import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Algorithms_Assignment_One {
	
	public static void main(String[] args) {
		Singly_Linked_List linkedList = new Singly_Linked_List();		
		Singly_Linked_List palindrome = new Singly_Linked_List();
		Queue myQueue = new Queue();
		Stack myStack = new Stack();
		int arrayCounter = 0;
		boolean isPalindrome = true;
		
	
	/***************File System Import*******************************/
		String content = new String();
		int count=1;
		File file = new File("magicItems.txt");
		
		 try {
		Scanner sc = new Scanner(new FileInputStream(file));
		
		while (sc.hasNextLine()){
			
			content = sc.nextLine();
			System.out.println("------------------------------");
			System.out.print("Linked List : ");
			System.out.println("Element - " + (linkedList.size()+1));
				linkedList.addHead(content);
			
				
				for(int i = 0; i < content.length(); i++) {
					//get each character and then cast character to string for push and enqueue 
					char c = content.charAt(i);
					String s = String.valueOf(c);
					
					//break down each line into characters then convert that to String to push and enqueue...
					//output in console WILL SHOW EACH CHARACTER TWICE AS IT SHOWS THAT EACH HAS BEEN ADDED TO STACK/QUEUE CORRECTLY, COULD COMMENT OUT CONFIRMATION MESSAGE IF DESIRED
					
					if(!checkEmptyString(s) && !checkBlankString(s)) {
						System.out.print("Stack - ");
							myStack.push(s);
						System.out.print("Queue - ");		
							myQueue.enqueue(s);
					}
				}
				
				int tempSize = 0;
				isPalindrome = true;
				while(tempSize < content.replace(" ", "").length()) {
					System.out.println("--------");
					String tempCharStack = myStack.pop();
				    String tempCharQueue = myQueue.dequeue();
					
				    
				    	
				    if(isPalindrome == true) {
							if(tempCharStack.toLowerCase().equals(tempCharQueue.toLowerCase())) {
								isPalindrome = true;
								
							}//if
							else {
								isPalindrome = false;
							}
				    }
					tempSize++;
					//System.out.println(tempSize);
					//System.out.println(content.length());
				}//while
				
				if(isPalindrome == true) {
					System.out.println(content + " is  a Palindrome");
					palindrome.addHead(content);
					arrayCounter++;
				}//if
				else {
					System.out.println(content + " is NOT a Palindrome");
					
				}//else
				
				
				
				 
		}//while
		sc.close();
		
		}catch(FileNotFoundException fnf){
		fnf.printStackTrace();
		}
		 
		catch (Exception e) {
		e.printStackTrace();
		System.out.println("\nProgram terminated Safely...");
		}
		
		 
		 //Use to Remove All Items from Linked List
		 System.out.println("\n--------Removes All Elements in List Once Processing Complete----------");
		while(!linkedList.isEmpty()) {
			linkedList.removeHead();
		}//while
			
		palindrome.printList(palindrome);

	}//main
	
	public static boolean checkEmptyString(String string) {
		return string == null || string.length() == 0;
	}//used to check to make sure not pushing empty spaces into stacks and queues
	public static boolean checkBlankString(String string) {
	    return string == null || string.trim().isEmpty();
	}////used to check to make sure not pushing blank spaces into stacks and queues
	

}//Algorithms_Assignment_One


	/**********************************************/	
		
		// -Testing if each character is read properly -
		//myStack.getEachCharacter("12345");
		
		/**********************************************
		 * Initial Testing For Singly Linked List
		linkedList.addHead("my first element");
		linkedList.addHead("my second element");
		linkedList.addHead("my third element");
		linkedList.addTail("my Four element");
		linkedList.addTail("my Five element");
		linkedList.addTail("my Six element");
		
		linkedList.removeElement("my Six element");
		
		while(!linkedList.isEmpty()) {
			linkedList.removeHead();
		}
		 **********************************************/
		
		/**********************************************
		 * Initial Testing For Queue
		myQueue.enqueue("person 1");
		myQueue.enqueue("person 2");
		myQueue.enqueue("person 3");
		myQueue.enqueue("person 4");
		myQueue.enqueue("person 5");
		myQueue.enqueue("person 6");
		myQueue.dequeue();//should be person 1, 2, ...
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.dequeue();
		**********************************************/
		
		/**********************************************
		 * Initial Testing For Stack
		myStack.push("person 1");
		myStack.push("person 2");
		myStack.push("person 3");
		myStack.push("person 4");
		myStack.pop();
		myStack.pop();
		myStack.pop();
		myStack.pop();	
		**********************************************/
		

