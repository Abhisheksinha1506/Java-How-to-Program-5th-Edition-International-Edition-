// Class StackComposition definition with composed List object
class StackComposition {
   private List s;

   public StackComposition() { s = new List( "stack" ); }
   public void push( Object o ) { s.insertAtFront( o ); }
   public Object pop() throws EmptyListException
      { return s.removeFromFront(); }
   public boolean isEmpty() { return s.isEmpty(); }
   public void print() { s.print(); }
}

