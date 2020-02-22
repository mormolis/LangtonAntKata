package ant;

import ant.properties.Coordinates;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ExploredTerrain {


    private Map<Coordinates, Ant> terrain;

    public ExploredTerrain() {
        this.terrain = new HashMap<>();
    }

    public Optional<Ant> getAntByCoordinates(Coordinates coordinates) {
        final Ant ant = terrain.get(coordinates);
        if (ant == null) {
            return Optional.empty();
        }
        return Optional.of(ant);
    }

    public void addAnt(Ant ant) {
        terrain.put(ant.getCoordinates(), ant);
    }

    public Map<Coordinates, Ant> getTerrainCopy() {
        return new HashMap<>(terrain);
    }

}
