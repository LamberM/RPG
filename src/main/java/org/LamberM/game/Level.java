package org.LamberM.game;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
@Getter
@Setter
public class Level {

    private int exp = 0;

    private int lvl = 1;
    private int lvlToCompare = 2;

    public boolean getLvlUp()
    {
        return lvl == lvlToCompare;
    }
    private boolean giveLvlUp(){
        return exp >=100;
    }
    private boolean expLessZero(){
        return exp < 0;
    }
    private void expNotNegative()
    {
        if (expLessZero())
        {
            exp = 0;
        }
    }
    public void lvlUP(){
        expNotNegative();
        if (giveLvlUp()){
            lvl = lvl+1;
            exp= exp - 100;
            System.out.println("Level up !!!");
            expNotNegative();
        }
    }
    public void addExp()
    {
        Random draw = new Random();
        exp = 70 + draw.nextInt(81);
    }

}