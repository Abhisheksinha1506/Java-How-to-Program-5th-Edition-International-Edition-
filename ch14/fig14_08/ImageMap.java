// Fig. 14.8: ImageMap.java
// Demonstrating an image map.
import java.awt.*;
import java.applet.Applet;

public class ImageMap extends Applet {
   Image mapImage;
   MediaTracker trackImage;
   int width, height;

   public void init()
   {
      trackImage = new MediaTracker( this );
      mapImage = getImage( getDocumentBase(), "icons2.gif" );
      trackImage.addImage( mapImage, 0 );

      try {
         trackImage.waitForAll();
      }
      catch( InterruptedException e ) { }

      width = mapImage.getWidth( this );
      height = mapImage.getHeight( this );
      resize( width, height );
   }

   public void paint( Graphics g )
   {
      g.drawImage( mapImage, 0, 0, this );
   }

   public boolean mouseMove( Event e, int x, int y )
   {
      showStatus( translateLocation( x, y ) );
      return true;
   }

   public boolean mouseExit( Event e, int x, int y )
   {
      showStatus( "Pointer outside ImageMap applet" );
      return true;
   }

   public String translateLocation( int x, int y )
   {
      // determine width of each icon (there are 6)
      int iconWidth = width / 6;

      if ( x >= 0 && x <= iconWidth)
         return "Common Programming Error";
      else if ( x > iconWidth && x <= iconWidth * 2 )
         return "Good Programming Practice";
      else if ( x > iconWidth * 2 && x <= iconWidth * 3 )
         return "Performance Tip";
      else if ( x > iconWidth * 3 && x <= iconWidth * 4 )
         return "Portability Tip";
      else if ( x > iconWidth * 4 && x <= iconWidth * 5 )
         return "Software Engineering Observation";
      else if ( x > iconWidth * 5 && x <= iconWidth * 6 )
         return "Testing and Debugging Tip";

      return ""; 
   }
} 
