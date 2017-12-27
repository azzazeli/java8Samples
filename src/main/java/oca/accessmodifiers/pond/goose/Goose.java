package oca.accessmodifiers.pond.goose;

import oca.accessmodifiers.pond.shore.Bird;

public class Goose extends Bird {
    public void helpGooseSwim(){
        Goose goose = new Goose();
        goose.floatInWater();
        System.out.println(goose.text);
    }

    public void helpOtherGooseSwim(){
        Bird other = new Goose();
//        other.floatInWater();
//        System.out.println(other.text);
    }
}
