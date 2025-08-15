package DesignPattern.FacadeDesignPattern.HomeTheatre;

public class DVDPlayer {
    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }
    public void stop() {
        System.out.println("DVD playback stopped.");
    }
}
