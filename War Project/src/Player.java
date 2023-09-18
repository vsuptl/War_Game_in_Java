import java.util.ArrayList;
import java.util.Collections;
public class Player{
    private String name;
    private ArrayList<Card> playerDeck;

    //constructor for the player class
    public Player(String name)
    {
        this.name = name;
        playerDeck = new ArrayList<Card>();
    }

    public int getSize()
    {
        return playerDeck.size();
    }

    //returns the name of the player
    public String getName()
    {
        return name;
    }

    public ArrayList<Card> getPlayerDeck()
    {
        return playerDeck;
    }

    //Accepts the cards from the deck
    public void acceptCard(Card card)
    {
        playerDeck.add(card);
    }

    public void acceptCards(ArrayList<Card> temp)
    {
        //shuffle
        //while loop
        //add to the hand and remove from temp
        Collections.shuffle(temp); // Credit from Mr. O'brien for letting us use this
        while(temp.size()>0)
        {
            playerDeck.add(temp.remove(0));
        }


    }

    //deals the top card from each player
    public Card dealTopCard()
    {
        return playerDeck.remove(0);
    }

    //toString of the player class
    public String toString()
    {
        String temp = "";
        temp += name + " has " + playerDeck.size() +" cards"+ "\n";// prints the player name and the number of cards in the deck
        for (int i = 0; i < playerDeck.size(); i++) {//iterates every card from the playerDeck and prints it out

            temp += playerDeck.get(i) + "\n";
        }
        return temp;
    }
}
