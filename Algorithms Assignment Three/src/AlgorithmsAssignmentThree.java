import java.io.*;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.*;
import java.util.HashMap;

public class AlgorithmsAssignmentThree {

    private static int totalComparisonsBinarySearch;
    private static int tempComparisonsBinarySearch;
    private static final int LINES_IN_FILE = 666;
    private static final int HASH_TABLE_SIZE = 250;


    public static void main(String[] args){

        System.out.println("\nEach time the program is run there will be 42 random items selected from the magicitems list, these selections will be different each run:");
        System.out.println("Linear Search searches through an UNSORTED magicitems list to find the randomly selected items (Could be sorted if you want but does not need to be)");
        System.out.println("Binary Search searches through a SORTED magicitems list to find the randomly selected items");

        //Declare Variables, in this case the strings that will be used throughout main
        String[] magicitems = readArray("magicitems.txt");
        String[] randomMagicItems = new String[42];

        /*
            System.out.println("All Elements in Array: ");
            for(int i = 0; i < magicitems.length; i++){
                System.out.println(magicitems[i]);
            }
        */




        //Randomly select 42 items within the magic items list, hold onto these values in a new array
        //Unique Numbers will be an array of value 0-666 all unique and in a random order, from this the first 42 can be used as an index value for the magic items to have 42 random and unique value
        //Each time the program is rerun new random values are generated but during the duration of the program the random elements remain the same
            int[] uniqueNumbers = createUniqueRandomNumber(0,665);

            for(int i = 0; i < randomMagicItems.length; i++){
                int temp = uniqueNumbers[i];
                String temp2 = magicitems[temp];

                randomMagicItems[i]= temp2;
            }
        /* Prints out all of the randomly selected items
            System.out.println("\n--------Randomly Selected 42 Elements in Array-------- ");
            for (int i = 0; i < randomMagicItems.length; i++){
                System.out.print(randomMagicItems[i] + ", ");
            }//for
        */
        //Taken from Assignment two, adapted from arrayList to work with arrays. Using quicksort. Magicitems remains unsorted
            int n = randomMagicItems.length;
            quickSort(randomMagicItems, 0, n-1);
        /* Prints out all the random items in sorted order
            System.out.println("\n--------Sorted Array-----------");
            for (int i = 0; i < randomMagicItems.length; i++){
                System.out.print(randomMagicItems[i] + ", ");
            }//for
        */
        //Linear Search - Here I have a sorted randomMagicItems array and an unsorted magicitems array. I am searching for each of the randomly selected items
        //within the larger magicitems array which again is unsorted.

            // Using Scanner for Getting Input from User so have the option to search for whatever individual items if desired
            System.out.println("\n\n--------Linear Search-----------");
            //System.out.println("Enter the Word to be Searched for: ");
            //Scanner in00 = new Scanner(System.in);
            //String searchLinear = in00.nextLine();

            String searchLinear = "";
            int[] result = new int[3];
            int totalComparisons = 0;
            for(int i = 0; i < randomMagicItems.length; i++){
                searchLinear = randomMagicItems[i];
                result = linearSearch(magicitems, searchLinear);
                int temp = result[2];
                totalComparisons = totalComparisons + temp;

                if(result[0] == 1) {
                    System.out.println("\n\tThe Element '" + searchLinear + "' was Found at Key " + result[1]);
                    System.out.println("\tComparisons: " + temp);
                }//if
                else{
                    System.out.println("\n\tThe Element '"+ searchLinear + "' was NOT Found in the Array");
                }//else
            }//for

            System.out.println("\nTotal Number of Comparisons: " + totalComparisons);
            System.out.println("\nAverage Number of Comparisons (Total/42): " + totalComparisons/42);




        //Binary Search - Here I have the same sorted randomMagicItems, but now I have to sort the full magicitems array in order to perform a binary search within it.

            // Using Scanner for Getting Input from User so have the option to search for whatever individual items if desired
            System.out.println("\n\n--------Binary Search-----------");
            //System.out.println("Enter the Word to be Searched for: ");
            //Scanner in00 = new Scanner(System.in);
            //String searchBinary = in00.nextLine();

        //sorting the magic items array to be used in binary search
                int m = magicitems.length;
                quickSort(magicitems, 0, m-1);


            String searchBinary = "";
            int start = 0;
            int stop = magicitems.length-1;


            for(int i = 0; i < randomMagicItems.length; i++){
                searchBinary = randomMagicItems[i];
                int result2 = 0;
                tempComparisonsBinarySearch = 0;
                result2 = binarySearch(magicitems, 0, magicitems.length-1, searchBinary);

                    if(result2 == -1) {
                    System.out.println("\nThe Element '" + searchBinary + "' was NOT Found in the Array");
                }//if
                else{
                    result2 = result2+1;
                        //adding a + 1 to the index key simply because we know that the list is 0-665 but in a text document or to an avg
                        //person the list of magicitems goes from 1-666.
                    System.out.println("\n\tThe Element '"+ searchBinary + "' was Found at Key " + result2);
                    System.out.println("\tComparisons: " + tempComparisonsBinarySearch);

                }//else
            }//for

            System.out.println("\nTotal Number of Comparisons: " + totalComparisonsBinarySearch);
            System.out.println("\nAverage Number of Comparisons (Total/42): " + totalComparisonsBinarySearch/42);


        System.out.println("\n\n--------Hashing-----------");
        int[] hashValues = new int[magicitems.length];
        // Print the array and hash values.
        int hashCode = 0;
        for (int i = 0; i < magicitems.length; i++) {
            System.out.print(i);
            System.out.print(". " + magicitems[i] + " - ");
            hashCode = makeHashCode(magicitems[i]);
            System.out.format("%03d%n", hashCode);
            hashValues[i] = hashCode;
        }

        // Analyze the distribution of hash values.
        analyzeHashValues(hashValues);

        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(000,"Dimensional shackles" );
        hashMap.put(000,"Eyes of petrification");
        System.out.println(hashMap);
        System.out.println(hashMap.get(000));








    }//main

