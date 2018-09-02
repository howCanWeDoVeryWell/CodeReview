package chapter02;

import chapter02.constants.Loop;
import chapter02.constants.Menu;
import common.UserInput;

public class Operator2 {
    public static final int ALPHABET_RANGE = 32;
    public static final int FAHRENHEIT_START_TEMPERATURE = 32;
    public static final double FAHRENHEIT_RESPONSE_TEMPERATURE = 1.8;

    class ASCIICode {
        private static final int UPPER_CASE_A = 65;
        private static final int UPPER_CASE_Z = 90;
        private static final int LOWER_CASE_A = 97;
        private static final int LOWER_CASE_Z = 122;
    }

    private void run() {
        int count = 0;
        while (count++ < Loop.MAX_COUNT) {
            if (execute()) {
                break;
            }
        }
        System.out.println("[프로그램을 종료합니다.]");
    }

    private boolean execute() {
        showMenu();
        int userSelectMenu = UserInput.getUserInteger();
        if (!isFinish(userSelectMenu)) {
            String questionType = checkQuestionTypeBy(userSelectMenu);
            String userInputValue = null;
            if (Menu.NUMBER_TYPE.equals(questionType)) {
                userInputValue =  String.valueOf(UserInput.getUserInteger());
            } else if (Menu.STRING_TYPE.equals(questionType)) {
                userInputValue = UserInput.getUserInputString();
            }
            String result = executeQuestionBy(userSelectMenu, userInputValue);
            System.out.println("[결과]" + result);
            return false;
        }
        return true;
    }

    private void showMenu() {
        System.out.println("1. 화씨를 섭씨로 반환하기 ");
        System.out.println("2. 숫자일때만 TRUE 반환하기");
        System.out.println("3. 대문자는 소문자로, 소문자는 대문자로 반환하기");
        System.out.println("100. 종료");
    }

    private boolean isFinish(int selectedMenu) {
        if (selectedMenu == Loop.FINISH) {
            return true;
        } else {
            return false;
        }
    }

    private String checkQuestionTypeBy(int userSelectMenu) {
        switch (userSelectMenu) {
            case Menu.ONE:
                return Menu.NUMBER_TYPE;
            case Menu.TWO:
                return Menu.STRING_TYPE;
            case Menu.THREE:
                return Menu.STRING_TYPE;
            default:
                return null;
        }
    }

    private String executeQuestionBy(int userSelectMenu, String userInputValue) {
        switch (userSelectMenu) {
            case Menu.ONE:
                return convertFahrenheitToCelsius(userInputValue);
            case Menu.TWO:
                return checkNumber(userInputValue);
            case Menu.THREE:
                return convertAlphabetic(userInputValue);
            default:
                return "없는 문제입니다.";
        }
    }

    // 1. 화씨를 섭씨로 반환하기
    // Fahrenheit : 화씨 , Celsius : 섭씨
    private String convertFahrenheitToCelsius(String fahrenheit) {
        return String.valueOf((Double.parseDouble(fahrenheit) - FAHRENHEIT_START_TEMPERATURE) / FAHRENHEIT_RESPONSE_TEMPERATURE);
    }

    // 2. 숫자일때만 TRUE 반환하기
    private String checkNumber(String userInput) {
        try {
            Double.parseDouble(userInput);
            return "true";
        } catch (NumberFormatException exception) {
            return "false";
        }
    }

    // 3. 대문자는 소문자로, 소문자는 대문자로 반환하기
    // NullPointerException
    private String convertAlphabetic(String userInput) {
        if (userInput != null) {
            char [] chars = userInput.toCharArray();
            for (int i = 0, size = chars.length; i < size; i++) {
                char unit = chars[i];
                if (isUpperCase(unit)) {
                    unit += ALPHABET_RANGE;
                } else {
                    if (isLowerCase(unit)) {
                        unit -= ALPHABET_RANGE;
                    }
                }
                chars[i] = unit;
            }
            return String.valueOf(chars);
        } else {
            return null;
        }
    }

    private boolean isUpperCase(char unit) {
       return unit >= ASCIICode.UPPER_CASE_A && unit <= ASCIICode.UPPER_CASE_Z;
    }

    private boolean isLowerCase(char unit) {
        return unit >= ASCIICode.LOWER_CASE_A && unit <= ASCIICode.LOWER_CASE_Z;
    }

    public static void main(String[] args) {
        new Operator2().run();
    }
}
