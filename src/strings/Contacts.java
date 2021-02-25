package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
    	HashMap<String, Integer> map = new HashMap<>();
        List<Integer> outputList = new ArrayList<Integer>();
        
        for(String[] query : queries){  
            String operation = query[0];
            String value = query[1];
            
            // Insertion Operation
            if(operation.equals("add")) {
            	for(int i=1; i <= value.length(); i++) {
            		String subStr = value.substring(0,i);
            		map.put(subStr, map.getOrDefault(subStr, 0)+1);
            	}
            }
            else { // Search Operation
                outputList.add((map.containsKey(value)) ? map.get(value) : 0);
            }
        }
        
        return outputList.stream().mapToInt(i -> i).toArray(); 
    }

  
    public static void main(String[] args) {
        System.out.println(Arrays.toString(contacts(new String[][]{{"add", "hack"}, {"add", "hackerrank"},{"find", "hac"}, {"find", "hak"}})));
    }
}
