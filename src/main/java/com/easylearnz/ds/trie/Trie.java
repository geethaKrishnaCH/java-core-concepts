package com.easylearnz.ds.trie;

public class Trie {
  private TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  public TrieNode getRoot() {
    return root;
  }

  public void setRoot(TrieNode root) {
    this.root = root;
  }

  public int getIndex(char c) {
    return c - 'a';
  }

  public void insert(String word, int value) {
    if (word == null) {
      System.out.println("Null cannot be inserted");
      return;
    }
    word = word.toLowerCase();
    TrieNode currentNode = root;
    for (int i = 0; i < word.length(); i++) {
      int index = getIndex(word.charAt(i));
      if (currentNode.getChild(index) == null) {
        currentNode.insertChild(new TrieNode(), index);
      }
      currentNode = currentNode.getChild(index);
    }

    currentNode.setWordEnd(true);
  }

  public boolean search(String word) {
    word = word.toLowerCase();
    if (word == null) {
      return false;
    }
    TrieNode current = this.root;
    for (int i = 0; i < word.length(); i++) {
      int index = getIndex(word.charAt(i));
      if (current.getChild(index) == null) {
        return false;
      }
      current = current.getChild(index);
    }
    if (current.isWordEnd())
      return true;
    return false;
  }

  public void delete(String word) {
    if (search(word)) {
      deleteUtil(word, root, 0);
    }
  }

  private boolean hasChildren(TrieNode node) {
    for (int i = 0; i < node.getChildren().length; i++) {
      if (node.getChild(i) != null)
        return true;
    }
    return false;
  }

  private void deleteUtil(String word, TrieNode node, int level) {
    int index = getIndex(word.charAt(level));
    // for last letter set isWordEnd as false
    if (level == word.length() - 1 && node.isWordEnd()) {
      node.setWordEnd(false);
    }

    TrieNode nextNode = null;

    if (level < word.length() - 1) {
      nextNode = node.getChild(index);
      deleteUtil(word, nextNode, level + 1);
    } else {

    }

    if (nextNode == null && !hasChildren(node)) {
      node.removeChild(index);
    }
  }

}
