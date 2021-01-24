package jackobs.TLVparking.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parking {

    @JsonProperty(value = "id")
    private int id;

    @JsonProperty(value = "x_coord")
    private int x_coord;

    @JsonProperty(value = "y_coord")
    private int y_coord;

    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value = "time")
    private String time;


    public Parking() {
    }

    public Parking(int id, int x_coord, int y_coord, String address, String time) {
        this.id = id;
        this.x_coord = x_coord;
        this.y_coord = y_coord;
        this.address = address;
        this.time = time;
    }


    public Parking(int x_coord, int y_coord, String address, String time) {
        this.x_coord = x_coord;
        this.y_coord = y_coord;
        this.address = address;
        this.time = time;
    }

    public int id() {
        return id;
    }

    public int x_coord() {
        return x_coord;
    }

    public int y_coord() {
        return y_coord;
    }

    public String address() {
        return address;
    }

    public String time() {
        return time;
    }
}
