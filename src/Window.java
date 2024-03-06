import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;


public class Window extends JFrame implements ActionListener
{
    String word;
    String usedWordslist;
    JTextField text;
    JButton b;
    JLabel leftLetters;
    JTextArea usedWords;
    JLabel lUsedW;
    ArrayList<String> alpha;
    ArrayList<String> w;
    ArrayList<String> listUsedWords;
    Scanner scanner;
    ImageIcon alphaImg;
    Window()
    {
        //main window settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(600,600);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Alphabetle");
        alphaImg = new ImageIcon("alpha.png");
        this.setIconImage(alphaImg.getImage());
        
        //array initialization
        w = new ArrayList<String>();
        listUsedWords = new ArrayList<String>();
        alpha = new ArrayList<String>();


        //read and add all English words from .txt to ArrayList
        File f = new File("words_alpha.txt");
        try {
            scanner = new Scanner(f); 
            while(scanner.hasNextLine())
            {
                w.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
          
            e.printStackTrace();
        }

       text = new JTextField(25);
       
       usedWords = new JTextArea();
       
       b = new JButton("Submit");
       
        word="";
        usedWordslist = "";
        
        usedWords.setText("");
        String alphabet = "";

       //panel initaialization & implementation
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        //JPanel panel4 = new JPanel();

        panel1.setBounds(0, 200, 600, 150);
        
        panel2.setBounds(0, 150, 600, 250);
        leftLetters = new JLabel();
        leftLetters.setBounds(0, 0, 600, 150);
        leftLetters.setFont(new Font("Consolas", Font.BOLD, 18));
        leftLetters.setHorizontalAlignment(JLabel.CENTER);

        lUsedW = new JLabel();
        //lUsedW.setBounds(0, 150, 600, 50);
        lUsedW.setText("Words used:");
        lUsedW.setFont(new Font("Consolas", Font.BOLD, 20));
        lUsedW.setHorizontalAlignment(JLabel.CENTER);
        
        text.setPreferredSize(new Dimension(200, 30));

        panel3.setBounds(0, 450, 600, 50);
        //panel4.setBounds(0, 150, 600, 50);

        panel3.setLayout(new FlowLayout());

        this.add(leftLetters);
        panel2.add(lUsedW);
        panel1.add(usedWords);
        panel3.add(text);
        panel3.add(b);
        

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        //this.add(panel4);



        usedWords.setPreferredSize(new Dimension(400,300));
        usedWords.setFont(new Font("Consolas", Font.BOLD, 16));
        usedWords.setLineWrap(true);
        usedWords.setWrapStyleWord(true);
        usedWords.setEditable(false);
        
        //usedWords.setHorizontalAlignment(JTextArea.CENTER_ALIGNMENT);
        //usedWords.setSize(new Dimension(400, 250));
        
        //text.setPreferredSize(new Dimension(250,40));

        b.addActionListener(this);
        
        alpha.add("a");
        alpha.add("b");
        alpha.add("c");
        alpha.add("d");
        alpha.add("e");
        alpha.add("f");
        alpha.add("g");
        alpha.add("h");
        alpha.add("i");
        alpha.add("j");
        alpha.add("k");
        alpha.add("l");
        alpha.add("m");
        alpha.add("n");
        alpha.add("o");
        alpha.add("p");
        alpha.add("q");
        alpha.add("r");
        alpha.add("s");
        alpha.add("t");
        alpha.add("u");
        alpha.add("v");
        alpha.add("w");
        alpha.add("x");
        alpha.add("y");
        alpha.add("z");

       
        for (String s : alpha) {
            alphabet = alphabet + s + " ";
        }
        leftLetters.setText(alphabet);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== b && w.contains(text.getText()) && !listUsedWords.contains(text.getText()) && !alpha.isEmpty())
        {
            word = text.getText();
            usedWordslist = usedWordslist + " " + word;
            listUsedWords.add(word);
            usedWords.setText("" + usedWordslist);
            for(int i = 0; i<word.length(); i++)
            {
                String newWord = word.substring(i, i+1);
                System.out.println(newWord);
                alpha.remove(newWord);
            }
            System.out.println(alpha);
            text.setText("");
            String alphabet = "";
        for (String s : alpha) {
            alphabet = alphabet + s + " ";
        }
        leftLetters.setText(alphabet);
        }
        if(alpha.isEmpty())
        {
            ScoreWindow scoreWin = new ScoreWindow(this);
        }
    }

    public int getWords()
    {
        int sum = listUsedWords.size();
        return sum;
    }

    public int getLetters()
    {
        int sum;
        sum = 0;
        for(String s : listUsedWords)
        {
           sum += s.length();
        }
        return sum;
    }
}