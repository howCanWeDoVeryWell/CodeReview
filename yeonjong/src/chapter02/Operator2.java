package chapter02;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operator2 {
    public static final int QUESTION_ONE = 1;
    public static final int QUESTION_TWO = 2;
    public static final int QUESTION_THREE = 3;
    public static final int QUESTION_FOUR = 4;
    public static final int ASCII_UPPER_CASE_A = 65;
    public static final int ASCII_UPPER_CASE_Z = 90;
    public static final int ASCII_LOWER_CASE_A = 97;
    public static final int ASCII_LOWER_CASE_Z = 122;
    public static final int ALPHABET_RANGE = 32;
    public static final int FAHRENHEIT_START_TEMPERATURE = 32;
    public static final double FAHRENHEIT_RESPONSE_TEMPERATURE = 1.8;

    public void run() {
        showMenu();
    }

    public void showMenu() {
        System.out.println("1. 화씨를 섭씨로 반환하기 ");
        System.out.println("2. 숫자일때만 TRUE 반환하기");
        System.out.println("3. 대문자는 소문자로, 소문자는 대문자로 반환하기");
        System.out.println("4. 종료");
        try {
            selectMenu();
        } catch (InputMismatchException e) {
            System.out.println("없는 문제 입니다. 다시 입력해주세요.");
            showMenu();
        }
    }

    public void selectMenu() throws InputMismatchException {
        Scanner sanner = new Scanner(System.in);
        int questionNumber = sanner.nextInt();
        checkQuestionNumber(questionNumber);
    }

    public void checkQuestionNumber(int questionNumber) {
        if (questionNumber >= QUESTION_ONE && questionNumber <= QUESTION_THREE) {
            try {
                getUserInput(questionNumber);
            } catch (InputMismatchException exception) {
                System.out.println("없는 문제 입니다. 다시 입력해주세요.");
                showMenu();
            }
        } else if (questionNumber == QUESTION_FOUR) {
            System.out.println("프로그램 종료됩니다.");
        } else {
            System.out.println("없는 문제 입니다. 다시 입력해주세요.");
            showMenu();
        }
    }

    public void getUserInput(int questionNumber) {
        String userInputValue = scanUserInputValue();
        getAnswerToQuestion(questionNumber, userInputValue);
    }

    public String scanUserInputValue() throws InputMismatchException {
        System.out.println("값을 입력하세요.");
        Scanner sanner = new Scanner(System.in);
        return sanner.nextLine();
    }

    public void getAnswerToQuestion(int questionNumber, String userInputValue) {
        String answer = null;
        switch (questionNumber) {
            case QUESTION_ONE:
                try {
                    int userInputNumber = Integer.parseInt(userInputValue);
                    answer = String.valueOf(convertFahrenheitToCelsius(userInputNumber));
                } catch (NumberFormatException exception) {
                    System.out.println("숫자만 입력 가능합니다.");
                    showMenu();
                }
                break;
            case QUESTION_TWO:
                answer = String.valueOf(checkNumber(userInputValue));
                break;
            case QUESTION_THREE:
                answer = convertAlphabetic(userInputValue);
                break;
        }
        System.out.println("[결과]" + answer);
    }

    // 1. 화씨를 섭씨로 반환하기
    // Fahrenheit : 화씨 , Celsius : 섭씨
    public double convertFahrenheitToCelsius(int fahrenheit) {
        return (fahrenheit - FAHRENHEIT_START_TEMPERATURE) / FAHRENHEIT_RESPONSE_TEMPERATURE;
    }

    // 2. 숫자일때만 TRUE 반환하기
    public boolean checkNumber(String userInput) {
        try {
            Double.parseDouble(userInput);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    // 3. 대문자는 소문자로, 소문자는 대문자로 반환하기
    public String convertAlphabetic(String userInput) {
        char[] compareChar = userInput.toCharArray();

        for (int i = 0, size = compareChar.length; i < size; i++) {
            if (compareChar[i] >= ASCII_UPPER_CASE_A && compareChar[i] <= ASCII_UPPER_CASE_Z) {
                compareChar[i] += ALPHABET_RANGE;
                continue;
            }
            if (compareChar[i] >= ASCII_LOWER_CASE_A && compareChar[i] <= ASCII_LOWER_CASE_Z) {
                compareChar[i] -= ALPHABET_RANGE;
                continue;
            }
        }
        return String.valueOf(compareChar);
    }

    public static void main(String[] args) {
        Operator2 operator = new Operator2();
        operator.run();
    }
}
