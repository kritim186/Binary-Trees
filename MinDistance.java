public class MinDistance {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //First find the Lca
    public static Node lca(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2) return root;

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

    //find the distance from lca to n;
    public static int dist(Node lca, int n){
        if(lca == null) return -1;
        if(lca.data == n) return 0;

        int leftDis = dist(lca.left, n);
        int rightDis = dist(lca.right, n);

        if(leftDis == -1 && rightDis == -1) {return -1;}
        else if(rightDis == -1) return leftDis+1;
        else return rightDis+1;

    }

    public static int minDistance(Node root, int n1, int n2){
        Node lca = lca(root, n1, n2);
        int d1 = dist(lca, n1);
        int d2 = dist(lca, n2);

        return d1 + d2;
    }

    public static void main(String[] args) {
                  /*
         1
        / \
       2   3
      / \   \
     4   5   6
minimum distance between 4 and 6 is 4

     */
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

        System.out.println(minDistance(root, 4, 6));
    }
}
