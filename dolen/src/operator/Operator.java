package operator;

import operator.calculator.Calculator;
import operator.constants.Common;
import operator.constants.Input;
import operator.constants.Menu;
import operator.util.Print;
import operator.util.UserInput;
import operator.util.Validator;

import java.util.InputMismatchException;
import java.util.Map;

public class Operator {
    private UserInput userInput;
    private Calculator calculator;

    public Operator() {
        this(new UserInput(), new Calculator());
    }

    public Operator(UserInput userInput) {
        this(userInput, new Calculator());
    }

    public Operator(Calculator calculator) {
        this(new UserInput(), calculator);
    }

    public Operator(UserInput userInput, Calculator calculator) {
        this.userInput = userInput;
        this.calculator = calculator;
    }

    public void run () {
        String menu = this.getMenu();
        if (menu == null) {
            Print.printConsole(Common.END_OF_PROGRAM);
        } else {
            int inputValue = this.getUserInputBy(menu);
            String result = this.calculator.execute(menu, inputValue);
            Print.printConsole(result);
        }
    }

    private String getMenu () {
        String menu = "";

        int count = 0;
        while (count < Common.MAX_LOOP_COUNT) {
            try {
                menu = this.selectMenu();
                if (menu != null) {
                    if (menu.equals(Menu.CLOSE_OPERATOR)) {
                        return null;
                    } else {
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                Print.clearConsole();
                Print.printConsole(Input.INPUT_TYPE_ERROR);
            } finally {
                count += 1;
            }
        }

        return menu;
    }

    private String selectMenu () throws InputMismatchException {
        Map<Integer, String> menus = Menu.getOperatorMenu();
        Print.printMenuByOrdering(menus);
        Print.printConsole(Input.CHOICES_ONE_OF_DIGIT);
        Integer inputValue = this.userInput.getIntValue();

        return menus.get(inputValue);
    }

    private int getUserInputBy (String menu) {
        int inputValue = 0;
        int count = 0;

        while (count < Common.MAX_LOOP_COUNT) {
            try {
                this.printInputTypeBy(menu);
                switch (menu) {
                    case Menu.TERNARY:
                        inputValue = this.userInput.getIntValue();
                        if (Validator.isTenLower(inputValue)) {
                            return inputValue;
                        } else {
                            break;
                        }
                    case Menu.DUMP_HUNDREDS:
                        inputValue = this.userInput.getIntValue();
                        if (Validator.isTenLower(inputValue)) {
                            return inputValue;
                        } else {
                            break;
                        }
                    case Menu.CHANGE_LAST_UNIT_DIGIT_TO_ONE:
                        inputValue = this.userInput.getIntValue();
                        if (Validator.isTenLower(inputValue)) {
                            return inputValue;
                        } else {
                            break;
                        }
                }
            } catch (InputMismatchException e) {
                Print.clearConsole();
                Print.printConsole(Input.INPUT_TYPE_ERROR);
            } finally {
                count += 1;
            }
        }

        return inputValue;
    }

    private void printInputTypeBy (String menu) {
        String message;
        switch (menu) {
            case Menu.TERNARY:
                message = Input.CHOICES_ONE_OF_DIGIT;
                break;
            case Menu.DUMP_HUNDREDS:
                message = Input.CHOICES_ONE_OF_DIGIT;
                break;
            case Menu.CHANGE_LAST_UNIT_DIGIT_TO_ONE:
                message = Input.CHOICES_ONE_OF_DIGIT;
                break;
            default:
                message = "";
                break;
        }
        Print.printConsole(message);
    }

    /**
     * 1. 삼항연산자를 이용하여 음수, 양수, 0 출력하기
     * 2. 백의자리 이하 버리기
     * 3. 입력받은 수의 일의 자리를 1로 바꾸기
     */
    public static void main (String ...args) {
        new Operator().run();
    }
}
