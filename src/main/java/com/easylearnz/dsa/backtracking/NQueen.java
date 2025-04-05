package com.easylearnz.dsa.backtracking;

import java.util.*;

public class NQueen {
    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solve(int n) {
        Set<Position> positions = new LinkedHashSet<>();
        List<Set<Position>> finalPositions = new ArrayList<>();
        solveUtil(0, n, finalPositions, positions);
        for (Set<Position> item: finalPositions) {
            for (Position position: item) {
                System.out.print("(" + position.x + "," + position.y + ")");
            }
            System.out.println();
        }
        return finalPositions.size();
    }

    private static void solveUtil(int i, int n, List<Set<Position>> finalPositions, Set<Position> positions) {
        if (i == n) {
            finalPositions.add(new LinkedHashSet<>(positions));
            return;
        }
        for (int j = 0; j < n; j++) {
            Position newPosition = new Position(i, j);
            if (checkIfValid(newPosition, positions)) {
                positions.add(newPosition);
                solveUtil(i + 1, n, finalPositions, positions);
                positions.remove(newPosition);
            }

        }
    }

    private static boolean checkIfValid(Position newPosition, Set<Position> positions) {
        for (Position position: positions) {
            int dx = newPosition.x - position.x;
            int dy = newPosition.y - position.y;
            if (dx == 0 || dy == 0) return false;
            if (Math.abs(dy/dx) == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solve(4));;
    }
}
