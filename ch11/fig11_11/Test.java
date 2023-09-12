// Fig. 11.11: Test.java
// Creating a custom component.
import java.applet.Applet;
import java.awt.*;

public class Test extends Applet {
   private LabelTextField customComponent;
   private Button button1;

   public void init()
   {
      customComponent = new LabelTextField( "label text" );
      button1 = new Button( "Button" );

      add( button1 );
      add( customComponent );
   }

   // button event is handled here
   public boolean action( Event e, Object o )
   {
      String s = "Textfield text: ";
      showStatus( s + customComponent.getFieldText() );
      return true;
   }
}

class LabelTextField extends Panel {
   private Label theLabel;
   private TextField theTextField;

   public LabelTextField( String s )
   {
      setLayout( new BorderLayout() );
      theLabel = new Label( s );
      theTextField = new TextField( 10 );

      add( "North", theLabel );
      add( "South", theTextField );
   }

   // handles its own textfield event
   public boolean action( Event e, Object o )
   {
      setLabelText( e.arg.toString() );
      return true;
   }

   // setLabelText is programmer-defined
   public void setLabelText( String s )
   {  
      theLabel.setText( s );  
   }
 
   // getFieldText is programmer-defined
   public String getFieldText()
   {  
      return theTextField.getText();  
   }
}
