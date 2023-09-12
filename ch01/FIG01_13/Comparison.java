// Using if statements, relational
// operators, and equality operators 
import java.awt.*;
import java.applet.Applet;

public class Comparison extends Applet {
   Label prompt1;     // prompt user to input first value
   TextField input1;  // input first value here
   Label prompt2;     // prompt user to input second value
   TextField input2;  // input second value here  
   int num1, num2;    // store input values

   // setup the graphical user interface components
   // and initialize variables
   public void init()
   {
      prompt1 = new Label( "Enter an integer" );
      input1 = new TextField( 10 );
      prompt2 =
         new Label( "Enter an integer and press Enter" );
      input2 = new TextField( 10 );
      add( prompt1 );  // put prompt1 on applet
      add( input1 );   // put input1 on applet
      add( prompt2 );  // put prompt2 on applet
      add( input2 );   // put input2 on applet
   }

   // display the results
   public void paint( Graphics g )
   {
      g.drawString( "The comparison results are:",
                    70, 75 );

      if ( num1 == num2 ) 
         g.drawString( num1 + " == " + num2, 100, 90 );

      if ( num1 != num2 ) 
         g.drawString( num1 + " != " + num2, 100, 105 );

      if ( num1 < num2 )
         g.drawString( num1 + " < " + num2, 100, 120 );

      if ( num1 > num2 )
         g.drawString( num1 + " > " + num2, 100, 135 );

      if ( num1 <= num2 ) 
         g.drawString( num1 + " <= " + num2, 100, 150 );

      if ( num1 >= num2 ) 
         g.drawString( num1 + " >= " + num2, 100, 165 );
   }

   // process user's action on the input2 text field
   public boolean action( Event event, Object o )
   {      
      if ( event.target == input2 ) {
         num1 = Integer.parseInt( input1.getText() );
         num2 = Integer.parseInt( input2.getText() );
         repaint();
      }

      return true;  // indicates user's action was processed
   }
}
