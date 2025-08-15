package DesignPattern.FacadeDesignPattern.HomeTheatre;

public class FacadePatternExample {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        homeTheater.watchMovie("Inception");
        // Output:
        // Get ready to watch a movie...
        // TV is now ON.
        // Sound system volume set to: 10
        // Playing movie: Inception

        homeTheater.endMovie();
        // Output:
        // Shutting down home theater...
        // DVD playback stopped.
        // Sound system is muted.
        // TV is now OFF.
    }
}
