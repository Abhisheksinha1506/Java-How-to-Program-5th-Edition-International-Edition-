// Exercise 7.10 Solution
// Test.java
// Driver for point, circle, cylinder program
import java.awt.Graphics;
import java.applet.Applet;

public class Test extends Applet {
   private Cylinder cylinder; 

   public void init()
   {
      cylinder = new Cylinder( 10, 3.3, 10, 10 ); 
   }

   public void paint( Graphics g )
   {   
      g.drawString( cylinder.getCPointName() + ": " +
                    cylinder.getCPointString(), 25, 25 );
   
      g.drawString( cylinder.getCircleName() + ": " + 
                    cylinder.getCircleString(), 25, 40 );
   
      g.drawString( cylinder.getName() + ": " +
                    cylinder.toString(), 25, 55 );

      int yPos = 85;      
      g.drawString( cylinder.getCPointName() +
                    ": " + cylinder.getCPointString(),
                     25, yPos );

      g.drawString( cylinder.getCircleName() +
                    ": " + cylinder.getCircleString(),
                     25, yPos += 15 );
      g.drawString( "Area = " + cylinder.getCircleArea(),
                     25, yPos += 15 );

      g.drawString( cylinder.getName() +
                    ": " + cylinder.toString(), 25, yPos += 15 );
      g.drawString( "Area = " + cylinder.area(), 25, yPos += 15 );
      g.drawString( "Volume = " + cylinder.volume(), 25, yPos += 15 );            
   }
}   
   
   
   
   
