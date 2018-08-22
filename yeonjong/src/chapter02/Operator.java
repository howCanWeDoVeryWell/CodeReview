package chapter02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Operator {

    public static final String QUESTION_ONE = "1";
    public static final String QUESTION_TWO = "2";
    public static final String QUESTION_THREE = "3";
    public static final String QUESTION_FOUR = "4";
    public static final String QUESTION_FIVE = "5";

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
        if (userInputNumber < 100) {
            throw new InputMismatchException();
        }
        return userInputNumber / 100 * 100;
    }

    // 3. 1의자리수 1로 바꾸기
    public int changeUnits(int userInputNumber) {
        if (userInputNumber < 10) {
            throw new InputMismatchException();
        }
        return userInputNumber / 10 * 10 + 1;
    }

    // 4. 입력받은 수보다 크면서 가장 가까운 10의 배수에서 입력받은 수 빼기
    public int calculateMultiple(int userInputNumber) {
        if (userInputNumber < 10) {
            throw new InputMismatchException();
        }
        return (userInputNumber / 10 * 10 + 10) - userInputNumber;
    }


    public int getUserInputNumber() throws InputMismatchException {

        System.out.println("숫자를 입력하세요.");
        Scanner answerScanner = new Scanner(System.in);
        return answerScanner.nextInt();
    }

    public void solveProblem(String questionNumber) {

        switch (questionNumber) {

            case QUESTION_ONE :
                System.out.println(doTernaryOperation(getUserInputNumber()));
                break;
            case QUESTION_TWO :
                System.out.println(dumpHundreds(getUserInputNumber()));
                break;
            case QUESTION_THREE :
                System.out.println(changeUnits(getUserInputNumber()));
                break;
            case QUESTION_FOUR :
                System.out.println(calculateMultiple(getUserInputNumber()));
                break;
            case QUESTION_FIVE :
                System.out.println("FINISH..");
                break;
            default :
                System.out.println("없는 문제입니다.");
                break;
        }
    }


    public void showMenu() throws InputMismatchException {
        System.out.println("1. 삼항연산자를 이용하여 음수, 양수, 0 출력하기");
        System.out.println("2. 백의자리 이하 버리기 ");
        System.out.println("3. 입력받은 수의 일의 자리를 1로 바꾸기");
        System.out.println("4. 입력받은 수보다 크면서 가장 가까운 10의 배수에서 입력받은 수 빼기");
        System.out.println("5. 종료");

        System.out.println("문제의 숫자를 선택하세요.");
        Scanner questionScanner = new Scanner(System.in);
        String questionNumber = questionScanner.nextLine();
        solveProblem(questionNumber);
    }

    public static void main(String[] args) {

        Operator operator = new Operator();
        try {
            operator.showMenu();
        } catch (InputMismatchException exception) {
            System.out.println("문제를 풀기에 적합하지 않은 숫자 입니다..");
            operator.showMenu();
        }

    }
}
