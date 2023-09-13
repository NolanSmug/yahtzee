/**
   Nolan Cyr
   CS110
   Threes category that scores 3 points for each 3 rolled
 */
public class Threes extends Category {

   /**
    * Receive 3 points for each 3 rolled
    * @param d Dice you are scoring
    * @return 3 points for each 3 rolled
    */
   @Override
   public int evaluate(Dice d)
   {
      return 3 * d.count(3);
   }
}
