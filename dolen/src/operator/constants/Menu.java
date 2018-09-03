package operator.constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public abstract class Menu {
    public final static String TERNARY = "삼항연산자를 이용하여 음수, 양수, 0 출력하기";
    public final static String DUMP_HUNDREDS = "백의자리 이하 버리기";
    public final static String CHANGE_LAST_UNIT_DIGIT_TO_ONE = "입력받은 수의 일의 자리를 1로 변경";
    public final static String CLOSE_OPERATOR = "프로그램 종료.";

    private static int START_INDEX_OF_MENU = 1;

    public static Map<Integer, String> getOperatorMenu () {
        Map<Integer, String> resultMap = new HashMap<>();
        List<String> menus = Arrays.asList(
                TERNARY,
                DUMP_HUNDREDS,
                CHANGE_LAST_UNIT_DIGIT_TO_ONE,
                CLOSE_OPERATOR
        );
        IntStream
                .range(0, menus.size())
                .forEach(i -> resultMap.put(i + START_INDEX_OF_MENU, menus.get(i)));
        return resultMap;
    }
}
