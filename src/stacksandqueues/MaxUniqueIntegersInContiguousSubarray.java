package stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
/*
 * You need to find the maximum number of unique integers among all possible contiguous subarrays of size M
 */
public class MaxUniqueIntegersInContiguousSubarray {
	public int solution(int[] nums, int M) {
		HashSet<Integer> uniqueNumbers = new HashSet<>();
		Deque<Integer> allNumbers = new ArrayDeque<>();
		
		int n = nums.length;
		int maxUnique = 0;
		
		for(int i=0; i<n; i++) {
			allNumbers.add(nums[i]);
			uniqueNumbers.add(nums[i]);
			
			if(allNumbers.size() == M) {
				maxUnique = Math.max(maxUnique, uniqueNumbers.size());
				
				int first = allNumbers.remove();
				
				if(!allNumbers.contains(first)) {
					uniqueNumbers.remove(first);
				}
			}
		}
		
		return maxUnique;
	}
	
	public static void main(String[] args) {
		MaxUniqueIntegersInContiguousSubarray maxUniqueIntegersInContiguousSubarray = new MaxUniqueIntegersInContiguousSubarray();
        System.out.println(maxUniqueIntegersInContiguousSubarray.solution(new int[]{ 5, 3, 5, 2, 3, 2 }, 3));
    }
}
