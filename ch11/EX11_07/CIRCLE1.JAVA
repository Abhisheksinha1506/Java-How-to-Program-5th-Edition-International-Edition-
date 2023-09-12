// Exercise 11.7 Solution
// Circle1.java
// Program draws a circle of a random
// diameter and displays the area, diameter,
// and circumference.

import java.applet.Applet;
import java.awt.*;

public class Circle1 extends Applet {
   private CircleCanvas theCanvas;
   private TextArea display;

   public void init()
   {
      theCanvas = new CircleCanvas();
      display = new TextArea( 5, 30 );

      display.setText( "The Radius is: " + theCanvas.getRadius() +
                       "\nThe Diameter is: " + theCanvas.getDiameter()
                       + "\nThe Area is: " + theCanvas.getArea() +
                       "\nThe Circumference is: " +
                       theCanvas.getCircumference() );

      setLayout( new BorderLayout() );
      add( "Center", theCanvas );
      add( "South", display );
   }
}

class CircleCanvas extends Canvas {
   private int radius;

   public CircleCanvas()
   {
      radius = ( int )( 1 + Math.random() * 100 );
      resize( 100, 100 );
   }

   public void paint( Graphics g )
   {  g.drawOval( 0, 0, radius, radius );  }

   public int getDiameter()  {  return ( 2 * radius );  }

   public int getCircumference()
   {  return ( int )( 2 * Math.PI * radius );  }

   public int getArea()
   {  return ( int )( radius * radius * Math.PI );  }

   public int getRadius()  {  return radius;  }
}
