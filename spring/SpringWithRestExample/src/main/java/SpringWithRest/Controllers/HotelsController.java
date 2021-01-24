package SpringWithRest.Controllers;

import SpringWithRest.Models.Hotel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelsController {

    public List<Hotel> hotels = new ArrayList<Hotel>();

    public HotelsController() {
        hotels.add(new Hotel(1, "Hilton", "Tel Aviv"));
        hotels.add(new Hotel(2, "4 Seasons", "France"));
        hotels.add(new Hotel(3, "Waldorf Astoria", "NYC"));
    }

    @GetMapping("/hotels")
    public List<Hotel> getAll() {
        return (hotels);
    }

    @GetMapping("/hotels/{hotelId}")
    public Hotel getSpecificHotel(@PathVariable int hotelId) {
        Hotel specificHotel = null;

        // Run over all the hotels in the list
        for (Hotel currHotel : hotels) {
            // Check if the the current hotel is the one were looking for
            if (currHotel.id() == hotelId) {
                specificHotel = currHotel;
            }
        }

        return (specificHotel);
    }

    @PostMapping("/hotels")
    public String add(@RequestBody Hotel newHotel) {
        hotels.add(newHotel);
        return ("Hotel Was successfuly added");
    }

    @PutMapping("/hotels/{hotelId}")
    public void updateHotel(@PathVariable int hotelId, @RequestBody Hotel hotel) {

        // Run over all the hotels in the list
        for (Hotel currHotel : hotels) {
            // Check if the the current hotel is the one were looking for
            if (currHotel.id() == hotelId) {
                currHotel.changeAddress(hotel.address());
                currHotel.changeName(hotel.name());
            }
        }
    }

    @DeleteMapping("/hotels")
    public void deleteAll() {
        hotels.clear();
    }

    @DeleteMapping("/hotels/{hotelId}")
    public void deleteHotel(@PathVariable int hotelId) {
        hotels.removeIf((hotel) -> hotel.id() == hotelId);
    }
}
