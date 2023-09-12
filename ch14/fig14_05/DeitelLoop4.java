// Fig. 14.5: DeitelLoop4.java
// Load an array of images, loop through the array,
// and display each image.
import java.applet.Applet;
import java.awt.*;

public class DeitelLoop4 extends Applet implements Runnable {
   private Image deitel[];
   private int totalImages = 30,  // total number of images
               currentImage = 0,  // current image subscript
               sleepTime = 40;    // milliseconds to sleep

   // The next two objects are for double-buffering
   private Graphics gContext; // off-screen graphics context 
   private Image buffer;      // buffer in which to draw image

   private MediaTracker imageTracker; // used to track images

   private Thread animate;      // animation thread
   private boolean suspended;   // toggle on/off

   // load the images when the applet begins executing
   public void init()
   {
      deitel = new Image[ totalImages ];
      buffer = createImage( 160, 80 ); // create image buffer
      gContext = buffer.getGraphics(); // get graphics context

      // set background of buffer to white
      gContext.setColor( Color.white );
      gContext.fillRect( 0, 0, 160, 80 );

      imageTracker = new MediaTracker( this );

      for ( int i = 0; i < deitel.length; i++ ) {
         deitel[ i ] = getImage( getDocumentBase(),
            "images/deitel" + i + ".gif" );

         // track loading image
         imageTracker.addImage( deitel[ i ], i );
      }

      try {
         imageTracker.waitForID( 0 );
      }
      catch( InterruptedException e ) { }
   }                                     

   // start the applet
   public void start()
   {
      // always start with 1st image
      gContext.drawImage( deitel[ 0 ], 0, 0, this );
      currentImage = 1;

      // create a new animation thread when user visits page
      if ( animate == null ) {
         animate = new Thread( this );
         animate.start();
      }
   }

   // terminate animation thread when user leaves page
   public void stop()
   {
      if ( animate != null ) {
         animate.stop();
         animate = null;
      }
   }

   // display the image in the Applet's Graphics context
   public void paint( Graphics g )
   {
      g.drawImage( buffer, 0, 0, this );
   }

   // override update to eliminate flicker
   public void update( Graphics g )
   {
      paint( g );
   }

   public void run()
   {
      while ( true ) {
         if ( imageTracker.checkID( currentImage, true ) ) {
            // clear previous image from buffer
            gContext.fillRect( 0, 0, 160, 80 );
          
            // draw new image in buffer
            gContext.drawImage(
               deitel[ currentImage ], 0, 0, this );
   
            currentImage = ++currentImage % totalImages;
         }
         else   // browser fix: help load images 
            postEvent(
               new Event( this, Event.MOUSE_ENTER, "" ) );

         try {
            Thread.sleep( sleepTime );
         }
         catch ( InterruptedException e ) {
            showStatus( e.toString() );
         }

         repaint();  // display buffered image
      }
   }

   public boolean mouseDown( Event e, int x, int y )
   {
      if ( suspended ) {
         animate.resume();
         suspended = false;
      }
      else {
         animate.suspend();
         suspended = true;
      }

      return true;
   }
}
                                        
