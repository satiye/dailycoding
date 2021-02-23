package dynamicprogramming.knapsack;
/*
 *  In the supermarket there are n packages (n ≤ 100) the package i has weight W[i] ≤ 100 and value V[i] ≤ 100. 
 *  A thief breaks into the supermarket, the thief cannot carry weight exceeding M (M ≤ 100). 
 *  The problem to be solved here is: which packages the thief will take away to get the highest value?
 *  
 *  
given: values = [60, 50, 70, 30] weights = [5, 3, 4, 2] maxWeight = 8 Output: 120
given: values = [60, 100, 120] weights = [10,20,30] maxWeight = 50 Output: 220
 */
public class ZeroOneKnapsack {
	public int solution(int[] values, int[] weights, int maxWeight) {
		int n= values.length;
	    int[][] dp = new int[n + 1][maxWeight + 1];

	    for (int row = 0; row <= n; row++) {
	      for (int col = 0; col <= maxWeight; col++) {
	        int currentItem = row - 1;

	        if (row == 0 || col == 0) {
	        	dp[row][col] = 0;
	        } else if (weights[currentItem] > col) {
	        	dp[row][col] = dp[row - 1][col];
	        } else {
	          int withItem = values[currentItem] + dp[row - 1][col - weights[currentItem]];
	          int withoutItem = dp[row - 1][col];

	          dp[row][col] = Math.max(withItem, withoutItem);
	        }
	      }
	    }

	    return dp[n][maxWeight];
	  }
	
	public static void main(String args[]){
		ZeroOneKnapsack zeroOneKnapsack = new ZeroOneKnapsack();
        System.out.println(zeroOneKnapsack.solution(new int[] { 60, 50, 70, 30 }, new int[] { 5, 3, 4, 2 }, 8));
        System.out.println(zeroOneKnapsack.solution(new int[] { 60, 100, 120 }, new int[] { 10, 20, 30 }, 50));
    }
	
}
