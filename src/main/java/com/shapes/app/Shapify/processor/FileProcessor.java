package com.shapes.app.Shapify.processor;

import com.opencsv.CSVWriter;
import com.shapes.app.Shapify.cache.ShapesCache;
import com.shapes.app.Shapify.data.Shape;
import com.shapes.app.Shapify.util.LineParser;
import com.shapes.app.Shapify.util.ShapeUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

    private final String inputFileName;
    private final String outputDirectory;
    private final ShapesCache shapesCache;

    public FileProcessor(String inputFileName, String outputDirectory, ShapesCache shapesCache) {
        this.inputFileName = inputFileName;
        this.outputDirectory = outputDirectory;
        this.shapesCache = shapesCache;
    }

    public void init() {
        System.out.println(inputFileName);
        processFile();
    }

    public void destroy() {

    }

    public void processFile() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFileName));
            List<Shape> shapes = new ArrayList<>();
            lines.forEach(line -> {
                Shape shape = LineParser.parseLine(line);
                if(shape != null) {
                    shapes.add(shape);
                }
            });
            shapesCache.cacheShapes(shapes);
            createCsvFile(shapes);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createCsvFile(List<Shape> shapes) {
        File file = new File(outputDirectory, "out.csv");

        try(CSVWriter csvWriter = new CSVWriter(new FileWriter(file), ',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END)) {
            // Write header
            String[] header = {"type", "width", "height", "radius", "area", "perimeter"};
            csvWriter.writeNext(header);

            shapes.forEach(shape -> csvWriter.writeNext(ShapeUtil.valuesAsStrings(shape)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
