package factory;

import factory.ShapeFactory.ShapeType;

public class FactoryMain {

	public static void main(String[] args) {
		
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape hex = shapeFactory.getShape(ShapeType.Hex);
		hex.draw();
		Shape cir = shapeFactory.getShape(ShapeType.Cir);
		cir.draw();
		Shape sqr = shapeFactory.getShape(ShapeType.Sqr);
		sqr.draw();

	}

}
