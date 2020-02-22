import Initialization.InitialStateRandomizer;
import Initialization.LangtonAntOrchestrator;
import ant.Ant;
import ant.ExploredTerrain;
import ant.Navigator;
import ant.properties.CapacityStatus;
import ant.properties.Colour;
import ant.properties.Coordinates;
import ant.properties.Direction;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LangtonAntOrchestratorAcceptanceTest {

    @Test
    public void antBehavesAccordingToTheSpecifications() {

        InitialStateRandomizer mockInitialStateRandomiser = mock(InitialStateRandomizer.class);
        Navigator navigator = new Navigator();
        ExploredTerrain exploredTerrain = new ExploredTerrain();
        LangtonAntOrchestrator langtonAntInitializer = new LangtonAntOrchestrator(mockInitialStateRandomiser, navigator, exploredTerrain);
        when(mockInitialStateRandomiser.randomColour()).thenReturn(Colour.WHITE);
        when(mockInitialStateRandomiser.randomColour()).thenReturn(Colour.WHITE);
        when(mockInitialStateRandomiser.randomDirection()).thenReturn(Direction.NORTH);
        when(mockInitialStateRandomiser.randomCoordinates()).thenReturn(new Coordinates(0,0));

        langtonAntInitializer.step();

        assertThat(langtonAntInitializer.getAnt(), equalTo(new Ant(Colour.WHITE, Direction.SOUTH, CapacityStatus.FULL, new Coordinates(1,0))));


    }

}