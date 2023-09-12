// Fig. 12.4: UsingExceptions.java
// Demonstrating the getMessage and printStackTrace
// methods inherited into all exception classes.
public class UsingExceptions {
   public static void main( String args[] )
   {
      try {
         method1();
      }
      catch ( UserException e )
      {
         System.err.println( e.getMessage() +
                             "\nThe stack trace is:" );
         e.printStackTrace();
      }
   }

   public static void method1() throws UserException
   {
      method2();
   }

   public static void method2() throws UserException
   {
      method3();
   }

   public static void method3() throws UserException
   {
      throw new UserException();
   }
}

class UserException extends Exception {
   public UserException()
   {
      super( "This is a user defined exception." );
   }
}
