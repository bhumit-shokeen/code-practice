package design_pattern.decorator;

public abstract class Beverage {

	String description = "unknown";

	public String getDescription() {
		return description;
	}

	public abstract double cost();

}
