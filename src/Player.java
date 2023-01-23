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
        (StrikePoint p:
        shootRecord){
            if (!newPoint.equals(p)) {
                shootRecord.add(newPoint);
            } else {
                System.out.println(strikePoint + " has been shot before. Try again.");
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
                higetLocationst++;
                if (hit == 5) {
                    return "Victory! You hit the last ship and won the game.";
                }
                return "Hit";
            }
        }
        return "Miss";
    }
}
