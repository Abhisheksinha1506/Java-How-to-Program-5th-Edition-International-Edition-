// Exercise 17.17 Solution
// TreeTest.java
// This program tests the Tree class.

import java.applet.Applet;
import java.awt.*;
import java.util.*;

public class TreeTest extends Applet {
   private Tree tree;
   private Label prompt;
   private TextField input;

   public void init()
   {
      prompt = new Label( "Enter String:" );
      input = new TextField( 25 );

      add( prompt );
      add( input );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == input ) {
         tree = new Tree();
         StringTokenizer s = new StringTokenizer( input.getText() );

         while ( s.hasMoreTokens() )             
            tree.insertNode( s.nextToken() );
                  
         System.out.println ( "\n\nPreorder traversal" );
         tree.preorderTraversal();

         System.out.println ( "\n\nInorder traversal" );
         tree.inorderTraversal();

         System.out.println ( "\n\nPostorder traversal" );
         tree.postorderTraversal();
         System.out.println();
      }

      return true;
   }
}
