package ant.properties.navigator;

import ant.properties.Coordinates;
import ant.properties.Direction;

import java.util.Objects;

public class Position {
    private Coordinates coordinates;
    private Direction direction;

    public Position(Coordinates coordinates, Direction direction) {
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
        return "Position{" +
                "coordinates=" + coordinates +
                ", direction=" + direction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return Objects.equals(getCoordinates(), position.getCoordinates()) &&
                getDirection() == position.getDirection();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoordinates(), getDirection());
    }
}
