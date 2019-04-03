package View;

import Model.HydrantModel;
import Controller.Controller;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HydrantView extends JFrame{
    private int currentSelectedRow;
    
    private final JTextField hydrantID = new JTextField(15);
    private final JTextField latitude = new JTextField(15);
    private final JTextField longitude = new JTextField(15);
    private final JTextField zone = new JTextField(15);
    private final JTextField type = new JTextField(15);
    private final JTextField manufacturer = new JTextField(15);
    private final JTextField manufactureDate = new JTextField(15);
    private final JTextField dateInstalled = new JTextField(15);
    private final JTextField dateLastServiced = new JTextField(15);
    private final JTextField staticPressure = new JTextField(15);
    private final JTextField residualPressure = new JTextField(15);
    private final JTextField sizeOfValve = new JTextField(15);
    private final JTextField depthOfValve = new JTextField(15);
    private final JTextField numTurns = new JTextField(15);
    private final JTextField valveType = new JTextField(15);
    private final JTextField flowRate = new JTextField(15);
    private JPanel informationPanel;
    private JPanel buttonPanel;
    private final Controller controller;
    private final HydrantModel currentHydrant;

    public HydrantView(Controller controller, int selectedModelRow) {
        this.currentSelectedRow = 0;
        currentSelectedRow = selectedModelRow;
        this.controller = controller;
        currentHydrant = controller.getHydrantList().getHydrant(selectedModelRow);
        interfaceComponents();
        parseCurrentHydrant();
    }
    
    public HydrantView(Controller newController){
        this.currentSelectedRow = 0;
        this.controller = newController;
        currentHydrant = null;
        altInterfaceComponents();
    }
    
    public void interfaceComponents() {
        setTitle("Hydrant Detail");
        setSize(900, 300);
        setLocationRelativeTo(null);
        
        informationPanel = new JPanel(new GridLayout(6, 2));
        informationPanel.add(new JLabel("HydrantID"));
        informationPanel.add(hydrantID);
        informationPanel.add(new JLabel("Longitude"));
        informationPanel.add(longitude);
        informationPanel.add(new JLabel("Latitude"));
        informationPanel.add(latitude);
        informationPanel.add(new JLabel("Zone"));
        informationPanel.add(zone);
        informationPanel.add(new JLabel("Type"));
        informationPanel.add(type);
        informationPanel.add(new JLabel("Manufacturer"));  
        informationPanel.add(manufacturer);
        informationPanel.add(new JLabel("Manufacture Date"));
        informationPanel.add(manufactureDate);
        informationPanel.add(new JLabel("Date Installed"));
        informationPanel.add(dateInstalled);
        informationPanel.add(new JLabel("Date Last Serviced"));
        informationPanel.add(dateLastServiced);
        informationPanel.add(new JLabel("Static Pressure"));
        informationPanel.add(staticPressure);
        informationPanel.add(new JLabel("Residual Pressure"));
        informationPanel.add(residualPressure);
        informationPanel.add(new JLabel("Size of Valve"));
        informationPanel.add(sizeOfValve);
        informationPanel.add(new JLabel("Depth of Valve"));
        informationPanel.add(depthOfValve);
        informationPanel.add(new JLabel("Number of Turns"));
        informationPanel.add(numTurns);
        informationPanel.add(new JLabel("Vlave Type"));
        informationPanel.add(valveType);
        informationPanel.add(new JLabel("Flow Rate"));
        informationPanel.add(flowRate);
        
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton flushListButton = new JButton("Flush List");
        JButton updateButton = new JButton("Update Hydrant");
        JButton deleteButton = new JButton("Delete Hydrant");
        
        flushListButton.addActionListener(event -> controller.getFlushListView());
        updateButton.addActionListener(event -> updateHydrant());
        deleteButton.addActionListener(event -> deleteCurrentHydrant());
        
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        
        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(informationPanel, BorderLayout.WEST);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public void altInterfaceComponents(){
        setTitle("Hydrant Detail");
        setSize(900, 300);
        setLocationRelativeTo(null);
        
        informationPanel = new JPanel(new GridLayout(6, 2));
        informationPanel.add(new JLabel("HydrantID"));
        informationPanel.add(hydrantID);
        informationPanel.add(new JLabel("Longitude"));
        informationPanel.add(longitude);
        informationPanel.add(new JLabel("Latitude"));
        informationPanel.add(latitude);
        informationPanel.add(new JLabel("Zone"));
        informationPanel.add(zone);
        informationPanel.add(new JLabel("Type"));
        informationPanel.add(type);
        informationPanel.add(new JLabel("Manufacturer"));  
        informationPanel.add(manufacturer);
        informationPanel.add(new JLabel("Manufacture Date"));
        informationPanel.add(manufactureDate);
        informationPanel.add(new JLabel("Date Installed"));
        informationPanel.add(dateInstalled);
        informationPanel.add(new JLabel("Date Last Serviced"));
        informationPanel.add(dateLastServiced);
        informationPanel.add(new JLabel("Static Pressure"));
        informationPanel.add(staticPressure);
        informationPanel.add(new JLabel("Residual Pressure"));
        informationPanel.add(residualPressure);
        informationPanel.add(new JLabel("Size of Valve"));
        informationPanel.add(sizeOfValve);
        informationPanel.add(new JLabel("Depth of Valve"));
        informationPanel.add(depthOfValve);
        informationPanel.add(new JLabel("Number of Turns"));
        informationPanel.add(numTurns);
        informationPanel.add(new JLabel("Vlave Type"));
        informationPanel.add(valveType);
        informationPanel.add(new JLabel("Flow Rate"));
        informationPanel.add(flowRate);
        
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton saveButton = new JButton("Save And Exit");
        buttonPanel.add(saveButton);
        saveButton.addActionListener(event -> saveNewHydrant());
        
        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(informationPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public void parseCurrentHydrant(){
        String hydrantIDString = Integer.toString(currentHydrant.getHydrantID());
        hydrantID.setText(hydrantIDString);
        latitude.setText("" + currentHydrant.getLatitude());
        longitude.setText("" + currentHydrant.getLongitude());
        zone.setText(currentHydrant.getZone());
        type.setText(currentHydrant.getType());
        manufacturer.setText(currentHydrant.getManufacturer());
        manufactureDate.setText(currentHydrant.getManufactureDate());
        dateInstalled.setText(currentHydrant.getDateInstalled());
        dateLastServiced.setText(currentHydrant.getDateLastServiced());
        staticPressure.setText("" + currentHydrant.getStaticPressure());
        residualPressure.setText("" + currentHydrant.getResidualPressure());
        sizeOfValve.setText("" + currentHydrant.getSizeOfValve());
        depthOfValve.setText("" + currentHydrant.getDepthOfValve());
        numTurns.setText("" + currentHydrant.getNumTurns());
        valveType.setText(currentHydrant.getValveType());
        flowRate.setText("" + currentHydrant.getflowRate());
    }
    
    private void updateHydrant(){
        if(controller.getHydrantList().getSize() <= 0){
            return;
        }
        else{
            String newHydrantID = hydrantID.getText();
            String newLat = latitude.getText();
            String newLong = longitude.getText();
            String newZone = zone.getText();
            String newType = type.getText();
            String newManufacturer = manufacturer.getText();
            String newManufactureDate = manufactureDate.getText();
            String newDateInstalled = dateInstalled.getText();
            String newDateLastServiced = dateLastServiced.getText();
            String newStaticPressure = staticPressure.getText();
            String newResidualPressure = residualPressure.getText();
            String newSizeOfValve = sizeOfValve.getText();
            String newDepthOfValve = depthOfValve.getText();
            String newNumTurns = numTurns.getText();
            String newValveType = valveType.getText();
            String newFlowRate = flowRate.getText();
            
            int id = Integer.parseInt(newHydrantID);
            double newLatitude = Double.parseDouble(newLat);
            double newLongitude = Double.parseDouble(newLong);
            double newStatPres = Double.parseDouble(newStaticPressure);
            double newResPres = Double.parseDouble(newResidualPressure);
            double newSize = Double.parseDouble(newSizeOfValve);
            double newDepth = Double.parseDouble(newDepthOfValve);
            int turns = Integer.parseInt(newNumTurns);
            double newFlow = Double.parseDouble(newFlowRate);
            
            HydrantModel h1 = new HydrantModel(id, newLatitude, newLongitude, newZone, newType, newManufacturer, newManufactureDate, newDateInstalled, newDateLastServiced, newStatPres, newResPres, newSize, newDepth, turns, newValveType, newFlow);
            
            controller.getHydrantList().getListOfHydrants().set(currentSelectedRow, h1);
            dispose();
            controller.getHydrantTableModel().fireTableDataChanged();  
        } 
    }
    
    private void deleteCurrentHydrant(){
        if(controller.getHydrantList().getListOfHydrants().size() <= 0){
            return;
        }
        else{
        controller.getHydrantList().getListOfHydrants().remove(currentHydrant);
        dispose();
        controller.getHydrantTableModel().fireTableDataChanged();
        }    
    }
    
    public void saveNewHydrant(){
        HydrantModel newHydrant = new HydrantModel(Integer.parseInt(hydrantID.getText()), 
                Integer.parseInt(latitude.getText()), Integer.parseInt(longitude.getText()), 
                zone.getText(), type.getText(), manufacturer.getText(), manufactureDate.getText(), 
                dateInstalled.getText(), dateLastServiced.getText(), Double.parseDouble(staticPressure.getText()), 
                Double.parseDouble(residualPressure.getText()), Double.parseDouble(sizeOfValve.getText()), 
                Double.parseDouble(depthOfValve.getText()), Integer.parseInt(numTurns.getText()), 
                valveType.getText(), Double.parseDouble(flowRate.getText()));
        controller.getHydrantList().addHydrant(newHydrant);
        controller.getHydrantTableModel().fireTableDataChanged();
        dispose();
    }
}
