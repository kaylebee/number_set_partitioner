package number.partitioner;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class NumberSetPartitionerTest
    extends TestCase
{

    @Test
    public void testDivide1() {
        Integer[] nums1 = {10, 11, 7, 7, 12};
        List<List<Integer>> result1 = NumberSetPartitioner.divide(nums1, 2);
        assertEquals(Arrays.asList(Arrays.asList(11, 12), Arrays.asList(10, 7, 7)), result1);
    }

    @Test
    public void testDivide2() {
        Integer[] nums2 = {5, 2, 6, 4, 3, 6};
        List<List<Integer>> result2 = NumberSetPartitioner.divide(nums2, 4);
        assertEquals(Arrays.asList(Arrays.asList(5), Arrays.asList(6), Arrays.asList(4, 3), Arrays.asList(2, 6)), result2);
    }

    @Test
    public void testDivide3() {
        Integer[] nums6 = {1, 1, 1, 1, 1, 1};
        List<List<Integer>> result6 = NumberSetPartitioner.divide(nums6, 3);
        assertEquals(Arrays.asList(Arrays.asList(1), Arrays.asList(1, 1), Arrays.asList(1, 1, 1)), result6);
    }

    @Test
    public void testDivide4() {
        Integer[] nums6 = {1, 2, 3, 4, 5, 6};
        List<List<Integer>> result6 = NumberSetPartitioner.divide(nums6, 3);
        assertEquals(Arrays.asList(Arrays.asList(6), Arrays.asList(1, 2, 4), Arrays.asList(3, 5)), result6);
    }

    @Test
    public void testDivideNull() {
        Integer[] nums3 = {7, 8, 12, 1};
        List<List<Integer>> result3 = NumberSetPartitioner.divide(nums3, 3);
        assertNull(result3);
    }
}
