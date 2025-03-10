package rps;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Rock Paper Scissors!");
		System.out.println("How to play:");
		System.out.println("- When asked for your turn, choose from the following:");
		System.out.println("Enter 1 for Rock");
		System.out.println("Enter 2 for Paper");
		System.out.println("Enter 3 for Scissors.");
		System.out.println("Enter q to quit.");
		System.out.println();
		int playerScore = 0;
		int cpuScore = 0;
		
		while(true) {
			String chosenValue = getPlayerValue(sc);
			
			//If they have chosen to quit then exit the loop
			if(chosenValue.equals("q")) {
				System.out.println("Thanks for playing, goodbye!");
				break;
			}
			
			int cpuVal = getCpuValue();		
			int winner = getWinner(chosenValue, cpuVal);
			switch(winner) {
				//Player Won
				case 1:
					playerScore = playerScore + 1;
					System.out.println("Congrats! You won, the CPU chose " + getNameOfHand(cpuVal));
					break;
				//CPU Won
				case 2:
					cpuScore = cpuScore + 1;
					System.out.println("Unlucky! The CPU won, they chose " + getNameOfHand(cpuVal));
					break;
				//Draw
				default:
					System.out.println("A Draw! You both drew the same hand!");
					break;
			}
			
			System.out.println("Current score is: You - " +  playerScore + ", CPU - " + cpuScore);
			
		}
	}
	
	private static String getNameOfHand(int value) {
		switch(value) {
			case 1:
				return "Rock";
			case 2:
				return "Paper";
			default:
				return "Scissors";
		}
	}
	
	private static int getWinner(String playerEnteredValue, int cpuVal) {
		int playerVal = Integer.parseInt(playerEnteredValue);

		
		//If the player and CPU choose the same thing, return 0 to indicate a draw
		if(playerVal == cpuVal)
			return 0;
		
		//If the player chose Rock.
		//Return 2 for the CPU if they chose Paper
		//Else return 1 for the player if they chose scissors
		if(playerVal == 1) {
			if(cpuVal == 2) return 2;
			else return 1;
		}
		
		//If the player chose Paper.
		//Return 2 for the CPU if they chose Scissors
		//Else return 1 for the player if they chose Rock
		if(playerVal == 2) {
			if(cpuVal == 3) return 2;
			else return 1;
		}
		
		//If the player chose Scissors.
		//Return 2 for the CPU if they chose Rock
		//Else return 1 for the player if they chose Paper
		if(playerVal == 3) {
			if(cpuVal == 1) return 2;
			else return 1;
		}
		
		return 0;
	}
	
	private static String getPlayerValue(Scanner scanner) {
		while(true) {
			System.out.println("Your turn! Choose a value [1 - Rock, 2 - Paper, 3 - Scissors, q - Quit]");
			String enteredValue = scanner.next().trim().toLowerCase();
			if(!enteredValue.equals("1")
				&& !enteredValue.equals("2")
				&& !enteredValue.equals("3")
				&& !enteredValue.equals("q")) {
				
				System.out.println("Invalid selection!");
			}
			return enteredValue;
		}
	}
	
	private static int getCpuValue() {
		Random rand = new Random();
		// Obtain a number between [1 - 3].
		return rand.nextInt(1, 4);
	}
}
