package java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class ListUtilTest {

    @Test
    public void countDuplicate() {
        List<String> strings = asList("java", "JAVA", "JaVa", "Scala");
        int amount = ListUtil.countDuplicate("java", strings, (t1, t2) -> t1.equalsIgnoreCase(t2));
        Assert.assertEquals(3,amount);
    }
}