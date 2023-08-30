/**
   Nolan Cyr
   CS110
   Methods for evaluating and scoring the all possible yahtzee scoring categories 
*/
public abstract class Category {

   private int score;
   private boolean used;

   /**
    * An abstract method that will evaluate the Die in the Dice object and return a score
    * @param d The dice being evaluated
    * @return Score for category being evaluated
    */
   public abstract int evaluate(Dice d);

   /**
    * Adds the value the Dice would produce to the score (calls evaluate). Marks category as used.
    * @param d Dice value is being added from
    */
   public void addValue(Dice d)
   {
      score = evaluate(d);
      used = true;
   }

   /**
    * Returns the current score for this category
    * @return the current score for this category
    */
   public int getScore()
   {
      return score;
   }

   /**
    * Returns the value of used indicating if category has been used
    * @return the value of used indicating if category has been used
    */
   public boolean getUsed()
   {
      return used;
   }
}