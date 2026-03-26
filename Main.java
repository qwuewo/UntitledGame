import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Engine engine = Engine.getInstance();
        Tower tower = new Tower(1, 3350, 900, 50, 0);
        tower.setFraction(0);
        engine.spawnObject(tower);
        GameView gameView = new GameView(engine);
        JFrame frame = new JFrame("Untitled Game");
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());
        frame.add(gameView);
        frame.add(new Controls(engine), BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}