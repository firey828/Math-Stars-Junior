package com.company;

public class Game {

    // ======== INSTANCE VARIABLES ========
    private String name;
    private Problem[] problems;
    private Stars stars;

    // ======== CONSTRUCTORS ========
    public Game(String user, Problem[] probs, Stars myStars) {
        name = user;
        problems = probs;
        stars = myStars;
    }

    /*
     * Does a game.
     */
    public void play() {
        GameMethods gm = new GameMethods();
        int additionWrong = 0;
        int subtractionWrong = 0;
        int numCorrect = 0;

        for (int i = 0; i < problems.length; i++) {
            String numAsString;
            for (numAsString = gm.ask(stars.toString() + "\n" +
                    "\n" + problems[i].toString()); numAsString.length() == 0 || gm.isInt(numAsString) || numAsString.charAt(0) == '0' && problems[i].getAnswer() != 0; numAsString = gm.ask(stars.toString() + "\n" +
                    "\n" + problems[i].toString())) {
                gm.say("I'm sorry, " + name + ", but I couldn't understand what you meant!\n" +
                        "Make sure you're typing in numbers instead of words.\n" +
                        "For example, instead of \"three\", type \"3\"!");
                gm.say("Let's try that again!");
            }

            int guess = Integer.parseInt(numAsString);
            boolean isCorrect = problems[i].checkIfCorrect(guess, stars);
            if (isCorrect && i != problems.length) {
                gm.sayRandomCongrats(name);
                numCorrect++;
            } else if (i != problems.length) {
                gm.sayRandomCondolences(name);
                if (problems[i].getSymbol().equals("+")) {
                    additionWrong++;
                } else {
                    subtractionWrong++;
                }
            }
        }

        double score = 100.0 * ((double) numCorrect / (double) problems.length);
        gm.say("You got " + score + "% ( " + numCorrect + " / " + problems.length + " )! ");
        gm.say("You got " + additionWrong + " addition problems wrong and " + subtractionWrong + " subtraction problems wrong! ");
        if (score == 0.0) {
            gm.say("Oh no! You didn't get any of the problems right!\n" +
                    "Ask a parent or your teacher to help you with the things you don't understand!");
        } else if (score <= 25.0) {
            gm.say("You got a lot of the problems wrong!\n" +
                    "Ask a parent or your teacher to help you with the things you don't understand!");
        } else if (score <= 50.0) {
            gm.say("You got a few of the problems wrong!\n" +
                    "Ask a parent or your teacher to help you with the things you don't understand!");
        } else if (score <= 75.0) {
            gm.say("You did good, but you can always do better!\n" +
                    "Ask a parent or your teacher to help you with the things you don't understand!");
        } else if (score <= 90.0) {
            gm.say("You're almost there! If you play again, I'm sure you\n" +
                    "can get an even higher score! I believe in you, " + name + "! ");
        } else if (score <= 99.0) {
            gm.say("Congratulations, " + name + "! You're a math star!\n" +
                    "Play again and try to get an even higher score!");
        } else {
            gm.say("Wow, " + name + "! You got everything right!\n" +
                    "You aren't just a math star -- you're a math superstar!!");
        }

        if (additionWrong > subtractionWrong) {
            gm.say("You should work on your addition skills!");
        } else if (additionWrong < subtractionWrong) {
            gm.say("You should work on your subtraction skills!");
        } else if (additionWrong > 0) {
            gm.say("You should work on both your addition skills and your subtraction skills!");
        }

    }
}
