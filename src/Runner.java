public class Runner {
    public static void main(String[] args) {
        String capitalLet = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String lowerLet = "qwertyuiopasdfghjklzxcvbnm";
        String stNum = ""; // ******StreetNumber
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
        int randLet = (int) (Math.random() * 26);
        String streetName = capitalLet.substring((int) (randLet, randLet + 1); // ****** Street Name
        String[] roadNames = {"St", "Av", "Ln", "Bl", "Rd", "Blvd", "Pl", "Pkwy"};
        int randRoad = (int) (Math.random() * 8);
        stNum += roadNames[randRoad]; // ****** Street Name pt2.
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
        String cityAbbrev = ""; // ****** city abbrev
        int randCityFirstLet = (int) (Math.random() * 26);
        cityAbbrev += capitalLet.substring(randCityFirstLet, randCityFirstLet + 1);
        int cityLength = (int) (Math.random() * 15); //city name must be less than 15 letters for convienience
        for (int cityLets = 0; cityLets != cityLength; cityLets++) {
            int randCityLet = (int) (Math.random() * 26);
            cityAbbrev += lowerLet.substring(randCityLet, randCityLet + 1);
        }
        int firstLetStateIndex = (int) (Math.random() * 26);
        int secondLetStateIndex = (int) (Math.random() * 26);
        String stateAbbrev = capitalLet.substring(firstLetStateIndex, firstLetStateIndex + 1) + capitalLet.substring(secondLetStateIndex, secondLetStateIndex + 1);

        Address addr1 = new Address(stNum, streetName , apt, cityAbbrev, stateAbbrev, zipCode);

    }
    public static int getZipCode() {
        String zipCodeString = "";
        int first3ZipNum = (int) (Math.random() * 1000);

        boolean generatedAreBad = true;
        String[] forbiddenZips = {"000", "002", "003", "004", "099", "192", "213", "269", "343", "345", "348", "353", "399", "419", "428", "429", "459", "509", "517", "518", "519", "529", "536", "552", "568", "578", "579", "589", "621", "632", "642", "643", "649", "659", "663", "682", "694", "695", "696", "697", "698", "699", "702", "709", "715", "732", "742", "817", "818", "819", "839", "842", "848", "849", "858", "861", "862", "866", "867", "868", "869", "872", "876", "886", "887", "888", "892", "896", "899", "909", "929", "987"};
        while (generatedAreBad) {
            generatedAreBad = false;
            for (int forbiddenZip: forbiddenZips) {
                if (forbiddenZip.equals(first3ZipNum)) {
                    first3ZipNum = (int) (Math.random() * 1000);
                    generatedAreBad = true;
                    break;
                }
            }
        }
        for (int zipInd = 0; zipInd != 2; zipInd++) {
            int otherNum = (int) (Math.random() * 10);
            zipCodeString += otherNum;
        }
        int zipCode = Integer.parseInt(zipCodeString);

    }
}
