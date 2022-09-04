package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTest {

    Feline feline = new Feline();
    private List expected;
    private String animalKind;

    public FelineTest(String animalKind, List expected) {
        this.animalKind = animalKind;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getFood() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void eatMeat() throws Exception {
        assertEquals(expected, feline.getFood(animalKind));
    }

    @Test
    public void getFamily() {
        assertEquals("Кошачьи", feline.getFamily());

    }

    @Test
    public void getKittens() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWhenReturnKittensCount() {
        assertEquals(2, feline.getKittens(2));
    }
}