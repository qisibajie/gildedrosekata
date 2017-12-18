package com.refactor.nullobject;

import javax.naming.Context;
import java.awt.*;

public class NullMouseEventHandler extends MouseEventHandler {
    public NullMouseEventHandler(Context context){
        super(context);
    }

    public boolean mouseDown(Graphics graphics, Event event, int x, int y) {
        return true;
    }

    public boolean mouseUp(Graphics graphics, Event event, int x, int y) {
        return true;
    }

    public boolean mouseExit(Graphics graphics, Event event, int x, int y) {
        return true;
    }
}
