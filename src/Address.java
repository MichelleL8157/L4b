public class Address {
    private int streetNum;
    private String streetName;
    private int apartNum;
    private String city;
    private String state;
    private int zipCode;

    public Address(int streetNum, String streetName, int apartNum, String city, String state, int zipCode) {
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.apartNum = apartNum;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(Address address) {
        streetNum = address.getStreetNum();
        streetName = address.getStreetName();
        apartNum = address.getApartNum();
        city = address.getCity();
        state = address.getState();
        zipCode = address.getZipCode();
    }

    public int getStreetNum() {
        return streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getApartNum() {
        return apartNum;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public int getZipCode() {
        return zipCode;
    }

    public Address(String address) {
        String[] temp = new String[5];
        int index = 0;
        while (address.indexOf(" ") != -1) {
            if (address.substring(0, 1) != ",") {
                String word = address.substring(0, address.indexOf(" "));
                temp[index] = word;
                address = address.substring(address.indexOf(" ") + 1);
            }
            else {
                if (index == 3) {
                    address = address.substring(1);
                    String word = address.substring(0, address.indexOf(","));
                    temp[index] = word;
                }
                if (index == 4) {
                    String word = address.substring(2, address.indexOf(" "));
                    temp[index] = word;
                }
            }
            index++;
        }
        streetNum = Integer.parseInt(temp[0]);
        streetName = temp[1];
        apartNum = Integer.parseInt(temp[2]);
        city = temp[3];
        state = temp[4];
        zipCode = Integer.parseInt(temp[5]);
    }

    public String toString() {
        return streetNum + " " + streetName + " " + apartNum + ", " + city + ", " + state + " " + zipCode;
    }

    private boolean sameThing(Address another) {
        if (toString().equals(another.toString())){
            return true;
        }
        return false;
    }
}
