package jackobs.TLVparking.Controllers;

import jackobs.TLVparking.DB.ParkingManager;
import jackobs.TLVparking.Models.Parking;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ParkingController {

    public ParkingController() {
    }

    @GetMapping("/parkings")
    public List<Parking> getAll() {
        return ParkingManager.readParkingFromDB();
    }

    @GetMapping("/parkings/{id}")
    public Parking getById(@PathVariable int id) {
        return ParkingManager.readParkingFromDB(id);
    }

    @DeleteMapping("/parkings/{id}")
    public Boolean deleteByID(@PathVariable int id) {
        return ParkingManager.deleteParkingFromDB(id);
    }

    @PostMapping("/parkings")
    public Boolean addParking(@RequestBody Parking parkingToAdd) {
        return ParkingManager.addParkingToDB(parkingToAdd);
    }
}
