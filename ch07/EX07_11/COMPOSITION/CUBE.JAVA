// Cube.java
// Definition of class Cube

public class Cube {
   private double depth;  
   private Square s;       // composition
    
   public Cube( double m, double a, double b )      
   {
      s = new Square( m, a, b ); 
      depth = m;
   }
      
   public double getDepth() { return depth; }
   
   public double area() { return s.area() * 6; } 
     
   public double volume() { return s.area() * depth; }

   public String toString()
      { return s.toString() + "; Depth = " + depth; }
   
   public String getName() { return "Cube"; }
 
   public double getSquareArea() { return s.area(); }

   public String getSquareName() { return s.getName(); }
  
   public String getSquareString() { return s.toString(); }
 
   public String getSPointString() { return s.getPointString(); }

   public String getSPointName() { return s.getPointName(); }
}
