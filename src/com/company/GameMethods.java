package com.company;

import java.awt.Component;
import javax.swing.JOptionPane;

class GameMethods {

    // ======== CONSTRUCTORS ========
    public GameMethods() {
    }

    /*
     * Returns true if the String s represents a valid integer value, false otherwise
     */
    public boolean isInt(String s) {
        for(int i = 0; i < s.length(); ++i) {
            if (!Character.isDigit(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /*
     * Displays a random selection from the following:
     *
     * "You're doing great, [NAME]!"
     * "Nice job, [NAME]!"
     * "You'll be a math star in no time, [NAME]!"
     * "Good work, [NAME]!"
     * "Wow! You're so smart, [NAME]!"
     * "Well done, [NAME]!"
     * "That was awesome, [NAME]!"
     * "Keep going, [NAME]!"
     * "You're almost there, [NAME]!"
     * "Isn't this fun, [NAME]?"
     * "You're a genius, [NAME]!"
     */
    public void sayRandomCongrats(String name) {
        double msgID = Math.random();
        if (msgID == 0.0) {
            say("You're doing great, " + name + "!");
        } else if (msgID <= 0.1) {
            say("Nice job, " + name + "!");
        } else if (msgID <= 0.2) {
            say("You'll be a math star in no time, " + name + "!");
        } else if (msgID <= 0.3) {
            say("Good work, " + name + "!");
        } else if (msgID <= 0.4) {
            say("Wow! You're so smart, " + name + "!");
        } else if (msgID <= 0.5) {
            say("Well done, " + name + "!");
        } else if (msgID <= 0.6) {
            say("That was awesome, " + name + "!");
        } else if (msgID <= 0.7) {
            say("Keep going, " + name + "!");
        } else if (msgID <= 0.8) {
            say("You're almost there, " + name + "!");
        } else if (msgID <= 0.9) {
            say("Isn't this fun, " + name + "?");
        } else {
            say("You're a genius, " + name + "!");
        }

    }

    /*
     * Displays a random selection from the following:
     *
     * "Don't worry, [NAME]! You'll get it next time!"
     * "So close!"
     * "You're still a math star to me, [NAME]!"
     * "Keep going! You can still make it!"
     * "You tried your best, and that's what matters!"
     * "We all make mistakes!"
     * "That's okay! You can do it!"
     * "You may have lost a star, but you're still a star to me, [NAME]!"
     * "Come on, [NAME]! You can do it!"
     * "Nobody's perfect!"
     * "You're still doing great, [NAME]!"
     */
    public void sayRandomCondolences(String name) {
        double msgID = Math.random();
        if (msgID == 0.0) {
            say("Don't worry, " + name + "! You'll get it next time!");
        } else if (msgID <= 0.1) {
            say("So close!");
        } else if (msgID <= 0.2) {
            say("You're still a math star to me, " + name + "!");
        } else if (msgID <= 0.3) {
            say("Keep going! You can still make it!");
        } else if (msgID <= 0.4) {
            say("You tried your best, and that's what matters!");
        } else if (msgID <= 0.5) {
            say("We all make mistakes!");
        } else if (msgID <= 0.6) {
            say("That's okay! You can do it!");
        } else if (msgID <= 0.7) {
            say("You may have lost a star, but you're still a star to me, " + name + "!");
        } else if (msgID <= 0.8) {
            say("Come on, " + name + "! You can do it!");
        } else if (msgID <= 0.9) {
            say("Nobody's perfect!");
        } else {
            say("You're still doing great, " + name + "!");
        }

    }

    /*
     * Produces a JOptionPane message dialogue pop-up with the String msg as its content.
     */
    public void say(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    /*
     * Produces a JOptionPane input dialogue pop-up with the String msg as its content and returns
     * user input as long as said input is not some capitalization of "exit". If it is, then the
     * program will produce a pop-up that says "Goodbye." and the program will terminate.
     */
    public String ask(String msg) {
        String s = JOptionPane.showInputDialog(msg);
        if (s.equalsIgnoreCase("exit")) {
            say("Goodbye.");
            System.exit(0);
        }

        return s;
    }
}
