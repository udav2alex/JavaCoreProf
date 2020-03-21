package homework6;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArrayTailMakerTest {
    private static int[] testParameter;
    private static int[] testAssert;

    @Test (expected = RuntimeException.class)
    public void ArrayTailMakerTestException() {
        testParameter = new int[] {5, 6, 7};
        testAssert = new int[] {};
        makeTest(testParameter, testAssert);
    }

    @Test (expected = RuntimeException.class)
    public void ArrayTailMakerTestEmpty() {
        testParameter = new int[] {};
        testAssert = new int[] {};
        makeTest(testParameter, testAssert);
    }

    @Test
    public void ArrayTailMakerTestFirst() {
        testParameter = new int[] {4, 5, 6, 7};
        testAssert = new int[] {5, 6, 7};
        makeTest(testParameter, testAssert);
    }

    @Test
    public void ArrayTailMakerTestLast() {
        testParameter = new int[] {1, 2, 3, 4};
        testAssert = new int[] {};
        makeTest(testParameter, testAssert);
    }

    @Test
    public void ArrayTailMakerTestMiddle() {
        testParameter = new int[] {1, 2, 3, 4, 5, 6, 7};
        testAssert = new int[] {5, 6, 7};
        makeTest(testParameter, testAssert);
    }

    @Test
    public void ArrayTailMakerTestMiddle2() {
        testParameter = new int[] {1, 2, 3, 4, 3, 4, 5, 6, 7};
        testAssert = new int[] {5, 6, 7};
        makeTest(testParameter, testAssert);
    }

    @Test
    public void ArrayTailMakerTestSequenced() {
        testParameter = new int[] {1, 2, 3, 4, 4, 4, 5, 6, 7};
        testAssert = new int[] {5, 6, 7};
        makeTest(testParameter, testAssert);
    }

    private void makeTest(int[] MyTestParameter, int[] MyTestAssert) {
        int[] testResult = ArrayTailMaker.getTailFor4(MyTestParameter);
        System.out.println(Arrays.toString(testResult));
        Assert.assertArrayEquals(testResult, MyTestAssert);
    }
}
