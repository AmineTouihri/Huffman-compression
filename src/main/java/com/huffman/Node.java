package com.huffman;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Node implements Comparable<Node>{
private final int frequency;
  public Node lefNode;
  public Node rightNode;
 
  public Node(Node lefNode,Node rightNode){

    this.frequency=lefNode.getFrequency()+rightNode.getFrequency();
   this.lefNode=lefNode;
   this.rightNode=rightNode;

  }

  @Override
    public int compareTo(Node n){

      return this.frequency-n.getFrequency();

  }
}
