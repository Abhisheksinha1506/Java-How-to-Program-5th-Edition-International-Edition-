// Ex. 4.6: SphereTest.java
import java.applet.Applet;
import java.awt.*;

public class SphereTest extends Applet {
   Label prompt;
   TextField input;

   public void init()
   {
      prompt = new Label( "Enter sphere radius: " );
      input = new TextField( 10 );
      add( prompt );
      add( input );
   }

   public boolean action( Event e, Object o )
   {
      Double val = new Double( o.toString() );
      double radius = val.doubleValue();
      showStatus( "Volume is " +
                  Double.toString( sphereVolume( radius ) ) );
      return true;
   }

   public double sphereVolume( double radius )
   {
      double volume;
      volume = ( 4 / 3 ) * Math.PI * Math.pow( radius, 3 );
      return volume;
   }
}
