package com.shapes.app.Shapify.data;

public class Triangle extends Shape {
    public Triangle(ShapeType type, double width, double height) {
        super(type, width, height, Double.NaN);
    }


    @Override
    public String toString() {
        return ("Triangle" + this.width + this.height + "n.a" + this.getArea() + this.getPerimeter());
    }

    @Override
    public void calculateArea() {
        this.area = 0.5 * this.width * this.height;
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = Math.sqrt(Math.pow(this.width, 2) + Math.pow(this.height, 2)) + this.width + this.height;
    }
}
