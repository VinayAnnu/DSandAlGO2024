package DesignPattern.StateDesignPattern.GameDevelopment;

class GameOverState implements GameState {
    @Override
    public void start(Game game) {
        System.out.println("Restarting the game...");
        game.setState(new StartState());
    }

    @Override
    public void pause(Game game) {
        System.out.println("Cannot pause. Game is over.");
    }

    @Override
    public void resume(Game game) {
        System.out.println("Cannot resume. Game is over.");
    }

    @Override
    public void gameOver(Game game) {
        System.out.println("Game is already over.");
    }

    @Override
    public void displayState() {
        System.out.println("Game is in GameOver state.");
    }
}
