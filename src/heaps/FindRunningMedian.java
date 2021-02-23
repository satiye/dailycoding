package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
 * 
 * Given integers are read from a data stream. Find median of elements read so for in efficient way. 
 * 
   - We use 2 Heaps to keep track of median
   A max-heap to store the smaller half of the input numbers
   A min-heap to store the larger half of the input numbers
   - We make sure that 1 of the following conditions is always true:
       1) maxHeap.size() == minHeap.size()
       2) maxHeap.size() - 1 = minHeap.size()
       
 given A: [12, 4, 5, 3, 8, 7], output: [12.0, 8.0, 5.0, 4.5, 5.0, 6.0]    
 */
public class FindRunningMedian {
	public double[] solution(int[] a) {
        double[] outputArr = new double[a.length];
         
         PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> y-x);
         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
         
        for(int i=0; i < a.length; i++){
            int curr = a[i];
            
            maxHeap.add(curr);
            minHeap.add(maxHeap.peek());
            maxHeap.remove();
           
            if(minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.peek());
                minHeap.remove();
            }
            
            outputArr[i] = minHeap.size() == maxHeap.size() ? (minHeap.peek() + maxHeap.peek())/2.0 : maxHeap.peek() /1.0;
        }
        
        return outputArr;
    }
	
	public static void main(String[] args) {
		FindRunningMedian findRunningMedian = new FindRunningMedian();
		
		System.out.println(Arrays.toString(findRunningMedian.solution(new int[]{12, 4, 5, 3, 8, 7})));
	}
}
