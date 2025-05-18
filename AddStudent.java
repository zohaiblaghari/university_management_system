import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener {

    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfcnic;
    JLabel labelrollno;
    JDateChooser dcdob;

    JComboBox cbcourse, cbbranch;
    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent () {

        setSize(900,650);
        setLocation(300,50);

        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(350,30,500,50);
        heading.setFont(new Font("Serif", 50, 30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("Serif", 50, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("Serif", 50, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("Serif", 50, 20));
        add(lblrollno);

        labelrollno = new JLabel("1533"+first4);
        labelrollno.setBounds(200,200,200,30);
        labelrollno.setFont(new Font("Serif", 50, 20));
        add(labelrollno);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("Serif", 50, 20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);


        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("Serif", 50, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("Serif", 50, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email ID");
        lblemail.setBounds(50,300,200,30);
        lblemail.setFont(new Font("Serif", 50, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400,300,200,30);
        lblx.setFont(new Font("Serif", 50, 20));
        add(lblx);

        tfx = new JTextField();
        tfx.setBounds(600,300,150,30);
        add(tfx);

        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50,350,200,30);
        lblxii.setFont(new Font("Serif", 50, 20));
        add(lblxii);

        tfxii = new JTextField();
        tfxii.setBounds(200,350,150,30);
        add(tfxii);

        JLabel lblcnic = new JLabel("B-Form/CNIC Number");
        lblcnic.setBounds(400,350,200,30);
        lblcnic.setFont(new Font("Serif", 50, 20));
        add(lblcnic);

        tfcnic = new JTextField();
        tfcnic.setBounds(600,350,150,30);
        add(tfcnic);

        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("Serif", 50, 20));
        add(lblcourse);

        String course[] = {"Bsc", "BBA", "BCA", "BE", "B.Tech", "Mphil", "MSc", "MTech"};
        cbcourse = new JComboBox<>(course);
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("Serif", 50, 20));
        add(lblbranch);

        String branch[] = {"Artificial Intelligence", "Computer science", "Civil", "Mechanical", "Electronics", "Electrical", "Information Technology", "Software", "Chemical"};
        cbbranch = new JComboBox<>(branch);
        cbbranch.setBounds(600, 400, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahona", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahona", Font.BOLD, 15));
        add(cancel);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit){
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelrollno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String cnic = tfcnic.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();

            try {
                String query = "insert into student values('"+name+"', '"+fname+"', '"+rollno+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+cnic+"','"+course+"', '"+branch+"')";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddStudent();
    }
}
