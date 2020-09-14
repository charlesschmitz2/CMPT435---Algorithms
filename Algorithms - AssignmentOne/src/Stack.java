
public class Stack {
	private Singly_Linked_List list = new Singly_Linked_List();
	
	public Stack() {
		
	}//constructor for the stack
	
	public int getSize() {
		return list.size();
	}//get size
	
	public boolean isEmpty() {
		return list.isEmpty();
	}//isEmpty
	
//First In - Last Out
	public void push(String element) {
		list.addHead(element);
	}//push
	
	public String pop() {
		return list.removeHead();
	}//pop
	
	public String getTop() {
		return list.head();
	}//getTop, gets the element on the top of the stack
	
	public void getEachCharacter(String myString) {
			
		System.out.println("Initial String = " + myString);
		
		//Cycle through each character of the string and assign to constant c to be printed/compared
		for(int i = 0; i < myString.length(); i++) {
			char c = myString.charAt(i);
			System.out.println(c);
		}//for 
		
		
		
		/*
		 * //declare a new stack to read into
			String newString = "";
			Stack myStack = new Stack();
			for(int i = 0; i < myString.length(); i++) {
				myStack.push(myString.substring(i,i+1));
			}
			
			for(int i = 0; i < myString.length(); i++) {
				myStack.push(myString.substring(i,i+1));
				
			}//loops through all the characters in the string and push's each individual character
			
			while(!myStack.isEmpty()) {
				newString += myStack.pop();
			}
			
			System.out.println("Final String = " + newString);
			
			return newString;
			*/
		
		
	}//getEachCharacter returns each individual character of a string put in the stack
	
	
	
}//Stack
