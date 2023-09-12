// Exercise 4.43 Solution
// Points.java
// Program calculates the distance
// between two points

import java.applet.Applet;
import java.awt.*;

public class Points extends Applet {
   TextField x1Input, x2Input, y1Input, y2Input;
   Label labelX1, labelX2, labelY1, labelY2;
   double theDistance;
   boolean enabled;

   public void init()
   {
      x1Input = new TextField( 4 );
      x2Input = new TextField( 4 );
      y1Input = new TextField( 4 );
      y2Input = new TextField( 4 );
      labelX1 = new Label( "Enter X1: " );
      labelY1 = new Label( "Enter Y1: " );
      labelX2 = new Label( "Enter X2: " );
      labelY2 = new Label( "Enter Y2: " );
      add( labelX1 );
      add( x1Input );
      add( labelY1 );
      add( y1Input );
      add( labelX2 );
      add( x2Input );
      add( labelY2 );
      add( y2Input );
   }

   public void paint( Graphics g )
   {
      if ( enabled == true ) 
         g.drawString( "Distance is " +
                       String.valueOf( theDistance ), 5, 170 );     
   }

   public boolean action( Event e, Object o )
   {
      enabled = false;

      if ( e.target == y2Input ) {
         double tempX1, tempX2, tempY1, tempY2;

         Double x = new Double( x1Input.getText() );
         tempX1 = x.doubleValue();

         Double y = new Double( y1Input.getText() );
         tempY1 = y.doubleValue();

         Double x2 = new Double( x2Input.getText() );
         tempX2 = x2.doubleValue();

         Double y2 = new Double( y2Input.getText() );
         tempY2 = y2.doubleValue();

         theDistance = distance( tempX1, tempY1, tempX2, tempY2 );
      }

      repaint();
      return true;
   }

   public double distance( double x1, double y1, double x2, double y2 )
   {
      double d;

      enabled = true;
      d = Math.sqrt( Math.pow( ( x1 - x2 ), 2 ) +
                     Math.pow( ( y1 - y2 ), 2 ) );

      return d;
   }
}
