// Fig. 12.2: UsingExceptions.java
// Demonstration of the try-catch-finally
// exception handling mechanism.
public class UsingExceptions {
   public static void main( String args[] )
   {
      try {
         throwException();
      }
      catch ( Exception e )
      {
         System.err.println( "Exception handled in main" );
      }

      doesNotThrowException();
   }

   public static void throwException() throws Exception
   {
      // Throw an exception and immediately catch it.
      try {
         System.out.println( "Method throwException" );
         throw new Exception();  // generate exception
      }
      catch( Exception e )
      {
         System.err.println( "Exception handled in " +
                             "method throwException" );
         throw e;  // rethrow exception for further processing
      }
      finally {
         System.err.println( "Finally is always executed" );
      }
   }   

   public static void doesNotThrowException()
   {
      try {
         System.out.println( "Method doesNotThrowException" );
      }
      catch( Exception e )
      {
         System.err.println( e.toString() );
      }
      finally {
         System.err.println( "Finally is always executed." );
      }
   }   
}
