/**
 * @author benjaminlewis-jones
 * This is the launcher, all it does is call the program loop
 */
public class Launcher {

    /**
     * calls the main program loop
     * @param args none are processed
     */
    public static void main(String[] args) {
        ProgramLoop runnable = new ProgramLoop(800, 400, 60);
        Thread programThread = new Thread(runnable);

        programThread.start();
    }
}
