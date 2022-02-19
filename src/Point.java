import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Point {

    static ArrayList<Integer> list;
    final int pointIndex;
    Rectangle rectangle;

    public Point(int index) {
        pointIndex = index;

        int width = 2;
        int height = list.get(pointIndex) * 2;
        int x = ((pointIndex + 1) * 7) + 40;
        int y = 300 - height;
        rectangle = new Rectangle(x, y, width, height);
    }

    public static void generateList() {
        Random random = new Random();
        list = new ArrayList<>();

        int upperBound = 100;

        for (int i = 0; i < 100; i++) list.add(random.nextInt(upperBound));
    }

    public int getPointValue() {
        return list.get(pointIndex);
    }

    private void updateRectangle() {
        rectangle.height = list.get(pointIndex) * 2;
        rectangle.x = ((pointIndex + 1) * 7) + 40;
        rectangle.y = 300 - rectangle.height;
    }

    public Rectangle getRectangle() {
        updateRectangle();
        return rectangle;
    }

    public static ArrayList<Integer> getList() {
        return list;
    }

    public static void setList(ArrayList<Integer> list) {
        Point.list = list;
    }
}
