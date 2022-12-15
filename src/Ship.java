//TODO Amy: convert this class to an abstract class or interface, whichever you'd prefer
    //TODO Amy: Define fields for the ship here, and adjust values for the subclasses
    /*TODO Amy: assume you will get two StrikePoints for start and end of each ship: write constructor in such a way that
       it works for a ship with n StrikePoints (i.e. so you don't have to write an individual one for each subclass).  */
import java.util.List;
import java.util.ArrayList;
import java.util.List;
public class Ship {
    
    private String name;
    private List<StrikePoint> location;
    private boolean isSunk;
    private int length;

    public Ship (String name, int row, int col, int length, Direction direction){
        this.name = name;
        this.location = new ArrayList<>;
        this.length = length;
        this.isSunk = false;
        int target;
        switch(direction){
            case UP:
                target = row + length;
                while(row < target){
                    location.add(new StrikePoint(row, col++));
                }
                break;

            case DOWN:
                target = row + length;
                while ((row < target)) {
                    location.add(new StrikePoint(row,col--))
                }
                break;

            case LEFT:
                target = col + length;
                while(col <target){
                    location.add(new StrikePoint(row--,col))
                }


            case RIGHT:
                target = col + length;
                while(col < target){
                    location.add(new StrikePoint(row++,col));
                }
                break;

        }
    }

    public boolean isSunk ( List<StrikePoint> enemyGuesses){
        int count = 0;
        for(StrikePoint ship : location){
            if(enemy.getCol() == ship.getCol()) && enemy.getRow == ship.getRow()){
                count++;
                break;
            }
        }
        return count == length;
    }


}

/*
public class StrikePoint {

    private int row;
    private int col;

    public StrikePoint(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
*/
