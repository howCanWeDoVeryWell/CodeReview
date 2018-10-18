package chapter05;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class HTMLParserTest {


    @Test
    public void testHtmlParser() {
        Map<String, Object> map = new HTMLParser().parser("<html>test</html>");

        Map<String, Object> mapTest = new HashMap<String, Object>();
        String value = "test";
        String key = "html";
        mapTest.put(key, value);

        assertEquals(mapTest, map);

    }

}