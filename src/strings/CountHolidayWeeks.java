package strings;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.YearMonth;

/*
 * 
 * John has always dreamed of taking a vacation on Hawaii. He has decided to make his dream come true during the next holiday period, and he would like to spend as much time as possible.
   
   The problem is that there is only one plane per week connecting Hawaii with the city where John lives. The plane departs every Monday and arrives every Sunday. 
   There is no other way to get to Hawaii and back. It means that John can spend only whole weeks in Hawaii.

   John knows in which month his vacation starts and in which month it ends. His vacation period starts on the first day of the beginning month and ends on the last day of the ending month. 
   John also knows the year in which vacation takes place.

   For example, If John's vacation lasts from July to September in 2008, then it starts on 1st July 2008 and ends 30th September 2008.
	
   Your task is to calculate how many weeks John will spend in Hawaii, given:
   * the month when the vacation begins
   * the month when the vacation ends
   * the year when the vacation takes place
   * the day of week for 1st January in vacation year(for convenience)
	
	The names of the days of the week are: Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
	The names of the months are: January, February, March, April, May, June, July, August, September, October, November, December
	The lengths of the months are respectively: 31, 28(or 29 in a leap year), 31,30,31,30,31,31,30,31,30,31 days
	
	Pay attention to leap years; you should also consider them. The year of vacation will be a number between 2001 and 2099, inclusive and you can tell that the year is a leap year if its divisible by 4.
	
	Write a function:
	class Solution{public int solution(int Y,String A, String B, String W);}
	
	that, given an integer Y and three non-empty strings A, B and W, denoting the year of vacation, the beginning month, the ending month and the day of the week for 1st January of that year, 
	returns the maximum number of weeks that John can spend in Hawaii.
	
	For example:
	given Y=2014, A="April", B="May" and W="Wednesday" the function should return 7, since John leave his city April 7th and come back on May 25th, 
	so he will spend 7 weeks n Hawaii.(the weeks beginning, respectively, on April 7th, 14th,21th,28th and May5th, 12th,19th).
*/
public class CountHolidayWeeks {
	public int solution(int Y, String A, String B, String W) {	 
		 int startMonth = Month.valueOf(A.toUpperCase()).getValue();
		 int endMonth = Month.valueOf(B.toUpperCase()).getValue();
		 
		 boolean holidayStarted = false;
		 int daysCountBeforeHoliday = 0;
		 int daysCountHoliday = 0;
		 
		 for(int i=1; i <=12; i++) {
			 YearMonth yearMonthObject = YearMonth.of(Y, i);
			 int daysInMonth = yearMonthObject.lengthOfMonth();
			 
			 if(i == startMonth) {
				 holidayStarted = true;
			 }
			 
			 if(holidayStarted) {
				 daysCountHoliday += daysInMonth;
			 }else {
				 daysCountBeforeHoliday += daysInMonth;
			 }
			 
			 if(i == endMonth) {
				 break;
			 }
		 }
		 
		 int firstDayOfYear = DayOfWeek.valueOf(W.toUpperCase()).getValue();
		 int firstDayOfHoliday = ((daysCountBeforeHoliday%7) + firstDayOfYear) % 7;		 
		 int emptyDaysBeforeHoliday = (7 - firstDayOfHoliday + 1 ) % 7;
		 
		 return (daysCountHoliday - emptyDaysBeforeHoliday) / 7;
	}
	
	public static void main(String[] args) {
		CountHolidayWeeks countHolidayWeeks = new CountHolidayWeeks();

		System.out.println(countHolidayWeeks.solution(2014, "April", "May", "Wednesday"));
		System.out.println(countHolidayWeeks.solution(2018, "January", "January", "Monday"));
		System.out.println(countHolidayWeeks.solution(2021, "January", "December", "Friday"));
	}
}
