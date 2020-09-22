
public class Queue {
	
	private Singly_Linked_List list = new Singly_Linked_List();
	
	public Queue() {
		
	}//constructor 
		
	public int getSize() {
		return list.size();
	}//get Size
	
	public boolean isEmpty() {
		return list.isEmpty();
	}//isEmpty
	
//First in - First Out
	public void enqueue(String element) {
		list.addTail(element);
	}//adding item onto the tail of the line
	
	public String dequeue() {
		return list.removeHead();
	}//removing item from front of line
	
	public String head() {
		return list.head();
	}//see what is at the front of the line
			
}//Queue
