
/**
 * The GUI class imports swing and awt libraries and implements the ActionListerner interface
 * Its constructor contains the carpark instance and the prepareGUI() function which establishes a new JFrame and adds different
 * components to it.
 * Each button in the mainframe has anonymous actionlistners that revert back to specified functions in GUI class.
 *
 * @author Hamza Suhail
 * @version 11.0.2, Date 11/04/2021, Student id: 102666611
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.border.Border;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class GUI implements ActionListener{
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JButton labelButton;
   private JPanel controlPanel;
   private JPanel headerpanel;
   private JTextArea msglabel;
   private CarPark carpar;
   
   
   /**
     * 
     * Constructor for the GUI
     * 
     * @param  carpar- a carpark instance
     * 
     */

   public GUI(CarPark carpar){
      this.carpar = carpar;
      prepareGUI();
   }
   
   /**
     * 
     * Preparing the GUI by making a new JFrame first, then adding 3 panels namely, imagePanel, headerPanel and main to hold the 
     * image, output screen (displays both text and buttons) and buttons for main selection.
     * Events are added to each button which functions through an Anonymous listener.
     * 
     * 
     */
   
   private void prepareGUI(){
      mainFrame = new JFrame("Car Park System");              // Init new JFrame
      mainFrame.setSize(1000,600);
      mainFrame.setLayout(new GridLayout(3, 1));        // JFrame is 3 rows 1 column
      
      mainFrame.addWindowListener(new WindowAdapter() {          // Exit on clicking top right cross button
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });
      //addVisStafParking();                                             // function for adding visitor and staff parking
   
      JPanel imagePanel = new JPanel(new GridLayout(2, 1));            // adding header panel containing image and text  with 2 rows 1 column
      JLabel textLabel = new JLabel("CAR PARK SYSTEM");      // Text label for headerpanel
      textLabel.setHorizontalAlignment(SwingConstants.CENTER);         // Editing text properties
      textLabel.setVerticalAlignment(SwingConstants.CENTER);
      textLabel.setFont(new Font("Serif", Font.BOLD, 40));
      imagePanel.add(textLabel);      
      JLabel picLabel = new JLabel();                                  // new label for icon in the header
      picLabel.setIcon(new ImageIcon(new ImageIcon("caricon.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
      picLabel.setHorizontalAlignment(SwingConstants.CENTER);
      picLabel.setVerticalAlignment(SwingConstants.CENTER);
      imagePanel.add(picLabel);
       
      mainFrame.add(imagePanel);                                      //add everything in the image panel to the main JFrame
      

      headerpanel = new JPanel(new GridLayout(2, 1, 10, 5));          // middle Jpanel with grid layout 
      
      headerpanel.setBackground(Color.WHITE);
      Border blackline = BorderFactory.createLineBorder(Color.DARK_GRAY); // add a border to it
      headerpanel.setBorder(blackline);
      mainFrame.add(headerpanel);                                      // add to main JFrame
      JButton button1 = new JButton("Show All Parking Spots");
      button1.setBackground(Color.LIGHT_GRAY);
      JButton button2 = new JButton("Find Vehicle");                        // new JButtons for last panel
      button2.setBackground(Color.LIGHT_GRAY);
      JButton button3 = new JButton("Park Vehicle");
      button3.setBackground(Color.LIGHT_GRAY);
      JButton button4 = new JButton("Delete Spot");
      button4.setBackground(Color.LIGHT_GRAY);
      JButton button5 = new JButton("Remove Vehicle");
      button5.setBackground(Color.LIGHT_GRAY);
      JButton button6 = new JButton("Add Parking Spot");
      button6.setBackground(Color.LIGHT_GRAY);
      JButton button7 = new JButton("Exit Application");
      JButton button8 = new JButton("Clear Screen");
      button7.setBackground(Color.LIGHT_GRAY);
      button8.setBackground(Color.LIGHT_GRAY);
      JPanel main = new JPanel(new GridLayout(4,2));                     // divide 4 rows, 2 columns in last JPanel
      button1.addActionListener(new ActionListener()
            {
                /*
                 * everything on the headerpanel first and runs the showAllParkings function when button 1 is clicked
                 * 
                 */
                public void actionPerformed(ActionEvent e)
                {
                    headerpanel.removeAll();
                    showAllParkings();
                }
            });
      button2.addActionListener(new ActionListener()
            {
                /*
                 * the findCar function when button 2 is clicked
                 */
                public void actionPerformed(ActionEvent e)
                {
                  findCar();
                }
            });
      
      button3.addActionListener(new ActionListener()
            {
                /*
                 * parkCar function when button 3 is clicked
                 */
                public void actionPerformed(ActionEvent e)
                {
                    parkCar();
                }
            });
            
      button4.addActionListener(new ActionListener()
            {
                /*
                 * deleteParking function when button 4 is clicked
                 */
                public void actionPerformed(ActionEvent e)
                {
                    headerpanel.removeAll();
                    deleteParking();
                }
            });
            
      button5.addActionListener(new ActionListener()
            {
                /*
                 *  runs the removeVehicle function when button 5 is clicked
                 */
                public void actionPerformed(ActionEvent e)
                {
                    removeVehicle();
                }
            });
            
      button6.addActionListener(new ActionListener()
            {
                /* 
                 *  runs the addParkingSpot function when button 6 is clicked
                 */
                public void actionPerformed(ActionEvent e)
                {
                    addParkingSpot();
                }
            });       
            
            
      button7.addActionListener(new ActionListener()
            {
                /* 
                 * exits the application when button 7 is clicked
                 */
                public void actionPerformed(ActionEvent e)
                {
                 System.exit(0);   
                }
            });
      
      button8.addActionListener(new ActionListener()
            {
                /* 
                 *  runs the showHomeScreen function when button 8 is clicked
                 */
                public void actionPerformed(ActionEvent e)
                {
                 showHomeScreen();   
                }
            });      
            
      main.add(button1);
      main.add(button2);
      main.add(button3);                             // add buttons to last JPanel
      main.add(button4);
      main.add(button5);
      main.add(button6);
      main.add(button7);
      main.add(button8);
      
      mainFrame.add(main);                           // add everything to JFrame
      
      mainFrame.setVisible(true);  
   }

//   Showing HomeScreen

   private void showHomeScreen(){
      headerpanel.removeAll(); 
      headerLabel= new JLabel("Welcome to Ha Noi Car Park");
      headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
      headerLabel.setVerticalAlignment(SwingConstants.CENTER);
      headerpanel.add(headerLabel); 
      headerpanel.revalidate();
      headerpanel.repaint();   // This is required if changing components
      mainFrame.setVisible(true);      
   }


   /**
     * deleting the car parking by user input
     */ 
    
    
   public void deleteParking(){
       
       showAllParkings();
       String spotID = JOptionPane.showInputDialog("Select the spot you would like to delete eg. (V001)");
       if (spotID!=null)
       {
       if (spotID.equals(""))
       {
           JOptionPane.showMessageDialog(null, "Alert: Please don't enter a blank value");
        }
       else
       {
           if(carpar.removeAParkingSlot(spotID) )
            {
                JOptionPane.showMessageDialog(null, "Success: spot deleted!","Spot Deleted Message", JOptionPane.INFORMATION_MESSAGE);
                headerpanel.removeAll();
                showAllParkings();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Alert: Spot doesn't exist or is currently occupied");
            }
       }
    }
    }
   
   /**
    * Adding car parking spot by taking userInput
    */ 
    
   public void addParkingSpot(){

       String spotstfvis = JOptionPane.showInputDialog("Is this a staff or visitor parking?").toUpperCase();
       String spotID = JOptionPane.showInputDialog("Add Spot ID eg. (S001 if staff or V001 if visitor)");
       boolean isParkingSlotDuplicate = false;
       if (spotID!=null)
       {
       if (spotID.equals(""))
       {
            JOptionPane.showMessageDialog(null, "Error: do not leave the id blank!");
        }
       else
       {
            for(ParkingSlot aParkingSlot : carpar.getAllParkingSlots())
            {
                /* checking if id already exists */
                if(aParkingSlot.getParkingSlotId().equalsIgnoreCase(spotID))
                {
                    isParkingSlotDuplicate = true;
                    JOptionPane.showMessageDialog(null, "Alert: Spot "+spotID+" already exists!. ");
                }
            }
            
            if(!isParkingSlotDuplicate)
            {
//                String spotstfvis = JOptionPane.showInputDialog("Is this a staff or visitor parking?").toUpperCase();
                if(spotstfvis.contains("STAFF"))
                {
                    /* checking if id starts with S, total length is 4 and contains numerics after S */
                    if (spotID.startsWith("S") && spotID.length()==4 && spotID.substring(1).chars().allMatch( Character::isDigit ))
                    {
                        JOptionPane.showMessageDialog(null, "Success! Staff Parking Added.");
                        ParkingSlot aParkingSlot = new ParkingSlot(spotID, true);         // new parking slot with isStaff as true
                        carpar.addNewParkingSlot(aParkingSlot);
                        headerpanel.removeAll();
                        showAllParkings();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Staff Parking must start with S and be 4 digits eg. (S110). Try again.");
                    }
                }
                else if(spotstfvis.contains("VISITOR"))
                {
                    /* checking if id starts with V, total length is 4 and contains numerics after V */
                    if (spotID.startsWith("V")  && spotID.length()==4 && spotID.substring(1).chars().allMatch( Character::isDigit ))
                    {
                        JOptionPane.showMessageDialog(null, "Success! Visitor Parking Added");
                        ParkingSlot aParkingSlot = new ParkingSlot(spotID);       // new parking spot by default isStaff is false
                        carpar.addNewParkingSlot(aParkingSlot);
                        headerpanel.removeAll();
                        showAllParkings();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Visitor Parking must start with V should be 4 digits eg. (V001). Try again");
                    }
                }
                /* if user doesn't choose staff or visitor. Display an error */
                else
                {
                    JOptionPane.showMessageDialog(null, "Please choose from \"staff\" or \"visitor\"");
                }
            }
        }
    }
    } 
    
   /**
    * Removing vehicle from spot and update the spot to empty
    * 
    */  
    
   public void removeVehicle(){
       boolean userQuery = false;
       String rego = JOptionPane.showInputDialog("Enter Registration Number of the Car eg. (30A12345)");
       if(rego!=null)
       {
       for(ParkingSlot aParkingSlot : carpar.getAllParkingSlots())
        {
            /*  checking if parking is occupied and vehicle is an instance of Car */
            if(aParkingSlot.getIsOccupied() && aParkingSlot.getVehicle() instanceof Car )
            {
                 /*  checking if registration matches. */
                if(((Car)aParkingSlot.getVehicle()).getrego().equals(rego))
                {
                 aParkingSlot.removeVehicle();
                 userQuery = true;
                 JOptionPane.showMessageDialog(null, "Success: Car Removed");
                 headerpanel.removeAll();
                 showAllParkings();
                }
            }
        }
    }
          /*  if user query isn't true, display an error */
       if(!userQuery)
        {
           JOptionPane.showMessageDialog(null, "Alert: No Car Found");
        }
    
    }
    
   /**
    *
    */
    
    
    public void actionPerformed(ActionEvent e)
    {
        /*
         * Action listener to get spotid from the button clicked
         * and show menu options to user and after menu being chosen 
         * run the associated function
         */
        String spotid = e.getActionCommand().substring(6, 10);
        final JPopupMenu menu = new JPopupMenu("Menu");
        menu.add("Add Parking Spot").addActionListener(ee-> {    
        addParkingSpot();                                 // run addParkingSpot function
        });
        menu.add("Delete Spot "+spotid ).addActionListener(ee-> {  
         removeParkingSpotSubMenu(spotid);                // run removeParkingSpotSubMenu function taking spotid as parameter
        });
        if(carpar.findParkingbyID(spotid).getIsOccupied()){
            
            menu.add("Remove Vehicle" ).addActionListener(ee-> {
            removeCarSubMenu(spotid);                     // run removeCarSubMenu function taking spotid 
                                                          //  as parameter if spot is occupied
        });
            
        }
        
        if(!carpar.findParkingbyID(spotid).getIsOccupied()){
            
            menu.add("Park Vehicle" ).addActionListener(ee-> {
            parkCarSubMenu(spotid);                             // run parkCarSubMenu function taking spotid 
        });                                                     //   as parameter if spot is empty
            
        }
        menu.show(labelButton, labelButton.getWidth(), labelButton.getHeight());   // display menu on parking slot button click
    }
    
   /**
    * ParkCarSubMenu showed when right click on parking spot
    */  
   
   public void parkCarSubMenu(String spotid)
   {
        String reg = JOptionPane.showInputDialog(null, "Enter Registration Number eg. (30A12345)", "Enter Registration Window", JOptionPane.INFORMATION_MESSAGE);
        if (reg !=null)
        {
            if (carpar.findVehicleRego(reg).isEmpty())
            {
                if (Character.isUpperCase(reg.charAt(2)) && reg.length()==8){
                      String owner = JOptionPane.showInputDialog(null, "Enter Owner Name", "Enter Owner Window", JOptionPane.INFORMATION_MESSAGE);
                    if(owner !=null)
                    {
                        Car car = new Car(reg , owner);                          // init new car
                        Vehicle vehicle = car;
                        int reply = JOptionPane.showConfirmDialog(null, "Is this a Staff Parking", "Staff Confirmation Window", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION)
                        {
                            if(carpar.findParkingbyID(spotid).getIsStaff())
                            {
                                carpar.findParkingbyID(spotid).addStaffVehicle(vehicle);
                                JOptionPane.showMessageDialog(null, "Success Staff Car is Parked");
                                headerpanel.removeAll();
                                showAllParkings();
                            }
                            else
                            {
                               JOptionPane.showMessageDialog(null, "This Spot " +spotid+" Isn't a Staff Spot", "Not a Staff Spot", JOptionPane.ERROR_MESSAGE);

                            }
                        }
                        else
                        {
                            if(!carpar.findParkingbyID(spotid).getIsStaff())
                            {
                                carpar.findParkingbyID(spotid).addVisitorVehicle(vehicle);
                                JOptionPane.showMessageDialog(null, "Success Visitor Car is Parked", "Car Parked", JOptionPane.INFORMATION_MESSAGE);
                                headerpanel.removeAll();
                                showAllParkings();
                            }
                            else
                            {
                               JOptionPane.showMessageDialog(null, "This Spot " +spotid+" Isn't a Visitor Spot", "Not a Visitor Spot", JOptionPane.ERROR_MESSAGE);

                            }

                        }
                    }
                }
                else
                {

                    JOptionPane.showMessageDialog(null, "Enter registration with proper format eg. (30A12345)", "Wrong Registration Format", JOptionPane.ERROR_MESSAGE);

                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Registration Already Exists In Car Park", "Duplicate Registration", JOptionPane.ERROR_MESSAGE);

            }
        }
    }
            
            
   /**
    * Removing the parkingSlot through clicking on parkingSlot button
    */         
            
   public void removeParkingSpotSubMenu(String spotid){
         if(carpar.removeAParkingSlot(spotid))
         {
            JOptionPane.showMessageDialog(null, "Success: Parking Spot Deleted");
            headerpanel.removeAll();
            showAllParkings();
         }
          else
         {
            JOptionPane.showMessageDialog(null, "Alert: Parking Spot is Occupied. Try again.");

         }
    }
   
    /**
    * Removing the car parked from an occupied parking slot.
    */   
            
   public void removeCarSubMenu(String id){
    carpar.findParkingbyID(id).removeVehicle();
    JOptionPane.showMessageDialog(null, "Success: Vehicle Removed");
    headerpanel.removeAll();
    showAllParkings();
    }
    
   /**
    * Displaying all parkingSlots to the user including occupied and empty spots.
    */ 
    
   
   public void showAllParkings(){
       String value = String.format("%-20s","ID");
       for(ParkingSlot aParkingSlot: carpar.getAllParkingSlots())
       {
           if (aParkingSlot.getVehicle() != null && aParkingSlot.getVehicle() instanceof Car && aParkingSlot.getIsOccupied())
           {
               labelButton = new JButton();
               labelButton.setText("<html>"+aParkingSlot.getParkingSlotId()+"<br/>"+ ((aParkingSlot.getIsStaff())?"Staff":"Visitor")+"<br/>"+((aParkingSlot.getIsOccupied())?"Occupied":"Empty")+"<br/>"+aParkingSlot.getVehicle().getOwner()+"<br/>"+((Car)aParkingSlot.getVehicle()).getrego()+"</html>");
               labelButton.setBackground(Color.RED);
               headerpanel.add(labelButton);
               labelButton.addActionListener(this);         // using this class as a listener for displayed buttons
            }
            else
            {
               labelButton = new JButton();
               labelButton.setText("<html>"+aParkingSlot.getParkingSlotId()+"<br/>"+ ((aParkingSlot.getIsStaff())?"Staff":"Visitor")+"<br/>"+((aParkingSlot.getIsOccupied())?"Occupied":"Empty")+"</html>");
               headerpanel.add(labelButton);
               labelButton.addActionListener(this);
            }            
       }
       headerpanel.revalidate();
       headerpanel.repaint();   
       mainFrame.setVisible(true);
    }
    
   /**
    * Finding the car by taking registration as an input from the user
    */  
   
   public void findCar(){
       headerpanel.removeAll(); 
       headerLabel= new JLabel("");
       String value ="";
       boolean query = false;
       String rego = JOptionPane.showInputDialog("The Registration Number of the Car eg. (30A12345)");
       if(rego!=null){
       value ="Your Parking details are as following: <br><p style='font-size:11px;'>"+"ID " + " Status " + " Vacancy " + " Registration "+ " Owner " + " Time In "+"</p>"+ "<br>";
       for(ParkingSlot aParkingSlot : carpar.getAllParkingSlots())
       {
          if(aParkingSlot.getIsOccupied() && aParkingSlot.getVehicle() instanceof Car )
          {
              if(((Car)aParkingSlot.getVehicle()).getrego().equals(rego))
              {
                value += " " +aParkingSlot.getParkingSlotId() +" "+((aParkingSlot.getIsStaff())?"Staff Parking":"Visitor Parking")+ " "+ ((aParkingSlot.getIsOccupied())?"Occupied":"Empty")+" "+((Car)aParkingSlot.getVehicle()).getrego()+" "+ aParkingSlot.getVehicle().getOwner()+ " "+ aParkingSlot.getVehicle().getTimeIn()+". min"+"<br>";
                query = true;
              }
          }
       }
    }
       if (!query)
       {
          value = "<p style='font-size:11px;'>Welcome to Ha Noi Car Park System</p>";
          JOptionPane.showMessageDialog(null, "No Car Found");
       }
       headerLabel.setText("<html><div style='text-align: center;'>" +value +"</div></html>");
       headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
       headerLabel.setVerticalAlignment(SwingConstants.CENTER);
       headerpanel.add(headerLabel);
       headerpanel.revalidate();
       headerpanel.repaint();
    }
    
   /**
    * Parking a car by taking the user input for the registration number, owner name and spot id. Duplicate registrations aren't allowed.
    */  
    
   public void parkCar(){
       String rego = JOptionPane.showInputDialog("The Registration Number of the Car eg (30A12345)");
       String value = "";
       if(rego!=null){
        if (rego.length()==8 && !carpar.findVehicleRego(rego).contains(rego) && Character.isUpperCase(rego.charAt(2)))
        {
            String owner = JOptionPane.showInputDialog("Enter Name of the owner");
            Car car = new Car(rego , owner);                          // init new car
            Vehicle vehicle = car;
           if(carpar.getAvailableParkingSlots().isEmpty()){
                headerLabel.setText("No Car Park Available");
           }
           else if(!carpar.findVehicleRego(rego).isEmpty()){
                JOptionPane.showMessageDialog(headerLabel, "Registration exists in car park. Please select another Registration", "Duplicate Vehicle", JOptionPane.WARNING_MESSAGE);
                headerLabel.setText("<html>Alert: Vehicle Registration Already exists! Can't Park more than one Vehicle.</html>");
           }
           else
           {
              //value = "Please select a Parking Spot from below: " + "<br>";
              headerpanel.removeAll();
              showAllParkings();
              String staffMember = JOptionPane.showInputDialog("Are you a staff member or visitor?");
              String parkingSpot = JOptionPane.showInputDialog("Enter Spot You Want to Park eg. (S001 if staff or V001 if visitor )");

              if (parkingSpot !=null && staffMember !=null){
              if(carpar.findParkingbyID(parkingSpot).getParkingSlotId().equals(parkingSpot) && !carpar.findParkingbyID(parkingSpot).getIsOccupied() )
            {  
              switch(staffMember)
              {
                  case "staff":
                  if(carpar.findParkingbyID(parkingSpot).getIsStaff()){
                      carpar.findParkingbyID(parkingSpot).addStaffVehicle(vehicle);
                      JOptionPane.showMessageDialog(null, "Success Staff Car is Parked");
                      headerpanel.removeAll();
                      showAllParkings();
                      break;
                    }
                  else{
                    JOptionPane.showMessageDialog(null, "The spot you have chosen is not a staff parking spot");
                    break;
                    }
                    
                  case "visitor":
                  if(!carpar.findParkingbyID(parkingSpot).getIsStaff()){
                      carpar.findParkingbyID(parkingSpot).addVisitorVehicle(vehicle);
                      JOptionPane.showMessageDialog(null, "Success Visitor Car is Parked");
                      headerpanel.removeAll();
                      showAllParkings();
                      break;
                    }
                  else{
                    JOptionPane.showMessageDialog(null, "The spot you have chosen is not a visitor parking spot");
                    break;
                    }  
                    
                  default:
                  JOptionPane.showMessageDialog(null,"Please enter \"staff\" or \"visitor\" ");
                  
              }
             
            }
            else
            {
                headerLabel.setText("<html><div style='text-align: center;'> Spot is occupied or no parking exists</div></html>");
                JOptionPane.showMessageDialog(headerLabel, "Spot is occupied or doesn't exist", "Parking Spot Error", JOptionPane.ERROR_MESSAGE);
            }
           }
        }
        }
        else
        {
            JOptionPane.showMessageDialog(headerLabel, "Make Sure Registration follows proper format eg.(30A12345).", "Registration input incorrect", JOptionPane.ERROR_MESSAGE);
        }
    }
    }
   
   /**
    * Main function to run the GUI application. A carpark instance is added to a GUI instance and showHomeScreen is called.
    */ 
    
   public static void main(String[] args)
   {
      CarPark carpar = new CarPark(); 
      GUI  newGUI = new GUI(carpar);  
      newGUI.showHomeScreen();
   }
}
