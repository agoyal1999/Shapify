package com.shapes.app.Shapify.controller;

import com.shapes.app.Shapify.cache.ShapesCache;
import com.shapes.app.Shapify.data.Shape;
import com.shapes.app.Shapify.data.ShapeType;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ShapeController {
    private final static Logger logger = LoggerFactory.getLogger(ShapeController.class);

    @Autowired
    ShapesCache shapesCache;

    @GetMapping("/shape")
    public ResponseEntity<List<Shape>> getShapeByType(@RequestParam(required = false) String type, HttpServletRequest request) {
        logger.info("info: {} {}?type={} - 200 {\"timestamp\": \"{}\"}",request.getMethod(), request.getRequestURI(), request.getParameter("type"), LocalDateTime.now());
        if(type == null || type.isEmpty()) {
            return ResponseEntity.ok(shapesCache.getAllShapes());
        }

        try{
            return ResponseEntity.ok(shapesCache.getShapesByType(ShapeType.valueOf(type.toUpperCase())));
        } catch(IllegalArgumentException e) {
            logger.error("No shape of type: {}", type);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book")
    public ResponseEntity<Shape> getShapeById(@RequestParam String id, HttpServletRequest request) {
        Shape shape = shapesCache.getShapeById(id);
        if(shape == null) {
            logger.error("error: {} {}?id={} - 404 {\"timestamp\": \"{}\"}",request.getMethod(), request.getRequestURI(), request.getParameter("id"), LocalDateTime.now());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        logger.info("info: {} {}?id={} - 200 {\"timestamp\": \"{}\"}",request.getMethod(), request.getRequestURI(), request.getParameter("id"), LocalDateTime.now());
        return ResponseEntity.ok(shapesCache.getShapeById(id));
    }

}
