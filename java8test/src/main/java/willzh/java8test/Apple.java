package willzh.java8test;

public class Apple {
	
	private String color;
	private Double weight;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public String toString(){
		return "color="+this.color + ";" + "weight=" + this.weight;
	}
	
	
}
