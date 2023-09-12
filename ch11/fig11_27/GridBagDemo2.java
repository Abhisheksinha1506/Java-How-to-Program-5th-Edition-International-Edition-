// Fig. 11.27: GridBagDemo2.java
// Demonstrating GridBagLayout constants.
import java.applet.Applet;
import java.awt.*;

public class GridBagDemo2 extends Applet { 
   private Choice cb;
   private TextField tf;
   private List m;
   private Button b1, b2, b3, b4;
   private GridBagLayout gbLayout;
   private GridBagConstraints gbConstraints; 
    
   public void init()
   {
      gbLayout = new GridBagLayout();
      setLayout( gbLayout );   // applet

      // instantiate gridbag constraints
      gbConstraints = new GridBagConstraints();

      // create some components
      cb = new Choice( );
      cb.addItem( "Pine" );
      cb.addItem( "Ash" );
      cb.addItem( "Pecan" );
      tf = new TextField( "TextField" );
      m = new List( 3, false );
      m.addItem( "Java" );
      b1 = new Button( "eins" );
      b2 = new Button( "zwei" );
      b3 = new Button( "drei" );
      b4 = new Button( "vier" );

      // textfield
      gbConstraints.weightx = 1;
      gbConstraints.weighty = 1;  
      gbConstraints.fill = GridBagConstraints.BOTH;
      gbConstraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( tf, gbLayout, gbConstraints );

      // button b1
      // weightx and weighty are 1: fill is BOTH
      gbConstraints.gridwidth = GridBagConstraints.RELATIVE;
      addComponent( b1, gbLayout, gbConstraints );

      // button b2
      // weightx and weighty are 1: fill is BOTH
      gbConstraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( b2, gbLayout, gbConstraints );

      // choicebox
      // weightx is 1: fill is BOTH
      gbConstraints.weighty = 0;
      gbConstraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( cb, gbLayout, gbConstraints );
      
      // button b3
      // weightx is 1: fill is BOTH
      gbConstraints.weighty = 1;
      gbConstraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( b3, gbLayout, gbConstraints ); 

      // button b4
      // weightx and weighty are 1: fill is BOTH
      gbConstraints.gridwidth = GridBagConstraints.RELATIVE;
      addComponent( b4, gbLayout, gbConstraints );

      // list
      // weightx and weighty are 1: fill is BOTH
      gbConstraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( m, gbLayout, gbConstraints );              
   }

   // addComponent is programmer-defined
   private void addComponent( Component c, GridBagLayout g,
                              GridBagConstraints gc ) 
   {
      g.setConstraints( c, gc );
      add( c );      // add component to applet
   }
}
