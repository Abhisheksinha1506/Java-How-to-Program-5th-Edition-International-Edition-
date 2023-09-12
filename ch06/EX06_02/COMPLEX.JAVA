// Exercise 6.2: Complex.java
// Definition of class Complex

public class Complex {
   private double real;
   private double imaginary;

   // Initialize both parts to 0
   public Complex() { this( 0.0, 0.0 ); }

   // Initialize real part to r and imaginary part to 0
   public Complex( double r ) { this( r, 0.0 ); }

   // Initialize real part to r and imaginary part to i
   public Complex( double r, double i )
   {
      real = r;
      imaginary = i;
   }

   // Add two Complex numbers
   public Complex add( Complex right )
   {
      return new Complex( real + right.real,
                    imaginary + right.imaginary );
   }

   // Subtract two Complex numbers
   public Complex subtract( Complex right )
   {
      return new Complex( real - right.real,
                    imaginary - right.imaginary );
   }

   // Return String representation of a Complex number
   public String toString() 
      { return "(" + real + ", " + imaginary + ")"; }
}