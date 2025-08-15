package DesignPattern.FacadeDesignPattern.HomeTheatre;

public class HomeTheaterFacade {
    private TV tv;
    private DVDPlayer dvdPlayer;
    private SoundSystem soundSystem;
    public HomeTheaterFacade(){
        tv = new TV();
        dvdPlayer = new DVDPlayer();
        soundSystem = new SoundSystem();
    }
    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        tv.turnOn();
        soundSystem.setVolume(10);
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down home theater...");
        dvdPlayer.stop();
        soundSystem.mute();
        tv.turnOff();
    }
}
