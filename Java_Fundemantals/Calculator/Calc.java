
public class Calc {
	private double number1;
	private double number2;
	private char opration;
	public Calc() {

	}
	public double getNumber1() {
		return number1;
	}
	public void setNumber1(double number1) {
		this.number1 = number1;
	}
	public double getNumber2() {
		return number2;
	}
	public void setNumber2(double number2) {
		this.number2 = number2;
	}
	public char getOpration() {
		return opration;
	}
	public void setOpration(char opration) {
		this.opration = opration;
	}
	public double result() {
		if (this.opration=='+')
			return (this.number1 + this.number2);
		if(this.opration=='-')
			return (this.number1 - this.number2);
		return 0;
	}
	
	
}
