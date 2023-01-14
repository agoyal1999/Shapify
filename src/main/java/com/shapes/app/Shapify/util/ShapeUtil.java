package com.shapes.app.Shapify.util;

import com.shapes.app.Shapify.data.Shape;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ShapeUtil {

    public static String[] valuesAsStrings(Shape shape) {
        return new String[]{shape.getType().toString().toLowerCase(),
                getAsStringOrNan(shape.getWidth()),
                getAsStringOrNan(shape.getHeight()),
                getAsStringOrNan(shape.getRadius()),
                getAsStringOrNan(shape.getArea()),
                getAsStringOrNan(shape.getPerimeter())};
    }

    public static String getAsStringOrNan(double value) {
        return Double.isNaN(value) ? "n.a": BigDecimal.valueOf(value).setScale(4, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();
    }
}
