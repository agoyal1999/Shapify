package com.shapes.app.Shapify.config;

import com.shapes.app.Shapify.controller.ShapeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Bean
    public ShapeController shapeController() {
        return new ShapeController();
    }
}
