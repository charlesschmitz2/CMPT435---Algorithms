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


    public static void main(String[] args) {
        
    }//main

}//SemesterProjectMain
