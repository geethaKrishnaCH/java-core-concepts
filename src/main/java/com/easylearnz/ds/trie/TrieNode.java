package com.easylearnz.ds.trie;

import java.util.Arrays;

public class TrieNode {
  private char letter;
  private TrieNode[] children;
  private boolean isWordEnd;

  public TrieNode() {

    this.isWordEnd = false;
    this.children = new TrieNode[26];
  }

  public char getLetter() {
    return letter;
  }

  public void setLetter(char letter) {
    this.letter = letter;
  }

  public TrieNode[] getChildren() {
    return children;
  }

  public void setChildren(TrieNode[] children) {
    this.children = children;
  }

  public void removeChild(int index) {
    this.children[index] = null;
  }

  public boolean isWordEnd() {
    return isWordEnd;
  }

  public void setWordEnd(boolean isWordEnd) {
    this.isWordEnd = isWordEnd;
  }

  public void insertChild(TrieNode node, int idx) {
    this.children[idx] = node;
  }

  public TrieNode getChild(int idx) {
    return this.children[idx];
  }

  @Override
  public String toString() {
    return "TrieNode [letter=" + letter + ", children=" + Arrays.toString(children) + ", isWordEnd=" + isWordEnd + "]";
  }

}
