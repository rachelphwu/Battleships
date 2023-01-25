import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Ship> shipList = new ArrayList<>();
    private ArrayList<StrikePoint> shootRecord = new ArrayList<>();
    private int lives;
    private Board territoryBoard;
    private Board attackBoard;

    public Player(String name, Board territoryBoard, Board attackBoard) {
        this.name = name;
        this.territoryBoard = territoryBoard;
        this.attackBoard = attackBoard;
        this.shipList = new ArrayList<>();
        this.shootRecord = new ArrayList<>();
        lives = 5;
    }

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
    Input: StrikePoint
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
   Input: StrikePoint
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
  Purpose: Make sure the player does not shoot repeatedly before shooting.
  The new point will be added to the player's shootRecord if the location has not been shot before.

  Input: StrikePoint
  Output: void

- input newPoint
- if newPoint equals to a point existing in shootRecord, print out notification and return;
- else, add the newPoint to shootRecord

  */

    public void addShootRecord(StrikePoint newPoint) {
        /*TODO - I'm guessing this was meant to be a for-each loop, so I've put that in. I also changed the 'else' here
           to print out newPoint. At present, this for-each loop adds a new point to the shootRecord equal to newPoint
           each time it doesn't find a match. The function also needs return statements for each case. I would use this
           to exit the for-each loop and the method as a whole if/when a match is found (false) and return true when a match
           is not found.
        */

        for (StrikePoint p : shootRecord) {
            //this is
            if (newPoint.equals(p)) {
                System.out.println(newPoint + " has been shot before. Try again.");
                return;
            }
        }
        shootRecord.add(p);
    }



    /*Purpose:
    - Check the player's list of ships against the enemy's guess.
    - whenever the player got hit, his/her live counter will minus one.

   Input: StrikePoint
   Output: boolean */

    /*TODO this method is a bit confused: it declares a winner if a ship receives 5 hits! A player in battleships wins
     *  when all of his opponent's ships have been sunk. Also, is shipList the player's list or the enemy's? If it's the
     * players', the player probably shouldn't win if their own ship has been sunk. Returning a String is also not a
     * good idea: instead we need to modify the StrikePoint present in the ship in question so the boolean for a hit
     * reads true.
     * */

    /* Reply from Rachel:
       The ship list belongs to the player.

       This method is for the player to check enemy's attack against his/her ship list,
       Game can then pass result to ship class and to board class to update if ship is sunk.

       The hit counter (now changed to lives counter) belongs to the player, not the ship.
       If a player's lives reduces to 0, it means that all his/her ships are sunk. Game over.
     */

    public boolean checkHit(StrikePoint p) {
        for (Ship s : shipList) {
            if (s.getLocations().equals(p)) {
                lives--;
                return true;
            }
        }
        return false;
    }


/* Purpose:
 - Check if the game is lost. When lives counter reaches 0,
   it means all ships are sunk by the enemy and the player has lost the game.
 - Called by game when checkHit() returns true.

 Input: none
 Output: boolean
 */

    public boolean checkAllSunk() {
        return lives == 0;
    }
}



    /*
    New features to be added later on:
     Avoid repeated name, uppercase, number and symbol
   */