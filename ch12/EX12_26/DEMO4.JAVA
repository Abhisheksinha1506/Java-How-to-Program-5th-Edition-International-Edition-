// Exercise 12.26 Solution
// Demo4.java
// Program demonstrates rethrowing an exception

public class Demo4 {

   public static void main( String args[] )
   {
      try {
         someMethod();
      }
      catch( Exception e ) {
         System.out.println( "Handled in main: " + e.toString() );
      }
   }

   public static void someMethod() throws Exception
   {
      try {
         someMethod2();
      }
      catch( Exception e ) {
         throw e;        // rethrow the exception
      }
   }

   public static void someMethod2() throws Exception
   {  throw new Exception();  }
}
