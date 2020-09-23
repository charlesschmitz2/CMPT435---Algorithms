import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class AssignmentTwoMain {

	private static int size = 0;
	private static int selectionCounter = 0;
	private static int insertionCounter = 0;
	private static int mergeCounter = 0;
	private static int quickCounter = 0;
	
	
	public static void main(String[] args) {
		
		//Use magicitems.get(index) to get values in ArrayList magicItems
		
		/* Goals: 
		 * Sort	using	your	selection	sort.	Print	the	number	of	comparisons.	
		 * Sort	using	your	insertion	sort.	Print	the	number	of	comparisons.	
		 * Sort	using	your	merge	sort.	Print	the	number	of	comparisons.	
         * Sort	using	your	quick	sort.	Print	the	number	of	comparisons.	
		 */
		//read in the array list each time so that it can be resorted and counted
		ArrayList<String> magicitems = readFromFile("magicitems.txt");
		System.out.println(Arrays.toString(magicitems.toArray()));
		System.out.println("\n");
		selectionSort(magicitems);
		
		ArrayList<String> magicitems1 = readFromFile("magicitems.txt");
		insertionSort(magicitems1);
		
		ArrayList<String> magicitems2 = readFromFile("magicitems.txt");
		mergeSort(magicitems2);
		
		ArrayList<String> magicitems3 = readFromFile("magicitems.txt");
		quickSort(magicitems3);
		
		
	}
	
	//this is the function that takes in the file name and adds it to an arrayList
	public static ArrayList readFromFile(String filename) {
		ArrayList<String> myList = new ArrayList<String>();
		try {
			Scanner sc = new Scanner(new File(filename));
			while(sc.hasNextLine()) {
				String value = sc.nextLine();
				myList.add(value.substring(0,1).toUpperCase() + value.substring(1));
				size++;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return myList;
		
	}//readFromFile
	
	public static void selectionSort(ArrayList<String> magicitems) {
		
		//check to see if the array list is null, if it is return null value
		//OR if it empty, OR if only one item in the array
		if(magicitems == null || magicitems.size()== 1 || magicitems.size()== 0) {
			return;
		}//if
		
		//loop through, compare, and sort
		for(int headIndex = 0; headIndex < magicitems.size(); headIndex++) {
			 int smallestIndex = findSmallestFrom(headIndex, magicitems);
		        if (smallestIndex != headIndex) {
		        	String head = magicitems.get(headIndex);
		    		magicitems.set(headIndex, magicitems.get(smallestIndex));
		    		magicitems.set(smallestIndex, head);
		    		selectionCounter++;
		        }
		}
	
		System.out.println("Selection Sort : Comparisons = " + selectionCounter);
		System.out.println(Arrays.toString(magicitems.toArray()));
	}//selectionSort

	public static void insertionSort(ArrayList<String> magicitems) {
		for(int i = 1; i < magicitems.size(); i++) {
			String value1 = magicitems.get(i);
			
			int j = i-1;
			while(j >= 0 && value1.compareToIgnoreCase(magicitems.get(j)) < 0) {
				magicitems.set(j+1, magicitems.get(j));
				j--;
			}//for
			magicitems.set(j+1, value1);
			insertionCounter++;
		}//for
		System.out.println("Insertion Sort : Comparisons = " + insertionCounter);
		System.out.println(Arrays.toString(magicitems.toArray()));
	}//insertionSort
	
	public static void mergeSort(ArrayList magicitems) {
		System.out.println("Merge Sort : Comparisons = " + mergeCounter);
		System.out.println(Arrays.toString(magicitems.toArray()));
	}//mergeSort
	
	public static void quickSort(ArrayList magicitems) {
		System.out.println("Quick Sort : Comparisons = " + quickCounter);
		System.out.println(Arrays.toString(magicitems.toArray()));
	}//quickSort
	
	private static int findSmallestFrom(int i, ArrayList<String> magicitems ) {
		int smallestIndex = i;
        String smallest = magicitems.get(i);
        for (int j = i; j < magicitems.size(); j++) {
            String value = magicitems.get(j);
            if (value.compareToIgnoreCase(smallest) < 0) {
                smallest = value;
                smallestIndex = j;
            }
        }
        return smallestIndex;
	}
	
	
	
	
	
	

	
}//AssignmentTwoMainClass
