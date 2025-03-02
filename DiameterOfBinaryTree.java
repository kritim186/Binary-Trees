class DiameterOfBinaryTree{
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root){
        if(root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
     }

     public static int diameter(Node root){
        if(root == null) return 0;

        int leftDia = diameter(root.left);
        int rightDia = diameter(root.right);
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int diaRoot = leftHeight + rightHeight + 1;
        return Math.max(Math.max(leftDia, rightDia), diaRoot);
     }

     public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

        System.out.println(diameter(root));

     }
}