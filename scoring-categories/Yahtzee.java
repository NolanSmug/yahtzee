/**
   Nolan Cyr
   CS110
   Checks for YAHTZEE! given set of Dice
 */
public class Yahtzee extends Category {

   /**
    * Scores if all 5 dice showing the same number
    * @param d Dice you are scoring
    * @return 50 points if yahtzee, 0 if not
    */
   @Override
   public int evaluate(Dice d)
   {
      for (int i = 1; i <= 6; i++)
      {
         if (d.count(i) == 5)
         {
            return 50;
         }
      }
      return 0;
   }
}
