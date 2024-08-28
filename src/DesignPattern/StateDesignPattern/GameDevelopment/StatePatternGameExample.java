package DesignPattern.StateDesignPattern.GameDevelopment;

public class StatePatternGameExample {
    public static void main(String[] args) {
        Game game = new Game();

        game.displayState();
        game.start();
        game.displayState();

        game.pause();
        game.displayState();

        game.resume();
        game.displayState();

        game.gameOver();
        game.displayState();

        game.start();
        game.displayState();
    }
}
