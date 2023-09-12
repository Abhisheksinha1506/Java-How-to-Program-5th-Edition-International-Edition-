// Fig. 14.1: LoadAudioAndPlay.java
// Load an audio clip and play it.
import java.applet.*;
import java.awt.*;

public class LoadAudioAndPlay extends Applet {
   private AudioClip sound;  
   private Button playSound, loopSound, stopSound;

   // load the image when the applet begins executing
   public void init()
   {
      sound = getAudioClip( getDocumentBase(), "hi.au" );
      playSound = new Button( "Play" );
      loopSound = new Button( "Loop" );
      stopSound = new Button( "Stop" );
      add( playSound );
      add( loopSound );
      add( stopSound );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == playSound ) 
         sound.play();
      else if ( e.target == loopSound ) 
         sound.loop();
      else if ( e.target == stopSound ) 
         sound.stop();

      return true;
   }
}
