// Fig. 7.10: Test.java
// Driver for point, circle, cylinder hierarchy
import java.awt.Graphics;
import java.applet.Applet;

public class Test extends Applet {
   private Point point;          
   private Circle circle;  
   private Cylinder cylinder; 
   private Shape arrayOfShapes[];

   public void init()
   {
      point = new Point( 7, 11 );          
      circle = new Circle( 3.5, 22, 8 );  
      cylinder = new Cylinder( 10, 3.3, 10, 10 ); 

      arrayOfShapes = new Shape[ 3 ];

      // aim arrayOfShapes[0] at subclass Point object
      // aim arrayOfShapes[1] at subclass Circle object
      // aim arrayOfShapes[2] at subclass Cylinder object
      arrayOfShapes[ 0 ] = point;
      arrayOfShapes[ 1 ] = circle;
      arrayOfShapes[ 2 ] = cylinder;  
   }

   public void paint( Graphics g )
   {   
      g.drawString( point.getName() + ": " +
                    point.toString(), 25, 25 );
   
      g.drawString( circle.getName() + ": " + 
                    circle.toString(), 25, 40 );
   
      g.drawString( cylinder.getName() + ": " +
                    cylinder.toString(), 25, 55 );

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
   
   
   
   
