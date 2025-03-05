public class SumOfNodes {
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int sum(Node root){
        if(root == null) return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        return left+right+root.data;
    }
    public static int countNodes(Node root){
        if(root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);
        System.out.println(sum(root));
        System.out.println(countNodes(root));
    }
}
