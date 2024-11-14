package com.easylearnz.ds.trees;

public class BinarySearchTree {
  private Node root;

  public static class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public Node getLeft() {
      return left;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public Node getRight() {
      return right;
    }

    public void setRight(Node right) {
      this.right = right;
    }

    @Override
    public String toString() {
      return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
    }

  }

  public Node getRoot() {
    return root;
  }

  public void insert(int value) {
    Node newNode = new Node(value);
    if (root == null) {
      root = newNode;
      return;
    }
    Node currentNode = root;
    while (currentNode != null) {
      if (currentNode.value > value) {
        if (currentNode.left == null) {
          currentNode.left = newNode;
          break;
        }
        currentNode = currentNode.left;
      } else if (currentNode.value < value) {
        if (currentNode.right == null) {
          currentNode.right = newNode;
          break;
        }
        currentNode = currentNode.right;
      }
    }
  }

  @Override
  public String toString() {
    return "BinarySearchTree [root=" + root + "]";
  }

}
