import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


//[[2], [1]]

class Solution {

    // BFS

    // HashMap<Integer, Node>
    Map<Integer, Node> map;

    public Node cloneGraph(Node node) {

        // check edge case
        if (node == null) return null;

        // Queue<Node> queue
        Queue<Node> queue = new LinkedList<>();

        // init queue
        Node root = new Node(node.val);
        queue.offer(node);

        // init map
        map = new HashMap<>();
        map.put(root.val, root);

        // while quque not empty
        while (!queue.isEmpty()) {
            // get the size of currQueue
            int size = queue.size();

            // loop through every node in curr queue
            for (int i = 0; i < size; i++) {
                // loop through all childrens of curr node
                Node curr = queue.poll();
                Node currCpy = map.get(curr.val);

                for (Node child : curr.neighbors) {
                    // if children unvisted 
                    if (!map.containsKey(child.val)) {
                        // add to map
                        Node newNode = new Node(child.val);
                        map.put(child.val, newNode);

                        // add children to queue
                        queue.offer(child);
                    }

                    // add children as neighbor of curr
                    currCpy.neighbors.add(map.get(child.val));
                }


            }

        }
        return root;
    }
}