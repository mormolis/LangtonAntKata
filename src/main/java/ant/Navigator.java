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

        if (colour.equals(Colour.BLACK)) {
            // when the ant is black rotate the value anticlockwise and wrap on negative values
            return Direction.values()[(direction.ordinal() - 1 + 4) % 4];
        }

        if (colour.equals(Colour.WHITE)) {
            // when the ant is white rotate the value clockwise and wrap on values greater than the number of available Directions
            return Direction.values()[(direction.ordinal() + 1) % 4];
        }
        
        throw new UnsupportedOperationException("colour is not supported");
    }
}
