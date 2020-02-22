package ant;

import ant.properties.CapacityStatus;
import ant.properties.Colour;
import ant.properties.Coordinates;
import ant.properties.Direction;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ExploredTerrainTest {

    private ExploredTerrain exploredTerrain;

    @Before
    public void init() {
        exploredTerrain = new ExploredTerrain();
    }

    @Test
    public void returnsAnEmptyOptionalIfCoordinatesHasNotBeenVisited() {

        assertThat(exploredTerrain.getAntByCoordinates(new Coordinates(0, 0)), equalTo(Optional.empty()));
    }

    @Test
    public void returnsAnOptionalOfAnAntWhenAntHasBeenAdded() {
        final Ant anAnt = new Ant(Colour.BLACK, Direction.SOUTH, CapacityStatus.FULL, new Coordinates(0, -9));
        exploredTerrain.addAnt(anAnt);

        assertThat(exploredTerrain.getAntByCoordinates(new Coordinates(0, -9)), equalTo(Optional.of(anAnt)));
    }


}