public class PostageCalculator {
    public static double calculatePostage(int zip1, int zip2, double weight) {
        int add5 = 0;
        while (weight != 0) {
            weight -= 0.1;
            add5++;
        }
        String count1 = (zip1 + "").substring(0, 3);
        String count2 = (zip2 + "").substring(0, 3);
        double calcuCounty = Integer.parseInt(count1) - Integer.parseInt(count2);
        if (calcuCounty < 0) {
            calcuCounty = Integer.parseInt(count2) - Integer.parseInt(count1);
        }
        double countyPrice = calcuCounty / 100;
        return 3.75 + (add5 * 0.05) + countyPrice;
    }

    public static double calculatePostage(Address addr1, Address addr2, double weight) {
        int zip1 = addr1.getZipCode();
        int zip2 = addr2.getZipCode();
        return calculatePostage(zip1, zip2, weight);
    }

    public static double calculatePostage(Package pack) {
        Address addr1 = pack.getOrigin();
        Address addr2 = pack.getDestination();
        double weight = pack.getWeight();
        return calculatePostage(addr1, addr2, weight);
    }
}
