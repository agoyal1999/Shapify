package com.shapes.app.Shapify.cache;

import com.shapes.app.Shapify.data.Shape;
import com.shapes.app.Shapify.data.ShapeType;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ShapesCache {

    private Map<String, Shape> shapesCache = new ConcurrentHashMap<>();

    public void cacheShapes(List<Shape> shapeList) {
        shapeList.stream().filter(Objects::nonNull).forEach(s -> shapesCache.put(s.id, s));
    }

    public Shape getShapeById(String id) {
        return shapesCache.get(id);
    }

    public List<Shape> getShapesByType(ShapeType type) {
        return shapesCache.values().stream().filter(shape -> shape.getType() == type).collect(Collectors.toList());
    }

    public List<Shape> getAllShapes() {
        return shapesCache.values().stream().toList();
    }
}
