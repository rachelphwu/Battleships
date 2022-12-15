public class Board {
    //note to Game class: maybe in future player can set the board size
    private static int gridWidth = 10;
    private static int gridHeight = 10;
    public static int gridSize = gridWidth * gridHeight;
    private StrikePoint[] grid;
    public Board()
    {
        grid = new StrikePoint[gridSize];
    }

    /**
     * This function creates a new array populated with strikepoints.
     * It will be used for player 1 placement grid, player 1 guess grid, player 2 placement grid, and player 2 guess grid.
     * @return board
     */
    public static StrikePoint[] createGrid() {
        StrikePoint[] grid = new StrikePoint[gridSize];
        int counter = 0;
        for (int x = 1; x <= (gridWidth); x++) {
            for (int y = 1; y <= (gridHeight); y++) {
                StrikePoint sp = new StrikePoint(x,y);
                sp.setHitShip(false);
                sp.updateSymbol(" ~ ");
                grid[counter] = sp;
                counter++;
            }
        }
        return grid;
    }
    /**
     * print the grid for player to see, letters on y-axis, numbers on x-axis
     * NB: letters are cosmetic only
     * @param grid take in grid to print
     */
    public static void printGrid(StrikePoint[] grid){
        //TODO: make grid scale with changing the width using numberdashes int
        int numberDashes = gridHeight*5 - 1;
        char colChar;
        String horizontalDividingLine = "   |-------------------------------------------------|";
        System.out.print("   | ");
        for (int i = 1; i<=gridWidth; i++) {
            System.out.print(String.format("%-5s", i + " |  "));
        }
        for (int y = 0; y < gridHeight; y++) {
            colChar = (char)(y + 65); //65 is capital A in ASCII, so we start here for capital letters
            System.out.println();
            System.out.println(horizontalDividingLine);
            System.out.print(colChar + "  | ");
            for (int x = 0; x < gridHeight; x++) {
                //following line finds the symbol at the correct index and trims it to two characters
                String symbol = grid[(y*gridHeight+x)].getSymbol().substring(0, Math.min(grid[(y*gridHeight+x)].getSymbol().length(), 2));
                System.out.print(String.format("%-3s",  symbol + " | "));
            }
        }
    }

    /**
     * during setup stage, checks the ship placement to ensure it is entirely on the grid     *
     * @param s take in ship s
     * @return boolean if ship can be placed on a grid
     */

    public static boolean validMapLocation(Ship s) {
        boolean isLocationValid = true;
        for (StrikePoint location : s.getLocations()) {
            if (location.getX() > gridWidth || location.getY() > gridHeight || location.getX() < 1 || location.getY() < 1) {
                isLocationValid = false;
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
     * @param myGrid take in grid where it will be placed
     * @return board after ship placement
     */
    public static void markShipLocation(Ship ship, StrikePoint[] myGrid){
        StrikePoint[] shipLocations = ship.getLocations();
        for (StrikePoint sp : shipLocations) {
            for (StrikePoint strikePoint : myGrid) {
                if (sp.equals(strikePoint)) {
                    strikePoint.updateSymbol(ship.getName());
                }
            }
        }
    }


   //player will check if a particular point contains a ship
    //after successful guess, need to do lots of stuff

    /**
     * this is used after a successful guess
     * This method takes in a strikepoint and updates it on a board
     * this can be used to update enemy board and guess board
     * @param sp take in a strikepoint where a guess was made
     * @param grid
     * @return
     */
    public void updateGridAfterGuess(StrikePoint sp, StrikePoint[] grid){
        boolean success = sp.getHitShip();
        for (StrikePoint strikePoint : grid) {
            if (sp.equals(strikePoint)) {
                if (success) {
                    strikePoint.updateSymbol("X");
                    strikePoint.setHitShip(true);
                } else {
                    strikePoint.updateSymbol("O");
                }
            }
        }
    }

}
