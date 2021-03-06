package spacetrader.api;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Created by Philip on 12/02/2014.
 */
public class SoundPlayer {

    private final static String clickPath = "sounds/click.wav";
    private final static String coinPath = "sounds/coin.wav";
    private final static String powerupPath = "sounds/powerup.wav";
    private final static String refreshPath = "sounds/refresh.wav";

    public static void playClick() {
        playSound(clickPath);
    }

    public static void playCoin() {
        playSound(coinPath);
    }

    public static void playPowerup() {
        playSound(powerupPath);
    }

    public static void playRefresh() {
        playSound(refreshPath);
    }

    private static void playSound(String path) {
        Media sound = new Media(SoundPlayer.class.getResource(path).toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.play();
    }
}
