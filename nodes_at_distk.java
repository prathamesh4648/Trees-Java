package Trees;
import java.util.*;
public class nodes_at_distk {
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

    public static void markparents(HashMap<Node , Node> mark,Node root){
        Queue<Node> q1=new LinkedList<Node>();
        q1.add(root);

        while(!q1.isEmpty()){
            Node x =q1.poll();
            if(x.left!=null){
                mark.put(x.left,x);
                q1.add(x.left);


            }
            if(x.right!=null){

                mark.put(x.right,x);
                q1.add(x.right);
            }
        }
        
        

    }

    public static List<Integer> distk(Node root,Node target,int k){
        HashMap<Node ,Node> markp=new HashMap<Node,Node>();
        markparents(markp, root);
        HashMap<Node ,Boolean> vis=new HashMap<Node,Boolean>();
        Queue <Node> q=new LinkedList<>();
        q.add(target);
        vis.put(target, true);
        int lvl=0;
        while(!q.isEmpty()){
            
            int size=q.size();
            if(lvl==k){
                break;
            }
            lvl++;
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                if(curr.left!=null && vis.get(curr.left)==null){
                    q.add(curr.left);
                    vis.put(curr.left,true);

                }
                if(curr.right!=null && vis.get(curr.right)==null){
                    q.add(curr.right);
                    vis.put(curr.right,true);
                    
                }
                if(markp.get(curr)!=null && vis.get(markp.get(curr))==null){
                    q.add(markp.get(curr));
                    vis.put(markp.get(curr),true);
                    
                }   
            }



        }
        List<Integer> l=new ArrayList<Integer>();
        while(!q.isEmpty()){
            Node x=q.poll();
            l.add(x.data);
        }
        return l;

    }
    public static int hl(Node root){
        int lvl=0;
        while(root.left!=null){
            lvl++;
            root=root.left;

        }
        return lvl;
    }
    public static int hr(Node root){
        int lvl=0;
        while(root.right!=null){
            lvl++;
            root=root.right;

        }
        return lvl;
    }

    public static int nodes(Node root){
        if(root==null){
            return 0;
        }


        int left=hl(root);
        int right=hr(root );

        if(left==right){
            return (int) Math.pow(2,left) - 1;
        }
        else{
            return nodes(root.left) + nodes(root.right)+1;
        }

    }

    public static void main(String args[]){
        Node x=new Node(6);
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,7,-1,8,-1,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node t=tree.buildtree(nodes);
        System.out.println(distk(t, t, 2));
        System.out.println(nodes(t));
    }
}
