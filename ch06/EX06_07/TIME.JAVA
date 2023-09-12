// Exercise 6.7 Solution
// Time.java
// Program adds validation to Fig. 6.5 example

public class Time {
   private int hour;     // 0 - 23
   private int minute;   // 0 - 59
   private int second;   // 0 - 59

   // Time constructor initializes each instance variable
   // to zero. Ensures that Time object starts in a 
   // consistent state.
   public Time() { setTime( 0, 0, 0 ); }

   // Time constructor: hour supplied, minute and second
   // defaulted to 0.
   public Time( int h ) { setTime( h, 0, 0 ); }

   // Time constructor: hour and minute supplied, second
   // defaulted to 0.
   public Time( int h, int m ) { setTime( h, m, 0 ); }

   // Time constructor: hour, minute and second supplied.
   public Time( int h, int m, int s ) { setTime( h, m, s ); }

   // Set Methods
   // Set a new Time value using military time. Perform 
   // validity checks on the data. Set invalid values 
   // to zero.
   public boolean setTime( int h, int m, int s )
   {
      boolean hourValid, minuteValid, secondValid;

      hourValid = setHour( h );    // set the hour
      minuteValid = setMinute( m );  // set the minute
      secondValid = setSecond( s );  // set the second

      return ( hourValid && minuteValid && secondValid );
   }

   // set the hour 
   public boolean setHour( int h ) 
   {
      if ( h >= 0 && h < 24 ) {
         hour = h;
         return true;
      }
      else {     
         hour = 0;
         return false;
      }
   }  

   // set the minute 
   public boolean setMinute( int m ) 
   {  
      if ( m >= 0 && m < 60 ) {
         minute = m;
         return true;
      }
      else {    
         minute = 0;
         return false;
      }
   }

   // set the second 
   public boolean setSecond( int s ) 
   {
      if ( s >= 0 && s < 60 ) {
         second = s;
         return true;
      }
      else {    
         second = 0;
         return false;
      }
   }

   // Get Methods  
   public int getHour() { return hour; }

   public int getMinute() { return minute; }

   public int getSecond() { return second; }

   // Convert Time to String in military-time format
   public String toMilitaryString()
   {
      return ( hour < 10 ? "0" : "" ) + hour +
             ( minute < 10 ? "0" : "" ) + minute;
   }

   // Convert Time to String in standard-time format
   public String toString()
   {
      return ( ( hour == 12 || hour == 0 ) ? 12 : hour % 12 ) +
             ":" + ( minute < 10 ? "0" : "" ) + minute +
             ":" + ( second < 10 ? "0" : "" ) + second +
             ( hour < 12 ? " AM" : " PM" );
   }
}
