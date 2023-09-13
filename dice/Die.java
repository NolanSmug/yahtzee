import java.util.Random;
/**
   Nolan Cyr
   CS110
   Creates Die object with random number
*/
public class Die {
   
   private int value;
   private final static int SIDES = 6;
   private Random r = new Random();

   /**
    * Initialize value to a random number between 1 and SIDES
    */
   public Die()
   {
      value = r.nextInt(SIDES) + 1;
   }

   /**
    * Change the value on the die to a random value between 1 and SIDES
    */
   public void roll()
   {
      value = r.nextInt(SIDES) + 1;
   }

   /**
    * Returns value on die
    * @return value on die
    */
   public int getValue()
   {
      return value;
   }

   /**
    * A String containing single integer value representing the value on the die
    * @return a String containing single integer value representing the value on the die
    */
   public String toString()
   {
      return String.format("%s", value);
   }
}
