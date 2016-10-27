//*******************************************//
//		Created by Connor Pope & Zebulon Cunningham  //
//																				   //
//*******************************************//

import java.util.*;
import java.io.*;

public class InfixToPostfix{
		
	public static Stack stack = new Stack();
	
	public static void main(String[] args)throws IOException{
		String infix;
		
		System.out.println("\nEnter an algebraic infix: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		infix = br.readLine();
		
		System.out.println("\nThe postfix of " + infix +" is: " + convertInfixToPostfix(infix));
	}

	private static String convertInfixToPostfix(String infix){
		char symbol;
		String postfix = "";
		
		for(int i = 0; i < infix.length(); i++){
			symbol = infix.charAt(i);
			if(Character.isLetter(symbol)){
				postfix += symbol;
			}
			else if((symbol == ')') && (!stack.isEmpty())){
				stack.pop();
			}
			else{
				while(!stack.isEmpty() && !(stack.peek() == '(') && 
							(evaluatePostfix(symbol) == evaluatePostfix(stack.peek()))){
					stack.pop();
				}
				stack.push(symbol);
			}
		}
		while (!stack.isEmpty()){
			postfix += stack.pop();
		}
		return postfix;
	}
		
	private static int evaluatePostfix(char c){
		if(c == '+' || c == '-'){
			return 1;
		}
		if(c == '*' || c == '/' || c == '%' || c == '^'){
			return 2;
		}
		return 0;
	}
}