package operator.calculator;

import operator.constants.Menu;

public class Calculator {
    public String execute (String menu, int inputValue) {
        String result = "";
        switch (menu) {
            case Menu.TERNARY:
                result = this.getMatchedStr(inputValue);
                break;
            case Menu.DUMP_HUNDREDS:
                break;
            case Menu.CHANGE_LAST_UNIT_DIGIT_TO_ONE:
                break;
            default:
                result = "";
                break;
        }
        return result;
    }

    private String getMatchedStr (int value) {
        return value > 0
                ? "양수"
                : value != 0
                ? "음수"
                : "0";
    }
}
