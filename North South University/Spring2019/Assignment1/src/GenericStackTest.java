/**
 * 
 */

/**
 * @author Syam
 *
 */
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

//@RunWith(Parameterized.class)
@RunWith(Theories.class)
public class GenericStackTest {

    /*This data points will check all possible combinations 
      of Integer, String, Double and Float type data.
      */

    /* --  Data Points -- */
    @DataPoints
    public static int[] dummyIntArray = {1, 2, 0, -888, -8885555, 0, 543654};
    @DataPoints
    public static String[] dummyStringArray = {"abcd", "", "   ", null, "aaaaaaaaaaaaaaa"};
    @DataPoints
    public static Double[] dummyDoubleArray = {1.20, 2.35, 225.55, -6698.25, -0.0, +0.00, 789.25874125899632147222547755221145222355};
    @DataPoints
    public static Float[] dummyFloatArray = {5.20f, 2.35f, -445.2f, +58936.02244f, +0.0f, -0.0f, 123.47896547885221445532444555522222244751202030225f};

    /* -- Different Type Of GenericStack Object to Test Different Data Types -- */
    GenericStack<Integer> genericStackInteger = new GenericStack<>();
    GenericStack<String> genericStackString = new GenericStack<>();
    GenericStack<Double> genericStackSDouble = new GenericStack<>();
    GenericStack<Float> genericStackFloat = new GenericStack<>();

    Integer item;
    int counter = 0;

    public GenericStackTest(int item) {
        this.item = item;
        counter++;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5}, {50}, {-2500}, {}, {0}, {-0}, {2222.222f}, {"asasasasa"}, {222555555}, {-0.222222222111111112222222}
        });
    }

    @Test
    public void isEmpty() {
        assertEquals(true, genericStackInteger.isEmpty());
    }

    //Pushing Data from Parameters
    @Test
    public void push() {
        assertEquals(item, genericStackInteger.push(item));
    }

    @Test
    public void pop() {
        push();
        assertEquals(item, genericStackInteger.pop());
    }

    /* -- Methods are getting parameters from DataPoints -- */
    @Theory
    public void pushWithIntegerData(Integer item) throws Exception {
        assertEquals(item, genericStackInteger.push(item));
    }

    @Theory
    public void pushWithStringrData(String item) throws Exception {
        System.out.println(item);
        assertEquals(item, genericStackString.push(item));
    }

    @Theory
    public void pushWithDoubleData(Double item) throws Exception {
        System.out.println(item);
        assertEquals(item, genericStackSDouble.push(item));
    }

    @Theory
    public void pushWithFloatData(Float item) throws Exception {
        System.out.println(item);
        assertEquals(item, genericStackFloat.push(item));
    }

    /* -- Common Method To POP All item -- */
    public void PopAll() {
        while (!genericStackInteger.isEmpty()) {
            int popedItem = genericStackInteger.pop();
            System.out.println("popped = " + popedItem);
        }
    }

    /* -- The Following Methods pushing and Poping Datas and check whether the stack is empty-- */
    @Test
    public void PushPopIntegerTest() throws Exception {
        int[] intArr = {5, 6, 7, 8, 9, 10};
        for (int i = 0; i < intArr.length; i++) {
            pushWithIntegerData(intArr[i]);
        }
        PopAll();
        assertEquals(true, genericStackInteger.isEmpty());
    }

    @Test
    public void PushPopStringTest() throws Exception {
        String[] strArr = {"", "aaaaaa", null};
        for (int i = 0; i < strArr.length; i++) {
            pushWithStringrData(strArr[i]);
        }
        PopAll();
        assertEquals(true, genericStackString.isEmpty());
    }

    @Test
    public void PushPopFloatTest() throws Exception {
        Float[] floatArr = {115.22f, 55.1f, 789.258f, 5555f, null};
        for (int i = 0; i < floatArr.length; i++) {
            pushWithFloatData(floatArr[i]);
        }
        PopAll();
        assertEquals(true, genericStackFloat.isEmpty());
    }

    @Test
    public void PushPopDoubleTest() throws Exception {
        Double[] doubleArr = {12.00, 58.96, 5544554545.223, null};
        for (int i = 0; i < doubleArr.length; i++) {
            pushWithDoubleData(doubleArr[i]);
        }
        PopAll();
        assertEquals(true, genericStackSDouble.isEmpty());
    }
}
