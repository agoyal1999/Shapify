package com.shapes.app.Shapify.config;

import com.shapes.app.Shapify.cache.ShapesCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public ShapesCache shapesCache() {
        return new ShapesCache();
    }
}
