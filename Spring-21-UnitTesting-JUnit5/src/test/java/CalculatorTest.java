import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    @BeforeAll
    static void setUpAll(){
        System.out.println("Before All is executed");
    }

    @BeforeEach
    void setUpEach(){
        System.out.println("Before Each is executed");
    }


    @Test
    void testCase1(){
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();
        assertSame(c1,c2);
        assertNotSame(c1,c3);

    }
    @Test
    void testCase2(){
       String nullString = null;
       String notNullString = "Cydeo";
//       assertNull(nullString);
//       assertNotNull(notNullString);
//       assertNull(notNullString);
       assertNotNull(nullString);


    }
    @Test
    void testCase3(){

        assertTrue(Calculator.operator.equals("add"));

    }
    @Test
    void testCase4(){
        assertFalse(Calculator.operator.equals("abb"));

    }
    @Test
    void testCase5(){assertArrayEquals(new int[]{2,2,3}, new int [] {1,2,3});

    }

    @Test
    void add(){
         int actual = Calculator.add(2,3);
        Assertions.assertEquals(5,actual,"Actual and expected response not match");
    }

    @Test
    void add2(){
        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(5,3));
    }

    @AfterEach
    void tearDownEach(){
        System.out.println("After Each is executed");
    }
    @AfterAll
    void tearDownAll(){
        System.out.println("After All is executed");
    }

}