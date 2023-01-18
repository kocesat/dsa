package com.kocesat.datastructure.nonlinear.graph;

import java.util.*;

public class Graph {
    private static class Node {
        private String label;
        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null) {
            throw new IllegalArgumentException();
        }
        adjacencyList.get(fromNode).add(toNode);
    }

    public void print() {
        for (var source: adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty()) {
                System.out.println(source + " is connected to " + targets);
            }
        }
    }

    public void removeNode(String label) {
        var node = nodes.get(label);
        if (node == null) {
            return;
        }
        for (var n: adjacencyList.keySet()) {
            adjacencyList.get(n).remove(node);
        }
        adjacencyList.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null) {
            return;
        }
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traverseDFSRecursive(String root) {
        var node = nodes.get(root);
        if (node == null) {
            return;
        }
        traverseDFSRecursive(node, new HashSet<>());
    }
    private void traverseDFSRecursive(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);

        adjacencyList.get(root).forEach(n -> {
            if (!visited.contains(n))
                traverseDFSRecursive(n, visited);
        });
    }

    public void traverseDFS(String root) {
        var node = nodes.get(root);
        if (node == null)
            return;
        Set<Node> visited = new HashSet<>();

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            var current = stack.pop();
            System.out.println(current);
            visited.add(current);
            adjacencyList.get(current).forEach(n -> {
                if (!visited.contains(n))
                    stack.push(n);
            });
        }
    }

    public void traverseBFS(String root) {
        var node = nodes.get(root);
        if (node == null)
            return;
        Set<Node> visited = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            var current = queue.poll();
            System.out.println(current);
            visited.add(current);

            for (var neighbor: adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }

    }
}
















