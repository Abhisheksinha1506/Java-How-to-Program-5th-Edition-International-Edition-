// Fig. 14.2: DeitelLoop.java
// Load an array of images, loop through the array,
// and display each image. 
import java.applet.Applet;
import java.awt.*;

public class DeitelLoop extends Applet {
   private Image deitel[];
   private int totalImages = 30,  // total number of images
               currentImage = 0,  // current image subscript
               sleepTime = 40;    // milliseconds to sleep

   // load the images when the applet begins executing
   public void init()
   {
      deitel = new Image[ totalImages ];

      for ( int i = 0; i < deitel.length; i++ )
         deitel[ i ] = getImage( getDocumentBase(),
            "images/deitel" + i + ".gif" );
   }

   // start the applet
   public void start()
   {
      currentImage = 0;  // always start with 1st image
   }

   // display the image in the Applet's Graphics context
   // then sleep and call repaint
   public void paint( Graphics g )
   {
      g.drawImage( deitel[ currentImage ], 1, 1, this );

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

      repaint();
   }
}
