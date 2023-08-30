/**
   Nolan Cyr
   CS110
   Sixes category that scores 6 points for each 6 rolled
 */
public class Sixes extends Category {

   /**
    * Receive 6 points for each 6 rolled
    * @param d Dice you are scoring
    * @return 6 points for each 6 rolled
    */
   @Override
   public int evaluate(Dice d)
   {
      return 6 * d.count(6);
   }
}