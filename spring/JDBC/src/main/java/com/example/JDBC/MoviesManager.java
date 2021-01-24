package com.example.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoviesManager {
  public static List<Movie> readMoviesFromDB() {
    List<Movie> movies = new ArrayList<>();
    final String query = "SELECT id, name, genre, rating FROM public.t_movies";

    try (Connection connection = DBConnection.instance().connection();
        Statement statement = connection.createStatement();
        ResultSet moviesResultSet = statement.executeQuery(query)) {

      while (moviesResultSet.next()) {
        int id = moviesResultSet.getInt("id");
        String name = moviesResultSet.getString("name");
        String genre = moviesResultSet.getString("genre");
        float rating = moviesResultSet.getFloat("rating");

        Movie currMovie = new Movie(id, name, genre, rating);
        movies.add(currMovie);
      }

    } catch (ClassNotFoundException | SQLException e) {
      System.out.println(e.getMessage());
    }
    return movies;
  }

  public static boolean addMovie(Movie movieToAdd) {
    int id = movieToAdd.id();
    String name = movieToAdd.name();
    String genre = movieToAdd.genre();
    float rating = movieToAdd.rating();

//    final String query =
//        "INSERT INTO public.t_movies (id, name, genre, rating) VALUES ('"
//            + id
//            + "', '"
//            + name
//            + "', '"
//            + genre
//            + "', '"
//            + rating
//            + "')";

    final String query =
                            "INSERT " +
                            "INTO public.t_movies (id, name, genre, rating) " +
                            "VALUES (?, ?, ?, ?);";

    final String[] vars = {name, genre, Float.toString(rating), Integer.toString(id)};

    return executeUpdate(query, vars);
  }

  public static boolean updateMovie(Movie movieToUpdate) {
    int id = movieToUpdate.id();
    String name = movieToUpdate.name();
    String genre = movieToUpdate.genre();
    float rating = movieToUpdate.rating();
    final String updateQuery =  "UPDATE public.t_movies " +
                                "SET name = ?, genre = ?, rating = ?" +
                                "'WHERE id = ?";

    final String[] vars = {name, genre, Float.toString(rating), Integer.toString(id)};

    return executeUpdate(updateQuery, vars);
  }

  public static boolean deleteMovie(int id) {
    final String deleteQuery = "DELETE from public.t_movies WHERE id = ?";
    return executeDelete(deleteQuery, id);
  }

  public static boolean executeAdd(final String query, int id, String name, String genre, float rating) {
    boolean ifExecuted = false;

    try (Connection connection = DBConnection.instance().connection();
         PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setInt(1, id);
      statement.setString(2, name);
      statement.setString(3, genre);
      statement.setFloat(4, rating);

      ifExecuted = (statement.executeUpdate(query) == 1);

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    return ifExecuted;
  }



  public static boolean executeUpdate(final String query, final String[] statementVars) {
    boolean ifExecuted = false;

    try (Connection connection = DBConnection.instance().connection();
         PreparedStatement statement = connection.prepareStatement(query)) {

      for (int varIndex = 1; varIndex <= statementVars.length; varIndex++) {
        statement.setString(varIndex, statementVars[varIndex - 1]);
      }

      ifExecuted = (statement.executeUpdate() == 1);

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    return ifExecuted;
  }

  public static boolean executeDelete(final String query, final int id) {
    boolean ifExecuted = false;

    try (Connection connection = DBConnection.instance().connection();
         PreparedStatement statement = connection.prepareStatement(query);
         ) {

      statement.setInt(1, id);

      ifExecuted = (statement.executeUpdate() == 1);

    } catch (ClassNotFoundException | SQLException e) {
      System.out.println(e.getMessage());
    }

    return ifExecuted;
  }
}
