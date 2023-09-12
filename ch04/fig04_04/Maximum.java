// Fig. 4.4: Maximum.java
// Finding the maximum of three integers
import java.awt.*;  
import java.applet.Applet;

public class Maximum extends Applet {
   Label label1, label2, label3, resultLabel;
   TextField number1, number2, number3, result;
   int num1, num2, num3, max;

   // set up labels and text fields
   public void init()
   {
      label1 = new Label( "Enter first integer:" );
      number1 = new TextField( "0", 10 );
      label2 = new Label( "Enter second integer:" );
      number2 = new TextField( "0", 10 );
      label3 = new Label( "Enter third integer:" );
      number3 = new TextField( "0", 10 );
      resultLabel = new Label( "Maximum value is:" );      
      result = new TextField( "0", 10 );
      result.setEditable( false );

      add( label1 );
      add( number1 );
      add( label2 );
      add( number2 );
      add( label3 );
      add( number3 );
      add( resultLabel );
      add( result );
   }

   // maximum method definition
   public int maximum( int x, int y, int z )
   {
      return Math.max( x, Math.max( y, z ) );
   }

   // get the integers and call the maximum method
   public boolean action( Event e, Object o )
   {
      num1 = Integer.parseInt( number1.getText() );
      num2 = Integer.parseInt( number2.getText() );
      num3 = Integer.parseInt( number3.getText() );
      max = maximum( num1, num2, num3 );
      result.setText( Integer.toString( max ) );
      return true;
   }
}
