// Darryl Green  
// CIS 2353 
// Winter 2018 
// Prof. John P. Baugh
package triagesimulator;

import java.io.*;
import java.util.*;

public class TriageSimulatorDemo {

    public static void main(String[] args) {
        TriageSimulator trisim = new TriageSimulator();

        try {
            //read information from input file
            Scanner infile = new Scanner(new File("patients.txt"));

            while (infile.hasNextLine()) {
                trisim.add(infile.nextLine());
            }
            infile.close();

            System.out.println("List of patients who have already been seen by a doctor by first and last name:");
            while (!trisim.isEmpty()) {
                System.out.println(trisim.remove());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file cannot be opened");
        }
    }
}
