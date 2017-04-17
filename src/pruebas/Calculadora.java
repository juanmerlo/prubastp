package pruebas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		String ecuacion = "";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 3));
		
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);

		
		JButton boton1 = new JButton();
		boton1.setText("pow");
		JButton boton2 = new JButton();
		boton2.setText("sqrt");
		JButton boton3 = new JButton();
		boton3.setText("+");
		boton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "+");
				
			}
		});;
		JButton boton4 = new JButton();
		boton4.setText("-");
		boton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "-");
				
			}
		});;
		JButton boton5 = new JButton();
		boton5.setText("*");
		boton5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "*");
				
			}
		});;
		JButton boton6 = new JButton();
		boton6.setText("/");
		boton6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "/");
				
			}
		});;
		JButton boton7 = new JButton();
		boton7.setText("(");
		boton7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "(");
				
			}
		});;
		JButton boton8 = new JButton();
		boton8.setText(")");
		boton8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + ")");
				
			}
		});;
		
		panel.add(boton1);
		panel.add(boton2);
		panel.add(boton3);
		panel.add(boton4);
		panel.add(boton5);
		panel.add(boton6);
		panel.add(boton7);
		panel.add(boton8);

	

		

	}

}
