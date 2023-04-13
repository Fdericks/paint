package groupProject.paint.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {

		int frameWidth = 700; // pixel num.
		int frameHeight = 700;

		// define JFrame
		JFrame mainFrame = new JFrame("Paint");
		mainFrame.setSize(frameWidth, frameHeight);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// define panels with layouts

		JPanel mainPanel = new JPanel();

		// Top Panel layout setup
		JPanel shapeButtonPanel = new JPanel();
		JPanel colorButtonPanel = new JPanel();
		JPanel topPanel = new JPanel();
		topPanel.add(colorButtonPanel);
		topPanel.add(shapeButtonPanel);

		GridLayout gridLayout = new GridLayout(2, 0); // create grid of two rows and as many columns as necessary.
		colorButtonPanel.setLayout(gridLayout);
		shapeButtonPanel.setLayout(gridLayout);

		// canvas setup
		int canvasHeight = 615; // preferred height
		int canvasWidth = frameWidth - 15; // preferred width
		Canvas canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
		canvas.setBackground(Color.WHITE);

		// define buttons with action listeners

		ArrayList<JButton> colorButtons = new ArrayList<JButton>();
		ArrayList<JButton> shapeButtons = new ArrayList<JButton>();

		// color buttons
		JButton blackBtn = new JButton("Black");
		ActionListener blackAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.BLACK);
			}
		};
		blackBtn.addActionListener(blackAL);
		colorButtons.add(blackBtn);

		JButton redBtn = new JButton("Red");
		ActionListener redAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.RED);
			}
		};
		redBtn.addActionListener(redAL);
		colorButtons.add(redBtn);

		JButton oranBtn = new JButton("Orange");
		ActionListener oranAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.ORANGE);
			}
		};
		oranBtn.addActionListener(oranAL);
		colorButtons.add(oranBtn);

		JButton yellowBtn = new JButton("Yellow");
		ActionListener yellowAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.YELLOW);
			}
		};
		yellowBtn.addActionListener(yellowAL);
		colorButtons.add(yellowBtn);

		JButton greenBtn = new JButton("Green");
		ActionListener greenAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.GREEN);
			}
		};
		greenBtn.addActionListener(greenAL);
		colorButtons.add(greenBtn);

		JButton blueBtn = new JButton("Blue");
		ActionListener blueAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.BLUE);
			}
		};
		blueBtn.addActionListener(blueAL);
		colorButtons.add(blueBtn);

		JButton whiteBtn = new JButton("White");
		ActionListener whiteAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.WHITE);
			}
		};
		whiteBtn.addActionListener(whiteAL);
		colorButtons.add(whiteBtn);

		JButton colorButton = new JButton("Color");
		colorButton.addActionListener(e -> {
			Color color = JColorChooser.showDialog(colorButton, "Select Color", canvas.getColor());
			canvas.setColor(color);
		});
		colorButtons.add(colorButton);

		// shape buttons
		JButton rectBtn = new JButton("Rectangle");
		ActionListener rectAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setCurrentShape(new Rectangle());
			}

		};
		rectBtn.addActionListener(rectAL);
		shapeButtons.add(rectBtn);

		JButton emptyRectBtn = new JButton("Empty Rectangle");
		ActionListener emptyRectAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setCurrentShape(new EmptyRectangle());
			}

		};
		emptyRectBtn.addActionListener(emptyRectAL);
		shapeButtons.add(emptyRectBtn);

		JButton triangleBtn = new JButton("Triangle");
		ActionListener triangleAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setCurrentShape(new Triangle());
			}

		};
		triangleBtn.addActionListener(triangleAL);
		shapeButtons.add(triangleBtn);

		JButton empTriangleBtn = new JButton("Empty Triangle");
		ActionListener empTriangleAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setCurrentShape(new EmptyTriangle());
			}

		};
		empTriangleBtn.addActionListener(empTriangleAL);
		shapeButtons.add(empTriangleBtn);

		JButton circleBtn = new JButton("Circle");
		ActionListener circleAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setCurrentShape(new Circle());
			}

		};
		circleBtn.addActionListener(circleAL);
		shapeButtons.add(circleBtn);

		JButton empCircleBtn = new JButton("Empty Circle");
		ActionListener empCircleAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setCurrentShape(new EmptyCircle());
			}

		};
		empCircleBtn.addActionListener(empCircleAL);
		shapeButtons.add(empCircleBtn);

		JButton lineBtn = new JButton("Line");
		ActionListener lineAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setCurrentShape(new Line());
			}
		};
		lineBtn.addActionListener(lineAL);
		shapeButtons.add(lineBtn);
		
		JButton brushBtn = new JButton("Brush");
		ActionListener brushAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel brushPanel = new JPanel();
				String[] sizeStr = new String[8];
				sizeStr[0] = "1";
				sizeStr[1] = "2";
				sizeStr[2] = "5";
				sizeStr[3] = "8";
				sizeStr[4] = "10";
				sizeStr[5] = "12";
				sizeStr[6] = "15";
				sizeStr[7] = "20";
				
				JComboBox<String> size = new JComboBox<String>(sizeStr); // drop-down menu
				size.setVisible(true);
				
				brushPanel.add(new JLabel("Select Brush Size"));
				brushPanel.add(size);
				
				canvas.setCurrentShape(null);
				JOptionPane.showMessageDialog(canvas, brushPanel);
				int index = size.getSelectedIndex();
				float brushWidth = Float.parseFloat(sizeStr[index]);
				System.out.println(brushWidth);
				canvas.setBrushWidth(brushWidth);
			}
		};
		
		brushBtn.addActionListener(brushAL);
		shapeButtons.add(brushBtn);

		for (JButton button : colorButtons) {
			colorButtonPanel.add(button);
		}

		for (JButton button : shapeButtons) {
			shapeButtonPanel.add(button);
		}

		JButton saveImageBtn = new JButton("Save Image");
		ActionListener saveImageAL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveImage(canvas);
			}

		};

		saveImageBtn.addActionListener(saveImageAL);
		topPanel.add(saveImageBtn);

		// Main Panel Layout Setup
		GroupLayout layout = new GroupLayout(mainPanel);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		mainPanel.setLayout(layout);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup().addComponent(topPanel).addComponent(canvas)));
		layout.setVerticalGroup(layout.createSequentialGroup().addComponent(topPanel).addComponent(canvas));

		mainFrame.add(mainPanel);

		mainFrame.setVisible(true);
	}

	private static void saveImage(Component panel) {
		// Create Panel to go inside Input Dialog
		String fileName;
		String fileExtension;
		JPanel filePanel = new JPanel();
		String[] extensionStr = new String[2];
		extensionStr[0] = "png";
		extensionStr[1] = "jpeg";

		JComboBox<String> extension = new JComboBox<String>(extensionStr); // drop-down menu
		extension.setVisible(true);
		filePanel.add(new JLabel("Input file name and select file type."));
		filePanel.add(extension);

		fileName = JOptionPane.showInputDialog(panel, filePanel); // get values from input dialog
		fileExtension = (String) extension.getSelectedItem();

		// create graphics to be saved
		Dimension size = panel.getSize();
		BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g2 = image.createGraphics();
		panel.paint(g2);
		try {
			ImageIO.write(image, fileExtension,
					new File(System.getProperty("user.dir"), fileName + "." + fileExtension));
			System.out.println(System.getProperty("user.dir"));
			System.out.println("Panel saved as Image.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(panel, "Error: Image not saved.");
//			e.printStackTrace();
		}
	}
}
