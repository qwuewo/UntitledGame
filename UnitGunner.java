import java.awt.*;

public class UnitGunner extends GameObject {

    @Override
    protected void update(float dt) {
        // движение влево
        x -= 100 * dt; // скорость движения
    }

    @Override
    protected void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int offsetX = (int) x;
        int offsetY = (int) y;

        // шлем
        g2.setColor(new Color(55, 120, 14));
        g2.fillOval(offsetX + 45, offsetY + 10, 30, 30);
        g2.setColor(Color.BLACK);
        g2.drawOval(offsetX + 45, offsetY + 10, 30, 30);

        // лицо
        g2.setColor(new Color(255, 233, 214));
        g2.fillRoundRect(offsetX + 50, offsetY + 20, 16, 14, 4, 4);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(offsetX + 50, offsetY + 20, 16, 14, 4, 4);

        // глаза
        g2.fillOval(offsetX + 53, offsetY + 25, 2, 2);
        g2.fillOval(offsetX + 60, offsetY + 25, 2, 2);

        // тело
        g2.setColor(new Color(55, 120, 14));
        g2.fillRoundRect(offsetX + 51, offsetY + 36, 22, 18, 5, 5);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(offsetX + 51, offsetY + 36, 22, 18, 5, 5);

        // автомат полностью
        // приклад
        g2.setColor(new Color(60, 60, 70));
        g2.fillRoundRect(offsetX + 64, offsetY + 37, 16, 11, 2, 2);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(offsetX + 64, offsetY + 37, 16, 11, 2, 2);

        // основа
        g2.setColor(new Color(85, 90, 100));
        g2.fillRoundRect(offsetX + 25, offsetY + 39, 40, 7, 2, 2);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(offsetX + 25, offsetY + 39, 40, 7, 2, 2);

        // ствол
        g2.setColor(new Color(70, 70, 80));
        g2.fillRect(offsetX + 14, offsetY + 41, 11, 3);
        g2.setColor(Color.BLACK);
        g2.drawRect(offsetX + 14, offsetY + 41, 11, 3);

        // магазин
        g2.setColor(new Color(75, 75, 85));
        g2.fillRect(offsetX + 56, offsetY + 46, 5, 8);
        g2.setColor(Color.BLACK);
        g2.drawRect(offsetX + 56, offsetY + 46, 5, 8);

        // рукоять
        g2.setColor(new Color(60, 60, 70));
        g2.fillRoundRect(offsetX + 41, offsetY + 46, 5, 7, 2, 2);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(offsetX + 41, offsetY + 46, 5, 7, 2, 2);
    }
}
