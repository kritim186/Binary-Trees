public class LowestCommonAncestorOptimised {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
//Idea is that "first ancestor which has both n1 and n2 in its subtree."

    public static Node lca(Node root, int n1, int n2){
        if(root == null) return null;

        if(root.data == n1 || root.data == n2) return root;

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if(left == null) return right;
        if(right == null) return left;

        return root;
    }
    public static void main(String[] args) {
        
          /*

         1
        / \
       2   3
      / \   \
     4   5   6

         */

         Node root = new Node(1);
         root.left = new Node(2);
         root.left.left = new Node(4);
         root.left.right = new Node(5);
         root.right = new Node(3);
         root.right.right = new Node(6);

         System.out.println(lca(root, 4, 5).data);
    }
    
}
