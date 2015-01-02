import hsa.*;
import java.awt.*;


public class Blackjack
{
    static Console c;
    static Console d;
    public static void main (String[] args)
    {
	d = new Console ();
	c = new Console ();
	String choice1 = "";
	int money = 0;
	c.println ("--------------------------------------------------------------------------------");
	c.println ("Do you want to play Black Jack?? Y or N");
	c.println ("--------------------------------------------------------------------------------");
	choice1 = c.readLine ();
	String option = "";
	if (choice1.equalsIgnoreCase ("y"))
	{
	    c.println ("How much money do you want to play with? The game ends when you have $0.");
	    money = c.readInt ();
	    while (!option.equalsIgnoreCase ("n"))
	    {
		if (money != 0)
		{
		    money = Game (money);
		    c.println ("Do you want to continue playing? Y or N");
		    option = c.readLine ();
		    d.clear ();
		}
		else if (money == 0)
		{
		    break;
		}
	    }
	}
	c.clear ();
	d.clear ();
	c.println ("The game has ended.");
	c.println ("Your balance is " + "$" + money);
	d.println ("The game has ended.");
	d.println ("Your balance is " + "$" + money);
    }


    public static int Game (int money)
    {
	CardDeck deck = new CardDeck ();
	c.clear ();
	deck.Shuffle ();
	//deck.printDeck(c);
	c.clear ();
	int sum = 0;
	int dsum = 0;
	int cardno = 4;
	int choose1 = (int) (Math.random () * 40) + 1;
	int betmoney;
	c.println ("Money balance: " + money);
	while (true)
	{
	    c.print ("Enter betting amount: ");
	    betmoney = c.readInt ();
	    if (money >= betmoney && betmoney > 0)
	    {
		break;
	    }
	    else
	    {
		c.println ("Amount entered is invalid");
	    }
	}
	c.clear ();

	CardType card1 = deck.cards [choose1];
	String value1 = Integer.toString (card1.getValue ());
	deck.cards [choose1].value = 0;

	int choose2 = (int) (Math.random () * 40) + 1;
	while (deck.cards [choose2].getValue () == 0)
	{
	    choose2 = (int) (Math.random () * 40) + 1;
	}


	CardType card2 = deck.cards [choose2];
	String value2 = Integer.toString (card2.getValue ());
	deck.cards [choose2].value = 0;

	int choose3 = (int) (Math.random () * 40) + 1;
	while (deck.cards [choose3].getValue () == 0)
	{
	    choose3 = (int) (Math.random () * 40) + 1;
	}


	CardType card3 = deck.cards [choose3];
	String value3 = Integer.toString (card3.getValue ());
	deck.cards [choose3].value = 0;

	int choose4 = (int) (Math.random () * 40) + 1;
	while (deck.cards [choose4].getValue () == 0)
	{
	    choose4 = (int) (Math.random () * 40) + 1;
	}


	CardType card4 = deck.cards [choose4];
	String value4 = Integer.toString (card4.getValue ());
	deck.cards [choose4].value = 0;

	String choice = "";
	int count = 1;
	int prob3 = 0;


	String suit1 = card1.getSuit ();
	String suit2 = card2.getSuit ();
	String suit3 = card3.getSuit ();
	String suit4 = card4.getSuit ();
	/*if (Integer.parseInt(value1) == 1){
	    value = "A";
	}
	else if (Integer.parseInt(value1) == 11){
	    value = "J";
	    card.value = 10;
	}
	else if (Integer.parseInt(value1) == 12){
	    value = "Q";
	    card.value = 10;
	}
	else if(Integer.parseInt(value1) == 13) {
	    value = "K";
	    card.value = 10;
	}*/
	//c.println ("Your card is: " +value1);
	d.drawString ("Player: ", 5, 60); //heart
	d.drawString ("House: ", 5, 270);

	d.setColor (Color.black);
	d.fillRect (50, 50, 90, 200);

	//second card


	if (suit2.equals ("diamond") || suit2.equals ("heart"))
	{
	    d.setColor (Color.red);
	    d.drawRect (  /*100*count+*/150, 50, 90, 200);
	    if (suit2.equals ("diamond"))
	    {
		d.drawString ("\u2666",  /*100*count+*/153, 60);
		d.drawString (value2,  /*100*count+*/153, 70);
	    }
	    else
	    {
		d.drawString ("\u2665",  /*100*count+*/153, 60);
		d.drawString (value2,  /*100*count+*/153, 70);
	    }
	}


	else
	{
	    d.setColor (Color.black);
	    d.drawRect (  /*100*count+*/150, 50, 90, 200);
	    if (suit2.equals ("spade"))
	    {
		d.drawString ("\u2660",  /*100*count+*/153, 60);
		d.drawString (value2,  /*100*count+*/153, 70);
	    }
	    else
	    {
		d.drawString ("\u2663",  /*100*count+*/153, 60);
		d.drawString (value2,  /*100*count+*/153, 70);
	    }
	}


	d.setColor (Color.black);
	d.fillRect (50, 260, 90, 200);




	//third card
	if (suit4.equals ("diamond") || suit4.equals ("heart"))
	{
	    d.setColor (Color.red);
	    d.drawRect (  /*100*count+*/150, 260, 90, 200);
	    if (suit4.equals ("diamond"))
	    {
		d.drawString ("\u2666",  /*100*count+*/153, 270);
		d.drawString (value4,  /*100*count+*/153, 280);
	    }
	    else
	    {
		d.drawString ("\u2665",  /*100*count+*/153, 270);
		d.drawString (value4,  /*100*count+*/153, 280);
	    }
	}


	else
	{
	    d.setColor (Color.black);
	    d.drawRect (  /*100*count+*/150, 260, 90, 200);
	    if (suit4.equals ("spade"))
	    {
		d.drawString ("\u2660",  /*100*count+*/153, 270);
		d.drawString (value4,  /*100*count+*/153, 280);
	    }
	    else
	    {
		d.drawString ("\u2663",  /*100*count+*/153, 270);
		d.drawString (value4,  /*100*count+*/153, 280);
	    }
	}


	sum = Integer.parseInt (value1) + Integer.parseInt (value2);
	dsum = Integer.parseInt (value3) + Integer.parseInt (value4);
	probCalc1 (deck.cards, cardno, sum);
	probCalc2 (deck.cards, cardno, sum);
	probCalc3 (deck.cards, cardno, sum);
	c.println ("Your current sum is " + sum + ", your hidden card is " + value1 + " of " + suit1 + "s");


	int choose = (int) (Math.random () * 40) + 1;
	while (sum < 21 && !choice.equalsIgnoreCase ("N"))
	{
	    c.println ("Want another card? Y or N?");
	    choice = c.readString ();
	    count++;
	    if (choice.equalsIgnoreCase ("n"))
	    {
		break;
	    }
	    while (deck.cards [choose].getValue () == 0)
	    {
		choose = (int) (Math.random () * 40) + 1;
	    }
	    CardType card = deck.cards [choose];
	    String suit = card.getSuit ();
	    String value = Integer.toString (card.getValue ());
	    if (suit.equals ("diamond") || suit.equals ("heart"))
	    {
		d.setColor (Color.red);
		d.drawRect (100 * count + 50, 50, 90, 200);
		cardno++;
		if (suit.equals ("diamond"))
		{
		    d.drawString ("\u2666", 100 * count + 53, 60);
		    d.drawString (value, 100 * count + 53, 70);
		}
		else
		{
		    d.drawString ("\u2665", 100 * count + 53, 60);
		    d.drawString (value, 100 * count + 53, 70);
		}
	    }
	    else
	    {
		cardno++;
		d.setColor (Color.black);
		d.drawRect (100 * count + 50, 50, 90, 200);
		if (suit.equals ("spade"))
		{
		    d.drawString ("\u2660", 100 * count + 53, 60);
		    d.drawString (value, 100 * count + 53, 70);
		}
		else
		{
		    d.drawString ("\u2663", 100 * count + 53, 60);
		    d.drawString (value, 100 * count + 53, 70);
		}
	    }
	    sum = card.getValue () + sum;
	    deck.cards [choose].value = 0;
	    probCalc1 (deck.cards, cardno, sum);
	    probCalc2 (deck.cards, cardno, sum);
	    probCalc3 (deck.cards, cardno, sum);
	    c.println ("Your current sum is " + sum + ", your hidden card is " + value1 + " of " + suit1 + "s");

	    if (sum >= 21)
	    {
		break;
	    }

	}


	count = 1;
	int dchoose = (int) (Math.random () * 40) + 1;
	while (dsum < 21)
	{
	    count++;
	    if (dsum >= 17)
	    {
		break;
	    }
	    while (deck.cards [dchoose].getValue () == 0)
	    {
		dchoose = (int) (Math.random () * 40) + 1;
	    }
	    CardType dcard = deck.cards [dchoose];
	    String dsuit = dcard.getSuit ();
	    String dvalue = Integer.toString (dcard.getValue ());
	    if (dsuit.equals ("diamond") || dsuit.equals ("heart"))
	    {
		cardno++;
		d.setColor (Color.red);
		d.drawRect (100 * count + 50, 260, 90, 200);
		if (dsuit.equals ("diamond"))
		{
		    d.drawString ("\u2666", 100 * count + 53, 270);
		    d.drawString (dvalue, 100 * count + 53, 280);
		}
		else
		{
		    d.drawString ("\u2665", 100 * count + 53, 270);
		    d.drawString (dvalue, 100 * count + 53, 280);
		}
	    }
	    else
	    {
		cardno++;
		d.setColor (Color.black);
		d.drawRect (100 * count + 50, 260, 90, 200);
		if (dsuit.equals ("spade"))
		{
		    d.drawString ("\u2660", 100 * count + 53, 270);
		    d.drawString (dvalue, 100 * count + 53, 280);
		}
		else
		{
		    d.drawString ("\u2663", 100 * count + 53, 270);
		    d.drawString (dvalue, 100 * count + 53, 280);
		}
	    }
	    dsum = dcard.getValue () + dsum;
	    deck.cards [dchoose].value = 0;
	    if (dsum >= 17 || dsum >= 21)
	    {
		break;
	    }
	}
	d.setColor (Color.white);
	d.fillRect (50, 260, 90, 200);
	if (suit1.equals ("diamond") || suit1.equals ("heart"))
	{
	    d.setColor (Color.red);
	    d.drawRect (  /*100*count+*/50, 260, 90, 200);
	    if (suit3.equals ("diamond"))
	    {
		d.drawString ("\u2666",  /*100*count+*/53, 270);
		d.drawString (value3,  /*100*count+*/53, 280);
	    }
	    else
	    {
		d.drawString ("\u2665",  /*100*count+*/53, 270);
		d.drawString (value3,  /*100*count+*/53, 280);
	    }
	}

	else
	{
	    d.setColor (Color.black);
	    d.drawRect (  /*100*count+*/50, 260, 90, 200);
	    if (suit3.equals ("spade"))
	    {
		d.drawString ("\u2660",  /*100*count+*/53, 270);
		d.drawString (value3,  /*100*count+*/53, 280);
	    }
	    else
	    {
		d.drawString ("\u2663",  /*100*count+*/53, 270);
		d.drawString (value3,  /*100*count+*/53, 280);
	    }
	}
	d.setColor (Color.white);
	d.fillRect (50, 50, 90, 200);
	if (suit1.equals ("diamond") || suit1.equals ("heart"))
	{
	    d.setColor (Color.red);
	    d.drawRect (  /*100*count+*/50, 50, 90, 200);
	    if (suit1.equals ("diamond"))
	    {
		d.drawString ("\u2666",  /*100*count+*/53, 60);
		d.drawString (value1,  /*100*count+*/53, 70);
	    }
	    else
	    {
		d.drawString ("\u2665",  /*100*count+*/53, 60);
		d.drawString (value1,  /*100*count+*/53, 70);
	    }
	}


	else
	{
	    d.setColor (Color.black);
	    d.drawRect (  /*100*count+*/50, 50, 90, 200);
	    if (suit1.equals ("spade"))
	    {
		d.drawString ("\u2660",  /*100*count+*/53, 60);
		d.drawString (value1,  /*100*count+*/53, 70);
	    }
	    else
	    {
		d.drawString ("\u2663",  /*100*count+*/53, 60);
		d.drawString (value1,  /*100*count+*/53, 70);
	    }
	}


	if (sum > 21)
	{
	    money = money - betmoney;
	    c.println ("Your score is " + sum + " , YOU LOST!");
	    c.println ("Your balance is: " + money);
	    return money;
	}


	else if (dsum > 21)
	{
	    money = money + betmoney * 2;
	    c.println ("Dealer's score is " + dsum);
	    c.println ("Your score is " + sum + " , YOU WIN!");
	    c.println ("Your balance is: " + money);
	    return money;
	}


	else if (sum > dsum)
	{
	    money = money + betmoney * 2;
	    c.println ("Dealer's score is " + dsum);
	    c.println ("Your score is " + sum + " , YOU WIN!");
	    c.println ("Your balance is: " + money);
	    return money;
	}


	else if (sum == dsum)
	{
	    c.println ("Dealer's score is " + dsum);
	    c.println ("Your score is " + sum + " , DRAW!");
	    c.println ("Your balance is: " + money);
	    return money;
	}
	else
	{
	    c.println ("Dealer's score is " + dsum);
	    c.println ("Your score is " + sum + " , YOU LOST!");
	    c.println ("Your balance is: " + money);
	    c.println ();
	    return money;
	}

    }


