package oca.m5l8;

public class PilotWithCamera implements Photographer, Flyer {
    @Override
    public void takeOff() {
        System.out.printf("Ladies and gentlemen, please fasten your seatbelts%n");
    }

    @Override
    public String takePhoto() {
        return "Slightly shakey image of wide sweeping vista, largely obscured by clouds, from above";
    }
}
