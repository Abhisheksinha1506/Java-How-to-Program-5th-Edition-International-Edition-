// Exercise 14.21 Solution
// Flash.java
// Program flashes text.

import java.applet.Applet;
import java.awt.*;

public class Flash extends Applet {
   private MyCanvas theCanvas;
   private Choice colorSelect;
   private Label prompt;
   private TextField input;

   public void init()
   {
      Image image1 = createImage( 100, 100 );     
      Image image2 = createImage( 100, 100 );

      prompt = new Label( "Enter rate ( 50 - 200 ):" );
      input = new TextField( 5 );      
      theCanvas = new MyCanvas( image1, image2 );

      colorSelect = new Choice();
      colorSelect.addItem( "Black" );
      colorSelect.addItem( "Red" );
      colorSelect.addItem( "Blue" );
      colorSelect.addItem( "Green" );
      
      add( theCanvas );
      add( colorSelect );
      add( prompt );
      add( input );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == colorSelect ) {
         Color c;

         if ( o.equals( "Black" ) )
            c = Color.black;
         else if ( o.equals( "Red" ) )
            c = Color.red;
         else if ( o.equals( "Blue" ) )
            c = Color.blue;
         else 
            c = Color.green;

         theCanvas.setBackColor( c );
      }
      else if ( e.target == input )
         theCanvas.setSleepTime( Integer.parseInt( input.getText() ) );

      showStatus( "current blink rate: " + theCanvas.getSleepTime() );
      return true;
   }
}

class MyCanvas extends Canvas implements Runnable {
   private Image img;
   private Image img2;
   private Graphics graph;
   private Graphics graph2;   
   private String text;
   private boolean flashSwitch;
   private int sleepTime;
   private Thread canvasThread;

   public MyCanvas( Image i, Image i2 )
   {
      setBackground( Color.black );
      canvasThread = new Thread( this );
      canvasThread.start();
      flashSwitch = true;
      text = "Flash me!";
      resize( 100, 100 );
      img = i;
      img2 = i2;
      graph = img.getGraphics();
      graph2 = img2.getGraphics();
      setBackColor( Color.black );
      setSleepTime( 150 );
   }

   public void paint( Graphics g )
   {
      if ( flashSwitch )
         g.drawImage( img, 0, 0, this );
      else
         g.drawImage( img2, 0, 0, this );
   }

   public void run()
   {
      while ( true ) {         
         repaint();

         try {
            Thread.sleep( sleepTime );
         } catch ( Exception e ) {
            System.err.println( "Exception: " + e.toString() );
         }

         flashSwitch = !flashSwitch;
      }
   }

   public void update( Graphics g ) { paint( g ); }

   public void setSleepTime( int t )
      { sleepTime = t >= 50 && t <= 200 ? t : 150; }

   public int getSleepTime() { return sleepTime; }

   public void setBackColor( Color c )
   {
      graph.setColor( c );
      graph2.setColor( c );
      graph.fillRect( 0, 0, 100, 100 );
      graph2.fillRect( 0, 0, 100, 100 );
      graph.setColor( Color.yellow );
      graph.drawString( text, 20, 50 );     
   }
}
