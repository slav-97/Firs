package by.tut.z4;

public class Bank {
    private int fifties;
    private int hundreds;
    private int twenties;

    public final static String FIFTIES = "fifties";
    public final static String HUNDREDS = "hundreds";
    public final static String TWENTIES = "twenties";

    public final static int fiftiesAmount = 20;
    public final static int hundredsAmount = 20;
    public final static int twentiesAmount = 20;

    public static void main(String[] args) {
        Bank atm = new Bank(10, 20,  30);
        atm.addMoney("hundreds", 9);
        System.out.println(atm.getMoney(1000));
    }

    public Bank(int hundreds, int twenties, int fifties) {
        this.hundreds = hundreds;
        this.twenties = twenties;
        this.fifties = fifties;
    }

    public int getTwenties() {
        return twenties;
    }

    public int getFifties() {
        return fifties;
    }

    public int getHundreds() {
        return hundreds;
    }

    public void setTwenties(int twenties) {
        this.twenties = twenties;
    }

    public void setFifties(int fifties) {
        this.fifties = fifties;
    }

    public void setHundreds(int hundreds) {
        this.hundreds = hundreds;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "twenties=" + twenties +
                "fifties=" + fifties +
                ", hundreds=" + hundreds +
                '}';
    }

    public void addMoney(String type, int amount) {
        if (getTwenties() + amount < twentiesAmount || getFifties() + amount < fiftiesAmount || getHundreds() + amount < hundredsAmount) {
            switch (type) {
                case (TWENTIES):
                    twenties = getTwenties() + amount;
                    break;
                case (FIFTIES):
                    fifties = getFifties() + amount;
                    break;
                case (HUNDREDS):
                    hundreds = getHundreds() + amount;
                    break;
            }
        } else {
            System.out.println("Невозможно добавить купюру");
        }


    }

    public boolean getMoney(int sum) {
        int havesum =  getTwenties() * 20 + getFifties() * 50 + getHundreds() * 100;
        if (havesum < sum) {
            return false;
        } else {
            if (sum % 20 != 0) {
                System.out.println("Невозможно получить данную сумму,купюры только 20 50 100");
                return false;
            } else {
                int amounthundred = sum / 100;
                int amountfift = (sum - amounthundred * 50) / 50;
                int amounttwent = (sum - amounthundred * 50 - amountfift * 20) / 20;
                System.out.println("Кол-во 100:  " + amounthundred + "Кол-во 50:  " + amountfift + "Кол-во 20:  " + amounttwent);
            }
            return true;
        }
    }
}
