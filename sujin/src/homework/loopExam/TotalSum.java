package src.homework.loopExam;
// 1부터 20까지의 정수 중 2 또는 3의 배수가 아닌 수의 총합을 구하시오
class TotalSumCalculator {
	void doCalculator() {
		int sum = 0;
		for(int i = 1; i <= 20; i++) {
			if(!(i%2 == 0 || i%3 == 0)) {
				System.out.println(i);
				sum += i;
			}
		}
		System.out.println("총합 : " + sum);
	}
}

public class TotalSum {
	public static void main(String[] args) {
		TotalSumCalculator totalCalculator = new TotalSumCalculator();
		totalCalculator.doCalculator();
	}
}
