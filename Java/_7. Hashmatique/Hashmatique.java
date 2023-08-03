import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();

        trackList.put("Canción 1", "Letras para la canción 1...");
        trackList.put("Canción 2", "Letras para la canción 2...");
        trackList.put("Canción 3", "Letras para la canción 3...");
        trackList.put("Canción 4", "Letras para la canción 4...");

        Set<String> tracks = trackList.keySet();

        for(String track : tracks) {
            System.out.println("Track: " + track + " - Lyrics: " + trackList.get(track));
        }
    }
}
