// Fig. 3.19: LogicalOperators.java
// Demonstrating the logical operators
import java.awt.Graphics;
import java.applet.Applet;

public class LogicalOperators extends Applet {
   public void paint( Graphics g )
   {
      g.drawString( "Logical AND (&&)", 10, 25 );
      g.drawString( "F && F: " + ( false && false ), 10, 40 );
      g.drawString( "F && T: " + ( false && true ), 10, 55 );
      g.drawString( "T && F: " + ( true && false ), 10, 70 );
      g.drawString( "T && T: " + ( true && true ), 10, 85 );

      g.drawString( "Logical OR (||)", 215, 25 );
      g.drawString( "F || F: " + ( false || false ), 215, 40 );
      g.drawString( "F || T: " + ( false || true ), 215, 55 );
      g.drawString( "T || F: " + ( true || false ), 215, 70 );
      g.drawString( "T || T: " + ( true || true ), 215, 85 );

      g.drawString( "Boolean logical AND (&)", 10, 115 );
      g.drawString( "F & F: " + ( false & false ), 10, 130 );
      g.drawString( "F & T: " + ( false & true ), 10, 145 );
      g.drawString( "T & F: " + ( true & false ), 10, 160 );
      g.drawString( "T & T: " + ( true & true ), 10, 175 );

      g.drawString( "Boolean logical inclusive OR (|)",
                    215, 115 );
      g.drawString( "F | F: " + ( false | false ), 215, 130 );
      g.drawString( "F | T: " + ( false | true ), 215, 145 );
      g.drawString( "T | F: " + ( true | false ), 215, 160 );
      g.drawString( "T | T: " + ( true | true ), 215, 175 );

      g.drawString( "Boolean logical exclusive OR (^)",
                    10, 205 );
      g.drawString( "F ^ F: " + ( false ^ false ), 10, 220 );
      g.drawString( "F ^ T: " + ( false ^ true ), 10, 235 );
      g.drawString( "T ^ F: " + ( true ^ false ), 10, 250 );
      g.drawString( "T ^ T: " + ( true ^ true ), 10, 265 );

      g.drawString( "Logical NOT (!)",
                    215, 205 );
      g.drawString( "!F: " + ( !false ), 215, 220 );
      g.drawString( "!T: " + ( !true ), 215, 235 );
   }
}
