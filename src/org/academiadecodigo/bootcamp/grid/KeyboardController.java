package org.academiadecodigo.bootcamp.grid;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardController implements KeyboardHandler {

    private final MapEditor mapEditor;

    public KeyboardController(MapEditor mapEditor) {

        this.mapEditor = mapEditor;
        initKeyboard();

    }

    private void initKeyboard() {

        Keyboard keyboard = new Keyboard(this);
        int[] keys = {
                KeyboardEvent.KEY_RIGHT,
                KeyboardEvent.KEY_LEFT,
                KeyboardEvent.KEY_DOWN,
                KeyboardEvent.KEY_UP,
                KeyboardEvent.KEY_S,
                KeyboardEvent.KEY_SPACE,
                KeyboardEvent.KEY_C,
                KeyboardEvent.KEY_L
        };

        for (int i = 0; i < keys.length; i++) {
            KeyboardEvent keyboardEvent = new KeyboardEvent();
            keyboardEvent.setKey(keys[i]);
            keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(keyboardEvent);
        }

        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_SPACE);
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(event);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                mapEditor.moveCursor(Cursor.Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                mapEditor.moveCursor(Cursor.Direction.LEFT);
                break;
            case KeyboardEvent.KEY_UP:
                mapEditor.moveCursor(Cursor.Direction.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                mapEditor.moveCursor(Cursor.Direction.DOWN);
                break;
            case KeyboardEvent.KEY_SPACE:
                mapEditor.setPainting(true);
                mapEditor.paintCell();
                break;
            case KeyboardEvent.KEY_C:
                mapEditor.clear();
                break;
            case KeyboardEvent.KEY_S:
                mapEditor.save();
                break;
            case KeyboardEvent.KEY_L:
                mapEditor.load();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            mapEditor.setPainting(false);
        }

    }

}