    //A function that will take in a string parameter that is the name of the file and copy the contents into an array
    //Assumes one element per line
    public static String[] readArray(String file){
        int count = 0;

        try{
            Scanner s1 = new Scanner(new File(file));

            //Count how many elements are in the file
            while(s1.hasNextLine()){
                count++;
                s1.nextLine();
            }//while

            //Create the array and copy elements into it
            String[] words = new String[count];

            Scanner s2 = new Scanner(new File(file));
            for(int i = 0; i < count; i++){
                words[i]=s2.nextLine();
            }

            return words;
        }//try
        catch (FileNotFoundException e){

        }

        return null;
    }//readString

    //A function that will create a list of random unique numbers between the desired range
    public static int[] createUniqueRandomNumber(int from, int to){
        //Number of integers need to generate
            int n = to - from + 1;

        //Create an array to store all the numbers from, from - to
            int array[] = new int[n];
            for (int i = 0; i < n; i++){
                array[i] = i;
            }//for

        //Create an array to store the result
            int result[] = new int[n];

            int x = n;
            SecureRandom rd = new SecureRandom();
            for(int i = 0; i < n; i++){
                //k is a random index in [0, x]
                int k = rd.nextInt(x);

                result[i] = array[k];

                //Replace value from a[k] by the value from the last index
                //so that there will not get the value array[k] again
                array[k] = array[x-1];

                //Decrease x by 1 to get a random index from 0 to x only
                x--;
            }

            return result;
    }//UniqueRandomNumber

    //Linear Search Function
    public static int[] linearSearch(String[] arr, String search){
        int[] result = new int[3];
        //the 0 index of the result array will either be initialized to a 0 representing a false value, if the search string is found then it is set
        //to a 1 representing a true value.
        // The 1 index of the result array represents the key, this is the index where the element is found within the random array
        //The 2 index of the result array represents the number of comparisons
        int key = -1;
        int comparisons = 0;
        result[0] = 0;
        result[1] = key;
        result[2] = comparisons;

        int count = 0;
        boolean end = true;
        while((count < arr.length) && (end == true)){
            if(arr[count].compareToIgnoreCase(search) == 0){
                result[0] = 1;
                key = count;
                comparisons++;
                count++;
                end = false;
            }//if
            comparisons++;
            count++;
        }//for
        result[1] = key+1;
        result[2] = comparisons;
        return result;
    }//linearSearch

