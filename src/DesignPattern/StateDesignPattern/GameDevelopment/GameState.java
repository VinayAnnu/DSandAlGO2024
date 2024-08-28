package DesignPattern.StateDesignPattern.GameDevelopment;

public interface GameState {
    void start(Game game);
    void pause(Game game);
    void resume(Game game);
    void gameOver(Game game);
    void displayState();
}
