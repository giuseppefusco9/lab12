package it.unibo.es3;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GUI extends JFrame {

    private final Map<JButton, Pair<Integer, Integer>> cells = new HashMap<>();
    private final JButton expandButton = new JButton(">");
    private final Logics logics;
    
    public GUI(int width) {
        this.logics = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);
        
        JPanel panel = new JPanel(new GridLayout(width,width));
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.getContentPane().add(expandButton, BorderLayout.SOUTH);

        expandButton.addActionListener(e -> {
            logics.expand();
            this.updateView();
            if(logics.toQuit()){
                System.exit(0);
            }
        });

        for (int i=0; i<width; i++){
            for (int j=0; j<width; j++){
                final JButton jb = new JButton(" ");
                this.cells.put(jb, new Pair<Integer,Integer>(i, j));
                panel.add(jb);
            }
        }
        this.updateView();
        this.setVisible(true);
    }

    private void updateView() {
    	List<Pair<Integer,Integer>> list = logics.getPositions();
    	cells.forEach((b,p)-> b.setText(list.contains(p) ? "*" : " "));
    }
    
}
