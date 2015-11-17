package factory;

public class ShapeFactory {
	
	public enum ShapeType {Hex, Cir, Sqr}
	
	public Shape getShape(ShapeType shapeType) {
		switch (shapeType) {
			case Hex: return new Hexagon();
			case Cir: return new Circle();
			case Sqr: return new Square();
			default: return null;
		}
	}

}
