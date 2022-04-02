/**
@author Saina Ghasemian-Roudsari, Rachel Dalton, Ana Perrone, Isaiah Lemiuex<a 
@version 1.8
@since   1.0
*/
package edu.ucalgary.ensf409;


import java.beans.Transient;
import java.io.FileNotFoundException;
import java.util.regex.*;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class ProjectTest {

    //REQUESTIO CLASS TESTS
    //RequestIO takes from user input and throws IllegalArgumentException when input is a letter, special character 
    // or not a number 

    @Test
    public void testInvalidRequestIO() 
    {
        String[][] input = new String[1];
        input[0][0] = "abc";
        boolean exceptionThrown = false;
        try {
            RequestIO.createOrderFromInput(input); 
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("An illegal argument exception was not thrown when invalid input was provided", exceptionThrown);
    }

    //Test for file not found exception
    @Test
    public void testCreateRequestOutput() {
        boolean exceptionThrown = false;
        try {
            RequestIO.createRequestOutput();
        }
        catch (FileNotFoundException e) {
            exceptionThrown = true;
        }
        assertTrue("A File not found exception was not thrown when createRequestOutput was called", exceptionThrown);
    }

    @Test 
    public void testSetAndGetOrder()
    {
        Order expectedOrder = new Order();
        ArrayList<Hamper> hamperList = new ArrayList<Hamper>();
        ArrayList<Client> clientList = new ArrayList<Client>();
        Hamper hamper = new Hamper(clientList);
        hamperList.add(hamper);
        hamperList.setOrder(hamperList);
        Order foundOrder = order.getOrder();
        assertEquals("The value of the order did not match the expected result ", expectedOrder, foundOrder);
    }

    @Test
    public void testValidateClientInputForIncorrectType()
    {
        String clientType = "Male Child Under 8";
        int clientID = 5;
        boolean expectedValidate = false;
        boolean actualValidate = validateClientInput(clientType, clientID);
        assertEquals("Validate method for client input failed to return false for an invalid input", expectedValidate, actualValidate);

    }

    @Test
    public void testValidateClientInputForIncorrectID()
    {
        String clientType = "Child under 8";
        int clientID = -5;
        boolean expectedValidate = false;
        boolean actualValidate = validateClientInput(clientType, clientID);
        assertEquals("Validate method for client input failed to return false for an invalid input", expectedValidate, actualValidate);

    }

    //ORDER CLASS TESTS

    @Test
    public void testOrderConstructor()
    {
        Order order = new Order();
        assertNotNull("The default Hamper constructor did not create an object when called with no arguments", order);
    }

    @Test
    public void testAddToOrder()
    {
        Client[] clients = new Client[1];
        clients[0] = new Client("2", "Adult Female", 2000, 25, 25, 25, 25);
        Hamper hamper = new Hamper(clients);
        order.addToOrder(hamper);
        
        assertNotNull("The ArrayList of Hampers is null after creating a new Order and adding a Hamper to it", order.getHampers().get(0));
    }

    //Method calculateNutrition adds the nutrition requirements of each client in the hamper, for each hamper in the Order. 
    //It returns an array with one Nutrition object per Hamper in the array.

    @Test
    public void testCalculateNutrition()
    {
        Order order = new Order();
        Client[] clients = new Client[2];
        clients[0] = new Client("2", "Adult Female", 2000, 25, 25, 25, 25);
        clients[1] = new Client("3", "Adult Male", 2000, 25, 25, 25, 25);
        Hamper hamper = new Hamper(clients);
        order.addToOrder(hamper);
        Nutrition[] expectedNutrition = new Nutrition(4000, 25, 25, 25, 25);
        Nutrition[] foundNutrition = order.calculateNutrition(hamper);

        assertEquals("The value of the Nutrition array created by calculateNutrition did not match the expected result ", expectedNutrition, foundNutrition);
    }

    @Test 
    public void testGetHampers()
    {
        Order order = new Order();
        Client[] clients = new Client[2];
        clients[0] = new Client("2", "Adult Female", 2000, 25, 25, 25, 25);
        clients[1] = new Client("3", "Adult Male", 2000, 25, 25, 25, 25);
        Hamper hamper = new Hamper(clients);
        order.addToOrder(hamper);
        ArrayList<Hamper> expectedHampers = new ArrayList<Hamper>();
        expectedHampers.set(0, hamper);
        ArrayList<Hamper> foundHampers = order.getHampers();

        assertEquals("The value of the Hamper arrayList in order did not match the expected result ", expectedHampers, foundHampers);
    }

    //HAMPER CLASS TESTS

    //testHamperConstructor() tests to see if the Hamper constructor creates a non-null object when given appropriate arguments.

    @Test
    public void testHamperConstructor() 
    {
        Client[] clients = new Client[1];
        clients[0] = new Client("2", "Adult Female", 2000, 25, 25, 25, 25);
        Hamper hamper = new Hamper(clients);
        assertNotNull("Hamper constructor did not create an object when given a list of clients", hamper);
    }

    //testSetandGetFood() tests the setFood() method for a Hamper object by setting the food field of the object,
    //then using getFood() method to get the object's food field. Then compares this return to the expected return object.

    @Test
    public void testSetAndGetFood() 
    {
        Food[] expectedFood = new Food[1];
        expectedFood[0] = new Food("10", "Apple", 5, 10, 23, 7, 8);
        Hamper hamper = new Hamper(null);
        hamper.setFood(expectedFood);
        Food foundFood = hamper.getFood();
        assertEquals("The value of the Food array in hamper did not match the expected result ", expectedFood, foundFood);
    }

    //testGetClients() tests the getClients() method for an Order object. Constructs an Order object using a Client object, 
    //then gets the clients field getter. Then compares this return to the expected result.

    @Test
    public void testGetClients() 
    {
        Order order = new Order();
        Client[] expectedClients = new Client[1];
        expectedClients[0] = new Client("2", "Adult Female", 2000, 25, 25, 25, 25);
        Hamper hamper = new Hamper(expectedClients);
        Client[] foundClients = hamper.getClients();
        assertEquals("The value of the Client array in Hamper did not match the expected result", expectedClients, foundClients);
    }

    //CLIENT CLASS TESTS

    //testClientConstructor() tests to see if the Client constructor creates a non-null object when given appropriate arguments.

    @Test
    public void testClientConstructor() {
        Client client = new Client("2", "Adult Female", 2000, 25, 25, 25, 25);
        assertNotNull("Client constructor did not create a new object of type Client when given the appropriate arguments", client);
    }

    //testGetNutritionClient() tests the getNutrition() method for a Client object. Constructs a Client object using appropriate
    //arguments, then compares this against the expected Nutrition object.

    @Test 
    public void testGetNutritionClient() {
        Client client = new Client("2", "Adult Female", 2000, 25, 25, 25, 25);
        Nutrition expectedNutrition = new Nutrition(2000, 25, 25, 25, 25);
        Nutrition actualNutrition = client.getNutrition();
        assertEquals("The Nutrition object of Client did not match the expected result", expectedNutrition, actualNutrition);
    }

    //NUTRITION CLASS TESTS

    //testNutritionConstructor() tests to see if Nutrition constructor creates a non-null object when given appropriate arguments.
    
    @Test
    public void testNutritionConstructor()
    {
        Nutrition nutrition = new Nutrition(2000, 25, 25, 25, 25);
        assertNotNull("Nutrition constructor did not create a new object of type Nutrition when given the appropriate arguments", nutrition);
    }

    //testGetTotalCals() tests the getTotalCals() method for a Nutrition object. Constructs a Nutrition object using appropriate arguments
    //then uses the totalCals field getter, and compares this against the expected totalCals.

    @Test
    public void testGetTotalCals()
    {
        Nutrition nutrition = new Nutrition(2000, 25, 25, 25, 25);
        int expectedTotalCals = 2000;
        int actualTotalCals = nutrition.getTotalCals();
        assertEquals("The totalCals of Nutrition object did not match the expected result", expectedTotalCals, actualTotalCals);
    }

    //testGetPercentGrains() tests the getPercentGrains() method for a Nutrition object. Constructs a Nutrition object using appropriate arguments
    //then uses the percentGrains field getter, and compares this against the expected percentGrains.

    @Test
    public void testGetPercentGrains()
    {
        Nutrition nutrition = new Nutrition(2000, 40, 20, 20, 20);
        int expectedPercentGrains = 40;
        int actualPercentGrains = nutrition.getPercentGrains();
        assertEquals("The percentGrains of Nutrition object did not match the expected result", expectedPercentGrains, actualPercentGrains);
    }

    //testGetPercentFV() tests the getpercentFV() method for a Nutrition object. Constructs a Nutrition object using appropriate arguments
    //then uses the percentFV field getter, and compares this against the expected percentFV.

    @Test
    public void testGetPercentFV()
    {
        Nutrition nutrition = new Nutrition(2000, 20, 40, 20, 20);
        int expectedPercentFV = 40;
        int actualPercentFV = nutrition.getPercentFV();
        assertEquals("The percentFV of Nutrition object did not match the expected result", expectedPercentFV, actualPercentFV);
    }

    //testGetPercentProtein() tests the getpercentProtein() method for a Nutrition object. Constructs a Nutrition object using appropriate arguments
    //then uses the percentProtein field getter, and compares this against the expected percentProtein.

    @Test
    public void testGetPercentProtein()
    {
        Nutrition nutrition = new Nutrition(2000, 20, 20, 40, 20);
        int expectedPercentProtein = 40;
        int actualPercentProtein = nutrition.getPercentProtein();
        assertEquals("The percentProtein of Nutrition object did not match the expected result", expectedPercentProtein, actualPercentProtein);
    }

    //testGetPercentOther() tests the getpercentOther() method for a Nutrition object. Constructs a Nutrition object using appropriate arguments
    //then uses the percentOther field getter, and compares this against the expected percentOther.

    @Test
    public void testGetPercentOther()
    {
        Nutrition nutrition = new Nutrition(2000, 20, 20, 20, 40);
        int expectedPercentOther = 40;
        int actualPercentOther = nutrition.getPercentOther();
        assertEquals("The percentOther of Nutrition object did not match the expected result", expectedPercentOther, actualPercentOther);
    }

    //FOOD CLASS TESTS

    //testFoodConstructor() tests to see if Food constructor creates a non-null object when given the appropriate arguments.

    @Test
    public void testFoodConstructor()
    {
        Food food = new Food("10", "Apple", 5, 10, 23, 7, 8);
        assertNotNull("Food constructor did not create a new object of type Food when given the appropriate arguments", food);
    }

    //testGetItemID() tests the getItemID() method for a Food object. Constructs a Food object using appropriate arguments,
    //then uses the itemID field getter, and compares this against the expected itemID.

    @Test
    public void testGetItemID()
    {
        Food food = new Food("10", "Apple", 5, 10, 23, 7, 8);
        String expectedItemID = "10";
        String actualItemID = food.getItemID();
        assertEquals("The itemID of Food object did not match the expected result", expectedItemID, actualItemID);
    }

    //testGetName() tests the getName() method for a Food object. Constructs a Food object using appropriate arguments,
    //then uses the name field getter, and compares this against the expected name.

    @Test
    public void testGetName()
    {
        Food food = new Food("10", "Apple", 5, 10, 23, 7, 8);
        String expectedName = "Apple";
        String actualName = food.getName();
        assertEquals("The name of Food object did not match the expected result", expectedName, actualName);
    }

    //testGetNutrition() tests the getNutrition() method for a Food object. Constructs a Food object using appropriate arguments,
    //then uses the nutrition field getter, and compares this against the expected nutrition.

    @Test
    public void testGetNutritionFood()
    {
        Food food = new Food("10", "Apple", 5, 10, 23, 7, 8);
        String expectedNutrition = new Nutrition(5, 10, 23, 7, 8);
        String actualNutrition = food.getNutrtition();
        assertEquals("The nutrition of Food object did not match the expected result", expectedNutrition, actualNutrition);
    }


    //DATABASE CLASS TESTS
    
    @Test
    public void testDefaultDatabaseConstructor() 
    {
        Database database = new Database();
        assertNotNull("The default Database constructor did not create an object when called with no arguments", database);
    }

    @Test
    public void testDatabaseConstructor()
    {
        ArrayList<Client> clientList = new ArrayList<Client>();
        ArrayList<Food> foodList = new ArrayList<Food>();
        Database database = new Database(clientList, foodList);
        assertNotNull("The Database constructor did not create an object when called with client and food array lists", database);
    }

    @Test
    public void testRemoveFoodByID()
    {
        Database database = new Database();
        String id = "1738";
        ArrayList<Food> foodList = new ArrayList<Food>();
        Food food = new Food("1738", "Apple", 5, 10, 23, 7, 8);
        foodList.add(food); 
        database.removeFoodByID(id); 
        boolean check = foodList.contains(id); 
        assertTrue("The method removeFoodByID did not remove a given string id from the food list array", !check); 
    }

    @Test
    public void testGetClientList()
    {
        Database database = new Database();
        ArrayList<Client> expectedList = new ArrayList<Client>();
        Client client = new Client(2, "Adult Female", 2000, 25, 25, 25, 25);
        expectedList.add(client);
        ArrayList<Client> actualList = database.getClientList();
        assertEquals("The client list of the database did not match the expected result, ", expectedList, actualList);
    }

    @Test
    public void testGetFoodList() //Needs review
    {
        Database database = new Database();
        ArrayList<Food> expectedList = new ArrayList<Food>();
        Food food = new Food("10", "Apple", 5, 10, 23, 7, 8);
        expectedList.add(food);
        ArrayList<Food> actualList = database.getFoodList();
        assertEquals("The food list of the database did not match the expected result, ", expectedList, actualList);
    }

    //INVENTORY CLASS TESTS

    //Test if method findHamperCombo throws an InsufficientInventoryException when there is not enough inventory
    //to complete an order. We initialize the foodList in Database to have only one food object with 100 calories. 
    //The Nutrition list supplied to the method findHamperCombo contains one Nutrition which requires 2000 total calories.
    //The method should throw an InsufficientInventoryException since there is not enough inventory to fill this requirement. 

    @Test
    public void testFindHamperComboException()
    {
        boolean exceptionThrown = false;

        ArrayList<Food> foodList = new ArrayList<Food>();
        Food food = new Food("10", "Apple", 100, 10, 23, 7, 9);
        foodList.add(food);

        Database database = new Database(null, foodList);

        Nutrition[] nutritionList = new Nutrition[1];
        Nutrition nutrition = new Nutrition(2000, 20, 20, 40, 20);
        nutritionList.add(nutrition);

        try
        {
            Inventory.findHamperCombo(nutritionList);
        }
        catch(InsufficientInventoryException e)
        {
            exceptionThrown = true;
        }

        assertTrue("The method findHamperCombo did not throw an InsufficientInventoryException when there was not enough
        inventory to complete the order", exceptionThrown);
    }

    //Test if the Food list generated by the method findHamperCombo contains enough total calories to satisfy the order requirements.

    @Test
    public void testFindHamperCombo() // not done
    {

        ArrayList<Food> foodList = new ArrayList<Food>();
        Food apple = new Food("10", "Apple", 100, 10, 23, 7, 9);
        Food chocolate = new Food("14", "Chocolate", 1300, 10, 45, 2, 10);
        foodList.add(apple);
        foodList.add()

        Database database = new Database(null, foodList);

        Nutrition[] nutritionList = new Nutrition[1];
        Nutrition nutrition = new Nutrition(1200, 20, 20, 40, 20);
        nutritionList.add(nutrition);
    }

    @Test
    public void testCompleteOrderForm() //Ana not done
    {
        ArrayList<Food> foodList = new ArrayList<Food>();
    }

    //CLIENTTYPES ENUMERATION TESTS

    @Test
    public void testClientTypes()
    {
         //ADULFEMALE
        String expected = "Adult Female";
        String actual = ClientTypes.ADULFEMALE.toString();
        assertEquals("Enumeration Direction toString Method not returning correct String", expected, actual);
        //Adult Male
        expected = "Adult Male";
        actual = ClientTypes.ADULTMALE.toString();
        assertEquals("Enumeration Direction toString Method not returning correct String", expected, actual);
        //Child Over 8
        expected = "Child Over 8";
        actual = ClientTypes.CHILDOVER8.toString();
        assertEquals("Enumeration Direction toString Method not returning correct String", expected, actual);
        //Child under 8
        expected = "Child Under 8";
        actual = ClientTypes.CHILDUNDER8.toString();
        assertEquals("Enumeration Direction toString Method not returning correct String", expected, actual);
    }
}
