package chapter05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HTMLParser {

    public Map<String, Object> parser(String html) {
        String key = null;
        String value = null;
        Map<String, Object> map = new HashMap<>();

        int cursor = 0;
        // cursor ++ ? while ?
        while (cursor < html.length()) {
            if ("<".equals(html.substring(cursor, cursor + 1))) { // 0 5
                cursor++; // 1 6
                if ("/".equals(html.substring(cursor, cursor + 1))) {
                    System.out.println(html.indexOf(">"));
                    cursor = cursor + html.indexOf(">");
                } else {
                    key = html.substring(cursor, html.indexOf(">"));
                    map.put(key, value);
                    cursor = html.indexOf(">"); //5
                    System.out.println("els" + cursor);
                }

                // />
            } else if (">".equals(html.substring(cursor, cursor + 1))) {
                cursor++;
            } else {
                value = html.substring(cursor, cursor + 1);
                map.put(key, map.get(key) + value);
                cursor++;
            }
        }

        return map;
    }

    public static void main(String[] args) {
        String html = "<html></html>";
        Map<String, Object> result = new HTMLParser().parser(html);
        System.out.println(result.get("html"));
    }
}

