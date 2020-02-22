package ant;

import ant.properties.CapacityStatus;
import ant.properties.Colour;
import ant.properties.Coordinates;
import ant.properties.Direction;

import java.util.Objects;

public class Ant {
    private Colour currentColour;
    private Direction currentDirection;
    private CapacityStatus capacityStatus;
    private Coordinates coordinates;

    public Ant(Colour currentColour, Direction currentDirection, CapacityStatus capacityStatus, Coordinates coordinates) {
        this.currentColour = currentColour;
        this.currentDirection = currentDirection;
        this.capacityStatus = capacityStatus;
        this.coordinates = coordinates;
    }

    public Colour getCurrentColour() {
        return currentColour;
    }

    public void setCurrentColour(Colour currentColour) {
        this.currentColour = currentColour;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public CapacityStatus getCapacityStatus() {
        return capacityStatus;
    }

    public void setCapacityStatus(CapacityStatus capacityStatus) {
        this.capacityStatus = capacityStatus;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Ant{" +
                "currentColour=" + currentColour +
                ", currentDirection=" + currentDirection +
                ", capacityStatus=" + capacityStatus +
                ", coordinates=" + coordinates +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ant)) return false;
        Ant ant = (Ant) o;
        return getCurrentColour() == ant.getCurrentColour() &&
                getCurrentDirection() == ant.getCurrentDirection() &&
                getCapacityStatus() == ant.getCapacityStatus() &&
                Objects.equals(getCoordinates(), ant.getCoordinates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCurrentColour(), getCurrentDirection(), getCapacityStatus(), getCoordinates());
    }
}
