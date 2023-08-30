package com.kocesat.datastructure.nonlinear.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Trie {

  private class Node {
    private char value;
    private HashMap<Character, Node> children = new HashMap<>();
    private boolean isEndOfWord;

    public Node(char value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "value=" + value;
    }

    public boolean hasChild(char ch) {
      return children.containsKey(ch);
    }

    public void addChild(char ch) {
      children.put(ch, new Node(ch));
    }

    public Node getChild(char ch) {
      return children.get(ch);
    }

    public Node[] getChildren() {
      return children.values().toArray(new Node[0]);
    }

    public boolean hasChildren() {
      return !children.isEmpty();
    }

    public void removeChild(char ch) {
      children.remove(ch);
    }
  }

  private Node root = new Node(' ');

  public void insert(String word) {
    var current = root;
    for (var ch : word.toCharArray()) {
      if (!current.hasChild(ch))
        current.addChild(ch);
      current = current.getChild(ch);
    }
    current.isEndOfWord = true;
  }

  public boolean contains(String word) {
    if (word == null || word.isEmpty()) {
      return false;
    }
    Node current = root;
    for (char ch: word.toCharArray()) {
      if (!current.hasChild(ch)) {
        return false;
      }
      current = current.getChild(ch);
    }
    return current.isEndOfWord;
  }

  public String longestCommonPrefix() {
    StringBuilder prefixBuilder = new StringBuilder();
    longestCommonPrefix(root, prefixBuilder);
    return prefixBuilder.toString().strip();
  }

  private void longestCommonPrefix(Node current, StringBuilder prefixBuilder) {
    prefixBuilder.append(current.value);
    Node[] children = current.getChildren();
    if (children.length == 1 && !current.isEndOfWord) {
      Node child = children[0];
      longestCommonPrefix(child, prefixBuilder);
    }
  }

  public int countWords() {
    AtomicInteger counter = new AtomicInteger(0);
    countWords(root, counter);
    return counter.get();
  }

  private void countWords(Node current, AtomicInteger counter) {
    if (current.isEndOfWord)
      counter.incrementAndGet();
    for (var child : current.getChildren()) {
      countWords(child, counter);
    }
  }

  public boolean containsRecursive(String word) {
    if (word == null) {
      return false;
    }
    return containsRecursive(root, word, 0);
  }

  private boolean containsRecursive(Node current, String word, int index) {
    if (index == word.length())
      return current.isEndOfWord;
    var ch = word.charAt(index);
    var child = current.getChild(ch);
    if (child == null) {
      return false;
    }
    return containsRecursive(child, word, index + 1);

  }

  public void traverse() {
    traverse(root);
  }

  private void traverse(Node root) {
    // pre-order: visit the root first
    System.out.println(root.value);

    for (var child : root.getChildren()) {
      traverse(child);
    }
  }

  public void remove(String word) {
    if (word == null || word.isEmpty()) {
      return;
    }
    remove(root, word, 0);
  }

  private void remove(Node root, String word, int index) {
    if (index == word.length()){
      root.isEndOfWord = false;
      return;
    }

    var ch = word.charAt(index);
    var child = root.getChild(ch);
    if (child == null) {
      return;
    }

    remove(child, word, index + 1);

    if (!child.hasChildren() && !child.isEndOfWord) {
      root.removeChild(child.value);
    }
  }

  public List<String> findWords(String prefix) {
    if (prefix == null || prefix.isEmpty()) {
      return Collections.emptyList();
    }
    Node lastNode = findLastNodeOf(prefix);
    List<String> words = new ArrayList<>();
    findWords(lastNode, prefix, words);
    return words;
  }

  private Node findLastNodeOf(String prefix) {
    Node current = root;

    for (var ch : prefix.toCharArray()) {
      Node child = current.getChild(ch);
      if (child == null) {
        return null;
      }
      current = child;
    }
    return current;
  }


  private void findWords(Node current, String prefix, List<String> words) {
    if (current == null) {
      return;
    }
    if (current.isEndOfWord) {
      words.add(prefix);
    }
    for (var child : current.getChildren()) {
      findWords(child, prefix + child.value, words);
    }
  }
}
