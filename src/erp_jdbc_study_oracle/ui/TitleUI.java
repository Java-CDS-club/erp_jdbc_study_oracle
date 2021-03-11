package erp_jdbc_study_oracle.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erp_jdbc_study_oracle.dto.Title;
import erp_jdbc_study_oracle.ui.component.table.TitleTable;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TitleUI extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private TitleTable pTable;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TitleUI frame = new TitleUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TitleUI() {
        initComponents();
    }
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        pTable = new TitleTable();
        pTable.loadItems();
        contentPane.add(pTable, BorderLayout.CENTER);
        
        JPanel pBtns = new JPanel();
        contentPane.add(pBtns, BorderLayout.EAST);
        pBtns.setLayout(new BoxLayout(pBtns, BoxLayout.Y_AXIS));
        
        btnAdd = new JButton("추가");
        btnAdd.addActionListener(this);
        pBtns.add(btnAdd);
        
        btnUpdate = new JButton("수정");
        btnUpdate.addActionListener(this);
        pBtns.add(btnUpdate);
        
        btnDelete = new JButton("삭제");
        btnDelete.addActionListener(this);
        pBtns.add(btnDelete);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDelete) {
            actionPerformedBtnDelete(e);
        }
        if (e.getSource() == btnUpdate) {
            actionPerformedBtnUpdate(e);
        }
        if (e.getSource() == btnAdd) {
            actionPerformedBtnAdd(e);
        }
    }
    protected void actionPerformedBtnAdd(ActionEvent e) {
        pTable.addRow(new Title(6, "인턴"));
    }
    protected void actionPerformedBtnUpdate(ActionEvent e) {
        pTable.updateRow(new Title(6, "계약직"));
    }
    protected void actionPerformedBtnDelete(ActionEvent e) {
        pTable.removeRow(new Title(6));
    }
}
