package com.refactor.nullobject;

import javax.naming.Context;
import java.awt.*;

public class MouseEventHandler {
    private final Context context;

    public MouseEventHandler(Context context) {
        this.context = context;
    }

    public boolean mouseMove(Graphics graphics, Event event, int x, int y) {
        return false;
    }

    public boolean mouseDown(Graphics graphics, Event event, int x, int y) {
        return false;
    }

    public boolean mouseUp(Graphics graphics, Event event, int x, int y) {
        return false;
    }

    public boolean mouseExit(Graphics graphics, Event event, int x, int y) {
        return false;
    }
}
