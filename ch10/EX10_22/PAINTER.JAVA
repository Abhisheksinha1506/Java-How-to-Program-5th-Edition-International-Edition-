// Exercise 10.22 Solution
// Painter.java
// Paint program

import java.applet.Applet;
import java.awt.*;

public class Painter extends Applet {
   private int xValue, yValue;
   private boolean firstTime;
   private Button redButton;
   private Button blackButton;
   private Button magentaButton;
   private Button blueButton;
   private Button greenButton;
   private Button yellowButton;
   private Color drawColor;
   private Panel p;

   public void init()
   {
      // first running of program
      firstTime = true;

      drawColor = Color.black;
      setLayout( new BorderLayout() );
      redButton = new Button( "Red" );
      blackButton = new Button( "Black" );
      magentaButton = new Button( "Magenta" );
      blueButton = new Button( "Blue" );
      greenButton = new Button( "Green" );
      yellowButton = new Button( "Yellow" );

      p = new Panel();

      p.add( redButton );
      p.add( blackButton );
      p.add( magentaButton );
      p.add( blueButton );
      p.add( greenButton );
      p.add( yellowButton );

      add( "South", p );
   }

   public void paint( Graphics g )
   {
      g.setColor( drawColor );

      // do not draw the first time
      if ( !firstTime )
         g.fillOval( xValue, yValue, 4, 4 );
   }

   // override Component class update
   public void update( Graphics g )
   {
      // do not clear background
      // only call paint
      paint( g );  
   }                
       
   public boolean mouseDrag( Event e, int x, int y )
   {
      xValue = x; 
      yValue = y;

      // enable drawing
      firstTime = false;

      repaint();     // call repaint
      return true;   
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target instanceof Button ) {

         if ( e.target == redButton ) {
            drawColor = Color.red;
            showStatus( "Red" );
         }
         else if ( e.target == blueButton ) {
            drawColor = Color.blue;
            showStatus( "Blue" );
         }
         else if ( e.target == yellowButton ) {
            drawColor = Color.yellow;
            showStatus( "Yellow" );
         }
         else if ( e.target == magentaButton ) {
            drawColor = Color.magenta;
            showStatus( "Magenta" );
         }
         else if ( e.target == greenButton ) {
            drawColor = Color.green;
            showStatus( "Green" );
         }
         else {
            drawColor = Color.black;
            showStatus( "Black" );
         }
      }

      return true;
   }
}
