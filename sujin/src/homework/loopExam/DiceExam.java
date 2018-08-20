package src.homework.loopExam;
// 두 개의 주사위를 던졌을 때 눈의 합이 6이 되는 모든 경우의 수를 출력하시오
class DiceTotalCalculator {
	void calculateTotalSum() {
		int index = 0;
		for(int i = 1; i <= 6; i++) {
			for(int j = 1; j <= 6; j++) {
				if(i + j == 6) {
					index++;
					System.out.println(i + "+" + j + "=" + (j + i));
				}
			}
		}
		System.out.println("총 경우의 수는 " + index + " 개 다 ");
	}
}

public class DiceExam {

	public static void main(String[] args) {
		DiceTotalCalculator diceTotalCalculator = new DiceTotalCalculator();
		diceTotalCalculator.calculateTotalSum();
	}
}
