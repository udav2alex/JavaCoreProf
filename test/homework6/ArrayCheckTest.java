package homework6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayCheckTest {
    private int[] array;
    private boolean assertResult;

    public ArrayCheckTest(int[] array, boolean assertResult) {
        this.array = array;
        this.assertResult = assertResult;
    }

    @Parameterized.Parameters
    public static Collection<Object> testData() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 3}, false},               // ни одного, ни другого
                {new int[]{1, 2, 3, 4}, true},          // и одно, и другое
                {new int[]{1, 1, 2, 3, 4, 4}, true},    // и одно, и другое несколько раз
                {new int[]{1, 2, 3}, false},            // только одно
                {new int[]{2, 3, 4}, false}             // только другое
        });
    }

    @Test
    public void checkArrayTest() {
        Assert.assertTrue(ArrayCheck.checkArray(array) == assertResult);
    }
}
