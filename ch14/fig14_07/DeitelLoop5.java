// Fig. 14.7: DeitelLoop5.java
// Load an array of images, loop through the array,
// and display each image. This version is customizeable.
//
// HTML parameter "sleeptime" is an integer indicating the
// number of milliseconds to sleep between images.
//
// HTML parameter "imagename" is the base name of the images
// that will be displayed (i.e., "deitel" is the base name
// for images "deitel0.gif," "deitel1.gif," etc.). The applet
// assumes that images are in an "images" subdirectory of
// the directory in which the applet resides.
//
// HTML parameter "totalimages" is an integer representing the
// total number of images in the animation. The applet assumes
// images are numbered from 0 to totalimages - 1.

import java.applet.Applet;
import java.awt.*;

public class DeitelLoop5 extends Applet implements Runnable {
   private Image images[];
   private int totalImages,       // total number of images
               currentImage = 0,  // current image subscript
               sleepTime;         // milliseconds to sleep
   private String imageName;  // base name of images

   // The next two objects are for double-buffering
   private Graphics gContext; // off-screen graphics context 
   private Image buffer;      // buffer in which to draw image

   private MediaTracker imageTracker;  // used to track images

   private Thread animate;      // animation thread
   private boolean suspended;   // toggle on/off

   private int width, height;

   // GUI Components to allow dynamic speed changing
   private Label sleepLabel;
   private TextField sleepDisplay;
   private Panel sleepStuff;

   // load the images when the applet begins executing
   public void init()
   {
      processHTMLParameters();

      if ( totalImages == 0 || imageName == null ) {
         showStatus( "Invalid parameters" );
         destroy();
      }

      images = new Image[ totalImages ];
      imageTracker = new MediaTracker( this );

      for ( int i = 0; i < images.length; i++ ) {
         images[ i ] = getImage( getDocumentBase(),
            "images/" + imageName + i + ".gif" );

         // track loading image
         imageTracker.addImage( images[ i ], i );
      }

      try {
         imageTracker.waitForID( 0 );
      }
      catch( InterruptedException e ) { }

      width = images[ 0 ].getWidth( this );      
      height = images[ 0 ].getHeight( this );
      resize( width, height + 30 );

      buffer = createImage( width, height ); 
      gContext = buffer.getGraphics(); 

      // set background of buffer to white
      gContext.setColor( Color.white );
      gContext.fillRect( 0, 0, 160, 80 );

      setLayout( new BorderLayout() );
      sleepLabel = new Label( "Sleep time" );
      sleepDisplay = new TextField( 5 );
      sleepDisplay.setText( String.valueOf( sleepTime ) );
      sleepStuff = new Panel();
      sleepStuff.add( sleepLabel );
      sleepStuff.add( sleepDisplay );
      add( "South", sleepStuff );
   }

   // start the applet
   public void start()
   {
      // always start with 1st image
      gContext.drawImage( images[ 0 ], 0, 0, this );
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
               images[ currentImage ], 0, 0, this );
   
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

   public boolean action( Event e, Object o )
   {
      try {
         int i = Integer.parseInt( o.toString() );
         sleepTime = i;
      }
      catch( NumberFormatException nfe ) {
         showStatus( "Sleep time must be an integer" );
      }

      return true;
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

   public void processHTMLParameters()
   {
      String parameter;

      parameter = getParameter( "sleeptime" );
      sleepTime = ( parameter == null ? 50 :
                    Integer.parseInt( parameter ) );

      imageName = getParameter( "imagename" );

      parameter = getParameter( "totalimages" );
      totalImages = ( parameter == null ? 0 :
                      Integer.parseInt( parameter ) );
   }
}
                                        
