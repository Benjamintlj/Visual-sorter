/**
 * @author benjaminlewis-jones
 * This class runs updates the screen at a specifed updates per second
 * The FPS is unlimited
 */
public class ProgramLoop implements Runnable {

    private Window window;

    private boolean running;
    private final double updateRate;

    private long nextStatTime;
    private int framesPerSecond, updatesPerSecond;


    /**
     * inits window, which inits display, which creates a new display
     * @param width display width
     * @param height display height
     */
    public ProgramLoop(int width, int height, int updatesPerASecond) {
        window = new Window(width, height);
        updateRate = 1.0d/updatesPerASecond;
    }

    /**
     * program loop updates all the objects, from the window class,
     * at a rate specified by the updateRate,
     * the fps is unlimited
     */
    @Override
    public void run() {
        running = true;
        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();
        nextStatTime = System.currentTimeMillis() + 1000;

        while(running) {
            currentTime = System.currentTimeMillis();
            double timeTakenToRenderLastFrame = (currentTime - lastUpdate) / 1000.0d;
            accumulator += timeTakenToRenderLastFrame;
            lastUpdate = currentTime;

            while(accumulator > timeTakenToRenderLastFrame) {
                update();
                accumulator -= updateRate;
            }

            render();
            //printStats();
        }
    }

    /**
     * updates all window objects
     */
    private void update() {
        window.update();
        updatesPerSecond++;
    }

    /**
     * renders the next frame
     */
    private void render() {
        window.render();
        framesPerSecond++;
    }

    /**
     * Prints FPS and UPS to the terminal
     */
    private void printStats() {
        if(System.currentTimeMillis() > nextStatTime) {
            System.out.println("FPS: " + framesPerSecond + " UPS: " + updatesPerSecond);
            framesPerSecond = 0;
            updatesPerSecond = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }
}
