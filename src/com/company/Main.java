package com.company;

class Main {
    Main() {
    }

    public static void main(String[] args) {
        GameMethods gm = new GameMethods();
        String name = gm.ask("Welcome to the Math Star Game! What is your name? ");
        gm.say("Nice to meet you, " + name + "! I hope you're ready to become a math star! ");
        Stars stars = new Stars();
        int numberOfQuestions = 0;
        String numAsString = "0";

        for (numAsString = gm.ask("Great! The rules of this game are simple: The more " +
                "questions you get right, the more stars you get! For a challenge, play against " +
                "your friends to see who can get the most stars!\n" +
                "\n" +
                "Before we begin, can you tell me how many questions you want me to ask you? " +
                "(If you don't know, just ask an adult!)");
             numAsString.length() == 0 || gm.isInt(numAsString) || numAsString.charAt(0) == '0';
             numAsString = gm.ask("I'm sorry, " + name + ", but I couldn't\n" +
                     "understand what you meant! Make sure you're typing in numbers\n" +
                     "instead of words. For example, instead of \"three\", type \"3\"!\n" +
                     "\n" +
                     "Let's try that again! How many questions should I ask you? ")) {
        }

        numberOfQuestions = Integer.parseInt(numAsString);
        Problem[] problems = new Problem[numberOfQuestions];

        int x;
        for (x = 0; x < problems.length; ++x) {
            problems[x] = new Problem(x + 1);
        }

        for (x = 0; x < problems.length; ++x) {
            for (int y = 0; y < problems.length; ++y) {
                if (x != y) {
                    while (problems[x].equals(problems[y])) {
                        problems[x] = new Problem(x + 1);
                    }
                }
            }
        }

        Game game = new Game(name, problems, stars);
        game.play();
    }
}