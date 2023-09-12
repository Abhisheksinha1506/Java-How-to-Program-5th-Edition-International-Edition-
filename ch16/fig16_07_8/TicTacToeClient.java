// Fig. 16.8: TicTacToeClient.java
// Client for the TicTacToe program
import java.applet.Applet;
import java.awt.*;
import java.net.*;
import java.io.*;

// Client class to let a user play Tic-Tac-Toe with
// another user across a network.
public class TicTacToeClient extends Applet
                             implements Runnable {
   TextField id;
   TextArea display;
   Panel boardPanel, panel2;
   Square board[][], currentSquare;
   Socket connection;
   DataInputStream input;
   DataOutputStream output;
   Thread outputThread;
   char myMark;

   // Set up user-interface and board
   public void init()
   {
      setLayout( new BorderLayout() );
      display = new TextArea( 4, 30 );
      display.setEditable( false );
      add( "South", display );

      boardPanel = new Panel();
      boardPanel.setLayout( new GridLayout( 3, 3, 0, 0 ) );
      board = new Square[ 3 ][ 3 ];

      for ( int row = 0; row < board.length; row++ )
         for ( int col = 0; col < board[ row ].length; col++ ) {
            board[ row ][ col ] = new Square();
            boardPanel.add( board[ row ][ col ] );
         }

      id = new TextField();
      id.setEditable( false );
      add( "North", id );

      panel2 = new Panel();
      panel2.add( boardPanel );
      add( "Center", panel2 );
   }

   // Make connection to server and get associated streams.
   // Start separate thread to allow this applet to
   // continually update its output in text area display.
   public void start()
   {
      try {
         connection =
            new Socket( InetAddress.getLocalHost(), 5000 );
         input = new DataInputStream(
            connection.getInputStream() );
         output = new DataOutputStream(
            connection.getOutputStream() );
      }
      catch ( IOException e ) {
         e.printStackTrace();         
      }

      outputThread = new Thread( this );
      outputThread.start();
   }

   // When user clicks mouse and releases in a square,
   // send an integer representing the clicked square
   // to the server. The integer is a number from 0 to 8
   // where the first row contains positions 0, 1 and 2,
   // the second row contains positions 3, 4 and 5 and
   // the third row contains positions 6, 7 and 8.
   public boolean mouseUp( Event e, int x, int y )
   {      
      for ( int row = 0; row < board.length; row++ ) {
         for ( int col = 0; col < board[ row ].length; col++ ) {
            try {
               if ( e.target == board[ row ][ col ] ) {
                  currentSquare = board[ row ][ col ];
                  output.writeInt( row * 3 + col );
               }
            }
            catch ( IOException ie ) {
               ie.printStackTrace();         
            }
         }
      }
      return true;
   }

   // Control thread that allows continuous update of the
   // text area display.
   public void run()
   {
      // First get player's mark (X or O)
      try {
         myMark = input.readChar();
         id.setText( "You are player \"" + myMark + "\"" );
      }
      catch ( IOException e ) {
         e.printStackTrace();         
      }

      // Receive messages sent to client
      while ( true ) {
         try {
            String s = input.readUTF();
            processMessage( s );
         }
         catch ( IOException e ) {
            e.printStackTrace();         
         }
      }
   }

   // Process messages sent to client
   public void processMessage( String s )
   {
      if ( s.equals( "Valid move." ) ) {
         display.appendText( "Valid move, please wait.\n" );
         currentSquare.setMark( myMark );
         currentSquare.repaint();
      }
      else if ( s.equals( "Invalid move, try again" ) ) {
         display.appendText( s + "\n" );
      }
      else if ( s.equals( "Opponent moved" ) ) {
         try {
            int loc = input.readInt();
   
            done:
            for ( int row = 0; row < board.length; row++ )
               for ( int col = 0;
                     col < board[ row ].length; col++ )
                  if ( row * 3 + col == loc ) {
                     board[ row ][ col ].setMark(
                        ( myMark == 'X' ? 'O' : 'X' ) );
                     board[ row ][ col ].repaint();
                     break done;
                  }

            display.appendText(
               "Opponent moved. Your turn.\n" );
         }
         catch ( IOException e ) {
            e.printStackTrace();         
         }
      }
      else {
         display.appendText( s + "\n" );
      }
   }
}

// Maintains one square on the board
class Square extends Canvas {
   char mark;

   public Square()
   {
      resize ( 30, 30 );
   }

   public void setMark( char c ) { mark = c; }

   public void paint( Graphics g )
   {
      g.drawRect( 0, 0, 29, 29 );
      g.drawString( String.valueOf( mark ), 11, 20 );
   }
}
