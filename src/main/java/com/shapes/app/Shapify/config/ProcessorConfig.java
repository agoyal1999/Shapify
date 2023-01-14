package com.shapes.app.Shapify.config;

import com.shapes.app.Shapify.cache.ShapesCache;
import com.shapes.app.Shapify.processor.FileProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessorConfig {

    @Value("${shapify.input.file}")
    private String inputFileName;

    @Value("${shapify.output.directory}")
    private String outputDirectory;

    @Autowired
    ShapesCache shapesCache;

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public FileProcessor fileProcessor() {
        return new FileProcessor(inputFileName, outputDirectory, shapesCache);
    }
}
