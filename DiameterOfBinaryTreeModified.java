public class DiameterOfBinaryTreeModified {
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Info{
        int dia;
        int ht;
        public Info(int dia, int ht){
            this.dia = dia;
            this.ht = ht;
        }
    }
    public static Info diameter2(Node root){
        if(root == null) return new Info(0,0);
        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);
        int finalDia = Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.ht+rightInfo.ht+1);
        int finalht = Math.max(leftInfo.ht, rightInfo.ht)+1;
        return new Info(finalDia, finalht);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

        System.out.println(diameter2(root).dia);
    }
    
}
