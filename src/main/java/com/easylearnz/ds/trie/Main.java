package com.easylearnz.ds.trie;

public class Main {
  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("geetha", 0);
    trie.insert("geethe", 0);
    System.out.println(trie.search("Geetha"));
    trie.delete("geetha");
    System.out.println(trie.search("Geetha"));

  }
}
