import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.*;

public class SwingControlDemo implements ActionListener {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JLabel urlLabel;
    private JLabel wordLabel;
    private JPanel controlPanel;
    private JPanel printerPanel;
    private JPanel resultPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;// the menu
    private JMenuItem cut, copy, paste, selectAll;// the menu bar drop down
    private JTextArea Ba;// the second text box
    private JTextArea ta;// the text box
    private JTextArea ca;// result box
    private JScrollPane scroll;
    private String taReal;
    private int xResult = 0;
    private int yResult = 0;
    private int WIDTH=800;
    private int HEIGHT=700;
//    public JPanel up;
//    public JButton but1,but2,but3;
//    public JFrame testFrame;
//    public JTextArea TA;


    public SwingControlDemo() {
        prepareGUI();
    }

    public static void main(String[] args) {
        SwingControlDemo swingControlDemo = new SwingControlDemo();
        swingControlDemo.showEventDemo();
    }

    private void prepareGUI() {
//        up = new JPanel();
//        but1= new JButton("boom");
//        but2= new JButton("a;lsdkfj");
//        but3= new JButton("trash");
//        testFrame= new JFrame(" Hales");
//        testFrame.setLayout(new GridLayout(1,1));
//        testFrame.setSize(400,400);
        ta= new JTextArea();
//        up.setLayout(new BorderLayout());
//        up.add(but1,BorderLayout.NORTH);
//        up.add(but2,BorderLayout.EAST);
//        up.add(ta,BorderLayout.CENTER);

        mainFrame = new JFrame("Java SWING Examples");// grey text that pops up in the top left
        mainFrame.setSize(WIDTH, HEIGHT);// this is how large it is.
        mainFrame.setLayout(new BorderLayout());// this sets the gridlayout, and this one sets GirdLyout as 3 rows and 1 column

        // this is where you make a method inside a method
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {// just closes the window and stops the program
                System.exit(0);
            }
        });

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
        mainFrame.add(mb);
        mainFrame.setJMenuBar(mb);

        Ba = new JTextArea();
        Ba.setEditable(true);
        ta = new JTextArea();
        ca = new JTextArea();

        Ba.setLineWrap(true);
        ta.setLineWrap(true);
        ca.setLineWrap(true);

//        Ba.setBounds(50, 5, WIDTH-100, HEIGHT-50);
//        ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);// this is how you would set the bounds of each area.
        ca.setBounds(50, 5, WIDTH-100, HEIGHT-50);
        //this wont work since gridlayout makes all the bounds = to each other

// this makes the label fill itself when you click it
        headerLabel = new JLabel("URL");
        statusLabel = new JLabel("word");
        urlLabel = new JLabel("URL");
        urlLabel.setHorizontalAlignment(JLabel.CENTER);
        wordLabel = new JLabel("Word");
        wordLabel.setHorizontalAlignment(JLabel.CENTER);

//        statusLabel.setSize(250, 100);



        controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());




        printerPanel = new JPanel();
//        printerPanel.setLayout(new BorderLayout());
        printerPanel.setLayout(new GridLayout(5,1));//order in which you add is order in which it appears.
        printerPanel.add(urlLabel);
        printerPanel.add(ta);
        printerPanel.add(wordLabel);
        printerPanel.add(Ba);
        printerPanel.add(controlPanel);

//        statusLabel.add(ca);



        //up.setLayout(new BorderLayout());
//        up.add(but1,BorderLayout.NORTH);

      //  controlPanel.add(new Button("test"),BorderLayout.EAST);


        resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());



        //this is scroll code
        ca.setEditable(true); // set textArea non-editable
        scroll = new JScrollPane(ca);// this makes the scroll part of the resut panle without making it messed up
//        resultPanel.add(ca,BorderLayout.CENTER);
        resultPanel.add(scroll,BorderLayout.CENTER);

        // Flow Layout starts from the top and makes it only as spacious as needed
        // You can change the bounds of the flow layout unlike gridlayout

       // mainFrame.add(headerLabel);
        mainFrame.add(printerPanel, BorderLayout.NORTH); //The printer panel  hopefully
       // mainFrame.add(controlPanel, BorderLayout.EAST);// the middle panel that has the buttons, which means there is flowlayout in a gridlayout
        mainFrame.add(resultPanel, BorderLayout.CENTER);// should be third panel that prints results
        JFrame frame = new JFrame ();

//        mainFrame.pack ();


//        mainFrame.add(up);
        //mainFrame.add(statusLabel);
        mainFrame.setVisible(true);// makes things show up

       // testFrame.add(printerPanel);
//        testFrame.add(up);
//        testFrame.setVisible(true);
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

        //controlPanel.add(okButton);
        controlPanel.add(submitButton, BorderLayout.CENTER);
        //controlPanel.add(cancelButton);

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

    public void HtmlRead(){
        // . contains()
        // .index OF ()  returns the position of the first occurrence of a value in a string
        // .substring()  is the final step for just printing out the link
        try {
            System.out.println();
            System.out.print("hello \n");
            URL url = new URL(taReal);// make a variable to string
            //url = new URL(ta.getText());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line;
            while ( (line = reader.readLine()) != null ) {
                if(line.contains("https")){
                    xResult = line.indexOf("https:"); // this gets line position
                    System.out.println(xResult);
                    String halfString;
                    halfString=line.substring(xResult,line.length());
                    if(halfString.contains("\"")){
                        yResult = line.indexOf("\"", xResult);
                        System.out.println(yResult);
                    }
                    else{
                        if(halfString.contains("'")){
                            yResult = line.indexOf("'", xResult);
                            System.out.println(yResult);

                        }
                        else{
                            if(halfString.contains("-")){
                                yResult = line.indexOf("-", xResult);
                                System.out.println(yResult);
                            }
                        }
                    }
//
                    // it has ', -,


                    System.out.println(line);
                    String Links = line.substring(xResult , yResult);
                    System.out.println("*****"+Links);
                    if (Links.contains(Ba.getText())) {
                        ca.append(Links); // this also never puts the substing into the result board ca
                        ca.append("\n");
                    }
                }
            }
            reader.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("OK")) {
                ta.getText();
                System.out.println(ta.getText());
//                String taText = ta.getText();
                taReal = ta.getText();
                HtmlRead();
                statusLabel.setText("Ok Button clicked.");
            } else if (command.equals("Submit")) {
                ta.getText();
                System.out.println(ta.getText());
//                String taText = ta.getText();
                taReal = ta.getText();
                HtmlRead();
                statusLabel.setText("Submit Button clicked.");
            } else {
                statusLabel.setText("Cancel Button clicked.");
            }
        }
    }
}