package java_chobo02_ch16_udp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java_chobo02_ch16_udp.FrameMessengerA_Gun.Messenger_Thread;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class FrameMessengerB_Gun extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;

	DatagramSocket socket;
	DatagramPacket packet;
	InetAddress address = null;
	final int myPort = 6000;
	final int otherPort = 5000;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMessengerB_Gun frame = new FrameMessengerB_Gun();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrameMessengerB_Gun() {
		initialize();
	}
	private void initialize() {
		setTitle("MessengerB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.addActionListener(this);
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(30);
		
		textArea = new JTextArea();
		textArea.setRows(10);
		textArea.setColumns(30);
		textArea.setEditable(false);
		contentPane.add(textArea, BorderLayout.CENTER);
		
		try {
			address = InetAddress.getByName("127.0.0.1");
			socket = new DatagramSocket(myPort);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	      catch (SocketException e) {
			e.printStackTrace();
		}
		
		Messenger_Thread th = new Messenger_Thread();
		th.start();
	}

	public void actionPerformed(ActionEvent e) {
		String s = textField.getText();
		byte[] buffer = s.getBytes();
		DatagramPacket packet;
		
		packet = new DatagramPacket(buffer, buffer.length, address, otherPort);
		try {
			socket.send(packet);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		textArea.append("SENT : " + s + "\n" );
		textField.selectAll();
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}	
		class Messenger_Thread extends Thread{
			@Override
			public void run() {
				while(true) {					
					try {
						byte[] buf = new byte[256];
						packet = new DatagramPacket(buf, buf.length);
						socket.receive(packet);
						textArea.append("RECIEVED : " + new String(buf) +  "\n");
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
			
		}
		
	}
}
