import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Creating the connection variable
	Connection dbConnection;

	/**
	 * Create the frame.
	 */
	public GUI() {

		// Create the instance
		dbConnection = databaseConnection.dataConnection();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQueryResults = new JLabel("Query Results");
		lblQueryResults.setFont(new Font("Serif", Font.PLAIN, 36));
		lblQueryResults.setBounds(228, 13, 201, 47);
		contentPane.add(lblQueryResults);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 72, 574, 240);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnDisplayResults = new JButton("Results");
		btnDisplayResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String sqlQuery = "SELECT * FROM Customers";
					PreparedStatement statement = dbConnection.prepareStatement(sqlQuery);
					// Add the Result Set
					ResultSet res = statement.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(res));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnDisplayResults.setBounds(274, 362, 117, 25);
		contentPane.add(btnDisplayResults);
	}
}
