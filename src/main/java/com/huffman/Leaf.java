package com.huffman;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Leaf extends Node{

    private char  CHAR;

    public Leaf(char character,int frequency) {
        super(frequency);
        CHAR=character;
    }
}