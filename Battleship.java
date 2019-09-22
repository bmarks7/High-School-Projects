import java.awt.*;
import hsa.Console;
//import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class CPT
{
    static Console c;

    public static void main (String[] args)
    {
	c = new Console (100, 125); // Sets the console to the appropriate size for the game

	while (true)
	{
	    c.setColor (Color.blue);
	    c.setTextBackgroundColor (new Color (0, 255, 255));
	    char start, headsOrTails;

	    c.clear ();
	    while (true)
	    {
		c.println ();
		c.println ();
		c.println ();
		c.println ("---------------------------------------------------WELCOME TO BATTLESHIP!---------------------------------------------------");
		c.println ();
		c.println ();
		c.println ();

		c.println ("Scenario:");
		c.println ();
		c.println ("- Your role will be a NAVY ship commander");
		c.println ();
		c.println ("- The North Koreans are trying to sink your ships");
		c.println ();
		c.println ("- To stop them, you must try to sink their ships with the use of coordinates");

		c.println ();
		c.println ();

		c.println ("Rules:");
		c.println ();
		c.println ("- A coin will be flipped to determine who goes first");
		c.println ();
		c.println ("- You and your enemy will select coordinates and try to hit each other's ships with your missles");
		c.println ();
		c.println ("- Your missles will either be a hit, or a miss");
		c.println ();
		c.println ("- Each ship will take up a certain number of grid points, or 'spots', and you must take out all of their spots to destroy that ship");
		c.println ();
		c.println ("- As you can guess, whoever has all of their own ships completely destroyed first will lose");
		c.println ();
		c.println ("- You may only place ships horizontally or vertically");
		c.println ();
		c.println ("- The coordinates which you have selected, and shich ones were hits and misses will be displayed for you");
		c.println ();
		c.println ();
		c.println ();
		c.println ();
		c.println (); // All the rules are simply printed to the user
		c.println ("Enter 's' to begin(not case sensitive)");
		start = c.getChar ();

		if ((int) start == 83 || (int) start == 115) // Makes sure the user enters either an upper case or lower case 's'
		{
		    break;
		}
		else
		{
		    c.clear ();
		}
	    }

	    c.clear ();
	    String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};
	    String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8"};

	    while (true)
	    {
		c.println ();
		c.println ("Heads or Tails?('h' or 't'):"); // This is a simulation of a heads or tails decision
		headsOrTails = c.getChar ();

		if ((int) headsOrTails == 72 || (int) headsOrTails == 84 || (int) headsOrTails == 104 || (int) headsOrTails == 116)
		{
		    break;
		}
		else
		{
		    c.clear ();
		}
	    }

	    c.println ();
	    c.println ("Flipping.....");
	    try
	    {
		Thread.sleep (2000);
	    }
	    catch (InterruptedException ie)
	    {
		c.println ("Timer not working");
	    }

	    int selectHeadsOrTails = (int) (Math.random () * 2) + 1; // The program 'flips a coin' to determine if it will be heads or tails
	    String turn = "";

	    if (selectHeadsOrTails == 1 && ((int) headsOrTails == 72 || (int) headsOrTails == 84)) // Depending on what the user selects, and how the 'coin' is flipped, the first turn is determined
	    {
		turn = "player";
	    }

	    else if (selectHeadsOrTails == 1 && ((int) headsOrTails == 104 || (int) headsOrTails == 116))
	    {
		turn = "enemy";
	    }

	    else if (selectHeadsOrTails == 2 && ((int) headsOrTails == 72 || (int) headsOrTails == 84))
	    {
		turn = "enemy";
	    }

	    else if (selectHeadsOrTails == 2 && ((int) headsOrTails == 104 || (int) headsOrTails == 116))
	    {
		turn = "player";
	    }

	    while (true)
	    {
		c.println ();
		if (turn.equals ("player"))
		{
		    c.println ("It's your turn");
		}
		else if (turn.equals ("enemy"))
		{
		    c.println ("It's your enemy's turn");
		}
		c.println ();
		c.println ("Enter 's' again to proceed");
		start = c.getChar ();
		if ((int) start == 83 || (int) start == 115) // Again, makes sure that the user enters a lower case or upper cast 'S'
		{
		    c.clear ();
		    break;
		}
		else
		{
		    c.clear ();
		}
	    }

	    int[] shipSizes = {2, 3, 4, 5};
	    int shipSize;
	    String[] [] playerGrid = new String [8] [8];
	    String[] [] enemyGrid = new String [8] [8]; // 2D arrays for the player's and the enemy's grid
	    for (int o = 0 ; o < 8 ; o++)
	    {

		for (int t = 0 ; t < 8 ; t++)
		{
		    playerGrid [o] [t] = "blank";
		    enemyGrid [o] [t] = "blank";
		}
	    }
	    String direction = "";
	    int number1, number2, letterNum1, letterNum2, yVal, xVal, startNum, startLetter;
	    String coordinate1 = "", coordinate2 = "", letter1 = "", letter2 = "";
	    number1 = 0;
	    number2 = 0;
	    letterNum1 = 0;
	    letterNum2 = 0;

	    for (int i = 0 ; i < 4 ; i++) // This for loop is made for the user to select where to place their ships
	    {
		shipSize = shipSizes [i];

		while (true)
		{
		    while (true)
		    {
			while (true)
			{
			    printGame (letters, numbers, playerGrid, enemyGrid); // This function displays everything for the user during the game
			    yVal = 100;
			    xVal = 400;
			    for (int a = 0 ; a < 4 ; a++)
			    {
				for (int b = 0 ; b < shipSizes [a] ; b++) // This shows the 4 ships and their sizes to the user
				{
				    c.setColor (Color.gray);
				    c.fillRect (xVal, yVal, 32, 30);
				    c.setColor (Color.black);
				    xVal += 32;
				}
				yVal += 100;
				xVal = 400;
			    }
			    c.println ("Now choose where to place your ships");
			    String[] ships = {"two", "three", "four", "five"};

			    c.println ("Select the coordinates for your ship with " + ships [shipSize - 2] + " square(s)");
			    c.println ("Enter a starting coordinate: "); //The user selects the coordinates to place their ships at, and this is for the starting coordinate
			    coordinate1 = c.readString ();
			    letter1 = coordinate1.substring (0, 1);
			    letterNum1 = getLetterNum (letter1);
			    try // Each coordinate will consist of a letter and a number, and this is meant to convert the number part into an int
			    {
				number1 = Integer.parseInt (coordinate1.substring (1, 2));
				number1 = number1 - 1;
			    }

			    catch (NumberFormatException e)
			    {

			    }

			    if (coordinate1.length () == 2 && number1 >= 0 && number1 <= 7 && (((int) coordinate1.charAt (0) >= 65 && (int) coordinate1.charAt (0) <= 72) || ((int) coordinate1.charAt (0) >= 97 && (int) coordinate1.charAt (0) <= 104)) && playerGrid [letterNum1] [number1].equals ("blank")) // This is an error trap to make sure the user enters a valid coordinate
			    {
				break;
			    }
			    else
			    {
				c.clear ();
			    }
			}

			c.println ("Enter an ending coordinate: "); // This is asking for the ending coordinate of each ship
			coordinate2 = c.readString (); // The same thing is done here to make sure the user enters a valid coordinate
			letter2 = coordinate2.substring (0, 1);
			letterNum2 = getLetterNum (letter2);
			try
			{
			    number2 = Integer.parseInt (coordinate2.substring (1, 2));
			    number2 = number2 - 1;
			}

			catch (NumberFormatException e)
			{

			}

			if (coordinate2.length () == 2 && number2 >= 0 && number2 <= 7 && (((int) coordinate2.charAt (0) >= 65 && (int) coordinate1.charAt (0) <= 72) || ((int) coordinate1.charAt (0) >= 97 && (int) coordinate1.charAt (0) <= 104)) && playerGrid [letterNum2] [number2].equals ("blank"))
			{
			    String crossed = checkCross (playerGrid, letterNum1, letterNum2, number1, number2);
			    if (crossed.equals ("no"))
			    {
				break;
			    }
			    else
			    {
				c.clear ();
			    }
			}
			else
			{
			    c.clear ();
			}
		    }
		    if ((number1 > number2 && number1 - number2 == (shipSize - 1) && letterNum1 == letterNum2) || (number2 > number1 && number2 - number1 == (shipSize - 1) && letterNum1 == letterNum2)) // These two if statements are used to determine whether the ship is positioned in a horizontal or vertical direction
		    {
			direction = "vertical";
			break;
		    }
		    else if ((letterNum1 > letterNum2 && letterNum1 - letterNum2 == (shipSize - 1) && number1 == number2) || (letterNum2 > letterNum1 && letterNum2 - letterNum1 == (shipSize - 1) && number1 == number2))
		    {
			direction = "horizontal";
			break;
		    }
		    else
		    {
			c.clear ();
		    }
		}

		startLetter = letterNum1;
		startNum = number1;
		if (direction.equals ("vertical"))
		{
		    if (number2 > number1)
		    {
			for (int a = 0 ; a < (number2 - number1 + 1) ; a++) // Depending on the coordinates the user chooses, certain coordinates in the 2D array will be used for ships
			{
			    playerGrid [startLetter] [startNum] = "ship";
			    startNum++;
			}
		    }
		    else if (number2 < number1)
		    {
			for (int a = 0 ; a < (number1 - number2 + 1) ; a++)
			{
			    playerGrid [startLetter] [startNum] = "ship";
			    startNum--;
			}
		    }
		}

		else if (direction.equals ("horizontal"))
		{
		    if (letterNum2 > letterNum1)
		    {
			for (int a = 0 ; a < (letterNum2 - letterNum1 + 1) ; a++)
			{
			    playerGrid [startLetter] [startNum] = "ship";
			    startLetter++;
			}
		    }
		    else if (letterNum2 < letterNum1)
		    {
			for (int a = 0 ; a < (letterNum1 - letterNum2 + 1) ; a++)
			{
			    playerGrid [startLetter] [startNum] = "ship";
			    startLetter--;
			}
		    }
		}

		if (i < 3)
		{
		    c.clear ();
		}

		else if (i == 3)
		{
		    printGame (letters, numbers, playerGrid, enemyGrid);
		}

	    }

	    String[] directions = {};
	    String direction2 = "";
	    int randomLetterNum, randomNum, randomDirection, randomLetterNum2 = -1, randomNum2 = -1;

	    for (int i = 0 ; i < 4 ; i++) // This for loop is designed for the computer to determine where to place its ships
	    {
		while (true)
		{
		    shipSize = shipSizes [i];
		    randomLetterNum = (int) (Math.random () * 8) + 1;
		    randomNum = (int) (Math.random () * 8) + 1; // A random coordinate for the ship is selected as a starting point
		    randomLetterNum--;
		    randomNum--;
		    String[] shipDirection = new String [4];
		    int c = 0;
		    int shipDirectionInt = 0;

		    if (randomLetterNum >= (shipSize - 1)) // Depending on where the coordinate is exactly, a direction for the end coordinate is determined
		    {
			shipDirection [c] = "left";
			c++;
		    }

		    else if ((7 - randomNum) >= (shipSize - 1))
		    {
			shipDirection [c] = "down";
			c++;
		    }

		    else if ((7 - randomLetterNum) >= (shipSize - 1))
		    {
			shipDirection [c] = "right";
			c++;
		    }

		    else if (randomNum >= (shipSize - 1))
		    {
			shipDirection [c] = "up";
			c++;
		    }
		    shipDirectionInt = (int) (Math.random () * c) + 1;
		    shipDirectionInt--;
		    direction2 = shipDirection [shipDirectionInt];


		    if (direction2.equals ("left")) // Depending on the direction, certain coordinates of the enemy's are used for ships
		    {
			randomNum2 = randomNum;
			randomLetterNum2 = randomLetterNum - (shipSize - 1);
			for (int a = 0 ; a < shipSize ; a++)
			{
			    enemyGrid [randomLetterNum] [randomNum] = "ship";
			    randomLetterNum--;
			}
		    }
		    else if (direction2.equals ("up"))
		    {
			randomLetterNum2 = randomLetterNum;
			randomNum2 = randomNum + (shipSize - 1);
			for (int a = 0 ; a < shipSize ; a++)
			{
			    enemyGrid [randomLetterNum] [randomNum] = "ship";
			    randomNum--;
			}
		    }
		    else if (direction2.equals ("right"))
		    {
			randomNum2 = randomNum;
			randomLetterNum2 = randomLetterNum + (shipSize - 1);
			for (int a = 0 ; a < shipSize ; a++)
			{
			    enemyGrid [randomLetterNum] [randomNum] = "ship";
			    randomLetterNum++;
			}
		    }

		    else if (direction2.equals ("down"))
		    {
			randomLetterNum2 = randomLetterNum;
			randomNum2 = randomNum - (shipSize - 1);
			for (int a = 0 ; a < shipSize ; a++)
			{
			    enemyGrid [randomLetterNum] [randomNum] = "ship";
			    randomNum++;
			}
		    }
		    String cross = checkCross (enemyGrid, randomLetterNum, randomLetterNum2, randomNum, randomNum2); // This function is used to make sure ships don't cross one another when being plotted
		    if (cross.equals ("no"))
		    {
			break;
		    }
		}
	    }

	    c.clear ();

	    String coordinateAttack, letter, cleverSelection = "no";
	    int letterNum = -1, number = -1;
	    int turnInt = -1;
	    int playerHits = 0, enemyHits = 0;
	    randomLetterNum = 0;
	    randomNum = 0;

	    if (turn.equals ("player"))
	    {
		turnInt = 0;
	    }
	    else if (turn.equals ("enemy"))
	    {
		turnInt = 1;
	    }

	    while (true) // This loop is used to alternate between the player's and the enemy's turn
	    {
		if (turnInt == 0)
		{
		    turn = "player";
		}
		else if (turnInt == 1)
		{
		    turn = "enemy";
		}

		if (turn.equals ("player"))
		{
		    if (playerHits == 14 || enemyHits == 14) // If all of the player's or the enemy's ships have sunken
		    {
			break;
		    }
		    while (true)
		    {
			c.clear ();
			printGame (letters, numbers, playerGrid, enemyGrid);

			c.println ("White spots are a miss, red spots are a hit");
			c.println ("Select a coordinate to attack your opponent: "); // Asks the player to select a coordinate to attack their opponent
			coordinateAttack = c.readString ();
			letter = coordinateAttack.substring (0, 1);
			letterNum = getLetterNum (letter);
			try
			{
			    number = Integer.parseInt (coordinateAttack.substring (1, 2));
			    number = number - 1;
			}

			catch (NumberFormatException e)
			{

			}

			if (coordinateAttack.length () == 2 && number >= 0 && number <= 7 && (((int) coordinateAttack.charAt (0) >= 65 && (int) coordinateAttack.charAt (0) <= 72) || ((int) coordinateAttack.charAt (0) >= 97 && (int) coordinateAttack.charAt (0) <= 104))) // Once again, the program checks to see if the coordinate is valid
			{
			    break;
			}
			else
			{
			    c.clear ();
			}
		    }
		    if (enemyGrid [letterNum] [number].equals ("ship")) // If the players hits a ship
		    {
			enemyGrid [letterNum] [number] = "hit"; // This causes this coordinate to change to a different color
			playerHits++;
		    }
		    else if (enemyGrid [letterNum] [number].equals ("blank")) // If the player misses a ship
		    {
			enemyGrid [letterNum] [number] = "miss"; // This causes this coordinate to change to a different color
		    }
		    turnInt = 1;
		}

		else if (turn.equals ("enemy"))
		{
		    c.clear ();
		    printGame (letters, numbers, playerGrid, enemyGrid);
		    int d = 0;
		    int randomDirectionInt;
		    String enemyRandomDirection;

		    if (cleverSelection.equals ("yes")) // Only after a hit has been made by the computer
		    {
			d = 0;
			while (true)
			{
			    d = 0;
			    String[] enemyDirections = new String [4];

			    if (randomLetterNum > 0)  // Depending on where the selected last coordinate was, which is a hit, the computer will make a clever decision to attack a coordinate right beside it, because there is where another hit will be made
			    {
				enemyDirections [d] = "left";
				d++;
			    }
			    if (randomLetterNum < 7)
			    {
				enemyDirections [d] = "right";
				d++;
			    }
			    if (randomNum < 7)
			    {
				enemyDirections [d] = "down";
				d++;
			    }
			    if (randomNum > 0)
			    {
				enemyDirections [d] = "up";
				d++;
			    }

			    randomDirectionInt = (int) (Math.random () * d) + 1;
			    randomDirectionInt--;
			    enemyRandomDirection = enemyDirections [randomDirectionInt];

			    if (enemyRandomDirection.equals ("left")) // Depending on the direction randomly chosen, the computer will select the appropriate coordinate
			    {
				randomLetterNum--;
			    }
			    else if (enemyRandomDirection.equals ("right"))
			    {
				randomLetterNum++;
			    }
			    else if (enemyRandomDirection.equals ("up"))
			    {
				randomNum--;
			    }
			    else if (enemyRandomDirection.equals ("down"))
			    {
				randomNum++;
			    }

			    if (playerGrid [randomLetterNum] [randomNum].equals ("ship") || playerGrid [randomLetterNum] [randomNum].equals ("blank"))
			    {
				break;
			    }

			}

		    }
		    else if (cleverSelection.equals ("no")) // If the computer has not made a hit
		    {
			while (true)
			{
			    randomLetterNum = (int) (Math.random () * 8) + 1;
			    randomNum = (int) (Math.random () * 8) + 1; // A random coordinate is simply chosen
			    randomLetterNum--;
			    randomNum--;
			    if (playerGrid [randomLetterNum] [randomNum].equals ("ship") || playerGrid [randomLetterNum] [randomNum].equals ("blank"))
			    {
				break;
			    }
			}
		    }
		    if (playerGrid [randomLetterNum] [randomNum].equals ("ship")) // Same with the player, a hit or miss will change the color of the coordinate on the grid later
		    {
			playerGrid [randomLetterNum] [randomNum] = "hit";
			enemyHits++;
			cleverSelection = "yes";
		    }


		    else if (playerGrid [randomLetterNum] [randomNum].equals ("blank"))
		    {
			playerGrid [randomLetterNum] [randomNum] = "miss";
			cleverSelection = "no";
		    }

		    c.println ("White spots are a miss, red spots are a hit");
		    c.println ("Your enemy is attacking...");
		    try
		    {
			Thread.sleep (2000);
		    }


		    catch (InterruptedException ie)
		    {
			c.println ("Timer not working");
		    }


		    turnInt = 0;
		}
	    }

	    c.clear ();

	    String playAgain = "";

	    while (true) // Once the game is over, the appropriate text will be printed onto the screen
	    {
		printGame (letters, numbers, playerGrid, enemyGrid);
		if (playerHits == 14)
		{
		    c.println ("VICTORY!");
		    c.println ("You have sunk all of your enemy's ships");
		}


		else if (enemyHits == 14)
		{
		    c.println ("DEFEAT");
		    c.println ("Your enemy has sunk all of your ships");
		}


		c.println ();
		c.print ("Would you like to play again('y' for yes, 'n' for no)");
		playAgain = c.readString ();

		if (playAgain.equalsIgnoreCase ("n")) // This is an error trap to make sure the user enters appropriately
		{
		    break;
		}


		else if (playAgain.equalsIgnoreCase ("y"))
		{
		    break;
		}
	    }

	    if (playAgain.equalsIgnoreCase ("n"))
	    {
		break;
	    }
	}

	c.clear ();
	c.println ();
	c.println ("Thanks for playing!");

    }



    public static void drawPlayerGrid (String[] letters, String[] numbers, String[] [] playerGrid)  // This function draws the player's own grid
    {
	int currentX = 70;
	int currentY = 125;
	int yVal = 0;
	c.println ();
	c.println ("                   YOUR GRID");
	c.println ();
	c.print ("          ");
	for (int i = 0 ; i < 8 ; i++)
	{
	    c.print (letters [i] + "   ");
	}


	c.println ();
	c.println ();
	c.println ();
	for (int i = 0 ; i < 8 ; i++)
	{
	    c.print ("    " + numbers [i]);
	    for (int a = 0 ; a < 8 ; a++)
	    {
		c.print ("     ");
	    }
	    c.println ();
	    c.println ();
	    yVal++;
	}


	c.println ();
	for (int a = 0 ; a < 8 ; a++)
	{
	    for (int i = 0 ; i < 8 ; i++)
	    {
		if (playerGrid [a] [i].equals ("blank")) // Each coordinate's color is different depending on what is on the coordinate
		{
		    c.drawRect (currentX, currentY, 32, 30);
		    currentY += 30;
		}
		else if (playerGrid [a] [i].equals ("ship"))
		{
		    c.setColor (Color.gray);
		    c.fillRect (currentX, currentY, 32, 30);
		    currentY += 30;
		    c.setColor (Color.black);
		}
		else if (playerGrid [a] [i].equals ("hit"))
		{
		    c.setColor (Color.red);
		    c.fillRect (currentX, currentY, 32, 30);
		    currentY += 30;
		    c.setColor (Color.black);
		}
		else if (playerGrid [a] [i].equals ("miss"))
		{
		    c.setColor (Color.white);
		    c.fillRect (currentX, currentY, 32, 30);
		    currentY += 30;
		    c.setColor (Color.black);
		}
	    }
	    currentX += 32;
	    currentY = 125;
	}
    }


    public static void drawEnemyGrid (String[] letters, String[] numbers, String[] [] enemyGrid)  // Similar to the previous function, the enemy's own grid is drawn
    {
	int currentX = 70;
	int currentY = 470;
	int yVal = 0;
	c.println ();
	c.println ("                   ENEMY GRID");
	c.println ();
	c.print ("          ");
	for (int i = 0 ; i < 8 ; i++)
	{
	    c.print (letters [i] + "   ");
	}

	c.println ();
	c.println ();
	c.println ();
	for (int i = 0 ; i < 8 ; i++)
	{
	    c.print ("    " + numbers [i]);
	    for (int a = 0 ; a < 8 ; a++)
	    {
		c.print ("     ");
	    }
	    c.println ();
	    c.println ();
	    yVal++;
	}


	c.println ();
	for (int a = 0 ; a < 8 ; a++)
	{
	    for (int i = 0 ; i < 8 ; i++)
	    {
		if (enemyGrid [a] [i].equals ("blank") || enemyGrid [a] [i].equals ("ship")) // Again, depending on what is on each coordinate, the color changes, but this time, the ships are not shown
		{
		    c.drawRect (currentX, currentY, 32, 30);
		    currentY += 30;
		}
		else if (enemyGrid [a] [i].equals ("hit"))
		{
		    c.setColor (Color.red);
		    c.fillRect (currentX, currentY, 32, 30);
		    currentY += 30;
		    c.setColor (Color.black);
		}
		else if (enemyGrid [a] [i].equals ("miss"))
		{
		    c.setColor (Color.white);
		    c.fillRect (currentX, currentY, 32, 30);
		    currentY += 30;
		    c.setColor (Color.black);
		}
	    }
	    currentX += 32;
	    currentY = 470;
	}
    }


    public static int getLetterNum (String letter)  // After the user enters a coordinate each time, the first part of the coordinate, the letter, is converted to a number which the 2D array or grid can understand
    {
	int letterNum = -1;
	if (letter.equalsIgnoreCase ("a"))
	{
	    letterNum = 0;
	}


	else if (letter.equalsIgnoreCase ("b"))
	{
	    letterNum = 1;
	}


	else if (letter.equalsIgnoreCase ("c"))
	{
	    letterNum = 2;
	}


	else if (letter.equalsIgnoreCase ("d"))
	{
	    letterNum = 3;
	}


	else if (letter.equalsIgnoreCase ("e"))
	{
	    letterNum = 4;
	}


	else if (letter.equalsIgnoreCase ("f"))
	{
	    letterNum = 5;
	}


	else if (letter.equalsIgnoreCase ("g"))
	{
	    letterNum = 6;
	}


	else if (letter.equalsIgnoreCase ("h"))
	{
	    letterNum = 7;
	}


	return letterNum;
    }


    public static String checkCross (String[] [] grid, int letterNum1, int letterNum2, int number1, int number2)  // After the user and computer select starting and ending coordinates for their ships, this function makes sure that ships don't cross one another
    {
	String crossed = "no";

	if (letterNum1 == letterNum2)
	{
	    if (number2 > number1)
	    {
		for (int i = number1 ; i < number2 ; i++)
		{
		    if (grid [letterNum1] [i].equals ("ship")) // The span of the ship is searched to see if there is a cross
		    {
			crossed = "yes";
		    }
		}
	    }

	    else if (number2 < number1)
	    {
		for (int i = number2 ; i < number2 ; i++)
		{
		    if (grid [letterNum1] [i].equals ("ship"))
		    {
			crossed = "yes";
		    }
		}
	    }
	}


	else if (number1 == number2)
	{
	    if (letterNum2 > letterNum1)
	    {
		for (int i = letterNum1 ; i < letterNum2 ; i++)
		{
		    if (grid [i] [number1].equals ("ship"))
		    {
			crossed = "yes";
		    }
		}
	    }

	    else if (letterNum2 < letterNum1)
	    {
		for (int i = letterNum2 ; i > letterNum1 ; i++)
		{
		    if (grid [i] [number1].equals ("ship"))
		    {
			crossed = "yes";
		    }
		}
	    }
	}

	return crossed;
    }


    public static void printGame (String[] letters, String[] numbers, String[] [] playerGrid, String[] [] enemyGrid)  // This function simply prints everything for the game onto the screen, including the title, the player's grid, and the enemy's grid
    {
	c.println ();
	c.println ("                   BATTLESHIP");
	c.println ();
	drawPlayerGrid (letters, numbers, playerGrid);
	drawEnemyGrid (letters, numbers, enemyGrid);
    }
}





