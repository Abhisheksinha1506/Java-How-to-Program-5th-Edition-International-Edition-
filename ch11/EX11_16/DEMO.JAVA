// Exercise 11.16 Solution
// Demo.java
// Program demonstrates two TextArea constructors

import java.applet.Applet;
import java.awt.*;

public class Demo extends Applet {
   private TextArea t1, t2;

   public void init()
   {
      t1 = new TextArea();
      t2 = new TextArea( "Text" );

      setLayout( new GridLayout( 2, 1 ) );
      add( t1 );
      add( t2 );
   }
}
