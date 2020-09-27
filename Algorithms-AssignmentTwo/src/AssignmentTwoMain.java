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
        //Merge sort done in different way than insertion and selection since utilizes 2 functions
        // to divide and conquer so prints comparisons and list out here to show sorted
        System.out.println("Merge Sort : Comparisons = " + mergeCounter);
        System.out.println(Arrays.toString(magicitems.toArray()));

        ArrayList<String> magicitems3 = readFromFile("sort.txt");
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

    private static int findSmallestFrom(int i, ArrayList<String> magicitems ) {
        int smallestIndex = i;
        String smallest = magicitems.get(i);
        for (int j = i; j < magicitems.size(); j++) {
            String value = magicitems.get(j);
            if (value.compareToIgnoreCase(smallest) < 0) {
                smallest = value;
                smallestIndex = j;
                selectionCounter++;
            }
        }
        return smallestIndex;
    }

    public static void insertionSort(ArrayList<String> magicitems) {
        for(int i = 1; i < magicitems.size(); i++) {
            String value1 = magicitems.get(i);

            int j = i-1;
            while(j >= 0 && value1.compareToIgnoreCase(magicitems.get(j)) < 0) {
                magicitems.set(j+1, magicitems.get(j));
                j--;
                insertionCounter++;
            }//for
            magicitems.set(j+1, value1);

        }//for
        System.out.println("Insertion Sort : Comparisons = " + insertionCounter);
        System.out.println(Arrays.toString(magicitems.toArray()));
    }//insertionSort



    public static ArrayList<String> mergeSort(ArrayList<String> magicitems) {
        int center;
        ArrayList<String> left = new ArrayList<String>();
        ArrayList<String> right = new ArrayList<String>();

        if (magicitems.size() == 1) {
            return magicitems;
        }//if list only one item in array

        else {
            //take the center of the array and break down into left and right, sort left and right halves and continue
            //divide and conquer then merge together

            center = magicitems.size()/2;

            //add items to each sections
            for (int i=0; i<center; i++) {
                left.add(magicitems.get(i));
            }
            for (int i=center; i<magicitems.size(); i++) {
                right.add(magicitems.get(i));
            }

            //mergeSort the sections themselves
            left =  mergeSort(left);
            right = mergeSort(right);

            //merge together the sorted sections
            merge(left, right, magicitems);

        }//else begin sorting array

        return magicitems;
    }//mergeSort

    public static void merge (ArrayList<String> left, ArrayList<String> right, ArrayList<String> magicitems){
        int leftIndex = 0;
        int rightIndex = 0;
        int magicItemsIndex = 0;

        //As long as the left and right elements of the array remain or have not been "used up"
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
                magicitems.set(magicItemsIndex, left.get(leftIndex));
                leftIndex++;
            }
            else {
                magicitems.set(magicItemsIndex, right.get(rightIndex));
                rightIndex++;
            }
            magicItemsIndex++;
            mergeCounter++;
        }


        ArrayList<String> remain;
        int remainIndex;
        //if the left array has been fully used up remaining is the right, else the remaining is the left
        if (leftIndex >= left.size()) {
            remain = right;
            remainIndex = rightIndex;
        } //if
        else {
            remain = left;
            remainIndex = leftIndex;
        }//else

        // Copy the remaining array items that have not been fully used up
        for (int i=remainIndex; i<remain.size(); i++) {
            magicitems.set(magicItemsIndex, remain.get(i));
            magicItemsIndex++;
        }
    }

    public static void quickSort(ArrayList<String> magicitems) {
        System.out.println("Quick Sort : Comparisons = " + quickCounter);
        System.out.println(Arrays.toString(magicitems.toArray()));
    }//quickSort










}//AssignmentTwoMainClass
