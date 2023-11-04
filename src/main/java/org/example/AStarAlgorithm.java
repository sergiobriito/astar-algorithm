package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarAlgorithm {
    private ArrayList<ArrayList<Integer>> squares = new ArrayList<>() {{
        add(new ArrayList<>() {{ add(0); add(-1); }});
        add(new ArrayList<>() {{ add(0); add(1); }});
        add(new ArrayList<>() {{ add(-1); add(0); }});
        add(new ArrayList<>() {{ add(1); add(0); }});
        add(new ArrayList<>() {{ add(-1); add(-1); }});
        add(new ArrayList<>() {{ add(-1); add(1); }});
        add(new ArrayList<>() {{ add(1); add(-1); }});
        add(new ArrayList<>() {{ add(1); add(1); }});
    };};

    public AStarAlgorithm(){};

    public void reversePath(ArrayList<ArrayList<Integer>> arr){
        int l = 0;
        int r = arr.size() - 1;

        while(l<r){
            ArrayList tmp = arr.get(l);
            arr.set(l,arr.get(r));
            arr.set(r,tmp);
            l++;
            r--;
        };
    };

    public void printPath(ArrayList<ArrayList<Integer>> path){
        for (ArrayList<Integer> cord : path){
            System.out.println("["+cord.get(0)+","+cord.get(1)+"]");
        };
    };

    public ArrayList<ArrayList<Integer>> findPath(int[][] map,ArrayList<Integer> start,ArrayList<Integer> end){
        Node startNode = new Node(null, start);
        Node endNode = new Node(null, end);

        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(node -> node.f));
        ArrayList<Node> closedList = new ArrayList<>();

        openList.add(startNode);

        while (!openList.isEmpty()){

            // Get the current node
            Node currNode = openList.poll();

            // add to closed list
            closedList.add(currNode);

            // Found the goal
            if (currNode.equals(endNode)){
                ArrayList<ArrayList<Integer>> path = new ArrayList<>();
                Node curr = currNode;
                while (curr != null){
                    path.add(curr.position);
                    curr = curr.parent;
                };
                reversePath(path);
                return path;
            };

            // Generate children
            ArrayList<Node> children = new ArrayList<>();

            for (ArrayList<Integer> newPosition : squares){
                Node finalCurrNode = currNode;
                ArrayList<Integer> nodePosition = new ArrayList<>() {{
                    add(finalCurrNode.position.get(0) + newPosition.get(0));
                    add(finalCurrNode.position.get(1) + newPosition.get(1));
                }};

                // Make sure within range
                if (nodePosition.get(0) > map.length - 1
                        || nodePosition.get(0) < 0
                        || nodePosition.get(1) > ((map[map.length-1]).length -1)
                        || nodePosition.get(1) < 0) {
                    continue;
                }

                // Make sure walkable terrain
                if (map[nodePosition.get(0)][nodePosition.get(1)] != 0){
                    continue;
                };

                // Create new node
                Node newNode = new Node(currNode,nodePosition);

                //Add
                children.add(newNode);
            };

            for (Node child : children){

                // Child is on the closed list
                for (Node closedChild : closedList){
                    if (child.equals(closedChild)){
                        continue;
                    };
                };

                // Create the f, g, and h values
                child.g = currNode.g + 1;
                child.h = Math.abs(child.position.get(0) - endNode.position.get(0)) + Math.abs(child.position.get(1) - endNode.position.get(1));
                child.f = child.g + child.h;

                // Child is already in the open list
                for (Node openNode : openList) {
                    if (child.equals(openNode)) {
                        if (child.g > openNode.g) {
                            continue;
                        }

                    }
                }

                // Add the child to the open list
                openList.add(child);
            };
        };

        return new ArrayList<ArrayList<Integer>>();
    };

}
