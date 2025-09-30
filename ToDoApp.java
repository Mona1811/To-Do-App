package TODoList;

import javax.swing.*;
import java.awt.*;

public class ToDoApp {

    private DefaultListModel<String> taskListModel; // stores tasks
    private JList<String> taskList; // displays tasks
    private JTextField taskField; // input field
    private JButton addButton, deleteButton;

    public ToDoApp() {
        // Frame setup
        JFrame frame = new JFrame("To-Do List App");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Task input field
        taskField = new JTextField();
        frame.add(taskField, BorderLayout.NORTH);

        // Task list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Task");
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Add task action
        addButton.addActionListener(_ -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText(""); // clear input
            } else {
                JOptionPane.showMessageDialog(frame, "Enter a task first!");
            }
        });

        // Delete task action
        deleteButton.addActionListener(_ -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a task to delete!");
            }
        });

        // Show frame
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}
