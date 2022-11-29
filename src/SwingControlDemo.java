import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingControlDemo implements ActionListener {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;// the menu
    private JMenuItem cut, copy, paste, selectAll;// the menu bar drop down
    private JTextArea ta;// the text box
    private int WIDTH=800;
    private int HEIGHT=700;


    public SwingControlDemo() {
        prepareGUI();
    }

    public static void main(String[] args) {
        SwingControlDemo swingControlDemo = new SwingControlDemo();
        swingControlDemo.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");// grey text that pops up in the top left
        mainFrame.setSize(WIDTH, HEIGHT);// this is how large it is.
        mainFrame.setLayout(new GridLayout(3, 1));// this sets the gridlayout, and this one sets GirdLyout as 3 rows and 1 column


        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");
        cut.addActionListener(this);// this= refering to the class: the place that the button is being clicked is on this button.
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

// this just names the Jmenu buttons
        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        // this adds all of the functions to the menu bar
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);

        ta = new JTextArea();
        ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);// this is how you would set the bounds of each area.
        //this wont work since gridlayout makes all the bounds = to each other
        mainFrame.add(mb);
        mainFrame.add(ta);
        mainFrame.setJMenuBar(mb);
// this makes the label fill itself when you click it
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);
// this is where you make a method inside a method
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {// just closes the window and stops the program
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        // Flow Layout starts from the top and makes it only as spacious as needed
        // You can change the bounds of the flow layout unlike gridlayout

       // mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);// the middle panel that has the buttons, which means there is flowlayout in a gridlayout
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);// makes things show up
    }

    private void showEventDemo() {
        headerLabel.setText("Control in action: Button");

        //sets text of buttons
        JButton okButton = new JButton("OK");
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");
        // making the label appear at the bottom
        okButton.setActionCommand("OK");
        submitButton.setActionCommand("Submit");
        cancelButton.setActionCommand("Cancel");

        okButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());

        controlPanel.add(okButton);
        controlPanel.add(submitButton);
        controlPanel.add(cancelButton);

        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //this codes what actually happens when you press cut, paste, copy, and seletAll
        if (e.getSource() == cut)
            ta.cut();
        if (e.getSource() == paste)
            ta.paste();
        if (e.getSource() == copy)
            ta.copy();
        if (e.getSource() == selectAll)
            ta.selectAll();
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("OK")) {
                statusLabel.setText("Ok Button clicked.");
            } else if (command.equals("Submit")) {
                statusLabel.setText("Submit Button clicked.");
            } else {
                statusLabel.setText("Cancel Button clicked.");
            }
        }
    }
}