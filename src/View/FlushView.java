package View;

import Model.FlushModel;
import Controller.Controller;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FlushView extends JFrame{
    private int currentSelectedRow;
    
    private final JTextField hydrantID = new JTextField(15);
    private final JTextField flushDate = new JTextField(15);
    private final JTextField flushStartTime = new JTextField(15);
    private final JTextField flushEndTime = new JTextField(15);
    private final JTextField duration = new JTextField(15);
    private final JTextField totalGallons = new JTextField(15);
    private JPanel informationPanel;
    private JPanel buttonPanel;
    private final Controller controller;
    private final FlushModel currentFlush;

    public FlushView(Controller controller, int selectedModelRow) {
        this.currentSelectedRow = 0;
        currentSelectedRow = selectedModelRow;
        this.controller = controller;
        currentFlush = controller.getFlushList().getFlush(selectedModelRow);
        interfaceComponents();
        parseCurrentFlush();
    }
    
    public FlushView(Controller newController){
        this.currentSelectedRow = 0;
        this.controller = newController;
        currentFlush = null;
        altInterfaceComponents();
    }
    
    public void interfaceComponents() {
        setTitle("Flush Detail");
        setSize(500, 300);
        setLocationRelativeTo(null);
        
        informationPanel = new JPanel(new GridLayout(6, 2));
        informationPanel.add(new JLabel("HydrantID"));
        informationPanel.add(hydrantID);
        informationPanel.add(new JLabel("Flush Date"));
        informationPanel.add(flushDate);
        informationPanel.add(new JLabel("Flush Start Time"));
        informationPanel.add(flushStartTime);
        informationPanel.add(new JLabel("Flush End Time"));
        informationPanel.add(flushEndTime);
        informationPanel.add(new JLabel("Duration"));
        informationPanel.add(duration);
        informationPanel.add(new JLabel("Total Gallons Flushed"));  
        informationPanel.add(totalGallons);
        
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton updateButton = new JButton("Update Flush");
        JButton deleteButton = new JButton("Delete Flush");
        
        updateButton.addActionListener(event -> updateFlush());
        deleteButton.addActionListener(event -> deleteCurrentFlush());
        
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        
        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(informationPanel, BorderLayout.WEST);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public void altInterfaceComponents(){
        setTitle("Flush Detail");
        setSize(500, 300);
        setLocationRelativeTo(null);
        
        informationPanel = new JPanel(new GridLayout(6, 2));
        informationPanel.add(new JLabel("HydrantID"));
        informationPanel.add(hydrantID);
        informationPanel.add(new JLabel("Flush Date"));
        informationPanel.add(flushDate);
        informationPanel.add(new JLabel("Flush Start Time"));
        informationPanel.add(flushStartTime);
        informationPanel.add(new JLabel("Flush End Time"));
        informationPanel.add(flushEndTime);
        informationPanel.add(new JLabel("Duration"));
        informationPanel.add(duration);
        informationPanel.add(new JLabel("Total Gallons Flushed"));  
        informationPanel.add(totalGallons);
        
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton saveButton = new JButton("Save And Exit");
        buttonPanel.add(saveButton);
        saveButton.addActionListener(event -> saveNewFlush());
        
        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(informationPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public void parseCurrentFlush(){
        String hydrantIDString = Integer.toString(currentFlush.getHydrantID());
        hydrantID.setText(hydrantIDString);
        flushDate.setText(currentFlush.getFlushDate());
        String startTimeString = Integer.toString(currentFlush.getFlshStartTime());
        flushStartTime.setText(startTimeString);
        String endTimeString = Integer.toString(currentFlush.getFlushEndTime());
        flushEndTime.setText(endTimeString);
        int durationOfFlush = currentFlush.getFlushEndTime() - currentFlush.getFlshStartTime();
        String durationString = Integer.toString(durationOfFlush);
        duration.setText(durationString);
        double totalGallonsFlushed = currentFlush.getTotalGallonsFlushed();
        String totalGallonsFlushedString = Double.toString(totalGallonsFlushed);
        totalGallons.setText(totalGallonsFlushedString);
    }
    
    private void updateFlush(){
        if(controller.getFlushList().getSize() <= 0){
            return;
        }
        else{
            String newHydrantID = hydrantID.getText();
            String newFlushDate = flushDate.getText();
            String newStartTime = flushStartTime.getText();
            String newEndTime = flushStartTime.getText();
            
            int id = Integer.parseInt(newHydrantID);
            int start = Integer.parseInt(newStartTime);
            int end = Integer.parseInt(newEndTime);
            
            FlushModel f1 = new FlushModel(id, newFlushDate, start, end);
            
            controller.getFlushList().getListOfFlushes().set(currentSelectedRow, f1);
            dispose();
            controller.getFlushTableModel().fireTableDataChanged();  
        } 
    }
    
    private void deleteCurrentFlush(){
        if(controller.getFlushList().getListOfFlushes().size() <= 0){
            return;
        }
        else{
        controller.getFlushList().getListOfFlushes().remove(currentFlush);
        dispose();
        controller.getFlushTableModel().fireTableDataChanged();
        }    
    }
    
    public void saveNewFlush(){
        FlushModel newFlush = new FlushModel(Integer.parseInt(hydrantID.getText()), flushDate.getText(), Integer.parseInt(flushStartTime.getText()), Integer.parseInt(flushEndTime.getText()));
        controller.getFlushList().addFlush(newFlush);
        controller.getFlushTableModel().fireTableDataChanged();
        dispose();
    }
}
