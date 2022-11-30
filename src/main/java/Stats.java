package main.java;

import java.util.Scanner;

class Stats {
    private int EXP = 0;
    private int LVL = 1;
    private int LVLtocompare = 2;
    private int Strength, Dexterity, Intelligence, HP, MP, Dodge, Armor, CriticalChance, AttackRange, CurrentHP, CurrentMP, CurrentArm, CurrentStr, CurrentDex, CurrentCritC, CurrentDodge;

    public int getAttackRange() {
        return AttackRange;
    }

    public void setAttackRange(int attackRange) {
        this.AttackRange = attackRange;
    }

    public int getEXP() {
        return EXP;
    }

    public void setEXP(int EXP) {
        this.EXP = EXP;
    }

    public int getLVL() {
        return LVL;
    }

    public void setLVL(int LVL) {
        this.LVL = LVL;
    }

    public int getLVLtocompare() {
        return LVLtocompare;
    }

    public void setLVLtocompare(int LVLtocompare) {
        this.LVLtocompare = LVLtocompare;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        this.Strength = strength;
    }

    public int getDexterity() {
        return Dexterity;
    }

    public void setDexterity(int dexterity) {
        this.Dexterity = dexterity;
    }

    public int getIntelligence() {
        return Intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.Intelligence = intelligence;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getDodge() {
        return Dodge;
    }

    public void setDodge(int dodge) {
        this.Dodge = dodge;
    }

    public int getArmor() {
        return Armor;
    }

    public void setArmor(int armor) {
        this.Armor = armor;
    }

    public int getCriticalChance() {
        return CriticalChance;
    }

    public void setCriticalChance(int criticalChance) {
        this.CriticalChance = criticalChance;
    }

    public int getCurrentHP() {
        return CurrentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.CurrentHP = currentHP;
    }

    public int getCurrentMP() {
        return CurrentMP;
    }

    public void setCurrentMP(int currentMP) {
        this.CurrentMP = currentMP;
    }

    public int getCurrentArm() {
        return CurrentArm;
    }

    public void setCurrentArm(int currentArm) {
        this.CurrentArm = currentArm;
    }

    public int getCurrentStr() {
        return CurrentStr;
    }

    public void setCurrentStr(int currentStr) {
        this.CurrentStr = currentStr;
    }

    public int getCurrentDex() {
        return CurrentDex;
    }

    public void setCurrentDex(int currentDex) {
        this.CurrentDex = currentDex;
    }

    public int getCurrentCritC() {
        return CurrentCritC;
    }

    public void setCurrentCritC(int currentCritC) {
        this.CurrentCritC = currentCritC;
    }

    public int getCurrentDodge() {
        return CurrentDodge;
    }

    public void setCurrentDodge(int currentDodge) {
        this.CurrentDodge = currentDodge;
    }

    public Stats(int strength, int dexterity, int intelligence, int HP, int MP, int dodge, int armor, int criticalChance, int attackRange) {
        this.Strength = strength;
        this.Dexterity = dexterity;
        this.Intelligence = intelligence;
        this.HP = HP;
        this.MP = MP;
        this.Dodge = dodge;
        this.Armor = armor;
        this.CriticalChance = criticalChance;
        this.AttackRange = attackRange;
        //current stats whose need to duel
        this.CurrentStr = this.Strength;
        this.CurrentDex = this.Dexterity;
        this.CurrentHP = this.HP;
        this.CurrentMP = this.MP;
        this.CurrentDodge = this.Dodge;
        this.CurrentArm = this.Armor;
        this.CurrentCritC = this.CriticalChance;
    }

    public void showStats() {
        System.out.println("Siła: " + this.Strength);
        System.out.println("Zręczność: " + this.Dexterity);
        System.out.println("Inteligencja: " + this.Intelligence);
        System.out.println("HP: " + this.HP);
        System.out.println("MP: " + this.MP);
        System.out.println("Unik: " + this.Dodge);
        System.out.println("Pancerz: " + this.Armor);
        System.out.println("Szansa na krytyczne uderzenie: " + this.CriticalChance);
    }

    // add stats after lvl up
    public void addStats() {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        double actuallypoints = 0;
        if (getLVL() == getLVLtocompare()) {
            actuallypoints = 10;
            System.out.println("Masz do wydania" + actuallypoints + "punktów doświadczenia");
            System.out.println("Twoje statystyki,które możesz zmienić:");
            System.out.println("Siła:" + getStrength());
            System.out.println("Zręczność:" + getDexterity());
            System.out.println("Inteligencja:" + getIntelligence());
            System.out.println("Dodaj punkty statystyki");
            System.out.println("1.Siła");
            System.out.println("2.Zręczność");
            System.out.println("3.Inteligencja");
            System.out.println("4.Cofnij do menu");
            int userChoice = scanner.nextInt();
            if (userChoice > 0 && userChoice < 5) {
                switch (userChoice) {
                    case 1 -> {
                        setStrength(this.Strength + 5);
                        System.out.println("Siła:" + getStrength());
                        actuallypoints = actuallypoints - 5;
                        if (actuallypoints == 0) {
                            System.out.println("Nie masz już punktów");
                            game.mainMENU();
                        }
                    }
                    case 2 -> {
                        setDexterity(this.Dexterity + 5);
                        System.out.println("Zręczność:" + getDexterity());
                        actuallypoints = actuallypoints - 5;
                        if (actuallypoints == 0) {
                            System.out.println("Nie masz już punktów");
                            game.mainMENU();
                        }
                    }
                    case 3 -> {
                        setIntelligence(this.Intelligence + 5);
                        System.out.println("Inteligencja:" + getIntelligence());
                        actuallypoints = actuallypoints - 5;
                        if (actuallypoints == 0) {
                            System.out.println("Nie masz już punktów");
                            game.mainMENU();
                        }
                    }
                    case 4 -> {
                    }
                }
            } else {
                addStats();
                System.out.println("Wpisałeś złą cyfrę");
            }
        } else {
            System.out.println("Nie wzrósł Ci poziom. Brakuje " + (100 - getEXP()) + " expa do następnego poziomu");
        }
    }
    // dualstats need in duelmenu
    public void duelStats() {
        System.out.println("HP: " + getCurrentHP() + " MP: " + getCurrentMP());
    }

}
