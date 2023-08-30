/**
   Nolan Cyr
   CS110
   Checks for a large straight given set of Dice  
*/
public class LgStraight extends Category {

   /**
    * Scores for any five consecutive numbers (for example, 2-3-4-5-6)
    * @param d Dice you are scoring
    * @return 40 points for large straight, 0 if not
    */
   @Override
   public int evaluate(Dice d)
   {
      boolean case1 = d.contains(1) && d.contains(2) && d.contains(3) && d.contains(4) && d.contains(5);
      boolean case2 = d.contains(2) && d.contains(3) && d.contains(4) && d.contains(5) && d.contains(6);
      
      if (case1 || case2)
         return 40;
      return 0;
   }
}