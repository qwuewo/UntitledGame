import javax.swing.*;
import java.awt.*;

/**
 * Главный класс игры.
 * Исправлено: башня теперь корректно создаётся посередине экрана.
 * <p>
 * By AmericanCoolBoyUSA777
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Engine engine = Engine.getInstance();

            // координаты башни
            int towerX = engine.getScreenWidth() / 2 + 200;
            int towerY = engine.getScreenHeight() - 180;

            Tower tower = new Tower(1, (float) towerX, (float) towerY, 100, 0f);
            tower.setFraction(2);
            engine.spawnObject(tower);

            GameView gameView = new GameView(engine);
            JFrame frame = new JFrame("Tower Battle - Archer Defense");
            frame.setSize(engine.getScreenWidth(), engine.getScreenHeight());
            frame.setLayout(new BorderLayout());
            frame.add(gameView, BorderLayout.CENTER);
            frame.add(new Controls(engine), BorderLayout.SOUTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
