package View;

import Controller.Controller;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public final class HydrantTableView extends JFrame{
    private Controller controller;
    
    private JPanel tablePanel;
    private JPanel buttonPanel;
    private JTable hydrantTable;
    private JScrollPane tableScroller;
    
    private JButton detailsButton;
    private JButton newButton;
    private JButton flushListButton;
    private final int defaultRow = 0;
    

    public HydrantTableView(Controller controller) {
        this.controller = controller;
        initComponents();
    }   
    
    public class DetailsButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(hydrantTable.getSelectedRow() >= 0){
                int selectedTableRow = hydrantTable.getSelectedRow();
                int selectedModelRow = hydrantTable.convertRowIndexToModel(selectedTableRow);
                HydrantTableView.this.controller.getHydrantDetailView(selectedModelRow);
            }
            else{
                int selectedTableRow = defaultRow;
                int selectedModelRow = hydrantTable.convertRowIndexToModel(selectedTableRow);
                HydrantTableView.this.controller.getHydrantDetailView(selectedModelRow);
            }
        }
        
    }
    
    public void initComponents(){
        
        tablePanel = new JPanel();
        buttonPanel = new JPanel(new GridLayout(1, 4));
        hydrantTable = new JTable(controller.getHydrantTableModel());
        hydrantTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        hydrantTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        detailsButton = new JButton("Details");
        detailsButton.addActionListener(new DetailsButtonListener());
        newButton = new JButton("New");
        flushListButton = new JButton("Flush List");
        newButton.addActionListener(event -> addNewHydrantToList());
        flushListButton.addActionListener(event -> controller.getFlushListView());
        
        buttonPanel.add(flushListButton);
        buttonPanel.add(newButton);
        buttonPanel.add(detailsButton);
        
        tableScroller = new JScrollPane(hydrantTable);
        hydrantTable.setFillsViewportHeight(true);
        tableScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroller.setPreferredSize(new Dimension(350, 300));
        tablePanel.add(tableScroller);
        
        this.setSize(900, 400);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
    }
    
    public void addNewHydrantToList(){
        controller.getNewHydrantDetailView();
    }
}
