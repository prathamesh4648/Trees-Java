package Trees;
    
public class search_BST {
   static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;

        } 
    }

    public static Node found(Node root,int t){
        
        while(root!=null && root.data!=t){
            if(root.data<t){
                root=root.right;
            }
            if(root.data>t){
                root=root.left;
            }
        }
        return root;
    }

    public static int ceil(Node root,int k){
        int min=Integer.MAX_VALUE;
        
        while(root!=null ){
            if(root.data==k){
                min=root.data;
                return min;
            }
            
            
            if(root.data<k){
                
                
                root=root.right;

            }
            else{
                
                min=root.data;
                root=root.left;
            }
        }
        return min ;

    }
    public static int floor(Node root,int f){
        int floor=Integer.MIN_VALUE;

        while(root!=null){
            if(root.data==f){
                floor=root.data;
                return floor;
            }
            else if(root.data<f){
                floor=root.data;
                root=root.right;
            }
            else if(root.data>f){
                root=root.left;
            }
        }
        if(floor==Integer.MIN_VALUE){
            System.out.println("No floor found");
            
        }
        return floor;
    }
    public static Node insert(Node root,int k){
        Node x=new Node(k);
        Node r=root;
        while(true){
            
            if(k < root.data){
                if(root.left==null){
                    root.left=x;
                    break;
                }
                root=root.left;
            }
            else if(k > root.data){
                if(root.right==null){
                    root.right=x;
                    break;
                }
                root=root.right;
             }
        

        }
        return r;

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

        System.out.println(ceil(root, 11));

        System.out.println(found(root, 12).data);
        System.out.println(floor(root,11));
        // System.out.println(insert(root,15));
        
        inorder(insert(root, 15));

    }
}
