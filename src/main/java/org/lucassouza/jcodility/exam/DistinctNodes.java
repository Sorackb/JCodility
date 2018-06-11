package org.lucassouza.jcodility.exam;

import java.util.HashSet;
import java.util.Set;

public class DistinctNodes {

  public int solution(Tree tree) {
    if (tree == null) {
      return 0;
    }

    if (tree.l == null && tree.r == null) {
      return 1;
    }

    return count(tree, new HashSet<>(), 0);
  }

  private int count(Tree node, Set<Integer> list, int max) {
    if (node == null) {
      if (list.size() > max) {
        max = list.size();
      }

      return max;
    }

    list.add(node.x);
    int left = count(node.l, list, max);
    list.add(node.x);
    int right = count(node.r, list, max);

    max = Math.max(left, right);

    if (list.contains(node.x)) {
      list.remove(node.x);
    }

    return max;
  }

  public static void main(String[] args) {
    DistinctNodes nodes = new DistinctNodes();
    Tree t = Tree.createTree();
    System.out.println(nodes.solution(t));

  }
}
