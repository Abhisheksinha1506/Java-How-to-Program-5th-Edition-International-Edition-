// Fig. 11.19: DialogBoxes.java
// Demonstrating modeless Dialog boxes.
import java.awt.*;

public class DialogBoxes extends Frame {
   private About a;
   private MenuItem item, item2;

   public DialogBoxes()
   {
      super( "Dialog boxes" );

      MenuBar bar = new MenuBar();
      Menu helpMenu = new Menu( "Help" );
      Menu fileMenu = new Menu( "File" );

      item = new MenuItem( "About..." );
      item2 = new MenuItem( "Exit" );

      helpMenu.add( item );
      fileMenu.add( item2 );

      bar.setHelpMenu( helpMenu ); 
      bar.add( helpMenu );
      bar.add( fileMenu );

      setMenuBar( bar );
      resize( 200, 100 );
      show();
   }

   public static void main( String args[] )
   {
      DialogBoxes d;

      d = new DialogBoxes();
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target instanceof MenuItem ) 

         if ( e.arg.equals( item.getLabel() ) ) {
            a = new About( this );    
            setItemState( false );
         }
         else     // Exit menu item
            removeFrame();
         
      return true;
   }

   public boolean handleEvent( Event e )
   {
      if ( e.id == Event.WINDOW_DESTROY ) {
         removeFrame();
         return true;
      }

      return super.handleEvent( e );
   }

   // setItemState is programmer-defined
   public void setItemState( boolean state )
   {
      if ( state == true )
         item.enable();
      else
         item.disable();
   }

   // removeFrame is programmer-defined
   public void removeFrame()
   {
      hide();
      dispose();
      System.exit( 0 );
   }
}

class About extends Dialog {
   private Button b;
   private Label l;
   private Panel p, p2;
   private DialogBoxes parent;

   public About( Frame f ) 
   {
      super( f, "About", false );
      parent = ( DialogBoxes ) f; 

      b = new Button( "Ok" );
      p = new Panel();
      p2 = new Panel();
      l = new Label( "Java How To Program" );

      p.add( l );
      p2.add( b );

      add( "Center", p );
      add( "South", p2 );
      resize( 200, 100 );
      show();
   }

   public boolean handleEvent( Event e )
   {
      if ( e.id == Event.WINDOW_DESTROY ) {
         removeDialog();         
         return true;
      }

      return super.handleEvent( e );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == b ) 
         removeDialog();

      return true;
   }

   // removeDialog is user-defined
   public void removeDialog()
   {
      hide();
      dispose();
      parent.setItemState( true );
   }
}


