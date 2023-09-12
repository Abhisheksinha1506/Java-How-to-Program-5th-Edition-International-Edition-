// Class ListNode definition
class ListNode {
   // friendly data so class List can access it directly
   Object data;    
   ListNode next;

   // Constructor: Create a ListNode that refers to Object o.
   ListNode( Object o )
   {
      data = o;     // this node refers to Object o
      next = null;  // set next to null
   }

   // Constructor: Create a ListNode that refers to Object o and
   // to the next ListNode in the List.
   ListNode( Object o, ListNode nextNode )
   {
      data = o;         // this node refers to Object o
      next = nextNode;  // set next to refer to next
   }

   // Return the Object in this node
   Object getObject() { return data; }

   // Return the next node
   ListNode getNext() { return next; }
}

// Class List definition
class List {
   private ListNode firstNode;
   private ListNode lastNode;
   private String name;  // String like "list" used in printing

   // Constructor: Construct an empty List with s as the name
   public List( String s )
   {
      name = s;
      firstNode = lastNode = null;
   }

   // Constructor: Construct an empty List with
   // "list" as the name
   public List() { this( "list" ); }                             

   // Insert an Object at the front of the List
   // If List is empty, firstNode and lastNode refer to
   // same Object. Otherwise, firstNode refers to new node.
   public void insertAtFront( Object insertItem )
   {
      if ( isEmpty() )
         firstNode = lastNode = new ListNode( insertItem );
      else 
         firstNode = new ListNode( insertItem, firstNode );
   }

   // Insert an Object at the end of the List
   // If List is empty, firstNode and lastNode refer to
   // same Object. Otherwise, lastNode's next instance
   // variable refers to new node.
   public void insertAtBack( Object insertItem )
   {
      if ( isEmpty() )
         firstNode = lastNode = new ListNode( insertItem );
      else 
         lastNode = lastNode.next = new ListNode( insertItem );
   }

   // Remove the first node from the List.
   public Object removeFromFront() throws EmptyListException
   {
      Object removeItem = null;

      if ( isEmpty() )
         throw new EmptyListException( name );

      removeItem = firstNode.data;  // retrieve the data

      // reset the firstNode and lastNode references
      if ( firstNode.equals( lastNode ) )
         firstNode = lastNode = null;
      else
         firstNode = firstNode.next;

      return removeItem;  
   }

   // Remove the last node from the List.
   public Object removeFromBack() throws EmptyListException
   {
      Object removeItem = null;

      if ( isEmpty() )
         throw new EmptyListException( name );

      removeItem = lastNode.data;  // retrieve the data

      // reset the firstNode and lastNode references
      if ( firstNode.equals( lastNode ) )
         firstNode = lastNode = null;
      else {
         ListNode current = firstNode;

         while ( current.next != lastNode )
            current = current.next;
   
         lastNode = current;
         current.next = null;
      }

      return removeItem;
   }

   // Return true if the List is empty
   public boolean isEmpty() { return firstNode == null; }

   // Output the List contents
   public void print()
   {
      if ( isEmpty() ) {
         System.out.println( "Empty " + name );
         return;
      }

      System.out.print( "The " + name + " is: " );

      ListNode current = firstNode;

      while ( current != null ) {
         System.out.print( current.data.toString() + " " );
         current = current.next;
      }

      System.out.println();
      System.out.println();
   }

   public ListNode getFirstNode() { return firstNode; }
}

// Class EmptyListException definition
class EmptyListException extends RuntimeException {
   public EmptyListException( String name )
   {
      super( "The " + name + " is empty" );
   }
}

