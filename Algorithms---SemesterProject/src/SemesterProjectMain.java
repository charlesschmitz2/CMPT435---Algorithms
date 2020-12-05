import java.util.ArrayList;
import java.util.Arrays;
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

    public static List<Person> people = new ArrayList<>();
    public static ListPeople peopleList = new ListPeople(people);
    public static void main(String[] args) {
        
        do{
            System.out.println("\n-------------RUNNING SIMULATION--------------");
        } while(runSimulation());
        
            

        }// main

        public static boolean runSimulation(){

            menuSelection = menu();

            if (menuSelection == 1){
                System.out.println("\n----Running Simulation with 100 People---- \n");
                peopleList.addPeople(100);
                runInfection();
                // peopleList.print();

            } // if 100
            else if (menuSelection == 2) {
                System.out.println("\n----Running Simulation with 1,000 People---- \n");
                peopleList.addPeople(1000);
                runInfection();
                // peopleList.print();

            } // if 1000
            else if (menuSelection == 3) {
                System.out.println("\n----Running Simulation with 10,000 People----\n");
                peopleList.addPeople(10000);
                runInfection();
                // peopleList.print();

            } // if 10000
            else if (menuSelection == 4) {
                System.out.println("\n----Running Simulation with 100,000 People----\n");
                peopleList.addPeople(100000);
                runInfection();
                // peopleList.print();

            } // if 1000000
            else if (menuSelection == 5) {
                System.out.println("\n----Running Simulation with 1,000,000 People----\n");
                peopleList.addPeople(1000000);
                runInfection();
                // peopleList.print();

            } // if 10000000
            else {
                System.out.print("Quitting Program");
                return false;
            } // else quitting

            return true;

        }//runSimulation

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
            System.out.println("6 - Quit");

            while (!input.hasNextInt()) {
                String scanner = input.next();
                System.out.print(" '" + scanner + "' is not a valid number.\n");
            } // while

            selection = input.nextInt();
            if(selection == 6){input.close();}
            
            return selection;
        }// menu

    public static void runInfection() {
        peopleList.diseaseGiver(infectionRate);
                for(int i = 0; i < peopleList.size(); i++){
                    if (people.get(i).getIsSick()==1){
                        if(peopleList.size()<=100000){System.out.println("\t\u2022 Person " + i + " has been infected");}
                        infectedCounter++;
                    }//if
                    
                }//for
                
                if(peopleList.size()>100000){System.out.println("1,000,000 is too many to print out around 20,000 'has been infected' messages");}

                if (infectedCounter == 0){
                    System.out.println("\tNo one was infected, unlikely but always possible...expect the unexpected");
                }
                else{
                    System.out.println("\n-->" + infectedCounter + " people were infected\n\n");
                }
    }//runInfection

    //if time allows can adjust to work with different sized groups other than 8 may come back and implement later
    public static int menu2() {

        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/

        System.out.println("Choose the GROUP SIZE the Simulation will be Run With :");
        System.out.println("-------------------------\n");
        System.out.println("1 - 4 Groups");
        System.out.println("2 - 6 Groups");
        System.out.println("3 - 8 Groups");
        System.out.println("4 - Quit");

        selection = input.nextInt();
        input.close();
        return selection;    
    }

}//SemesterProjectMain
