
public class Person {
    
    int isSick = 0; //0 represents not sick, 1 represents sick

    public Person(int isSick) {
        this.isSick = isSick;
    }//person constructor

        public int getIsSick(){
            return this.isSick;
        }//getter

        public void setIsSick(int maybeGotCovid){
            this.isSick = maybeGotCovid;
        }//setter
    
        public String toString(){
            String s = Integer.toString(this.isSick);
                return (s);
        }



}//person
