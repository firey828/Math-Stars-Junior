//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

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

    // ======== CONSTRUCTORS ========
    public Problem(int problemNumber) {
        currentNumber = problemNumber;
        isAddition = false;
        if (Math.random() > 0.5D) {
            isAddition = true;
            operationSymbol = "+";
        } else {
            operationSymbol = "-";
        }

        firstInt = (int)(Math.random() * 10.0D);
        secondInt = (int)(Math.random() * 10.0D);
        setViaRerollIfNecessary();
        if (isAddition) {
            answer = firstInt + secondInt;
        } else {
            answer = firstInt - secondInt;
        }

    }

    private void setViaRerollIfNecessary() {
        if (!isAddition) {
            while(firstInt - secondInt < 0) {
                rerollFirstInt();
                rerollSecondInt();
            }
        }

    }

    boolean checkIfCorrect(int guess, Stars stars) {
        if (guess == answer) {
            stars.addStar();
            return true;
        } else {
            stars.removeStar();
            return false;
        }
    }

    private void rerollFirstInt() {
        firstInt = (int)(Math.random() * 10.0D);
    }

    private void rerollSecondInt() {
        secondInt = (int)(Math.random() * 10.0D);
    }

    public String toString() {
        return "Question #" + currentNumber + ": What is " + firstInt + " " + operationSymbol + " " + secondInt + "? ";
    }
}
