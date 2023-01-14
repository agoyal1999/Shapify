package com.shapes.app.Shapify.data;

public enum ShapeType {
    SQUARE("s"),
    RECTANGLE("r"),
    CIRCLE("c"),
    TRIANGLE("t");

    private final String str;

    ShapeType(String str) {
        this.str = str;
    }
    public static String getShapeType(String input){
        return switch (input) {
            case ("s") -> "square";
            case ("r") -> "rectangle";
            case ("t") -> "triangle";
            case ("c") -> "circle";
            default -> "null";
        };
    }
}
