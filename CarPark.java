
/**
 * The CarPark class contains a collection of parkingslots.
 * It has methods to add spots, remove spots, get details of the spot and vehicle 
 *
 * @author Hamza Suhail
 * @version 11.0.2, Date 11/04/2021, Student id: 102666611
 */
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
public class CarPark
{
    private ArrayList<ParkingSlot> ParkingSlots;         // these are our collection of existing parkingslots in an arraylist
     
    /** 
     * defines the ParkingSlot collection object
     * 
     */
    
    public CarPark()
    {
        ParkingSlots = new ArrayList<ParkingSlot>();
    }
    
    /**
     * 
     * Adds  aParkingSlot to the collection  of ParkingSlots
     * 
     * @param  aParkingSlot that is a parking ParkingSlot object
     * 
     */
    public void addNewParkingSlot(ParkingSlot aParkingSlot)
    {
        // put your code here
        ParkingSlots.add(aParkingSlot);
    }
    
    /**
     * Removes a parking slot from the collection of parking slots
     * 
     * @param spotId which is the spot that needs to be removed
     * @return false if spot doesn't exist and true if spot is removed from collection.
     */ 
    
    public boolean removeAParkingSlot(String spotId)
    {
        for(ParkingSlot aParkingSlot : ParkingSlots)
        {
            if(aParkingSlot.getParkingSlotId().equalsIgnoreCase(spotId) && !aParkingSlot.getIsOccupied())
            {
                ParkingSlots.remove(aParkingSlot);
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Gets all available parking slots.
     * 
     * @return availParkingSlots, the parking spots that are not occupied
     */ 
    
    public ArrayList<ParkingSlot> getAvailableParkingSlots()
    {
        ArrayList<ParkingSlot> availParkingSlots = new ArrayList<ParkingSlot>();
        for(ParkingSlot aParkingSlot : ParkingSlots)
        {
            if(!aParkingSlot.getIsOccupied())
                availParkingSlots.add(aParkingSlot);
        }
        return availParkingSlots;
    }
    
    
    /** 
     * Finds the vehicle by owner name in the parking slot.
     * 
     * @param ownerName of the vehicle to be found from the parking slots.
     * @return foundParkingSlots, the parking spot of the vehicle owner
     */
    
    public ArrayList<ParkingSlot> findVehicleOwner(String ownerName)
    {
        ArrayList<ParkingSlot> foundParkingSlots = new ArrayList<ParkingSlot>();
        for(ParkingSlot aParkingSlot : ParkingSlots)
        {
            if(aParkingSlot.getVehicle()!=null )
            {  
                if(aParkingSlot.getVehicle().getOwner().equals(ownerName) && aParkingSlot.getIsOccupied())
                {
                    foundParkingSlots.add(aParkingSlot);
                    
                }    
            }
        }   
            return foundParkingSlots;
    
    }
    
    /**
     * 
     * Finds the vehicle by registration number in the parking slot list.
     * 
     * @param Rego of the vehicle to be found from the parking slots.
     * @return foundParkingSlots, the parking spot matching the registration number
     */
    
    public ArrayList<ParkingSlot> findVehicleRego(String Rego)
    {
        ArrayList<ParkingSlot> foundParkingSlots = new ArrayList<ParkingSlot>();
        for(ParkingSlot aParkingSlot : ParkingSlots)
        {
            if(aParkingSlot.getVehicle() instanceof Car )
            {  
                if(((Car)aParkingSlot.getVehicle()).getrego().equals(Rego) && aParkingSlot.getIsOccupied())
                {
                    foundParkingSlots.add(aParkingSlot);
                    
                }
            }
        }   
            return foundParkingSlots;
    
    }
    
    /**
     * 
     * Finds the parking slot based on given id
     * 
     * @param id of the parking to be found from the parking slots.
     * @return foundParkingSlots, the parking spot matching the id provided number
     */
    
    
    public ParkingSlot findParkingbyID(String Id)
    {
        ParkingSlot foundParkingSlot = new ParkingSlot("-1");
        for(ParkingSlot aParkingSlot : ParkingSlots)
        {
            if(aParkingSlot.getParkingSlotId().equals(Id))
            {
                foundParkingSlot = aParkingSlot;
                break;
            }    
        }
        return foundParkingSlot;
    }
    
    /**
     * 
     * Finds the occupied parking slots in the car park
     * Loops through ParkingSlots and checks if parking is occupied
     * 
     * @return occupiedParkingSlots, the parking slots that are occupied
     */
    
    public ArrayList<ParkingSlot> getOccupiedParkingSlots()
    {
        ArrayList<ParkingSlot> occupiedParkingSlots = new ArrayList<ParkingSlot>();
        for(ParkingSlot aParkingSlot : ParkingSlots)
        {
            if(aParkingSlot.getIsOccupied())
                {occupiedParkingSlots.add(aParkingSlot);}
        }
        return occupiedParkingSlots;
    }
    
    /**
     * 
     * Finds the staff parking slots in the car park
     * Loops through ParkingSlots and checks if parking belongs to staff
     * 
     * @return staffParkingSlots, the parking slots that belong to staff
     */
    
    public ArrayList<ParkingSlot> getStaffParkingSlots()
    {
        ArrayList<ParkingSlot> staffParkingSlots = new ArrayList<ParkingSlot>();
        for(ParkingSlot aParkingSlot : ParkingSlots)
        {
            if(aParkingSlot.getIsStaff())
                {
                    staffParkingSlots.add(aParkingSlot);
                }
        }
        return staffParkingSlots;
    }
    
    /**
     * 
     * Finds all parking slots in the car park
     * 
     * 
     * @return ParkingSlots, all parking slots in car park
     */
    
    public ArrayList<ParkingSlot> getAllParkingSlots()
    {
        return ParkingSlots;
    }
}
