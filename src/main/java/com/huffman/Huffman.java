package com.huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Huffman {
    private String text;
    private Node root;
    private Map<Character,Integer> charFrequencies;
    private Map<Character,String> huffmanCodes;


    public Huffman(String text){
        this.huffmanCodes=new HashMap<>();
       this.text=text;
       fillCharFrequencies();
    }

    private void fillCharFrequencies() {
        charFrequencies=new HashMap<>();
        for(char c:text.toCharArray()){
            System.out.println(c);
            if(charFrequencies.containsKey(c)){
                charFrequencies.put(c,charFrequencies.get(c)+1);
            }
            else {
                charFrequencies.put(c,1);
            }
        }
    }
    public String encode(){

        StringBuilder str =new StringBuilder();
        Queue<Node> q=new PriorityQueue<>();
        charFrequencies.forEach((character,freq)->{
            q.add(new Leaf(character,freq));
        });
        while(q.size()>1){
            q.add(new Node(q.poll(),q.poll()));
        }
        root=q.poll();
        generateHufmanCodes(root,"");

        for(char c:text.toCharArray()) {
           str.append(huffmanCodes.get(c));
        }
        return str.toString();
    }

    private void generateHufmanCodes(Node node, String code) {
        if(node instanceof Leaf)
        {
            if(code==""){

                huffmanCodes.put(((Leaf)node).getCHAR(),"0");
                return;
            }
            huffmanCodes.put(((Leaf)node).getCHAR(),code);
            return;
        }
      generateHufmanCodes(node.getLefNode(),code.concat("0"));
        generateHufmanCodes(node.getRightNode(),code.concat("1"));
    }
    public String decode(String s){
        StringBuilder str=new StringBuilder();
        Node tmpNode=root;
       for(char c:s.toCharArray()){
           if(huffmanCodes.size()>1)
           tmpNode= c=='0' ? tmpNode.getLefNode():tmpNode.getRightNode();

           if(tmpNode instanceof Leaf){
               str.append(((Leaf) tmpNode).getCHAR());
               tmpNode=root;
           }
       }
       return str.toString();
    }
}