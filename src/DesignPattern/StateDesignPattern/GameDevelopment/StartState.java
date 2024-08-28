package DesignPattern.StateDesignPattern.GameDevelopment;

class StartState implements GameState {
    @Override
    public void start(Game game) {
        System.out.println("Game is starting...");
        game.setState(new PlayingState());
    }

    @Override
    public void pause(Game game) {
        System.out.println("Cannot pause. Game hasn't started yet.");
    }

    @Override
    public void resume(Game game) {
        System.out.println("Cannot resume. Game hasn't started yet.");
    }

    @Override
    public void gameOver(Game game) {
        System.out.println("Cannot end. Game hasn't started yet.");
    }

    @Override
    public void displayState() {
        System.out.println("Game is in Start state.");
    }
}
