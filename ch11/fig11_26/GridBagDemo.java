// Fig. 11.26: GridBagDemo.java
// Demonstrating GridBagLayout.
import java.applet.Applet;
import java.awt.*;

public class GridBagDemo extends Applet { 
   private Canvas c;
   private Choice cb;
   private TextArea ta;
   private TextField tf;
   private Button b1, b2, b3;
   private GridBagLayout gbLayout;
   private GridBagConstraints gbConstraints; 
    
   public void init()
   {
      gbLayout = new GridBagLayout();
      setLayout( gbLayout );   // applet

      // instantiate gridbag constraints
      gbConstraints = new GridBagConstraints();

      ta = new TextArea( "Text Area", 5, 10 );
      cb = new Choice( );
      cb.addItem( "Linden" );
      cb.addItem( "Birch" );
      cb.addItem( "Ceder" );
      tf = new TextField( "TextField" );
      b1 = new Button( "Button 1" );
      b2 = new Button( "Button 2" );
      b3 = new Button( "Button 3" );
      c = new Canvas();
      c.setBackground( Color.blue );
      c.resize( 10, 5 );

      // text area
      // weightx and weighty are both 0: the default
      // anchor for all components is CENTER: the default
      gbConstraints.fill = GridBagConstraints.BOTH;
      addComponent( ta, gbLayout, gbConstraints, 0, 0, 1, 3 );    
       
      // button b1
      // weightx and weighty are both 0: the default
      gbConstraints.fill = GridBagConstraints.HORIZONTAL;
      addComponent( b1, gbLayout, gbConstraints, 0, 1, 2, 1 );
      
      // choice button
      // weightx and weighty are both 0: the default
      // fill is HORIZONTAL
      addComponent( cb, gbLayout, gbConstraints, 2, 1, 2, 1 );             

      // button b2
      gbConstraints.weightx = 1000;  // can grow taller
      gbConstraints.weighty = 1;     // can grow wider
      gbConstraints.fill = GridBagConstraints.BOTH;
      addComponent( b2, gbLayout, gbConstraints, 1, 1, 1, 1 );
       
      // button b3
      // fill is BOTH
      gbConstraints.weightx = 0;
      gbConstraints.weighty = 0;    
      addComponent( b3, gbLayout, gbConstraints, 1, 2, 1, 1 );
       
      // textfield
      // weightx and weighty are both 0: fill is BOTH
      addComponent( tf, gbLayout, gbConstraints, 3, 0, 2, 1 );

      // canvas
      // weightx and weighty are both 0: fill is BOTH
      addComponent( c, gbLayout, gbConstraints, 3, 2, 1, 1 );    
   }

   // addComponent is programmer defined
   private void addComponent( Component c, GridBagLayout g,
                              GridBagConstraints gc, int row,
                              int column, int width, int height )
   {
      // set gridx and gridy 
      gc.gridx = column;
      gc.gridy = row;

      // set gridwidth and gridheight
      gc.gridwidth = width;   
      gc.gridheight = height;
       
      g.setConstraints( c, gc );  // set constraints
      add( c );      // add component to applet
   }
}
