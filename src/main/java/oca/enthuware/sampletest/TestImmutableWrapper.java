package oca.enthuware.sampletest;

public class TestImmutableWrapper {
    public static void testInts(Integer obj, int var){
        obj = var++;
        obj++;
    }

    public static void main(String[] args) throws Exception {
        Integer vall = new Integer(5);
        int val2 = 9;
        testInts(vall++, ++val2);
        System.out.println(vall + " " + val2);
    }
}
