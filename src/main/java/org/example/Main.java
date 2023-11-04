package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] map = {
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0}
        };

        ArrayList<Integer> start = new ArrayList<>(Arrays.asList(0,0));
        ArrayList<Integer> end = new ArrayList<>(Arrays.asList(7,6));

        AStarAlgorithm starAlgorithm = new AStarAlgorithm();
        ArrayList<ArrayList<Integer>> path = starAlgorithm.findPath(map,start,end);
        starAlgorithm.printPath(path);

    }
}