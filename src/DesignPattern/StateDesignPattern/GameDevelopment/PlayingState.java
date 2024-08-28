package DesignPattern.StateDesignPattern.GameDevelopment;

class PlayingState implements GameState {
    @Override
    public void start(Game game) {
        System.out.println("Game is already playing.");
    }

    @Override
    public void pause(Game game) {
        System.out.println("Pausing the game...");
        game.setState(new PausedState());
    }

    @Override
    public void resume(Game game) {
        System.out.println("Game is already playing.");
    }

    @Override
    public void gameOver(Game game) {
        System.out.println("Ending the game...");
        game.setState(new GameOverState());
    }

    @Override
    public void displayState() {
        System.out.println("Game is in Playing state.");
    }
}
