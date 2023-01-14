package com.shapes.app.Shapify.data;

public class Square extends Shape {
    public Square(ShapeType type, double side) {
        super(type, side, side, Double.NaN);
    }



    @Override
    public String toString() {
        return ("Square," + this.width + "," + this.width + "," + "n.a," + this.getArea() + "," + this.getPerimeter());
    }

    @Override
    public void calculateArea() {
        this.area = Math.pow(this.width, 2);
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = 4 * this.width;
    }
}
