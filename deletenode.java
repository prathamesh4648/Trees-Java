package Trees;

import java.util.ArrayList;

public class deletenode {
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

    public static Node deleete(Node root,int k){
        if(root==null){
            return null;

        }
        if(root.data==k){
            helper(root);
        }

        Node dummy=root;
        while(root!=null){
            if(root.data>k){
                if(root.left!=null && root.left.data==k ){
                    root.left=helper(root.left);
                    break;
                }
                else{
                    root=root.left;
                }
            }
            else{
                if(root.right!=null && root.right.data==k){
                    root.right=helper(root.right);
                    break;
                }
                else{
                    root=root.right;
                }
            }
        }
        return dummy;
    }
    public static Node helper(Node root){
        Node dum =root;
        if(root.left==null){
            return root.right;

        }
        if(root.right==null){
            return root.left;

        }
        if(root.left!=null && root.right!=null){
            Node x=root.left;
            Node y=travright(x);
            y.right=dum.right;
            

        }
        return dum.left;
    }
    public static Node travright(Node root){
        while(root.right!=null){
            root=root.right;

        }
        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            
            return;
        }
        
        // System.out.println(root.data+" ");
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    // inorder of BST is sorted 

    public static void inorder(Node root,int ans,int k){
        if(root==null){
            
            return;
        }
        
        // System.out.println(root.data+" ");
        
        inorder(root.left,ans,k);
        k--;
        if(k==0){
            ans=root.data;
            k=10000;
        }
        
        // System.out.print(root.data+" ");
        inorder(root.right,ans,k);
    }


    public static int ksmall(Node root,int k){
        
        int ans=0;
        inorder(root,ans,k);
        return ans;
    }

    public static void main(String args[]){
        Node root = new Node(8);
        root . left = new Node(5);
        root . left . left = new Node(4);
        root . left . right = new Node(7);
        root . left . right . left = new Node(6);
        root . right = new Node(12);
        root . right . left = new Node(10);
        root . right . right = new Node(14);
        root . right . right . left = new Node(13);

        inorder(root);
        System.out.println();
        inorder(deleete(root, 7));
        System.out.println();

        System.out.println(ksmall(root,3));

        
    }
}
