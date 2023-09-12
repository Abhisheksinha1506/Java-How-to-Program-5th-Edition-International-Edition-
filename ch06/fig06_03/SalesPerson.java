// Fig. 6.3: SalesPerson.java
// Definition of class SalesPerson with a utility method
public class SalesPerson {
   private double sales[];     // 12 monthly sales figures

   // Constructor method allocates sales array
   public SalesPerson()
   {
      sales = new double[ 12 ];
   }
   
   // Method to set one of the 12 monthly sales figures
   public void setSales( int month, double amount )
   {
      if ( month >= 1 && month <= 12 && amount > 0 ) 
         sales[ month - 1 ] = amount;
   }
   
   // Private utility method to total annual sales
   private double totalAnnualSales()
   {
      double total = 0.0;
   
      for ( int i = 0; i < 12; i++ )
         total += sales[ i ];
   
      return total;
   }
   
   // Convert the total annual sales figure to a String
   public String toString()
   {
      return "The total annual sales are $" +
             totalAnnualSales();
   }
}
