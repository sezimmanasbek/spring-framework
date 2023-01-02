import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc1","abc2"})
    void testCase1(String args){
        Assertions.assertTrue(!args.isEmpty());

    }

    @ParameterizedTest
    @ValueSource(ints = {3,9})
    void testCase2(int nums){
        Assertions.assertEquals(0,nums%3);

    }

    @ParameterizedTest
    @ValueSource(strings = {"abc1","abc2"})
//    @EmptySource
//    @NullSource
    @NullAndEmptySource
    void testCase3(String args){
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase4(String args){
        Assertions.assertTrue(!args.isEmpty());

    }

    @ParameterizedTest
    @CsvSource({"10,20,30","20,20,40","50,10,100"})
    void testCase5(int num1, int num2, int result){
        Assertions.assertEquals(result,Calculator.add(num1,num2));

    }
    @ParameterizedTest
    @CsvFileSource(resources = "sample-data.csv",numLinesToSkip = 1)
    void testCase6(int num1, int num2, int result){
        Assertions.assertEquals(result,Calculator.add(num1,num2));

    }

    static String[] stringProvider(){
        return new String [] {"Abc","Java","SQL"};
    }
}
