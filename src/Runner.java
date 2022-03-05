import javax.security.auth.callback.PasswordCallback;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        /*//Testing if the methods work:"
        String stNum = getNum();
        String streetName = getStreet();
        String apt = getApt();
        String cityAbbrev = getCity();
        String stateAbbrev = getState();
        String zipCode = getZipCode();
        String wholeThing = stNum + " " + streetName + " " + apt + ". " + cityAbbrev + ". " + stateAbbrev + " " + zipCode;
        if (apt.equals("")) {
            wholeThing = stNum + " " + streetName + ". " + cityAbbrev + ". " + stateAbbrev + " " + zipCode;
        }
        System.out.println("St Num = " + stNum);
        System.out.println("Street Name = " + streetName);
        System.out.println("apt = " + apt);
        System.out.println("city = " + cityAbbrev);
        System.out.println("state = " + stateAbbrev);
        System.out.println("zipcode = " + zipCode);
        System.out.println(wholeThing);

        Address addr1 = new Address(stNum, streetName , apt, cityAbbrev, stateAbbrev, zipCode);
        System.out.println("1st constructor: " + addr1.toString());
        Address addr2 = new Address(addr1);
        System.out.println("2nd constructor: " + addr2.toString());
        Address addr3 = new Address(wholeThing);
        System.out.println("3rd constructor: " + addr3.toString());
        Address destination = new Address(getNum(), getStreet(), getApt(), getCity(), getState(), getZipCode()); //using 1st constructor
        System.out.println("Destination: " + destination.toString());
        System.out.println();
        System.out.println("same address: expected- true, result- " + addr1.sameThing(addr3));
        System.out.println("same address: expected- false, result- " + addr2.sameThing(destination));

        int randMultiplier = (int) (Math.random() * 10);
        double weight = (int) (Math.random() * 51) + 0.1 + (0.1 * randMultiplier);
        PostageCalculator postCal = new PostageCalculator();
        double first = postCal.calculatePostage(addr1, destination, weight);
        System.out.println("1st ver. method: " + first);
        System.out.println("2nd ver. method: " + postCal.calculatePostage(addr1.getZipCode(), destination.getZipCode(), weight));
        Package post = new Package(addr1, destination, weight);
        System.out.println("3rd ver. method: " + postCal.calculatePostage(post));
        */
        //Addresses:
        Scanner scanString = new Scanner(System.in);
        PostageCalculator postCal = new PostageCalculator();
        System.out.println("This shipping simulation will have 1 origin address and 1 destination address\nbut you can add as many packages as you would like!");
        Address origin = new Address(getNum(), getStreet(), getApt(), getCity(), getState(), getZipCode());
        System.out.print(origin.toString() + "\nEnter yes if you want this to be the origin address: ");
        String confirmAdd1 = scanString.nextLine().toLowerCase();
        while (!confirmAdd1.equals("yes")) {
            origin = new Address(getNum(), getStreet(), getApt(), getCity(), getState(), getZipCode());
            System.out.print(origin.toString() + "\nEnter yes if you want this to be the origin address: ");
            confirmAdd1 = scanString.nextLine().toLowerCase();
        }
        Address destination = new Address(getNum(), getStreet(), getApt(), getCity(), getState(), getZipCode());
        System.out.print(destination.toString() + "\nEnter yes if you want this to be the destination address: ");
        String confirmAdd2 = scanString.nextLine().toLowerCase();
        while (!confirmAdd2.equals("yes")) {
            destination = new Address(getNum(), getStreet(), getApt(), getCity(), getState(), getZipCode());
            System.out.print(destination.toString() + "\nEnter yes if you want this to be the destination address: ");
            confirmAdd2 = scanString.nextLine().toLowerCase();
        }
        //Packages:
        Scanner scanDouble = new Scanner(System.in);
        ArrayList<Package> packages = new ArrayList<Package>();
        ArrayList<Double> addedCost = new ArrayList<Double>();
        String userContinue = "yes";
        while (userContinue.equals("yes")) {
            userContinue = "no";
            System.out.println("Please give me some information about the package!\nPlease keep in mind that all sides of the pacakge must be at least 2 inches.");
            System.out.print("Length of Package: ");
            double userLen = scanDouble.nextDouble();
            System.out.print("Width of Package: ");
            double userWid = scanDouble.nextDouble();
            System.out.print("Height of Package: ");
            double userHei = scanDouble.nextDouble();
            while (userLen < 2 || userWid < 2 || userHei < 2) {
                System.out.println("Please enter a value at least 2 for all dimensions.");
                System.out.print("Length of Package: ");
                userLen = scanDouble.nextDouble();
                System.out.print("Width of Package: ");
                userWid = scanDouble.nextDouble();
                System.out.print("Height of Package: ");
                userHei = scanDouble.nextDouble();
            }
            System.out.print("What is the weight of the package?\nPlease keep in mind that the package must be at least 0.1 lbs.\nWeight: ");
            double weight = scanDouble.nextDouble();
            while (weight < 0.1) {
                System.out.print("Please enter a weight of at least 0.1 lbs\nWeight: ");
                weight = scanDouble.nextDouble();
            }
            packages.add(new Package(origin, destination, weight));
            addedCost.add(postCal.additionalCharges(userLen, userWid, userHei));
            System.out.print("That is all for one package, would you like to add another package?\nEnter yes if so: ");
            userContinue = scanString.nextLine().toLowerCase();
        }
        //Total Shipping cost of all packages
        System.out.println("The details of the shipment are:\n");
        double total = 0;
        for (int i = 0; i != packages.size(); i++) {
            System.out.println("Package " + (i + 1) + ":\nThe details of this shipment are:");
            System.out.println("Origin: " + packages.get(i).getOrigin());
            System.out.println("Destination: " + packages.get(i).getDestination());
            double baseCost = postCal.calculatePostage(packages.get(i).getOrigin(), packages.get(i).getDestination(), packages.get(i).getWeight());
            double addedCharge = addedCost.get(i);
            total += baseCost + addedCharge;
            System.out.println("Total Cost: $" + (baseCost + addedCharge) + "\n");
        }
        System.out.print("The total cost of the shipment will be: $" + total);
    }
    public static String getNum() {
        String capitalLet = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String stNum = "";
        if ((int) (Math.random() * 2) == 1) {
            //4 nums
            int firstNum = (int) (Math.random() * 9) + 1;
            stNum += firstNum;
            for (int i = 0; i != 3; i++) {
                int randNum = (int) (Math.random() * 10);
                stNum += randNum;
            }
        } else {
            //3 nums
            int firstNum = (int) (Math.random() * 9) + 1;
            stNum += firstNum;
            for (int i = 0; i != 2; i++) {
                int randNum = (int) (Math.random() * 10);
                stNum += randNum;
            }
        }
        if ((int) (Math.random() * 2) == 1) {
            int letterSt = (int) (Math.random() * 26);
            stNum += capitalLet.substring(letterSt, letterSt + 1); // ****** StreetNumber + Letter
        }
        return stNum;
    }

    public static String getStreet() {
        String capitalLet = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String lowerLet = "qwertyuiopasdfghjklzxcvbnm";
        String street = ""; // ******StreetNumber
        int randLet = (int) (Math.random() * 26);
        street += capitalLet.substring(randLet, randLet + 1);
        int streetNameLength = (int) (Math.random() * 10); //road/st/etc. name must be less than 10 letters for convienience
        for (int letter = 0; letter != streetNameLength; letter++) {
            int randCityLet = (int) (Math.random() * 26);
            street += lowerLet.substring(randCityLet, randCityLet + 1);
        }
        String[] roadNames = {"St", "Av", "Ln", "Bl", "Rd", "Blvd", "Pl", "Pkwy"};
        int randRoad = (int) (Math.random() * 8);
        street += " " + roadNames[randRoad]; // ****** Street Name pt2.
        return street;
    }

    public static String getApt() {
        String capitalLet = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String apt = ""; // ****** OPTIONAL apt num
        if ((int) (Math.random() * 2) == 1) {
            int aptNum = (int) (Math.random() * 99) + 1; //set max apt. num to 99 double digits
            apt += "Apt " + aptNum;
            if ((int) (Math.random() * 2) == 1) {
                int letIndex = (int) (Math.random() * 26);
                String addLet = capitalLet.substring(letIndex, letIndex + 1);
                apt += addLet;
            }
        }
        return apt;
    }

    public static String getCity() {
        String capitalLet = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String lowerLet = "qwertyuiopasdfghjklzxcvbnm";
        String cityAbbrev = "";
        int randCityFirstLet = (int) (Math.random() * 26);
        cityAbbrev += capitalLet.substring(randCityFirstLet, randCityFirstLet + 1);
        int cityLength = (int) (Math.random() * 10); //city name must be less than 10 letters for convienience
        for (int cityLets = 0; cityLets != cityLength; cityLets++) {
            int randCityLet = (int) (Math.random() * 26);
            cityAbbrev += lowerLet.substring(randCityLet, randCityLet + 1);
        }
        return cityAbbrev;
    }

    public static String getState() {
        String capitalLet = "QWERTYUIOPASDFGHJKLZXCVBNM";
        int firstLetStateIndex = (int) (Math.random() * 26);
        int secondLetStateIndex = (int) (Math.random() * 26);
        String stateAbbrev = capitalLet.substring(firstLetStateIndex, firstLetStateIndex + 1) + capitalLet.substring(secondLetStateIndex, secondLetStateIndex + 1);
        return stateAbbrev;
    }

    public static String getZipCode() {
        int nationalArea = (int) (Math.random() * 10);
        int sectionalCenter = (int) (Math.random() * 100);
        String addZero1 = "";
        if (sectionalCenter < 10) {
            addZero1 = "0";
        }
        int postOffice = (int) (Math.random() * 100);
        String addZero2 = "";
        if (postOffice < 10) {
            addZero2 = "0";
        }
        String part1 = nationalArea + "";
        String part2 = addZero1 + sectionalCenter;
        String part3 = addZero2 + postOffice;
        String zipCode = part1 + part2 + part3;
        return zipCode;
    }
}
