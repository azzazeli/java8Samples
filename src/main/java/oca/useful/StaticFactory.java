package oca.useful;

public class StaticFactory {
    public static void main(String[] args) {
        Useful u = Useful.getOne(9);
        u.beUseful();
    }
}
