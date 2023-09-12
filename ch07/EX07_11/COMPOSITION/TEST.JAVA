// Exercise 7.11 Solution
// Test.java
// Driver for point, square, cube composition program
import java.awt.Graphics;
import java.applet.Applet;

public class Test extends Applet {
   private Cube cube; 

   public void init()
      { cube = new Cube( 3.3, 10, 10 ); }

   public void paint( Graphics g )
   {   
      g.drawString( cube.getSPointName() + ": " +
                    cube.getSPointString(), 25, 25 );
   
      g.drawString( cube.getSquareName() + ": " + 
                    cube.getSquareString(), 25, 40 );
   
      g.drawString( cube.getName() + ": " +
                    cube.toString(), 25, 55 );

      int yPos = 85;      
      g.drawString( cube.getSPointName() +
                    ": " + cube.getSPointString(),
                     25, yPos );

      g.drawString( cube.getSquareName() +
                    ": " + cube.getSquareString(),
                     25, yPos += 15 );
      g.drawString( "Area = " + cube.getSquareArea(),
                     25, yPos += 15 );

      g.drawString( cube.getName() +
                    ": " + cube.toString(), 25, yPos += 15 );
      g.drawString( "Area = " + cube.area(), 25, yPos += 15 );
      g.drawString( "Volume = " + cube.volume(), 25, yPos += 15 );            
   }
}   
   
   
   
   
