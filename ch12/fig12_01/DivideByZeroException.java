// Fig. 12.1: DivideByZeroException.java
// Definition of class DivideByZeroException.
// Used to throw an exception when a
// divide-by-zero is attempted.
public class DivideByZeroException
             extends ArithmeticException {
   public DivideByZeroException()
   {
      super( "Attempted to divide by zero" );
   }
}
