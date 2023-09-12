// Fig. 5.6: FinalTest.java
// a final object must be initialized
import java.applet.Applet;

public class FinalTest_b extends Applet {
   final int x = 10;

   public void init()
   {
      x = 7;
   }
}

