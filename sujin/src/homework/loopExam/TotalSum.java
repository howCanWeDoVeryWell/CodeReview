package src.homework.loopExam;

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
