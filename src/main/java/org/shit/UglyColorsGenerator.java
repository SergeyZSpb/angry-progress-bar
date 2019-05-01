package org.shit;

import com.google.common.collect.Lists;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

public class UglyColorsGenerator {

    private final ArrayList<Color> theColors;

    private final Random random;

    private Color currentUglyColor;

    public UglyColorsGenerator() {
        theColors = Lists.newArrayList(
                hex2Rgb("#A805FA"),
                hex2Rgb("#FF9D00"),
                hex2Rgb("#FB00FF"),
                hex2Rgb("#00F7FF"),
                hex2Rgb("#5EFF00")
        );
        random = new Random();
        currentUglyColor = nextUglyColor();
    }

    public Color nextUglyColorChangedIf(Supplier<Boolean> predicate) {
        if (predicate.get()) {
            currentUglyColor = nextUglyColor();
        }
        return currentUglyColor;
    }

    private Color nextUglyColor() {
        return theColors.get(random.nextInt(theColors.size()));
    }

    private Color hex2Rgb(String colorStr) {
        return new Color(
                Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
                Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
                Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
    }
}
