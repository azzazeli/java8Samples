package oca.ch3;

import java.util.ArrayList;
import java.util.List;

public class AutoBoxingSamples {
    public static void main(String[] args) {
        AutoBoxingSamples samples = new AutoBoxingSamples();
        samples.testNPE();
    }

    private void testNPE(){
        List<Integer> list = new ArrayList<>();
        list.add(null);
        int i = list.get(0);
    }
}
