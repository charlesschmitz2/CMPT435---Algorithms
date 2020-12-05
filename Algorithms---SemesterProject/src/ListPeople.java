import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListPeople {

    //int person = 0;
    private List<Person> people = new ArrayList<>();

    public ListPeople(List<Person> listPeople){
        this.people = listPeople;
    }//ListPeople

    //Clears the list and adds adds however many people given to the list, so if 100 have a list of 100 people
    public void addPeople(int sizeWanted){
        this.people.clear();
        for(int i = 0; i < sizeWanted; i++){
            Person person = new Person(0);
            people.add(person);
        }//for
    }//addPerson

    //Here I have set the infection rate to 2 by generating a random number btw 0-100 and if that number is less than 2 
    //then the person has covid dun dun dunnnnn hope he is quarantining
    public void diseaseGiver(int infectionRate){
        for(int i = 0; i < people.size(); i++){
            Random r = new Random();
            int percentChanceGetSick = r.nextInt(100);
            if (percentChanceGetSick < infectionRate){
                people.get(i).setIsSick(1);
            }
            
            //return testResult.nextInt((1-0)+0);
            
        }
    }//test

    public void clearList(){
        this.people.clear();
    }//clear

    public int size(){
        return people.size();
    }//size

    public Person get(int index){
        return people.get(index);
    }

    public void print(){
        if(!people.isEmpty()){
            for(int i = 0; i < people.size(); i++)
                System.out.println(i);
        }//if

    }
    
}//ListPeole
