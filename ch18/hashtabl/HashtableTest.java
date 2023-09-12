// Fig. 18.3: HashtableTest.java
// Demonstrates class Hashtable of the java.util package.
import java.util.*;
import java.awt.*;
import java.applet.Applet;

public class HashtableTest extends Applet {
   Hashtable table;

   Label name1, name2;
   TextField fName, lName;
   TextArea display;
   Button put, get, remove, empty, containsKey, containsObj,
          clear, listElems, listKeys;

   public void init()
   {
      table = new Hashtable();

      name1 = new Label( "First name" );
      fName = new TextField( 10 );
      name2 = new Label( "Last name (key)" );
      lName = new TextField( 10 );
      display = new TextArea( 4, 45 );
      put = new Button( "Put" );
      get = new Button( "Get" );
      remove = new Button( "Remove" );
      empty = new Button( "Empty" );
      containsKey = new Button( "Contains key" );
      containsObj = new Button( "Contains object" );
      clear = new Button( "Clear table" );
      listElems = new Button( "List objects" );
      listKeys = new Button( "List keys" );
      add( name1 );
      add( fName );
      add( name2 );
      add( lName );
      add( display );
      add( put );
      add( get );
      add( remove );
      add( empty );
      add( containsKey );
      add( containsObj );
      add( clear );
      add( listElems );
      add( listKeys );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == put ) {
         Employee emp = new Employee( fName.getText(),
                                      lName.getText() );
         Object val = table.put( lName.getText(), emp );

         if ( val == null )
            showStatus( "Put: " + emp.toString() );
         else
            showStatus( "Put: " + emp.toString() +
                        "; Replaced: " + val.toString() );
      }
      else if ( e.target == get ) {
         Object val = table.get( lName.getText() );
             
         if ( val != null )
            showStatus( "Get: " + val.toString() );
         else
            showStatus( "Get: " + lName.getText() +
                        " not in table" );
      }
      else if ( e.target == remove ) {
         Object val = table.remove( lName.getText() );
             
         if ( val != null )
            showStatus( "Remove: " + val.toString() );
         else
            showStatus( "Remove: " + lName.getText() +
                        " not in table" );
      }
      else if ( e.target == empty ) {
         showStatus( "Empty: " + table.isEmpty() );
      }
      else if ( e.target == containsKey ) {
         showStatus( "Contains key: " +
            table.containsKey( lName.getText() ) );
      }
      else if ( e.target == containsObj ) {
         showStatus( "Contains object: " +
            table.contains( new Employee( fName.getText(),
                                   lName.getText() ) ) );
      }
      else if ( e.target == clear ) {
         table.clear();
         showStatus( "Clear: Table is now empty" );
      }
      else if ( e.target == listElems ) {
         StringBuffer buf = new StringBuffer();

         for ( Enumeration enum = table.elements();
               enum.hasMoreElements(); )
            buf.append( enum.nextElement() ).append( '\n' );

         display.setText( buf.toString() );
      }
      else if ( e.target == listKeys ) {
         StringBuffer buf = new StringBuffer();

         for ( Enumeration enum = table.keys();
               enum.hasMoreElements(); )
            buf.append( enum.nextElement() ).append( '\n' );

         display.setText( buf.toString() );
      }

      return true;
   }
}

class Employee {
   private String first;
   private String last;

   public Employee( String fName, String lName )
   {
      first = fName;
      last = lName;
   }

   public String toString() { return first + " " + last; }
}
