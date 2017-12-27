package com.samples.java8.crx;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SimpleRainWaterServiceImplTest {

    private SimpleRainWaterServiceImpl impl = new SimpleRainWaterServiceImpl();

    @Test
    public void testWrongInput() throws Exception {
        assertEquals(0L, impl.volume(null));
        assertEquals(0L, impl.volume(new int[]{1, 2}));
    }

    /**
     * 4
     * |-|  3
     * | |2|-|
     * | |-| |
     * |_|_|_|
     */
    @Test
    public void testSimpleCases() {
        assertEquals(1, impl.volume(new int[]{4, 2, 3}));
        assertEquals(1, impl.volume(new int[]{3, 2, 4}));
        assertEquals(2, impl.volume(new int[]{4, 1, 3}));
        assertEquals(2, impl.volume(new int[]{4, 1, 1, 2}));
        assertEquals(6, impl.volume(new int[]{4, 1, 1, 4}));
        assertEquals(5, impl.volume(new int[]{4, 2, 1, 4}));
    }

    @Test
    public void testNoHoles() {
        assertEquals(0, impl.volume(new int[]{4, 7, 2, 1}));
        assertEquals(0, impl.volume(new int[]{4, 2, 2, 1}));
    }

    @Test
    public void testCaseRecalculateHoleVolume() {
        assertEquals(8, impl.volume(new int[]{4, 1, 1, 0, 2, 3}));
    }

    @Test
    public void testCseWith2Holes() {
        assertEquals(2, impl.volume(new int[]{3, 2, 4, 1, 2}));
        assertEquals(22, impl.volume(new int[]{7, 1, 4, 1, 8, 1, 9}));
        assertEquals(17, impl.volume(new int[]{5, 0, 0, 3, 0, 6}));
    }

    @Test
    public void testNoRightHole() {
        assertEquals(1, impl.volume(new int[]{1, 4, 2, 3}));
    }

    @Test
    public void testComplexHole() {
        assertEquals(8, impl.volume(new int[]{4, 1, 2, 1, 4}));
    }

    @Test
    public void testComplexCases() {
        assertEquals(13, impl.volume(new int[]{2, 1, 4, 0, 2, 0, 2, 4, 3, 1}));
        assertEquals(17, impl.volume(new int[]{0, 3, 5, 8, 8, 3, 7, 0, 5, 8}));
        assertEquals(24, impl.volume(new int[]{0, 8, 9, 2, 4, 6, 0, 9, 3, 0}));
        assertEquals(8, impl.volume(new int[]{9, 3, 5, 8, 7, 6, 4}));
    }


}