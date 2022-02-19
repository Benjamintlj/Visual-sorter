import java.util.ArrayList;

/**
 * @author benjaminlewis-jones
 * this class stores all the applications objects
 * it also renders them
 */
public class Window {

    Thread sort;
    private final Display display;
    private final ArrayList<Point> pointList;
    private final SortingAlgorithms sortingAlgorithms;

    /**
     * inits all objects,
     * and also creates a new display
     *
     * @param width  display width
     * @param height display height
     */
    public Window(int width, int height) {
        display = new Display(width, height);

        // create all points, with random values for each
        Point.generateList();
        pointList = new ArrayList<Point>();
        for (int i = 0; i < 100; i++) pointList.add(new Point(i));

        // create sort thread
        sortingAlgorithms = new SortingAlgorithms();
        sort = new Thread(sortingAlgorithms);
        sort.start();
    }

    /**
     * used to update each of the objects for the next frame
     */
    public void update() {
        if (sort.isAlive()) sort.resume();
    }

    /**
     * renders the next frame
     */
    public void render() {
        display.render(this);
    }

    /**
     * used to return a vector of rectangle objects, for rendering
     *
     * @return returns the rectangle object vector
     */
    public ArrayList<Point> getPointList() {
        return pointList;
    }

}
