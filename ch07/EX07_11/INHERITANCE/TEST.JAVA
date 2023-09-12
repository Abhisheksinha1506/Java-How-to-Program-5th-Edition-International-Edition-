// Exercies 7.11 Solution
// Test.java
// Driver for point, square, cube hierarchy
import java.awt.Graphics;
import java.applet.Applet;

public class Test extends Applet {
   private Point point;          
   private Square square;  
   private Cube cube; 
   private Shape arrayOfShapes[];

   public void init()
   {
      point = new Point( 7, 11 );          
      square = new Square( 3.5, 22, 8 );  
      cube = new Cube( 3.3, 10, 10 ); 

      arrayOfShapes = new Shape[ 3 ];

      arrayOfShapes[ 0 ] = point;
      arrayOfShapes[ 1 ] = square;
      arrayOfShapes[ 2 ] = cube;  
   }

   public void paint( Graphics g )
   {   
      g.drawString( point.getName() + ": " +
                    point.toString(), 25, 25 );
   
      g.drawString( square.getName() + ": " + 
                    square.toString(), 25, 40 );
   
      g.drawString( cube.getName() + ": " +
                    cube.toString(), 25, 55 );

      int yPos = 85;
      
      // Loop through arrayOfShapes and print the name,
      // area, and volume of each object.
      for ( int i = 0; i < 3; i++ ) {
         g.drawString( arrayOfShapes[ i ].getName() +
            ": " + arrayOfShapes[ i ].toString(),
            25, yPos );
         yPos += 15;
         g.drawString( "Area = " + 
            arrayOfShapes[ i ].area(), 25, yPos );
         yPos += 15;
         g.drawString( "Volume = " +
            arrayOfShapes[ i ].volume(), 25, yPos );
         yPos += 30;
      }
   }
}   
   
   
   
   
