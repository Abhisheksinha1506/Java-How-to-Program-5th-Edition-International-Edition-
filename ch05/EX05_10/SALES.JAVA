// Exercise 5.10 Solution
// Sales.java
// Program calculates the amount of pay
// for a salesperson

import java.applet.Applet;
import java.awt.*;

public class Sales extends Applet {
   TextField input;
   Label prompt;
   int total[];

   public void init()
   {
      total = new int[ 9 ];

      for ( int i = 0; i < total.length; i++ )
         total[ i ] = 0;

      input = new TextField( 5 );
      prompt = new Label( "Enter sales amount:" );
      add( prompt );
      add( input );
   }

   public void paint( Graphics g )
   {
      int x = 105, y = 70;

      g.drawString( "Range", 5, 60 );
      g.drawString( "Number", 105, 60 );

      g.drawString( "$200-$299", 5, 70 );
      g.drawString( "$300-$399", 5, 80 );
      g.drawString( "$400-$499", 5, 90 );
      g.drawString( "$500-$599", 5, 100 );
      g.drawString( "$600-$699", 5, 110 );
      g.drawString( "$700-$799", 5, 120 );
      g.drawString( "$800-$899", 5, 130 );
      g.drawString( "$900-$999", 5, 140 );
      g.drawString( "$1000 and over", 5, 150 );

      for ( int i = 0; i < total.length; i++, y += 10 )
         g.drawString( String.valueOf( total[ i ] ), x, y );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == input ) {
         Double d = new Double( input.getText() );
         double dollars = d.doubleValue();
         double salary = dollars * 0.09 + 200;

         if ( salary <= 299 )
            total[ 0 ]++;
         else if ( salary <= 399 )
            total[ 1 ]++;
         else if ( salary <= 499 )
            total[ 2 ]++;
         else if ( salary <= 599 )
            total[ 3 ]++;
         else if ( salary <= 699 )
            total[ 4 ]++;
         else if ( salary <= 799 )
            total[ 5 ]++;
         else if ( salary <= 899 )
            total[ 6 ]++;
         else if ( salary <= 999 )
            total[ 7 ]++;
         else
            total[ 8 ]++;
      }

      repaint();
      return true;
   }
}
