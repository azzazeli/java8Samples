package oca.accessmodifiers.pond.swan;

import oca.accessmodifiers.pond.shore.Bird;

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
//        bird.floatInWater();
//        System.out.println(bird.text);
    }
}
