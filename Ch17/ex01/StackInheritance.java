// Class StackInheritance definition
// Derived from class List
class StackInheritance extends List {
   public StackInheritance() { super( "stack" ); }
   public void push( Object o ) { insertAtFront( o ); }
   public Object pop() throws EmptyListException
      { return removeFromFront(); }
   public boolean isEmpty() { return super.isEmpty(); }
   public void print() { super.print(); }
}