    //Binary Search Function
    public static int binarySearch(String[] arr, int start, int stop, String search){

        if(start > stop){
            tempComparisonsBinarySearch++;
            totalComparisonsBinarySearch++;
            return -1;
        }//if

        //could round or take floor or ceiling of midpoint, I did't explicitly do that here but it seems to calculate it correctly
        //so im just going to leave it as is
        int midPoint = start + (stop-start) / 2;

        if(search.equalsIgnoreCase(arr[midPoint])){
            tempComparisonsBinarySearch++;
            totalComparisonsBinarySearch++;
            return midPoint;
        }//if
        else if(search.compareToIgnoreCase(arr[midPoint]) < 0){
            tempComparisonsBinarySearch++;
            totalComparisonsBinarySearch++;
            return binarySearch(arr, start, midPoint - 1, search);
        }
        else{
            tempComparisonsBinarySearch++;
            totalComparisonsBinarySearch++;
            return binarySearch(arr, midPoint + 1, stop, search);
        }

    }//BinarySearch



    private static int makeHashCode(String str) {
        str = str.toUpperCase();
        int length = str.length();
        int letterTotal = 0;

        // Iterate over all letters in the string, totalling their ASCII values.
        for (int i = 0; i < length; i++) {
            char thisLetter = str.charAt(i);
            int thisValue = (int)thisLetter;
            letterTotal = letterTotal + thisValue;

            // Test: print the char and the hash.

           System.out.print(" [");
           System.out.print(thisLetter);
           System.out.print(thisValue);
           System.out.print("] ");
           //


            }

        // Scale letterTotal to fit in HASH_TABLE_SIZE.
        int hashCode = (letterTotal * 1) % HASH_TABLE_SIZE;  // % is the "mod" operator
        // TODO: Experiment with letterTotal * 2, 3, 5, 50, etc.

        return hashCode;
        }//makeHashCode

    private static void analyzeHashValues(int[] hashValues) {
        System.out.println("\nHash Table Usage:");

        // Sort the hash values.
        Arrays.sort(hashValues);    // This is a "dual-pivot" quicksort
                                    // See https://zgrepcode.com/java/oracle/jdk-8u181/java/util/dualpivotquicksort.java
                                    // Actually, look at that JDK source code; it's a bunch of sorts.

        // Test: print the sorted hash values.
        /*
56         for (int i=0; i < LINES_IN_FILE; i++) {
57            System.out.println(hashValues[i]);
58         }
59      // */

        // Create a histogram-like report based on the count of each unique hash value,
        // count the individual entry size,
        // the total space used (in items),
        // and the standard deviation of their distribution over the hash table.
        int asteriskCount = 0;
        int[] bucketCount = new int[HASH_TABLE_SIZE];
        int totalCount = 0;
        int arrayIndex = 0;

        for (int i=0; i < HASH_TABLE_SIZE; i++) {
            System.out.format("%03d ", i);
            asteriskCount = 0;
            while ( (arrayIndex < LINES_IN_FILE) && (hashValues[arrayIndex] == i) ) {
                System.out.print("*");
                asteriskCount = asteriskCount + 1;
                arrayIndex = arrayIndex + 1;
                }
            System.out.print(" ");
            System.out.println(asteriskCount);
            bucketCount[i] = asteriskCount;
            totalCount = totalCount + asteriskCount;
        }

        System.out.print("Average load (count): ");
        float averageLoad = (float) totalCount / HASH_TABLE_SIZE;
        System.out.format("%.2f%n", averageLoad);

        System.out.print("Average load (calc) : ");
        averageLoad = (float) LINES_IN_FILE / HASH_TABLE_SIZE;
        System.out.format("%.2f%n", averageLoad);

        System.out.print("Standard Deviation: ");
        // TODO: Refactor this into its own method.
        double sum = 0;
        for (int i=0; i < HASH_TABLE_SIZE; i++) {
            // For each value in the array...
            // ... subtract the mean from each one ...
            double result = bucketCount[i] - averageLoad;
            // ... and square the result.
            double square = result * result;
            // Sum all of those squares.
            sum = sum + square;
        }
        // Divide the sum by the number of values ...
        double temp = sum / HASH_TABLE_SIZE;
        // ... and take the square root of that.
        double stdDev = Math.sqrt(temp);
        System.out.format("%.2f%n", stdDev);
    }




    //Quicksort and partition functions taken from assignment two using array's instead of array list
    public static void quickSort(String arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }//quicksort
    private static int partition(String arr[], int begin, int end) {
        String pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j].compareToIgnoreCase(pivot) < 0) {
                i++;

                String swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        String swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }//partition



}//AssignmentThree
