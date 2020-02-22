package ant;

import ant.properties.Colour;

public class ColourFlipper {

    public Colour flip(Colour currentColour) {
        return Colour.values()[(currentColour.ordinal() + 1) % 2];
    }
}
