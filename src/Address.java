public class Address {
    private String streetNum;
    private String streetName;
    private String apartNum; //optional
    private String city;
    private String state;
    private String zipCode;

    public Address(String streetNum, String streetName, String apartNum, String city, String state, String zipCode) {
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

    public String getZipCode() {
        return zipCode;
    }

    public Address(String address) { //def not the best but work w this 4now
        String addNum = address.substring(0, address.indexOf(" "));
        address = address.substring(address.indexOf(" ") + 1);
        String nameSt = address.substring(0, address.indexOf(" "));
        address = address.substring(address.indexOf(" ") + 1);
        String formSt = address.substring(0, address.indexOf(" "));
        address = address.substring(formSt.length() + 1);
        String aptNum = "";
        if (formSt.indexOf(".") == -1) { //there is an apt
            aptNum = address.substring(0, address.indexOf(" "));
            String aptRoom = address.substring(address.indexOf(" ") + 1, address.indexOf("."));
            aptNum += " " + aptRoom;
            address = address.substring(address.indexOf(".") + 2);
        } else {
            formSt = formSt.substring(0, formSt.length() - 1);
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
        zipCode = zip;
    }

    public String toString() {
        if (apartNum.equals("")) {
            return streetNum + " " + streetName +  ". " + city + ". " + state + " " + zipCode;
        }
        return streetNum + " " + streetName + " " + apartNum + ". " + city + ". " + state + " " + zipCode;
    }

    public boolean sameThing(Address another) {
        if (toString().equals(another.toString())){
            return true;
        }
        return false;
    }
}
