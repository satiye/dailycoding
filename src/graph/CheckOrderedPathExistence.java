package graph;

import tree.SerializeDeserializeBinaryTree;
import tree.TreeNode;

/*
 * You are given an undirected graph consisting of N vertices, numbered from 1 to N, and M edges.

The graph is described by two arrays, A and B, both of length M. A pair(A[K], B[K]), for K from 0 to M-1, describes an edge between vertex A[K] and vertex B[K].

Your task is to check whether the given graph contains a path from vertex 1 to vertex N going through all of the vertices, one by one, in increasing order of their numbers. All connections on the path should be direct.

Write a function:

class Solution{public boolean solution(int N, int[]A, int[]B);}

that, given an integer N and two arrays A and B of M integers each, returns true if there exists a path from vertex 1 to N going through all vertices, one by one, in increasing order, or false otherwise.

Examples: 
given N=4, A=[1,2,4,4,3], B=[2,3,1,3,1]
,the function should return true. There is a path (1->2->3->4) using edges(1,2),(2,3) and (4,3)

given N=4, A=[1,2,1,3], B=[2,4,3,4]
,the function should return false. There is no path (1->2->3->4) there is no direct connection from vertex 2 to vertex 3.

given N=6, A=[2,4,5,3], B=[3,5,6,4]
,the function should return false. There is no path (1->2->3->4->5->6) there is no direct connection from vertex 1 to vertex 2.

given N=3, A=[1,3], B=[2,2]
,the function should return true. There is a path (1->2->3) using edges(1,2),(2,3)

 */
public class CheckOrderedPathExistence {
	public boolean solution(int N, int[]A, int[]B) {
		boolean[] exist = new boolean[N];
		
		for(int i=0; i<A.length; i++) {
			if(Math.abs(A[i] - B[i]) == 1) {
				exist[Math.min(A[i], B[i])] = true;
			}
		}
		
		for(int i=1; i<N;i++) {
			if(exist[i] == false) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) { 
    	CheckOrderedPathExistence checkOrderedPathExistence = new CheckOrderedPathExistence();

		System.out.println(checkOrderedPathExistence.solution(4, new int[] {1,2,4,4,3}, new int[] {2,3,1,3,1}));
		System.out.println(checkOrderedPathExistence.solution(4, new int[] {1,2,1,3}, new int[] {2,4,3,4}));
		System.out.println(checkOrderedPathExistence.solution(6, new int[] {2,4,5,3}, new int[] {3,5,6,4}));
		System.out.println(checkOrderedPathExistence.solution(3, new int[] {1,3}, new int[] {2,2}));
	}
}
