package chapter02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Operator {
    public static final int QUESTION_ONE = 1;
    public static final int QUESTION_TWO = 2;
    public static final int QUESTION_THREE = 3;
    public static final int QUESTION_FOUR = 4;
    public static final int QUESTION_FIVE = 5;
    public static final int MIN_NUMBER = 0;

    public void run() {
        showMenu();
    }

    public void showMenu() {
        System.out.println("1. 삼항연산자를 이용하여 음수, 양수, 0 출력하기");
        System.out.println("2. 백의자리 이하 버리기 ");
        System.out.println("3. 입력받은 수의 일의 자리를 1로 바꾸기");
        System.out.println("4. 입력받은 수보다 크면서 가장 가까운 10의 배수에서 입력받은 수 빼기");
        System.out.println("5. 종료");
        System.out.println("문제를 선택하세요.");
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
        if (questionNumber >= QUESTION_ONE && questionNumber <= QUESTION_FOUR) {
            try {
                getUserInput(questionNumber);
            } catch (InputMismatchException exception) {
                System.out.println("없는 문제 입니다. 다시 입력해주세요.");
                showMenu();
            }
        } else if (questionNumber == QUESTION_FIVE) {
            System.out.println("프로그램 종료됩니다.");
        } else {
            System.out.println("없는 문제 입니다. 다시 입력해주세요.");
            showMenu();
        }
    }

    public void getUserInput(int questionNumber) {
        try {
            int userInputValue = scanUserInputValue();
            if (userInputValue <= MIN_NUMBER) {
                System.out.println("0이상의 숫자만 가능합니다.");
                showMenu();
            } else {
                getAnswerToQuestion(questionNumber, userInputValue);
            }
        } catch (InputMismatchException exception) {
            System.out.println("숫자가 아닙니다.");
            showMenu();
        }
    }

    public int scanUserInputValue() throws InputMismatchException {
        System.out.println("숫자를 입력하세요.");
        Scanner sanner = new Scanner(System.in);
        return sanner.nextInt();
    }

    public void getAnswerToQuestion(int questionNumber, int userInputValue) {
        String answer = null;
        switch (questionNumber) {
            case QUESTION_ONE:
                answer = doTernaryOperation(userInputValue);
                break;
            case QUESTION_TWO:
                answer = String.valueOf(dumpHundreds(userInputValue));
                break;
            case QUESTION_THREE:
                answer = String.valueOf(changeLastUnits(userInputValue));
                break;
            case QUESTION_FOUR:
                answer = String.valueOf(calculateMultiple(userInputValue));
                break;
        }
        System.out.println("[결과]" + answer);
    }

    // 1. 삼항연산자를 이용하여 음수, 양수, 0 출력하기
    // TernaryOperation : 삼항 연산
    public String doTernaryOperation(int userInputNumber) {
        return userInputNumber > 0
                ? "양수"
                : userInputNumber < 0
                ? "음수"
                : "0";
    }

    // 2. 100이하 버리기
    public int dumpHundreds(int userInputNumber) {
        return userInputNumber / 100 * 100;
    }

    // 3. 1의자리수 1로 바꾸기
    public int changeLastUnits(int userInputNumber) {
        return userInputNumber / 10 * 10 + 1;
    }

    // 4. 입력받은 수보다 크면서 가장 가까운 10의 배수에서 입력받은 수 빼기
    public int calculateMultiple(int userInputNumber) {
        return (userInputNumber / 10 * 10 + 10) - userInputNumber;
    }

    public static void main(String[] args) {
        Operator operator = new Operator();
        operator.showMenu();
    }
}
