// Fig. 12.3: UsingExceptions.java
// Demonstration of stack unwinding.
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
   }

   public static void throwException() throws Exception
   {
      // Throw an exception and catch it in main.
      try {
         System.out.println( "Method throwException" );
         throw new Exception();  // generate exception
      }
      catch( OtherException e )
      {
         System.err.println( "Exception handled in " +
                             "method throwException" );
      }
      finally {
         System.err.println( "Finally is always executed" );
      }
   }   
}

class OtherException extends Exception {
   public OtherException()
   {
      super( "Another exception type" );
   }
}
