/**
   Nolan Cyr
   CS110
   Player class to hold a player's name and scorecard
*/
public class Player
{

    private String name;
    private Scorecard scorecard;

    /**
     * Creates player object with name
     * @param name Name of the player
     */
    public Player(String name)
    {
        this.name = name;
        this.scorecard = new Scorecard();
    }

    /**
     * Returns players' scorecard
     * @return players' scorecard
     */
    public Scorecard getScorecard()
    {
        return scorecard;
    }

    /**
     * Returns players' name
     * @return players' name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns players' name
     * @return players' name
     */
    @Override
    public String toString()
    {
        return name;
    }
}