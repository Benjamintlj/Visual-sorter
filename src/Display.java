import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * @author benjaminlewis-jones
 * draws all objects and sets all display settings
 */
public class Display extends JFrame {

    private Canvas canvas;

    /**
     * set up display with various settings
     * @param width sets the display width
     * @param height sets the display height
     */
    public Display(int width, int height) {
        setTitle("Visual Sorter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
        pack();

        canvas.createBufferStrategy(3);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * renders the window
     * Note: all objects are draw here, thus all window objects must be looped through, to be rendered
     * @param window
     */
    public void render(Window window) {
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0, canvas.getWidth(), canvas.getHeight());

        graphics.setColor(Color.PINK);

        ArrayList<Point> pointList = window.getPointList();
        for (Point point : pointList) {
            graphics.fillRect((int) point.getRectangle().getX(),
                    (int) point.rectangle.getY(),
                    (int) point.rectangle.getWidth(),
                    (int) point.rectangle.getHeight());
        }


        graphics.dispose();
        bufferStrategy.show();
    }
}
