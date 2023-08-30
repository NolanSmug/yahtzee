/**
   Nolan Cyr
   CS110
   Twos category that scores 2 points for each 2 rolled
 */
public class Twos extends Category {

   /**
    * Receive 2 points for each 2 rolled
    * @param d Dice you are scoring
    * @return 2 points for each 2 rolled
    */
   @Override
   public int evaluate(Dice d)
   {
      return 2 * d.count(2);
   }
}