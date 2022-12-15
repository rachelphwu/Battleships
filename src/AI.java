public abstract class AI extends Player {
   
    //TODO David: this subclass is a placeholder at the moment, as it only has one offshoot: see AdmiralDartboard
        Random rand = new Random();
        ArrayList<Integer> aiGuess = new ArrayList<>();
        int len = aiGuess.size();
            public Integer generateRandomPosition(){
            for (int i = 0; i < len; i++) {
                int guessPosition = rand.nextInt(100);
                if (aiGuess.contains(guessPosition)) {
                    System.out.println("position duplicate: " + guessPosition);
                }
                else {
                    aiGuess.add(guessPosition);
                }
            }
            return generateRandomPosition();
        }
}
