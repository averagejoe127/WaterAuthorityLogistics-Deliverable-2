package Model;

import java.util.ArrayList;

public class FlushListModel {
    private ArrayList<FlushModel> flushes;

    public FlushListModel() {
        flushes = new ArrayList<>();
        addFlushesToList();
    }
    
    public void addFlushesToList() {
        getListOfFlushes().add(new FlushModel(1, "Mar 21, 2019", 1530, 1545));
        getListOfFlushes().add(new FlushModel(2, "Mar 21, 2019", 1700, 1715));
        getListOfFlushes().add(new FlushModel(3, "Mar 21, 2019", 1600, 1615));
        getListOfFlushes().add(new FlushModel(4, "Mar 21, 2019", 1615, 1630));
        getListOfFlushes().add(new FlushModel(5, "Mar 21, 2019", 1630, 1645));
    }
    
    public ArrayList<FlushModel> getListOfFlushes() {
        return flushes;
    }
    
    public int getSize() {
        return getListOfFlushes().size();
    }
    
    public void addFlush(FlushModel f) {
        flushes.add(f);
    }
    
    public FlushModel getFlush(int i) {
        return flushes.get(i);
    }
    
    public void displayList() {
        for (FlushModel f : getListOfFlushes()) {
            System.out.println(f.toString());
        }
    }
}
