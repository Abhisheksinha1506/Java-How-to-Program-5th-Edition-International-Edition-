// Class QueueInheritance definition
// Derived from List
class QueueInheritance extends List {
   public QueueInheritance() { super( "queue" ); }
   public void enqueue( Object o ) { insertAtBack( o ); }
   public Object dequeue() throws EmptyListException
      { return removeFromFront(); }
   public boolean isEmpty() { return super.isEmpty(); }
   public void print() { super.print(); }
}

