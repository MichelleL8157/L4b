public class Package {
    private Address origin;
    private Address destination;
    private double weight;

    public Package(Address origin, Address destination, double weight) {
        this.origin = origin;
        this.destination = destination;
        if (weight < 0.1) {
            this.weight = 0;
        }
        else {
            this.weight = weight;
        }
    }

    public Address getOrigin() {
        return origin;
    }

    public Address getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }
}
