package arrays;

import java.util.HashSet;
import java.util.Set;

public class SmallestElementsWindow {
	 public static int solution(int[] A) {
		 int N = A.length;
		 int result = N;
		 
		 Set<Integer> elements = new HashSet<>();
		 
		 for(int i=0; i < N; i++) {
			 elements.add(A[i]);
		 }
		 
		 int expectedSize = elements.size();
		 
		 int start = 0;
		 int[] elementsCount = new int[N];
		 Set<Integer> currentWindowElements = new HashSet<>();
		 
		 currentWindowElements.add(A[0]);
		 elementsCount[A[0]]++;
		 
		 for(int i=1; i<N;i++) {
			 while(A[i] == A[start]) {
				 start++;
				 elementsCount[A[start]]--;
			 }
			 
			 currentWindowElements.add(A[i]);
			 elementsCount[A[i]]++;
			 
			 if(currentWindowElements.size() == expectedSize) {
				 result = Math.min(result, i-start+1);
			 }
		 }
		 
		 int end = N-1;
		 while(elementsCount[end] > 1) {
				elementsCount[end]--;
				end--;
		 }
		 
		 return Math.min(result, end-start+1);
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[]{7,3,7,3,1,3,4,1}));
		System.out.println(solution(new int[]{2,1,1,3,2,1,1,3}));
	}
}
