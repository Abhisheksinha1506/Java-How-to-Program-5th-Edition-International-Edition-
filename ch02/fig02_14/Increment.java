// Fig. 2.14: Increment.java
// Preincrementing and postincrementing
import java.awt.Graphics;
import java.applet.Applet;

public class Increment extends Applet {
   public void paint( Graphics g ) 
   {
      int c;

      c = 5;
      g.drawString( Integer.toString( c ), 25, 25 );
      g.drawString( Integer.toString( c++ ), 25, 40 ); // postincrement
      g.drawString( Integer.toString( c ), 25, 55 );

      c = 5;
      g.drawString( Integer.toString( c ), 25, 85 );
      g.drawString( Integer.toString( ++c ), 25, 100 ); // preincrement
      g.drawString( Integer.toString( c ), 25, 115 );
   }
}

