// Exercise 14.62 Solution
// Zoom.java
// Program zooms an image.

import java.applet.Applet;
import java.awt.*;

public class Zoom extends Applet {
   private MyCanvas theCanvas;
   private Panel p;
   private Choice select;
   private int width, height;

   public void init()
   {
      MediaTracker tracker = new MediaTracker( this );
      Image image1 = getImage( getDocumentBase(), "icons2.gif" );
      tracker.addImage( image1, 0 );

      try {
         tracker.waitForID( 0 );
      } catch( Exception e ) {
         System.err.println( "Exception: " + e.toString() );
      }

      p = new Panel();
      setLayout( new BorderLayout() );
      select = new Choice();
      select.addItem( "100%" );
      select.addItem( "200%" );
      select.addItem( "300%" );
      p.add( select );

      width = image1.getWidth( this ) / 2;
      height = image1.getHeight( this ) / 2;

      theCanvas = new MyCanvas( image1, width, height );
      add( "Center", theCanvas );
      add( "South", p );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == select ) {

         if ( o.equals( "100%" ) )
            theCanvas.setWidthHeight( width, height );
         else if ( o.equals( "200%" ) )
            theCanvas.setWidthHeight( width * 2, height * 2 );
         else  // 300%
            theCanvas.setWidthHeight( width * 3, height * 3 );
      }

      return true;
   }
}

class MyCanvas extends Canvas {
   private Image img;
   private int imgWidth;
   private int imgHeight;

   public MyCanvas( Image i, int w, int h )
   {
      setBackground( Color.green );
      resize( w, h );      
      img = i;
      setWidthHeight( w, h );
   }

   public void setWidthHeight( int w, int h )
   {
      imgWidth = w;
      imgHeight = h;
      repaint();
   }

   public void paint( Graphics g )
      { g.drawImage( img, 0, 0, imgWidth, imgHeight, this ); }
}
