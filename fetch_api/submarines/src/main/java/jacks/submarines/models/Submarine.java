package jacks.submarines.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Submarine {
    @JsonProperty
    private int x;

    @JsonProperty
    private int y;

    @JsonProperty
    private int id;

    public Submarine(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public int id() {
        return this.id;
    }

    public void x(int x) {
        this.x = x;
    }

    public void y(int y) {
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Submarine submarine = (Submarine) o;
        return id == submarine.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, id);
    }
}
