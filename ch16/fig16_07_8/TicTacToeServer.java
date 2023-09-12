// Fig. 16.7: TicTacToeServer.java
// This class maintains a game of Tic-Tac-Toe for two
// client applets.
import java.awt.*;
import java.net.*;
import java.io.*;

public class TicTacToeServer extends Frame {
   private byte board[];
   private boolean xMove;
   private TextArea output;
   private Player players[];
   private ServerSocket server;
   private int numberOfPlayers;
   private int currentPlayer;

   public TicTacToeServer()
   {
      super( "Tic-Tac-Toe Server" );
      board = new byte[ 9 ];
      xMove = true;
      players = new Player[ 2 ];
      currentPlayer = 0;
 
      // set up ServerSocket
      try {
         server = new ServerSocket( 5000, 2 );
      }
      catch( IOException e ) {
         e.printStackTrace();
         System.exit( 1 );
      }

      output = new TextArea();
      add( "Center", output );
      resize( 300, 300 );
      show();
   }

   // wait for two connections so game can be played
   public void execute()
   {
      for ( int i = 0; i < players.length; i++ ) {
         try {
            players[ i ] =
               new Player( server.accept(), this, i );
            players[ i ].start();
            ++numberOfPlayers;
         }
         catch( IOException e ) {
            e.printStackTrace();
            System.exit( 1 );
         }
      }
   }
   
   public int getNumberOfPlayers() { return numberOfPlayers; }

   public void display( String s )
   {
      output.appendText( s + "\n" );
   }
 
   // Determine if a move is valid.
   // This method is synchronized because only one move can be
   // made at a time.
   public synchronized boolean validMove( int loc, int player )
   {
      boolean moveDone = false;

      while ( player != currentPlayer ) {
         try {
            wait();
         }
         catch( InterruptedException e ) {
         }
      }

      if ( !isOccupied( loc ) ) {
         board[ loc ] =
            (byte)( currentPlayer == 0 ? 'X' : 'O' );
         currentPlayer = ++currentPlayer % 2;
         players[ currentPlayer ].otherPlayerMoved( loc );
         notify();    // tell waiting player to continue
         return true;
      }
      else 
         return false;
   }

   public boolean isOccupied( int loc )
   {
      if ( board[ loc ] == 'X' || board [ loc ] == 'O' )
          return true;
      else
          return false;
   }

   public boolean gameOver()
   {
      return false;
   }

   public boolean handleEvent( Event event )
   {
      if ( event.id == Event.WINDOW_DESTROY ) {
         hide();
         dispose();

         for ( int i = 0; i < players.length; i++ )
            players[ i ].stop();

         System.exit( 0 );
      }

      return super.handleEvent( event );
   }

   public static void main( String args[] )
   {
      TicTacToeServer game = new TicTacToeServer();

      game.execute();
   }
}

// Player class to manage each Player as a thread
class Player extends Thread {
   Socket connection;
   DataInputStream input;
   DataOutputStream output;
   TicTacToeServer control;
   int number;
   char mark;

   public Player( Socket s, TicTacToeServer t, int num )
   {
      mark = ( num == 0 ? 'X' : 'O' );

      connection = s;
      
      try {
         input = new DataInputStream(
                    connection.getInputStream() );
         output = new DataOutputStream(
                    connection.getOutputStream() );
      }
      catch( IOException e ) {
         e.printStackTrace();
         System.exit( 1 );
      }

      control = t;
      number = num;
   }

   public void otherPlayerMoved( int loc )
   {
      try {
         output.writeUTF( "Opponent moved" );
         output.writeInt( loc );
      }
      catch ( IOException e ) {}
   }

   public void run()
   {
      boolean done = false;

      try {
         control.display( "Player " +
            ( number == 0 ? 'X' : 'O' ) + " connected" );
         output.writeChar( mark );
         output.writeUTF( "Player " +
            ( number == 0 ? "X connected\n" :
                            "O connected, please wait\n" ) );

         // wait for another player to arrive
         if ( control.getNumberOfPlayers() < 2 ) {
            output.writeUTF( "Waiting for another player" );

            while (control.getNumberOfPlayers() < 2 )
               ; 

            output.writeUTF(
               "Other player connected. Your move." );
         }

         // Play game
         while ( !done ) {
            int location = input.readInt();

            if ( control.validMove( location, number ) ) {
               control.display( "loc: " + location );
               output.writeUTF( "Valid move." );
            }
            else 
               output.writeUTF( "Invalid move, try again" );

            if ( control.gameOver() )
               done = true;
         }         

         connection.close();
      }
      catch( IOException e ) {
         e.printStackTrace();
         System.exit( 1 );
      }
   }
}


