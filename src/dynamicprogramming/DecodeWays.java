package dynamicprogramming;

public class DecodeWays {
	  public int solution(String s) {
	        int[] dp = new int[s.length()+1]; 
	        dp[0] = 1;
	        dp[1] = s.charAt(0) == '0' ? 0 : 1;

	        for(int i=2; i < s.length()+1; i++) {
	        	int first = Integer.valueOf(s.substring(i-1, i));
	            int second = Integer.valueOf(s.substring(i-2, i));
	            
	            if(first >= 1 && first <= 9) {
	               dp[i] += dp[i-1];  
	            }
	            if(second >= 10 && second <= 26) {
	                dp[i] += dp[i-2];
	            }
	        }
	        
	        return dp[s.length()];
	    }
	    
	    public static void main(String[] args) {
	    	DecodeWays decodeWays = new DecodeWays();
			
			System.out.println(decodeWays.solution("12"));
			System.out.println(decodeWays.solution("2611055971756562"));
			System.out.println(decodeWays.solution("111111111111111111111111111111111111111111111"));
		}
}
