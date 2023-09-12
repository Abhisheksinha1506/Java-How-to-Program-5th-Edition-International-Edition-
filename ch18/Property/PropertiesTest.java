// Fig. 18.6: PropertiesTest.java
// Demonstrates class Properties of the java.util package.
import java.io.*;
import java.util.*;
import java.awt.*;

public class PropertiesTest extends Frame {
   Properties table;
   FileInputStream input;
   FileOutputStream output;

   Label prompt1, prompt2;
   TextField propName, propVal, result;
   TextArea display;
   Button put, clear, getProperty, save, load;

   public PropertiesTest()
   {
      super( "Properties Test" );
      table = new Properties();

      prompt1 = new Label( "Property name (key)" );
      propName = new TextField( 10 );
      prompt2 = new Label( "Property value" );
      propVal = new TextField( 10 );
      display = new TextArea( 4, 35 );
      put = new Button( "Put" );
      clear = new Button( "Clear" );
      getProperty = new Button( "Get property" );
      save = new Button( "Save" );
      load = new Button( "Load" );
      result = new TextField( 35 );
      result.setEditable( false );
      setLayout( new FlowLayout() );
      add( prompt1 );
      add( propName );
      add( prompt2 );
      add( propVal );
      add( display );
      add( put );
      add( clear );
      add( getProperty );
      add( save );
      add( load );
      add( result );
      resize( 330, 225 );
      show();
   }

   public boolean handleEvent( Event e )
   {
      if ( e.id == Event.WINDOW_DESTROY ) {
         hide();
         dispose();
         System.exit( 0 );
      }

      return super.handleEvent( e );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == put ) {
         Object val = table.put( propName.getText(),
                                 propVal.getText() );

         if ( val == null )
            showStatus( "Put: " + propName.getText() + " " +
                        propVal.getText() );
         else
            showStatus( "Put: " + propName.getText() + " " +
                        propVal.getText() + "; Replaced: " +
                        val.toString() );
      }
      else if ( e.target == clear ) {
         table.clear();
         showStatus( "Table in memory cleared" );
      }
      else if ( e.target == getProperty ) {
         Object val = table.getProperty( propName.getText() );
             
         if ( val != null )
            showStatus( "Get property: " + propName.getText() +
                        " " + val.toString() );
         else
            showStatus( "Get: " + propName.getText() +
                        " not in table" );
      }
      else if ( e.target == save ) {
         try {
            output = new FileOutputStream( "props.dat" );
            table.save( output, "Sample Properties" );
            output.close();
         }
         catch( IOException ex ) {
            showStatus( ex.toString() );
         }
      }
      else if ( e.target == load ) {
         try {
            input = new FileInputStream( "props.dat" );
            table.load( input );
            input.close();
         }
         catch( IOException ex ) {
            showStatus( ex.toString() );
         }
      }

      listProperties();
      return true;
   }

   public void listProperties()
   {
      StringBuffer buf = new StringBuffer();
      String pName, pVal;

      for ( Enumeration enum = table.propertyNames();
            enum.hasMoreElements(); ) {
         pName = enum.nextElement().toString();
         pVal = table.getProperty( pName );
         buf.append( pName ).append( '\t' );
         buf.append( pVal ).append( '\n' );
      }

      display.setText( buf.toString() );
   }

   public void showStatus( String s )
   {
      result.setText( s );
   }

   public static void main( String args[] )
   {
      PropertiesTest p = new PropertiesTest();
   }
}
