package com.majorsalad;
import java.util.Scanner;

class Hamburger {

    private String breadRollType;
    private Meat meat;
    private Lettuce lettuce;
    private Tomato tomato;
    private Carrot carrot;
    private double totalPrice;

    public Hamburger(String breadRollType, String meatName, int meatWeight) {
        this.breadRollType = breadRollType;
        this.meat = new Meat(meatName, meatWeight);
        lettuce = null;
        tomato = null;
        carrot = null;
    }

    public void setLettuce(String lettuceName) {
        this.lettuce = new Lettuce(lettuceName);
    }

    public void setTomato(String tomatoName) {
        this.tomato = new Tomato(tomatoName);
    }

    public void setCarrot(String carrotName) {
        this.carrot = new Carrot(carrotName);
    }

    public double getTotalPrice(){
        double lettucePrice;
        double tomatoPrice;
        double carrotPrice;

        if(this.lettuce == null){
            lettucePrice = 0;
        } else {
            lettucePrice = lettuce.getPrice();
        }

        if(this.tomato == null){
            tomatoPrice = 0;
        } else {
            tomatoPrice = tomato.getPrice();
        }

        if (this.carrot == null){
            carrotPrice = 0;
        } else {
            carrotPrice = carrot.getPrice();
        }

        this.totalPrice = meat.getPrice() + lettucePrice + tomatoPrice + carrotPrice;
        return totalPrice;
    }
}

class Meat {
    private String meatName;
    private int meatWeight;
    private double price;

    public Meat(String meatName, int meatWeight) {
        this.meatName = meatName;

        if(meatWeight < 0){
            System.out.println("You cannot have a meat weight of less than  0");
            System.out.println("Setting meat weight to zero");
            meatWeight = 0;
            this.meatWeight = meatWeight;
        } else {
            this.meatWeight = meatWeight;
        }

        if(meatWeight > 0 && meatWeight <=2){
            this.price = 1.50;
        } else if (meatWeight > 2 && meatWeight <= 5){
            this.price = 3.00;
        }
    }

    public String getMeatName() {
        return meatName;
    }

    public double getPrice() {
        return price;
    }

    public int getMeatWeight() {
        return meatWeight;
    }
}

class Lettuce {
    private String lettuceName;
    private double price;

    public Lettuce(String lettuceName) {
        this.lettuceName = lettuceName;
        this.price = 0.50;
    }

    public double getPrice() {
        return price;
    }

    public String getLettuceName() {
        return lettuceName;
    }
}

class Tomato {
    private String tomatoName;
    private double price;

    public Tomato(String tomatoName) {
        this.tomatoName = tomatoName;
        this.price = 0.50;
    }

    public double getPrice() {
        return price;
    }

    public void setTomatoName(String tomatoName) {
        this.tomatoName = tomatoName;
    }
}

class Carrot {
    private String carrotType;
    private double price;

    public Carrot(String carrotType) {
        this.carrotType = carrotType;
        this.price = 0.75;
    }

    public double getPrice() {
        return price;
    }

    public String getCarrotType() {
        return carrotType;
    }
}

class Ketchup {
    private String ketchupBrand;
    private double price;

    public Ketchup(String ketchupBrand) {
        this.ketchupBrand = ketchupBrand;
        this.price = 0.25;
    }

    public double getPrice() {
        return price;
    }

    public String getKetchupBrand() {
        return ketchupBrand;
    }
}

class secretSauce {
    private String sauceName;
    private double price;

    public secretSauce(String sauceName) {
        this.sauceName = sauceName;
        this.price = 0.50;
    }

    public void setSauceName(String sauceName) {
        this.sauceName = sauceName;
    }

    public String getSauceName() {
        return sauceName;
    }

    public double getPrice() {
        return price;
    }
}

class HealthyBurger extends Hamburger{

    private secretSauce sauce;
    private Ketchup ketchup;

    public HealthyBurger(String meatName, int meatWeight){
        super("Brown Rye", meatName, meatWeight);
        sauce = null;
        ketchup = null;
    }

    public void setSauce(String sauceName) {
        sauce = new secretSauce(sauceName);
    }

