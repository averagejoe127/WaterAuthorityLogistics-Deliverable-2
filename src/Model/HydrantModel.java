package Model;


public class HydrantModel {
    private int hydrantID;
    private double latitude;
    private double longitude;
    private String zone;
    private String type;
    private String manufacturer;
    private String manufactureDate;
    private String dateInstalled;
    private String dateLastServiced;
    private double staticPressure;
    private double residualPressure;
    private double sizeOfValve;
    private double depthOfValve;
    private int numTurnsForValve;
    private String valveType;
    private double flowRate;

    public HydrantModel(int hydrantID, double latitude, double longitude, String zone, 
            String type, String manufacturer, String manufactureDate, String dateInstalled, 
            String dateLastServiced, double staticPressure, double residualPressure, 
            double sizeOfValve, double depthOfValve, int numTurnsForValve, 
            String valveType, double flowRate) {
        this.hydrantID = hydrantID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zone = zone;
        this.type = type;
        this.manufacturer = manufacturer;
        this.manufactureDate = manufactureDate;
        this.dateInstalled = dateInstalled;
        this.dateLastServiced = dateLastServiced;
        this.staticPressure = staticPressure;
        this.residualPressure = residualPressure;
        this.sizeOfValve = sizeOfValve;
        this.depthOfValve = depthOfValve;
        this.numTurnsForValve = numTurnsForValve;
        this.valveType = valveType;
        this.flowRate = flowRate;
    }
    
    public int getHydrantID() {
        return hydrantID;
    }
    
    public double getLatitude() {
        return latitude;
    }
    
    public double getLongitude() {
        return longitude;
    }
    
    public String getZone() {
        return zone;
    }
    
    public String getType() {
        return type;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public String getManufactureDate() {
        return manufactureDate;
    }
    
    public String getDateInstalled() {
        return dateInstalled;
    }
    
    public String getDateLastServiced() {
        return dateLastServiced;
    }
    
    public double getStaticPressure() {
        return staticPressure;
    }
    
    public double getResidualPressure() {
        return residualPressure;
    }
    
    public double getSizeOfValve() {
        return sizeOfValve;
    }
    
    public double getNumTurns() {
        return numTurnsForValve;
    }
    
    public String getValveType() {
        return valveType;
    }
    
    public double getDepthOfValve() {
        return depthOfValve;
    }
    
    public double getflowRate() {
        return flowRate;
    }

    @Override
    public String toString() {
        return "Hydrant ID: " + hydrantID + ", Latitude: " + latitude + ", Longitude: " + longitude + ", Zone: " + zone + ", Type: " + type + ", Manufacturer: " + manufacturer + ", Date Manufactured: " + manufactureDate + ", Date Installed: " + dateInstalled + ", Date Last Serviced: " + dateLastServiced + ", Static Pressure: " + staticPressure + ", Residual Pressure: " + residualPressure + ", Size of Valve: " + sizeOfValve + ", Depth of Valve: " + depthOfValve + ", Number of Turns for Valve: " + numTurnsForValve + ", Valve Type: " + valveType + ", Flow Rate: " + flowRate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.hydrantID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HydrantModel other = (HydrantModel) obj;
        if (this.hydrantID != other.hydrantID) {
            return false;
        }
        return true;
    }
}
