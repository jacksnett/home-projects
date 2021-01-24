package Bsmch.SpringExcerscise.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Song {

    @JsonProperty
    private String name;

    @JsonProperty
    private String singer;

    @JsonProperty
    private String duration;

    @JsonProperty
    private int    views;

    public Song(String name, String singer, String duration, int views) {
        this.name = name;
        this.singer = singer;
        this.duration = duration;
        this.views = views;
    }

    public String name() {
        return name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public String singer() {
        return singer;
    }

    public void changeSinger(String singer) {
        this.singer = singer;
    }

    public String duration() {
        return duration;
    }

    public void changeDuration(String duration) {
        this.duration = duration;
    }

    public int views() {
        return views;
    }

    public void changeViews(int views) {
        this.views = views;
    }
}
