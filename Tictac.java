import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.FontUIResource;

class Tictac implements ActionListener {
    public void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    JFrame jf;
    JButton one, two, three, four, five, six, seven, eight, nine;
    int count = 0;
    String str = "";
    boolean k = false;
    String name1;
    String name2;

    void playerName(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    void createFrame() {

        jf = new JFrame();
        jf.setDefaultCloseOperation(3);
        jf.setSize(400, 400);
        jf.setLayout(new GridLayout(3, 3));

        one = new JButton();
        one.addActionListener(this);
        jf.add(one);

        two = new JButton();
        two.addActionListener(this);
        jf.add(two);

        three = new JButton();
        three.addActionListener(this);
        jf.add(three);

        four = new JButton();
        four.addActionListener(this);
        jf.add(four);

        five = new JButton();
        five.addActionListener(this);
        jf.add(five);

        six = new JButton();
        six.addActionListener(this);
        jf.add(six);

        seven = new JButton();
        seven.addActionListener(this);
        jf.add(seven);

        eight = new JButton();
        eight.addActionListener(this);
        jf.add(eight);

        nine = new JButton();
        nine.addActionListener(this);
        jf.add(nine);
        jf.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        playSound("/Users/devenrtwal/Documents/Projects 2022/Sounds/click2.wav");
        count++;
        if (count % 2 == 0) {
            str = "O";
        } else {
            str = "X";
        }
        if (e.getSource() == one) {
            one.setText(str);
            one.setFont(new FontUIResource("font", 1, 70));
            one.setEnabled(false);
        } else if (e.getSource() == two) {
            two.setText(str);
            two.setFont(new FontUIResource("font", 1, 70));
            two.setEnabled(false);
        } else if (e.getSource() == three) {
            three.setText(str);
            three.setFont(new FontUIResource("font", 1, 70));
            three.setEnabled(false);
        } else if (e.getSource() == four) {
            four.setText(str);
            four.setFont(new FontUIResource("font", 1, 70));
            four.setEnabled(false);
        } else if (e.getSource() == five) {
            five.setText(str);
            five.setFont(new FontUIResource("font", 1, 70));
            five.setEnabled(false);
        } else if (e.getSource() == six) {
            six.setText(str);
            six.setFont(new FontUIResource("font", 1, 70));
            six.setEnabled(false);
        } else if (e.getSource() == seven) {
            seven.setText(str);
            seven.setFont(new FontUIResource("font", 1, 70));
            seven.setEnabled(false);
        } else if (e.getSource() == eight) {
            eight.setText(str);
            eight.setFont(new FontUIResource("font", 1, 70));
            eight.setEnabled(false);
        } else if (e.getSource() == nine) {
            nine.setText(str);
            nine.setFont(new FontUIResource("font", 1, 70));
            nine.setEnabled(false);
        }
        winningPossibility();
        whoWins();

    }

    void winningPossibility() {
        if (one.getText() == two.getText() && two.getText() == three.getText() && one.getText() != "") {
            k = true;
        } else if (four.getText() == five.getText() && five.getText() == six.getText() && four.getText() != "") {
            k = true;
        } else if (seven.getText() == eight.getText() && eight.getText() == nine.getText() && seven.getText() != "") {
            k = true;
        } else if (one.getText() == four.getText() && four.getText() == seven.getText() && one.getText() != "") {
            k = true;
        } else if (two.getText() == five.getText() && five.getText() == eight.getText() && two.getText() != "") {
            k = true;
        } else if (three.getText() == six.getText() && six.getText() == nine.getText() && three.getText() != "") {
            k = true;
        } else if (one.getText() == five.getText() && five.getText() == nine.getText() && one.getText() != "") {
            k = true;
        } else if (three.getText() == five.getText() && five.getText() == seven.getText() && three.getText() != "") {
            k = true;
        } else {
            k = false;
        }

    }

    void whoWins() {
        if (k) {
            JOptionPane.showMessageDialog(jf, str + " Wins");
        } else if (k == false && count == 9) {
            JOptionPane.showMessageDialog(jf, "Match Draw");
        }
    }

}
