import java.io.File;
import java.util.ArrayList;

import net.salesianos.launcher.Launcher;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ArrayList<String> lines = Utils.getAllLines("/Users/macbookpro/Desktop/UD1-PRACTICA 1/src/lorem_ipsum.txt");
    ArrayList<Process> allProcesses = new ArrayList<>();

    Integer lineCounter = 0;
    for (String line : lines) {
      lineCounter++;
      String outputFileName = "outputLine" + lineCounter + ".txt";
      Process javaProcess = Launcher.initWordCounterProcess(line, outputFileName);
      allProcesses.add(javaProcess);
    }

    for (Process process : allProcesses) {
      try {
        process.waitFor();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    Integer totalWords = 0;

    for (int i = 1; i <= lineCounter; i++) {
      String outputFileName = "outputLine" + i + ".txt";
      String outputFileRoute = "./net/salesianos/outputs/" + outputFileName;
      Integer wordsFromFile = Utils.getTotalWordsFrom(outputFileRoute);
      totalWords += wordsFromFile;

      System.out.println("El fichero " + outputFileName + " tiene " + wordsFromFile + " palabras");
  
      File outputFile = new File(outputFileRoute);
      outputFile.delete();
    }
    
    System.out.println("El fichero tiene " + lines.size() + " lineas y " + totalWords + " palabras.");
  }
}
