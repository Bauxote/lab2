import org.junit.Assert;
import org.junit.Test;

import main.java.Main;

public class MainTest {

    @Test
    public void testCompareEqual() {
        StringBuffer sb1 = new StringBuffer("apple");
        StringBuffer sb2 = new StringBuffer("apple");
        Assert.assertEquals(0, Main.compare(sb1, sb2));
    }

    @Test
    public void testCompareFirstSmaller() {
        StringBuffer sb1 = new StringBuffer("apple");
        StringBuffer sb2 = new StringBuffer("banana");
        Assert.assertTrue(Main.compare(sb1, sb2) < 0);
    }

    @Test
    public void testCompareFirstLarger() {
        StringBuffer sb1 = new StringBuffer("banana");
        StringBuffer sb2 = new StringBuffer("apple");
        Assert.assertTrue(Main.compare(sb1, sb2) > 0);
    }

    @Test
    public void testCompareSamePrefixShorterFirst() {
        StringBuffer sb1 = new StringBuffer("cat");
        StringBuffer sb2 = new StringBuffer("cats");
        Assert.assertTrue(Main.compare(sb1, sb2) < 0);
    }

    @Test
    public void testCompareSamePrefixLongerFirst() {
        StringBuffer sb1 = new StringBuffer("cats");
        StringBuffer sb2 = new StringBuffer("cat");
        Assert.assertTrue(Main.compare(sb1, sb2) > 0);

}
}
