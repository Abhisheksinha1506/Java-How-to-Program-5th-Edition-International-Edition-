// Exercise 5.38 Solution
// Maze.java
// Program traverses a maze

import java.io.IOException;
import java.applet.Applet;
import java.awt.*;

public class Maze extends Applet {  
   final int RIGHT = 1, LEFT = 3, UP = 2, DOWN = 0;
   final int X_START = 2, Y_START = 0;
   int flag;

   char m[][] =
        { { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
          { '#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#' },
          { '.', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#' },
          { '#', '#', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#' },
          { '#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '.' },
          { '#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '.', '#' },
          { '#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#' },
          { '#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#' },
          { '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#' },
          { '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#' },
          { '#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#' },
          { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' } };

   public void init() 
   {
      flag = 0;
      mazeTraversal( m, X_START, Y_START, RIGHT );
   }

   public void mazeTraversal( char m2[][], int x, int y, int direction ) 
   {
      m2[ x ][ y ] = 'x';

      repaint();

      if ( xyAreEdge( x, y ) && x != X_START && y != Y_START ) {
         showStatus( "Maze sucessfully exited!" );
         return;  
      }
      else if ( x == X_START && y == Y_START && flag == 1 ) {
         showStatus( "Arrived back at starting location." );
         return;
      }
      else {
         flag = 1;

         for ( int move = direction, count = 0; count < 4; ++count, ++move, move %= 4 )
            switch ( move ) {
               case DOWN:
                  if ( validMove( x + 1, y ) ) {   // move down
                     mazeTraversal( m2, x + 1, y, LEFT );
                     return;
                  }
                  break;
               case RIGHT:
                  if ( validMove( x, y + 1 ) ) {   // move right
                     mazeTraversal( m2, x, y + 1, DOWN );
                     return;
                  }
                  break;
               case UP:
                  if ( validMove( x - 1, y ) ) {   // move up
                     mazeTraversal( m2, x - 1, y, RIGHT );
                     return;
                  }
                  break;
               case LEFT:
                  if ( validMove( x, y - 1 ) ) {  // move left
                     mazeTraversal( m2, x, y - 1, UP );
                     return;
                  }
            }
      }

   }

   public boolean validMove( int r, int c )
   {
      return ( r >= 0 && r <= 11 && c >= 0 && c <= 11 && m[ r ][ c ] != '#' );
   }             

   public boolean xyAreEdge( int x1, int y1 )
   {
      if ( ( x1 == 0 || x1 == 11 ) && ( y1 >= 0 && y1 <= 11 ) )
         return true;
      else if ( ( y1 == 0 || y1 == 11 ) && ( x1 >= 0 && x1 <= 11 ) )
         return true;
      else
         return false;
   }

   public void paint( Graphics g )
   {
      int x = 5, y = 30;      

      for ( int r = 0; r < m.length; r++ ) {         

         for ( int c = 0; c < m[ r ].length; c++ ) 
            g.drawString( String.valueOf( m[ r ][ c ] ), x += 20, y );
         
         y += 10;
         x = 5;
      }
   }
}
