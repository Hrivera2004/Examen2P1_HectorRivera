
package ex2p1_hectorrivera;
    import java.util.ArrayList;
    import java.util.Scanner;
public class Items {
    ArrayList<Items> Backpack = new ArrayList<Items>();
    Scanner sc = new Scanner(System.in);
    String Name;
    int HPpoints;
    int MPpoints;
    
    
    public Items(){
    }
    public Items(String Name, int HPpoints, int MPpoints){
        this.Name=Name;
        this.HPpoints=HPpoints;
        this.MPpoints=MPpoints;
    }
    public void setMPpoints(int MPpoints) {
        this.MPpoints = MPpoints;
    }
    public void setHPpoints(int HPpoints) {
        this.HPpoints = HPpoints;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getName() {
        return Name;
    }
    public int getHPpoints() {
        return HPpoints;
    }
    public int getMPpoints() {
        return MPpoints;
    }
    
    
    
}
