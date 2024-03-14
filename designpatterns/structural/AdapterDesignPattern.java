package designpatterns.structural;

public class AdapterDesignPattern{

    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayerImpl();
        mediaPlayer.play("song.mp3");
        mediaPlayer = new MediaAdapter();
        mediaPlayer.play("video.mp4");
    }
}


// Target interface
interface MediaPlayer {
    void play(String fileName);
}

class MediaPlayerImpl implements MediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing mp3 file: " + fileName);
    }
}

// Adaptee interface
interface VideoPlayer {
    void playMP4(String fileName);
}

// Concrete Adaptee classes
class VideoPlayerImpl implements VideoPlayer {
    @Override
    public void playMP4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}

// Adapter class
class MediaAdapter implements MediaPlayer {
    private VideoPlayer videoPlayer;

    MediaAdapter () {
        videoPlayer = new VideoPlayerImpl();
    }

    @Override
    public void play(String fileName) {
        videoPlayer.playMP4(fileName);
    }
}