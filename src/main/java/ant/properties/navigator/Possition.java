package ant.properties.navigator;

import ant.properties.Coordinates;
import ant.properties.Direction;

import java.util.Objects;

public class Possition {
    private Coordinates coordinates;
    private Direction direction;

    public Possition(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Possition{" +
                "coordinates=" + coordinates +
                ", direction=" + direction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Possition)) return false;
        Possition possition = (Possition) o;
        return Objects.equals(getCoordinates(), possition.getCoordinates()) &&
                getDirection() == possition.getDirection();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoordinates(), getDirection());
    }
}
