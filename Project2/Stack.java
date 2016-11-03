//*******************************************//
//Created by Connor Pope & Zebulon Cunningham//
//											 //
//*******************************************//

import java.util.*;
import java.io.*;

public class Stack{
	private int arraySize;
	private char[] charArray;

	public Stack(){
		charArray = new char[20];
		arraySize = 0;
	}
	
	public void push(char c) {
		try{
			charArray[arraySize] = c;
			arraySize++;
		}
		catch(StackEmptyException e){
			throw new StackEmptyException();
		}
	}
	
	public char pop() {
		return charArray[arraySize--];
	}
	
	public boolean isEmpty(){
		if(arraySize == 0){
			return true;
		}
		else{ return false; }
	}
	
	public char peek(){
		return charArray[arraySize];
	}
}
