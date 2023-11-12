
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public abstract class Vehicle
{
    protected String owner;                              // the name of the owner
    private LocalDateTime arrivalTime;                 // arrival time of vehicle
    
    
        
    /**
     * Constructor for objects of class Vehicle
     *
     *@param ownerName, the owner of the vehicle
    */
    
    public Vehicle(String ownerName)
    {
        // initialise instance variables
       
        owner = ownerName;
        arrivalTime = LocalDateTime.now();
    }
    
    /**
     * Getting the owner of the vehicle
     *
     *@return owner, the owner of the vehicle
    */
    
    public String getOwner()
    {
        // put your code here
        return owner;
    }
    
    /**
     * Getting the arrival time from LocalDateTime
     *
     *@return arrivalTime, the arrival time of the vehicle in the parking eg. 3pm
     */
   
    
    public LocalDateTime getArrivalTime()
    {
        // put your code here
        return arrivalTime;
    }
    
    /**
     * Getting the time in the parking once vehicle is parked
     *
     *@return arrivalTime,in minutes
     */
    
    
    public long getTimeIn()    {
        return arrivalTime.until(LocalDateTime.now(),ChronoUnit.MINUTES);
    }
    
    /**
     * Displaying information about vehicle
     *
     *@return owner, the owner of the vehicle
     *@return arrivalTime, the arrival time of parked vehicle
     *@return getTimeIn(), time in minutes of parked vehicle 
    */
    
    public String toString()
    {
     return "Owner: "+owner+" Arrival Time : "+arrivalTime+"\n Time In : "+getTimeIn()+"\n***********";   
    }
    
}
