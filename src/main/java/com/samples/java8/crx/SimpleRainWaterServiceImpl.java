package com.samples.java8.crx;

/**
 * Simple implementation of RainWaterService
 * //todo: describe algorithm complexity
 */
public class SimpleRainWaterServiceImpl implements RainWaterService {
    /**
     * @param input array of ints;
     *              if provided array is null or have less then 3 elements return 0;
     * @return volume of water
     */
    @Override
    public int volume(int[] input) {
        if (input == null || input.length < 3) {
            return 0;
        }

        //init
        int result = 0;
        int leftIndex = 0;
        int min = Integer.MAX_VALUE;
        int holeVolume = 0;

        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i - 1]) { //hole here
                int tmp = Math.min(input[i], input[leftIndex]);
                if (tmp > min) {
                    //the case when hole became bigger
                    holeVolume = calculateVolume(input, leftIndex + 1, i, tmp);
                } else {
                    holeVolume += calculateVolume(input, leftIndex + 1, i, tmp);
                }
                min = tmp;
                if (input[i] >= input[leftIndex]) {
                    //next hole
                    leftIndex = i;
                    result += holeVolume;
                    holeVolume = 0;
                }
            }
        }

        if(holeVolume!=0) result+=holeVolume;//one simple hole
        return result;
    }

    private int calculateVolume(int[] input, int start, int end, int min) {
        int result = 0;
        for (int j = start; j < end; j++) {
            result += min - input[j];
        }
        return result;
    }
}
