// Fig. 6.3: SalesPersonTest.java
// Demonstrating class SalesPerson and its utility method
import java.awt.*;
import java.applet.Applet;

public class SalesPersonTest extends Applet {
   private SalesPerson s;
   private double salesFigure;
   private int month;
   private boolean moreInput = true;
   private String months[] = { "January", "February",
                       "March", "April", "May", "June", 
                       "July", "August", "September", 
                       "October", "November", "December" };

   // GUI components
   private Label enterLabel;
   private TextField currentMonth, enter, total;

   public void init()
   {
      s = new SalesPerson();
      month = 1;

      enterLabel = new Label( "Enter sales for" );
      currentMonth = new TextField( "January", 10 );
      currentMonth.setEditable( false );
      enter = new TextField( 10 );
      total = new TextField( 30 );
      total.setEditable( false );

      add( enterLabel );
      add( currentMonth );
      add( enter );
      add( total );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == enter ) {
         if ( moreInput ) {
            Double val = Double.valueOf( e.arg.toString() );
            s.setSales( month, val.doubleValue() );

            if ( month == 12 ) {
               total.setText( s.toString() );

               // hide GUI components no longer needed
               enterLabel.hide();
               currentMonth.hide();
               enter.hide();      
               moreInput = false;
            }
            else {
               month++;
               currentMonth.setText( months[ month - 1 ] );
               enter.setText( "" );  // clear the text field
            }
         }
      }

      return true;
   }
}

