/**
   Nolan Cyr
   CS110
   Fives category that scores 5 points for each 5 rolled 
*/
public class Fives extends Category {

   /**
    * Receive 5 points for each 5 rolled in Dice
    * @param d Dice you are scoring
    * @return 5 points for each 5 rolled in Dice
    */
   @Override
   public int evaluate(Dice d)
   {
      return 5 * d.count(5);
   }
}