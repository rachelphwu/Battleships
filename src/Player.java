import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Ship> shipList = new ArrayList<>();
    private ArrayList<StrikePoint> shootRecord = new ArrayList<>();
    private int hit;
    private Board territoryBoard;
    private Board attackBoard;

    public Player(String name, Board territoryBoard, Board attackBoard) {
        this.name = name;
        this.territoryBoard = territoryBoard;
        this.attackBoard = attackBoard;
        this.shipList = new ArrayList<>();
        this.shootRecord = new ArrayList<>();
    }

    /*
    Purpose: avoid repeated name, uppercase, number and symbol
   */
    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public Board getTerritoryBoard() {
        return territoryBoard;
    }

    public Board getAttackBoard() {
        return attackBoard;
    }


    /*
   Purpose: get one of the ship
    */
    public Ship getShip(int i) {
        return shipList.get(i);
    }

    /*
    Purpose: get all ships
     */
    public ArrayList<Ship> getShipList() {
        return shipList;
    }


    /*
    Purpose: Add ship to the shipList
    Input: coordinates
    Output: boolean */

    //check if the shipList contains the ship
    //if not, add it to the shipList
    public void placeShip(Ship s) {
        if (!shipList.contains(s)) {
            shipList.add(s);
        }
    }

    /*
   Purpose: check against intersection to make sure it is an empty space for placing ship
   Input: coordinates
   Output: boolean */

    //input strikePoint
    //return true if input does not match strikePoints of other ships
    public boolean noOverLap(StrikePoint p) {
        for (Ship s : shipList) {
            if (s.getLocations().equals(p)) {
                return false;
            }
        }
        return true;
    }


     /*
  Purpose: check against intersection to make sure it has not been shot before
  Input: coordinates
  Output: boolean */

    //input coordinates
    //return true if
    public boolean noRepeatedShoot(StrikePoint newPoint) {
        /*TODO - I'm guessing this was meant to be a for-each loop, so I've put that in. I also changed the 'else' here
           to print out newPoint. At present, this for-each loop adds a new point to the shootRecord equal to newPoint
           each time it doesn't find a match. The function also needs return statements for each case. I would use this
           to exit the for-each loop and the method as a whole if/when a match is found (false) and return true when a match
           is not found.
        */
        for (StrikePoint p:
        shootRecord){
            //this is
            if (!newPoint.equals(p)) {
                shootRecord.add(newPoint);
            } else {
                System.out.println(newPoint + " has been shot before. Try again.");
            }
        }
    }


    /*Purpose:
    - Check list of ships against the guesses, pass result to ship class and to board class, update if ship is sunk
    - With a boolean method to check if game has been won
   Input: coordinates
   Output: boolean */
    public String checkHit(StrikePoint p) {
        for (Ship s : shipList) {
            if (s.().equals(p)) {
                hit++;
                /*TODO 5 is a magic number - please replace with a variable. It would be wise to code as if the number
                   of ships could vary; perhaps the number of ships in the shipList could be useful here. */
                if (hit == 5) {
                    return "Victory! You hit the last ship and won the game.";
                }
                return "Hit";
            }
        }
        return "Miss";
    }
}
