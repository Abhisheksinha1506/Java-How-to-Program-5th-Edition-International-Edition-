// Fig. 11.14: MyFrame3.java
// Creating a Frame-based application.
import java.awt.*;

public class MyFrame3 extends Frame {
   private Button showFrame;
   private DemoFrame f;
   private int number;
   private String frameTitle, title;

   // default constructor
   public MyFrame3()
      {  this( "Frame" );  }

   public MyFrame3( String t )
   {
      super( "Application" );
      String s = "Click here to see the Frame";

      number = 0;
      title = t;
      showFrame = new Button( s );
      add( "South", showFrame );

      resize( 300, 100 );
      show();
   }

   public boolean handleEvent( Event e )
   {
      if ( e.id == Event.WINDOW_DESTROY ) {
         removeFrame( this );
         System.exit( 0 );  // terminate program
         return true;
      }

      return super.handleEvent( e );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == showFrame ) {

         if ( f != null )
            removeFrame( f );

         number++;
         frameTitle = title + " " +
                      String.valueOf( number );

         f = new DemoFrame( frameTitle );
      }

      return true;
   }

   public void removeFrame( Frame w )
   {
      w.hide();     // hide frame
      w.dispose();  // free resources
   }

   public static void main( String args[] )
   {
      MyFrame3 myself;

      if ( args.length == 0 )
         myself = new MyFrame3();
      else
         myself = new MyFrame3( args[ 0 ] );
   }
}                           

class DemoFrame extends Frame {
   private Button a, b, c, d;

   public DemoFrame( String s )
   {
      super( s );
      a = new Button( "yellow" );
      b = new Button( "red" );
      c = new Button( "blue" );
      d = new Button( "green" );
      
      // default layout is border
      add( "North", a );
      add( "East", b );
      add( "South", c );
      add( "West", d );

      resize( 200, 200 );
      show();   // display frame 
   }

   public boolean handleEvent( Event e )
   {
      if ( e.id == Event.ACTION_EVENT ) {
         action( e, e.arg );
         return true;
      }
      else if ( e.id == Event.WINDOW_DESTROY ) {
         hide();     // hide frame
         dispose();  // free resources
         return true;
      }

      return super.handleEvent( e );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == c )
         setBackground( Color.blue );
      else if ( e.target == b )
         setBackground( Color.red );
      else if ( e.target == d )
         setBackground( Color.green );
      else  // a button
         setBackground( Color.yellow );

      repaint();
      return true;
   }
}
