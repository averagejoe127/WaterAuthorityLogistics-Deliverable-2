package Model;

import javax.swing.table.AbstractTableModel;

public class FlushTableModel extends AbstractTableModel{
        
    private final String[] columnNames = {"Hydrant ID", "Flush Date", "Start Time", "End Time", "Duration", "Total Gallons Flushed"};
    private final FlushListModel flushList;

    public FlushTableModel(FlushListModel newFlushList) {
        flushList = newFlushList;
    }
    
        @Override
    public int getRowCount() {
        return flushList.getListOfFlushes().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0: return (Object) flushList.getFlush(row).getHydrantID();
            case 1: return (Object) flushList.getFlush(row).getFlushDate();
            case 2: return (Object) flushList.getFlush(row).getFlshStartTime();
            case 3: return (Object) flushList.getFlush(row).getFlushEndTime();
            case 4: return (Object) flushList.getFlush(row).getFlushDuration();
            case 5: return (Object) flushList.getFlush(row).getTotalGallonsFlushed();
            default: return null;
        }
    }
}
