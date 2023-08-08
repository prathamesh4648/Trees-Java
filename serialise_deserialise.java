package Trees;
import java.util.*;
public class serialise_deserialise {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;

        }   

    }

    static class BinaryTree{
        static int idx=-1;
        public static Node buildtree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode= new Node(nodes[idx]);
            newNode.left=buildtree(nodes);
            newNode.right=buildtree(nodes);

            return newNode;
        }

    }
    public static String serialise(Node root){
        StringBuilder res=new StringBuilder("");
        Queue<Node> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node x=q.poll();
            if(x==null){
                res.append("# ");
                continue;
            }

            res.append(x.data+ " ");
            q.add(x.left);
            q.add(x.right);


        }
        return res.toString();

    }

    public static Node deserialise(String s){
        String str[]=s.split(" ");
        Queue<Node> q=new LinkedList<>();
        Node x=new Node (Integer.parseInt(str[0]));
        q.add(x);
        for(int i=1;i<str.length;i++){
            Node y=q.poll();
            if(!(str[i].equals("#"))){
                Node left=new Node(Integer.parseInt(str[i]));
                y.left=left;
                q.add(left);

                 
            }

            if(!(str[i++].equals("#"))){
                Node right=new Node(Integer.parseInt(str[i++]));
                y.right=right;
                q.add(right);
            }
        }
        return x;

    }

    public static Node delete(Node root,Node del){
        if(root.data==del.data){
            return null;
        }
        Node prev=null;
        while(root!=null && root.data!=del.data){

            if(root.data<del.data){
                prev=root;

                root=root.right;

            }
            else{
                prev=root;
                root=root.left;
            }
            prev.left=root.left;
            prev.right=root.right;
            return root;
        }   
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,7,-1,8,-1,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node t=tree.buildtree(nodes);
        System.out.println(serialise(t));
    }
}
