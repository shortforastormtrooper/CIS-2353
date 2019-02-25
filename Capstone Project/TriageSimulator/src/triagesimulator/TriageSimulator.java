// Darryl Green  
// CIS 2353 
// Winter 2018 
// Prof. John P. Baugh
package triagesimulator;

import java.util.*;

public class TriageSimulator {

    private final Queue<String> queue1;
    private final Queue<String> queue2;
    private final Queue<String> queue3;

    public TriageSimulator() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        queue3 = new LinkedList<>();
    }

    //read information from input file
    public void add(String lineFromFile) {
        String[] tokens = lineFromFile.split(" ");

        //determine trigage code and severity
        if (tokens[2].equalsIgnoreCase("AL") || tokens[2].equalsIgnoreCase("HA") || tokens[2].equalsIgnoreCase("ST")) {
            queue1.add(tokens[0] + " " + tokens[1]);
        } else if (tokens[2].equalsIgnoreCase("BL") || tokens[2].equalsIgnoreCase("IW") || tokens[2].equalsIgnoreCase("KS") || tokens[2].equalsIgnoreCase("OT")) {
            queue2.add(tokens[0] + " " + tokens[1]);
        } else if (tokens[2].equalsIgnoreCase("HN")) {
            queue3.add(tokens[0] + " " + tokens[1]);
        } else {
            System.out.println("Invalid TriageCode!");
        }
    }

    //
    public String remove() {
        if (!queue1.isEmpty()) {
            return queue1.remove();
        }

        if (!queue2.isEmpty()) {
            return queue2.remove();
        }

        if (!queue3.isEmpty()) {
            return queue3.remove();
        }

        return null;
    }

    //determine if all 3 queues are empty
    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty() && queue3.isEmpty();
    }
} //end main pprogram
