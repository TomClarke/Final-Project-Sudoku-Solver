package src;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.util.List;
import javax.swing.*;

//Modified from 
//http://stackoverflow.com/questions/16288303/best-example-for-creating-programmatically-splashscreen-with-text

public class SplashScreen {
	
	private JDialog dialog;
    private JProgressBar progress;

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

				
            }

        };
        worker.execute();
    }

    protected void hideSplashScreen() {
        dialog.setVisible(false);
        dialog.dispose();
    }

    protected void showSplashScreen() throws MalformedURLException {
        dialog = new JDialog((Frame) null);
        JLabel background = new JLabel(new ImageIcon(SudokuMenuView.class.getResource("/src/SudokuTitle.jpg")));
        background.setLayout(new BorderLayout());
        dialog.add(background);
     
        progress = new JProgressBar();
        background.add(progress, BorderLayout.SOUTH);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }


	public void actionPerformed(ActionEvent e) {
		
	}

}
