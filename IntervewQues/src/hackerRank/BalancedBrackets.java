package hackerRank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class BalancedBrackets {
	public static void main(String[] args)                 
	

	 {
			Scanner input=new Scanner(System.in);
			input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 List<Character> chr = new ArrayList<>();
		 Set<Character> unique = new HashSet<Character>();
	    String res="";
	    String rt=input.nextLine();
	 
	    int i=0;
	  
	  
	  for(char c : rt.toCharArray()) {
		    chr.add(c);
		    unique.add(c);
		}
	 // System.out.println(chr.size());
	 // System.out.println(chr);
	 // System.out.println(chr.get(0));

	/////
	 
	 if(chr.size()%2!=0) {
	         System.out.println("NO");
	       
	     }
	 
	 else {
	 if(!areParenthesisBalanced(chr)){
		 System.out.println("NO");
	 } 
	 
	 
	 else {
	     
	     for (int k=0;k<chr.size();k++) {               
	       
	       
	          //System.out.println(chr.get(k));
	         
	         if(chr.get(k)=='{'&& chr.contains('}')) {
	        	
	             
	        	 chr.remove(Character.valueOf('{'));
	              
	             chr.remove(Character.valueOf('}'));
	          k--;
	            
	         }  
	        
	        
	         else if(chr.get(k)=='(' && chr.contains(')')){
	        	 
	        	     chr.remove(Character.valueOf('('));
	            	 chr.remove(Character.valueOf(')'));
	            	 k--;
	             }
	         
	       
	         else if(chr.get(k)=='[' && chr.contains(']')){
	        	     chr.remove(Character.valueOf('['));
	            	 chr.remove(Character.valueOf(']'));
	            	 
	            	k--;
	         }
	         
	         }
	     
	         
	  
	     if(chr.size()==0) {
		        res="YES";
		        System.out.println("yes");
		     }
	    
	      if(chr.size()!=0) {
	        res="NO";
	        System.out.println("no");
	        System.out.println(chr.size());
	       
	     }
	 

	 System.out.println(res);

	 }
		
	}	
		
	 }	
		static boolean areParenthesisBalanced( List<Character> exp) 
	    { 
	       /* Declare an empty character stack */
			Stack s = new Stack(); 
	       
	       /* Traverse the given expression to  
	          check matching parenthesis */
	       for(int i=0;i<exp.size();i++) 
	       { 
	            
	          /*If the exp[i] is a starting  
	            parenthesis then push it*/
	          if (exp.get(i) == '{' || exp.get(i) == '(' || exp.get(i) == '[') 
	            s.push(exp.get(i)); 
	       
	          /* If exp[i] is an ending parenthesis  
	             then pop from stack and check if the  
	             popped parenthesis is a matching pair*/
	          if (exp.get(i) == '}' || exp.get(i) == ')' || exp.get(i) == ']') 
	          { 
	                   
	              /* If we see an ending parenthesis without  
	                 a pair then return false*/
	             if (s.isEmpty()) 
	               { 
	                   return false; 
	               }  
	       
	             /* Pop the top element from stack, if  
	                it is not a pair parenthesis of character  
	                then there is a mismatch. This happens for  
	                expressions like {(}) */
	             else if (!isMatchingPair((char) s.pop(),exp.get(i)))  
	               { 
	                   return false; 
	               } 
	          } 
	            
	       } 
	          
	       /* If there is something left in expression  
	          then there is a starting parenthesis without  
	          a closing parenthesis */
	        
	       if (s.isEmpty()) 
	         return true; /*balanced*/
	       else
	         {   /*not balanced*/
	             return false; 
	         }  
	    } 
		 static boolean isMatchingPair(char ch1, char ch2) 
		    { 
		       if (ch1 == '(' && ch2 == ')') 
		         return true; 
		       else if (ch1 == '{' && ch2 == '}') 
		         return true; 
		       else if (ch1 == '[' && ch2 == ']') 
		         return true; 
		       else
		         return false; 
		    } 
		
}
