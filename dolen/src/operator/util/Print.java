package operator.util;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.IntStream;

public abstract class Print {
    public static void printMenuByOrdering (Map<Integer, String> menus) {
        Iterator iterator = menus.keySet().iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            System.out.println((i + 1) + ". " + menus.get(iterator.next()));
        }
    }

    public static void printConsole (String str) {
        System.out.println(str);
    }

    public static void clearConsole () {
        IntStream.range(0, 30).forEach(i -> System.out.println());
    }
}
