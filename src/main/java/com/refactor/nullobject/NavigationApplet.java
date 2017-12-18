package com.refactor.nullobject;

import java.applet.Applet;
import java.awt.*;

public class NavigationApplet extends Applet {

    private MouseEventHandler mouseEventHandler;

    public boolean mouseMoveTo(Event event, int x, int y){
        if(mouseEventHandler != null){
            return mouseEventHandler.mouseMove(getGraphics(), event, x, y);
        }
        return true;
    }

    public boolean mouseDownTo(Event event, int x, int y){
        if(mouseEventHandler != null){
            return mouseEventHandler.mouseDown(getGraphics(), event, x, y);
        }
        return true;
    }

    public boolean mouseUpTo(Event event, int x, int y){
        if(mouseEventHandler != null){
            return mouseEventHandler.mouseUp(getGraphics(), event, x, y);
        }
        return true;
    }

    public boolean mouseExitTo(Event event, int x, int y){
        if(mouseEventHandler != null){
            return mouseEventHandler.mouseExit(getGraphics(), event, x, y);
        }
        return true;
    }
}
