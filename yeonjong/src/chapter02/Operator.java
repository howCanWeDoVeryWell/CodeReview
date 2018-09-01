package chapter02;


import chapter02.constants.Loop;
import chapter02.constants.Menu;
import chapter02.common.UserInput;

public class Operator {

    public void run() {
        excute();
    }

    private void excute() {
        int count = 0;
        while (count++ < Loop.MAX_COUNT) {
            showMenu();
            int selectedMenu = UserInput.getUserInteger();
            if (selectedMenu == Loop.FINISH) {
                return;
            }
            int userInputValue = UserInput.getUserInteger();
            String result = executeQuestionBy(selectedMenu, userInputValue);
            print(result);
        }
        print("프로그램을 종료합니다.");
    }

    private void showMenu() {
        System.out.println("1. 삼항연산자를 이용하여 음수, 양수, 0 출력하기");
        System.out.println("2. 백의자리 이하 버리기 ");
        System.out.println("3. 입력받은 수의 일의 자리를 1로 바꾸기");
        System.out.println("4. 입력받은 수보다 크면서 가장 가까운 10의 배수에서 입력받은 수 빼기");
        System.out.println("100. 종료");
        System.out.println("문제를 선택하세요.");
    }

    private String executeQuestionBy(int selectedMenu, int userInputValue) {
        String result;
        switch (selectedMenu) {
            case Menu.ONE:
                result = doTernaryOperation(userInputValue);
                break;
            case Menu.TWO:
                result = dumpHundreds(userInputValue);
                break;
            case Menu.THREE:
                result = changeLastUnits(userInputValue);
                break;
            case Menu.FOUR:
                result = calculateMultiple(userInputValue);
                break;
            default:
                result = "없는 문제입니다.";
                break;
        }
        return result;
    }

    // 1. 삼항연산자를 이용하여 음수, 양수, 0 출력하기
    // TernaryOperation : 삼항 연산
    private String doTernaryOperation(int userInputNumber) {
        return userInputNumber > 0
                ? "양수"
                : userInputNumber < 0
                ? "음수"
                : "0";
    }

    // 2. 100이하 버리기
    private String dumpHundreds(int userInputNumber) {
        return String.valueOf(userInputNumber / 100 * 100);
    }

    // 3. 1의자리수 1로 바꾸기
    private String changeLastUnits(int userInputNumber) {
        return String.valueOf(userInputNumber / 10 * 10 + 1);
    }

    // 4. 입력받은 수보다 크면서 가장 가까운 10의 배수에서 입력받은 수 빼기
    private String calculateMultiple(int userInputNumber) {
        return String.valueOf((userInputNumber / 10 * 10 + 10) - userInputNumber);
    }

    private void print(String str) {
        System.out.println(str);
    }

    public static void main(String [] args) {
        new Operator().run();
    }
}
