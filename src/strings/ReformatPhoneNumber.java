package strings;
/*
 * 
 *  Task: 
 *  	Reformat the phone number
    Task Description:
    We are given a string S representing a phone number, which we would like to reformat. String S consists of N characters: digits, spaces and/or dashes. It contains at least two digits.

	Spaces and dashes in string S can be ignored. We want to reformat the given phone number in such a way that the digits are grouped in blocks of length three, seperated by single dashes. If necessary, the final block or last two blocks can be of length two.
	
	Write a function:
	 class Solution{public String solution(String S);}
	 
	that, given a string S representing a phone number, returns this phone number reformatted as described above.
	
	For example,
	given S = "00-44  48  5555 8361", the function should return "004-448-555-583-61".
	given S="0 - 22 1985--324", the function should return "022-198-53-24"
	given S="555372654", the function should return "555-372-654"	
*/
public class ReformatPhoneNumber {
	public String solution(String S) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < S.length(); i++) {
			if(S.charAt(i) !=' ' && S.charAt(i) != '-') {
				sb.append(S.charAt(i));
			}
		}
		
        int index = 0;
        
        while(index + 4 < sb.length()) {
        	sb.insert(index+3, '-');
        	index += 4;
        }
        
        if(index + 4 ==  sb.length()) {
        	sb.insert(index+2, '-');
        }
        
        return sb.toString();  
	}
	
	public static void main(String[] args) {
		ReformatPhoneNumber reformatPhoneNumber = new ReformatPhoneNumber();

		System.out.println(reformatPhoneNumber.solution("00-44  48  5555 8361"));
		System.out.println(reformatPhoneNumber.solution("0 - 22 1985--324"));
		System.out.println(reformatPhoneNumber.solution("555372654"));
		System.out.println(reformatPhoneNumber.solution("5555"));
		System.out.println(reformatPhoneNumber.solution("555"));
		System.out.println(reformatPhoneNumber.solution("55"));
	}
}
