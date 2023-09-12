// Exercise 12.21 Solution
// Demo.java
// Program demonstrates that the exception
// superclass will catch the subclass exceptions

class ExceptionA extends Exception {}

class ExceptionB extends ExceptionA {}

class ExceptionC extends ExceptionB {}

public class Demo {

   public static void main( String args[] )
   {
      try {
         throw new ExceptionC();
      } catch( ExceptionA a ) {
         System.out.println( a.toString() );
      }

      try {
         throw new ExceptionB();
      } catch( ExceptionA b ) {
         System.out.println( b.toString() );
      }
   }
}
