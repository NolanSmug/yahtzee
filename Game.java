import java.util.Scanner;
import java.util.ArrayList;
/**
   Nolan Cyr
   CS110
   Runs Yahtzee game for two players
*/
public class Game
{
   private int playerNum = 1; // start with player 1
   private int numRolls = 1;
   private int numTurns = 0;

   private String input = "";

   private final int MAX_ROLLS_PER_TURN = 3; // can only roll 3 times per turn (including initial roll
   private final int MAX_TURNS = 26; // total turns for BOTH users

   private ArrayList<Die> diceSaved = new ArrayList<>();

   public void playGame()
   {
      // printing initial welcome to game
      System.out.print(welcomeToYahtzee());

      // asking for each player's name
      Scanner username = new Scanner(System.in);
      System.out.print("\nPlayer 1: ");
      Player player1 = new Player(username.nextLine());

      System.out.print("Player 2: ");
      Player player2 = new Player(username.nextLine());

      // create player that holds the current player's info
      Player currentPlayer = player1;

      while (numTurns < MAX_TURNS) {
         // START TURN
         System.out.print(playerScorecard(currentPlayer.getScorecard(), currentPlayer));

         // printing initial 5 dice
         System.out.print("Dice to reroll:\n");
         DiceRoll dice = new DiceRoll();
         System.out.print(dice);

         // for each sub turn in a user turn
         Scanner keyboard = new Scanner(System.in);
         while (numRolls < MAX_ROLLS_PER_TURN && !input.equalsIgnoreCase("score"))
         {
            // ask user which dice to save
            System.out.print("\nSave dice with [ ] filled with index values separated by spaces\n"
                    + "'roll' to reroll, 'score' to score\n");
            input = keyboard.nextLine();

            // if user enters roll to roll dice
            if (input.equalsIgnoreCase("roll"))
            {
               System.out.print(rollDice(dice, currentPlayer)); // see rollDice method (line 270)
            }
            // if user enters [ ] to save
            else if (input.startsWith("[") && input.endsWith("]") && verifySave(input, dice.getNumDice()))
            {
               saveDice(input, dice, currentPlayer.getScorecard());
            }
            // if user enters invalid input
            else if (!input.equalsIgnoreCase("score"))
            {
               System.out.printf("%s is not valid\n", input);
               System.out.print("Dice to reroll:\n");
               System.out.print(dice);
            }
         }
         // if user enters score OR loop is left after 3 rolls, add all dice saved to dice
         System.out.print("\nFinal Roll:\n");
         for (Die d : diceSaved)
         {
            dice.addDie(d);
         }
         // clear dice saved
         diceSaved.clear();
         System.out.print(dice);

         // print out evaluation to all categories and ask user which category they want to score in
         System.out.print("\nSelect a category that you have not scored in yet:\n");
         for (CategoryValue cv : CategoryValue.values())
         {
            System.out.printf("%2d: %s, current score %d\n", cv.getValue() + 1, cv,
                              currentPlayer.getScorecard().getEvaluation(cv, dice));
         }

         // user enters which category to score in
         boolean validChoice = false;
         while (!validChoice)
         {
            String categoryChosen = keyboard.nextLine();
            CategoryValue categoryValue = getCategoryChosen(categoryChosen);

            if (categoryValue != null)
            {
               // if category has not been chosen
               if (!currentPlayer.getScorecard().checkScored(categoryValue))
               {
                  currentPlayer.getScorecard().choose(categoryValue, dice);
                  validChoice = true;

               }

               // if category already chosen
               else
               {
                  // checking if user is eligible for yahtzee bonus
                  if (categoryValue == CategoryValue.YAHTZEE &&
                          currentPlayer.getScorecard().getCategoryScore(CategoryValue.YAHTZEE) != 0 &&
                          currentPlayer.getScorecard().getEvaluation(CategoryValue.YAHTZEE, dice) != 0)
                  {
                     currentPlayer.getScorecard().choose(categoryValue, dice);
                     validChoice = true;
                  }
                  else
                  {
                     System.out.print("\nCategory already chosen, select again\n");
                  }
               }
            }
         }

         numTurns++;
         numRolls = 1;
         input = "";
         // switch player number
         if (currentPlayer == player1)
         {
            currentPlayer = player2;
         }
         else
         {
            currentPlayer = player1;
         }
         // END TURN
      }
      // END GAME
      int player1Score = player1.getScorecard().score();
      int player2Score = player2.getScorecard().score();
      // printing out ending score summary and winner
      System.out.printf("\n\nGAME OVER\n%s: %d\n%s: %d\n\nWinner: %s\n",
              player1, player1Score, player2, player2Score, (player1Score > player2Score) ? player1: player2);
   }

