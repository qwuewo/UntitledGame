import java.awt.*;
import java.awt.geom.Path2D;

public class BaseUnit extends GameObject {

    public BaseUnit() {
    }

    public BaseUnit(int id, float x, float y, int size, float speed) {
        super(id, x, y, size, speed, Color.BLACK);
    }

    // Сеттеры для координат
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void draw(Graphics g) {
        int x = (int) this.x;
        int y = (int) this.y;
        // масштабный коэффициент: базовый размер принят за 100
        float k = this.size / 100.0f;
        if (k <= 0) k = 1.0f; // защита от нулевого размера

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // тень
        g2.setColor(new Color(0, 0, 0, 40));
        g2.fillOval(Math.round(x - 25 * k), Math.round(y + 50 * k),
                Math.round(150 * k), Math.round(20 * k));


        // всадник
        g2.setColor(new Color(108, 29, 13));
        g2.fillRoundRect(Math.round(x + 15 * k), Math.round(y - 40 * k),
                Math.round(40 * k), Math.round(50 * k),
                Math.round(35 * k), Math.round(75 * k));
        g2.setColor(new Color(217, 142, 73));
        g2.fillOval(Math.round(x + 17 * k), Math.round(y - 65 * k),
                Math.round(35 * k), Math.round(35 * k));
        g2.setColor(new Color(0, 0, 0));
        g2.fillOval(Math.round(x + 42 * k), Math.round(y - 57 * k),
                Math.round(5 * k), Math.round(10 * k));
        g2.fillOval(Math.round(x + 33 * k), Math.round(y - 55 * k),
                Math.round(5 * k), Math.round(10 * k));


        Graphics2D gBat = (Graphics2D) g2.create();

        double angle = Math.toRadians(-40);
        int bx = Math.round(x + 50 * k);
        int by = Math.round(y - 20 * k);

        gBat.rotate(angle, bx, by);

        // форма биты (вся бита целиком, включая рукоятку)
        Path2D bat = new Path2D.Float();

        // Начинаем с набалдашника (самый левый край)
        bat.moveTo(bx - 18 * k, by);                     // левый край набалдашника
        bat.lineTo(bx - 12 * k, by - 5 * k);             // переход к рукоятке
        bat.lineTo(bx - 8 * k, by - 6 * k);              // сужение рукоятки
        bat.lineTo(bx, by - 5 * k);                      // начало рукоятки
        bat.lineTo(bx + 35 * k, by - 5 * k);             // рукоятка
        bat.lineTo(bx + 55 * k, by - 10 * k);            // плавное расширение
        bat.lineTo(bx + 100 * k, by - 15 * k);           // широкая часть
        bat.lineTo(bx + 115 * k, by - 10 * k);           // сужение к концу
        bat.lineTo(bx + 115 * k, by);                    // кончик биты
        bat.lineTo(bx + 115 * k, by + 10 * k);           // нижняя часть конца
        bat.lineTo(bx + 100 * k, by + 15 * k);           // нижняя широкая часть
        bat.lineTo(bx + 55 * k, by + 10 * k);            // сужение обратно
        bat.lineTo(bx + 35 * k, by + 5 * k);             // возврат к рукоятке
        bat.lineTo(bx, by + 5 * k);                      // конец рукоятки
        bat.lineTo(bx - 8 * k, by + 6 * k);              // расширение к набалдашнику
        bat.lineTo(bx - 12 * k, by + 5 * k);             // набалдашник нижняя часть
        bat.closePath();

        // градиент для металлической биты
        GradientPaint metal = new GradientPaint(
                bx - 10 * k, by,
                new Color(200, 40, 40),
                bx + 100 * k, by,
                new Color(100, 20, 20)
        );

        gBat.setPaint(metal);
        gBat.fill(bat);

        // добавляем темную обмотку на рукоятку (поверх, но без разрывов)
        gBat.setColor(new Color(20, 20, 20));
        gBat.fillRoundRect(
                bx - Math.round(5 * k),
                by - Math.round(6 * k),
                Math.round(40 * k),
                Math.round(12 * k),
                8, 8
        );

        // блик на бите
        gBat.setColor(new Color(255, 220, 220, 120));
        gBat.setStroke(new BasicStroke(3 * k));
        gBat.drawLine(
                Math.round(bx + 20 * k),
                Math.round(by - 2 * k),
                Math.round(bx + 105 * k),
                Math.round(by - 8 * k)
        );

        // дополнительный блик для объема
        gBat.setColor(new Color(255, 200, 200, 80));
        gBat.setStroke(new BasicStroke(2 * k));
        gBat.drawLine(
                Math.round(bx + 40 * k),
                Math.round(by - 4 * k),
                Math.round(bx + 95 * k),
                Math.round(by - 10 * k)
        );

        gBat.dispose();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        this.x = x;
        this.y = y + 40;
        draw(g);
    }
}