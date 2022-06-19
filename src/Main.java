import org.academiadecodigo.bootcamp.grid.KeyboardController;
import org.academiadecodigo.bootcamp.grid.MapEditor;

public class Main {

    public static void main(String[] args) {

        MapEditor mapEditor = new MapEditor(20, 20);
        new KeyboardController(mapEditor);

    }
}

