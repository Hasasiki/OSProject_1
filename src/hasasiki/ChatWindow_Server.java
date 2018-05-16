package hasasiki;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChatWindow_Server {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatWindow_Server window = new ChatWindow_Server();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChatWindow_Server() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//The chat zone
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 29, 414, 139);
		frame.getContentPane().add(textPane);
		
		
		textField = new JTextField();
		textField.setBounds(10, 189, 306, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			//Submit button clicked method -->
			//here need a multi thread to handle the real-time update  
			public void mouseClicked(MouseEvent arg0) {
				textPane.setText("");
			}
		});
		btnNewButton.setBounds(331, 188, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblServer = new JLabel("Server");
		lblServer.setBounds(10, 4, 54, 15);
		frame.getContentPane().add(lblServer);
		
		JLabel lblNewLabel = new JLabel("Port:");
		lblNewLabel.setBounds(10, 236, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(49, 233, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
