package arrays.kadanesalgorithm;

/*
 * An algorithm is finding the contiguous sub-array within a one-dimensional numeric array which has the largest sum.
 * given: [-2, 1, -3, 4, -1, 2, 1, -5, 4] Output: 6
 * 
 * Kadane’s algorithm :
 *  We want to answer the question: "What is the Max Contiguous Subarray Sum we can achieve ending at index i?"
	Extend the subarray by appending that element, or
	Discarding the subarray and starting a new subarray after that element.
 */
public class MaxContiguousSubarraySum {
	public int solution(int[] nums) {
	    int maxSoFar = nums[0];
	    int maxEndingHere = nums[0];


	    for (int i = 1; i < nums.length; i++) {
	      maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
	      maxSoFar = Math.max(maxSoFar, maxEndingHere);  
	    }

	    return maxSoFar;
	}
	
	public static void main(String[] args) {
		MaxContiguousSubarraySum maxContiguousSubarraySum = new MaxContiguousSubarraySum();
		
		System.out.println(maxContiguousSubarraySum.solution(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}
}
