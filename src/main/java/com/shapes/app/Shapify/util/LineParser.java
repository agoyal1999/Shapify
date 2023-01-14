package com.shapes.app.Shapify.util;

import com.shapes.app.Shapify.data.*;

import java.util.Arrays;

public class LineParser {

    public static Shape parseLine(String line) {
        String[] parts = line.split("\\|");
        Shape shape = null;
        try {
            switch (parts[0]) {
                case "s" :
                    shape = new Square(ShapeType.SQUARE, Double.parseDouble(parts[1]));
                    break;
                case "r" :
                    shape = new Rectangle(ShapeType.RECTANGLE, Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
                    break;
                case "c" :
                    shape = new Circle(ShapeType.CIRCLE, Double.parseDouble(parts[1]));
                    break;
                case "t" :
                    shape = new Triangle(ShapeType.TRIANGLE, Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shape;
    }
}
