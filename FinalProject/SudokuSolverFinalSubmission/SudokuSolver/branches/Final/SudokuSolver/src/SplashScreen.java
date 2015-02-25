package src;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.net.MalformedURLException;
import java.util.List;
import javax.swing.*;

//Modified from 
//http://stackoverflow.com/questions/16288303/best-example-for-creating-programmatically-splashscreen-with-text

/**
 * The Class SplashScreen that is the box that will .
 */
public class SplashScreen {
	
	/** The dialog box that contains the information. */
	private JDialog dialogBox;
    
    /** The progress bar the will slowly complete */
    private JProgressBar progress;

    /**
     * Initiates the user interface meaning the splash screen
     * a swing worker is used to allow a computation to be made in the background which 
     * adds to the progress bar, when done the splash screen is hidden.
     *
     * @throws MalformedURLException the malformed url exception
     */
    protected void initUI() throws MalformedURLException {
        showSplashScreen();
        
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {

            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(10);
                    publish(i);
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                progress.setValue(chunks.get(chunks.size() - 1));
            }

            @Override
            protected void done() {
            hideSplashScreen();

            }
        };
        worker.execute();
    }

    /**
     * Hides the splash screen by setting is as invisible.
     */
    protected void hideSplashScreen() {
    	dialogBox.setVisible(false);
    }

    /**
     * Show the splash screen , by creating the JFrame, inserting the image 
     * and the progress bar, this is then set to visible. 
     *
     * @throws MalformedURLException the malformed url exception
     */
    protected void showSplashScreen() throws MalformedURLException {
    	dialogBox = new JDialog((Frame) null);
        JLabel background = new JLabel(new ImageIcon(SudokuMenuView.class.getResource("/src/SudokuTitle.jpg")));
        background.setLayout(new BorderLayout());
        dialogBox.add(background);
     
        progress = new JProgressBar();
        background.add(progress, BorderLayout.SOUTH);
        dialogBox.pack();
        dialogBox.setLocationRelativeTo(null);
        dialogBox.setVisible(true);
    }
	
}
