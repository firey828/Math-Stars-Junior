package com.company;

public class Stars {
    private int numberOfStars = 0;

    Stars() {
    }

    void addStar() {
        ++numberOfStars;
    }

    void removeStar() {
        --numberOfStars;
        if (numberOfStars < 0) {
            numberOfStars = 0;
        }

    }

    private int starsMod5() {
        return numberOfStars % 5;
    }

    private int starsMod10() {
        return numberOfStars % 10;
    }

    private int groupsOf5Stars() {
        if (numberOfStars >= 5 && starsMod10() == 5) {
            return 1;
        } else if ((numberOfStars - 6) % 10 == 0) {
            return 1;
        } else if ((numberOfStars - 7) % 10 == 0) {
            return 1;
        } else if ((numberOfStars - 8) % 10 == 0) {
            return 1;
        } else {
            return (numberOfStars - 9) % 10 == 0 ? 1 : 0;
        }
    }

    private int groupsOf10Stars() {
        return (numberOfStars - starsMod10()) / 10;
    }

    public void debugMode(int upper) {
        GameMethods gm = new GameMethods();
        String msg = "";

        for(int i = 0; i < upper; ++i) {
            numberOfStars = i + 1;
            msg = msg + (i + 1) + " stars: " + toString() + "\n";
        }

        gm.say(msg);
    }

    public String toString() {
        String msg = "";
        int remainder = starsMod5();

        int i;
        for(i = 0; i < groupsOf10Stars(); ++i) {
            msg = msg + "********** :D\n";
        }

        for(i = 0; i < groupsOf5Stars(); ++i) {
            msg = msg + "***** :)\n";
        }

        for(i = 0; i < remainder; ++i) {
            msg = msg + "*";
        }

        return msg;
    }
}
