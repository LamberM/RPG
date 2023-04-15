import org.LamberM.game.HeroCreator;
import org.LamberM.game.Journey;


public class Main {
    public static void main(String[] args)
    {
        HeroCreator heroCreator = new HeroCreator();
        Journey journey = new Journey(heroCreator.createHero());
        System.out.println("Hello. This is RPG game");
        journey.startJourney();
    }
}