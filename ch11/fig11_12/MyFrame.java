// Fig. 11.12: MyFrame.java
// Creating a Frame from an applet.
import java.applet.Applet;
import java.awt.*;

public class MyFrame extends Applet {
   private Frame f;
   private Font x;
   private String s;
   private Label l;
   private Button showFrame;
 
   public void init() 
   {
      String s2 = "Click here to see a Frame";

      s = "FRAME";
      x = new Font( "Courier", Font.BOLD, 36 );
      showFrame = new Button( s2 );
      add( showFrame );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == showFrame ) {

         if ( f != null ) {
            f.hide();     // hide frame
            f.dispose();  // free resources
         }

         // create frame
         f = new Frame( "A Frame!" );

         // create label
         l = new Label( s );
         l.setFont( x );
                              
         // change layout
         f.setLayout( new FlowLayout() );

         // add label to frame
         f.add( l );

         // size and show frame
         f.resize( 300, 100 );
         f.show();   // display frame
      }

      return true;
   }
}                    