    public void setKetchup(String ketchupBrand) {
        ketchup = new Ketchup(ketchupBrand);
    }
}

class DeluxeBurger extends Hamburger{
    private String chipsBrand;
    private String drinkBrand;
    public DeluxeBurger(String meatName, int meatWeight, String chipsName, String drinkName){
        super("Normal bread", meatName, meatWeight);
        chipsBrand = chipsName;
        drinkBrand = drinkName;
    }
}


public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Scanner wordInput = new Scanner(System.in);
        int menuChoice, goAgain, addOnChoice, meatWeight;
        String breadName, meatName, lettuceName, carrotName, tomatoName, ketchupName, sauceName, chipsName, drinkName;

        Hamburger burger;
        DeluxeBurger deluxe;

        do{
            System.out.println("Would you like to order a hamburger?");
            System.out.println("======================== MENU ========================");
            System.out.println("1) Standard Hamburger -- comes with 4 add-ons");
            System.out.println("2) Healthy burger -- comes with 2 add-ons ontop of the standard, so 6 total add-ons");
            System.out.println("3) Deluxe burger -- no additional add-ons. Only the 4 standard add-ons. Comes with a bag of chips and drink");
            menuChoice = keyboard.nextInt();

            switch(menuChoice){
                case 1:
                        System.out.println("Would you like any lettuce, tomatoes, or carrots with that sandwich? None of the above or all of the above?");
                        System.out.println("0) No additions. Just the standard burger");
                        System.out.println("1) Lettuce");
                        System.out.println("2) Tomatoes");
                        System.out.println("3) Carrots");
                        System.out.println("4) Lettuce and Tomatoes");
                        System.out.println("5) Lettuce and Carrots");
                        System.out.println("6) Tomatoes and Carrots");
                        System.out.println("7) All of the above");

                        addOnChoice = keyboard.nextInt();

                                    switch(addOnChoice){
                                        case 0:
                                            System.out.println("Please enter in the type of bread that you would like");
                                            breadName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the meat you would like: ");
                                            meatName = wordInput.nextLine();
                                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                                            meatWeight = keyboard.nextInt();
                                            burger = new Hamburger(breadName,meatName,meatWeight);
                                            System.out.println("Your total price for your burger will be: $" + burger.getTotalPrice() + " dollars.");
                                            break;
                                        case 1:
                                            System.out.println("Please enter in the type of bread that you would like");
                                            breadName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the meat you would like: ");
                                            meatName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the lettuce you would like: ");
                                            lettuceName = wordInput.nextLine();
                                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                                            meatWeight = keyboard.nextInt();
                                            burger = new Hamburger(breadName,meatName,meatWeight);
                                            burger.setLettuce(lettuceName);
                                            System.out.println("Your total price for your burger will be: $" + burger.getTotalPrice() + " dollars.");
                                            break;
                                        case 2:
                                            System.out.println("Please enter in the type of bread that you would like");
                                            breadName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the meat you would like: ");
                                            meatName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the tomato you would like: ");
                                            tomatoName = wordInput.nextLine();
                                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                                            meatWeight = keyboard.nextInt();
                                            burger = new Hamburger(breadName,meatName,meatWeight);
                                            burger.setTomato(tomatoName);
                                            System.out.println("Your total price for your burger will be: $" + burger.getTotalPrice() + " dollars.");
                                            break;
                                        case 3:
                                            System.out.println("Please enter in the type of bread that you would like");
                                            breadName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the meat you would like: ");
                                            meatName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the carrots you would like: ");
                                            carrotName = wordInput.nextLine();
                                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                                            meatWeight = keyboard.nextInt();
                                            burger = new Hamburger(breadName,meatName,meatWeight);
                                            burger.setCarrot(carrotName);
                                            System.out.println("Your total price for your burger will be: $" + burger.getTotalPrice() + " dollars.");
                                            break;
                                        case 4:
                                            System.out.println("Please enter in the type of bread that you would like");
                                            breadName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the meat you would like: ");
                                            meatName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the lettuce you would like: ");
                                            lettuceName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the tomato you would like: ");
                                            tomatoName = wordInput.nextLine();
                                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                                            meatWeight = keyboard.nextInt();
                                            burger = new Hamburger(breadName,meatName,meatWeight);
                                            burger.setLettuce(lettuceName);
                                            burger.setTomato(tomatoName);
                                            System.out.println("Your total price for your burger will be: $" + burger.getTotalPrice() + " dollars.");
                                            break;
                                        case 5:
                                            System.out.println("Please enter in the type of bread that you would like");
                                            breadName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the meat you would like: ");
                                            meatName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the lettuce you would like: ");
                                            lettuceName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the carrots you would like: ");
                                            carrotName = wordInput.nextLine();
                                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                                            meatWeight = keyboard.nextInt();
                                            burger = new Hamburger(breadName,meatName,meatWeight);
                                            burger.setLettuce(lettuceName);
                                            burger.setCarrot(carrotName);
                                            System.out.println("Your total price for your burger will be: $" + burger.getTotalPrice() + " dollars.");
                                            break;
                                        case 6:
                                            System.out.println("Please enter in the type of bread that you would like");
                                            breadName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the meat you would like: ");
                                            meatName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the tomato you would like: ");
                                            tomatoName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the carrots you would like: ");
                                            carrotName = wordInput.nextLine();
                                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                                            meatWeight = keyboard.nextInt();
                                            burger = new Hamburger(breadName,meatName,meatWeight);
                                            burger.setTomato(tomatoName);
                                            burger.setCarrot(carrotName);
                                            System.out.println("Your total price for your burger will be: $" + burger.getTotalPrice() + " dollars.");
                                            break;
                                        case 7:
                                            System.out.println("Please enter in the type of bread that you would like");
                                            breadName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the meat you would like: ");
                                            meatName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the lettuce you would like: ");
                                            lettuceName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the tomato you would like: ");
                                            tomatoName = wordInput.nextLine();
                                            System.out.println("Enter in the name of the carrots you would like: ");
                                            carrotName = wordInput.nextLine();
                                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                                            meatWeight = keyboard.nextInt();
                                                burger = new Hamburger(breadName,meatName,meatWeight);
                                                burger.setLettuce(lettuceName);
                                                burger.setTomato(tomatoName);
                                                burger.setCarrot(carrotName);
                                                System.out.println("Your total price for your burger will be: $" + burger.getTotalPrice() + " dollars.");
                                            break;
                                    }
                    break;

                case 2:
                    System.out.println("The healthy burger comes with healthy ");
                    System.out.println("Would you like any lettuce, tomatoes, or carrots with that sandwich? None of the above or all of the above?");
                    System.out.println("0) No additions. Just the standard burger");
                    System.out.println("1) Lettuce");
                    System.out.println("2) Tomatoes");
                    System.out.println("3) Carrots");
                    System.out.println("4) Lettuce and Tomatoes");
                    System.out.println("5) Lettuce and Carrots");
                    System.out.println("6) Tomatoes and Carrots");
                    System.out.println("7) All of the above");

                    addOnChoice = keyboard.nextInt();

                    switch(addOnChoice) {
                        case 0:
                            System.out.println("Please enter in the type of bread that you would like");
                            breadName = wordInput.nextLine();
                            System.out.println("Enter in the name of the meat you would like: ");
                            meatName = wordInput.nextLine();
                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                            meatWeight = keyboard.nextInt();
                            burger = new Hamburger(breadName, meatName, meatWeight);
                            System.out.println("Your total price for your burger will be: $" + burger.getTotalPrice() + " dollars.");
                            break;
                        case 1:
                            System.out.println("Please enter in the type of bread that you would like");
                            breadName = wordInput.nextLine();
                            System.out.println("Enter in the name of the meat you would like: ");
                            meatName = wordInput.nextLine();
                            System.out.println("Enter in the name of the lettuce you would like: ");
                            lettuceName = wordInput.nextLine();
                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                            meatWeight = keyboard.nextInt();
                            burger = new Hamburger(breadName, meatName, meatWeight);
                            burger.setLettuce(lettuceName);
                            System.out.println("Your total price for your burger will be: $" + burger.getTotalPrice() + " dollars.");
                            break;
                        case 2:
                            System.out.println("Please enter in the type of bread that you would like");
                            breadName = wordInput.nextLine();
                            System.out.println("Enter in the name of the meat you would like: ");
                            meatName = wordInput.nextLine();
                            System.out.println("Enter in the name of the tomato you would like: ");
                            tomatoName = wordInput.nextLine();
                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                            meatWeight = keyboard.nextInt();
                            burger = new Hamburger(breadName, meatName, meatWeight);
                            burger.setTomato(tomatoName);
                            System.out.println("Your total price for your burger will be: $" + burger.getTotalPrice() + " dollars.");
                            break;
                        case 3:
                            System.out.println("Please enter in the type of bread that you would like");
                            breadName = wordInput.nextLine();
                            System.out.println("Enter in the name of the meat you would like: ");
                            meatName = wordInput.nextLine();
                            System.out.println("Enter in the name of the carrots you would like: ");
                            carrotName = wordInput.nextLine();
                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                            meatWeight = keyboard.nextInt();
                            burger = new Hamburger(breadName, meatName, meatWeight);
                            burger.setCarrot(carrotName);
                            System.out.println("Your total price for your burger will be: $" + burger.getTotalPrice() + " dollars.");
                            break;
                        case 4:
                            System.out.println("Please enter in the type of bread that you would like");
                            breadName = wordInput.nextLine();
                            System.out.println("Enter in the name of the meat you would like: ");
                            meatName = wordInput.nextLine();
                            System.out.println("Enter in the name of the lettuce you would like: ");
                            lettuceName = wordInput.nextLine();
                            System.out.println("Enter in the name of the tomato you would like: ");
                            tomatoName = wordInput.nextLine();
                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                            meatWeight = keyboard.nextInt();
                            burger = new Hamburger(breadName, meatName, meatWeight);
                            burger.setLettuce(lettuceName);
                            burger.setTomato(tomatoName);
                            System.out.println("Your total price for your burger will be: $" + burger.getTotalPrice() + " dollars.");
                            break;
                        case 5:
                            System.out.println("Please enter in the type of bread that you would like");
                            breadName = wordInput.nextLine();
                            System.out.println("Enter in the name of the meat you would like: ");
                            meatName = wordInput.nextLine();
                            System.out.println("Enter in the name of the lettuce you would like: ");
                            lettuceName = wordInput.nextLine();
                            System.out.println("Enter in the name of the carrots you would like: ");
                            carrotName = wordInput.nextLine();
                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                            meatWeight = keyboard.nextInt();
                            burger = new Hamburger(breadName, meatName, meatWeight);
                            burger.setLettuce(lettuceName);
                            burger.setCarrot(carrotName);
                            System.out.println("Your total price for your burger will be: $" + burger.getTotalPrice() + " dollars.");
                            break;
                        case 6:
                            System.out.println("Please enter in the type of bread that you would like");
                            breadName = wordInput.nextLine();
                            System.out.println("Enter in the name of the meat you would like: ");
                            meatName = wordInput.nextLine();
                            System.out.println("Enter in the name of the tomato you would like: ");
                            tomatoName = wordInput.nextLine();
                            System.out.println("Enter in the name of the carrots you would like: ");
                            carrotName = wordInput.nextLine();
                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                            meatWeight = keyboard.nextInt();
                            burger = new Hamburger(breadName, meatName, meatWeight);
                            burger.setTomato(tomatoName);
                            burger.setCarrot(carrotName);
                            System.out.println("Your total price for your burger will be: $" + burger.getTotalPrice() + " dollars.");
                            break;
                        case 7:
                            System.out.println("Please enter in the type of bread that you would like");
                            breadName = wordInput.nextLine();
                            System.out.println("Enter in the name of the meat you would like: ");
                            meatName = wordInput.nextLine();
                            System.out.println("Enter in the name of the lettuce you would like: ");
                            lettuceName = wordInput.nextLine();
                            System.out.println("Enter in the name of the tomato you would like: ");
                            tomatoName = wordInput.nextLine();
                            System.out.println("Enter in the name of the carrots you would like: ");
                            carrotName = wordInput.nextLine();
                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                            meatWeight = keyboard.nextInt();
                            burger = new Hamburger(breadName, meatName, meatWeight);
                            burger.setLettuce(lettuceName);
                            burger.setTomato(tomatoName);
                            burger.setCarrot(carrotName);
                            System.out.println("Your total price for your burger will be: $" + burger.getTotalPrice() + " dollars.");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Congrats! The deluxe burger comes with a bag of chips and a drink.");
                    System.out.println("Would you like any lettuce, tomatoes, or carrots with that sandwich? None of the above or all of the above?");
                    System.out.println("0) No additions. Just the standard burger");
                    System.out.println("1) Lettuce");
                    System.out.println("2) Tomatoes");
                    System.out.println("3) Carrots");
                    System.out.println("4) Lettuce and Tomatoes");
                    System.out.println("5) Lettuce and Carrots");
                    System.out.println("6) Tomatoes and Carrots");
                    System.out.println("7) All of the above");

                    addOnChoice = keyboard.nextInt();

                    switch(addOnChoice){
                        case 0:
                            System.out.println("Enter in the name of the meat you would like: ");
                            meatName = wordInput.nextLine();
                            System.out.println("The type of chips you'd like: ");
                            chipsName = wordInput.nextLine();
                            System.out.println("The type of drink you'd like: ");
                            drinkName = wordInput.nextLine();
                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                            meatWeight = keyboard.nextInt();
                            deluxe = new DeluxeBurger(meatName,meatWeight,chipsName,drinkName);
                            System.out.println("Your total price for your burger will be: $" + deluxe.getTotalPrice() + " dollars.");
                            break;
                        case 1:
                            System.out.println("Enter in the name of the meat you would like: ");
                            meatName = wordInput.nextLine();
                            System.out.println("Enter in the name of the lettuce you would like: ");
                            lettuceName = wordInput.nextLine();
                            System.out.println("The type of chips you'd like: ");
                            chipsName = wordInput.nextLine();
                            System.out.println("The type of drink you'd like: ");
                            drinkName = wordInput.nextLine();
                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                            meatWeight = keyboard.nextInt();
                            deluxe = new DeluxeBurger(meatName,meatWeight,chipsName,drinkName);
                            deluxe.setLettuce(lettuceName);
                            System.out.println("Your total price for your burger will be: $" + deluxe.getTotalPrice() + " dollars.");
                            break;
                        case 2:
                            System.out.println("Enter in the name of the meat you would like: ");
                            meatName = wordInput.nextLine();
                            System.out.println("Enter in the name of the tomato you would like: ");
                            tomatoName = wordInput.nextLine();
                            System.out.println("The type of chips you'd like: ");
                            chipsName = wordInput.nextLine();
                            System.out.println("The type of drink you'd like: ");
                            drinkName = wordInput.nextLine();
                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                            meatWeight = keyboard.nextInt();
                            deluxe = new DeluxeBurger(meatName,meatWeight,chipsName,drinkName);
                            deluxe.setTomato(tomatoName);
                            System.out.println("Your total price for your burger will be: $" + deluxe.getTotalPrice() + " dollars.");
                            break;
                        case 3:
                            System.out.println("Enter in the name of the meat you would like: ");
                            meatName = wordInput.nextLine();
                            System.out.println("Enter in the name of the carrots you would like: ");
                            carrotName = wordInput.nextLine();
                            System.out.println("The type of chips you'd like: ");
                            chipsName = wordInput.nextLine();
                            System.out.println("The type of drink you'd like: ");
                            drinkName = wordInput.nextLine();
                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                            meatWeight = keyboard.nextInt();
                            deluxe = new DeluxeBurger(meatName,meatWeight,chipsName,drinkName);
                            deluxe.setCarrot(carrotName);
                            System.out.println("Your total price for your burger will be: $" + deluxe.getTotalPrice() + " dollars.");
                            break;
                        case 4:
                            System.out.println("Enter in the name of the meat you would like: ");
                            meatName = wordInput.nextLine();
                            System.out.println("Enter in the name of the lettuce you would like: ");
                            lettuceName = wordInput.nextLine();
                            System.out.println("Enter in the name of the tomato you would like: ");
                            tomatoName = wordInput.nextLine();
                            System.out.println("The type of chips you'd like: ");
                            chipsName = wordInput.nextLine();
                            System.out.println("The type of drink you'd like: ");
                            drinkName = wordInput.nextLine();
                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                            meatWeight = keyboard.nextInt();
                            deluxe = new DeluxeBurger(meatName,meatWeight,chipsName,drinkName);
                            deluxe.setLettuce(lettuceName);
                            deluxe.setTomato(tomatoName);
                            System.out.println("Your total price for your burger will be: $" + deluxe.getTotalPrice() + " dollars.");
                            break;
                        case 5:
                            System.out.println("Enter in the name of the meat you would like: ");
                            meatName = wordInput.nextLine();
                            System.out.println("Enter in the name of the lettuce you would like: ");
                            lettuceName = wordInput.nextLine();
                            System.out.println("Enter in the name of the carrots you would like: ");
                            carrotName = wordInput.nextLine();
                            System.out.println("The type of chips you'd like: ");
                            chipsName = wordInput.nextLine();
                            System.out.println("The type of drink you'd like: ");
                            drinkName = wordInput.nextLine();
                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                            meatWeight = keyboard.nextInt();
                            deluxe = new DeluxeBurger(meatName,meatWeight,chipsName,drinkName);
                            deluxe.setLettuce(lettuceName);
                            deluxe.setCarrot(carrotName);
                            System.out.println("Your total price for your burger will be: $" + deluxe.getTotalPrice() + " dollars.");
                            break;
                        case 6:
                            System.out.println("Enter in the name of the meat you would like: ");
                            meatName = wordInput.nextLine();
                            System.out.println("Enter in the name of the tomato you would like: ");
                            tomatoName = wordInput.nextLine();
                            System.out.println("Enter in the name of the carrots you would like: ");
                            carrotName = wordInput.nextLine();
                            System.out.println("The type of chips you'd like: ");
                            chipsName = wordInput.nextLine();
                            System.out.println("The type of drink you'd like: ");
                            drinkName = wordInput.nextLine();
                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                            meatWeight = keyboard.nextInt();
                            deluxe = new DeluxeBurger(meatName,meatWeight,chipsName,drinkName);
                            deluxe.setTomato(tomatoName);
                            deluxe.setCarrot(carrotName);
                            System.out.println("Your total price for your burger will be: $" + deluxe.getTotalPrice() + " dollars.");
                            break;
                        case 7:
                            System.out.println("Enter in the name of the meat you would like: ");
                            meatName = wordInput.nextLine();
                            System.out.println("Enter in the name of the lettuce you would like: ");
                            lettuceName = wordInput.nextLine();
                            System.out.println("Enter in the name of the tomato you would like: ");
                            tomatoName = wordInput.nextLine();
                            System.out.println("Enter in the name of the carrots you would like: ");
                            carrotName = wordInput.nextLine();
                            System.out.println("The type of chips you'd like: ");
                            chipsName = wordInput.nextLine();
                            System.out.println("The type of drink you'd like: ");
                            drinkName = wordInput.nextLine();
                            System.out.println("Lastly, enter in the weight of your preferred meight in ounces from 0-5");
                            meatWeight = keyboard.nextInt();
                            deluxe = new DeluxeBurger(meatName,meatWeight,chipsName,drinkName);
                            deluxe.setLettuce(lettuceName);
                            deluxe.setTomato(tomatoName);
                            deluxe.setCarrot(carrotName);
                            System.out.println("Your total price for your burger will be: $" + deluxe.getTotalPrice() + " dollars.");
                            break;
                    }
                    break;

            }


            System.out.println("Would you like to make another order? Press 1 to go again, otherwise enter in any other key.");
            goAgain = keyboard.nextInt();
        }while(goAgain == 1);


    }
}
