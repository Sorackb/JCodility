/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lucassouza.jcodility.exam;

/**
 *
 * @author Lucas
 */
public class Tree {

  public int x;
  public Tree l;
  public Tree r;

  public static Tree createTree() {
    Tree node = new Tree();
    node.x = 4;
    node.l = new Tree();
    node.l.x = 5;
    node.l.l = new Tree();
    node.l.l.x = 4;
    node.l.l.l = new Tree();
    node.l.l.l.x = 5;
    node.r = new Tree();
    node.r.x = 6;
    node.r.l = new Tree();
    node.r.l.x = 1;
    node.r.r = new Tree();
    node.r.r.x = 6;

    return node;
  }
}
