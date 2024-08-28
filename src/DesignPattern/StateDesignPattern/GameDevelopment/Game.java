package DesignPattern.StateDesignPattern.GameDevelopment;

public class Game {
    private GameState state;

    public Game() {
        // Initial state is Start
        this.state = new StartState();
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void start() {
        state.start(this);
    }

    public void pause() {
        state.pause(this);
    }

    public void resume() {
        state.resume(this);
    }

    public void gameOver() {
        state.gameOver(this);
    }

    public void displayState() {
        state.displayState();
    }
}
