/**
   Nolan Cyr
   CS110
   Fours category that scores 4 points for each 4 rolled 
*/
public class Fours extends Category {

   /**
    * Receive 4 points for each 4 rolled in Dice
    * @param d Dice you are scoring
    * @return 4 points for each 4 rolled in Dice
    */
   @Override
   public int evaluate(Dice d)
   {
      return 4 * d.count(4);
   }
}