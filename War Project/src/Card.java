public class Card {
    private String suit;
    private int value;
    private String name;

    //Constructor for the card
    public Card(String suit, int value, String name) {
        this.suit = suit;
        this.value = value;
        this.name = name;
    }

    //overloaded constructor for joker
    public Card() {
        this.value=0;
        this.name="Joker";
        this.suit="Joker";
    }

    //getter method for suit of card
    public String getSuit() {
        return suit;
    }

    //getter method for value of card
    public int getValue() {
        return value;
    }

    //getter method for name of card
    public String getName() {
        return name;
    }

    //compares the values of two cards
    public boolean equals(Card other)
    {
        if(this.getValue()==other.getValue())
        {
            return true;
        }
            return false;
    }

    // compares two cards and return int values
    public int compareTo(Card other)
    {
    if(this.getValue() < other.getValue()) //if the first value has a lesser value than the second one
    {
        return -1;
    }
    else if(this.getValue() == other.getValue())//if the first value has the same value as the second one
    {
        return 0;
    }
    else
    {
        return 1;//if the first value has a greater value than the second one
    }
    }

    //toString of the card
    public String toString()
    {
        return name + " of " + suit;
    }
}
