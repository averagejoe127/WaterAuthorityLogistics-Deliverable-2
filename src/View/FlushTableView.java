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


public final class FlushTableView extends JFrame{
    private Controller controller;
    
    private JPanel tablePanel;
    private JPanel buttonPanel;
    private JTable flushTable;
    private JScrollPane tableScroller;
    
    private JButton detailsButton;
    private JButton newButton;
    private JButton hydrantList;
    private final int defaultRow = 0;
    

    public FlushTableView(Controller controller) {
        this.controller = controller;
        initComponents();
    }   
    
    public class DetailsButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(flushTable.getSelectedRow() >= 0){
                int selectedTableRow = flushTable.getSelectedRow();
                int selectedModelRow = flushTable.convertRowIndexToModel(selectedTableRow);
                FlushTableView.this.controller.getFlushDetailView(selectedModelRow);
            }
            else{
                int selectedTableRow = defaultRow;
                int selectedModelRow = flushTable.convertRowIndexToModel(selectedTableRow);
                FlushTableView.this.controller.getFlushDetailView(selectedModelRow);
            }
        }
        
    }
    
    public void initComponents(){
        
        tablePanel = new JPanel();
        buttonPanel = new JPanel(new GridLayout(1, 4));
        flushTable = new JTable(controller.getFlushTableModel());
        flushTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        flushTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        detailsButton = new JButton("Details");
        detailsButton.addActionListener(new DetailsButtonListener());
        newButton = new JButton("New");
        hydrantList = new JButton("Hydrant List");
        hydrantList.addActionListener(event -> controller.getHydrantListView());
        newButton.addActionListener(event -> addNewFlushToList());
        
        buttonPanel.add(hydrantList);
        buttonPanel.add(newButton);
        buttonPanel.add(detailsButton);
        
        tableScroller = new JScrollPane(flushTable);
        flushTable.setFillsViewportHeight(true);
        tableScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroller.setPreferredSize(new Dimension(350, 300));
        tablePanel.add(tableScroller);
        
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
    }
    
    public void addNewFlushToList(){
        controller.getNewFlushDetailView();
    }
}
