import java.util.ArrayList;
import java.util.Scanner;
public class War {
    private Deck theDeck;
    private Player p1;
    private Player p2;
    private ArrayList<Card> table;
    private int rounds;
    private Scanner myScanner;

    public War()
    {
        myScanner = new Scanner(System.in);
        theDeck = new Deck(); //Created a deck of cards

        System.out.println("Enter Player 1 name:");
        String p1Name = myScanner.nextLine(); // get the name of player one using a scanner
        System.out.println("Enter Player 2 name:");
        String p2Name = myScanner.nextLine(); // get the name of player two using a scanner

        table = new ArrayList<Card>();
        p1 = new Player(p1Name); // created player one's object
        p2 = new Player(p2Name); //created player two's object
        rounds = 0;

        theDeck.shuffle(); // shuffled the deck of cards
        dealCards(); // dealing the shuffled cards to each playerDeck

        System.out.println("*************************************");
        prediction();

        round();


    }

     public void dealCards() //deals 26 cards to the two temp variables
     {
        for(int i = 0; i<26; i++)
        {
            p1.acceptCard(theDeck.dealTopCard()); //player one temp
            p2.acceptCard(theDeck.dealTopCard()); // player two temp
        }
     }

    public void round()
    {
        while(p1.getSize() > 0 && p2.getSize() > 0) {
            table.add(p1.dealTopCard());
            table.add(p2.dealTopCard());
            rounds++; //ups the count everytime round is called
            System.out.println("**********ROUND " + rounds + "**********");

            System.out.println(p1.getName() + " has " + table.get(table.size() - 2)); //This is the first player's card
            System.out.println(p2.getName() + " has " + table.get(table.size() - 1)); //This is the second player's card

            if (table.get(table.size() - 2).compareTo(table.get(table.size() - 1)) == 1) // If player one's card is greater, player one wins
            {
                System.out.println(p1.getName() + " has won this round!!!");
                p1.acceptCards(table); // takes all the cards from the shuffled table and sends it to player 1
                System.out.println(p1.getName() + " has " + p1.getSize() + " cards"); //Prints out the number of cards of player 1
                System.out.println(p2.getName() + " has " + p2.getSize() + " cards"); // Prints out the number of cards of player 2
                if(p2.getSize()==0)
                {
                    System.out.println( p1.getName()+ " has won the game of WAR");
                }
            }
            else if (table.get(table.size() - 2).compareTo(table.get(table.size() - 1)) == -1) // If player one's card is less, player two wins
            {
                System.out.println(p2.getName() + " has won this round!!!");
                p2.acceptCards(table); // takes all the cards from the shuffled table and sends it to player 2
                System.out.println(p1.getName() + " has " + p1.getSize() + " cards"); // Prints out the number of cards of player 1
                System.out.println(p2.getName() + " has " + p2.getSize() + " cards"); // Prints out the number of cards of player 2
                if(p1.getSize()==0)
                {
                    System.out.println(p2.getName()+ " has won the game of WAR");
                }

            }
            else{
                if(p1.getSize() <=1) {//checks to see if one deck has zero cards and determines the winner of the game
                    p2.acceptCards(table);//takes all the cards from the table and puts it into the winning deck
                    System.out.println("Player two has won the game of WAR");
                    System.out.println(p1.getName() + " has " + p1.getSize() + " cards");
                    System.out.println(p2.getName() + " has " + p2.getSize() + " cards");

                }
                else if(p2.getSize() <=1)//tie scenerio if player 2 has no cards left
                {
                    p1.acceptCards(table);
                    System.out.println("Player one has won the game of WAR");
                    System.out.println(p1.getName() + " has " + p1.getSize() + " cards");//prints the cards that player 1 has
                    System.out.println(p2.getName() + " has " + p2.getSize() + " cards");//prints the cards that player 2 has
                }
                else
                    {
                        System.out.println("**********************************WAR*************************************** \nA card from each player will be added to the table!" );
                        table.add(p1.dealTopCard());//Adds card to the table that will not compare
                        table.add(p2.dealTopCard());//Adds card to the table that will not compare
                        System.out.println(p1.getName() + " has " + p1.getSize() + " cards");
                        System.out.println(p2.getName() + " has " + p2.getSize() + " cards");
                    }
            }
        }

    }

    public void prediction() // Got this idea from Rita, sums up all the values from each deck and compare which has greater sum.
    {
        int p1Total = 0;
        int p2Total = 0;
        for(int i = 0; i<p1.getSize();i++)
        {
            p1Total += p1.getPlayerDeck().get(i).getValue();// finds the sum of all the cards from player one
        }
        for(int j = 0; j<p2.getSize();j++)
        {
            p2Total += p2.getPlayerDeck().get(j).getValue(); // finds the sum of all the cards from player two
        }
        if(p1Total>p2Total)
        {
            System.out.println("Prediction: " + p1.getName() + " will win the game from war because he/she has a greater sum of cards");// if sum of p1 is greater, p1 is predicted to win
        }
        else
        {
            System.out.println("Prediction: " + p2.getName() + " will win the game from war because he/she has a greater sum of cards");//if sum of p1 is greater, p1 is predicted to win
        }
    }
}