// Fig. 14.3: DeitelLoop2.java
// Load an array of images, loop through the array,
// and display each image.
import java.applet.Applet;
import java.awt.*;

public class DeitelLoop2 extends Applet {
   private Image deitel[];
   private int totalImages = 30,  // total number of images
               currentImage = 0,  // current image subscript
               sleepTime = 40;    // milliseconds to sleep

   // The next two objects are for double-buffering
   private Graphics gContext; // off-screen graphics context 
   private Image buffer;      // buffer in which to draw image

   // load the images when the applet begins executing
   public void init()
   {
      deitel = new Image[ totalImages ];
      buffer = createImage( 160, 80 ); // create image buffer
      gContext = buffer.getGraphics(); // get graphics context

      // set background of buffer to white
      gContext.setColor( Color.white );
      gContext.fillRect( 0, 0, 160, 80 );

      for ( int i = 0; i < deitel.length; i++ )
         deitel[ i ] = getImage( getDocumentBase(),
            "images/deitel" + i + ".gif" );
   }

   // start the applet
   public void start()
   {
      // always start with 1st image
      gContext.drawImage( deitel[ 0 ], 0, 0, this );
      currentImage = 1;  
   }

   // display the image in the Applet's Graphics context
   public void paint( Graphics g )
   {
      g.drawImage( buffer, 0, 0, this );

      // clear previous image from buffer
      gContext.fillRect( 0, 0, 160, 80 );

      // draw new image in buffer
      gContext.drawImage( deitel[ currentImage ], 0, 0, this );

      // fix to help load images in Netscape Navigator
      // makes browser "think" there is a mouse event
      postEvent( new Event( this, Event.MOUSE_ENTER, "" ) );

      currentImage = ++currentImage % totalImages;

      try {
         Thread.sleep( sleepTime );
      }
      catch ( InterruptedException e ) {
         showStatus( e.toString() );
      }

      repaint();  // display buffered image
   }
}
                                        
