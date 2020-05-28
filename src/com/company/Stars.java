package com.company;

public class Stars {
    // ======== INSTANCE VARIABLES ========
    private int numberOfStars = 0;

    // ======== CONSTRUCTORS ========
    public Stars() {
    }

    /*
     * Increments the current number of stars by 1.
     */
    public void addStar() {
        numberOfStars++;
    }

    /*
     * Decrements the current number of stars by 1, then sets it to 0 if the resulting integer is less than 0.
     */
    public void removeStar() {
        numberOfStars--;
        if (numberOfStars < 0) {
            numberOfStars = 0;
        }

    }

    /*
     * Returns the remainder of n / 5, where n represents the current number of stars
     */
    private int starsMod5() {
        return numberOfStars % 5;
    }

    /*
     * Returns the remainder of n / 10, where n represents the current number of stars
     */
    private int starsMod10() {
        return numberOfStars % 10;
    }

    /*
     * Returns the number of groups of five stars each that can be made with the current number of stars.
     */
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

    /*
     * Returns the number of groups of ten stars each that can be made with the current number of stars.
     */
    private int groupsOf10Stars() {
        return (numberOfStars - starsMod10()) / 10;
    }

    /*
     * Returns a String representing the current star inventory.
     */
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
