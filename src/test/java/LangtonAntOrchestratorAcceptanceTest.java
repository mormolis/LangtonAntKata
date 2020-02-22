import Initialization.InitialStateRandomizer;
import Initialization.LangtonAntOrchestrator;
import ant.Ant;
import ant.ColourFlipper;
import ant.ExploredTerrain;
import ant.Navigator;
import ant.properties.CapacityStatus;
import ant.properties.Colour;
import ant.properties.Coordinates;
import ant.properties.Direction;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LangtonAntOrchestratorAcceptanceTest {

    private Navigator navigator;
    private InitialStateRandomizer mockInitialStateRandomiser;
    private ExploredTerrain exploredTerrain;
    private ColourFlipper colourFlipper;
    private LangtonAntOrchestrator langtonAntInitializer;

    @Before
    public void init() {
        navigator = new Navigator();
        mockInitialStateRandomiser = mock(InitialStateRandomizer.class);
        when(mockInitialStateRandomiser.randomColour()).thenReturn(Colour.WHITE);
        when(mockInitialStateRandomiser.randomDirection()).thenReturn(Direction.NORTH);
        when(mockInitialStateRandomiser.randomCoordinates()).thenReturn(new Coordinates(0, 0));
        exploredTerrain = new ExploredTerrain();
        colourFlipper = new ColourFlipper();
        langtonAntInitializer = new LangtonAntOrchestrator(mockInitialStateRandomiser, navigator, exploredTerrain, colourFlipper);
    }

    @Test
    public void antBehavesAccordingToTheSpecifications() {

        langtonAntInitializer.step();

        assertThat(langtonAntInitializer.getCurrentAnt(), equalTo(new Ant(Colour.WHITE, Direction.EAST, CapacityStatus.FULL, new Coordinates(1, 0))));
    }

    @Test
    public void inFourStepsAntWillReturnToTheStartingPointWhenAllAreWhite() {

        stepFourTimes();

        assertThat(langtonAntInitializer.getCurrentAnt(), equalTo(new Ant(Colour.BLACK, Direction.NORTH, CapacityStatus.FULL, new Coordinates(0, 0))));
    }

    @Test
    public void afterFourStepsOnWhitePlainTheMapNeedsToHaveFourAnts() {

        stepFourTimes();
        final Map<Coordinates, Ant> terrainCopy = exploredTerrain.getTerrainCopy();

        assertThat(terrainCopy.keySet().size(), equalTo(4));
    }

    @Test
    public void afterFourStepsOnWhitePlainTheMapNeedsToThreeEmptyAnts() {

        stepFourTimes();
        final Map<Coordinates, Ant> terrainCopy = exploredTerrain.getTerrainCopy();
        long emptyAnts = terrainCopy.keySet()
                .stream()
                .map(k -> terrainCopy.get(k).getCapacityStatus())
                .filter(cs -> cs.equals(CapacityStatus.EMPTY))
                .count();

        assertThat(emptyAnts, equalTo(3L));
    }

    private void stepFourTimes() {
        langtonAntInitializer.step();
        langtonAntInitializer.step();
        langtonAntInitializer.step();
        langtonAntInitializer.step();
    }


}