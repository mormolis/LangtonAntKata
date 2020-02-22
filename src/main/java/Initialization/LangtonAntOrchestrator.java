package Initialization;

import ant.Ant;
import ant.ColourFlipper;
import ant.ExploredTerrain;
import ant.Navigator;
import ant.properties.CapacityStatus;
import ant.properties.navigator.Position;

public class LangtonAntOrchestrator {

    private InitialStateRandomizer initialStateRandomiser;
    private Navigator navigator;
    private ExploredTerrain exploredTerrain;
    private ColourFlipper colourFlipper;

    private Ant currentAnt;

    public LangtonAntOrchestrator(InitialStateRandomizer initialStateRandomiser, Navigator navigator,
                                  ExploredTerrain exploredTerrain, ColourFlipper colourFlipper) {

        this.initialStateRandomiser = initialStateRandomiser;
        this.navigator = navigator;
        this.exploredTerrain = exploredTerrain;
        this.colourFlipper = colourFlipper;
        placeFirstAntRandomly();
    }


    public void step() {
        final Position newAntsPosition = navigator.navigateFrom(
                currentAnt.getCurrentDirection(),
                currentAnt.getCurrentColour(),
                currentAnt.getCoordinates()
        );
        Ant ant = getNewAnt(newAntsPosition);
        changeCurrentAntsCapacityAndColour();
        currentAnt = ant;
    }

    private Ant getNewAnt(Position position) {

        Ant ant = exploredTerrain.getAntByCoordinates(position.getCoordinates())
                .orElseGet(() -> {
                    final Ant newAnt = new Ant(initialStateRandomiser.randomColour(), position.getDirection(), CapacityStatus.FULL, position.getCoordinates());
                    exploredTerrain.addAnt(newAnt);
                    return newAnt;
                });

        ant.setCapacityStatus(CapacityStatus.FULL);
        ant.setCurrentDirection(position.getDirection());

        return ant;
    }

    private void changeCurrentAntsCapacityAndColour() {
        exploredTerrain.getAntByCoordinates(currentAnt.getCoordinates())
                .ifPresent(currentAnt -> {
                    currentAnt.setCapacityStatus(CapacityStatus.EMPTY);
                    currentAnt.setCurrentColour(colourFlipper.flip(currentAnt.getCurrentColour()));
                });
    }

    public Ant getCurrentAnt() {
        return currentAnt;
    }

    private void placeFirstAntRandomly() {

        this.currentAnt = new Ant(
                initialStateRandomiser.randomColour(),
                initialStateRandomiser.randomDirection(),
                CapacityStatus.FULL,
                initialStateRandomiser.randomCoordinates()
        );

        exploredTerrain.addAnt(currentAnt);
    }

}
