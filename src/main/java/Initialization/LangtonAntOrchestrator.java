package Initialization;

import ant.Ant;
import ant.ExploredTerrain;
import ant.Navigator;

public class LangtonAntOrchestrator {

    private InitialStateRandomizer initialStateRandomiser;
    private Navigator navigator;
    private ExploredTerrain exploredTerrain;

    public LangtonAntOrchestrator(InitialStateRandomizer initialStateRandomiser, Navigator navigator, ExploredTerrain exploredTerrain) {
        this.initialStateRandomiser = initialStateRandomiser;
        this.navigator = navigator;
        this.exploredTerrain = exploredTerrain;
    }

    public void step() {
        throw new UnsupportedOperationException();
    }

    public Ant getAnt() {
        throw new UnsupportedOperationException();
    }

}
