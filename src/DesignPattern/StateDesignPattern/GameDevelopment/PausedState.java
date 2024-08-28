package DesignPattern.StateDesignPattern.GameDevelopment;

class PausedState implements GameState {
    @Override
    public void start(Game game) {
        System.out.println("Cannot start. Game is already paused.");
    }

    @Override
    public void pause(Game game) {
        System.out.println("Game is already paused.");
    }

    @Override
    public void resume(Game game) {
        System.out.println("Resuming the game...");
        game.setState(new PlayingState());
    }

    @Override
    public void gameOver(Game game) {
        System.out.println("Ending the game...");
        game.setState(new GameOverState());
    }

    @Override
    public void displayState() {
        System.out.println("Game is in Paused state.");
    }
}
