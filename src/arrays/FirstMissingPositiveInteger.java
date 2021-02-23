package arrays;
/*
 * Given an array of integers, find the first missing positive integer in linear time and constant space. 
 * In other words, find the lowest positive integer that does not exist in the array. 
 * 
 * The array can contain duplicates and negative numbers as well.
 * 
 * For example, the input [3, 4, -1, 1] should give 2. 
 * The input [1, 2, 0] should give 3.
 * 
 * 
 * You can modify the input array in-place.
 */
public class FirstMissingPositiveInteger {
	public int solution(int[] nums) {
		int N = nums.length;
		
		//ignore 0, negative integers and integers greater than N
		for(int i=0; i < N; i++) {
			if(nums[i] == 0 || nums[i] < 0 || nums[i] > N) {
				nums[i] = N+1;
			}
		}
		
		//set seen integer index as its negative value to track found integers
		//for example if 3 is seen in index0, replace the value(x) at index2 with its negative value(-x).
		for(int i=0; i<N; i++) {
			int current = Math.abs(nums[i]);
			
			if(current > N) {
				continue;
			}
			
			if(nums[current-1] > 0) {
				nums[current-1] *= -1;
			}
		}
		
		//first positive value seen index is the result
		for(int i=0; i < N; i++) {
			if(nums[i] > 0) {
				return i+1;
			}
		}
		
		//if all of them are negative return the next biggest integer N+1;
		//example nums=[2, 1, 3], return 4
		return N+1;
	}
	
	public static void main(String[] args) {
		FirstMissingPositiveInteger firstMissingPositiveInteger = new FirstMissingPositiveInteger();
		
		System.out.println(firstMissingPositiveInteger.solution(new int[]{3, 4, -1, 1}));
		System.out.println(firstMissingPositiveInteger.solution(new int[]{1, 2, 0}));
		System.out.println(firstMissingPositiveInteger.solution(new int[]{2, 1, 3}));
	}
}
