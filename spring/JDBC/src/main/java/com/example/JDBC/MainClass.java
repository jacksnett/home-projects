package com.example.JDBC;

import java.util.List;
import java.util.Scanner;

public class MainClass {
    private static final int GET_ALL_MOVIES = 1;
    private static final int ADD_MOVIE = 2;
    private static final int REMOVE_MOVIE = 3;
    private static final int UPDATE_MOVIE = 4;
    private static final int EXIT = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int action = getActionFromUser();

        while (action != EXIT) {
            switch (action) {
                case GET_ALL_MOVIES:
                    List<Movie> movies = MoviesManager.readMoviesFromDB();

                    if (movies.isEmpty()) {
                        System.out.println("There is no movies");
                    } else {
                        
                        for (Movie currentMovie : movies) {
                            currentMovie.print();
                        }
                    }

                    break;
                case ADD_MOVIE:
                    if (MoviesManager.addMovie(readMovieFromUser())) {
                        System.out.println("Movie was successfully added!");
                    } else {
                        System.out.println("Failed to add the movie, please try again.");
                    }

                    break;
                case REMOVE_MOVIE:
                    System.out.print("Enter ID of the movie to delete: ");
                    int id = scanner.nextInt();

                    if (MoviesManager.deleteMovie(id)) {
                        System.out.println("Movie was successfully deleted!");
                    } else {
                        System.out.println("Failed to delete the movie, please try again.");
                    }

                    break;
                case (UPDATE_MOVIE):
                    Movie movieToUpdate = readMovieFromUser();

                    if (MoviesManager.updateMovie(movieToUpdate)) {
                        System.out.println(movieToUpdate.name() + " was successfully updated!");
                    } else {
                        System.out.println("Failed to update the movie, please try again.");
                    }

                    break;
                default:
                    System.out.println("Invalid action code, please enter again");

                    break;
            }

            action = getActionFromUser();
        }
    }

    public static int getActionFromUser() {
        Scanner scanner = new Scanner(System.in);
        int action;

        System.out.println(
                "Hi, Welcome to blockbuster. Movies for everyone!\n"
                        + "-----------------------------------------------");
        System.out.println(
                "Enter your action:\n"
                        + GET_ALL_MOVIES
                        + "- Print all movies\n"
                        + ADD_MOVIE
                        + "- Add\n"
                        + REMOVE_MOVIE
                        + "- Remove\n"
                        + UPDATE_MOVIE
                        + "- Update\n"
                        + EXIT
                        + "- Exit");

        action = scanner.nextInt();

        return action;
    }

    public static Movie readMovieFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ID of the movie to add: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name of the movie: ");
        String name = scanner.nextLine();
        System.out.print("Enter the genre of the movie: ");
        String genre = scanner.nextLine();
        System.out.print("Enter the rating of the movie (1-10): ");
        float rating = scanner.nextFloat();

        return new Movie(id, name, genre, rating);
    }
}
