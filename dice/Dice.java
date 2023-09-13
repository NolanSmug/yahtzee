import java.util.ArrayList;
/**
   Nolan Cyr
   CS110
   Methods for an ArrayList of dice to help check category scoring
*/
public class Dice {
   
   private ArrayList<Die> dice;
   private final static int DEF_CAP = 5;

   /**
    * Create the ArrayList with DEF_CAP capacity
    */
   public Dice()
   {
      dice = new ArrayList<Die>(DEF_CAP);
   }

   /**
    * Create the ArrayList with num capacity
    * @param num the max capacity of the dice ArrayList
    */
   public Dice(int num)
   {
      dice = dice = new ArrayList<Die>(num);
   }

   /**
    * Add the d to the end of the ArrayList
    * @param d the die to add
    */
   public void addDie(Die d)
   {
      dice.add(d);
   }

   /**
    * Returns the number of Die in the ArrayList
    * @return the number of Die in the ArrayList
    */
   public int getNumDice()
   {
      return dice.size();
   }

   /**
    * Return the Die at index i in the ArrayList.
    * @param i the index of the die you are looking to return
    * @return the die at index i
    */
   public Die getDie(int i)
   {
      return dice.get(i);
   }

   /**
    * Remove the Die at the index i in the ArrayList
    * @param i the index of the die you are looking to remove
    */
   public void removeDie(int i)
   {
      dice.remove(i);
   }

   /**
    * Returns the number of Die in the ArrayList that have a value of the specified val
    * @param val the value of the die you are looking to count
    * @return the number of Die in the ArrayList that have a value of the specified val
    */
   public int count(int val)
   {
      int count = 0;
      for (Die d : dice)
      {
         if (d.getValue() == val)
         {
            count++;
         }
      }
      return count;
   }

   /**
    * Returns the sum of the Die values in the ArrayList
    * @return the sum of the Die values in the ArrayList
    */
   public int sum()
   {
      int sum = 0;
      for (Die d : dice)
      {
         sum += d.getValue();    
      }
      return sum;
   }

   /**
    * Return true if at least one Die in the ArrayList has a value of val
    * @param val the Die with the number you are searching for
    * @return boolean if val is in ArrayList of Die
    */
   public boolean contains(int val)
   {
      boolean contains = false;
      for (Die d : dice)
      {
         if (d.getValue() == val)
         {
            contains = true;
         }
      }
      return contains;
   }

   /**
    * Prints all dice from dice ArrayList with their index and value
    * @return String of all dice from dice ArrayList with their index and value
    */
   public String toString()
   {
      String s = "";
      int numDie = 1;
      for (Die d : dice)
      {
         s += String.format("%d:  value %d\n", numDie, d.getValue());
         numDie++;
      }
      return s;
   }
}
