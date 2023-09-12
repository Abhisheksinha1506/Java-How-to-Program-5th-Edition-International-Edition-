// Fig. 6.1: Time.java
// Time class definition
public class Time {
   private int hour;     // 0 - 23
   private int minute;   // 0 - 59
   private int second;   // 0 - 59

   // Time constructor initializes each instance variable
   // to zero. Ensures that each Time object starts in a 
   // consistent state.
   public Time() { setTime( 0, 0, 0 ); }

   // Set a new Time value using military time. Perform 
   // validity checks on the data. Set invalid values 
   // to zero.
   public void setTime( int h, int m, int s )
   {
      hour = ( ( h >= 0 && h < 24 ) ? h : 0 );
      minute = ( ( m >= 0 && m < 60 ) ? m : 0 );
      second = ( ( s >= 0 && s < 60 ) ? s : 0 );
   }

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
