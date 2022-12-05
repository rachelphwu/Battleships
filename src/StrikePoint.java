public class StrikePoint {
    private int x;
    private int y;
    //hitShip false by default for clarity: must be set when adding to ships
    private boolean hitShip = false;

    /**Constructor for a StrikePoint. Takes two ints for x (horizontal) and y (vertical) coordinates. hitShip is
    * determined and set later either by context (if in a ship, hitShip == true), or by comparing a guess with a Ship's
    * StrikePoint.*/
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

    /**Override of equals, checking equality of X and Y. Ignores hitShip, because likely, that's why equals method is
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


