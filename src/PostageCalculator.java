public class PostageCalculator {
    public PostageCalculator(){}

    public static double calculatePostage(String zip1, String zip2, double weight) {
        String count1 = zip1.substring(0, 3);
        String count2 = zip2.substring(0, 3);
        double calcuCounty = Integer.parseInt(count1) - Integer.parseInt(count2);
        if (calcuCounty < 0) {
            calcuCounty = Integer.parseInt(count2) - Integer.parseInt(count1);
        }
        double countyPrice = calcuCounty / 100;
        double addedCharge = 0;
        double tempWeight = weight;
        while (tempWeight > 40) {
              tempWeight -= 0.1;
              addedCharge += 0.1;
        }
        int add5 = 0;
        double tempWeigh2 = weight;
        while (tempWeigh2 >= 0.1) {
            tempWeigh2 -= 0.1;
            add5++;
        }
        return 3.75 + (add5 * 0.05) + countyPrice + addedCharge;
    }

    public static double calculatePostage(Address addr1, Address addr2, double weight) {
        String zip1 = addr1.getZipCode();
        String zip2 = addr2.getZipCode();
        return calculatePostage(zip1, zip2, weight);
    }

    public static double calculatePostage(Package pack) {
        Address addr1 = pack.getOrigin();
        Address addr2 = pack.getDestination();
        double weight = pack.getWeight();
        return calculatePostage(addr1, addr2, weight);
    }

    public static double additionalCharges(double length, double width, double height) {
        double volume = length * width * height;
        if (volume > 36) {
            double additionalCharge = 0;
            double tempVolume = volume;
            while (tempVolume > 36) {
                additionalCharge += 0.1;
                tempVolume -= 1;
            }
            return additionalCharge;
        }
        return 0;
    }
}
