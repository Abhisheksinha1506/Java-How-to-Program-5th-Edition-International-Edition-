// Fig. 11.13: MyFrame2.java
// Creating a subclass of Frame.
import java.applet.Applet;
import java.awt.*;

public class MyFrame2 extends Applet {
   private DemoFrame f;
   private Button showFrame;

   public void init() 
   {
      String s = "Click here to see the Frame";

      showFrame = new Button( s );    
      add( showFrame );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == showFrame ) {
         String s = "This frame does something!";

         if ( f != null ) {
            f.hide();     // hide frame
            f.dispose();  // free resources
         }
         
         f = new DemoFrame( s );   // instantiate frame
         f.resize( 300, 200 );    // resize frame

         // do not allow the frame to be resized
         f.setResizable( false );      

         f.show();   // display frame 
      }

      return true;
   }
}

class DemoFrame extends Frame {
   private Button a, b, c, d;

   public DemoFrame( String s )
   {
      // call base class constructor
      super( s );

      a = new Button( "yellow" );
      b = new Button( "red" );
      c = new Button( "blue" );      
      d = new Button( "green" );
      
      // default layout is border layout
      add( "North", a );
      add( "East", b );
      add( "South", c );
      add( "West", d );
   }

   public boolean handleEvent( Event e )
   {
      if ( e.id == Event.WINDOW_DESTROY ) {
         hide();     // hide frame
         dispose();  // free resources
         return true;
      }

      return super.handleEvent( e );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == a )
         setBackground( Color.yellow );         
      else if ( e.target == b )               
         setBackground( Color.red );          
      else if ( e.target == c )               
         setBackground( Color.blue );
      else   // d button
         setBackground( Color.green );

      repaint();  // update color change
      return true;
   }
}