   // PRIVATE METHODS
   /**
    * Returns a string of the **welcome to yahtzee**
    * @return a string of the **welcome to yahtzee**
    */
   private String welcomeToYahtzee()
   {
      String s = "";
      for (int i = 0; i < 56; i++)
      {
         s += "*";
      }
      s += String.format("\n%37s\n", "WELCOME TO YAHTZEE");
      for (int i = 0; i < 56; i++)
      {
         s += "*";
      }
      s += "\n";
      return s;
   }

   /**
    * Returns a players' scorecard for each turn
    * @param scorecard scorecard to print
    * @param player player number to print
    * @return a players' scorecard for each turn
    */
   private String playerScorecard(Scorecard scorecard, Player player)
   {
      String s = "";
      s += String.format("\nPlayer %d: %s\n", playerNum, player);
      s += "Current Scorecard:\n";
      s += scorecard.toString();
      
      playerNum = (playerNum == 1) ? 2 : 1;

      return s;
   }


   /**
    * Returns boolean true if user inputs valid response to saving dice, false if not
    * @param s What user input
    * @param numDice Number of dice in saved dice
    * @return boolean true if user inputs valid response to saving dice, false if not
    */
   private boolean verifySave(String s, int numDice)
   {
      ArrayList<Character> usedNums = new ArrayList<>();
      boolean valid;
      // string must be a minimum of 3 characters to be verified
      if (s.length() <= 2)
      {
         return false;
      }
      // checking that first and last characters are [ and ] respectively
         boolean needInt = true;
         valid = true;

      // iterating through string between [ and ]
      for (int i=1; i < s.length()-1; i++) {
         // return once we hit a false valid
         if (!valid)
         {
            return false;
         }

         char character = s.charAt(i);
         if (needInt)
         {
            // checking user enters number 1-5 and number hasn't been used before (in usedNums ArrayList)
            valid = (character == '1' || character == '2' || character == '3' ||
                    character == '4' || character == '5') && !usedNums.contains(character);
            usedNums.add(character);
            if (valid)
            {
               // checking that user ALSO enters number in range of saved dice
               valid = Integer.parseInt(String.valueOf(character)) <= numDice;
            }
            needInt = false;
         }
         // if it's not a number entry is a space between two numbers
         else
         {
            valid = character == ' ';
            needInt = true;
         }
      }
      return valid;
   }

   /**
    * Removes dice from dice and adds them to saved dice array from user input
    * @param input What user input for saved dice
    * @param dice Dice user can roll
    * @param s Users' scorecard
    */
   private void saveDice(String input, DiceRoll dice, Scorecard s)
   {
      // take empty spaces out of user input to just have [] and ints inside
      String inputInts = input.replaceAll(" ", "");

      // iterate through just the ints of the string and add Die to diceSaved
      for (int i=1; i < inputInts.length()-1; i++)
      {
         String num = inputInts.substring(i, i+1);
         // get Die object from dice based on what index the user asked to save
         Die dieToSave = dice.getDie(Integer.parseInt(num)-1);
         diceSaved.add(dieToSave);
      }

      // run a backwards loop and remove Die objects that were saved from dice user is rolling
      for (int i=dice.getNumDice()-1; i>=0; i--)
      {
         Die dieToRemove = dice.getDie(i);
         if (diceSaved.contains(dieToRemove))
         {
            // remove Die object from savedDice ArrayList
            dice.removeDie(i);
         }
      }
      // printing scorecard
      System.out.println(s);
      // printing dice left to roll and dice saved by user
      System.out.print("Dice to reroll:\n" + dice);
      System.out.print("\nDice to save:\n");
      for (int i = 0; i < diceSaved.size(); i++)
      {
         System.out.printf("%d:  value %d\n", i+1, diceSaved.get(i).getValue());
      }
   }

   /**
    * Rolls dice given DiceRoll object, prints scorecard, current dice, and dice to save info
    * @param dice DiceRoll object you're printing
    * @param currentPlayer The current player for which scorecard to print
    * @return Scorecard, current dice, and dice to save info
    */
   private String rollDice(DiceRoll dice, Player currentPlayer)
   {
      String s = "";
      numRolls++;
      dice.toss();
      s += (currentPlayer.getScorecard() + "\n");

      if (numRolls < 3) {
         s += ("Dice to reroll:\n" + dice);
         s += ("\nDice to save:\n");

         for (int i = 0; i < diceSaved.size(); i++) {
            s += String.format("%d: value %d\n", i + 1, diceSaved.get(i).getValue());
         }
      }
      return s;
   }

   /**
    * Returns the category value by converting user input string to category value
    * @param s user input string
    * @return the category value
    */
   private CategoryValue getCategoryChosen(String s)
   {
      try {
         int scoreInput = Integer.parseInt(s) - 1;
         for (CategoryValue cv : CategoryValue.values()) {
            if (cv.getValue() == scoreInput) {
               return cv;
            }
         }
      }
      catch (NumberFormatException e) {
         // empty catch statement
      }
      System.out.print("Invalid choice\n");
      return null;
   }
}