package com.shapes.app.Shapify.data;

import java.util.UUID;

public abstract class Shape {
    public String id = String.valueOf(UUID.randomUUID());
    protected ShapeType type;
    protected double width;
    protected double height;
    protected double radius;
    protected double area;
    protected double perimeter;

    public Shape(ShapeType type, double width, double height, double radius){
        this.type = type;
        this.width = width;
        this.height = height;
        this.radius = radius;
        calculateArea();
        calculatePerimeter();
    }

    public ShapeType getType() {
        return type;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public abstract void calculateArea();

    public abstract void calculatePerimeter();

}
