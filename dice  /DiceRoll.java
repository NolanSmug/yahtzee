/**
   Nolan Cyr
   CS110
   Methods for creating Die in ArrayList and rolling them   
*/
public class DiceRoll extends Dice {

   private final static int NUM_DIE = 5;

   /**
    * Fills the super (Dice) object with NUM_DIE random Die objects
    */
   public DiceRoll()
   {
      for (int i = 0; i < NUM_DIE; i++)
      {
         addDie(new Die());
      }
   }

   /**
    * Rolls each of the Die in the Dice ArrayList
    */
   public void toss()
   {
      for (int i = 0; i < getNumDice(); i++)
      {
         getDie(i).roll();
      }
   }
}
