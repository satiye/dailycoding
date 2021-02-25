package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * We're going to make our own Contacts application! The application must perform two types of operations:

add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting with  and print the count on a new line.
Given  sequential add and find operations, perform each operation in order.

Sample Input
add hack
add hackerrank
find hac
find hak
Sample Output
2
0

 */
public class Contacts {
    static int[] contacts(String[][] queries) {
    	TrieNode trie = new TrieNode();
        List<Integer> outputList = new ArrayList<Integer>();
        
        for(String[] query : queries){  
            String operation = query[0];
            String value = query[1];
            
            // Insertion Operation
            if(operation.equals("add")) {
                trie.insert(trie, value);
            }
            else { // Search Operation
            	TrieNode currentNode = trie;
                
                // Traverse through each level
                for(char c : value.toCharArray()) {
                    // Maintain a reference to the Node matching the char for that level
                    currentNode = currentNode.children[c - 'a'];
                    
                    if(currentNode == null) {
                        break;
                    }
                }
                
                // Print the number of results
                outputList.add((currentNode != null) ? currentNode.count : 0);
            }
        }
        
        return outputList.stream().mapToInt(i -> i).toArray(); 
    }

  
    public static void main(String[] args) {
        System.out.println(Arrays.toString(contacts(new String[][]{{"add", "hack"}, {"add", "hackerrank"},{"find", "hac"}, {"find", "hak"}})));
    }
}
