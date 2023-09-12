// Exercise 6.8: RectangleTest.java
// Definition of class RectangleTest
import java.awt.*;
import java.applet.Applet;

public class RectangleTest extends Applet {
   private Label prompt1, prompt2;
   private TextField input1, input2;
   private MyRectangle r;

   public void init()
   {
      prompt1 = new Label( "Length:" );
      prompt2 = new Label( "Width:" );
      input1 = new TextField( 10 );
      input2 = new TextField( 10 );
      add( prompt1 );
      add( input1 );
      add( prompt2 );
      add( input2 );
      r = new MyRectangle();
   }

   public void paint( Graphics g )
   {
      g.drawString( "Length = " + r.getLength(), 25, 75 );
      g.drawString( "Width = " + r.getWidth(), 25, 90 );
      g.drawString( "Perimeter = " + r.perimeter(), 25, 105 );
      g.drawString( "Area = " + r.area(), 25, 120 );
   }

   public boolean action( Event e, Object o )
   {
      Double d1, d2;

      d1 = new Double( input1.getText() );
      d2 = new Double( input2.getText() );

      r.setLength( d1.doubleValue() );
      r.setWidth( d2.doubleValue() );
      repaint();
      return true;
   }
}
