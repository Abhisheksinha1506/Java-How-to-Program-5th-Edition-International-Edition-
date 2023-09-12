// Exercise 6.4: TimeTest.java
// Demonstrating the Time class set and get methods
import java.awt.*;
import java.applet.Applet;

public class TimeTest extends Applet {
   private Time t;
   private Label hrLabel, minLabel, secLabel;
   private TextField hrField, minField, secField, display;
   private Button tickButton;

   public void init()
   {
      t = new Time();

      hrLabel = new Label( "Set Hour" );
      hrField = new TextField( 10 );
      minLabel = new Label( "Set Minute" );
      minField = new TextField( 10 );
      secLabel = new Label( "Set Second" );
      secField = new TextField( 10 );
      display = new TextField( 30 );
      display.setEditable( false );
      tickButton = new Button( "Add 1 to Second" );

      add( hrLabel );
      add( hrField );
      add( minLabel );
      add( minField );
      add( secLabel );
      add( secField );
      add( display );
      add( tickButton );
      updateDisplay();      
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == tickButton )
         t.tick();
      else if ( e.target == hrField ) {
         t.setHour( Integer.parseInt( e.arg.toString() ) );
         hrField.setText( "" );
      }
      else if ( e.target == minField ) {
         t.setMinute( Integer.parseInt( e.arg.toString() ) );
         minField.setText( "" );
      }
      else if ( e.target == secField ) {
         t.setSecond( Integer.parseInt( e.arg.toString() ) );
         secField.setText( "" );
      }

      updateDisplay();

      return true;
   }

   public void updateDisplay()
   {
      display.setText( "Hour: " + t.getHour() +
         "; Minute: " + t.getMinute() +
         "; Second: " + t.getSecond() );
      showStatus( "Standard time is: " + t.toString()+
         "; Military time is: " + t.toMilitaryString() );
   }
}


