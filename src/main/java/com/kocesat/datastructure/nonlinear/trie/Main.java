package com.kocesat.datastructure.nonlinear.trie;

public class Main {

  public static void main(String[] args) {
    var trie = new Trie();
    trie.insert("car");

    System.out.println(trie.longestCommonPrefix());
  }
}
