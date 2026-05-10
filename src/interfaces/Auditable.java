
package interfaces;

/*
  Auditable Interface
  
  This interface is used for tracking and logging actions performed on objects.
  
  Any class that implements this interface must provide implementation for
  logAction(String action) method to record important operations like
  deposits, withdrawals, or any system activity.

 */

public interface Auditable {
    
     void logAction(String action);
    
}
