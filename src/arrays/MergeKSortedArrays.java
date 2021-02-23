package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 
 * Given K sorted arrays, write an algorithm that merges these arrays and returns a single sorted array.
 * 
 * Example: 
 * Input: [[1, 3, 4], [5, 6, 11], [2, 9, 10]]
 * Output: [1, 2, 3, 4, 5, 6, 9, 10, 11]
 * 
 * 
 * Let n be the total elements across the k sorted arrays. Extracting and adding to the min heap will both take log(k) time.
 * For each of the n items, we will do an addition to the heap and removal from the heap (log(k) expense per heap operation). We get O( n * log(k) ).
 */
public class MergeKSortedArrays {
	class Tupple{
		int row;
		int col;
		int val;
		int totalLength;
		Tupple(int r, int c, int v, int tl){
			this.row = r;
			this.col = c;
			this.val = v;
			this.totalLength = tl;
		}
	}
	
	public int[] solution(int[][] arrays) {
		int K = arrays.length;
		int resultLength = 0;
		
		PriorityQueue<Tupple> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
		
		for(int i=0; i<K; i++) {
			minHeap.add(new Tupple(i, 0, arrays[i][0], arrays[i].length));
			resultLength += arrays[i].length;
		}
		
		int[] result = new int[resultLength];
	    int index = 0;
	    
		while(!minHeap.isEmpty()) {
			Tupple currentMin = minHeap.poll();
			result[index] = currentMin.val;
			index++;
			
			if(currentMin.col + 1 < currentMin.totalLength) {
				minHeap.add(new Tupple(currentMin.row, currentMin.col + 1, arrays[currentMin.row][currentMin.col + 1], arrays[currentMin.row].length));
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		MergeKSortedArrays mergeKSortedArrays = new MergeKSortedArrays();
		
		System.out.println(Arrays.toString(mergeKSortedArrays.solution(new int[][]{{1, 3, 4}, {5, 6, 11},{2, 9, 10}})));
		System.out.println(Arrays.toString(mergeKSortedArrays.solution(new int[][]{{1, 3}, {5, 6, 11},{9}})));
		System.out.println(Arrays.toString(mergeKSortedArrays.solution(new int[][]{{2, 6, 12, 34}, {1, 9, 20, 1000},{23, 34, 90, 2000}})));
	}
}
