// Fig. 14.1: LoadImageAndScale.java
// Load an image and display it in its original size
// and scale it to twice its original width and height.
import java.applet.Applet;
import java.awt.*;

public class LoadImageAndScale extends Applet {
   private Image deitel;  

   // load the image when the applet begins executing
   public void init()
   {
      deitel = getImage( getDocumentBase(),
                         "deitel0.gif" );
   }

   // display the image
   public void paint( Graphics g )
   {
      // draw the original image
      g.drawImage( deitel, 1, 1, this );

      // draw the image with its width and height doubled
      int width = deitel.getWidth( this );
      int height = deitel.getHeight( this );
      g.drawImage( deitel, 1, 90, width * 2,
                   height * 2, this );
   }
}
