import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class Login extends JFrame{
	
	private JLabel lb1,lb2,eye,lab;
	private JTextField txt1;
	private JPasswordField txt2;
	private JButton bt1;
	private ImageIcon icon;
	private GridBagConstraints gc;
	private static Login gui;
	private static Admin ad;
	private static Account ac;
	public Login()
	{
		setLayout(new GridBagLayout());		
		gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		
		setName();
		setPosition();
		setPassword();
		addListener();
		setCursor();
			
	}
	
		
	public static Login getLogin()
	{
		gui = new Login();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.setSize(700,450);
		gui.setLocation(300, 100);
		gui.setTitle("Login");
		gui.getContentPane().setBackground(Color.ORANGE);
		return gui;
	}
	
	void setPosition()
	{
		gc.gridx = 0;
		gc.gridy = 2;
		gc.insets = new Insets(0,0,0,0);	
		lb1.setFont(new Font("Arial",Font.BOLD,16));
		//lb1.setBorder(new LineBorder(Color.BLUE));
		//lb1.setForeground(Color.GRAY);
		add(lb1,gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		//gc.weightx=0.5;
		gc.ipady=5;
		gc.insets = new Insets(0,10,0,0);
		txt1.setFont(new Font("Arial",Font.PLAIN,16));
		txt1.setBackground(new Color(224,224,224));
		//txt1.setCaretColor(Color.WHITE);
		add(txt1,gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		gc.insets = new Insets(30,0,0,0);
		lb2.setFont(new Font("Arial",Font.BOLD,16));
		add(lb2,gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		//gc.ipadx=40;
		gc.ipady=4;
		gc.insets = new Insets(30,10,0,0);
		txt2.setFont(new Font("Arial",Font.BOLD,16));
		txt2.setBackground(new Color(224,224,224));
	//	txt2.setCaretColor(Color.WHITE);
		add(txt2,gc);
		
		gc.gridx = 3;
		gc.gridy = 3;
		gc.insets = new Insets(30,0,0,0);
		add(eye,gc);
		
		gc.gridx = 0;
		gc.gridy = 5;
		gc.insets = new Insets(10,0,0,90);
		lab.setForeground(Color.RED);
		lab.setFont(new Font("Arial",Font.PLAIN,15));
		add(lab,gc);
		
		gc.gridx = 0;
		gc.ipadx = 48;
		gc.gridy = 8;
		gc.insets = new Insets(50,150,0,10);
		bt1.setFont(new Font("Arial",Font.BOLD,14));
		bt1.setForeground(Color.white);
		bt1.setBackground(new Color(51, 153, 255));
		add(bt1,gc);
		
	}
	void setName()
	{
		lb1 = new JLabel("USERNAME:");
		txt1 = new JTextField();
		lb2 = new JLabel("PASSWORD:");
		txt2 = new JPasswordField(13);
		icon = new ImageIcon(getClass().getResource("visible.png"));
		eye = new JLabel(icon);
		lab = new JLabel("Forget Password ?");
		bt1 = new JButton("Login");
				
	}
	
	void addListener()
	{
		bt1.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent arg0) {
			
			String str=String.valueOf(txt2.getPassword());
			LoginDatabase l=new LoginDatabase(txt1.getText(),str.hashCode());
			if(l.userInitialise()==true)
			{	
				JOptionPane.showMessageDialog(new JFrame(),"  Login Successfully.");
				ac=new Account(txt1.getText());
				ac.setVisible(true);
				setVisible(false);
			}
			/*
			else if(l.adminIntialise()==true)
			{
				JOptionPane.showMessageDialog(new JFrame(),"  Login Successfully.");
				ad = new Admin(txt1.getText());
				ad.setVisible(true);
				setVisible(false);
			}
				*/
			else 
			JOptionPane.showMessageDialog(new JFrame("Incorrect Password"), "Enter the correct password and email address");				
		}	
		});
		
		lab.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lab.setFont(new Font("Arial",Font.PLAIN,14));	
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lab.setFont(new Font("Arial",Font.BOLD,14));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFrame jf=new JFrame("new one");
		        jf.setBackground(Color.BLACK);
		        jf.setSize(new Dimension(400,300));
		        jf.setVisible(true);
		        jf.setDefaultCloseOperation(HIDE_ON_CLOSE);
		        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
			}
		});
	
	}
	
	void setCursor()
	{
		lab.setCursor(Password.curr);
		bt1.setCursor(Password.curr);
		eye.setCursor(Password.curr);
	}
	void setPassword()
	{
		eye.setIcon(icon);		
		Password.showpasswrd(eye, txt2);
	}
	
	public static Account getAccount(){
		return ac;
	}


	public static Admin getAdmin()
	{
		return ad;
	}
	
	protected void finalise(){
		ac.disable();
		ad.disable();
		
	}
	
}
	
