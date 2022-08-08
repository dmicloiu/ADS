import java.util.*;

class StreetEndterm {

    // Use the fields below to store the heads and tails of the even and odd side of the street
    // Do NOT change the names of the fields or how they are initialised in the constructor!
    // You may NOT add more fields to the class.
    Node headEven;

    Node tailEven;

    Node headOdd;

    Node tailOdd;

    /**
     * Make an empty street.
     */
    public StreetEndterm() {
        headEven = new Node();
        tailEven = new Node();
        headEven.setNext(tailEven);
        tailEven.setPrev(headEven);
        headOdd = new Node();
        tailOdd = new Node();
        headOdd.setNext(tailOdd);
        tailOdd.setPrev(headOdd);
    }

    /**
     * Removes a house from the street.
     * If the house does not exist, the street should be unchanged and the method should return null.
     *
     * This method must run in O(n + m) time.
     * Here is n the number of even houses, and m the number of odd houses.
     *
     * @param houseNumber number of the house to be removed from this street, if present
     * @return if present, the removed house, otherwise null
     */
    public House removeHouse(int houseNumber) {
        if(houseNumber % 2 == 0){
            Node find = findEven(houseNumber);
            if(find == null){
                return null;
            }

            oppositeDropOdd(find.getHouse());
            Node prev = find.getPrev();
            Node next = find.getNext();

            prev.setNext(next);
            next.setPrev(prev);


            return find.getHouse();
        }

        else {
            Node find = findOdd(houseNumber);
            if(find == null){
                return null;
            }
            //System.out.println(find.getHouse().getHouseNumber());
            oppositeDropEven(find.getHouse());

            Node prev = find.getPrev();
            Node next = find.getNext();

            prev.setNext(next);
            next.setPrev(prev);


            return find.getHouse();
        }
    }

    public void oppositeDropOdd(House house){
        Node startOdd = headOdd.getNext();

        while(!startOdd.equals(tailOdd)){
            HashSet<House> neighbours = startOdd.getOpposingHouses();
            if(neighbours!=null){
                neighbours.remove(house);
            }

            startOdd = startOdd.getNext();
        }
    }

    public void oppositeDropEven(House house){
        Node startEven = headEven.getNext();

        while(!startEven.equals(tailEven)){
            //System.out.println(startEven.getHouse().getHouseNumber());
            HashSet<House> neighbours = startEven.getOpposingHouses();
            if(neighbours!=null){
                neighbours.remove(house);
            }

            startEven = startEven.getNext();
        }
    }

    public Node findEven(int houseNumber){
        Node startEven = headEven.getNext();

        while(!startEven.equals(tailEven)){
            if(startEven.getHouse().getHouseNumber() == houseNumber){
                return startEven;
            }
            startEven = startEven.getNext();
        }
        return null;
    }

    public Node findOdd(int houseNumber){
        Node startOdd = headOdd.getNext();

        while(!startOdd.equals(tailOdd)){
            if(startOdd.getHouse().getHouseNumber() == houseNumber){
                return startOdd;
            }
            startOdd = startOdd.getNext();
        }
        return null;
    }

    /**
     * Puts all the houses in the street in a list in increasing order of house number.
     *
     * This method must run in O(n+m) time.
     * Here n is the number of even houses, and m is the number of odd houses.
     *
     * @return a list of all the houses in the street in increasing order of house number
     */
    public List<House> collectAllHouses() {
        List<House> answer = new ArrayList<>();

        Node startEven = headEven.getNext();
        Node startOdd = headOdd.getNext();

        while(!startEven.equals(tailEven) && !startOdd.equals(tailOdd)){
            if(startEven.getHouse().getHouseNumber()<startOdd.getHouse().getHouseNumber()){

                answer.add(startEven.getHouse());
                startEven = startEven.getNext();
            }
            else {
                answer.add(startOdd.getHouse());
                startOdd = startOdd.getNext();
            }
        }

        while(!startEven.equals(tailEven)){

            answer.add(startEven.getHouse());
            startEven = startEven.getNext();
        }
        while(!startOdd.equals(tailOdd)){

            answer.add(startOdd.getHouse());
            startOdd = startOdd.getNext();
        }

        return answer;




    }

    /**
     * Gets the number of even numbered houses in the street.
     *
     * @return the number of houses with an even house number
     */
    public int getNumEven() {
        Node even = headEven.getNext();
        int nr = 0;
        while(!even.equals(tailEven)){
            nr++;
            even = even.getNext();
        }

        return nr;
    }
}

class House {

    private int houseNumber;

    public House(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return houseNumber == house.houseNumber;
    }

    @Override
    public String toString() {
        return "House{" + houseNumber + '}';
    }
}

class Node {

    private House house;

    private Node prev;

    private Node next;

    private HashSet<House> opposingHouses = new HashSet<>();

    public Node(House house) {
        this.house = house;
    }

    public Node(House house, Node prev, Node next) {
        this.house = house;
        this.prev = prev;
        this.next = next;
    }

    public Node() {}

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public HashSet<House> getOpposingHouses() {
        return opposingHouses;
    }

    public void setOpposingHouses(HashSet<House> opposingHouses) {
        this.opposingHouses = opposingHouses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(house, node.house)
                && Objects.equals(prev, node.prev)
                && Objects.equals(next, node.next)
                && Objects.equals(opposingHouses, node.opposingHouses);
    }

    @Override
    public String toString() {
        return "Node{" + house + ", opposingHouses=" + opposingHouses.toString() + '}';
    }
}