    public static void probCalc1 (CardType cards[], int cardno, int sum)
    {
	int prob1 = 0;
	for (int i = 1 ; i <= cards.length - 1 ; i++)
	{
	    if (cards [i].getValue () >= 5)
	    {
		prob1++;
	    }
	}


	if (sum >= 21)
	{
	}


	else
	{
	    c.println ("the probability of getting a card with a value of 5 or higher is " + Math.round ((prob1) / (40.0 - cardno) * 100) + "%");
	}
    }


    public static void probCalc2 (CardType cards[], int cardno, int sum)
    {
	int prob2 = 0;
	for (int i = 1 ; i <= cards.length - 1 ; i++)
	{
	    if (sum + cards [i].getValue () == 21)
	    {
		prob2++;
	    }
	}


	if (sum >= 21)
	{
	}


	else
	{
	    c.println ("the probability of the player getting 21 in the next round is " + Math.round ((prob2) / (40.0 - cardno) * 100) + "%");
	}
    }


    public static void probCalc3 (CardType cards[], int cardno, int sum)
    {
	int prob3 = 0;
	for (int i = 1 ; i <= cards.length - 1 ; i++)
	{
	    if (sum + cards [i].getValue () > 21)
	    {
		prob3++;
	    }
	}


	if (sum >= 21)
	{
	}


	else
	{
	    c.println ("the probability of the player losing in the next round is " + Math.round ((prob3) / (40.0 - cardno) * 100) + "%");
	}
    }
}


