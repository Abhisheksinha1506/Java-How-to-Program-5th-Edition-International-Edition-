// Exercise 14.58 Solution
// Flash3.java
// Program highlights an image.

import java.applet.Applet;
import java.awt.*;

public class Flash3 extends Applet {
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

      int width = image1.getWidth( this ) + 20;
      int height = image1.getHeight( this ) + 20;
      Image image2 = createImage( width, height );
      Image image3 = createImage( width, height );

      theCanvas = new MyCanvas( image1, image2, image3, width, height );
      add( theCanvas );
   }
}

class MyCanvas extends Canvas implements Runnable {
   private Image img;
   private Image img2;
   private Image img3;
   private Graphics graph2;
   private Graphics graph3;      
   private boolean flashSwitch;
   private Thread canvasThread;

   public MyCanvas( Image i, Image i2, Image i3, int w, int h )
   {      
      canvasThread = new Thread( this );
      canvasThread.start();
      flashSwitch = true;     
      resize( w, h );      
      img = i;
      img2 = i2;
      img3 = i3;
      createBuffers( w, h );
   }

   public void createBuffers( int w, int h )
   {
      graph2 = img2.getGraphics();
      graph3 = img3.getGraphics();

      graph2.setColor( Color.black );
      graph2.fillRect( 0, 0, w, h );
      graph3.setColor( Color.black );
      graph3.fillRect( 0, 0, w, h );

      int count = 0;

      for ( int x = 0; x < w; x += 10 ) {
         for ( int y = 0; y < h; y += 10 ) {

            // Change ++count to y to get the effect of
            // all the lights "turning off" then "turning on"
            // Also the line below that alternates the lights
            // should be commented out or removed.
            if ( ++count % 2 == 0 ) {               
               graph2.setColor( Color.yellow );
               graph3.setColor( Color.white );
            }
            else {
               graph2.setColor( Color.white );
               graph3.setColor( Color.yellow );               
            }

            graph2.fillOval( x, y, 10, 10 );
            graph3.fillOval( x, y, 10, 10 );          
         }

         // Allow the lights to alternate
         count = ( count % 2 == 0 ? 1 : 0 );
      }

      graph2.drawImage( img, 10, 10, this );
      graph3.drawImage( img, 10, 10, this );
   }

   public void paint( Graphics g )
   {
      if ( flashSwitch )
         g.drawImage( img2, 0, 0, this );
      else
         g.drawImage( img3, 0, 0, this );
   }

   public void update( Graphics g ) { paint( g ); }

   public void run()
   {
      while ( true ) {         
         repaint();

         try {
            Thread.sleep( 300 );
         } catch ( Exception e ) {
            System.err.println( "Exception: " + e.toString() );
         }

         flashSwitch = !flashSwitch;
      }
   }
}
