package edu.ucalgary.ensf409;


import java.beans.Transient;
import java.util.regex.*;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class ProjectTest {

    //REQUESTIO TESTS

    @Test
    public void testInvalidRequestIO() {
        String input = "abc";
        boolean exceptionThrown = false;
        try {
            createOrderFormInput(input); //method throwing exception not constructor 
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("An illegal argument exception was not thrown when invalid input was provided", exceptionThrown);
    }

    //test for file not found exception
    @Test
    public void testCreateRequestOutput()
    {

    }

    @Test 
    public void testGetOrder()
    {

    }

    @Test
    public void testValidateClientInput()
    {
        
    }

    //HAMPER TESTS

    @Test
    public void testHamperConstructor() 
    {
        Client[] clients = new Client[1];
        //clients[0] = new Client(2, "ADULTFEMALE", )
        Hamper hamper = new Hamper(null);
        assertNotNull("Hamper constructor did not create an object when given a list of clients");
    }

    @Test
    public void testSetAndGetFood() 
    {
        Food[] expectedFood = new Food[1];
        Nutrition nutrition = new Nutrition(5, 10, 23, 7, 8);
        food[0] = new Food("10", "Apple", nutrition);
        expectedFood[0] = new Food("10", "Apple", nutrition);
        Hamper hamper = new Hamper(null, null);
        hamper.setFood(expectedFood);
        foundFood = hamper.getFood();
        assertEquals("Method setFood did not return the expected result: ", expectedFood, foundFood);
    }

    @Test
    public void testSetAndGetClients() {
        
    }

    //CLIENT TESTS

    @Test
    public void testClientConstructor() {

    }

    @Test 
    public void testGetNutrition() {

    }
    

    @Test
    public void testCalculateNutrition()
    {

    }

    @Test 
    public void testOrder()
    {

    }

    @Test
    public void testAddToOrder()
    {

    }


    //Throw Tests
    //Exceptions
    //InsufficientInventoryException
    //FileNotFoundException
    //IllegalArgumentException

    //RequestIO takes from user input and throws IllegalArgumentException when input is a letter, special character 
    // or not a number 

    


    @Test
    public void testClientIllegalArgument() {

    }
    
    




    /*
    Enumeration Method Tests
    */

}
