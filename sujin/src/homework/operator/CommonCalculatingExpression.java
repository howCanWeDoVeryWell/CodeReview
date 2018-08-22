package homework.operator;
// 연산자 공통 코드
public class CommonCalculatingExpression {
    public Boolean doCalculate(String userInput, Boolean isThatWords) {
        for(int i = 0; i < userInput.length(); i++) {
            char stringConvertToChar = userInput.charAt(i);

            if(!(stringConvertToChar >= 48 && stringConvertToChar <= 57)) {
                if(userInput.charAt(i) == 45)  {
                    continue;
                } else {
                    isThatWords = false;
                    break;
                }
            }
        }

        return isThatWords;
    }
}
