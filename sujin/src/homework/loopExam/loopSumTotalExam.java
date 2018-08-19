package src.homework.loopExam;

class LoopExamCalculator {
	void doCalculator() {
		int sum = 0;
		int index = 0;
		
		while(sum < 100) {
			index++;

			if (index % 2 == 0) {
				sum -= index;
			} else {
				sum += index;
			}
		}
		
		System.out.println(index + " 까지 더해야 총합이 100 나온다.");
		System.out.println("sum : " + sum);
	}
}

public class loopSumTotalExam {

	public static void main(String[] args) {
		LoopExamCalculator loopExamCalculator = new LoopExamCalculator();
		loopExamCalculator.doCalculator();
	}
}
