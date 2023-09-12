// Exercise 6.18: Time.java
// Time class definition
public class Time {
   private int totalSeconds;

   // Time constructor initializes each instance variable
   // to zero. Ensures that each Time object starts in a
   // consistent state.
   public Time() { setTime( 0, 0, 0 ); }

   // Set a new Time value using military time. Perform
   // validity checks on the data. Set invalid values
   // to zero.
   public void setTime( int h, int m, int s )
   {
      int hour, minute, second;

      hour = ( ( h >= 0 && h < 24 ) ? h : 0 );
      minute = ( ( m >= 0 && m < 60 ) ? m : 0 );
      second = ( ( s >= 0 && s < 60 ) ? s : 0 );

      totalSeconds = hour * 3600 + minute * 60 + second;
   }

   // Convert Time to String in military-time format
   public String toMilitaryString()
   {
      int hour, minute, temp;

      hour = totalSeconds / 3600;
      temp = totalSeconds % 3600;
      minute = temp / 60;

      return ( hour < 10 ? "0" : "" ) + hour +
             ( minute < 10 ? "0" : "" ) + minute;
   }

   // Convert Time to String in standard-time format
   public String toString()
   {
      int hour, minute, second, temp;

      hour = totalSeconds / 3600;
      temp = totalSeconds % 3600;
      minute = temp / 60;
      second = temp % 60;

      return ( ( hour == 12 || hour == 0 ) ? 12 : hour % 12 ) +
             ":" + ( minute < 10 ? "0" : "" ) + minute +
             ":" + ( second < 10 ? "0" : "" ) + second +
             ( hour < 12 ? " AM" : " PM" );
   }
}
