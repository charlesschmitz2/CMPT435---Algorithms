public class person {
    
    int isSick = 0; //0 represents not sick, 1 represents sick

    public person(int isSick) {
        this.isSick = isSick;
    }//person constructor

        public int getIsSick(){
            return this.isSick;
        }//getter

        public void setIsSick(int maybeGotCovid){
            this.isSick = maybeGotCovid;
        }//setter


}//person
