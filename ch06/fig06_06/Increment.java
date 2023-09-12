// Fig. 6.6: Increment.java
// Initializing a final variable
import java.awt.*;
import java.applet.Applet;

public class Increment extends Applet {
   private int count, total;
   private final int increment = 5; // constant variable
   private Button incr;  

   public void init() 
   { 
      count = 0; 
      total = 0;
      incr = new Button( "Click to increment" );
      add( incr );
   }

   public boolean action( Event e, Object o )
   {
      total += increment;
      count++;
      showStatus( "After increment " + count +
                  ": total = " + total );
      return true;
   }
}

