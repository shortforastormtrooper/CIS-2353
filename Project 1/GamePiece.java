/* 
Darryl Green 
CIS 2353
Winter 2018
Baugh
 */
package GamePiece;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePiece {

    public enum Classification {
        ROCK("rock") {
            @Override
            public List<Classification> winningAgainst() {
                if (wins.isEmpty()) {
                    wins.add(SCISSORS);
                    wins.add(LIZARD);
                }
                return wins;
            }
        },
        PAPER("paper") {
            @Override
            public List<Classification> winningAgainst() {
                if (wins.isEmpty()) {
                    wins.add(ROCK);
                    wins.add(SPOCK);
                }
                return wins;
            }
        },
        SCISSORS("scissors") {
            @Override
            public List<Classification> winningAgainst() {
                if (wins.isEmpty()) {
                    wins.add(PAPER);
                    wins.add(LIZARD);
                }
                return wins;
            }
        },
        LIZARD("lizard") {
            @Override
            public List<Classification> winningAgainst() {
                if (wins.isEmpty()) {
                    wins.add(SPOCK);
                    wins.add(PAPER);
                }
                return wins;
            }
        },
        SPOCK("spock") {
            @Override
            public List<Classification> winningAgainst() {
                if (wins.isEmpty()) {
                    wins.add(ROCK);
                    wins.add(SCISSORS);
                }
                return wins;
            }
        };

        private String kyd;

        protected List<Classification> wins;

        private Classification(String kyd) {
            this.kyd = kyd;
            this.wins = new ArrayList<>();
        }

        public String getKeyword() {
            return kyd;
        }

        public abstract List<Classification> winningAgainst();
    }

    public void printUserOptions() {
        StringBuilder stb = new StringBuilder();
        stb.append("Input your choice of one of the following: ");
        for (Classification ch : Classification.values()) {
            stb.append(" ");
            stb.append(ch.getKeyword());
        }
        System.out.println(stb.toString());
    }

    public Classification getUserInput() {
        boolean validity = false;
        BufferedReader br = null;
        Classification uc = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            do {
                String ucs = br.readLine();
                validity = validating(ucs);
                if (!validity) {
                    System.out.println("Please enter one of the valid options. ");
                } else {
                    uc = Classification.valueOf(ucs.toUpperCase());
                }
            } while (!validity);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error while reading from input.", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return uc;
    }

    public boolean validating(String uc) {
        for (Classification ch : Classification.values()) {
            if (ch.getKeyword().equals(uc)) {
                return true;
            }
        }
        return false;
    }

    public Classification computerChoices() {
        return Classification.values()[new Random().nextInt(Classification.values().length)];
    }

    public void evalRes(Classification uc, Classification computerChoice) {
        if (uc == computerChoice) {
            System.out.println("It's a tie!");
            return;
        }

        if (uc.winningAgainst().contains(computerChoice)) {
            System.out.println("You won!");
        } else {
            System.out.println("The computer won.");
        }
    }

    public void playGame() {
        printUserOptions();
        Classification uc = getUserInput();
        Classification computerChoice = computerChoices();

        System.out.println("");
        System.out.println("You picked: " + uc.getKeyword());
        System.out.println("Computer picked: " + computerChoice.getKeyword());
        System.out.println("");
        evalRes(uc, computerChoice);
    }

    public static void main(String[] args) {
        GamePiece rockPaperScissors = new GamePiece();
        rockPaperScissors.playGame();
    }
} //end main program
