package com.example.JDBC;

public class Movie {
  private int id;
  private String name;
  private String genre;
  private float rating;

  public Movie(int id, String name, String genre, float rating) {
    this.id = id;
    this.updateName(name);
    this.updateGenre(genre);
    this.updateRating(rating);
  }

  public int id() {
    return this.id;
  }

  public String name() {
    return this.name;
  }

  public String genre() {
    return this.genre;
  }

  public float rating() {
    return this.rating;
  }

  public void updateName(String name) {
    this.name = name;
  }

  public void updateGenre(String genre) {
    this.genre = genre;
  }

  public void updateRating(float rating) {
    this.rating = rating;
  }

  public void print() {
    System.out.println(
            "Name: "
            + this.name()
            + "\n"
            + "Genre: "
            + this.genre()
            + "\n"
            + "Rating: "
            + this.rating()
            + "\n");
  }
}
