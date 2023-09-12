// Fig. 11.10: Scroll.java
// Using Scrollbars to size an oval.
import java.applet.Applet;
import java.awt.*;

public class Scroll extends Applet {
   private Scrollbar upDown, leftRight;
   private MyCanvas theCanvas;
   private Panel thePanel;

   public void init() 
   {
      // create scrollbars
      upDown = new Scrollbar( Scrollbar.VERTICAL, 100,
                              0, 0, 200 );

      leftRight = new Scrollbar( Scrollbar.HORIZONTAL, 100,
                                 0, 0, 200 );

      // create canvas
      theCanvas = new MyCanvas();
      theCanvas.resize( 200, 200 );
      theCanvas.setBackground( Color.yellow );

      thePanel = new Panel();  // create panel

      // set layouts
      setLayout( new BorderLayout() );
      thePanel.setLayout( new BorderLayout() );

      // layout components
      add( "West", upDown );
      thePanel.add( "South", leftRight );
      thePanel.add( "Center", theCanvas );
      add( "Center", thePanel );
   }

   public boolean handleEvent( Event e )
   {
      if ( e.target instanceof Scrollbar ) {

         if ( e.target == upDown )
            theCanvas.setHeight( upDown.getValue() );
         else  // leftRight
            theCanvas.setWidth( leftRight.getValue() );

         showStatus( "e.arg is " + String.valueOf( e.arg ) );
         theCanvas.repaint();   // repaint canvas
         return true;
      }

      // not one of our scroll bars
      // do the default handling ( base class )
      return super.handleEvent( e );
   }
}

class MyCanvas extends Canvas {
    private int width, height;

    public MyCanvas()
    {
       setWidth( 100 );
       setHeight( 100 );
    }

    public void setWidth( int w )
    {   width = w;   }

    public void setHeight( int h )
    {   height = h;  }

    public void paint( Graphics g )
    {
       g.setColor( Color.black );
       g.drawOval( 0, 0, width, height );
    }
}
