package Controller;

import java.util.ArrayList;
import Model.FlushListModel;
import Model.FlushModel;
import Model.FlushTableModel;
import View.FlushTableView;
import View.FlushView;
import Model.HydrantListModel;
import Model.HydrantTableModel;
import View.HydrantTableView;
import View.HydrantView;

public class Controller {
    private HydrantListModel hydrantList;
    private FlushListModel flushList;
    private FlushView flushDetailView;
    private FlushTableView flushTableView;
    private HydrantView hydrantDetailView;
    private HydrantTableView hydrantTableView;
    private HydrantTableModel hydrantTableModel;
    private FlushTableModel flushTableModel;
    
    public Controller() {
        ArrayList<FlushModel> flushes = new ArrayList();
        hydrantList = new HydrantListModel();
        flushList = new FlushListModel();
        flushTableModel = new FlushTableModel(flushList);
        hydrantTableModel = new HydrantTableModel(hydrantList);
        flushTableView = new FlushTableView(this);
        flushTableView.setVisible(true);
        hydrantList.displayList();
    }
    
    public void getHydrantListView() {
        hydrantTableView = new HydrantTableView(this);
        hydrantTableView.setVisible(true);
        flushTableView.setVisible(false);
    }
    
    public void getFlushListView() {
        hydrantTableView.setVisible(false);
        flushTableView.setVisible(true);
    }
    
    public void getHydrantDetailView(int selectedModelRow) {
        hydrantDetailView = new HydrantView(this, selectedModelRow);
        hydrantDetailView.setVisible(true);
    }
    
    public void getNewHydrantDetailView() {
        hydrantDetailView = new HydrantView(this);
        hydrantDetailView.setVisible(true);
    }
    
    public FlushTableModel getFlushTableModel() {
        return flushTableModel;
    }
    
    public HydrantTableModel getHydrantTableModel() {
        return hydrantTableModel;
    }
    
    public FlushListModel getFlushList() {
        return flushList;
    }
    
    public HydrantListModel getHydrantList() {
        return hydrantList;
    }
    
    public FlushModel getFlush(int i){
        return flushList.getFlush(i);
    }

    public void getFlushDetailView(int selectedModelRow) {
        flushDetailView = new FlushView(this, selectedModelRow);
        flushDetailView.setVisible(true);
    }

    public void getNewFlushDetailView() {
        flushDetailView = new FlushView(this);
        flushDetailView.setVisible(true);
    }
}
