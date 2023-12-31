
public class Car extends Vehicle
{
    private String rego;           // registration number of the car
    
    
    /**
     * Constructor for a Car
     *
     *@param rego, The registration number of the vehicle
     *@param ownerName, The owner of the vehicle
     *
     */
    
    public Car(String rego, String ownerName)
    {
        // initialise instance variables
        super(ownerName);
        this.rego = rego ;
    }
    
    /**
     * Gets the registration number of the car
     *
     *@return rego, The registration number of the vehicle
     *
     */
    
    public String getrego()
    {
        // put your code here
        return rego;
    }
    
    /**
     * Displays information about the Car
     *
     *@return rego, The registration number of the vehicle
     *@return getArrivalTime(), The arrival time of the car
     *@return getOwner(), The owner of the car
     */
    
     public String toString()
    {
        return "Car"+","+owner+","+getArrivalTime()+","+rego;
    }
}
