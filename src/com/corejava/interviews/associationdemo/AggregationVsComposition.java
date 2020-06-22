package com.corejava.interviews.associationdemo;

public class AggregationVsComposition {
	/**
	 * 1. Dependency: Aggregation implies a relationship where the child can exist independently of the parent. For example, Bank and Employee, delete the Bank and the Employee still exist. whereas Composition implies a relationship where the child cannot exist independent of the parent. Example: Human and heart, heart don¡¯t exist separate to a Human
	 * 2. Type of Relationship: Aggregation relation is ¡°has-a¡± and composition is ¡°part-of¡± relation.
	 * 3. Type of association: Composition is a strong Association whereas Aggregation is a weak Association.
	 * @param args
	 */
	public static void main(String[] args) {
		Engine engine = new Engine();
		Car car = new Car(engine);
		car.move();

	}

}
class Engine{
	public void work(){
		System.out.println("Engine Start");
	}
}

final class Car{
//	private Engine engine; // for aggregation: allow Engine is null
	private final Engine engine; // for composition: car can't move without engine
	Car(Engine engine){
		this.engine = engine;
	}
	public void move(){
		if(engine != null){
			engine.work();
			System.out.println("Car is moving");
		}
	}
}
