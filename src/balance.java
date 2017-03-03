import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
public class balance extends JPanel{

	JLabel bal,history;
	JTable table;
	JTextField  Bal;
	Font font;
	JPanel panel;
	public balance(){
		setLayout(new GridBagLayout());
		GridBagConstraints c =new GridBagConstraints();
		
		Object[] tab={"FROM","TO","Time","Date"};
		
		bal=new JLabel("Your Current balance is : ");
		Bal=new JTextField("0",3);
		Bal.setEnabled(false);
		
		font=new Font("Arial",Font.BOLD,20);
		bal.setFont(font);
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		
		c.insets=new Insets(-220, 0,0 , 0);
		this.add(bal,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=0;
		c.ipady=5;
		c.insets=new Insets(-220,-400,0 , 300);
		add(Bal,c);
		
		history=new JLabel("Ride History ",SwingConstants.CENTER);
		history.setFont(font);
		panel=new JPanel();
		panel.setLayout(new GridLayout(1,3));
		panel.add(new JLabel(""));
		panel.add(history);
		panel.add(new JLabel(""));
		
		
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=1;
		c.ipady=0;
		c.insets=new Insets(-140, 0, 0, 0);
		this.add(panel,c);
		
		table=new JTable(100,4);
		table.setBorder( new LineBorder(Color.BLUE));
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=2;
		c.insets=new Insets(-40, 0, 0,0);
		table.setPreferredScrollableViewportSize(new Dimension(700,150));
		table.setFillsViewportHeight(true);
		
		JScrollPane scroll=new JScrollPane(table);
		add(scroll,c);
		
		TableColumn column;
		
		for(int i=0;i<4;i++){
			column=table.getColumnModel().getColumn(i);
			column.setPreferredWidth(300);
			column.setHeaderValue(tab[i]);
		}
		table.setRowHeight(30);
		table.setEnabled(false);
	}
	public void setValues(ResultSet rs,String balance) throws Exception{
		
		}
	}
	
	

