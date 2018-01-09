package oca.m5l8;

public class Main {
    public static void main(String[] args) {
        Photographer [] photographers = {
                new MomWthCamera(),
                new MomWithGrownUpKidsAndCamera(),
                new PilotWithCamera(),
                new SpySatellite()
        };

        for (Photographer photographer : photographers) {
            if(photographer instanceof Flyer){
                ((Flyer) photographer).takeOff();
            }

            String photo = photographer.takePhoto();
            System.out.printf("Image taken by %s is %s%n", photographer.getClass().getName(), photo);

            if (photographer instanceof ProfessionalPhotographer){
                int fee = ((ProfessionalPhotographer) photographer).howMuchDoYouChargeForAnEightByTen();
                System.out.printf("Oh, %s never mind, that's too expensive%n", fee);
            }
            System.out.println("============================");
        }
    }
}
