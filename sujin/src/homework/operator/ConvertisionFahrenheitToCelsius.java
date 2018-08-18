package homework.operator;
/*
 * 1. ?™”?”¨ë¥? ?„­?”¨ë¡? ë³??™˜?•˜?Š” ì½”ë“œë¥? ?‘?„±?•˜?‹œ?˜¤ 
 * ê³µì‹?? c = 5 / 9 * (f-32)
 */
public class Ch03_Variable3_1 {
	/*	
	 *	?™”?”¨?? ?„­?”¨?? 	
	 */
	public double caculateFConvertC(double f) {
		double c = 5.0 / 9 * (f - 32);
		return c;
	}
	
	public static void main(String[] args) {
		Ch03_Variable3_1 mainCls = new Ch03_Variable3_1();
		double f = 40;
		double result = mainCls.caculateFConvertC(f);
		System.out.println(result);
	}
}
