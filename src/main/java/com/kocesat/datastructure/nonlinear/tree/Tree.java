package com.kocesat.datastructure.nonlinear.tree;

/**
 * Binary Search Tree implementation
 * For simplicity the values of nodes will be assumed as Integer
 */
public class Tree {
    private static class Node {
        private Integer value;
        private Node leftChild;
        private Node rightChild;

        public Node(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
    private Node root;

    public void insert(int value) {
        Node newNode = new Node(value);
        // if the root is null initialize inserted value as root
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        while (true) {
            if (value == current.value) {
                throw new IllegalArgumentException("Duplicate value");
            } else if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public void traverse(Traversal traversal) {
        switch (traversal) {
            case PRE_ORDER:
                traversePreOrder(root);
                break;
            case IN_ORDER:
                traverseInOrder(root);
                break;
            case POST_ORDER:
                traversePostOrder(root);
                break;
            default:
                // todo: add level order traversal
                throw new UnsupportedOperationException();
        }
    }
    public int min(boolean bst){
        if (root == null) {
            throw new IllegalArgumentException("Empty tree");
        }
        if (bst) {
            Node current = root;
            Node last = root;
            while (current != null) {
                last = current;
                current = current.leftChild;
            }
            return last.value;
        }
        return min(root);
    }
    private int min(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (isLeaf(root)) {
            return root.value;
        }
        var left = min(root.leftChild);
        var right = min(root.rightChild);
        return Math.min(root.value, Math.min(left, right));
    }
    private void traversePreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        return isInRange(root, min, max)
                && isBST(root.leftChild, min, root.value)
                && isBST(root.rightChild, root.value, max);
    }
    private boolean isInRange(Node node, int min, int max) {
        return node.value < max && node.value > min;
    }
    private void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    private void traversePostOrder(Node root) {
        if (root == null) {
            return;
        }
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) {
            return -1;
        }
        if (isLeaf(root)) {
            return 0;
        }
        return 1 + Math.max(
                height(root.leftChild),
                height(root.rightChild)
        );
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public boolean equalsTo(Tree anotherTree) {
        if (anotherTree == null) {
            return false;
        }
        return nodeEquals(root, anotherTree.root);
    }

    private boolean nodeEquals(Node node, Node otherNode) {
        if (node == null && otherNode == null) {
            return true;
        }
        if (node != null && otherNode != null) {
            return node.value.equals(otherNode.value)
                    && nodeEquals(node.leftChild, otherNode.leftChild)
                    && nodeEquals(node.rightChild, otherNode.rightChild);
        }
        return false;
    }

    public void printNodesAtKDistanceFromRoot(int k) {
        printNodesAtKDistance(root, k);
    }
    private void printNodesAtKDistance(Node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.value);
        } else {
            k--;
            printNodesAtKDistance(root.leftChild, k);
            printNodesAtKDistance(root.rightChild, k);
        }
    }
}
