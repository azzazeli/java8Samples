package oca.enthuware.sampletest;

interface House {
    default String getAddress() {
        return "101 Main Str";
    }
}
interface Bungalow extends House {
    default String getAddress() {
        return "101 Smart Str";
    }
}

class MyHouse implements Bungalow, House{
}

public class DefaultQuestion {

    public static void main(String[] args) {
        House house = new MyHouse();
        System.out.println(house.getAddress());

        System.out.println("=====================");
        MyHouse myHouse = new MyHouse();
        System.out.println(myHouse.getAddress());
    }

}
