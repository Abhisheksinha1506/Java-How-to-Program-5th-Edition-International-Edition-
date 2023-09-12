// Fig. 4.17: MethodOverload.java
// Overloaded methods with identical signatures and
// different return types.
import java.awt.Graphics;
import java.applet.Applet;

public class MethodOverload extends Applet {
   int square( double x )
   {
      return x * x;
   }
   
   double square( double y )
   {
      return y * y;
   }
}
