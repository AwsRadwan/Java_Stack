
public class Circle extends GeometricObject {
	
	private double radius;

	public Circle() {
		
	}
	public Circle(double radius) {
			this.radius = radius;
		}
	public Circle(double radius, String color, boolean filled) {
		this.radius = radius;
		this.color = color;
		this.filled = filled;
	}
	
	public double getArea() {
		return radius*radius*3.14;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	

}
