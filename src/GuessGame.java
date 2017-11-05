import java.util.Scanner;
public class GuessGame {
	public static void main(String[] args) {
		boolean play = true;
		Scanner key = new Scanner(System.in);
		while(play) {//main loop for game repetition
			int randomnum, usernum, UserG, CurrentCPUG, GuessC=0, CPUGuessC=0, max = 100, min = 0, userc;//ints for game
			randomnum = (int)(100*Math.random()+1);//creating first num for user to guess
			boolean uguess = false, cpuguess = false;//creating bools for nested while loops
			while(!uguess) {
				System.out.println("Enter your guess:");
				UserG = key.nextInt();
				if (UserG == randomnum) {//correct guess
					System.out.println("Correct");
					GuessC++;//count number of guesses
					System.out.println("My turn");
					uguess = true;//break out of loop and start computer guessing setions
				}else if (UserG > randomnum) {//high guess
					System.out.println("Hi");
					GuessC++;//count number of guesses
				}else if (UserG < randomnum){//low guess
					System.out.println("Lo");
					GuessC++;//count number of guesses
				}
			}

			CurrentCPUG = (int)(100*Math.random()+1);//make fist guess from computer 
			while(!cpuguess) {
				System.out.println("The computer's guess is:" + CurrentCPUG);//prompt user with computer's guess
				System.out.println("Please type in 1 for Hi, 2 for Lo, or 3 for a correct guess from the computer");//show user the options
				userc = key.nextInt();//record user input
				switch(userc) {
				case 1://if the computert's guess was High
					max = CurrentCPUG-1;//set the max a guess can be based on previous guess
					CurrentCPUG = (int)((max-min)*Math.random()+min);//guess new number based on max and min
					CPUGuessC++;//count number of guesses
					break;
				case 2://if the computert's guess was low
					min = CurrentCPUG+1;//set the min a guess can be based on previous guess
					CurrentCPUG = (int)((max-min)*Math.random()+min);//guess new number based on max and min.out.println();
					CPUGuessC++;//count number of guesses
					break;
				case 3://if the computert's guess was correct
					CPUGuessC++;//count number of guesses
					cpuguess = true;//break out of while loop
					break;
				}
			
			}
			if(CPUGuessC == GuessC) {//if the user and the computer tied prompt user
				System.out.println("TIE!");
				System.out.println("You both guessed " + GuessC + " times");
			}else if(CPUGuessC > GuessC) {//if the user wins prompt user with why
				System.out.println("You Win!");
				System.out.println("You guessed " + GuessC + " times");
				System.out.println("The computer " + CPUGuessC + " times");
			}else if(CPUGuessC < GuessC) {//if the user loses prompt user with why
				System.out.println("You Lose!");
				System.out.println("You guessed " + GuessC + " times");
				System.out.println("The computer " + CPUGuessC + " times");
			}
			
			System.out.println("Would you like to play again? Type 1 to play again or 2 to quit");//ask user if they'd like to play again
			if (key.nextInt() == 2) {//if they do not want to play again break out of loop and end program
				play = false;
			}else {//if they do wish to play gain restart
				play = true;
			}
		}

	}

}