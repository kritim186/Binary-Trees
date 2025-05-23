import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopView {
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    static class Info{
        int hd;
        Node node;
        Info(int hd, Node node){
            this.hd = hd;
            this.node = node;
        }
    }
    public static void topView(Node root){
        // Level Order
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min=0, max = 0;
        q.add(new Info(0, root));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()) break;
                else q.add(null);
            }else{

            if(!map.containsKey(curr.hd)){ // Check if map has unique hd
                map.put(curr.hd, curr.node);
            }

            if(curr.node.left != null){
                q.add(new Info(curr.hd-1, curr.node.left));
                min = Math.min(min, curr.hd-1);
            }
            if(curr.node.right != null){
                q.add(new Info(curr.hd+1, curr.node.right));
                max = Math.max(max, curr.hd+1);
            }
        }

        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");            
        }
    }
    public static void main(String[] args) {
         /*

         1
        / \
       2   3
      / \   \
     4   5   6
     // Top view - 4 2 1 3 6

         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

        topView(root);
    }
    
}
