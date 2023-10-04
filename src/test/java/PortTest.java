import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class PortTest {

    @Test
    public void getArrayOfNumbers() {
        Port port = new Port(new String[]{"1,3-5", "2", "3-4"});
        int[] actual = port.getArrayOfNumbers();

        int[] expected = {1, 3, 4, 5, 2, 3, 4};

        Assert.assertArrayEquals(expected, actual);

        Assert.assertArrayEquals(new int[]{1}, new Port(new String[]{"1"}).getArrayOfNumbers());
        Assert.assertArrayEquals(new int[]{}, new Port(new String[]{}).getArrayOfNumbers());
    }

    @Test
    public void getUniqueGroups() {
        Port port = new Port(new String[]{"1,3-5", "2", "3-4"});
        Set<List<Integer>> actual = port.getUniqueGroups();
        Set<List<Integer>> expected = Set.of(List.of(1, 2, 3),
                List.of(1, 2, 4), List.of(3, 2, 3), List.of(3, 2, 4), List.of(4, 2, 3),
                List.of(4, 2, 4), List.of(5, 2, 3), List.of(5, 2, 4));
        Assert.assertEquals(expected, actual);
    }
}