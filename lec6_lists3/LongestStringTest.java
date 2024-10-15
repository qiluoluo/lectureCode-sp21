import org.junit.Assert;
import org.junit.Test;

public class LongestStringTest {
    @Test
    public void LongestStringInSLListTest() {
        SLList<String> slList = new SLList<>("1234");
        slList.addFirst("123");
        slList.addFirst("123456789");
        slList.addFirst("123456");
        String longestString = LongestString.LongestStringInSLList(slList);
        Assert.assertEquals("123456789", longestString);
    }
}
