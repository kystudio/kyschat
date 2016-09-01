package cn.kystudio.chat.server;

import cn.kystudio.chat.utils.CharacterUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kystudio on 2016/9/1.
 */
public class Server extends JFrame {

    private JLabel jLabel1,jLabel2,jLabel3;
    private JButton jButton1;
    private JPanel jPanel1,jPanel2;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private JTextField jTextField1;

    public Server(String name){
        super(name);

        this.initComponents();
    }

    public static void main(String[] args) {
        new Server("服务器");
    }

    // 初始化界面
    private void initComponents(){
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();

        jTextField1 = new JTextField(10);
        jButton1 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();

        jPanel1.setBorder(BorderFactory.createTitledBorder("服务器信息"));
        jPanel2.setBorder(BorderFactory.createTitledBorder("在线用户列表"));

        jLabel1.setText("服务器状态");
        jLabel2.setText("停止");
        jLabel3.setForeground(new Color(204,0,51));
        jLabel3.setText("端口号");

        jButton1.setText("启动服务器");

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Server.this.execute();
            }
        });

        this.jTextArea1.setEditable(false);
        this.jTextArea1.setForeground(new Color(245,0,0));

        jPanel1.add(jLabel1);
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel3);

        jPanel1.add(jTextField1);
        jPanel1.add(jButton1);

        jTextArea1.setColumns(30);
        jTextArea1.setForeground(new Color(0,51,204));
        jTextArea1.setRows(20);

        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1);

        this.getContentPane().add(jPanel1,BorderLayout.NORTH);
        this.getContentPane().add(jPanel2,BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    private void execute(){
        String hostPort = this.jTextField1.getText();

        if (CharacterUtil.isEmpty(hostPort)){
            JOptionPane.showMessageDialog(this,"端口号不能为空！","警告",JOptionPane.WARNING_MESSAGE);

            this.jTextField1.requestFocus();

            return;
        }

        if (!CharacterUtil.isNumber(hostPort)){
            JOptionPane.showMessageDialog(this,"端口号必须为数字！","警告",JOptionPane.WARNING_MESSAGE);

            this.jTextField1.requestFocus();

            return;
        }

        if (!CharacterUtil.isPortCorrect(hostPort)){
            JOptionPane.showMessageDialog(this,"端口号必须在1024~65535之间！","警告",JOptionPane.WARNING_MESSAGE);

            this.jTextField1.requestFocus();

            return;
        }
    }
}
