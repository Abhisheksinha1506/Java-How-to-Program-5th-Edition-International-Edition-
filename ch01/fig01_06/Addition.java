// Addition program
import java.awt.*;    // import the java.awt package
import java.applet.Applet;

public class Addition extends Applet {
   Label prompt;      // prompt user to input
   TextField input;   // input values here
   int number;        // store input value
   int sum;           // store sum of integers

   // setup the graphical user interface components
   // and initialize variables
   public void init()
   {
      prompt = new Label( "Enter integer and press Enter:" );
      input = new TextField( 10 );     
      add( prompt );  // put prompt on applet 
      add( input );   // put input on applet
      sum = 0;        // set sum to 0
   }

   // process user's action on the input text field
   public boolean action( Event e, Object o )
   {
      number = Integer.parseInt( o.toString() ); // get number
      input.setText( "" );  // clear data entry field
      sum = sum + number;   // add number to sum
      showStatus( Integer.toString( sum ) );  // show result
      return true;  // indicates user's action was processed
   }
}




            
