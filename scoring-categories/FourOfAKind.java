/**
   Nolan Cyr
   CS110
   Checks for four of a kind given set of Dice  
*/
public class FourOfAKind extends Category {

   /**
    * Adds up all the spots on all dice if four dice are the same number
    * @param d Dice you are scoring
    * @return Sum of all the spots on all dice
    */
   @Override
   public int evaluate(Dice d)
   {
      for (int i = 1; i <= 6; i++)
      {
         if (d.count(i) >= 4)
         {
            return d.sum();
         }
      }
      return 0;
   }
}
