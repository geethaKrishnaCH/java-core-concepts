package com.easylearnz.ds.trees;

public class Main {
  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(2);
    bst.insert(1);
    bst.insert(5);
    bst.insert(8);
    bst.insert(4);
    System.out.println(bst);
  }
}
