import java.awt.*;
import hsa.Console;
import java.io.*;

public class Hangman_CPT
{
    static Console c;

    public static void main (String[] args) throws IOException
    {
	c = new Console (30, 125, 16); // Sets the dimensions of the user screen
	c.setTextBackgroundColor (new Color (0, 255, 255)); // Sets the background color to cyan

	String word, playagain, playagain2, place, newstring, wrong, character, letter, word2, category, notify2, notify, notify3, scores, scores2, scores1;
	char playagin, highscore1, highscore2, highscore3, score2;
	int wordline, score, letterspot, start, asciival, asciival2, scoreorder; // All variables are declared here
	c.clear ();

	int games = 0; // Games is an integer to keep track of the number of games played

	while (true)
	{
	    notify2 = ("no"); // This is a string used to cancel the action of notifying the user of incorrect data entered
	    while (true)
	    {
		c.println ("-----------------------------------------------------------HANGMAN-----------------------------------------------------------");
		c.println ("Welcome to the classic game of hangman!");
		c.println ();
		c.println ("The rules are as follows: ");
		c.println ();
		c.println ("- You will select from a series of categories, each a series of words");
		c.println ("- Your objective is to type in any letter, and letters that are in the word will appear in the spaces, and the ones that aren't will appear in a box called 'Wrong Letters'");
		c.println ("- You have a maximum of 7 wrong letters, and once you have 7 wrong letters used, its game over. You will have the option to try again");
		c.println ("- The case of any of the letters you type in does not matter");
		c.println ("- Score is calculated by the number of wrong guesses it takes to figure out the word in a single game, so the lower your score, the better");
		c.println ("- There are no numbers or special characters in these words, just letters"); // All of this text welcomes the user and displays all the rules
		c.println ();
		c.println ("The categories are:");
		c.println ("1. Movie Franchises");
		c.println ("2. Countries");
		c.println ("3. Hockey Teams");
		c.println ("4. TV Shows");
		c.println ("5. Video Games"); // Each category here has a number assigned to it, to make it easier for the user to select one
		c.println ();

		if (notify2.equals ("notcategory")) // This is if the user has not entered one of the category numbers from above
		{
		    c.println ("This is not one of the categories");
		    notify2 = ("no"); // After incorrect data is entered, notify is set back to "no" so that the program does not go back into this if statement unless it must
		}

		c.println ("Enter a category number from above:"); // Asks the user to enter a category
		category = c.readLine ();

		if (category.equals ("1"))
		{
		    category = ("Movie Franchises");
		    c.clear ();
		    break;
		}

		else if (category.equals ("2"))
		{
		    category = ("Countries");
		    c.clear ();
		    break;
		}

		else if (category.equals ("3"))
		{
		    category = ("Hockey Teams");
		    c.clear ();
		    break;
		}

		else if (category.equals ("4"))
		{
		    category = ("Tv Shows");
		    c.clear ();
		    break;
		}

		else if (category.equals ("5")) // The user is meant to enter a number between 1 and 5, and each number will have a category selected
		{
		    category = ("Video Games");
		    c.clear (); // Clears the screen of the rules to begin the actual game of hangman
		    break;
		}

		else
		{
		    notify2 = ("notcategory"); // If the user does not enter valid data, the the variable 'notify2' will have this data, and instead of breaking out of this while loop, it will loop back up and go into the if statement that notifies the user that their category selection is invalid
		    c.clear ();
		}
	    }

	    BufferedReader input;
	    input = new BufferedReader (new FileReader (category + ".txt")); // Sets up the BufferedReader

	    wordline = (int) (Math.random () * 13); // A random number between 0 and 12 will be generated for later purposes

	    for (int count = 0 ; count < wordline ; count++) // This loop will go on until the integer 'count' is equal to the random number generated
	    {
		word = input.readLine (); // Each time in this loop, a new line will be read into the variable 'word', and it will stop at whatever random number has been generated, because each text file has 13 words
	    }

	    word = input.readLine (); // The word the user will try to guess is now set

	    newstring = (""); // This string will represent the random word with its characters replaced with dashes

	    for (int spot = 0 ; spot < word.length () ; spot++) // This loop is built to go through every single character in the selected word
	    {
		place = word.substring (spot, spot + 1); // This variable will be every single character in the word each time the loop goes through

		if (place.equals (" ")) // If the character searcher encounters a space in the word, this becomes part of 'newstring'
		{
		    newstring = (newstring + (" "));
		}

		else // If the character searcher encounters any letter, a dash sign will be added onto 'newstring'
		{
		    newstring = (newstring + ("-"));
		}
	    }
	    score = 0; // Keeps track of the number of wrong guesses the user gets
	    wrong = ("Wrong Letters: "); // A string that displays the letters the user has gotten wrong
	    notify = ("no"); // As before, this string is set to 'no' so that at first, no notifications will be displayed to the user

	    while (score < 7) // While the user is still in the game
	    {
		start = 0;
		c.println ("-----------------------------------------------------------HANGMAN-----------------------------------------------------------"); // Top title
		c.println ("Category: " + category); // Displays category to the user
		c.println ();
		c.setColor (Color.black);
		c.drawLine (950, 500, 1200, 500);
		c.drawLine (1075, 500, 1075, 200);
		c.drawLine (1075, 200, 950, 200);
		c.drawLine (950, 200, 950, 250); // Draws the stand to hang the hangman

		if (notify.equals ("alreadywrong")) // If the user guesses a letter they have already guessed wrong
		{
		    c.println ("You have gotten this letter wrong already");
		    notify = ("no");
		}

		else if (notify.equals ("alreadycorrect")) // If the user guesses a letter they have already gotten correct
		{
		    c.println ("You have gotten this letter correct already");
		    notify = ("no");
		}

		else if (notify.equals ("lettersonly")) // If the user enters a character that is not a letter
		{
		    c.println ("This is not a letter");
		    notify = ("no");
		}

		else if (notify.equals ("oneonly")) // If the user enters more than one character
		{
		    c.println ("You must enter one letter at a time");
		    notify = ("no"); // In each of these if statements, notify is set back to no, so that the variable 'notify' is set back to normal if any further notifications are needed
		}

		c.println (wrong); // Displays the characters the user guesses incorrectly
		c.println ("Incorrect Guesses: " + score + "/7"); // Displays how many guesses the user has until they lose the game
		c.println ();
		c.println (newstring); // Displays the word replaced by dashes
		c.println ();
		c.print ("Enter a letter: "); // Asks the user to enter a letter
		letter = c.readString ();
		letter = letter.toLowerCase (); // If the user ever enters a lower case letter

		word2 = word.toLowerCase (); // Since the words in the text files are written formally and have an upper case character at the beginning of each word, it converts all of them to lower case to make it simpler

		if (letter.length () != 1) // If the user types in more than one character
		{
		    notify = ("oneonly"); // So that the user is notified and one of the if statements is triggered
		}

		else // If the user guesses one character
		{
		    if ((int) letter.charAt (0) >= 97 && (int) letter.charAt (0) <= 122) // If the character is a letter according to the ascii alphabet
		    {
		    }

		    else // If its not a letter
		    {
			notify = ("lettersonly"); // So that the user is notified and one of the if statements will be triggered above
		    }
		}

		letterspot = word2.indexOf (letter, 0); // Checks to see if the letter guessed by the user is in the word

		if (letterspot == -1) // If the user guesses an incorrect letter
		{
		    if (wrong.indexOf (letter, 13) != -1) // Checks the list of incorrect letters to see if the user has guessed the letter wrong already
		    {
			notify = ("alreadywrong"); // So that the user is notified by one of the if statements above
		    }

		    else // If the user has not gotten the letter wrong yet
		    {
			if (notify.equals ("lettersonly")) // Makes sure the program does not search for invalid data in the word and puts it as an incorrect letter
			{
			}

			else if (notify.equals ("oneonly")) // Makes sure the program does not search for invalid data in the word and puts it as an incorrect letter
			{
			}

			else // If the data entered is valid
			{
			    score++; // Increases the score by one each time
			    wrong = (wrong + (letter + " ")); // Adds the incorrect letter to the list of incorrect ones
			}
		    }
		    c.clear (); // clears the screen to have another letter entered
		}

		else // If the user guesses a correct letter
		{

		    if (newstring.indexOf (letter, 0) != -1) // Checks if the user has gotten the letter correct already
		    {
			notify = ("alreadycorrect"); // So that the user is notified by one of the if statements above
		    }
		    while (true)
		    {
			letterspot = word2.indexOf (letter, start); // Searches the location of the correct letter guessed within the word
			if (letterspot == -1) // When the program has searched out all the places of the correct letter in the word
			{
			    break;
			}

			else // During the first time in this loop,
			{
			    newstring = newstring.substring (0, (letterspot)) + letter + newstring.substring (letterspot + 1); // The 'newstring' is updated each time, so it replaces the correct dash with the correct letter guessed
			    start = letterspot + 1; // Each time the loop goes through, the program stars at a new spot and finds the next spot of the correct letter in the word and replaces that dash with the letter
			}
		    }
		    c.clear (); // Clears the screen to have the user enter a letter again
		}

		if (newstring.indexOf (("-"), 0) == -1) // If there are no more dashes in the newstring, and the user has guessed all the letters and they have won the game
		{
		    break;
		}

		if (score == 1)
		{
		    c.drawOval (925, 250, 50, 50); // After one wrong guess, the head is drawn
		}

		else if (score == 2)
		{
		    c.drawOval (925, 250, 50, 50);
		    c.drawLine (950, 300, 950, 400); // The torso is drawn, with each succeding point, the previous object is drawn in addition with another part
		}

		else if (score == 3)
		{
		    c.drawOval (925, 250, 50, 50);
		    c.drawLine (950, 300, 950, 400);
		    c.drawLine (950, 325, 990, 375); // The right hand is drawn
		}

		else if (score == 4)
		{
		    c.drawOval (925, 250, 50, 50);
		    c.drawLine (950, 300, 950, 400);
		    c.drawLine (950, 325, 990, 375);
		    c.drawLine (950, 325, 910, 375); // The left hand is drawn
		}

		else if (score == 5)
		{
		    c.drawOval (925, 250, 50, 50);
		    c.drawLine (950, 300, 950, 400);
		    c.drawLine (950, 325, 990, 375);
		    c.drawLine (950, 325, 910, 375);
		    c.drawLine (950, 400, 910, 450); // The left leg is drawn
		}

		else if (score == 6)
		{
		    c.drawOval (925, 250, 50, 50);
		    c.drawLine (950, 300, 950, 400);
		    c.drawLine (950, 325, 990, 375);
		    c.drawLine (950, 325, 910, 375);
		    c.drawLine (950, 400, 910, 450);
		    c.drawLine (950, 400, 990, 450); // The right leg is drawn
		}

		else if (score == 7) // The maximum number of guesses before the user looses
		{
		    c.drawOval (925, 250, 50, 50);
		    c.drawLine (950, 300, 950, 400);
		    c.drawLine (950, 325, 990, 375);
		    c.drawLine (950, 325, 910, 375);
		    c.drawLine (950, 400, 910, 450);
		    c.drawLine (950, 400, 990, 450);
		    c.setColor (Color.gray);
		    c.fillOval (925, 250, 50, 50);
		    c.setColor (Color.black);
		    c.drawLine (935, 260, 940, 265);
		    c.drawLine (940, 260, 935, 265);
		    c.drawLine (965, 260, 960, 265);
		    c.drawLine (960, 260, 965, 265);
		    c.drawLine (940, 285, 960, 285); // Draws a grey head with the eyes being x's, indicating that the man has been hanged, and the user has lost the game
		}

	    }
	    if (score < 7) // If the program has breaked and the score is less than the maximum, in other words, the user wins
	    {
		c.println ("-----------------------------------------------------------HANGMAN-----------------------------------------------------------"); // Top title again
		c.println ("The word is " + "'" + word + "'"); // Displays the word to the user
		c.println ("Contratulations! You win");
		c.println ("Your score is " + score); // Displays the score
		c.drawOval (925, 250, 50, 50); // This all displays the man when the user wins, and the differences are that the man has his hands in the air in joy and has a smiley face
		c.drawLine (950, 300, 950, 400);
		c.drawLine (950, 325, 990, 300);
		c.drawLine (950, 325, 910, 300);
		c.drawLine (950, 400, 910, 450);
		c.drawLine (950, 400, 990, 450);
		c.setColor (Color.yellow);
		c.fillOval (925, 250, 50, 50); // Yellow face
		c.setColor (Color.black);
		c.fillOval (935, 260, 5, 5);
		c.fillOval (965, 260, 5, 5); // Eyes
		c.fillOval (938, 270, 25, 25); // Smile as a black circle at first
		c.setColor (Color.yellow);
		c.fillRect (938, 265, 25, 15); // Cuts off half of the black circle drawn to create a semicircle smile
	    }

	    else if (score == 7) // If the program breaked and the user has lost the game
	    {
		c.println ("-----------------------------------------------------------HANGMAN-----------------------------------------------------------"); // Top title again
		c.println ("Sorry, you lost");
		c.println ("The word is '" + word + "'"); // Prints when the user has lost the game
	    }

	    /*scores = ("");
	    scores = scores + score;
	    scores1 = scores;

	    scoreorder = 0;
	    c.println ("High Scores: ");

	    while (scoreorder < 3)
	    {
		scores = ("");
		if (scoreorder == 0)
		{
		    for (int count = 0 ; count < scores.length () ; count++)
		    {
			score2 = score.charAt (count);

			if (count == 0)
			{
			    highscore1 = score2;
			}

			else
			{
			    if (score2 < scores.charAt (count - 1)
			    {

			    }
			}
		    }


		}








	    }*/

	    c.println ();

	    notify3 = ("no"); // As before, this variable will later on exist to notify the user whenever invalid data is entered
	    while (true) // This while loop is to error trap the user's response to whether or not they want to play the game again
	    {
		if (notify3.equals ("notvalid")) // If this variable equals 'notvalid', this if statement is triggered, notifying the user of invalid data entered
		{
		    c.println ("This answer is not valid");
		    notify3 = ("no"); // This variable is set back to 'no' so that this if statement is not triggered again
		}
		playagain2 = ("neutral");
		c.println ("Would you like to play again? Enter 'y' or 'n'"); // Prompts for the user's response
		playagain = c.readString ();
		asciival = ((int) playagain.charAt (0)); // Checks the asciival of the data entered

		if (asciival == 110 && playagain.length () == 1 || asciival == 78 && playagain.length () == 1) // Checks if the user has entered an 'n' and sees if its only one character
		{
		    playagain2 = ("no"); // This change of the string's data will trigger a certain if statement once the program breaks out of this while loop
		    break;
		}

		else if (asciival == 121 && playagain.length () == 1 || asciival == 89 && playagain.length () == 1) // Checks if the user has entered a 'y' and sees if its only one character
		{
		    playagain2 = ("yes"); // This change of the string's data will trigger a certain if statement once the program breaks out of this while loop
		    break;
		}

		else
		{
		    notify3 = ("notvalid"); // This is the one if statement that does not break out of this while loop, and this is where the error trap occurs
		}
		c.clear ();
	    }

	    if (playagain2.equals ("no")) // If the user has eneterd 'n'
	    {
		break;
	    }


	    else if (playagain2.equals ("yes")) // If the user has entered 'y'
	    {
		c.clear (); // It automatically loops all the way back up to start the game again
	    }

	}
	c.close (); // If the user has entered 'n', the program will close
    }
}



