package com.company;

public class Game {
    private String name;
    private Problem[] problems;
    private Stars stars;

    public Game(String user, Problem[] probs, Stars myStars) {
        name = user;
        problems = probs;
        stars = myStars;
    }

    public void play() {
        GameMethods gm = new GameMethods();
        int additionWrong = 0;
        int subtractionWrong = 0;
        int numCorrect = 0;

        for (int i = 0; i < problems.length; i++) {
            String numAsString;
            for (numAsString = gm.ask(stars.toString() + "\n\n" + problems[i].toString()); numAsString.length() == 0 || gm.isInt(numAsString) || numAsString.charAt(0) == '0' && problems[i].getAnswer() != 0; numAsString = gm.ask(stars.toString() + "\n\n" + problems[i].toString())) {
                gm.say("I'm sorry, " + name + ", but I couldn't understand what you meant!\nMake sure you're typing in numbers instead of words.\nFor example, instead of \"three\", type \"3\"!");
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

        double score = 100.0D * ((double) numCorrect / (double) problems.length);
        gm.say("You got " + score + "% ( " + numCorrect + " / " + problems.length + " )! ");
        gm.say("You got " + additionWrong + " addition problems wrong and " + subtractionWrong + " subtraction problems wrong! ");
        if (score == 0.0D) {
            gm.say("Oh no! You didn't get any of the problems right!\nAsk a parent or your teacher to help you with the things you don't understand!");
        } else if (score <= 25.0D) {
            gm.say("You got a lot of the problems wrong!\nAsk a parent or your teacher to help you with the things you don't understand!");
        } else if (score <= 50.0D) {
            gm.say("You got a few of the problems wrong!\nAsk a parent or your teacher to help you with the things you don't understand!");
        } else if (score <= 75.0D) {
            gm.say("You did good, but you can always do better!\nAsk a parent or your teacher to help you with the things you don't understand!");
        } else if (score <= 90.0D) {
            gm.say("You're almost there! If you play again, I'm sure you\ncan get an even higher score! I believe in you, " + name + "! ");
        } else if (score <= 99.0D) {
            gm.say("Congratulations, " + name + "! You're a math star!\nPlay again and try to get an even higher score!");
        } else {
            gm.say("Wow, " + name + "! You got everything right!\nYou aren't just a math star -- you're a math superstar!!");
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
