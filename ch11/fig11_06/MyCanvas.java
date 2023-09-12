// Fig. 11.6: MyCanvas.java
// Extending the Canvas class.
import java.applet.Applet;
import java.awt.*;

class NewCanvas extends Canvas {
   private int shape;

   public void paint( Graphics g )
   {
      if ( shape == 1 )
        g.fillOval( 50, 10, 60, 60 );
      else  // shape == 2
        g.fillRect( 50, 10, 60, 60 );
   }

   public void setShape( int s )
   {
      shape = s;
      repaint();
   }
}

public class MyCanvas extends Applet {
   private Panel p;
   private NewCanvas c;
   private Button circleButton, squareButton;

   public void init()
   {
      p = new Panel();
      c = new NewCanvas();   // instantiate canvas

      c.resize( 185, 125 );  // resize canvas

      squareButton = new Button( "Square" );
      circleButton = new Button( "Circle" );

      p.setLayout( new BorderLayout() );
      p.add( "North", circleButton );
      p.add( "South", squareButton );

      setLayout( new BorderLayout() );
      add( "West", p );  
      add( "East", c );    // add canvas
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == circleButton )
         c.setShape( 1 );
      else   // squareButton
         c.setShape( 2 );

      return true;
   }
}
