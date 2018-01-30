package oca.ch4.swan;

import oca.ch4.shore.Bird;

public class Swan extends Bird {
    public void swim(){
        floatInWater();
        System.out.println(text);
    }
    public void helpOtherSwanSwim(){
        Swan other = new Swan();
        other.floatInWater();
        System.out.println(other.text);
    }

    public void helpOtherBirdSwim(){
        Bird bird = new Bird();
        //the code just happens to be in the Swan class
//        bird.floatInWater(); //floatInWater has protected access
//        System.out.println(bird.text); //text has protected access
    }
}
