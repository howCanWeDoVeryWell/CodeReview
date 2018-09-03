package operator.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    public int getIntValue () throws InputMismatchException {
        return new Scanner(System.in).nextInt();
    }
}
