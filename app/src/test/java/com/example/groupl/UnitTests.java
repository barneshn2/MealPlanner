package com.example.groupl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTests {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void sum_isCorrect(){
        Sum mySum = new Sum();
        assertEquals(mySum.sum(10, 2), 12);
    }

    @Test
    public void sum_isInCorrect(){
        Sum mySum = new Sum();
        assertEquals(mySum.sum(10, 2), 8);
    }


    @Test
    public void multiply_isCorrect(){
        Sum mySum = new Sum();
        assertEquals(mySum.multiply(10, 2), 20);
    }

    @Test
    public void multiply_isInCorrect(){
        Sum mySum = new Sum();
        assertEquals(mySum.multiply(10, 2), 22);
    }
}