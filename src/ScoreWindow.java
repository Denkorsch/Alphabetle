import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ScoreWindow extends JFrame
 {
    JLabel scoreWords;
    JLabel scoreLetters;
    JLabel congrats;
    JLabel and;
    Window w;
ScoreWindow(Window win)
{
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(5,1));
    this.setSize(600,600);
    this.setVisible(true);
    this.setResizable(false);
    this.setTitle("Alphabetle");
    w = win;
    scoreLetters = new JLabel();
    scoreWords = new JLabel();
    congrats = new JLabel();
    and = new JLabel();
    this.add(congrats);
    this.add(scoreWords);
    this.add(and);
    this.add(scoreLetters);
    congrats.setText("Congratulations!");
    scoreWords.setText("You used " + w.getWords() + " words");
    and.setText("and");
    scoreLetters.setText(w.getLetters() + " letters!");
    //congrats.setBounds(150, 50, 600, 300);
    //scoreWords.setBounds(150, 100, 600, 300);
    //scoreLetters.setBounds(175, 150, 600, 300);
    congrats.setFont(new Font("Consolas", Font.BOLD, 35));
    scoreWords.setFont(new Font("Consolas", Font.BOLD, 25));
    scoreLetters.setFont(new Font("Consolas", Font.BOLD, 25));
    and.setFont(new Font("Consolas", Font.BOLD, 25));
    congrats.setHorizontalAlignment(JLabel.CENTER);
    scoreWords.setHorizontalAlignment(JLabel.CENTER);
    scoreLetters.setHorizontalAlignment(JLabel.CENTER);
    and.setHorizontalAlignment(JLabel.CENTER);
}


}
