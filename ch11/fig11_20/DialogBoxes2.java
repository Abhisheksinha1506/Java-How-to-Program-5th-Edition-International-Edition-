// Fig. 11.20: DialogBoxes2.java
// Demonstrating the "Open" and "Save" dialog boxes.
import java.awt.*;

public class DialogBoxes2 extends Frame
{
   private MyFiles m;
   private MenuItem item, item2;

   public DialogBoxes2()
   {
      super( "Dialog boxes 2" );

      MenuBar bar = new MenuBar();
      Menu fileMenu = new Menu( "File" );

      item = new MenuItem( "Open..." );
      item2 = new MenuItem( "Save As ..." );
      
      fileMenu.add( item );
      fileMenu.add( item2 );

      bar.add( fileMenu );
      setMenuBar( bar );
      resize( 200, 100);
      show();
   }

   public static void main( String args[] )
   {
      DialogBoxes2 d = new DialogBoxes2();
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target instanceof MenuItem ) 

         if ( e.arg.equals( item.getLabel() ) ) 
            m = new MyFiles( this, FileDialog.LOAD );
         else if ( e.arg.equals( item2.getLabel() ) )
            m = new MyFiles( this, FileDialog.SAVE );

      return true;
   }

   public boolean handleEvent( Event e )
   {
      if ( e.id == Event.WINDOW_DESTROY ) { 
         hide();
         dispose();
         System.exit( 0 );
         return true;
      }

      return super.handleEvent( e );
   }
}

class MyFiles extends FileDialog
{
   public MyFiles( Frame f, int type ) 
   {
      super( f, ( type == FileDialog.LOAD ? "Open "
                  : "Save " ) + "Dialog", type );

      resize( 400, 250 );
      show();
   }
}
