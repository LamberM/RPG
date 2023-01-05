package org.LamberM.game;


import org.LamberM.classes.AssassinTest;
import org.LamberM.classes.ClassesTest;
import org.LamberM.classes.SorcererTest;
import org.LamberM.classes.WarriorTest;
import org.LamberM.enemy.EnemyTest;
import org.junit.jupiter.api.Test;


public class GameTest {
private String Name;
    String getName() {
        return Name;
    }
    void setName(String name) {
        Name = name;
    }
    ClassesTest myHero;

    int userChoice;
    public int range=1;

    @Test
    void addName() {
        System.out.println("Podaj swoją nazwę bohatera");
        String name = "test";
        setName(name);
        System.out.println(getName());
        // DZIAŁĄ !!!
    }


    void infoAboutClass() {
        WarriorTest warrior=new WarriorTest();
        AssassinTest assassin= new AssassinTest();
        SorcererTest sorcerer= new SorcererTest();
        System.out.println("Statystyki wszystkich klas:");
        System.out.println("Statystyki wojownika/wojowniczki: ");
        warrior.showStats();
        System.out.println("Statystyki zabójcy/zabójczyni");
        assassin.showStats();
        System.out.println("Statystyki czarodzieja/czarodziejki");
        sorcerer.showStats();
        // działą !!!
    }

    void pickClass() {
        System.out.println("Wybierz klasę:");
        System.out.println("1.Wojownik/Wojowniczka");
        System.out.println("2.Zabójca/Zabójczyni");
        System.out.println("3.Czarodziej/Czarodziejka");
        System.out.println("4.Wyjdź z aplikacji");
        userChoice = 1;

        if (userChoice > 0 & userChoice < 5) {
            switch (userChoice) {
                case 1 -> {
                    System.out.println("Wybrałeś wojownika/wojowniczke");
                    myHero=new WarriorTest();
                    mainMENU();
                }
                case 2 -> {
                    System.out.println("Wybrałeś zabójce/zabójczyni");
                    myHero=new AssassinTest();
                    mainMENU();
                }
                case 3 -> {
                    System.out.println("Wybrałeś czarodzieja/czarodziejke");
                    myHero=new SorcererTest();
                    mainMENU();
                }
                case 4 -> {}
            }
        }
        else {
            pickClass();
            System.out.println("Spróbuj ponownie");
        }
        // wszystko działa !!
    }
    @Test
    void game() {
        addName();
        infoAboutClass();
        pickClass();
    }
    public void mainMENU() {
        System.out.println("Witaj " + getName());
        System.out.println("Gotowy na przygodę ?");
        System.out.println("Twoje możliwości wyboru:");
        System.out.println("1.Walka");
        System.out.println("2.Sprawdź statystyki");
        System.out.println("3.Dodaj punkty statystyk");
        System.out.println("4.Wyjdź");
        userChoice = 1;
        if (userChoice > 0 & userChoice < 5) {
            switch (userChoice) {
                case 1 -> duelMENU();
                case 2 -> {
                    myHero.showStats();
                }
                case 3 -> {
                    myHero.lvlUP();
                }
                case 4 ->{}
            }
        } else {
            System.out.println("Spróbuj ponownie");
            mainMENU();
        }
        // Działa !!!
    }
    void duelMENU() {
        EnemyTest enemy = new EnemyTest();
        enemy.duelStats();
        myHero.duelStats();
        System.out.println("1.Atak");
        System.out.println("2.Zaklęcia");
        System.out.println("3.Krok w przód");
        System.out.println("4.Krok w tył");
        System.out.println("5.Odpoczynek");
        userChoice = 1;
        if (userChoice > 0 & userChoice < 6) {
            switch (userChoice) {
                case 1 ->{
                    if (range <= myHero.stats.getAttackRange()) //range działa
                    {
                        myHero.attack();
                        enemy.attack();
                        // test
                        System.out.println("myhero " + myHero.stats.getCurrentHP());
                        System.out.println("enemy " + enemy.enemyStats.getCurrentHP());

                    }
                    else {
                        System.out.println("Nie możesz uderzyć przeciwnika, twój zasięg ataku jest za mały");
                        duelMENU();
                    }
                }
                case 2-> {
                    if (myHero.stats.getCurrentMP()>=20){
                        myHero.skills();
                        enemy.attack();
                    }
                    else {
                        System.out.println("Masz za mało many");
                        duelMENU();
                    }
                }
                case 3->{
                    range=range-1;
                    enemy.attack();
                }
                case 4->{
                    range=range+1;
                    enemy.attack();
                }
                case 5-> {
                    myHero.rest();
                    enemy.attack();
                }
            }
        }
        else{
            System.out.println("Wpisałeś złą liczbę");
            duelMENU();
        }
        // dodać zwycięzce, expa ,lvl up'y
    }
}