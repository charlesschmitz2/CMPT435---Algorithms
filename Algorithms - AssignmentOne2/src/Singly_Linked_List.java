
public class Singly_Linked_List {
	
	//Node Class Used Created for Linked List 
	private static class Node {
		private String myData;
		private Node myNext;
		
		public Node(String data, Node next) {
			myData = data;
			myNext = next;
		}//NodeConstructor 
		
		public String getData(){
			return myData;
		}//getData
		
		public Node getNext() {
			return myNext;
		}//getNext
		
		public void setNext(Node newNext) {
			myNext = newNext;
		}//setNext
		
	}//NodeClass
	
	//Linked List
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	public Singly_Linked_List() {
		
	} //SinglyLinkedList()
	
	public int size() {
		return size;
	}//size of list
	
	public boolean isEmpty() {
		if (size == 0) {
			return (true);
		}//if
		else {
			return (false);
		}//else
	}//Checks if list is empty
	
	
	public String head() {
		if(isEmpty()) {
			return null;
		}//if list is empty return null
		else {
			return head.getData();
		}//if list is not empty return the value from the head
	}//first or head of the list is checked and value returned if there is one
	
	public String tail() {
		if(isEmpty()) {
			return null;
		}//last element of list checked and if empty returns null
		else {
			return tail.getData();
		}//otherwise, return the element at the tail
	}//last or tail of the list is checked and value returned if there is one
	
//you can add an element to the beginning (head) of the list or to the end (tail) done
	public void addHead(String element) {
		head = new Node(element, head);
		//create a new node, takes the element passed to the function, creates pointer at the head
	
		if(size == 0) {
			tail = head;
		}//if the size of the list is 0 the value serves as both the tail and head values of the list
		
		size++; //up's the size with each addition
		System.out.println("Added Node Element '" + head.getData() + "' to First (head) Position");
	}//addHead
	
	public void addTail(String element) {
		Node newNode = new Node(element, null); 
		if(isEmpty()) {
			head = newNode;
		}//if the list is empty the head will become this element
		else {
			tail.setNext(newNode);
		}//else not empty the tail will point to the new Node created
		
		tail = newNode;
		size++;
		System.out.println("Added Node Element '" + tail.getData() + "' to Last (tail) Position");
		
	}//addTail
	
	public String removeHead() {
		if(isEmpty()) {
			return null;
		}//if
		else {
			String ans = head.getData();
			head = head.getNext(); //set the head to the new next value in the list
			
			size--;
			if(size==0) {
				tail = null;
			}//if no removed all items in the list assign null value to tail to show that
			
			System.out.println("Removed Node Element '" + ans + "' From First (head) Position");
			
			return ans;
		}//else
		
		
	}//removes the Node at the head of the list
	
	public String removeElement(String element) {
		Node current = head;
		Node previous = head;
		int position = 0;
		while((current != null) && (current.getData() != element)) {
			previous = current;
			current = current.getNext();
			position++;
		}//while we are not at the end of the list or we have not found the element being searched
		//keeps track of where we are in the list and what is in front/behind us
	
		if(current==null) {
			return null;
		}//if current element is null then it doesn't exist 
		else {
			if(head==current) {
				head = current.getNext();
			}//if
			else if(tail==current) {
				tail = previous;
				tail.setNext(null);
			}//else if
			else {
				previous.setNext(current.getNext());
			}//else
			
			System.out.println("Elementwas Found and Removed at position " + position);
			size--;
			return current.getData();
		}
	
	}//Deletes a Node at a certain location/Finds position of specific element in the list
	
	public static void printList(Singly_Linked_List list) {
		
		Node currNode = list.head; 
		   
        System.out.print("\nPalindromes: "); 
   
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.getData() + ", "); 
   
            // Go to next node 
            currNode = currNode.getNext(); 
        } 
		
		
		
	}//toString

	
}//Singly Linked List
