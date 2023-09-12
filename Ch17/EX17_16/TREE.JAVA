// Class TreeNode definition

class TreeNode {
   TreeNode left;   // left node
   int data;        // data item
   TreeNode right;  // right node

   public TreeNode( int d )
   { 
      data = d;              
      left = right = null;  
   }

   public void insert( int d )
   {
      if ( d < data ) {
         if ( left == null )
            left = new TreeNode( d );
         else
            left.insert( d );
      }
      else if ( d >= data ) {     // adding the = is the only change
         if ( right == null )     // in this program
            right = new TreeNode( d );
         else
            right.insert( d );
      }
   }
}

// Class Tree definition
public class Tree {
   private TreeNode root;

   // Construct an empty Tree of integers
   public Tree() { root = null; }

   // Insert a new node in the binary search tree.
   // If the root node is null, create the root node here.
   // Otherwise, call the insert method of class TreeNode.
   public void insertNode( int d )
   {
      if ( root == null )
         root = new TreeNode( d );
      else
         root.insert( d );
   }

   // Preorder Traversal
   public void preorderTraversal() { preorderHelper( root ); }

   // Recursive method to perform preorder traversal
   private void preorderHelper( TreeNode node )
   {
      if ( node == null )
         return;

      System.out.print( node.data + " " );
      preorderHelper( node.left );
      preorderHelper( node.right );
   }

   // Inorder Traversal
   public void inorderTraversal() { inorderHelper( root ); }

   // Recursive method to perform inorder traversal
   private void inorderHelper( TreeNode node )
   {
      if ( node == null )
         return;

      inorderHelper( node.left );
      System.out.print( node.data + " " );
      inorderHelper( node.right );
   }

   // Postorder Traversal
   public void postorderTraversal() { postorderHelper( root ); }

   // Recursive method to perform postorder traversal
   private void postorderHelper( TreeNode node )
   {
      if ( node == null )
         return;

      postorderHelper( node.left );
      postorderHelper( node.right );
      System.out.print( node.data + " " );
   }
}
