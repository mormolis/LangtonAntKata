package ant.properties;

import org.junit.Test;

import static ant.properties.Direction.EAST;
import static ant.properties.Direction.NORTH;
import static ant.properties.Direction.SOUTH;
import static ant.properties.Direction.WEST;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class DirectionOrdinalConfirmationTest {

    @Test
    public void secureOrdinal(){

        final Direction[] directionValues = Direction.values();

        assertThat(directionValues[0], equalTo(WEST));
        assertThat(directionValues[1], equalTo(NORTH));
        assertThat(directionValues[2], equalTo(EAST));
        assertThat(directionValues[3], equalTo(SOUTH));
    }

}