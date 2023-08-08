package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class flatten_binarytree {
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
    static Node prev=null;
    public static void flatten(Node root){
        
        if(root==null){
            return ;
        }

        flatten(root.right);
        flatten(root.left);

        root.right=prev;
        root.left=null;
        prev=root;

        
    }
    
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,7,-1,8,-1,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node r=tree.buildtree(nodes);
        flatten(r);
        while((r.right!=null)){
            System.out.print(r.data+ " ");
            r=r.right;
        }
        System.out.print(r.data);
        
    }
}
