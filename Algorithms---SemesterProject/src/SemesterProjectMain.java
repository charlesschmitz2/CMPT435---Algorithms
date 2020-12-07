import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SemesterProjectMain {

    /* ----Project Goal----
    Program	a	simulation	of	the	testing	protocol	described	in	Alan’s	article.	Run	your	
    simulation	on	population	of	1000	people	(at	Lirst)	in	groups	of	8	assuming	a	2%	
    infection	rate	and	100%	accurate	tests.	Output	the	results	in	a	manner	similar	to	those	
    shown	below.		
    Using	the	protocol	described	in	Alan’s	article,	there	are	three	possibilities	to	consider:	
        (1) there	are	no	infected	samples	
        (2) there	is	exactly	one	infected	sample	
        (3) there	are	two	or	more	infected	samples
    */

    //ALL WITH GROUPS OF 8 NUMBERS NEEDED : 
    //For case (1) the liklihood of randomly choosing 8 unifected samples is (0.98)^8 = **0.85** or 85%, here we have a **1** test per group of 8
    //For case (2) the liklihood of randomly choosing ... **7** tests per 1 infectiom in group --> **0.1496** or abut 15% of the time
    //For case (3) the liklihood of randomly choosing 2 infected samples is 0.**0004** or 0.04% --> **11** tests are needed

    /* EXAMPLE RUN FROM ASSIGNMENT : 
    So,	for	1000	people	where	20	of	them	(2%)	are	infected	and	980	are	infection-free,	we	could	make	
    125	groups	of	8	samples	each	and	work	out	what	we	expect	based	on	the	percentages:	
    Case (1): 125 × 0.8500 = 106.25 instances requiring 107 tests (since there are no partial tests) --> 107*1
    Case (2): 125 × 0.1496 = 18.70 instances requiring 131 tests --> 19*7
    Case (3): 125 × 0.0004 = 0.05 round up to 1 instance requiring 11 tests --> 1*11
    ———————————————————————————————————————	
    That's	249	tests	to	screen	a	population	of	1000	people	for	a	disease	with	an	infection	rate	of	2%.		
    */

    //FUNCTIONS IF WORKING WITH DIFFERENT GROUP SIZES : here it is the for group sizes of 8, this can be substituted for other values as well such as 4,2, whatever. The x represents the infection rate, here we are working with 2%
    //Case (1) --> y = [(1-x/100)^8)]*100
    //Case (2) --> y = [(x/100)^2]*100
    //Case (3) --> y = 100 - [(100*{(1-x/100)^8}) + (x/100)^2]

    /* MY APPROACH :
        1. Use list to store our groups of 8, just taking groups of 8 starting at 0 up to the amountInputed/8 or # of groups of 8
        2. Produce output of liklihood of each case. NOT set as constants
        3. Use a little I/O console input
        4. Use a random() function and 0/1 to when testing the groups to see if positive or negative test
        5. Assume 100% accuracy
        6. Testing :
            If we are testing a group of 8 and there is an infection, then we will test four and four, if there is one or more infections from those tests 
            then each one is tested individually.

        First, I will take input on simulation size and that sort of thing
        Second, I will create an list of the inputted simulation size, then calculate amount of group - (simulationSize/groupsize[here using 8])
        Third, I will loop through the list of people to be tested grabbing 8 at a time for the amount of time calculated in the previous step

                counter = 0;
                int i = 0
                while(i < calculated Number of Groups){}
                    for(int j = 0; j < 8; j++){
                        if(list[counter].test(random function that gives either a 0 or a 1) == 1 [positive])
                            list[counter].setSickness to positive // I will be using a list of nodes that have an attribute of sickness which is either pos. or neg.
                        else
                            do nothing since all people will be added and assumed to be negative...innocent until proven guilty as they say.
                    }
                }

        Fourth, I should store and print out and compare these results to the statistically expected values that will be calculated and outputted alongside my test results
                these should match or be close to the expected

    */


    public static int menuSelection = 0;
    public static int infectionRate = 2; //this represents a 2% infection rate
    public static int infectedCounter = 0;
    public static int groupSize = 8; //this is our default size that we are running for this project, could adjust if desired
    public static int numTests = 0;
    public static int numPeople = 1000;

    public static List<Person> people = new ArrayList<>(1000);
    public static ListPeople peopleList = new ListPeople(people);
    
/*----Main----*/
    public static void main(String[] args) {

        System.out.println("\n\nHello & Welcome to my Pooled Testing Simulation : ");
        System.out.println("\n\tInformational output will be provided along the journey, you may continue to keep running the simulation with varying");
        System.out.println("\ttest numbers so once you have finished press '8' to quit. You may alter the number of people the simulation is performed on,");
        System.out.println("\tas well as the group size that these individuals are split into when testing. For this project the default is set to **group sizes of 8**,");
        System.out.println("\tbut can be altered if desired by pressing '6' within our menu selection. **Default simulation size is 1,000** as well. I hope you find my method of testing satisfactory.");
        System.out.println("\tAlso please note that our **infection rate of this disease is 2%**, you can run this program with different infection rates but this must be changed within the code itself.");
        System.out.println("\n\tPlease note that these test values are near or at the expected values, I do not list the expected within this program as that is detailed within");
        System.out.println("\tmy LaTeX documentation found on Github. By running the program multiple times and averaging the actual results you can match the expected values.");
        System.out.println("\nStay safe and enjoy!");
        
        //Run the simulation until you quit
        do{
            System.out.println("\n-------------RUNNING SIMULATION--------------");
            System.out.println("CURRENT SIMULATION SIZE : " + numPeople);
            System.out.println("CURRENT GROUP SIZE : " + groupSize);
            
        } while(runSimulation());
        
            

    }// main

/*----Simulation Functions----*/
        //This is the function where the simulation is run and analized 
        public static boolean runSimulation(){

            menuSelection = menu();
            infectedCounter = 0;
            numTests = 0;


            if (menuSelection == 1){
                System.out.println("\n----Running Simulation with 100 People---- \n");
                numPeople = 100;
                peopleList.addPeople(numPeople); //each time an addPeople is run the list is cleared and refilled so the program can run multiple cycles of differnet simulation sizes
                System.out.println("\n----The Infection has Begun to Spread---- \n");
                runInfection();
                test();
                System.out.print("\n \u2022--> Number of Tests Given : " + numTests + " <--\u2022\n");
                //peopleList.print();

            } // if 100
            else if (menuSelection == 2) {
                System.out.println("\n----Running Simulation with 1,000 People---- \n");
                numPeople = 1000;
                peopleList.addPeople(numPeople);
                System.out.println("\n----The Infection has Begun to Spread---- \n");
                runInfection();
                test();
                System.out.print("\n\u2022--> Number of Tests Given : " + numTests + " <--\u2022\n");
                // peopleList.print();

            } // if 1000
            else if (menuSelection == 3) {
                System.out.println("\n----Running Simulation with 10,000 People----\n");
                numPeople = 10000;
                peopleList.addPeople(numPeople);
                System.out.println("\n----The Infection has Begun to Spread---- \n");
                runInfection();
                test();
                System.out.print("\n\u2022--> Number of Tests Given : " + numTests + " <--\u2022\n");
                // peopleList.print();

            } // if 10000
            else if (menuSelection == 4) {
                System.out.println("\n----Running Simulation with 100,000 People----\n");
                numPeople = 100000;
                peopleList.addPeople(numPeople);
                System.out.println("\n----The Infection has Begun to Spread---- \n");
                runInfection();
                test();
                System.out.print("\n\u2022--> Number of Tests Given : " + numTests + " <--\u2022\n");
                // peopleList.print();

            } // if 1000000
            else if (menuSelection == 5) {
                System.out.println("\n----Running Simulation with 1,000,000 People----\n");
                numPeople = 1000000;
                peopleList.addPeople(numPeople);
                System.out.println("\n----The Infection has Begun to Spread---- \n");
                runInfection();
                test();
                System.out.print("\n\u2022--> Number of Tests Given : " + numTests + " <--\u2022\n");
                // peopleList.print();

            } // if 10000000
            else if(menuSelection == 6){
                menu2();
                return true;
            }//if want to change the group size
            else {
                System.out.print("Quitting Program, please come again!");
                return false;
            } // else quitting

            return true;

        }//runSimulation

/*----Menu Functions----*/
    public static void runInfection() {
        peopleList.diseaseGiver(infectionRate);//this is the function that infects people at the infection rate that is set (2% for us)
                for(int i = 0; i < peopleList.size(); i++){
                    if (people.get(i).getIsSick()==1){
                        if(peopleList.size()<=10000){System.out.println("\t\u2022 Person " + i + " has been infected");}
                        infectedCounter++;
                    }//if
                    
                }//for
                
                if(peopleList.size()==1000000){System.out.println("1,000,000 is way too many to print out around 20,000 'has been infected' messages");}
                if(peopleList.size()==100000){System.out.println("100,000 is too many to print out around 2,000 'has been infected' messages");}

                if (infectedCounter == 0){
                    System.out.println("\tNo one was infected, unlikely but always possible...expect the unexpected");
                }
                else{
                    System.out.println("\n-->" + infectedCounter + " people were infected\n\n");
                }
    }//runInfection

    public static void test() {
        //break each sample size up into groups of groupSize (8 default), then test 
        //if we get EVEN ONE positive test in the sample we need to break that group of 8 into 2 groups of 4
        //test each group and if there is EVEN ONE positive test within that group then we then
        //test each one of those 4 people and we tally up the total amount of tests needed to get through the entire group 
        //NOTE: while we may know which person is sick this is a simulation so we have to abide by these rules to get an accurate representation 
        //of how many tests are needed as there is no magic person node that marks people as sick or not sick that you can just summon up.

        double numberTestGroups = Math.ceil((float) peopleList.size()/groupSize);        

        //here I split up our list of people into groups of the specified group size and print them out using parts
        //parts represents a list of list, each sublist being a test group

        /* PLAN : 
        IF Infection found
            split into two list
            IF one group shows infection AND the other does not
                test all members of the infect group and the other group is clear
            ELSE both groups show infection
                test all members of both groups 
        ELSE 
            done with 1 test
        */

        System.out.println("--Splitting Group into " + numberTestGroups + "--");
        List<List<Person>> parts = chopped(peopleList.getList(), groupSize); //set groupSize above 
        for (List<Person> list : parts) { 
            if(peopleList.size() <= 1000){System.out.print(" [");} 
  
            for (Person person : list) { 
                if(peopleList.size() <= 1000){ System.out.print(" " + person + ",");} //too many console print statements if doing anything bigger than 1000
                
                //Compute if they are sick, then we send that to another method where they are split down and tested and our test counter will be 
                //incremented.
                if(person.getIsSick() == 1){
                   List<List<Person>> splitList = new ArrayList<>();
                   splitList = split(list);

                   for(int i = 0; i < splitList.size(); i++){
                        performTest(); //test the two split lists
                   }//for

                   for (List<Person> listSubGroup : splitList){
                       for(Person personSubGroup : listSubGroup){
                            if(personSubGroup.getIsSick() == 1){
                                //test all of the people in that subgroup group for each subgroup that is found to have a sick person
                                for(int i = 0; i < listSubGroup.size(); i++){
                                    performTest();
                                }
                            }
                       }//for
                   }//for
                } //if
            } //for
            if(peopleList.size() <= 1000){System.out.println("] ");} 
            performTest();
        } //for
        

    }//test

     // chops a list into non-view sublists of length L, these represent our testing groups since we are passing it our List of person objects and the number that we want the list to be chopped into
    public static <T> List<List<T>> chopped(List<T> list, final int L) {
        List<List<T>> parts = new ArrayList<List<T>>();
        final int N = list.size();
        for (int i = 0; i < N; i += L) {
            parts.add(new ArrayList<T>(list.subList(i, Math.min(N, i + L))));
        }//for
        return parts;
    }//chopped

    // Generic function to split a list into two sublists in Java
    public static <T> List<List<T>> split(List<T> list)
    {
        List<List<T>> splitInTwo = new ArrayList<List<T>>();

        // get size of the list
        int size = list.size();
    
        // construct new list from the returned view by list.subList() method
        List<T> first = new ArrayList<>(list.subList(0, (size + 1)/2));
        List<T> second = new ArrayList<>(list.subList((size + 1)/2, size));
    
        // return a List array to accommodate both lists
        splitInTwo.add(first);
        splitInTwo.add(second);

        return splitInTwo;
    }

    //simply keeps track of how many tests have been given
    public static void performTest(){
        numTests++;
    }//performTest

    public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/

        System.out.println("\nChoose the AMOUNT OF PEOPLE the Simulation will be Run With :");
        System.out.println("1 - 100");
        System.out.println("2 - 1,000");
        System.out.println("3 - 10,000");
        System.out.println("4 - 100,000");
        System.out.println("5 - 1,000,000");
        System.out.println("6 - Change Testing Group Size");
        System.out.println("7 - Run with Default Settings");
        System.out.println("8 - Quit");

        while (!input.hasNextInt()) {
            String scanner = input.next();
            System.out.print(" '" + scanner + "' is not a valid number.\n");
        } // while

        selection = input.nextInt();
        if(selection == 8){input.close();}
        if(selection == 7){selection = 2; groupSize = 8;}
        
        return selection;
    }// menu

    //if time allows can adjust to work with different sized groups other than 8 may come back and implement later
    public static void menu2() {

        int selection;
        Scanner input2 = new Scanner(System.in);

        /***************************************************/

        System.out.println("\nChoose the GROUP SIZE the Simulation will be Run With :");
        System.out.println("1 - 4 Groups");
        System.out.println("2 - 6 Groups");
        System.out.println("3 - 8 Groups");
        System.out.println("4 - 16 Groups");
        System.out.println("5 - 32 Groups");
        System.out.println("6 - Quit");

   
        while (!input2.hasNextInt()) {
            String scanner = input2.next();
            System.out.print(" '" + scanner + "' is not a valid number.\n");
        } // while

        selection = input2.nextInt();
        
        //Processing choice here as it is a submenu and want to keep main cleaner and for our main menu
        if(selection == 1) {
            groupSize = 4;
        }
        if(selection == 2) {
            groupSize = 6;
        }
        if(selection == 3) {
            groupSize = 8;
        }
        if(selection == 4) {
            groupSize = 16;
        }
        if(selection == 5) {
            groupSize = 32;
        }
        if(selection == 6) {
            System.out.println("Group Size Remains the Same");
            //input2.close();
        }

        System.out.println("Rerunning Simulation Program with new group size");


    }

}//SemesterProjectMain
