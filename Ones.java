/**
   Nolan Cyr
   CS110
   Ones category that scores 1 point for each 1 rolled 
*/
public class Ones extends Category {

   /**
    * Receive 1 point for each 1 rolled
    * @param d Dice you are scoring
    * @return 1 point for each 1 rolled
    */
   @Override
   public int evaluate(Dice d)
   {
      return d.count(1);
   }
}