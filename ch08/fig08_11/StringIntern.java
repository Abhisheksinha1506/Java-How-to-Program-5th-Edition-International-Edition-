// Fig. 8.11: StringIntern.java
// This program demonstrates the intern method
// of the String class.
import java.awt.Graphics;
import java.applet.Applet;

public class StringIntern extends Applet {
   String s1, s2, s3, s4;

   public void init()
   {
      s1 = new String( "hello" );
      s2 = new String( "hello" );
   }

   public void paint( Graphics g )
   {
      // Test strings to determine if they are the same
      // String object in memory.
      if ( s1 == s2 )
         g.drawString( "s1 and s2 are the " +
                       "same object in memory", 25, 25 );
      else
         g.drawString( "s1 and s2 are not the " +
                       "same object in memory", 25, 25 );

      // Test strings for equality of contents
      if ( s1.equals( s2 ) )
         g.drawString( "s1 and s2 are equal", 25, 45 );
      else
         g.drawString( "s1 and s2 are not equal", 55, 45 );

      // Use String intern method to get a unique copy of
      // "hello" refered to by both s3 and s4.
      s3 = s1.intern();
      s4 = s2.intern();

      // Test strings to determine if they are the same
      // String object in memory.
      if ( s3 == s4 )
         g.drawString( "s3 and s4 are the " +
                       "same object in memory", 25, 65 );
      else
         g.drawString( "s3 and s4 are not the " +
                       "same object in memory", 25, 65 );

      // Determine if s1 and s3 refer to the same object
      if ( s1 == s3 )
         g.drawString( "s1 and s3 are the " +
                       "same object in memory", 25, 85 );
      else
         g.drawString( "s1 and s3 are not the " +
                       "same object in memory", 25, 85 );

      // Determine if s2 and s4 refer to the same object
      if ( s2 == s4 )
         g.drawString( "s2 and s4 are the " +
                       "same object in memory", 25, 105 );
      else
         g.drawString( "s2 and s4 are not the " +
                       "same object in memory", 25, 105 );

      // Determine if s1 and s4 refer to the same object
      if ( s1 == s4 )
         g.drawString( "s1 and s4 are the " +
                       "same object in memory", 25, 125 );
      else
         g.drawString( "s1 and s4 are not the " +
                       "same object in memory", 25, 125 );
   }
}
