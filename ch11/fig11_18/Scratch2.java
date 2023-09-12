// Fig. 11.18: Scratch2.java
// Using submenus in a menu.
import java.awt.*;

public class Scratch2 extends Frame {
   private TextArea t;
   private Font f;
   private Color c;
   private CheckboxMenuItem x;   

   public Scratch2() 
   {
      super( "ScratchPad Application 2" );

      t = new TextArea();
      add( "Center", t );

      f = new Font( "TimesRoman", Font.PLAIN, 12 );
      t.setFont( f );
    
      t.setForeground( Color.black );

      // create menubar
      MenuBar bar = new MenuBar();

      // create menus
      Menu viewMenu = new Menu( "View" );
      Menu fontMenu = new Menu( "Font" );
      Menu colorMenu = new Menu( "Color" );

      // build color menu
      colorMenu.add( new MenuItem( "Black" ) );
      colorMenu.add( new MenuItem( "Blue" ) );

      // build font menu
      fontMenu.add( new MenuItem( "Times Roman" ) );
      fontMenu.add( new MenuItem( "Courier" ) );

      // build view menu
      viewMenu.add( fontMenu );
      viewMenu.add( new MenuItem( "-" ) );
      viewMenu.add( colorMenu );
      viewMenu.add( new MenuItem( "-" ) );

      x = new CheckboxMenuItem( "Read-only" );
      viewMenu.add( x );     
      x.setState( false );  

      // add menu to menu bar
      bar.add( viewMenu );

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
         else if ( e.arg.equals( "Black" ) ) 
            c = Color.black;
         else if ( e.arg.equals( "Blue" ) ) 
            c = Color.blue;
         else if ( e.arg.equals( x.getLabel() ) )
            t.setEditable( !x.getState() );

         t.setForeground( c );
         t.setFont( f );
      }
      
      return true;
   }
          
   public static void main( String args[] )
   {
      Scratch2 e;

      e = new Scratch2();
   }
}                    
