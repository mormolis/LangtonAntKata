package ant;

import ant.properties.CapacityStatus;
import ant.properties.Colour;
import ant.properties.Coordinates;
import ant.properties.Direction;

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
}
