package Model;

import javax.swing.table.AbstractTableModel;

public class HydrantTableModel extends AbstractTableModel{
        
    private final String[] columnNames = {"Hydrant ID", "Latitude", "Longitude", "Zone", "Type", "Manufacturer", "Manufacture Date", "Date Installed", "Date Last Serviced", "Static Pressure", "Residual Pressure", "Size of Valve", "Depth of Valve", "Number of Turns", "Valve Type", "Flow Rate"};
    private final HydrantListModel hydrantList;

    public HydrantTableModel(HydrantListModel newHydrantList) {
        hydrantList = newHydrantList;
    }
    
        @Override
    public int getRowCount() {
        return hydrantList.getListOfHydrants().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0: return (Object) hydrantList.getHydrant(row).getHydrantID();
            case 1: return (Object) hydrantList.getHydrant(row).getLatitude();
            case 2: return (Object) hydrantList.getHydrant(row).getLongitude();
            case 3: return (Object) hydrantList.getHydrant(row).getZone();
            case 4: return (Object) hydrantList.getHydrant(row).getType();
            case 5: return (Object) hydrantList.getHydrant(row).getManufacturer();
            case 6: return (Object) hydrantList.getHydrant(row).getManufactureDate();
            case 7: return (Object) hydrantList.getHydrant(row).getDateInstalled();
            case 8: return (Object) hydrantList.getHydrant(row).getDateLastServiced();
            case 9: return (Object) hydrantList.getHydrant(row).getStaticPressure();
            case 10: return (Object) hydrantList.getHydrant(row).getResidualPressure();
            case 11: return (Object) hydrantList.getHydrant(row).getSizeOfValve();
            case 12: return (Object) hydrantList.getHydrant(row).getDepthOfValve();
            case 13: return (Object) hydrantList.getHydrant(row).getNumTurns();
            case 14: return (Object) hydrantList.getHydrant(row).getValveType();
            case 15: return (Object) hydrantList.getHydrant(row).getflowRate();
            default: return null;
        }
    }
}
