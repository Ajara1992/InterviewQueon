package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CheckDigitAndCode {
/** Given a 17 digit number as a string, calculate the Check Digit and Check COde
 *  according to the following rules.Return as a string in the format of the example below.
 *  CHECK DIGIT: Sum all the digits up,but first multiply every other digit by 3,starting with
 *  the first digit *3.Then , subtract the sum from the nearest equal or higher multiple of ten.
 *  For example,if the sum is 119,then the multiple of ten is 120,and you would do 120-119=1
 *  to get the check digit.
 *  CHECK CODE: Append the Check Digit to the end of the 17-digit number.Take each of the 9 two-digit
 *  numbers out of the string and multiply each one by (3+ <index of two digit number from 0-8>).
 *  Add the results together and then add add 207.Divide that total by 103 to get the remainder.
 *  The Check Code is the remainder as a two digit number,padded with a leading zero if necessary.
 *  Example input: "87656784324567240"
 *  Example output:"4,40"
 * 
 */
	
	
	public static void main(String[] args) {
		
		
		
	
		String digit="25747938567392714";
		//Conversion String  using parseLong(String) method
			digit=digit.replace("", " ").trim();
			 String[] stringSplit = digit.split(" "); 
		long[] conA = new long[stringSplit.length];
		long checkDig=0;
		List<Long> arrCheck=new ArrayList<>();
		for(int k=0;k<stringSplit.length;k++) {
			//convert to Array
			
			 //parse and store each value into int[] to be returned
	        conA[k] = Long.parseLong(stringSplit[k]); 
			//System.out.println(conA[k]);
		    arrCheck.add(conA[k]);
		}
		//System.out.println(Arrays.toString(conA));
		
		//System.out.println(sumMult(conA));
		long subSum=sumMult(conA);
		
		if(subSum%10==0) {
			checkDig=0;
			System.out.println(" CHECK DIGIT: "+checkDig);
		}
		else { 
			
		    //The % operator evaluates to the remainder of the division	
           // Subtracting that from 10 evaluates to how much how much you need to reach the next multiple
			long temp = subSum + (10 - subSum % 10);
			checkDig=temp-subSum;
			System.out.println("CHECK DIGIT: "+checkDig);
		}
		
		arrCheck.add(checkDig);
		 
		//System.out.println(arrCheck.size());
		
		
		String listString = arrCheck.toString();
		
		checkCode(listString);
		
	}
	//sum method for array mult *3
	 public static long sumMult(long...values) {
		   long result = 0;
		   for (long value:values) {
		     result += value;
		   }
		   long mult=result*3;
		   return mult;
		 }
	
	 public static String checkCode(String num){
		
		num=num.replace("[", "").replace("]", "").replace(",","").replace(" ","").trim();
		 int frst=0;
		 int scnd=2;
		 long sum=0;
		 long pos=0;//for each loop for the index from 0-8
		 String [] twoNumArr=new String [num.length()/2];
		 for(int k=0;k<twoNumArr.length;k++) {
			 twoNumArr[k]=(num.substring(frst, scnd));
			 frst+=2;
			 scnd+=2;
		 }
		 long[] addNum = new long[twoNumArr.length];
		 
		 for(int k=0;k<twoNumArr.length;k++) {
				
			addNum[k] = Long.parseLong(twoNumArr[k]); 
				
			}
		 
		 for(long sumNum:addNum) {
			 sum+=(sumNum*(3+pos));
			 pos++;
		 }
		 double toDouble = (double)sum;//cast to double
		 
		 double fin=(toDouble+207)/103;
		 String total = String.valueOf(fin);//convert double to string
		 total=total.substring(0, 5);
		 System.out.println("CHECK CODE: "+total);
		 return total;
	 }
	
	
}
