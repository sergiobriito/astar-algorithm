package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Node {
    public Node parent;
    public ArrayList<Integer> position;
    public int g = 0;
    public int h = 0;
    public int f = 0;

    public Node(Node parent,ArrayList<Integer> position){
        this.parent = parent;
        this.position = position;
    };

    public boolean equals(Node other){
        return Objects.equals(this.position, other.position);
    };
}
