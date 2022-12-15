public class Board {
    private StrikePoint[] board;
    public Board()
    {
        board = new StrikePoint[100];
    }

    /**
     * This function creates a new array populated with strikepoints.
     * It will be used for player 1 placement board, player 1 guess board, player 2 placement board, and player 2 guess board.
     * @return board
     */
    public static StrikePoint[] createBoard() {
        StrikePoint[] board = new StrikePoint[100];
        int counter = 0;
        for (int x = 1; x < 11; x++) {
            for (int y = 1; y < 11; y++) {
                StrikePoint sp = new StrikePoint(x,y);
                sp.setHitShip(false);
                sp.updateSymbol("~");
                board[counter] = sp;
                counter++;
            }
        }
        return board;
    }
    /**
     * print the board for player to see, letters on y-axis, numbers on x-axis
     * NB: letters are cosmetic only
     * @param board take in board to print
     */
    public static void printBoard(StrikePoint[] board){
        System.out.print("   | ");
        for (int i = 1; i<11; i++) {
            System.out.print(String.format("%-5s", i + " |  "));
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("A" + "  | ");
        for (int i = 0; i<10; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("B" + "  | ");
        for (int i = 10; i<20; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("C" + "  | ");
        for (int i = 20; i<30; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("D" + "  | ");
        for (int i = 30; i<40; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("E" + "  | ");
        for (int i = 40; i<50; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("F" + "  | ");
        for (int i = 50; i<60; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("G" + "  | ");
        for (int i = 60; i<70; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("H" + "  | ");
        for (int i = 70; i<80; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("I" + "  | ");
        for (int i = 80; i<90; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("J" + "  | ");
        for (int i = 90; i<100; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
    }

    /**
     * during setup stage, checks the ship placement to ensure it is entirely on the grid
     * this method doesn't work. it returns a null pointer exception
     * it's able to print the locations in the main, but once I try to fetch the locations array in here from the ship object, it's all, "i don't know her"
     * advice requested
     * also this is the last one I troubleshooted.
     * if it can't get ship locations, there's not much else it can do
     * @param s take in ship s
     * @return boolean if ship can be placed on a board
     */
    public static boolean validMapLocation(Ship s) {
        boolean isLocationValid = false;
        boolean horizontal = false;
        //StrikePoint[] shipLocations = s.getLocations();
        StrikePoint[] shipLocations = new StrikePoint[s.getLength()];
        for (int i = 0; i < s.getLength(); i++) {
            shipLocations[i] = s.getLocations()[i];
        }
        StrikePoint initial = shipLocations[0];
        StrikePoint last = shipLocations[s.getLength()];
        if (initial.getY()==last.getY()) horizontal = true;
        if (horizontal) {
            //if the ship is horizontal, then the first position x must be within length of the board edge
            if (((last.getX())-9>0) || (initial.getX()<0)) {
                System.out.println("Sorry, your ship is over the edge of the map.");
                System.out.println("Please try again");
                return isLocationValid;
            }
        } else {
            //if the ship is vertical, then the first position y must be within length of the board edge
            if (((last.getY()) - 9 > 0) || (initial.getY() < 0)) {
                System.out.println("Sorry, your ship is over the edge of the map.");
                System.out.println("Please try again");
                return isLocationValid;
            }
        }
        return isLocationValid;
    }

    /**
     * Could be changed so previous method (validMapLocation) calls on this one to also place ship at the same time, or game can call on this. i'm not fussed either way
     * this is used by the game class
     * this places ship in the initial game setup
     * @param ship take in a ship to be placed
     * @param myBoard take in board where it will be placed
     * @return board after ship placement
     */
    public static StrikePoint[] placeShip(Ship ship, StrikePoint[] myBoard){
        StrikePoint[] shipLocations = ship.getLocations();
        for (StrikePoint sp : shipLocations) {
            for (StrikePoint strikePoint : myBoard) {
                if (sp.getX()==strikePoint.getX() && sp.getY()==strikePoint.getY()) {
                    strikePoint.updateSymbol(ship.getName());
                }
            }
        }
        return myBoard;
    }

   //player will check if a particular point contains a ship
    //after successful guess, need to do lots of stuff
    /*
    //I initially thought we would need two methods for both boards, but now I think that's a bit silly and we just need the updateStrikePoint method
    //leaving them in just in case my first instinct was right; easy enough to uncomment or delete either way
    public StrikePoint[] updateEnemyBoard(StrikePoint strikePoint, Ship ship, StrikePoint[] enemyBoard){
        enemyBoard = updateStrikePoint(strikePoint, enemyBoard);
        return enemyBoard;
    }
    public StrikePoint[] updateGuessBoard(StrikePoint strikePoint, Ship ship, StrikePoint[] guessBoard){
        guessBoard = updateStrikePoint(strikePoint, guessBoard);
        return guessBoard;
    }

     */

    //sorry ben for all the comments (: (sad attempt at upside down smiley)
    //I have to make basically the same method twice, once for a successful hit and once for a miss.
    //I can either take in a boolean where they say whether it's a hit and combine those into two methods (labeled option 1)
    //or I can have two methods for updating on a hit and updating on a miss (labeled option 2a and 2b)
    //pick your poison
    /**
     * option 1
     * this is used after a successful guess
     * This method takes in a strikepoint and updates it on a board
     * this can be used to update enemy board and guess board
     * @param sp take in a strikepoint where a guess was made
     * @param board
     * @return
     */
    public StrikePoint[] updateBoardAfterGuess(StrikePoint sp, StrikePoint[] board, boolean success){
        for (StrikePoint strikePoint : board) {
            if (sp.getX()==strikePoint.getX() && sp.getY()==strikePoint.getY()) {
                if (success) {
                    strikePoint.updateSymbol("X");
                    strikePoint.setHitShip(true);
                } else {
                    strikePoint.updateSymbol("O");
                }
            }
        }
        return board;
    }
    /**
     * option 2a
     * this is used after a successful guess
     * This method takes in a strikepoint and updates it on a board
     * this can be used to update enemy board and guess board
     * @param sp take in a strikepoint where a guess was made
     * @param board either enemy board or guess board
     * @return board after alteration
     */
    public StrikePoint[] updateBoardOnHit(StrikePoint sp, StrikePoint[] board){
        for (StrikePoint strikePoint : board) {
            if (sp.getX()==strikePoint.getX() && sp.getY()==strikePoint.getY()) {
                strikePoint.updateSymbol("X");
                strikePoint.setHitShip(true);
            }
        }
        return board;
    }

    /**
     * option 2b
     * this is used after an unsuccessful guess
     * This method takes in a strikepoint and updates it on a board
     * this can be used to update enemy board and guess board
     * @param sp
     * @param board
     * @return
     */
    public StrikePoint[] updateBoardOnMiss(StrikePoint sp, StrikePoint[] board){
        for (StrikePoint strikePoint : board) {
            if (sp.getX()==strikePoint.getX() && sp.getY()==strikePoint.getY()) {
                strikePoint.updateSymbol("O");
                strikePoint.setHitShip(true);
            }
        }
        return board;
    }

    //final note: change StrikePoint boolean to yes on the ship object was listed on board, but I think this is more of a Ship/Player thing, right?
    //oh well i'll give it a go anyway (:

    public Ship updateShipSPBool(Ship ship, StrikePoint strikePoint){
        //StrikePoint[] shipLocations = ship.getLocations();
        for (StrikePoint sp : ship.getLocations()){
            if (sp.getX()==strikePoint.getX() && sp.getY()==strikePoint.getY()) {
                sp.setHitShip(true);
            }
        }
        return ship;
    }
    //aborted midcommit because i messed up, let's go round 2
}
