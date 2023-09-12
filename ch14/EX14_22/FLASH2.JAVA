// Exercise 14.22 Solution
// Flash2.java
// Program flashes text.

import java.applet.Applet;
import java.awt.*;

public class Flash2 extends Applet {
   private MyCanvas theCanvas;

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

      int width = image1.getWidth( this );
      int height = image1.getHeight( this );
      Image image2 = createImage( width,
                                  height );

      theCanvas = new MyCanvas( image1, image2, width, height );
      add( theCanvas );
   }
}

class MyCanvas extends Canvas implements Runnable {
   private Image img;
   private Image img2;
   private Graphics graph;
   private Graphics graph2;      
   private boolean flashSwitch;
   private Thread canvasThread;

   public MyCanvas( Image i, Image i2, int w, int h )
   {      
      canvasThread = new Thread( this );
      canvasThread.start();
      flashSwitch = true;     
      resize( w, h );
      img = i;
      img2 = i2;
   }

   public void paint( Graphics g )
   {
      if ( flashSwitch )
         g.drawImage( img, 0, 0, this );
      else
         g.drawImage( img2, 0, 0, this );
   }

   public void run()
   {
      while ( true ) {         
         repaint();

         try {
            Thread.sleep( 140 );
         } catch ( Exception e ) {
            System.err.println( "Exception: " + e.toString() );
         }

         flashSwitch = !flashSwitch;
      }
   }
}
