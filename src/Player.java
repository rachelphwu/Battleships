import java.util.ArrayList;

public class Player {
    //TODO Rachel: define Player class. Needs a name field, and getters & setters
    //TODO Rachel: some kind of validation needed in the constructor: disallow numbers in name, for example? Any other criteria?


    private String name;
    private ArrayList<Ship> shipList = new ArrayList<>();
    private ArrayList<int[][]> shootRecord = new ArrayList<>();
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
    public boolean placeShip(Ship s) {
        if(!shipList.contains(s)){
            shipList.add(s);
        }
    }

    /*
   Purpose: check against intersection to make sure it is an empty space for placing ship
   Input: coordinates
   Output: boolean */

    //input strikePoint
    //return true if input does not match strikePoints of other ships
    public boolean noOverLap(int[][] strikePoint) {
        for (Ship s : shipList) {
            return s.getStrikePoint() != strikePoint;
        }
    }


     /*
  Purpose: check against intersection to make sure it has not been shot before
  Input: coordinates
  Output: boolean */

    //input coordinates
    //return true if
    public boolean noRepeatedShoot(int[][] newStrikePoint) {
         (int[][] strikePoint : shootRecord) {
            if(!shootRecord.contains(newStrikePoint)){
                return true;
            }
            else{
                System.out.println(strikePoint + " has been shot before. Try again.");
            }
        }
    }

    /*Purpose: add coordinates to shoot record
    Input: coordinates
    Output: X */
    public void addShootRecord(int[][] strikePoint){
            shootRecord.add(strikePoint);
        }


    /*Purpose: Check list of ships against the guesses, pass result to ship class and to board class, update if ship is sunk
   Input: coordinates
   Output: boolean */
    public boolean checkHit(int[][] strikePoint) {
        for (Ship s : shipList) {
            return s.getStrikePoint() = strikePoint;
        }
    }


    /* ignore
    Purpose: update list if ship is sunk
    Input: coordinates
    Output: x

    //find the ship that has been sunk
    //change its location to
    public void ArrayList<Ship> setShipList(int[][]){

    }
    */
}
