import java.util.ArrayList;
/**
   Nolan Cyr
   CS 110
   Scorecard class that holds score of all categories
 */
public class Scorecard {

   private ArrayList<Category> scorecard;
   private int yahtzeeBonus = 0;
   
   private final static int NUM_CATS = 13;

   /**
    * Creates all category objects and adds them to scorecard ArrayList
    */
   public Scorecard()
   {
      scorecard = new ArrayList<Category>(NUM_CATS);
      scorecard.add(new Ones());
      scorecard.add(new Twos());
      scorecard.add(new Threes());
      scorecard.add(new Fours());
      scorecard.add(new Fives());
      scorecard.add(new Sixes());
      scorecard.add(new ThreeOfAKind());
      scorecard.add(new FourOfAKind());
      scorecard.add(new FullHouse());
      scorecard.add(new SmStraight());
      scorecard.add(new LgStraight());
      scorecard.add(new Yahtzee());
      scorecard.add(new Chance());
   }

   /**
    * Gets the appropriate Category and score that category
    * and sets appropriate scored element to true, indicating it has been used.
    * @param cv The category being used to score
    * @param d Dice being scored
    */
   public void choose(CategoryValue cv, Dice d)
   {
      Category c = scorecard.get(cv.getValue());
      // check if user previously scored a Yahtzee
      if (cv == CategoryValue.YAHTZEE && checkScored(cv)) {
         yahtzeeBonus += 100;
      }
      else {
         c.addValue(d);
      }
   }

   /**
    * Returns the score that would be achieved in this category with the provided Dice object
    * @param cv Category being used to score
    * @param d Dice being scored
    * @return the score that would be achieved in this category with the provided Dice object
    */
   public int getEvaluation(CategoryValue cv, Dice d)
   {
      Category c = scorecard.get(cv.getValue());
      return c.evaluate(d);
   }

   /**
    * Returns true if Category has been used, false otherwise
    * @param cv the category you're checking if it was used
    * @return true if Category has been used, false otherwise
    */
   public boolean checkScored(CategoryValue cv)
   {
      Category c = scorecard.get(cv.getValue());
      return c.getUsed();
   }

   /**
    * Returns the current score for the specified Category
    * @param cv the category you are getting score from
    * @return the current score for the specified Category
    */
   public int getCategoryScore(CategoryValue cv)
   {
      Category c = scorecard.get(cv.getValue());
      return c.getScore();
   }

   /**
    * Returns the total score for the top of the scorecard
    * @return the total score for the top of the scorecard
    */
   public int scoreTop()
   {
      int score = 0;
      for (int i = 0; i <= 5; i++)
      {
         // assume that top categories are in order of enum (0-5)
         score += scorecard.get(i).getScore();
      }
      // check for bonus
      if (score >= 63)
      {
         score += 35;
      }
      return score;
   }

   /**
    * Returns the total score for the bottom of the scorecard
    * @return the total score for the bottom of the scorecard
    */
   public int scoreBottom()
   {
      int score = 0;
      for (int i = 6; i <= 12; i++)
      {
         // assume that bottom categories are in order of enum (6-12)
         score += scorecard.get(i).getScore();
      }
      score += yahtzeeBonus;
      return score;
   }

   /**
    * Returns the total score for the scorecard
    * @return the total score for the scorecard
    */
   public int score()
   {
      return scoreTop() + scoreBottom();
   }
   
   public String toString()
   {
      String s = "";
      
      for (CategoryValue cv : CategoryValue.values())
      {
         s += String.format("%15s: %d\n", cv,cv == CategoryValue.YAHTZEE ? getCategoryScore(cv) + yahtzeeBonus : getCategoryScore(cv));
      }
      s += String.format("%15s: %d\n", "Upper Total", scoreTop());
      s += String.format("%15s: %d\n", "Lower Total", scoreBottom());
      s += String.format("%15s: %d\n", "Total", score());
      
      return s;
   }
}
