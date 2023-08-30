/**
   Nolan Cyr
   CS110
   Checks for three of a kind given set of Dice
 */
public class ThreeOfAKind extends Category {

   /**
    * Adds up all the spots on all the dice if three dice of the same number,
    * @param d Dice you are scoring
    * @return sum of all spots on the dice
    */
   @Override
   public int evaluate(Dice d)
   {
      for (int i = 1; i <= 6; i++)
      {
         if (d.count(i) >= 3)
         {
            return d.sum();
         }
      }
      return 0;
   }
}