import java.util.ArrayList;

public class LowestCommonAncestor {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    //First find the Path from root till N
    public static boolean getPath(ArrayList<Node> list, int n, Node root){
        if(root == null) return false;

        list.add(root);
        if(root.data == n) return true;

        boolean foundLeft = getPath(list, n, root.left);
        boolean foundRight = getPath(list, n, root.right);

        if(foundLeft || foundRight) return true;

        list.remove(list.size() - 1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2){
       ArrayList<Node> path1 = new ArrayList<>();
       ArrayList<Node> path2 = new ArrayList<>();

       getPath(path1, n1, root);
       getPath(path2, n2, root);
        int i = 0;
       for(; i < path1.size() && i < path2.size(); i++){
            if(path1.get(i) != path2.get(i)) break;
       }

       return path1.get(i-1);

    }

    public static void main(String[] args) {
          /*

         1
        / \
       2   3
      / \   \
     4   5   6
     lca of 4 and 5 is 2

         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

        System.out.println(lca(root, 4, 6).data);
    }
}
