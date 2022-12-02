public class Character {
    String name;
    double size;
    final double originalSize;
    int locationC;
    int locationR;
    Boolean canFly;
    Boolean canWalk;
    double health;
    Boolean hasPill;
    Boolean hasFungi;
    Bag bag;

     /**
     * Constructs a wonderland character.
     * @param name string that stores the characters name.
     * @param size the height of the character double in inches.
     * @param oS the immutible original height of the character double in inches.
     * @param locationC the location of the character column on the map.    
     * @param locationR the location of the character row on the map.
     */
    public Character(String n, double s, double oS, int locationC, int locationR){
        this.name = n;
        this.size = s;
        this.originalSize = oS;
        this.locationC = locationC;
        this.locationR = locationR;
        this.canFly = false;
        this.canWalk = true;
        this.health = 100;
        this.hasPill = false;
        this.hasFungi = false;
        this.bag = new Bag();

    }
}
