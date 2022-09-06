package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    private boolean expected;
    private String sex;

    public LionTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "sex: {0}, return {1}")
    public static Object[][] getMane() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(sex);
        assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion("Самец");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void getKittens() {
        Kittens feline = new Feline();
        Lion lion = new Lion(feline);
        assertEquals(1, lion.getKittens());
    }
}