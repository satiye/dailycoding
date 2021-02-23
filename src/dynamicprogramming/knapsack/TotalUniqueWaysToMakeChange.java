package dynamicprogramming.knapsack;

/*
 * 
 * You are given coins of different denominations and a total amount of money. 
 * Write a function to compute the number of combinations that make up that amount. 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * given  amount = 5, coins = [1, 2, 5] Output: 4
 * given amount = 3, coins = [2] Output: 0
 * given amount = 10, coins = [10] Output: 1
 * 
 * If the highest coin does not exceed the required sum, then 
 * 	the number of ways that the sum can be made will be equal to the number of ways that the same sum can be made without the highest coin + the number of ways in which a value of sum - highest coin can be made.
 * Else, if the highest coin exceeds the required sum, then the number of ways this sum can be made is equal to the number of ways it could be made without this coin.
 */
public class TotalUniqueWaysToMakeChange {
	 public int solution(int amount, int[] coins) {
	        int n = coins.length;
	        int[][] dp = new int[n+1][amount+1];
	        
	        //the number of ways to make 0 amount is 1, not use anything
	        for(int i=0; i < n+1; i++){
	            dp[i][0] = 1;
	        }
	        
	        //no ways to make amount that is bigger than 0 with empty coin list
	        for(int i=1; i < amount+1; i++){
	            dp[0][i] = 0;
	        }
	        
	        for(int row=1; row < n+1; row++){
	            int lastAddedCoin = coins[row-1];
	            for(int col=1; col < amount+1; col++){
	                if(col>=lastAddedCoin){
	                	//example to get 4 with 1 & 2 coins
	                	// 1+1+1+1 is already found without using 2
	                	// 4-2=2; 2 is already obtained with 1+1 & 2, so add 2 to this sums so look 4-2=2 sum found in the same row
	                    dp[row][col] = dp[row-1][col] + dp[row][col-lastAddedCoin];  //not use + use
	                }else{
	                    dp[row][col] = dp[row-1][col]; //not use
	                }
	            }
	        }
	    
	        return dp[n][amount];
	    }
	 
	    public static void main(String[] args) {
	    	TotalUniqueWaysToMakeChange totalUniqueWaysToMakeChange = new TotalUniqueWaysToMakeChange();
				
			System.out.println(totalUniqueWaysToMakeChange.solution(5, new int[]{1, 2, 5}));
			System.out.println(totalUniqueWaysToMakeChange.solution(3, new int[]{2}));
			System.out.println(totalUniqueWaysToMakeChange.solution(10,  new int[]{10}));
		}
}
