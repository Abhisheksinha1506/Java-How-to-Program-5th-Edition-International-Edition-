// Passing arrays and individual array elements to functions
// \Java_04\fig04_14\exe\PassArray.java
// C++ fig4_14.cpp

public class PassArray2 {

   public static void main( String args[] )
   {
      String a[] = { "hello", "goodbye", "seeya" };

      System.out.println(
         "Effects of passing entire array call-by-reference:\n\n" +
         "The values of the original array are:" );
   
      for ( int i = 0; i < a.length; i++ )
         System.out.print( "  " + a[i] );
   
      System.out.println();
   
      modifyArray( a );  // array a passed call-by-reference
   
      System.out.println( "The values of the modified array are:" );
   
      for ( int i = 0; i < a.length; i++ )
         System.out.print( "  " + a[i] );
   
      System.out.println(
           "\n\n\nEffects of passing array element call-by-value:" +
           "\n\nThe value of a[1] is " + a[1] );
   
      modifyElement( a[1] );
   
      System.out.println( "The value of a[1] is " + a[1] );
   }
   
   public static void modifyArray( String b[] )
   {
         b[0] = "goodbye";
         b[1] = "seeya";
         b[2] = "hello";
   }
   
   public static void modifyElement( String e )
   {
      System.out.println( "Value in modifyElement is " + ( e = "hello" ) );
   }
   
}
