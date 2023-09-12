// Fig. 18.5: ObserverTest.java
// Test of class Observable and interface Observer
// from the java.util package.
import java.util.*;
import java.awt.*;
import java.applet.Applet;

public class ObserverTest extends Applet implements Observer {
   Clock c;
   Label currentLabel;
   TextField current;
   Button alarmOn;
   Thread clockThread;

   public void init()
   {
      c = new Clock();
      c.addObserver( this );
      clockThread = new Thread( c );

      currentLabel = new Label( "Current date and time: " );
      current = new TextField( c.getDate(), 25 );
      current.setEditable( false );
      alarmOn = new Button( "Alarm on" );
      add( currentLabel );
      add( current );
      add( alarmOn );
      
      clockThread.start();
   }

   public boolean action( Event e, Object o )
   {      
      showStatus( "Alarm set at " + c.setAlarm() );
      return true;
   }

   public void update( Observable ob, Object arg )
   {
      current.setText( arg.toString() );
      showStatus( "Alarm sounded, see new time" );
   }
}

class Clock extends Observable implements Runnable {
   Date d;
   boolean alarmSet;

   public Clock() { d = new Date(); }

   public String setAlarm()
   {      
      alarmSet = true;
      d = new Date();
      return d.toString();
   }

   public String getDate()
   {
      return d.toString();
   }

   public void run()
   {
      while ( true ) {
         if ( alarmSet ) {
            try {
               Thread.sleep( 10000 );
            }
            catch( InterruptedException e ) {
               System.err.println( "Sleep interrupted" );
            }

            alarmSet = false;
            d = new Date();  // get new time
            setChanged();
            notifyObservers( d.toString() );
         }
      }
   }
}
