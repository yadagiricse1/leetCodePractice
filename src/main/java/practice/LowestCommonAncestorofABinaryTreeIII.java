package practice;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorofABinaryTreeIII {

   /* class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }*/

    public Node1 lowestCommonAncestor(Node1 p, Node1 q){
        Node1 a = p;
        Node1 b =q;
        while(a!=b){
            a=a==null?p:a.parent;
            b=b==null?q:b.parent;
        }
        return a;
    }


    public Node1 lowestCommonAncestor1(Node1 p, Node1 q) {
        List<Node1> parents = new ArrayList<>();
        while(p!=null){
            parents.add(p);
            p=p.parent;
        }
        Node1 result = null;
        while(q!=null){
            if(parents.contains(q)){
                return q;
            } else {
                q =q.parent;
            }


        }

     return null;
    }
}
