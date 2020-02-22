package ant;

import ant.properties.Colour;
import ant.properties.Coordinates;
import ant.properties.Direction;
import ant.properties.navigator.Position;

public class Navigator {


    public Position navigateFrom(Direction direction, Colour colour, Coordinates coordinates) {

        Direction newDirection = getDirection(direction, colour);
        Coordinates newCoordinates = getNewCoordinates(coordinates, newDirection);

        return new Position(newCoordinates, newDirection);
    }

    private Coordinates getNewCoordinates(Coordinates coordinates, Direction newDirection) {

        int newX = coordinates.getX();
        int newY = coordinates.getY();

        switch (newDirection) {
            case WEST:
                newX -= 1;
                break;
            case NORTH:
                newY += 1;
                break;
            case EAST:
                newX += 1;
                break;
            case SOUTH:
                newY -= 1;
                break;
        }

        return new Coordinates(newX, newY);
    }


    private Direction getDirection(Direction direction, Colour colour) {
        Direction newDirection = null;

        if (colour.equals(Colour.BLACK)) {
            newDirection = Direction.values()[(direction.ordinal() - 1 + 4) % 4];
        }

        if (colour.equals(Colour.WHITE)) {
            newDirection = Direction.values()[(direction.ordinal() + 1) % 4];
        }
        return newDirection;
    }
}
