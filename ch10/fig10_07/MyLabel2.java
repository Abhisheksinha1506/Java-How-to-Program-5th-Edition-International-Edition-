// Fig. 10.7: MyLabel2.java
// Demonstrating Label class getText and setText methods.
import java.applet.Applet;
import java.awt.*;

public class MyLabel2 extends Applet {
   private Font f;
   private Label noLabel;
    
   public void init()
   {   
      f = new Font( "Courier", Font.BOLD, 14 );

      // call label constructor with no text
      noLabel = new Label();

      // set text in noLabel
      noLabel.setText( "new text!" );

      // set font for noLabel
      noLabel.setFont( f );

      // add label component
      add( noLabel );
   }

   public void paint( Graphics g )
   {
      // get noLabel's text
      showStatus( "Label is displaying: " + noLabel.getText() );
   }
}
