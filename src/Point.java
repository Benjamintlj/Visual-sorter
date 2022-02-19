import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author benjaminlewis-jones
 * This class stores the random list, and the rectangles associated with each element in that list
 */
public class Point {

    static ArrayList<Integer> list;
    final int pointIndex;
    Rectangle rectangle;

    /**
     * Creates rectangle and stores the index of the point
     *
     * @param index sets the index of the point, used for determining the rectangle parameters
     */
    public Point(int index) {
        pointIndex = index;

        int width = 2;
        int height = list.get(pointIndex) * 2;
        int x = ((pointIndex + 1) * 7) + 40;
        int y = 300 - height;
        rectangle = new Rectangle(x, y, width, height);
    }

    /**
     * creates the randomly generated list
     */
    public static void generateList() {
        Random random = new Random();
        list = new ArrayList<>();

        int upperBound = 100;

        for (int i = 0; i < 100; i++) list.add(random.nextInt(upperBound));
    }

    /**
     * @return returns the lists current state
     */
    public static ArrayList<Integer> getList() {
        return list;
    }

    /**
     * @param list updates the list with the value of the parameter
     */
    public static void setList(ArrayList<Integer> list) {
        Point.list = list;
    }

    /**
     * returns the value of the point
     *
     * @return value of the object in the list
     */
    public int getPointValue() {
        return list.get(pointIndex);
    }

    /**
     * updates the rectangles attributes based on the value of the object
     */
    private void updateRectangle() {
        rectangle.height = list.get(pointIndex) * 2;
        rectangle.x = ((pointIndex + 1) * 7) + 40;
        rectangle.y = 300 - rectangle.height;
    }

    /**
     * @return returns the rectangle
     */
    public Rectangle getRectangle() {
        updateRectangle();
        return rectangle;
    }
}
