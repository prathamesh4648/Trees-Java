package Trees;

import java.util.*;

import GIT.Hashmap;

public class vertical_order_traversal {
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
    public static class tuple{
        Node node;
        int x;
        int y;
        tuple(Node node, int x, int y){
            this.node=node;
            this.x=x;
            this.y=y;
        }


    }

    public static List<List<Integer>> vertical(Node root ){
        int x1=0;
        int x2=0;
        HashMap<Integer, HashMap<Integer,PriorityQueue<Integer>>> map=new HashMap<>();
        Queue <tuple> q=new LinkedList<tuple>();
        q.add(new tuple(root,0,0));
        while(!q.isEmpty()){
            tuple t=q.poll();
            // q.pop();
            Node n=t.node;
            int x=t.x;
            int y=t.y;

            if(x<x1){
                x1=x;
            }
            
            if(x>x2){
                x2=x;
            }

            if(!map.containsKey(x)){
                map.put(x,new HashMap());

            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }

            map.get(x).get(y).add(n.data);

            if(n.left!=null){
                q.add(new tuple(n.left, x-1, y+1));

            }
            
            if(n.right!=null){
                q.add(new tuple(n.right, x+1, y+1));
                    
            }

        }
       
        List<List<Integer>> list=new ArrayList<>();
        for(HashMap<Integer,PriorityQueue<Integer>> mp:map.values()){
            // mp.entrySet().stream().sorted(Map.Entry.<Integer, PriorityQueue<Integer>>comparingByKey()) ;
            // System.out.println(mp.values());

            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> p:mp.values()){
                while(!p.isEmpty()){
                    System.out.println(p.peek());
                    list.get(list.size() - 1).add(p.poll());
                }
            }
        }
        return list;



    }

    public static class Pair{
        Node node;
        int hd;
        Pair(Node node, int hd){
            this.node = node;
            this.hd=hd;
        }
    }

    public static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>(); 
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0)); 
        while(!q.isEmpty()) {
            Pair it = q.remove();
            int hd = it.hd; 
            Node temp = it.node; 
            if(map.get(hd) == null) map.put(hd, temp.data); 
            if(temp.left != null) {
                
                q.add(new Pair(temp.left, hd - 1)); 
            }
            if(temp.right != null) {
                
                q.add(new Pair(temp.right, hd + 1)); 
            }
        }
    
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
        
    }
    public static boolean sym2(Node root){
        if(root==null || symmbinary(root.left, root.right)){
            return true;
        }
        return false;
    }
    public static boolean symmbinary(Node left,Node right){
        if(left==null || right==null){
            return left==right;
        }
        if(left.data!=right.data){
            return false;

        }

        return symmbinary(left.left, right.right) && symmbinary(left.right, right.left);
      

    }
    
    public static boolean path(Node root,int c,ArrayList<Integer> l)
    {
        if(root==null){
            return false;

        }
        l.add(root.data);
        if(root.data==c){
            return true;

        }

        if(path(root.left,c,l) || path(root.right,c,l) ){
            return true;
        }
        l.remove(l.size()-1);
        return false;
        


    }
    public static Node lowestancestor(Node root,Node p,Node q){
        if(root==null || root==p ||root==q){
            return root;
        }
        Node left=lowestancestor(root.left, p, q);
        Node right=lowestancestor(root.right, p, q);

        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
        }

        else{
            return root;
        }
    }

    // public static void checktree(Node root){
    //     if(root==null){
    //         return ;
    //     }
    //     int child=0;

    //     if(root.left!=null){
    //         child=+root.left.data;

    //     }
    //     if(root.right!=null){
    //         child=+root.right.data;

    //     }



    //     if(child>=root.data)
    //         root.data=child;
    //     }
    //     else{
    //         child=root.data;
    //     }
    //     checktree(root.left);
    //     checktree(root.right);

    //     int tot=0;
    //     if(root.left!=null){
    //         tot=tot+root.left.data;

    //     }
    //     if(root.right!=null){
    //         tot=tot+root.right.data;
    //     }
    //     if(root.left!=null || root.right!=null){
    //         root.data=tot;
    //     }
    //     return ;
    // }

    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,3,-1,-1,5,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node t=tree.buildtree(nodes);
        System.out.println(topView(t)); 
        ArrayList<Integer> l=new ArrayList<Integer>();
        path(t, 6, l);
        System.out.println(l);
        // System.out.println(lowestancestor(t, , t))
        
    }
}

