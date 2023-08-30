/**
   Nolan Cyr
   CS110
   Chance category that adds up the spots on all dice  
*/
public class Chance extends Category {

   /**
    * Scores for any combination of dice, add up all the spots on all the dice
    * @param d Dice you are scoring
    * @return the sum of all the Die in Dice
    */
   @Override
   public int evaluate(Dice d)
   {
      return d.sum();
   }
}