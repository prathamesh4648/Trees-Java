package Trees;

import java.lang.reflect.Array;
import java.util.*;

public class IterativePreOrder {
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
    public static ArrayList<Integer> it_inorder(Node root){
        ArrayList<Integer> l=new ArrayList<Integer>();
        
        
        Stack <Node> s1=new Stack<Node>();
        while(true){
            if(root!=null){
                s1.push(root);
                root=root.left;

            }
            else{
                if(s1.isEmpty()){
                    break;
                }
                else{
                    root=s1.pop();
                    l.add(root.data);
                    root=root.right;
                }
            }
        }
        return l;
    }
    
    public static ArrayList<Integer> it_postorder(Node r){
        ArrayList<Integer> l=new ArrayList<Integer>();
        
        
        Stack <Node> s1=new Stack<Node>();
        Stack <Node> s2=new Stack<Node>();
        s1.push(r);
        while(!s1.isEmpty()){
            Node root=s1.pop();
            if(root.left!=null){
                s1.push(root.left);
                
            }
            if(root.right!=null){
                s1.push(root.right);
                
            }
            l.add(root.data);
            s2.push(root);

        }        

        return l;
        
        
    }

    public static ArrayList<Integer> it_pre(Node root){
        Stack <Node> s=new Stack<Node>();
        ArrayList<Integer> l=new ArrayList<>();
        s.push(root);
        if(root==null){return l;}
        
        // s.push(null);
        while(!s.isEmpty()){
            
            Node x=s.pop();
            
            l.add(x.data);
            if(x.right!=null){
                s.push(x.right);
            }
            if(x.left!=null){
                s.push(x.left);
            }
        }


        return l;
        
            

        
    }

    

    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,7,-1,8,-1,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node t=tree.buildtree(nodes);
        System.out.println(it_pre(t));
        System.out.println(it_inorder(t));
        System.out.println(it_postorder(t));
    }    
}