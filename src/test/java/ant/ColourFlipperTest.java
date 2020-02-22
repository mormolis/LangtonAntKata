package ant;

import ant.properties.Colour;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ColourFlipperTest {

    @Test
    public void whenColourIsBlackWhenFlippedIsWhite(){
        ColourFlipper colourFlipper = new ColourFlipper();

        assertThat(colourFlipper.flip(Colour.BLACK), equalTo(Colour.WHITE));
    }

    @Test
    public void whenColourIsWhiteWhenFlippedIsBlack(){
        ColourFlipper colourFlipper = new ColourFlipper();

        assertThat(colourFlipper.flip(Colour.WHITE), equalTo(Colour.BLACK));
    }


}