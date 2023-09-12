// Exercise 10.9 Solution
// Align.java
// This program creates a simple GUI
import java.applet.Applet;
import java.awt.*;

public class Align extends Applet {
   private Button ok, cancel, help; 
   private TextField xValue, yValue;
   private Checkbox snap, show;
   private Label xLabel, yLabel;
   private Panel checkPanel, buttonPanel,
                 fieldPanel1, fieldPanel2,
                 fieldPanel;

   public void init()
   {
      // build checkPanel
      snap = new Checkbox( "Snap to Grid" );
      show = new Checkbox( "Show Grid" );
      checkPanel = new Panel();
      checkPanel.setLayout( new GridLayout( 2 , 1 ) );
      checkPanel.add( snap );
      checkPanel.add( show );

      // build field panel1
      xLabel = new Label( "X: " );
      xValue = new TextField( "8", 3 );
      fieldPanel1 = new Panel();
      fieldPanel1.setLayout( new FlowLayout( FlowLayout.CENTER, 3, 5 ) );
      fieldPanel1.add( xLabel );
      fieldPanel1.add( xValue );

      yLabel = new Label( "Y: " );
      yValue = new TextField( "8", 3 );
      fieldPanel2 = new Panel();
      fieldPanel2.setLayout( new FlowLayout( FlowLayout.CENTER, 3, 5 ) );
      fieldPanel2.add( yLabel );
      fieldPanel2.add( yValue );

      fieldPanel = new Panel();
      fieldPanel.setLayout( new BorderLayout() );
      fieldPanel.add( "North", fieldPanel1 );
      fieldPanel.add( "South", fieldPanel2 );
      
      // build button panel
      ok = new Button( "Ok" );
      cancel = new Button( "Cancel" );
      help = new Button( "Help" );
      buttonPanel = new Panel();
      buttonPanel.setLayout( new GridLayout( 3, 1, 10, 5 ) );
      buttonPanel.add( ok );
      buttonPanel.add( cancel );
      buttonPanel.add( help );

      // set layout for applet
      setLayout( new FlowLayout( FlowLayout.CENTER, 10, 5 ) );
      add( checkPanel );
      add( fieldPanel );
      add( buttonPanel );
   }
}
