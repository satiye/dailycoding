package graphs.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * 
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * 
 * Return true if you can finish all courses. Otherwise, return false.

Input: numCourses = 2, prerequisites = [[1,0]] Output: true
Input: numCourses = 2, prerequisites = [[1,0],[0,1]] Output: false
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		//key: courseX, value:list of courses that depends on courseX
        HashMap<Integer, List<Integer>> map = buildMap(numCourses, prerequisites);
        //count of dependent course. courseX depends on inDegree[courseX] many courses
        int[] inDegree = buildInDegree(numCourses, prerequisites);
        
        Queue<Integer> q = new LinkedList<>();
        
        //if dependent course count==0, take course directly
        for(int i=0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        
        //take the course decrease related dependent course count, if no dependency remains, take that course also(add to queue)
        int count = 0;
        while(!q.isEmpty()){
            int current = q.poll();
            count++;
            
            for(int neighbor : map.get(current)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        
        return count == numCourses;
    }
    
    private int[] buildInDegree(int numCourses, int[][] prerequisites){
        int[] inDegree = new int[numCourses];
        
        for(int[] arr : prerequisites){
            int currentCourse = arr[0];
            inDegree[currentCourse]++;
        }
        
        return inDegree;
    }

    private HashMap<Integer, List<Integer>> buildMap(int numCourses, int[][] prerequisites){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int[] arr : prerequisites){
            int courseX = arr[1];
            int courseThatDependOnX = arr[0];
            
            List<Integer> list = map.get(courseX);
            list.add(courseThatDependOnX);
            
            map.put(courseX, list);
        }
        
        return map;
    }
    
    public static void main(String[] args) {
    	CourseSchedule courseSchedule = new CourseSchedule();
		
		System.out.println(courseSchedule.canFinish(2, new int[][] {{1, 0}}));
		System.out.println(courseSchedule.canFinish(2, new int[][] {{1, 0}, {0, 1}}));
	}
}
