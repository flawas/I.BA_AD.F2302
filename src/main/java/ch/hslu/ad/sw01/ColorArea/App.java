package ch.hslu.ad.sw01.ColorArea;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public class App {

    private static int countColorPixel = 0;
    private static int countColorArea = 0;

    public static void main(String[] args) {
        colorArea(5, 4, Color.gray, Color.black);
        System.out.println("colorPixel Aufrufe: " + countColorPixel);
        System.out.println("colorArea Aufrufe: " + countColorArea);
    }

    private static Color[][] area = new Color[][] {
            { Color.black, Color.black, Color.black, Color.black, Color.black, Color.black, Color.black, Color.black, Color.black, Color.black },
            { Color.black, Color.white, Color.white, Color.white, Color.white, Color.white, Color.white, Color.white, Color.white, Color.black },
            { Color.black, Color.white, Color.white, Color.white, Color.black, Color.black, Color.black, Color.black, Color.white, Color.black },
            { Color.black, Color.white, Color.white, Color.white, Color.black, Color.black, Color.black, Color.black, Color.white, Color.black },
            { Color.black, Color.black, Color.white, Color.white, Color.white, Color.white, Color.white, Color.black, Color.white, Color.black },
            { Color.black, Color.black, Color.white, Color.white, Color.white, Color.black, Color.white, Color.black, Color.white, Color.black },
            { Color.black, Color.black, Color.black, Color.white, Color.white, Color.black, Color.white, Color.black, Color.white, Color.black },
            { Color.black, Color.black, Color.black, Color.white, Color.white, Color.black, Color.white, Color.white, Color.white, Color.black },
            { Color.black, Color.black, Color.white, Color.white, Color.white, Color.black, Color.black, Color.black, Color.black, Color.black },
            { Color.black, Color.black, Color.white, Color.white, Color.white, Color.black, Color.black, Color.black, Color.black, Color.black },
            { Color.black, Color.black, Color.black, Color.black, Color.black, Color.black, Color.black, Color.black, Color.black, Color.black }
    };

    public static void colorArea(final int x, final int y, final Color fillColor, final Color outsideColor) {
        countColorArea++;
        Color actualColor = area[x - 1][y - 1];
        if ((actualColor != outsideColor) && (actualColor != fillColor)) {
            area[x - 1][y - 1] = fillColor;
            countColorPixel++;
            System.out.println(String.format("x: %d, y: %d", x, y));
            colorArea(x + 1, y, fillColor, outsideColor);
            colorArea(x, y + 1, fillColor, outsideColor);
            colorArea(x - 1, y, fillColor, outsideColor);
            colorArea(x, y - 1, fillColor, outsideColor);
        }
    }
}
