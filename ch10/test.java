import java.awt.*;
import java.applet.Applet;

public class test extends Applet {
  Button b, bb;

  public void init()
  {
     b = new Button( "hi" );
     bb = new Button( "hi" );

     add( b );
     add( bb );

  }


}
