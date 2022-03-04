public class Address {
    private String streetNum;
    private String streetName;
    private String apartNum; //optional
    private String city;
    private String state;
    private int zipCode;

    public Address(String streetNum, String streetName, String apartNum, String city, String state, int zipCode) {
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

    public String getStreetNum() {
        return streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getApartNum() {
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
        String addNum = address.substring(0, address.indexOf(" "));
        address = address.substring(address.indexOf(" ") + 1);
        String nameSt = address.substring(0, address.indexOf(" "));
        address = address.substring(address.indexOf(" ") + 1);
        String formSt = address.substring(0, address.indexOf(" "));
        address = address.substring(formSt.length() + 1);
        String aptNum = "";
        if (formSt.indexOf(".") == -1) {
            aptNum = address.substring(0, address.indexOf(" "));
            address = address.substring(address.indexOf(" ") + 1);
            String aptRoom = address.substring(0, address.indexOf(" "));
            aptNum += " " + aptRoom;
        }
        String city = address.substring(0, address.indexOf("."));
        address = address.substring(address.indexOf(".") + 2);
        String state = address.substring(0, address.indexOf(" "));
        address = address.substring(address.indexOf(" ") + 1);
        String zip = address;
        streetNum = addNum;
        streetName = nameSt + " " + formSt;
        apartNum = aptNum;
        this.city = city;
        this.state = state;
        zipCode = Integer.parseInt(zip);

        /*
        String[] temp = new String[8];
        int index = 0;
        while (address.indexOf(" ") != -1) {
            if (address.substring(0, 1) != ".") {
                String word = address.substring(0, address.indexOf(" "));
                temp[index] = word;
            }
            else {
                if (index == 4) {
                    address = address.substring(1);
                    String word = address.substring(0, address.indexOf(","));
                    temp[index] = word;
                }
                if (index == 5) {
                    String word = address.substring(2, address.indexOf(" "));
                    temp[index] = word;
                }
            }
            address = address.substring(address.indexOf(" ") + 1);
            index++;
        }
        streetNum = temp[0];
        streetName = temp[1];
        apartNum = temp[2];
        city = temp[3];
        state = temp[4];
        zipCode = Integer.parseInt(temp[5]);
         */
    }

    public String toString() {
        if (apartNum.equals("")) {
            return streetNum + " " + streetName +  ". " + city + ". " + state + " " + zipCode;
        }
        return streetNum + " " + streetName + " " + apartNum + ". " + city + ". " + state + " " + zipCode;
    }

    private boolean sameThing(Address another) {
        if (toString().equals(another.toString())){
            return true;
        }
        return false;
    }
}
