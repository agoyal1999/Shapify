package com.shapes.app.Shapify.data;

public class Circle extends Shape{
    public Circle(ShapeType type, double radius) {
        super(type, Double.NaN, Double.NaN, radius);
    }

    @Override
    public void calculateArea() {
        this.area = Math.PI * radius * radius;
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return ("Circle" + "n.a" +  "n.a" + this.radius + this.getArea() + this.getPerimeter());
    }
}
