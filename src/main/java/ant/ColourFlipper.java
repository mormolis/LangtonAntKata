package ant;

import ant.properties.Colour;

public class ColourFlipper {

    public Colour flip(Colour currentColour) {
        final Colour[] availableColours = Colour.values();
        return availableColours[(currentColour.ordinal() + 1) % availableColours.length];
    }
}
