package graphs.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. 
 * Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
 * 
 * 
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
 * 
 * Return the least number of units of times that the CPU will take to finish all the given tasks.

Input: tasks = ["A","A","A","B","B","B"], n = 2 Output: 8
Explanation:  A -> B -> idle -> A -> B -> idle -> A -> B

Input: tasks = ["A","A","A","B","B","B"], n = 0 Output: 6
Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2 Output: 16
 * 
 * 
 */
public class TaskScheduler {
	 public int leastInterval(char[] tasks, int n) {
	        HashMap<Character,Integer> map = new HashMap<>();
	        for(char c: tasks){
	            map.put(c, map.getOrDefault(c, 0) + 1);
	        }
	        
	        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
	        maxHeap.addAll(map.values());
	        
	        int numberOfUnits = 0;
	        
	        while(!maxHeap.isEmpty()){
	            List<Integer> temp = new ArrayList<>();
	            for(int i=0; i < n+1; i++){
	                if(!maxHeap.isEmpty()){
	                    temp.add(maxHeap.remove());
	                }
	            }
	            
	            for(int i : temp){
	                if(--i > 0){
	                    maxHeap.add(i);
	                }
	            }
	            
	            numberOfUnits += maxHeap.isEmpty() ? temp.size() : n+1 ;
	        }
	        
	        return numberOfUnits;
	    }
	 
	 public static void main(String[] args) {
		 TaskScheduler taskScheduler = new TaskScheduler();
			
			System.out.println(taskScheduler.leastInterval(new char[] {'A','A','A','B','B','B'}, 2));
			System.out.println(taskScheduler.leastInterval(new char[] {'A','A','A','B','B','B'}, 0));
			System.out.println(taskScheduler.leastInterval(new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
		}
}
