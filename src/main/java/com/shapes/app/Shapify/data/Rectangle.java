package com.shapes.app.Shapify.data;

public class Rectangle extends Shape {
    public Rectangle(ShapeType type, double width, double height) {
        super(type, width, height, Double.NaN);
    }



    @Override
    public String toString() {
        return ("Rectangle" + this.width +  this.height + "n.a" + this.getArea() + this.getPerimeter());
    }

    @Override
    public void calculateArea() {
        this.area = this.width * this.height;
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = (2 * this.width) + (2 * this.height);

    }
}
