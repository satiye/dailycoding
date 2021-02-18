package string;

import java.util.TreeSet;

/*
 * 
 *  Task: 
 *  	Get search results from the save contacts for the number you entered.
    Task Description:
	When you open the dialer of your phone and start typing a number, you will probably get search results from the save contacts for the number you entered. Your task is to implement a similar feature.
	Saved contacts are numbered from 0 to N-1. They are represented by two arrays A,B of N strings each. Name of K-th contact is A[K] and phone number is B[K].
	Write a function
	class Solution { public String solution(String[] A, String[] B, String P); }
	which, given two arrays A and B and a string P of length M representing a partial phone number, returns the contact name whose phone number contains P as a substring, that is a contiguous segment (for example, �436800143� contains as a substring �6800�, but not �3614�).
	If there is more than one contact matching the search criteria, your function should return the alphabetically smallest contact name.
	If no match is found, your function should return �NO CONTACT�.
	Examples:
	Given A = [�pim�, �pom�], B = [�999999999�, �777888999�] and P = �88999�, your function should return �pom�, because only pom�s phone number contains �88999�.
	Given A = [�sander�, �amy�, �ann�, �michael�], B = [�123456789�, �234567890�, �789123456�, ��123123123��] and P = �1�, your function should return �ann�. Note that sander, ann and michael�s phone number contain �1� but �ann� is alphabetically smaller.
 */
public class SortedContactSearch {
	public String solution(String[] A, String[] B, String P) {
		TreeSet<String> sortedContacts = new TreeSet<>();
		
		for(int i=0; i < A.length; i++) {
			if(B[i].contains(P)) {
				sortedContacts.add(A[i]);
			}
		}
		
		return sortedContacts.isEmpty() ? "NO CONTACT" : sortedContacts.first();
	}
	
	public static void main(String[] args) {
		SortedContactSearch saveContactSearch = new SortedContactSearch();

		System.out.println(saveContactSearch.solution(new String[]{"pim", "pom"}, new String[]{"999999999", "777888999"}, "88999"));
		System.out.println(saveContactSearch.solution(new String[]{"sander", "amy", "ann", "michael"}, new String[]{"123456789", "234567890", "789123456", "123123123"}, "1"));
		System.out.println(saveContactSearch.solution(new String[]{"sander", "amy", "ann", "michael"}, new String[]{"123456789", "234567890", "789123456", "123123123"}, "10"));
	}
}
