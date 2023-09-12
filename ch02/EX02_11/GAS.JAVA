// Exercise 2.11 Solution
// Gas.java
// Program calculates average mpg

import java.applet.Applet;
import java.awt.*;

public class Gas extends Applet {
   TextField milesInput;
   TextField gallonsInput;
   Label milesLabel;
   Label gallonsLabel;
   int miles, gallons;
   int totalMiles, totalGallons;
   float milesPerGallon;
   float totalMilesPerGallon;

   public void init()
   {
      milesLabel = new Label( "Enter Miles: " );
      gallonsLabel = new Label( "Enter Gallons: " );
      milesInput = new TextField( 5 );
      gallonsInput = new TextField( 5 );
      totalMiles = 0;
      totalGallons = 0;
      milesPerGallon = 0;
      totalMilesPerGallon = 0;
      add( milesLabel );
      add( milesInput );
      add( gallonsLabel );
      add( gallonsInput );
   }

   public void paint( Graphics g )
   {
      g.drawString( "MPG this tankful: " + milesPerGallon, 25, 70 );
      g.drawString( "Total MPG: " + totalMilesPerGallon, 25, 85 );
   }
   
   public boolean action( Event e, Object o )
   {
      if ( e.target == gallonsInput ) {
         miles = Integer.parseInt( milesInput.getText() );
         totalMiles += miles;        
         gallons = Integer.parseInt( gallonsInput.getText() );
         totalGallons += gallons; 
      
         if ( gallons != 0 ) 
            milesPerGallon = ( float ) miles / gallons;

         if ( totalGallons != 0 )
            totalMilesPerGallon = ( float ) totalMiles / totalGallons;

         repaint();
      }

      return true;
   }
}
