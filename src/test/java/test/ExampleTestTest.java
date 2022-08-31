package test;

import kolo.Calculator;
import kolo.CheckEvenNumber;
import kolo.Fixture;
import kolo.Shape;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleTestTest{

    @Test
   public void shouldShowSimpleAssertion(){
        Assertions.assertEquals(1, 1, "Value is equal");
    }

    @Test
    @DisplayName("Should CheckAllItems")
    public void shouldCheckAllItemsInTheList(){
        List<Integer> numbers = List.of(2,3,4,5,6,9);
        Assertions.assertAll(() ->assertEquals(2, numbers.get(0), "Valid"),
                () -> assertEquals(3, numbers.get(1), "Valid"),
                () -> assertEquals(4, numbers.get(2), "Valid"),
                () -> assertEquals(5, numbers.get(3), "Valid"),
                () -> assertEquals(6, numbers.get(4), "Valid"),
                () -> assertEquals(9, numbers.get(5), "Valid"));
    }

    @Test
    @DisplayName("CheckEvenNumber")
    public void checkEvenNumberTest(){
        CheckEvenNumber checkEvenNumber = new CheckEvenNumber();
        Assertions.assertTrue(checkEvenNumber.checkValue(110));
    }

    @Test
    @DisplayName("Should only run the test if so")
    public void shouldOnlyRunTheTestIfSo(){


        Assumptions.assumeTrue(Fixture.apiVersion() >10);
        //these tests only apply to a recent API version higher than 10
        assertEquals(1,1);
    }

    @ParameterizedTest
    @DisplayName("Should create shapes with different numbers of side")
    @ValueSource(ints = {3,4,5,6,14})

    public void shouldCreateShapesWithDifferentNumbersofSide(int expectedNumberOfSides){
       Shape shape = new Shape(expectedNumberOfSides);
       assertEquals(expectedNumberOfSides, shape.numberOfSides(), "Valid");
        //fail("Not Implemented");

    }

    @ParameterizedTest
    @DisplayName("Should not create shapes with invalid numbers of side")
    @ValueSource(ints = {0,1,2,Integer.MAX_VALUE})
    public void shouldNotCreateShapesWithInvalidNumbersofSide(int expectedNumberOfSides){
        Shape shape = new Shape(expectedNumberOfSides);
        assertThrows(IllegalArgumentException.class,
                () -> new Shape(expectedNumberOfSides));
        //assertEquals(expectedNumberOfSides, shape.numberOfSides(), "Valid");
        //fail("Not Implemented");

    }
}