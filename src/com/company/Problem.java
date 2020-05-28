package com.company;

public class Problem {

    // ======== INSTANCE VARIABLES ========
    private boolean isAddition;
    private int currentNumber;
    private int firstInt;
    private int secondInt;
    private int answer;
    private String operationSymbol;

    // ======== GETTERS ========
    public String getSymbol() {
        return operationSymbol;
    }
    public int getAnswer() {
        return answer;
    }

    // ======== SETTERS ========
    private void setViaRerollIfNecessary() {
        if (!isAddition) {
            while(firstInt - secondInt < 0) {
                rerollFirstInt();
                rerollSecondInt();
            }
        }
    }

    // ======== CONSTRUCTORS ========
    public Problem(int problemNumber) {
        currentNumber = problemNumber;
        isAddition = false;
        if (Math.random() > 0.5) {
            isAddition = true;
            operationSymbol = "+";
        } else {
            operationSymbol = "-";
        }

        firstInt = (int)(Math.random() * 10.0);
        secondInt = (int)(Math.random() * 10.0);
        setViaRerollIfNecessary();
        if (isAddition) {
            answer = firstInt + secondInt;
        } else {
            answer = firstInt - secondInt;
        }

    }

    /*
     * Adds a star and returns true if the guess is equal to the correct answer, removes a
     * star and returns false otherwise.
     */
    public boolean checkIfCorrect(int guess, Stars stars) {
        if (guess == answer) {
            stars.addStar();
            return true;
        } else {
            stars.removeStar();
            return false;
        }
    }

    /*
     * Randomly selects an integer from 1 to 10 and assigns it to firstInt.
     */
    private void rerollFirstInt() {
        firstInt = (int)(Math.random() * 10.0);
    }

    /*
     * Randomly selects an integer from 1 to 10 and assigns it to secondInt.
     */
    private void rerollSecondInt() {
        secondInt = (int)(Math.random() * 10.0);
    }

    /*
     * Returns a String representing the current question
     */
    public String toString() {
        return "Question #" + currentNumber + ": What is " + firstInt + " " + operationSymbol + " " + secondInt + "? ";
    }
}
