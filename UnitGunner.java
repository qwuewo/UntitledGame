import javax.swing.*;
import java.awt.*;

public class UnitGunner extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);


        // шлем
        g2.setColor(new Color(55, 120, 14));
        g2.fillOval(180, 40, 120, 120);
        g2.setColor(Color.BLACK);
        g2.drawOval(180, 40, 120, 120);

        // защита
        g2.setColor(new Color(30, 73, 5));
        g2.fillOval(265, 75, 45, 70);
        g2.setColor(Color.BLACK);
        g2.drawOval(265, 75, 45, 70);

        // мордашка
        g2.setColor(new Color(255, 233, 214));
        g2.fillRoundRect(205, 90, 65, 55, 15, 15);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(205, 90, 65, 55, 15, 15);

        // глаза
        g2.fillOval(218, 110, 8, 8);
        g2.fillOval(245, 110, 8, 8);

        // рот
        g2.setStroke(new BasicStroke(3));
        g2.drawArc(225, 125, 20, 10, 180, 180);
        g2.setStroke(new BasicStroke(4));

        // тело
        g2.setColor(new Color(55, 120, 14));
        g2.fillRoundRect(210, 145, 85, 65, 20, 20);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(210, 145, 85, 65, 20, 20);

        // АВТОМАТ

        // приклад
        g2.setColor(new Color(60, 60, 70));
        g2.fillRoundRect(255, 150, 65, 45, 8, 8);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(255, 150, 65, 45, 8, 8);

        // основа
        g2.setColor(new Color(85, 90, 100));
        g2.fillRoundRect(100, 155, 160, 30, 8, 8);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(100, 155, 160, 30, 8, 8);

        // ствол
        g2.setColor(new Color(70, 70, 80));
        g2.fillRect(55, 163, 45, 14);
        g2.setColor(Color.BLACK);
        g2.drawRect(55, 163, 45, 14);

        // магазин
        g2.setColor(new Color(75, 75, 85));
        g2.fillRect(225, 185, 22, 32);
        g2.setColor(Color.BLACK);
        g2.drawRect(225, 185, 22, 32);

        // рукоять
        g2.setColor(new Color(60, 60, 70));
        g2.fillRoundRect(165, 185, 18, 28, 6, 6);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(165, 185, 18, 28, 6, 6);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Unit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 300);
        frame.setLocationRelativeTo(null);
        frame.add(new UnitDrawing());
        frame.setVisible(true);
    }
}