// Exercise 9.20 Solution
// Pyramid.java
// This program draws a tetrahedron

import java.applet.Applet;
import java.awt.*;

public class Pyramid extends Applet {

   public void paint( Graphics g )
   {
      int basex[] = { 100, 200, 150, 50, 100 };
      int basey[] = { 100, 100, 130, 130, 100 };
      int x = 110, y = 40;

      g.setColor( Color.red );
      g.drawPolygon( basex, basey, 5 );

      for ( int i = 0; i < 4; i++ )
         g.drawLine( basex[ i ], basey[ i ], x, y );
   }
}
                    
