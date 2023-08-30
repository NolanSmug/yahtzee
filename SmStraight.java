/**
   Nolan Cyr
   CS110
   Checks for a small straight given set of Dice
 */

public class SmStraight extends Category {

   /**
    * Scores for any four consecutive numbers (for example, 3-4-5-6)
    * @param d Dice you are scoring
    * @return 30 points for small straight, 0 if not
    */
   @Override
   public int evaluate(Dice d)
   {
      boolean case1 = d.contains(1) && d.contains(2) && d.contains(3) && d.contains(4);
      boolean case2 = d.contains(2) && d.contains(3) && d.contains(4) && d.contains(5);
      boolean case3 = d.contains(3) && d.contains(4) && d.contains(5) && d.contains(6);
      
      if (case1 || case2 || case3)
         return 30;
      return 0;
   }
}