package oca.ch2;

public class OptionalLabel {
    public static void main(String[] args) {
        OptionalLabel optionalLabel = new OptionalLabel();
        optionalLabel.breakLabel();
        optionalLabel.continueLabel();
    }

    private void breakLabel(){
        int [][] lis = {{1,13,5},{1,2,5},{2,7,2}};
        int searchValue = 2;
        int posX = -1;
        int posY = -1;
        PARENT_LOOP:
        for (int i = 0; i < lis.length ; i++) {
            for (int j = 0; j < lis[i].length; j++) {
                if(lis[i][j] == searchValue) {
                    posX = i;
                    posY = j;
                    break PARENT_LOOP;
                }
            }
        }
        if(posX==-1 || posY==-1){
            System.out.println("Value " + searchValue + " not found");
        }
        else{
            System.out.println("Values " + searchValue+ " found at " + posX + " " + posY);
        }
    }

    private void continueLabel(){
        int [][] lis = {{1,13,5},{1,2,5},{2,7,2}};
        int searchValue = 2;
        int posX = -1;
        int posY = -1;
        PARENT_LOOP:
        for (int i = 0; i < lis.length ; i++) {
            for (int j = 0; j < lis[i].length; j++) {
                if(lis[i][j] == searchValue) {
                    posX = i;
                    posY = j;
                    continue PARENT_LOOP;
                }
            }
        }
        if(posX==-1 || posY==-1){
            System.out.println("Value " + searchValue + " not found");
        }
        else{
            System.out.println("Values " + searchValue+ " found at " + posX + " " + posY);
        }
    }


}
