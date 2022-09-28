import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UserWindow {

    private Session session;
    JFrame frame;
    JPanel panel;
    JLabel mainLabel;
    JLabel fileNameLabel;
    JTextField fileNameField;
    JLabel wordCountLabel;
    JTextArea wordCountArea;

    JScrollPane scrollPane;
    JButton submitButton;
    JLabel statusLabel;

    JRadioButton radio1;
    JRadioButton radio2;
    JRadioButton radio3;


    public UserWindow(Session session) throws IOException {
        this.session = session;
        int fWidth = 1920;
        int fHeight = 1080;
        int xChunk = fWidth / 12;
        int yChunk = fHeight / 12;
        frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(fWidth, fHeight);

        panel = new JPanel();
        panel.setLayout(null);


        mainLabel = new JLabel("Word Counter");
        mainLabel.setBounds((int) (xChunk * 4), yChunk, xChunk - 1, yChunk / 2);
        mainLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(mainLabel);

        fileNameLabel = new JLabel("File Name");
        fileNameLabel.setBounds(xChunk , yChunk * 2, xChunk - 1, yChunk / 2);
//        fileNameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(fileNameLabel);

        fileNameField = new JTextField();
        fileNameField.setBounds(xChunk *2, yChunk * 2, xChunk * 3, yChunk / 2);
        fileNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(fileNameField);

        wordCountLabel = new JLabel("Word Counts");
        wordCountLabel.setBounds(xChunk, yChunk * 3, xChunk - 1, yChunk / 2);
//        wordCountLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(wordCountLabel);

        wordCountArea = new JTextArea(10, 20);
//        wordCountArea.setBounds(xChunk*6, yChunk*3, xChunk-1, yChunk/2);
        wordCountArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        panel.add(wordCountArea);

        scrollPane = new JScrollPane(wordCountArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(xChunk * 2, yChunk * 3, xChunk * 3, yChunk * 2);
        panel.add(scrollPane);

        submitButton = new JButton("Count");
        submitButton.setBounds((int)(xChunk * 2.5), yChunk * 8, xChunk * 2, yChunk / 2);
        submitButton.addActionListener(new CountButtonController(this));
        panel.add(submitButton);

        statusLabel = new JLabel("Please type the filename in this totally secure portal!");
        statusLabel.setBounds((int) (xChunk * 2.5), yChunk * 6, xChunk * 2, yChunk / 2);
        statusLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(statusLabel);

        radio1 = new JRadioButton("words1.txt");
        radio1.setBounds(xChunk * 5, yChunk * 2, xChunk, yChunk / 2);
        radio2 = new JRadioButton("words2.txt");
        radio2.setBounds(xChunk * 5, yChunk * 3, xChunk, yChunk / 2);

        radio3 = new JRadioButton("Custom");
        radio3.setBounds(xChunk * 5, yChunk * 4, xChunk, yChunk / 2);

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radio1);
        radioGroup.add(radio2);
        radioGroup.add(radio3);

        panel.add(radio1);
        panel.add(radio2);
        panel.add(radio3);

        BufferedImage myPicture = ImageIO.read(new File("src/resources/graphic/books.jpeg"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(4, 4, xChunk, yChunk);
        panel.add(picLabel);

        panel.setBackground(new Color(218, 247, 166));
        frame.add(panel);
        frame.setVisible(true);
    }

    public String getFileName() {
        return fileNameField.getText();
    }

    public Session getSession() {
        return session;
    }

    public void setTextField(String output) {
        wordCountArea.setText(output);
    }

}
