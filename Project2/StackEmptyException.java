//*******************************************//
//Created by Connor Pope & Zebulon Cunningham//
//											 //
//*******************************************//

public class StackEmptyException extends RuntimeException {
	public StackEmptyException() {
		super("The stack is empty.");
	}
}