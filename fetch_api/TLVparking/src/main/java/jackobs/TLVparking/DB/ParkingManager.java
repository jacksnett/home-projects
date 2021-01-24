package jackobs.TLVparking.DB;

import jackobs.TLVparking.Models.Parking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParkingManager {
    public static List<Parking> readParkingFromDB() {
        List<Parking> parkingList = new ArrayList<>();
        final String query = "SELECT id, x_coord, y_coord, address, time " +
                "FROM public.t_parking " +
                "ORDER BY id asc";

        try (Connection connection = DBConnection.instance().connection();
             Statement statement = connection.createStatement();
             ResultSet parkingResultSet = statement.executeQuery(query)) {

            while (parkingResultSet.next()) {
                int id = parkingResultSet.getInt("id");
                int x_coord = parkingResultSet.getInt("x_coord");
                int y_coord = parkingResultSet.getInt("y_coord");
                String address = parkingResultSet.getString("address");
                String time = parkingResultSet.getString("time");

                Parking parkingToAdd = new Parking(id, x_coord, y_coord, address, time);
                parkingList.add(parkingToAdd);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return parkingList;
    }

    public static Parking readParkingFromDB(int searchedID) {
        Parking parkingToReturn = null;
        final String query = "SELECT id, x_coord, y_coord, address, time " +
                "FROM public.t_parking " +
                "WHERE id = ?";

        try(Connection connection = DBConnection.instance().connection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, searchedID);
            ResultSet parkingResultSet = preparedStatement.executeQuery();

            while(parkingResultSet.next()) {
                int id = parkingResultSet.getInt("id");
                int x_coord = parkingResultSet.getInt("x_coord");
                int y_coord = parkingResultSet.getInt("y_coord");
                String address = parkingResultSet.getString("address");
                String time = parkingResultSet.getString("time");

                parkingToReturn = new Parking(id, x_coord, y_coord, address, time);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return parkingToReturn;
    }

    public static boolean deleteParkingFromDB(int IDToDelete) {
        final String query =  "DELETE " +
                "FROM public.t_parking " +
                "WHERE id = ?";

        int changedDBLines = 0;

        try(Connection connection = DBConnection.instance().connection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, IDToDelete);
            changedDBLines = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return (changedDBLines == 1);
    }

    public static boolean addParkingToDB(Parking parkingToAdd) {
        final int id = parkingToAdd.id();
        final int x_coord = parkingToAdd.x_coord();
        final int y_coord = parkingToAdd.y_coord();
        final String address = parkingToAdd.address();
        final String time = parkingToAdd.time();

        final String query = "INSERT " +
                "INTO public.t_parking(id, x_coord, y_coord, address, time) " +
                "VALUES(?, ?, ?, ? , ?)";

        int changedLines = 0;

        try(Connection connection = DBConnection.instance().connection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, x_coord);
            preparedStatement.setInt(3, y_coord);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, time);
            changedLines = preparedStatement.executeUpdate();
    } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return (changedLines == 1);
    }
    }
