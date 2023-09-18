import java.lang.reflect.Array;
import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> myDeck;
    private String[] suitName = {"Spades", "Diamonds", "Clubs", "Hearts"};
    private String[] numberName = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};

    //constructer for deck
    public Deck() {
        myDeck = new ArrayList<Card>();
        cardsAll();// putting all the cards into the myDeck
    }

    //52 cards are added to the deck
    public void cardsAll() {
        for (int i = 0; i < suitName.length; i++) {//iterates through the suitName
            for (int j = 0; j < numberName.length; j++) {//iterates through the numberName
                myDeck.add(new Card(suitName[i], j+2, numberName[j]));// the cards are being created and being put into a arraylist
            }
        }
    }

    //shuffles the deck of cards
    public void shuffle()
    {
        ArrayList<Card> temp = new ArrayList<Card>();//temparary Arraylist where the shuffled cards are going to be put into
        while(myDeck.size()>0)
            {
                int rand = (int)(Math.random()*myDeck.size());//genrates a randon place in the deck
                temp.add(myDeck.remove(rand));//takes the selected card and puts it into the temp arraylist
            }
        myDeck=temp;//the primary arraylist is then equals to the temp arraylist
    }

    public Card dealTopCard()
    {
        return myDeck.remove(0);
    } //deals the first card of the deck

    //prints my Deck
    public String toString() {
        String temp = "";
        for (int i = 0; i < myDeck.size(); i++) {//iterates every card in the deck and prints it out

            temp += myDeck.get(i) + "\n";
        }
        temp+= myDeck.size();// prints the number of cards in the deck
        return temp;
    }

}



