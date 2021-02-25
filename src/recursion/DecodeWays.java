package recursion;

import java.util.Arrays;
/*
 * Given an encoded message as a string, return the number of ways to decode.
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 */
public class DecodeWays {
	    public int solution(String s) {
	        int[] memory = new int[s.length()]; 
	        Arrays.fill(memory,-1);
	        return numDecodeUtil(s, 0, memory);
	    }
	    
	    private int numDecodeUtil(String s, int startIndex, int[] memory){
	        if(startIndex ==  s.length()){
	            return 1;
	        }
	         
	        if(s.charAt(startIndex) == '0'){
	            return 0;
	        }
	        
	        if(memory[startIndex] != -1)
	            return memory[startIndex];
	        
	        int totalWays = numDecodeUtil(s, startIndex+1, memory);
	        
	        if(startIndex+1 < s.length() && Integer.parseInt(s.substring(startIndex,startIndex+2)) <= 26){
	              totalWays += numDecodeUtil(s, startIndex+2, memory);
	        }
	        memory[startIndex] = totalWays;
	        return totalWays;
	    }
	    
	    public static void main(String[] args) {
	    	DecodeWays decodeWays = new DecodeWays();
			
			System.out.println(decodeWays.solution("12"));
			System.out.println(decodeWays.solution("2611055971756562"));
			System.out.println(decodeWays.solution("111111111111111111111111111111111111111111111"));
		}
}
