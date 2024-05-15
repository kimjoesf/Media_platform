package com.mycompany.view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Comment extends JPanel {
 
 public Comment(com.mycompany.model.Comment c) {
	 setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	 setBackground(Gui.white);
	 setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 25));

	 JPanel header = new JPanel(new BorderLayout());
	 header.setBackground(null);

	 Jlabel author = new Jlabel(c.getUser().getname(), 20, Gui.post, Font.BOLD);
	 header.add(author, BorderLayout.WEST);
	 add(header);

	 JPanel center = new JPanel(new FlowLayout(FlowLayout.LEADING));
	 center.setBackground(null);
	 JTextArea content = new JTextArea(c.getContent(),18, Gui.post,Font.PLAIN); 
	 
	 center.add(content);
	 add(center);

	 JPanel bottom = new JPanel(new BorderLayout());
	 bottom.setBackground(null);
	 bottom.add(new Jlabel(c.getDateToString(), 15, Gui.post, Font.PLAIN),
	 BorderLayout. EAST);
	 add(bottom);

	 int height =(int) (90 + content.getPreferredSize().getHeight());

	 Dimension dimension = new Dimension(500, height);
	 setPreferredSize(dimension);
	 setMaximumSize(dimension);
	 setMinimumSize(dimension);
	 
	 
	 
 }
	
}
