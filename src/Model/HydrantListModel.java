/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

public class HydrantListModel {
    private ArrayList<HydrantModel> hydrants;

    public HydrantListModel() {
        hydrants = new ArrayList<>();
        addHydrantsToList();
    }
    
    public void addHydrantsToList() {
        getListOfHydrants().add(new HydrantModel(1, 40.786237, -77.869875, "Zone 1", "Type", "American Darling", "19 DEC 1998", "05 JAN 2000", "22 MAR 2019", 102.43, 96.25, 6.0, 7.0, 4, "Butterfly Valve", 1089.56));
        getListOfHydrants().add(new HydrantModel(2, 40.785165, -77.868014, "Zone 1", "Type", "American Darling", "19 DEC 1998", "05 JAN 2000", "22 MAR 2019", 102.43, 96.25, 6.0, 7.0, 4, "Butterfly Valve", 1089.56));
        getListOfHydrants().add(new HydrantModel(3, 40.786024, -77.867045, "Zone 1", "Type", "American Darling", "19 DEC 1998", "05 JAN 2000", "22 MAR 2019", 102.43, 96.25, 6.0, 7.0, 4, "Butterfly Valve", 1089.56));
        getListOfHydrants().add(new HydrantModel(4, 40.787077, -77.868487, "Zone 1", "Type", "American Darling", "19 DEC 1998", "05 JAN 2000", "22 MAR 2019", 102.43, 96.25, 6.0, 7.0, 4, "Butterfly Valve", 1089.56));
        getListOfHydrants().add(new HydrantModel(5, 40.788029, -77.869766, "Zone 1", "Type", "American Darling", "19 DEC 1998", "05 JAN 2000", "22 MAR 2019", 102.43, 96.25, 6.0, 7.0, 4, "Butterfly Valve", 1089.56));
    }
    
    public ArrayList<HydrantModel> getListOfHydrants() {
        return hydrants;
    }
    
    public int getHydrantID(int i) {
        return getListOfHydrants().get(i).getHydrantID();
    }
    
    public HydrantModel getHydrant(int i) {
        return getListOfHydrants().get(i);
    }
    
    public int getSize() {
        return getListOfHydrants().size();
    }
    
    public void addHydrant(HydrantModel h1) {
        getListOfHydrants().add(h1);
    }
    
    public void displayList() {
        for (HydrantModel h : getListOfHydrants()) {
            System.out.println(h.toString());
        }
    }
}
