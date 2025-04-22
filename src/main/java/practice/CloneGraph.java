package practice;
import java.util.*;



class Node2 {
    public int val;
    public List<Node2> neighbors;
    public Node2() {
        val = 0;
        neighbors = new ArrayList<Node2>();
    }
    public Node2(int _val) {
        val = _val;
        neighbors = new ArrayList<Node2>();
    }
    public Node2(int _val, ArrayList<Node2> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph {

   /* public Node2 cloneGraph(Node2 node) {
        if(node==null)
            return node;
        Node2 node2= new Node2();
        node2.val=node.val;
        node2.neighbors= dfsCloneGraph(node.neighbors);
        return node2;
    }

    private List<Node2> dfsCloneGraph(List<Node2> neighbors) {
        List<Node2> newNeighbors = new ArrayList<>();
        for(Node2 node2:neighbors){
            Node2 node22= new Node2();
            node22.val=node2.val;
            node22.neighbors=dfsCloneGraph(node2.neighbors);
            newNeighbors.add(node22);
        }
        return newNeighbors;

    }*/
   private HashMap<Node2, Node2> visited = new HashMap<>();
    public Node2 cloneGraph(Node2 node) {
        if(node==null)
            return null;
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node2 cloneNode = new Node2(node.val, new ArrayList<>());
        visited.put(node, cloneNode);
        for(Node2 neighbor:node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
     
        return cloneNode;
    }
}
