// Fig. 4.10: Scoping.java
// A scoping example
import java.awt.Graphics;
import java.applet.Applet;

public class Scoping extends Applet {
   int x = 1;      // instance variable

   public void paint( Graphics g )
   {
      g.drawString( "See command line for output", 25, 25 );

      int x = 5;   // local variable to paint

      System.out.println( "local x in paint is " + x );

      a();         // a has automatic local x
      b();         // b uses instance variable x
      a();         // a reinitializes automatic local x
      b();         // instance variable x retains its value

      System.out.println( "\nlocal x in paint is " + x );
   }

   void a()
   {
      int x = 25;  // initialized each time a is called

      System.out.println( "\nlocal x in a is " + x +
                          " after entering a" );
      ++x;
      System.out.println( "local x in a is " + x +
                          " before exiting a" );
   }

   void b()
   {
      System.out.println( "\ninstance variable x is " + x +
                          " on entering b" );
      x *= 10;
      System.out.println( "instance variable x is " + x +
                          " on exiting b" );
   }
}   
