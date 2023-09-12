// Fig. 16.1: SiteSelector.java
// This program uses a button to load a document from a URL.
import java.awt.*;
import java.net.*;
import java.applet.Applet;

public class SiteSelector extends Applet {
   Site siteList[];  // array of sites

   public void init()
   {
      siteList = new Site[ 2 ]; 
      siteList[ 0 ] = new Site ( " Java Home ", 
                     "http://www.javasoft.com/index.html" );
      siteList[ 1 ] = new Site ( "Deitel Home", 
                     "http://www.deitel.com/index.html" );

      for ( int i = 0; i < siteList.length; i++ )
         add( new Button( siteList[ i ].getTitle() ) );
   }

   public boolean action( Event e, Object arg )
   {
      if ( e.target instanceof Button ) {
         String title;
         URL location;

         for ( int i = 0; i < siteList.length; i++ ) {
            title = siteList[ i ].getTitle();
            location = 
               siteList[ i ].getLocation();

            if ( title.equals( arg.toString() ) ) {
               gotoSite( location );
               return true;  // event handled
            }
         }
      }

      return false;    // event not handled yet
   }

   public void gotoSite( URL loc )
   {
      // this must be executed in a broswer such as Netscape
      getAppletContext().showDocument( loc );
   }
}

class Site extends Button {
   private String title;
   private URL location;

   public Site( String siteTitle, String siteLocation )
   {
      title = siteTitle;

      try {
         location = new URL( siteLocation );
      }
      catch ( MalformedURLException e ) {
         System.err.println( "Invalid URL: " + siteLocation );
      }
   }

   public String getTitle() { return title; }

   public URL getLocation() { return location; }
}

