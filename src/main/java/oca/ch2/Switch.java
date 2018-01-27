package oca.ch2;

public class Switch {
    public static void main(String[] args) {

    }

    private int getSortOrder(String firstName, final String lastName) {
        String middleName = "Patricia";
        final String suffix = "JR";
        int id = 0;
        switch (firstName){
            case "Test":
                return 52;
//            case middleName:
//                id = 5;
//                break
            case suffix:
                id = 0; break;
//            case lastName:
//                id = 8; break;

        }
        return id;
    }
}
