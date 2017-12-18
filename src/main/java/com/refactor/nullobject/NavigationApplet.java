package com.refactor.nullobject;

import java.applet.Applet;
import java.awt.*;

public class NavigationApplet extends Applet {

    private MouseEventHandler mouseEventHandler = new NullMouseEventHandler();

    public boolean mouseMoveTo(Event event, int x, int y) {
        return mouseEventHandler.mouseMove(getGraphics(), event, x, y);
    }

    public boolean mouseDownTo(Event event, int x, int y) {
        return mouseEventHandler.mouseDown(getGraphics(), event, x, y);
    }

    public boolean mouseUpTo(Event event, int x, int y) {
        return mouseEventHandler.mouseUp(getGraphics(), event, x, y);
    }

    public boolean mouseExitTo(Event event, int x, int y) {
        return mouseEventHandler.mouseExit(getGraphics(), event, x, y);
    }
}
