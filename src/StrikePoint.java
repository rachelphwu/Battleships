public class StrikePoint {
    private int x;
    private int y;
    private boolean hitShip = false;

    private String symbol = "O  ";

    /**Constructor for a StrikePoint. Takes two ints for x (horizontal) and y (vertical) coordinates. hitShip is
    * determined and set later by comparing a guess with a Ship's coordinates. */
    StrikePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*Getters & Setters*/
    public int getX(){return x;}
    public int getY(){return y;}
    public boolean getHitShip(){return hitShip;}
    public void setHitShip(boolean hitShip) {this.hitShip = hitShip;}
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}

    public String getSymbol() {return symbol;}

    public void updateSymbol(String o){
        //Implementation dependent on Ship: is the name of the ship passed in? Do we hold boolean indicating if
        //StrikePoint is on a ship?
    }

    /**Override of equals, checking equality of X and Y. Ignores hitShip, because likely, that's what equals method is
     * being used to determine.*/
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof StrikePoint)) {
            return false;
        }
        else return this.x == ((StrikePoint) obj).x && this.y == ((StrikePoint) obj).y;

    }

    /*Override of hashcode, as equals has been overridden.*/
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}


