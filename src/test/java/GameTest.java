//package test.java;
//import main.java.*;
//import org.junit.jupiter.api.Test;
//
//
//class GameTest {
//private String Name;
//    String getName() {
//        return Name;
//    }
//    void setName(String name) {
//        Name = name;
//    }
//    Classes myHero;
//    int userChoice;
//    public int range=1;
//
//    @Test
//    void addName() {
//        System.out.println("Podaj swoją nazwę bohatera");
//        String name = "test";
//        setName(name);
//        System.out.println(getName());
//    }
//
//    @Test
//    void infoAboutClass() {
//        Warrior warrior=new Warrior();
//        Assassin assassin= new Assassin();
//        Sorcerer sorcerer= new Sorcerer();
//        System.out.println("Statystyki wszystkich klas:");
//        System.out.println("Statystyki wojownika/wojowniczki: ");
//        warrior.showStats();
//        System.out.println("Statystyki zabójcy/zabójczyni");
//        assassin.showStats();
//        System.out.println("Statystyki czarodzieja/czarodziejki");
//        sorcerer.showStats();
//    }
//
//    @Test
//    void pickClass() {
//        System.out.println("Wybierz klasę:");
//        System.out.println("1.Wojownik/Wojowniczka");
//        System.out.println("2.Zabójca/Zabójczyni");
//        System.out.println("3.Czarodziej/Czarodziejka");
//        System.out.println("4.Wyjdź z aplikacji");
//        userChoice = 1;
//
//        if (userChoice > 0 & userChoice < 5) {
//            switch (userChoice) {
//                case 1 -> {
//                    System.out.println("Wybrałeś wojownika/wojowniczke");
//                    myHero=new Warrior();
//                    mainMENU();
//                }
//                case 2 -> {
//                    System.out.println("Wybrałeś zabójce/zabójczyni");
//                    myHero=new Assassin();
//                    mainMENU();
//                }
//                case 3 -> {
//                    System.out.println("Wybrałeś czarodzieja/czarodziejke");
//                    myHero=new Sorcerer();
//                    mainMENU();
//                }
//                case 4 -> {}
//            }
//        }
//        else {
//            pickClass();
//            System.out.println("Spróbuj ponownie");
//        }
//    }
//    @Test
//    void game() {
//        addName();
//        infoAboutClass();
//        pickClass();
//    }
//    @Test
//    void mainMENU() {
//        System.out.println("Witaj " + getName());
//        System.out.println("Gotowy na przygodę ?");
//        System.out.println("Twoje możliwości wyboru:");
//        System.out.println("1.Walka");
//        System.out.println("2.Sprawdź statystyki");
//        System.out.println("3.Dodaj punkty statystyk");
//        System.out.println("4.Wyjdź");
//        userChoice = 1;
//        if (userChoice > 0 & userChoice < 5) {
//            switch (userChoice) {
//                case 1 -> duelMENU();
//                case 2 -> {
//                    myHero.showStats();
//                    mainMENU();
//                }
//                case 3 -> {
//                    myHero.lvlUP();
//                    mainMENU();
//                }
//                case 4 ->{}
//            }
//        } else {
//            System.out.println("Spróbuj ponownie");
//            mainMENU();
//        }
//    }
//
//    @Test
//    void duelMENU() {
//        Enemy enemy = new Enemy();
//        enemy.duelStats();
//        myHero.duelStats();
//        System.out.println("1.Atak");
//        System.out.println("2.Zaklęcia");
//        System.out.println("3.Krok w przód");
//        System.out.println("4.Krok w tył");
//        System.out.println("5.Odpoczynek");
//        userChoice = 1;
//        if (userChoice > 0 & userChoice < 6) {
//            switch (userChoice) {
//                case 1 ->{
//                    if (range <= myHero.stats.getAttackRange()) //range działa
//                    {
//                        myHero.attack();
//                        enemy.attack();
//                        // testowanie
//                        System.out.println("myhero " + myHero.stats.getCurrentHP());
//                        System.out.println("enemy " + enemy.enemyStats.getCurrentHP());
//                        duelMENU();
//                    }
//                    else {
//                        System.out.println("Nie możesz uderzyć przeciwnika, twój zasięg ataku jest za mały");
//                        duelMENU();
//                    }
//                }
//                case 2-> {
//                    if (myHero.stats.getCurrentMP()>=20){
//                        myHero.skills();
//                        enemy.attack();
//                        duelMENU();
//                        //testowanie
//                        myHero.stats.getCurrentHP();
//                    }
//                    else {
//                        System.out.println("Masz za mało many");
//                        duelMENU();
//                    }
//                }
//                case 3->{
//                    range=range-1;
//                    enemy.attack();
//                    duelMENU();
//                    //testowanie
//                    myHero.stats.getCurrentHP();
//                }
//                case 4->{
//                    range=range+1;
//                    enemy.attack();
//                    duelMENU();
//                    //testowanie
//                    myHero.stats.getCurrentHP();
//                }
//                case 5-> {
//                    myHero.rest();
//                    enemy.attack();
//                    duelMENU();
//                    //testowanie
//                    myHero.stats.getCurrentHP();
//                }
//            }
//        }
//        else{
//            System.out.println("Wpisałeś złą liczbę");
//            duelMENU();
//        }
//        // dodać zwycięzce, expa ,lvl up'y
//    }
//}