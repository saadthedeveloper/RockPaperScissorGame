package com.mycompany.rockpaperscissorgame;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author msaad
 */
public class RockPaperScissorGame {

    public static void main(String[] args) {
        // Get the result of the game and display it in a dialog
        String result = choiceComparer();
        JOptionPane.showMessageDialog(null, result);
    }

    /**
     * Generates a random choice for the computer.
     * 
     * @return The computer's choice as a string: "Rock", "Paper", or "Scissor".
     */
    public static String computersChoice() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(3) + 1;
        String choice;
        
        if (randomNumber == 1) {
            choice = "Rock";
        } else if (randomNumber == 2) {
            choice = "Paper";
        } else {
            choice = "Scissor";
        }
        return choice;
    }

    /**
     * Prompts the user to choose from "rock", "paper", or "scissor" until a valid choice is entered.
     * 
     * @return The user's valid choice as a string: "Rock", "Paper", or "Scissor".
     */
    public static String humansChoice() {
        String choice;
        boolean status = false;
        
        // Initial prompt to the user
        choice = JOptionPane.showInputDialog("choose from rock, paper and scissor");

        // Check if the initial choice is valid
        if (choice.equalsIgnoreCase("rock") || choice.equalsIgnoreCase("paper") || choice.equalsIgnoreCase("scissor")) {
            status = true;
        }

        // Continue prompting until a valid choice is made
        while (!status) {
            choice = JOptionPane.showInputDialog("choose from rock, paper and scissors\n Enter either into the input box below correctly");
            
            // Check if the new choice is valid
            if (choice.equalsIgnoreCase("rock") || choice.equalsIgnoreCase("paper") || choice.equalsIgnoreCase("scissor")) {
                status = true;
            }
        }
        
        return choice;
    }

    /**
     * Compares the human's choice with the computer's choice and determines the outcome of the game.
     * 
     * @return A string indicating the result of the game: "It's a draw", "You win", or "You lose".
     */
    public static String choiceComparer() {
        String humanChoice;
        String computerChoice;
        String result;
        
        // Get choices from both the human and the computer
        humanChoice = humansChoice();
        computerChoice = computersChoice();
        
        // Determine the result of the game based on the choices
        if (humanChoice.equalsIgnoreCase(computerChoice)) {
            result = "It's a draw! You both chose " + humanChoice;
        } else if ((humanChoice.equalsIgnoreCase("rock") && computerChoice.equalsIgnoreCase("scissor")) ||
                   (humanChoice.equalsIgnoreCase("scissor") && computerChoice.equalsIgnoreCase("paper")) ||
                   (humanChoice.equalsIgnoreCase("paper") && computerChoice.equalsIgnoreCase("rock"))) {
            result = "You win! " + humanChoice + " beats " + computerChoice;
        } else {
            result = "You lose! " + computerChoice + " beats " + humanChoice;
        }
        
        return result;
    }
}
