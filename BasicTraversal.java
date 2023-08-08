package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BasicTraversal{
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


    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data+" ");
        
        preorder(root.left);
        preorder(root.right);

        

    }
    public static void inorder(Node root){
        if(root==null){
            
            return;
        }
        // System.out.println(root.data+" ");
        
        inorder(root.left);
        System.out.println(root.data+" ");
        inorder(root.right);
 
        

    }
    public static void postorder(Node root){
        if(root==null){
            return;
        }
        // System.out.println(root.data+" ");
        
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data+" ");

        

    }

    public static void levelorder(Node root){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            root=q.remove();
            // System.out.print(root.data+" ");

            if(root==null){
                System.out.println();
                if(q.isEmpty()){
                    break;

                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(root.data+" ");
                if(root.left!=null){
                    q.add(root.left);

                }
                if(root.right!=null){
                    q.add(root.right);
                    
                }
            }
            
           
                   
            

        }
    }
        
        
       

        

    

    

    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,3,-1,-1,5,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node t=tree.buildtree(nodes);
        // System.out.println(t.data);
        preorder(t);
        System.out.println();
        inorder(t);
        System.out.println();
        postorder(t);
        System.out.println();
        levelorder(t);
    }
}
