// Fig. 11.16: ScratchPad.java
// Incorporating menus into a Frame-based application.
import java.awt.*;

public class ScratchPad extends Frame {
   private TextArea t;
   private Font f;

   public ScratchPad() 
   {
      super( "ScratchPad Application" );

      t = new TextArea();
      add( "Center", t );

      f = new Font( "TimesRoman", Font.PLAIN, 12 );
      setFont( f );

      // create menubar
      MenuBar bar = new MenuBar();

      // create font menu
      Menu fontMenu = new Menu( "Font" );

      // add some items to the menu
      fontMenu.add( "Times Roman" );
      fontMenu.add( "Courier" );
      fontMenu.add( "Helvetica" );   

      // add menu to menu bar
      bar.add( fontMenu );

      // set the menubar for the frame
      setMenuBar( bar );
 
      resize( 300, 200 );
      show();
   }

   public boolean handleEvent( Event e )
   {
      if ( e.id == Event.WINDOW_DESTROY ) {
         hide();      // hide frame
         dispose();   // free resources
         System.exit( 0 );  // terminate
         return true;
      }

      return super.handleEvent( e );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target instanceof MenuItem ) {

         if ( e.arg.equals( "Times Roman" ) )
            f = new Font( "TimesRoman", Font.PLAIN, 12 );
         else if ( e.arg.equals( "Courier" ) )
            f = new Font( "Courier", Font.PLAIN, 12 );
         else  // Helvetica
            f = new Font( "Helvetica", Font.PLAIN, 12 );

         t.setFont( f );
      }

      return true;
   }

   public static void main( String args[] )
   {
      ScratchPad e;

      e = new ScratchPad();
   }
}                    
