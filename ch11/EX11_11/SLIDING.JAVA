// Exercise 11.11 Solution
// Sliding.java
// Program allows the user to scroll through
// a range of values.

import java.applet.Applet;
import java.awt.*;

public class Sliding extends Applet {
   private Scrollbar slider;
   private TextField input;
   private Label valueLabel;
   private Panel p;
   private MyCanvas theCanvas;

   public void init()
   {
      slider = new Scrollbar( Scrollbar.HORIZONTAL, 50, 0, 0, 100 );
      input = new TextField( "50", 4 );
      valueLabel = new Label( "( 0 - 100 ):" );
      theCanvas = new MyCanvas( "50" );

      p = new Panel();
      p.setLayout( new BorderLayout() );
      p.add( "South", slider );
      p.add( "East", input );
      p.add( "West", valueLabel );

      setLayout( new BorderLayout() );
      add( "Center", theCanvas );
      add( "South", p );
   }

   public boolean handleEvent( Event e )
   {
      if ( e.target == slider ) {
         int t = slider.getValue();
         String s = String.valueOf( t );

         theCanvas.setValue( s );
         input.setText( s );
         theCanvas.repaint();
      }

      return super.handleEvent( e );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == input ) {
         String s = input.getText();
         int x = Integer.parseInt( s );

         if ( x >= 0 && x <= 100 ) {
            theCanvas.setValue( s );
            slider.setValue( x );
         }
         else
            input.setText( "" );

         theCanvas.repaint();
      }

      return true;
   }
}

class MyCanvas extends Canvas {
   private String value;
   private Font f;

   public MyCanvas( String v )
   {
      f = new Font( "Helvetica", Font.BOLD, 72 );
      setValue( v );
      resize( 100, 100 );
   }

   public void setValue( String s )   { value = s; }

   public void paint( Graphics g )
   {
      g.setFont( f );
      g.drawString( value, 0, 70 );
   }
}
