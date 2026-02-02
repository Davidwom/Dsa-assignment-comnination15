public class main {
    public static void main(String[] args) {

        DispatchController dc = new DispatchController();

        
        dc.units.insert(201.0);
        dc.units.insert(202.0);
        dc.units.insert(203.0);

        System.out.print("Active Units: ");
       
 
        dc.call("A", 3);
        dc.call("B", 1);
        dc.call("C", 1);

      
        dc.dispatch();

        
        dc.escalate("A", 1);

        dc.dispatch();


        System.out.print("Call Log (Queue): ");
        dc.callLog.display();

        System.out.print("Action History (Stack): ");
        dc.actionHistory.display();
    }
}