package Initialization;

import ant.properties.Colour;
import ant.properties.Coordinates;
import ant.properties.Direction;

import java.util.Random;

public class InitialStateRandomizer {

    private Random random;

    public InitialStateRandomizer() {
        this.random = new Random();
    }

    public Colour randomColour() {
        return Colour.values()[random.nextInt(Colour.values().length)];
    }

    public Direction randomDirection() {
        return Direction.values()[random.nextInt(Direction.values().length)];
    }

    public Coordinates randomCoordinates() {

        int x = 1;
        int y = 1;

        if (random.nextInt(10) > 5) {
            x = -1;
        }
        if (random.nextInt(10) > 5) {
            y = -1;
        }
        return new Coordinates(random.nextInt(Integer.MAX_VALUE) * x, random.nextInt(Integer.MAX_VALUE) * y);
    }
}
