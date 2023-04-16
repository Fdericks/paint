package groupProject.paint.main;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImageSaver {

	
	/**
	 * 
	 * @param panel
	 */
	public void saveImage(JPanel panel) {
		// Create Panel to go inside Input Dialog
		String fileName;
		String fileExtension;
//		JPanel filePanel = new JPanel();
		fileExtension = "png";

//		JComboBox<String> extension = new JComboBox<String>(extensionStr); // drop-down menu
//		extension.setVisible(true);
//		filePanel.add(new JLabel("Input file name."));
//		filePanel.add(extension);
		try {
			fileName = JOptionPane.showInputDialog(panel, "Input file name."); // get values from input dialog
			if (fileName != null && !fileName.isEmpty()) {

				// create graphics to be saved
				Dimension size = panel.getSize();
				BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_4BYTE_ABGR);
				Graphics2D g2 = image.createGraphics();
				panel.paint(g2);
				System.out.println(fileExtension);

				ImageIO.write((BufferedImage) image, fileExtension,
						new File(System.getProperty("user.dir"), fileName + "." + fileExtension));// parent directory
																									// and file.
				System.out.println("Panel saved as Image.");
				JOptionPane.showMessageDialog(panel, "Image saved.");

			} else {
				throw new RuntimeException("Input is null/cancel button pressed.");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(panel, "Image not saved.");
		}

	}
}
