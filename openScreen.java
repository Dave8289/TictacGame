import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class openScreen implements ActionListener

{

    JFrame jf;
    JLabel jl1;
    JLabel jl2;
    JTextField jt1;
    JTextField jt2;
    JButton jb;

    openScreen() {
        jf = new JFrame();
        jf.setSize(400, 400);
        jf.setDefaultCloseOperation(3);
        jf.setLayout(null);

        jl1 = new JLabel("Player One :");
        jl1.setBounds(80, 103, 100, 30);
        jf.add(jl1);

        jl2 = new JLabel("Player two :");
        jl2.setBounds(80, 153, 100, 30);
        jf.add(jl2);

        jt1 = new JTextField();
        jt1.setBounds(170, 100, 150, 40);
        jf.add(jt1);

        jt2 = new JTextField();
        jt2.setBounds(170, 150, 150, 40);
        jf.add(jt2);

        jb = new JButton("Start Game");
        jb.setBounds(140, 220, 100, 50);
        jb.addActionListener(this);
        jf.add(jb);

        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name1 = jl1.getText();
        String name2 = jl2.getText();

        Tictac game = new Tictac();
        game.playerName(name1, name2);
        game.createFrame();

        jf.setVisible(false);

    }
}