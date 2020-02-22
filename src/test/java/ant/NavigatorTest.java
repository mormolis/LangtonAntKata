package ant;

import ant.properties.Colour;
import ant.properties.Coordinates;
import ant.properties.Direction;
import ant.properties.navigator.Possition;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class NavigatorTest {

    private Navigator navigator;

    @Before
    public void init() {
        navigator = new Navigator();
    }


    @Test
    public void newDirectionWhenCurrentColourIsBlackIsTheCurrentDirectionMinusOneInTheOrdinal() {
        final Possition fromWest = navigator.navigateFrom(Direction.WEST, Colour.BLACK, new Coordinates(0, 0));
        final Possition fromSouth = navigator.navigateFrom(Direction.SOUTH, Colour.BLACK, new Coordinates(0, 0));
        final Possition fromEast = navigator.navigateFrom(Direction.EAST, Colour.BLACK, new Coordinates(0, 0));
        final Possition fromNorth = navigator.navigateFrom(Direction.NORTH, Colour.BLACK, new Coordinates(0, 0));

        assertThat(fromWest.getDirection(), equalTo(Direction.SOUTH));
        assertThat(fromSouth.getDirection(), equalTo(Direction.EAST));
        assertThat(fromEast.getDirection(), equalTo(Direction.NORTH));
        assertThat(fromNorth.getDirection(), equalTo(Direction.WEST));

    }

    @Test
    public void newDirectionWhenCurrentColourIsWhiteIsTheCurrentDirectionPlusOneInTheOrdinal() {
        final Possition fromWest = navigator.navigateFrom(Direction.WEST, Colour.WHITE, new Coordinates(0, 0));
        final Possition fromSouth = navigator.navigateFrom(Direction.SOUTH, Colour.WHITE, new Coordinates(0, 0));
        final Possition fromEast = navigator.navigateFrom(Direction.EAST, Colour.WHITE, new Coordinates(0, 0));
        final Possition fromNorth = navigator.navigateFrom(Direction.NORTH, Colour.WHITE, new Coordinates(0, 0));

        assertThat(fromWest.getDirection(), equalTo(Direction.NORTH));
        assertThat(fromNorth.getDirection(), equalTo(Direction.EAST));
        assertThat(fromEast.getDirection(), equalTo(Direction.SOUTH));
        assertThat(fromSouth.getDirection(), equalTo(Direction.WEST));
    }

    @Test
    public void givenCurrentDirectionColourAndCoordinatesGivesTheCoordinatesForTheNextStep() {

        assertThat(
                navigator.navigateFrom(Direction.WEST, Colour.BLACK, new Coordinates(0, 0)),
                equalTo(new Possition(new Coordinates(0, -1), Direction.SOUTH))
        );

        assertThat(
                navigator.navigateFrom(Direction.WEST, Colour.WHITE, new Coordinates(0, 0)),
                equalTo(new Possition(new Coordinates(0, 1), Direction.NORTH))
        );

        assertThat(
                navigator.navigateFrom(Direction.SOUTH, Colour.WHITE, new Coordinates(0, 0)),
                equalTo(new Possition(new Coordinates(-1, 0), Direction.WEST))
        );

        assertThat(
                navigator.navigateFrom(Direction.SOUTH, Colour.BLACK, new Coordinates(0, 0)),
                equalTo(new Possition(new Coordinates(1, 0), Direction.EAST))
        );

        assertThat(
                navigator.navigateFrom(Direction.EAST, Colour.WHITE, new Coordinates(0, 0)),
                equalTo(new Possition(new Coordinates(0, -1), Direction.SOUTH))
        );

        assertThat(
                navigator.navigateFrom(Direction.EAST, Colour.BLACK, new Coordinates(0, 0)),
                equalTo(new Possition(new Coordinates(0, 1), Direction.NORTH))
        );

        assertThat(
                navigator.navigateFrom(Direction.NORTH, Colour.WHITE, new Coordinates(0, 0)),
                equalTo(new Possition(new Coordinates(1, 0), Direction.EAST))
        );

        assertThat(
                navigator.navigateFrom(Direction.NORTH, Colour.BLACK, new Coordinates(0, 0)),
                equalTo(new Possition(new Coordinates(-1, 0), Direction.WEST))
        );
    }
}