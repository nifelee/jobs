package com.nifelee.lessons;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//길 찾기 게임 (Kakao 2018)
//https://programmers.co.kr/learn/courses/30/lessons/42892
@Slf4j
public class Solution_42892 {

  @Test
  public void test() {
    int[][] nodeinfo = {{5,3}, {11,5}, {13,3}, {3,5}, {6,1}, {1,3}, {8,6}, {7,2}, {2,2}};
    int[][] result = {{7,4,6,9,1,8,5,2,3}, {9,6,5,8,1,4,3,2,7}};

    Assertions.assertThat(solution(nodeinfo)).isEqualTo(result);
  }

  private int index;
  private List<Node> nodeList = new ArrayList<>();
  public int[][] solution(int[][] nodeinfo) {
    int nodeCount = nodeinfo.length;

    for (int i=0; i<nodeCount; i++) {
      Node node = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
      nodeList.add(node);
    }

    nodeList.sort(compY);
    Node root = nodeList.get(0);
    for (int i=1; i<nodeCount; i++) {
      addNode(root, nodeList.get(i));
    }

    int[][] answer = new int[2][nodeCount];
    preOrder(answer, root);

    index = 0;
    postOrder(answer, root);

    return answer;
  }

  private void preOrder(int[][] answer, Node node) {
    if (node == null) return;

    answer[0][index++] = node.index;
    preOrder(answer, node.leftNode);
    preOrder(answer, node.rightNode);
  }

  private void postOrder(int[][] answer, Node node) {
    if (node == null) return;

    postOrder(answer, node.leftNode);
    postOrder(answer, node.rightNode);
    answer[1][index++] = node.index;
  }

  private void addNode(Node parent, Node child) {
    if (parent.x > child.x) {
      if (parent.leftNode == null) {
        parent.leftNode = child;
      } else {
        addNode(parent.leftNode, child);
      }
    } else {
      if (parent.rightNode == null) {
        parent.rightNode = child;
      } else {
        addNode(parent.rightNode, child);
      }
    }
  }

  private Comparator<Node> compY = (n1, n2) -> {
    if (n2.y == n1.y) {
      return n1.x - n2.x;
    } else {
      return n2.y - n1.y;
    }
  };

  @ToString
  @RequiredArgsConstructor
  private static class Node {
    final int index;
    final int x;
    final int y;

    Node leftNode;
    Node rightNode;
  }

}
