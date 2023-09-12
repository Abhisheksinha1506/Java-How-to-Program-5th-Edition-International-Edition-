// Exercise 10.20 Solution
// Events.java
// Program monitors events

import java.applet.Applet;
import java.awt.*;

public class Events extends Applet {
   private Choice events;
   private boolean mouseMoveEvent;
   private boolean mouseDownEvent;
   private boolean mouseDragEvent;
   private boolean keyDownEvent;
   private boolean keyUpEvent;

   public void init()
   {
      events = new Choice();
      events.addItem( "keyUp" );
      events.addItem( "keyDown" );
      events.addItem( "mouseDown" );
      events.addItem( "mouseDrag" );      
      events.addItem( "mouseMove" );

      disableEvents();
      keyUpEvent = true;

      add( events );
   }

   private void disableEvents()
   {
      mouseMoveEvent = false;
      mouseDownEvent = false;
      mouseDragEvent = false;
      keyDownEvent = false;
      keyUpEvent = false;
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == events ) {
         disableEvents();

         if ( e.arg.equals( "mouseMove" ) )
            mouseMoveEvent = true;
         else if ( e.arg.equals( "keyDown" ) )
            keyDownEvent = true;
         else if ( e.arg.equals( "mouseDown" ) )
            mouseDownEvent = true;
         else if ( e.arg.equals( "mouseDrag" ) )
            mouseDragEvent = true;
         else
            keyUpEvent = true;
      }

      return true;
   }

   public boolean keyDown( Event e, int key )
   {
      if ( keyDownEvent == true ) 
         System.out.println( e.toString() );

      return true;
   }

   public boolean keyUp( Event e, int key )
   {
      if ( keyUpEvent == true ) 
         System.out.println( e.toString() );
      
      return true;
   }

   public boolean mouseDown( Event e, int x, int y )
   {
      if ( mouseDownEvent == true ) 
         System.out.println( e.toString() );
      
      return true;
   }

   public boolean mouseDrag( Event e, int x, int y )
   {
      if ( mouseDragEvent == true ) 
         System.out.println( e.toString() );
      
      return true;
   }

   public boolean mouseMove( Event e, int x, int y )
   {
      if ( mouseMoveEvent == true ) 
         System.out.println( e.toString() );
      
      return true;
   }

}
