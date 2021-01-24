package Bsmch.SpringExcerscise.Controllers;

import Bsmch.SpringExcerscise.Models.Song;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SongController {
  @JsonProperty(value = "songList")
  public List<Song> songLIst = new ArrayList<Song>();

  public SongController() {}

  @GetMapping("/Songs")
  public List<Song> getSongs() {
    return (songLIst);
  }

  @GetMapping("/Songs/{songName}")
  public Song getSong(@PathVariable String songName) {
    Song songToReturn = null;
    for (Song song : (songLIst)) {
      if (song.name().equalsIgnoreCase(songName)) {
        songToReturn = song;
      }
    }

    return songToReturn;
  }

  @PostMapping("/Songs")
  public String add(@RequestBody Song songToAdd) {
    songLIst.add(songToAdd);

    return "Song added successfully";
  }

  @PutMapping("/Songs/{songName}")
  public void updateSong(@PathVariable String songName, @RequestBody Song songDetails) {
    for (Song currSong : songLIst) {
      if (currSong.name().equalsIgnoreCase(songName)) {
        currSong.changeName(songDetails.name());
        currSong.changeDuration(songDetails.duration());
        currSong.changeSinger(songDetails.singer());
        currSong.changeViews(songDetails.views());
      }
    }
  }

  @DeleteMapping("/Songs/{songName}")
  public void deleteSong(@PathVariable String songName) {
    songLIst.removeIf((song) -> song.name().equalsIgnoreCase(songName));
  }
}
