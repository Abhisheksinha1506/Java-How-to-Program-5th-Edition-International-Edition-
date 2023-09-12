// Fig. 8.3: StringCompare
// This program demonstrates the methods equals, 
// equalsIgnoreCase, compareTo, and regionMatches 
// of the String class.
import java.awt.Graphics;
import java.applet.Applet;

public class StringCompare extends Applet {
   String s1, s2, s3, s4;

   public void init()
   {
      s1 = new String( "hello" );
      s2 = new String( "good bye" );
      s3 = new String( "Happy Birthday" );
      s4 = new String( "happy birthday" );
   }

   public void paint( Graphics g )
   {
      g.drawString( "s1 = " + s1, 25, 25 );
      g.drawString( "s2 = " + s2, 25, 40 );
      g.drawString( "s3 = " + s3, 25, 55 );
      g.drawString( "s4 = " + s4, 25, 70 );

      // test for equality
      if ( s1.equals( "hello" ) )
         g.drawString( "s1 equals \"hello\"", 25, 100 );
      else
         g.drawString( "s1 does not equal \"hello\"", 
                       25, 100 );

      // test for equality with ==
      if ( s1 == "hello" )
         g.drawString( "s1 equals \"hello\"", 25, 115 );
      else
         g.drawString( "s1 does not equal \"hello\"", 
                       25, 115 );

      // test for equality--ignore case
      if ( s3.equalsIgnoreCase( s4 ) )
         g.drawString( "s3 equals s4", 25, 130 );
      else
         g.drawString( "s3 does not equal s4", 25, 130 );

      // test compareTo
      g.drawString( "s1.compareTo( s2 ) is " + 
                    s1.compareTo( s2 ), 25, 160 );
      g.drawString( "s2.compareTo( s1 ) is " + 
                    s2.compareTo( s1 ), 25, 175 );
      g.drawString( "s1.compareTo( s1 ) is " + 
                    s1.compareTo( s1 ), 25, 190 );
      g.drawString( "s3.compareTo( s4 ) is " +
                    s3.compareTo( s4 ), 25, 205 );
      g.drawString( "s4.compareTo( s3 ) is " + 
                    s4.compareTo( s3 ), 25, 220 );

      // test regionMatches (case sensitive)
      if ( s3.regionMatches( 0, s4, 0, 5 ) )
         g.drawString( 
            "First 5 characters of s3 and s4 match",
            25, 250 );
      else
         g.drawString( 
            "First 5 characters of s3 and s4 do not match",
            25, 250 );

      // test regionMatches (ignore case)
      if ( s3.regionMatches( true, 0, s4, 0, 5 ) )
         g.drawString( 
            "First 5 characters of s3 and s4 match",
            25, 265 );
      else
         g.drawString( 
            "First 5 characters of s3 and s4 do not match",
            25, 265 );
   }
}
