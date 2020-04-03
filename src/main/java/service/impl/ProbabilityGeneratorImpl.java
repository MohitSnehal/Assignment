package service.impl;

import pojo.FileContents;
import service.ProbabilityGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ProbabilityGeneratorImpl implements ProbabilityGenerator {

    private FileContents fileContents;

    public ProbabilityGeneratorImpl(){ }

    public ProbabilityGeneratorImpl(String fileName) throws Exception {
        ClassLoader classLoader = new ProbabilityGeneratorImpl().getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String currentLine = null ;
        fileContents = new FileContents();
        while((currentLine = br.readLine()) != null){
            fileContents.build(currentLine);
        }
    }

    public String getNextString() {
        int randomNumber = ((int)(Math.random() * 100)) % 100;
        String result = fileContents.getStringForNumber(randomNumber);
        return result;
    }
}
