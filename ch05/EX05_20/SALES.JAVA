// Exercise 5.20 Solution
// Sales.java
// Program totals sales for salespeople 
// and products.

import java.applet.Applet;
import java.awt.*;

public class Sales extends Applet {
    Label prompt1, prompt2, prompt3;
    TextField input1, input2, input3;
    double sales[][], totalPerson[], totalProducts[];
    int person, product;

    public void init()
    {
       sales = new double[ 4 ][ 5 ];
       totalPerson = new double[ 4 ];
       totalProducts = new double[ 5 ];

       zeroArrays();
       prompt1 = new Label( "Enter sales person number: " );
       prompt2 = new Label( "Enter product number: " );
       prompt3 = new Label( "Enter sales amount: " );
       input1 = new TextField( 5 );
       input2 = new TextField( 5 );
       input3 = new TextField( 5 );
       add( prompt1 );
       add( input1 );
       add( prompt2 );
       add( input2 );
       add( prompt3 );
       add( input3 );
    }
   
   public void zeroArrays()
   {
      for ( int row = 0; row < sales.length; row++ ) {

        for ( int col = 0; col < sales[ row ].length; col++ ) {
            sales[ row ][ col ] = 0;

            if ( row == 0 )
               totalProducts[ col ] = 0;
        }

        totalPerson[ row ] = 0;
      }
   }

   public boolean action( Event e, Object o )
   {
      showStatus( "" );

      if ( e.target == input3 ) {
         Double d = new Double( input3.getText() );
         person = Integer.parseInt( input1.getText() );
         product = Integer.parseInt( input2.getText() );

         if ( person >= 1 && person < 5 &&
              product >= 1 && product < 6 ) {

            sales[ person - 1 ][ product - 1 ] += d.doubleValue();
         }
         else
            showStatus( "Invalid input!" );
      }

      repaint();
      return true;
   }

   public void paint( Graphics g )
   {
      int x = 100, y = 120;
      double total = 0.0;

      for ( int j = 0; j < totalProducts.length; j++ )
         totalProducts[ j ] = 0;

      g.drawString( "Product", 5, 110 );
      g.drawString( "1", x += 30, 110 );
      g.drawString( "2", x += 30, 110 );
      g.drawString( "3", x += 30, 110 );
      g.drawString( "4", x += 30, 110 );
      g.drawString( "5", x += 30, 110 );
      g.drawString( "Total", x += 30, 110 );

      for ( int r = 0; r < sales.length; r++ ) {
         g.drawString( "Sales person " + ( r + 1 ), 5, y );
         total = 0.0;
         x = 100;

         for ( int c = 0; c < sales[ r ].length; c++ ) {
            total += sales[ r ][ c ];
            g.drawString( String.valueOf( sales[ r ][ c ] ), x += 30, y );
            totalProducts[ c ] += sales[ r ][ c ];
         }

         g.drawString( String.valueOf( total ), x += 30, y );
         y += 10;
      }

      g.drawString( "Total", 5, y );
      x = 100;

      for ( int k = 0; k < totalProducts.length; k++ )
         g.drawString( String.valueOf( totalProducts[ k ] ), x += 30, y );
   }
}
