package dynamicprogramming;

import java.util.Arrays;

/*
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * 
 * Input: coins = [1, 2, 3] amount = 10  Output: 4 Explanation: We can use two 3 coins & two 2 coins to fully make change for 10. 3 + 3 + 2 + 2 = 10
 * 
 * Input: coins = [1, 3, 5, 6, 9] amount = 90 Output: 10 Explanation: 9 x 10 uses = 90
 * 
 * Input: coins = [2] amount = 5 Output: -1 Explanation: We cannot make change for 5 with only a 2 coin.
 */
public class FewestCoinsToMakeChange {
	 public int solution(int amount, int[] coins) {
	     int[] dp = new int[amount+1];
	     Arrays.fill(dp, amount+1);
	     dp[0] = 0;
	     
	     for(int i=1; i <= amount; i++) {
	    	 for(int j=0; j < coins.length; j++) {
	    		 if(i >= coins[j]) {
	    			 dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
	    		 }
	    	 }
	     }
	     
	     return dp[amount] == amount+1 ? -1 : dp[amount];
	 }
	 
	 public static void main(String[] args) {
		FewestCoinsToMakeChange fewestCoinsToMakeChange = new FewestCoinsToMakeChange();
			
		System.out.println(fewestCoinsToMakeChange.solution(10, new int[]{1, 2, 3}));
		System.out.println(fewestCoinsToMakeChange.solution(90, new int[]{1, 3, 5, 6, 9}));
		System.out.println(fewestCoinsToMakeChange.solution(5,  new int[]{2}));
	}
}
