import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class CreateJFrameWindowWithMouseEventHandling extends JFrame implements MouseListener {

    private static final long serialVersionUID = 1L;

    public CreateJFrameWindowWithMouseEventHandling() {
        setTitle("Simple Frame");
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("1Mouse Clicked at X: " + x + " - Y: " + y);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("鼠标进入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("鼠标移除");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("4Mouse Pressed at X: " + x + " - Y: " + y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("5Mouse Released at X: " + x + " - Y: " + y);
    }

    private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new CreateJFrameWindowWithMouseEventHandling();

        //Display the window.
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
