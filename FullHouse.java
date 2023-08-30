/**
   Nolan Cyr
   CS110
   Checks for a full house given set of Dice 
*/
public class FullHouse extends Category {

   /**
    * Scores for three dice showing the same number, and two dice showing another number
    * @param d Dice you are scoring
    * @return 25 points for full house, 0 if not
    */
   @Override
   public int evaluate(Dice d)
   {
      boolean twoOf = false;
      boolean threeOf = false;
      for (int i = 1; i <= 6; i++)
      {
         if (d.count(i) == 3)
         {
            threeOf = true;
         }
         if (d.count(i) == 2)
         {
            twoOf = true;
         }
      }
      
      if (twoOf && threeOf)
      {
         return 25;
      }
      return 0;
   }
}