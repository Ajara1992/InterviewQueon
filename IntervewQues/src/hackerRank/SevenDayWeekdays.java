package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SevenDayWeekdays {
public static void main(String[] args) {
	/**Task: your input will be a string of any length.
	 *  Each letter of this string should be assigned to 
	 *  one of the 7 days in a week. If a length of the 
	 *  string is shorter than 7, then you need to use the
	 *   same string from the begining. And you also need to
	 *    give a letter which will be assigned for a current day.
	 *     Here is the example: 
your input is "frank", then from today will be the first day of 
your week 1=f, 2=r, 3=a, 4=n, 5=k and since it's the end of the
 word, but we still have 2 days in a week, we continue 6=f, 7=r
and after that display your current day like 1=f
if you run your program tomorrow, it should give you 2=r
**/
	
	
	Scanner input =new Scanner(System.in);
	System.out.println("Input your word");
	String word=input.next();
	word.replace(" ", "").trim();
	word=word.toLowerCase();
	
	if(!(word.matches("[a-zA-Z]+"))) {//only for letters
	System.out.println("Please input only letters");
}
	
	wordsToWeekDays(word,2);
	
	input.close();
}

public static String wordsToWeekDays(String word,int day) {
	List<String> days=new ArrayList<>();
	int num=7;
	int len=word.length();
	int nnm=0;
	
	String dayOfWeek="";
	String toStr="";
	String conToStr="";
	char[] letters = word.toCharArray();
	if(len<=7) {
	for(int k=0;k<letters.length;k++) {
		nnm++;
		num--;
		conToStr = String.valueOf(nnm);
		days.add(letters[k]+"="+conToStr);
		len--;
		if(len==0&&num>0) {
			
			for(int s=0;s<letters.length;s++) {
				
				if(num>0&&nnm<7) {
					nnm++;
					
				toStr = String.valueOf(nnm);
				days.add(letters[s]+"="+toStr);
				
				}
				
			}
		}		
				
	}
	System.out.println(Arrays.toString(days.toArray()));
	 dayOfWeek=days.get(day-1);
	System.out.println(dayOfWeek);
	}
	else {
		
			
			for(int d=0;d<letters.length;d++) {
				
				nnm++;
				conToStr = String.valueOf(nnm);
				days.add(letters[d]+"="+conToStr);
				if(nnm==7) {
					nnm-=7;
				}
			}
			
		
		
		System.out.println(Arrays.toString(days.toArray()));
		 dayOfWeek=days.get(day-1);
		System.out.println(dayOfWeek);
		}
		
	
	
	return dayOfWeek;
}

}
