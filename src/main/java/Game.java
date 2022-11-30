package main.java;

import java.util.Scanner;

public class Game {
    private String Name;
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    Scanner scanner = new Scanner(System.in);
    Classes myHero;
    int userChoice;
    public int range=2;

    public void game() {
        addName();
        infoAboutClass();
        pickClass();
    }
    public void addName(){
        System.out.println("Podaj swoją nazwę bohatera");
        String name = scanner.nextLine();
        setName(name);
    }
    public void infoAboutClass(){
        Warrior warrior=new Warrior();
        Assassin assassin= new Assassin();
        Sorcerer sorcerer= new Sorcerer();
        System.out.println("Statystyki wszystkich klas:");
        System.out.println("Statystyki wojownika/wojowniczki: ");
        warrior.showStats();
        System.out.println("Statystyki zabójcy/zabójczyni");
        assassin.showStats();
        System.out.println("Statystyki czarodzieja/czarodziejki");
        sorcerer.showStats();
    }
    public void pickClass(){
        System.out.println("Wybierz klasę:");
        System.out.println("1.Wojownik/Wojowniczka");
        System.out.println("2.Zabójca/Zabójczyni");
        System.out.println("3.Czarodziej/Czarodziejka");
        System.out.println("4.Wyjdź z aplikacji");
        userChoice = scanner.nextInt();

        if (userChoice > 0 && userChoice < 5) {
            switch (userChoice) {
                case 1 -> {
                    System.out.println("Wybrałeś wojownika/wojowniczke");
                    myHero=new Warrior();
                    mainMENU();
                }
                case 2 -> {
                    System.out.println("Wybrałeś zabójce/zabójczyni");
                    myHero=new Assassin();
                    mainMENU();
                }
                case 3 -> {
                    System.out.println("Wybrałeś czarodzieja/czarodziejke");
                    myHero=new Sorcerer();
                    mainMENU();
                }
                case 4 -> {}
            }
        }
        else {
            pickClass();
            System.out.println("Spróbuj ponownie");
        }
    }
    public void mainMENU() {
            System.out.println("Witaj " + getName());
            System.out.println("Gotowy na przygodę ?");
            System.out.println("Twoje możliwości wyboru:");
            System.out.println("1.Walka");
            System.out.println("2.Sprawdź statystyki");
            System.out.println("3.Dodaj punkty statystyk");
            System.out.println("4.Wyjdź");
            userChoice = scanner.nextInt();
            if (userChoice > 0 && userChoice < 5) {
                switch (userChoice) {
                    case 1 -> duelMENU();
                    case 2 -> {
                        myHero.showStats();
                        mainMENU();
                    }
                    case 3 -> {
                        myHero.lvlUP();
                        mainMENU();
                    }
                    case 4 ->{}
                }
            } else {
                System.out.println("Spróbuj ponownie");
                mainMENU();
            }
        }
    public void duelMENU() {
            Enemy enemy = new Enemy();
            enemy.duelStats();
            myHero.duelStats();
            System.out.println("1.Atak");
            System.out.println("2.Zaklęcia");
            System.out.println("3.Krok w przód");
            System.out.println("4.Krok w tył");
            System.out.println("5.Odpoczynek");
            userChoice = scanner.nextInt();
            if (userChoice > 0 && userChoice < 6) {
                switch (userChoice) {
                    case 1 ->{
                    if (range <= myHero.stats.getAttackRange()){
                        myHero.attack();
                        enemy.attack();
                        duelMENU();
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
                            duelMENU();

                        }
                        else {
                            System.out.println("Masz za mało many");
                            duelMENU();
                        }
                    }
                    case 3->{
                        range=range-1;
                        enemy.attack();
                        duelMENU();
                    }
                    case 4->{
                        range=range+1;
                        enemy.attack();
                        duelMENU();
                    }
                    case 5-> {
                        myHero.rest();
                        enemy.attack();
                        duelMENU();

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

