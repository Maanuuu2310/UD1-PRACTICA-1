package net.salesianos.launcher;
import java.io.File;
import java.io.IOException;

public class Launcher {
    private final static String OUTPUT_ROUTE = "./net/salesianos/outputs/";

    public static Process initWordCounterProcess(String line, String fileName) {
      ProcessBuilder processBuilder = new ProcessBuilder(
        "java", "./net/salesianos/processes/WordCounter.java", line
      );
  
      Process javaProcess = null;
  
      try {
        File outputFile = new File(OUTPUT_ROUTE + fileName);
        processBuilder.redirectOutput(outputFile);
        javaProcess =  processBuilder.start();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
  
      return javaProcess;
    }
    
}


