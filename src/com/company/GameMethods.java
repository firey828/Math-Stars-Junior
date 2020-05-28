package com.company;

import java.awt.Component;
import javax.swing.JOptionPane;

class GameMethods {

    // ======== CONSTRUCTORS ========
    GameMethods() {
    }

    boolean isInt(String s) {
        for(int i = 0; i < s.length(); ++i) {
            if (!Character.isDigit(s.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    void sayRandomCongrats(String name) {
        double msgID = Math.random();
        if (msgID == 0.0D) {
            this.say("You're doing great, " + name + "!");
        } else if (msgID <= 0.1D) {
            this.say("Nice job, " + name + "!");
        } else if (msgID <= 0.2D) {
            this.say("You'll be a math star in no time, " + name + "!");
        } else if (msgID <= 0.3D) {
            this.say("Good work, " + name + "!");
        } else if (msgID <= 0.4D) {
            this.say("Wow! You're so smart, " + name + "!");
        } else if (msgID <= 0.5D) {
            this.say("Well done, " + name + "!");
        } else if (msgID <= 0.6D) {
            this.say("That was awesome, " + name + "!");
        } else if (msgID <= 0.7D) {
            this.say("Keep going, " + name + "!");
        } else if (msgID <= 0.8D) {
            this.say("You're almost there, " + name + "!");
        } else if (msgID <= 0.9D) {
            this.say("Isn't this fun, " + name + "?");
        } else {
            this.say("You're a genius, " + name + "!");
        }

    }

    void sayRandomCondolences(String name) {
        double msgID = Math.random();
        if (msgID == 0.0D) {
            this.say("Don't worry, " + name + "! You'll get it next time!");
        } else if (msgID <= 0.1D) {
            this.say("So close!");
        } else if (msgID <= 0.2D) {
            this.say("You're still a math star to me, " + name + "!");
        } else if (msgID <= 0.3D) {
            this.say("Keep going! You can still make it!");
        } else if (msgID <= 0.4D) {
            this.say("You tried your best, and that's what matters!");
        } else if (msgID <= 0.5D) {
            this.say("We all make mistakes!");
        } else if (msgID <= 0.6D) {
            this.say("That's okay! You can do it!");
        } else if (msgID <= 0.7D) {
            this.say("You may have lost a star, but you're still a star to me, " + name + "!");
        } else if (msgID <= 0.8D) {
            this.say("Come on, " + name + "! You can do it!");
        } else if (msgID <= 0.9D) {
            this.say("Nobody's perfect!");
        } else {
            this.say("You're still doing great, " + name + "!");
        }

    }

    void say(String msg) {
        JOptionPane.showMessageDialog((Component)null, msg);
    }

    String ask(String msg) {
        String s = JOptionPane.showInputDialog(msg);
        if (s.equalsIgnoreCase("exit")) {
            this.say("Goodbye.");
            System.exit(0);
        }

        return s;
    }
}
