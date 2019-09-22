import java.awt.*;
import hsa.Console;

public class escape
{
    static Console c;

    public static void main (String[] args)
    {
	c = new Console (50, 110);

	int x1, y1, x2, y2, addy1, addx1, addy2, addx2, games, randomstart, highscore, bounces;
	String direction, movement, notify2, notify3, ignorex, ignorey, newgame;
	char movement1, movement2, start, playagain;

	direction = ("neutral");
	ignorex = ("no");
	ignorey = ("no");
	newgame = ("no");
	notify2 = ("no");
	notify3 = ("no");
	bounces = 0;
	games = 0;
	highscore = 0;

	while (true)
	{
	    c.setTextBackgroundColor (Color.cyan);
	    c.clear ();
	    c.println ("Welcome to the newly invented game of bounce");
	    c.println ("- In this game, you are a blue ball on a hoverboard trying to get as many bounces as you can with the red ball on a hoverboard");
	    c.println ("- The red ball will continue bouncing around, but whenever you hit a wall, the game will pause, and you can choose which direction you bounce back towards");
	    c.println ("- Use the 'w', 'a', 's', 'd' keys to choose your direction. You can input one letter to only choose one direction, or you can choose two different directions to move diagonally");
	    c.println ("- Your score will be based on how many bounces you can get");
	    c.println ("- Enter '-1' whenever you would like to start a new game");
	    c.println ();

	    c.println ("Enter any key to begin");
	    start = c.getChar ();
	    c.clear ();

	    x1 = 500;
	    x2 = 150;
	    y1 = 200;
	    y2 = 500;

	    addx1 = 5;
	    addx2 = 5;
	    addy1 = -5;
	    addy2 = 5;

	    while (true)
	    {
		while (true)
		{
		    c.println ("Bounces: " + bounces);
		    c.println ("Use the 'w', 'a', 's', 'd' keys");

		    if (games == 0)
		    {
			highscore = bounces;
		    }

		    else
		    {
			if (bounces > highscore)
			{
			    c.println ("New High Score!");
			    highscore = bounces;
			}

			else
			{
			    highscore = highscore;
			}
		    }

		    c.println ("High Score: " + highscore);

		    c.setColor (Color.white);
		    c.fillRect (100, 100, 700, 500);

		    c.setColor (Color.blue);
		    c.fillOval (x1 + 2, y1, 20, 20);
		    c.setColor (Color.gray);
		    c.fillRect (x1, y1 + 20, 25, 5);
		    c.setColor (Color.white);
		    c.fillOval (x1 + 8, y1 + 4, 2, 2);
		    c.fillOval (x1 + 14, y1 + 4, 2, 2);

		    c.setColor (Color.red);
		    c.fillOval (x2 + 2, y2, 20, 20);
		    c.setColor (Color.gray);
		    c.fillRect (x2, y2 + 20, 25, 5);
		    c.setColor (Color.black);
		    c.fillOval (x2 + 8, y2 + 4, 2, 2);
		    c.fillOval (x2 + 14, y2 + 4, 2, 2);

		    try
		    {
			Thread.sleep (20);
		    }
		    catch (InterruptedException ex)
		    {
			Thread.currentThread ().interrupt ();
		    }

		    c.clear ();

		    if (x1 == 100 || x1 == 775 || y1 == 100 || y1 == 575)
		    {
			if (ignorey.equals ("yes") && direction.equals ("left"))
			{
			    if (x1 == 100)
			    {
				ignorey = ("no");
				direction = ("neutral");
				break;
			    }

			    else
			    {
				addx1 = -5;
				addy1 = 0;
			    }
			}

			else if (ignorey.equals ("yes") && direction.equals ("right"))
			{
			    if (x1 == 775)
			    {
				ignorey = ("no");
				direction = ("neutral");
				break;
			    }

			    else
			    {
				addx1 = 5;
				addy1 = 0;
			    }
			}

			else if (ignorex.equals ("yes") && direction.equals ("down"))
			{
			    if (y1 == 575)
			    {
				ignorex = ("no");
				direction = ("neutral");
				break;
			    }

			    else
			    {
				addy1 = 5;
				addx1 = 0;
			    }
			}
			else if (ignorex.equals ("yes") && direction.equals ("up"))
			{
			    if (y1 == 100)
			    {
				ignorex = ("no");
				direction = ("neutral");
				break;
			    }

			    else
			    {
				addy1 = -5;
				addx1 = 0;
			    }
			}

			else
			{
			    break;
			}
		    }

		    if (x2 == 100)
		    {
			addx2 = 5;
		    }

		    else if (x2 == 775)
		    {
			addx2 = -5;
		    }

		    else if (y2 == 100)
		    {
			addy2 = 5;
		    }

		    else if (y2 == 575)
		    {
			addy2 = -5;
		    }

		    if (x2 == 100 && y2 == 100)
		    {
			addx2 = 5;
			addy2 = 5;
		    }

		    else if (x2 == 100 && y2 == 575)
		    {
			addx2 = 5;
			addy2 = -5;
		    }

		    else if (x2 == 775 && y2 == 575)
		    {
			addx2 = -5;
			addy2 = -5;
		    }

		    else if (x2 == 775 && y2 == 100)
		    {
			addx2 = -5;
			addy2 = -5;
		    }

		    if (x1 <= x2 + 25 && x1 >= x2 + 20 && y2 >= y1 - 25 && y2 <= y1 + 25)
		    {
			if (x1 == 775)
			{
			    addx1 = 0;
			    addx2 = -5;
			}

			else if (x2 == 775)
			{
			    addx1 = 5;
			    addx2 = 0;
			}

			else
			{
			    addx1 = 5;
			    addx2 = -5;
			}
			bounces++;
		    }

		    else if (x1 >= x2 - 25 && x1 <= x2 - 20 && y2 >= y1 - 25 && y2 <= y1 + 25)
		    {
			if (x1 == 100)
			{
			    addx1 = 0;
			    addx2 = 5;
			}

			else if (x2 == 100)
			{
			    addx1 = 5;
			    addx2 = 0;
			}

			else
			{
			    addx1 = -5;
			    addx2 = 5;
			}
			bounces++;
		    }

		    else if (y1 <= y2 + 25 && y1 >= y2 + 20 && x2 <= x1 + 25 && x2 >= x1 - 25)
		    {
			if (y1 == 575)
			{
			    addy1 = 0;
			    addy2 = -5;
			}

			else if (y2 == 575)
			{
			    addy1 = -5;
			    addy2 = 0;
			}
			else
			{
			    addy1 = 5;
			    addy2 = -5;
			}
			bounces++;
		    }

		    else if (y1 >= y2 - 25 && y1 <= y2 - 20 && x2 <= x1 + 25 && x2 >= x1 - 25)
		    {
			if (y1 == 100)
			{
			    addy1 = 0;
			    addy2 = 5;
			}

			else if (y2 == 100)
			{
			    addy1 = 5;
			    addy2 = 0;
			}

			else
			{
			    addy1 = -5;
			    addy2 = 5;
			}

			bounces++;
		    }

		    if (x1 + 25 == x2 && y1 + 25 == y2)
		    {
			addx1 = -5;
			addx2 = 5;
			addy1 = -5;
			addy2 = 5;
		    }

		    else if (x1 + 25 == x2 && y1 - 25 == y2)
		    {
			addx1 = -5;
			addx2 = 5;
			addy1 = 5;
			addy2 = -5;
		    }

		    else if (x1 - 25 == x2 && y1 - 25 == y2)
		    {
			addx1 = 5;
			addx2 = -5;
			addy1 = 5;
			addy2 = -5;
		    }

		    else if (x1 - 25 == x2 && y1 + 25 == y2)
		    {
			addx1 = 5;
			addx2 = -5;
			addy1 = -5;
			addy2 = 5;
		    }

		    x1 = x1 + addx1;
		    y1 = y1 + addy1;

		    x2 = x2 + addx2;
		    y2 = y2 + addy2;
		}

		while (true)
		{
		    if (notify3.equals ("yes"))
		    {
			addx1 = 0;
			addy1 = 0;
			c.println ("This is not valid input");
			notify3 = ("no");
		    }

		    c.setColor (Color.white);
		    c.fillRect (100, 100, 700, 500);
		    c.setColor (Color.blue);
		    c.fillOval (x1 + 2, y1, 20, 20);
		    c.setColor (Color.gray);
		    c.fillRect (x1, y1 + 20, 25, 5);
		    c.setColor (Color.white);
		    c.fillOval (x1 + 8, y1 + 4, 2, 2);
		    c.fillOval (x1 + 14, y1 + 4, 2, 2);

		    c.setColor (Color.red);
		    c.fillOval (x2 + 2, y2, 20, 20);
		    c.setColor (Color.gray);
		    c.fillRect (x2, y2 + 20, 25, 5);
		    c.setColor (Color.black);
		    c.fillOval (x2 + 8, y2 + 4, 2, 2);
		    c.fillOval (x2 + 14, y2 + 4, 2, 2);

		    c.println ("Bounces: " + bounces);
		    c.println ("Use the 'w', 'a', 's', 'd' keys");

		    if (games == 0)
		    {
			highscore = bounces;
		    }

		    else
		    {
			if (bounces > highscore)
			{
			    c.println ("New High Score!");
			    highscore = bounces;
			}

			else
			{
			    highscore = highscore;
			}
		    }

		    c.println ("High Score: " + highscore);

		    movement = c.readString ();
		    movement = movement.toLowerCase ();

		    movement1 = movement.charAt (0);

		    if (movement.equals ("-1"))
		    {
			if (games != 0)
			{
			    if (bounces > highscore)
			    {
				c.print ("     New High Score!");
				highscore = bounces;
			    }
			    else
			    {
				highscore = highscore;
			    }
			}
			newgame = ("yes");
			break;
		    }

		    if (movement.length () == 1)
		    {
			if ((int) movement1 == 119)
			{
			    if (x1 == 100 && y1 != 100 || x1 == 775 && y1 != 100)
			    {
				ignorex = ("yes");
				direction = ("up");
				addy1 = -5;
				addx1 = 0;
				break;
			    }

			    if (y1 == 100 || y1 == 100 && x1 == 100 || y1 == 100 && x1 == 775)
			    {
				notify3 = ("yes");
			    }

			    else
			    {
				addy1 = -5;
				addx1 = 0;
				break;
			    }
			}

			else if ((int) movement1 == 97)
			{
			    if (y1 == 100 && x1 != 100 || y1 == 575 && x1 != 100)
			    {
				ignorey = ("yes");
				direction = ("left");
				addy1 = 0;
				addx1 = -5;
				break;
			    }

			    if (x1 == 100 || x1 == 100 && y1 == 100 || x1 == 100 && y1 == 575)
			    {
				notify3 = ("yes");
			    }

			    else
			    {
				addx1 = -5;
				addy1 = 0;
				break;
			    }
			}

			else if ((int) movement1 == 115)
			{
			    if (x1 == 100 && y1 != 575 || x1 == 775 && y1 != 575)
			    {
				ignorex = ("yes");
				direction = ("down");
				addx1 = 0;
				addy1 = 5;
				break;
			    }

			    if (y1 == 575 || y1 == 575 && x1 == 100 || y1 == 575 && x1 == 775)
			    {
				notify3 = ("yes");
			    }

			    else
			    {
				addx1 = 0;
				addy1 = 5;
				break;
			    }
			}

			else if ((int) movement1 == 100)
			{
			    if (y1 == 100 && x1 != 775 || y1 == 575 && x1 != 775)
			    {
				ignorey = ("yes");
				direction = ("right");
				addy1 = 0;
				addx1 = 5;
				break;
			    }

			    if (x1 == 775 || x1 == 775 && y1 == 100 || x1 == 775 && y1 == 575)
			    {
				notify3 = ("yes");
			    }

			    else
			    {
				addx1 = 5;
				addy1 = 0;
				break;
			    }
			}

			else
			{
			    notify3 = ("yes");
			}
		    }

		    else if (movement.length () == 2)
		    {
			movement2 = movement.charAt (1);

			if ((int) movement1 == 119)
			{
			    addy1 = -5;
			}

			else if ((int) movement1 == 97)
			{
			    addx1 = -5;
			}

			else if ((int) movement1 == 115)
			{
			    addy1 = 5;
			}

			else if ((int) movement1 == 100)
			{
			    addx1 = 5;
			}

			else
			{
			    notify3 = ("yes");
			}

			if ((int) movement2 == 119)
			{
			    addy1 = -5;
			}

			else if ((int) movement2 == 97)
			{
			    addx1 = -5;
			}

			else if ((int) movement2 == 115)
			{
			    addy1 = 5;
			}

			else if ((int) movement2 == 100)
			{
			    addx1 = 5;
			}

			else
			{
			    notify3 = ("yes");
			}

			if ((int) movement1 + (int) movement2 == 197 || (int) movement1 + (int) movement2 == 234)
			{
			    notify3 = ("yes");
			}

			if ((int) movement1 == (int) movement2 || x1 == 100 && (int) movement1 + (int) movement2 == 216 || x1 == 100 && (int) movement1 + (int) movement2 == 212 || x1 == 775 && (int) movement1 + (int) movement2 == 215 || x1 == 775 && (int) movement1 + (int) movement2 == 219 || y1 == 100 && (int) movement1 + (int) movement2 == 219 || y1 == 100 && (int) movement1 + (int) movement2 == 216 || y1 == 575 && (int) movement1 + (int) movement2 == 215 || y1 == 575 && (int) movement1 + (int) movement2 == 212)
			{
			    notify3 = ("yes");
			}

			else
			{
			    break;
			}
		    }

		    else
		    {
			notify3 = ("yes");
		    }
		    c.clear ();
		}

		if (newgame.equals ("yes"))
		{
		    c.clear ();
		    games++;
		    addx1 = 0;
		    addy1 = 0;
		    bounces = 0;
		    newgame = ("no");
		    break;
		}

		if (x2 == 100)
		{
		    addx2 = 5;
		}

		else if (x2 == 775)
		{
		    addx2 = -5;
		}

		else if (y2 == 100)
		{
		    addy2 = 5;
		}

		else if (y2 == 575)
		{
		    addy2 = -5;
		}
		x1 = x1 + addx1;
		y1 = y1 + addy1;

		x2 = x2 + addx2;
		y2 = y2 + addy2;
	    }
	}
    }
}



