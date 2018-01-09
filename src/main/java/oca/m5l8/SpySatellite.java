package oca.m5l8;

public class SpySatellite extends Asset implements Photographer, Flyer {
    public SpySatellite() {
        super(1_000_000_000);
    }

    @Override
    public void takeOff() {
        System.out.println("Picture of your neighbor's house with unmarked truck outside and people furtively carrying " +
                "odd-shaped package inside. License plate of truck clearly readable.");
    }

    @Override
    public String takePhoto() {
        return "Roar of unimaginable quantities of hydrazine burning, huge amounts of heat and noise , " +
                "rapidly diminishes to nothin but a thin vertical vapor trail";
    }
}
