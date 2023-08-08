
package Trees;

import java.util.*;

public class bulidtree {
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
    public Node buildtree(int []preorder,int inorder[]){
        HashMap <Integer,Integer> inorderseq = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            inorderseq.put(inorder[i],i);

        }

        Node x= build(inorder,0,inorder.length-1,preorder,0,preorder.length-1,inorderseq);

        return x;
    }
    public Node build(int []inorder,int instart,int inend,int []preorder,int prestart,int preend ,HashMap<Integer,Integer> inorderseq){

        Node root=new Node(preorder[prestart]);

        int inroot= inorderseq.get(root.data);
        int numsleft=inroot-instart;

        root.left=build(inorder,inroot-1,inorder.length-1,preorder,prestart+1,prestart+numsleft,inorderseq);
        root.right=build(inorder,inroot+1,inorder.length-1,preorder,prestart+1+numsleft,preorder.length-1,inorderseq);

        return root; 



    }
}
