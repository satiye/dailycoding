package trie;

import java.util.Arrays;

public class TrieNode {
	int count;
	TrieNode[] children;
    
	TrieNode() {
        this.count = 0;
        this.children = new TrieNode[26];
        Arrays.fill(children, null);
    }
    
    public void insert(TrieNode current, String value) {

        for(char c : value.toCharArray()) {
            int index = c - 'a';
            
            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            
            current.children[index].count++;
            current = current.children[index];
        }
    }
}
