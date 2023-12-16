package ex2p1_hectorrivera;
    import java.util.ArrayList;
    import java.util.Random;
    import java.util.Scanner;
public class Personaje {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    Items Objetos = new Items();
    
    ArrayList<Personaje> Party = new ArrayList<Personaje>();
    ArrayList<Personaje> Reserve = new ArrayList<Personaje>();

    String Nombre;
    int HP;
    int MP;
    int AttackPoints;
    int DefensePoints;
    
    public Personaje(){
    }
    public Personaje(String name, int hp, int mp, int AP, int DP){
        this.Nombre=name;
        this.HP=hp;
        this.MP=mp;
        this.AttackPoints=AP;
        this.DefensePoints=DP;
    }

    public String getNombre() {
        return Nombre;
    }
    public int getAttackPoints() {
        return AttackPoints;
    }
    public int getDefensePoints() {
        return DefensePoints;
    }
    public int getMP() {
        return MP;
    }
    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public void setMP(int MP) {
        this.MP = MP;
    }
    
    public void start(){
        String Name=" ";
        int HP=0,MP=0,AP=0,DP=0;
        for (int i = 0; i < 3; i++) {
            if (i==0) {
                Name="Sora";
                HP=300;
                MP=300;
                AP=75;
                DP=15;
            }else if(i==1){
                Name="Donald";
                HP=150;
                MP=450;
                AP=45;
                DP=10;                
            }else{
                Name="Goofy";
                HP=450;
                MP=100;
                AP=150;
                DP=50;                
            }
            Personaje Char = new Personaje(Name,HP,MP,AP,DP);
            Party.add(Char);
        }
        for (int i = 0; i < 3; i++) {
            if (i==0) {
                Name="Mickey";
                HP=100;
                MP=500;
                AP=150;
                DP=35;
            }else if(i==1){
                Name="Roxas";
                HP=300;
                MP=300;
                AP=15;
                DP=75;                
            }else{
                Name="Kiari";
                HP=200;
                MP=200;
                AP=50;
                DP=15;                
            }
            Personaje Char = new Personaje(Name,HP,MP,AP,DP);
            Reserve.add(Char);
        }
        Items Pocion = new Items("Pocion",50,0);
        Objetos.Backpack.add(Pocion);
        Items Ether = new Items("Ether",0,50);
        Objetos.Backpack.add(Ether);
        Items Elixir = new Items("Elixir",100,100);
        Objetos.Backpack.add(Elixir);
    } 
    
    public void Play(){
        randomEvent( 1);
        System.out.println("Desea continuar: ");
        char yes = sc.next().charAt(0);
    }
    public void randomEvent(int random){
        switch(random){
            case 1:
                int yes = rd.nextInt(2)+1;
                ActionMenu(yes);// continuar
                break;
            case 2:
                Items Pocion = new Items("Pocion",50,0);
                Objetos.Backpack.add(Pocion);
                System.out.println("Te has encontrado un cofre con una Pocion!");
                break;
            case 3:
                Items Ether = new Items("Ether",0,50);
                Objetos.Backpack.add(Ether);
                System.out.println("Te has encontrado un cofre con una Ether!");
                break;
            case 4:
                Items Elixir = new Items("Elixir",100,100);
                Objetos.Backpack.add(Elixir);
                System.out.println("Te has encontrado un cofre con una Elixir!");
                break;
            case 5:
                int objeto = rd.nextInt(Objetos.Backpack.size());
                System.out.println("Te has encontrado a unos Amigos les regalas un "+Objetos.Backpack.get(0).getName());
                Objetos.Backpack.remove(0);
                break;        
        }
    }
    public int chooseCharacter(){
        for (int i = 0; i < 3; i++) {
            System.out.println("");
            System.out.println(i+". "+Party.get(i).getNombre());
            System.out.println("    HP = "+ Party.get(i).getHP());
            System.out.println("    MP = "+ Party.get(i).getMP());
            System.out.println("    Attack Points: = "+ Party.get(i).getAttackPoints());
            System.out.println("    Defense Points: = "+ Party.get(i).getDefensePoints());
        }
        System.out.println("\nElija el personaje: ");
        int Character = sc.nextInt();
        while(Character<0||Character>2 && Party.get(Character).getHP()>0){
            System.out.println("Ingrese un numero valido: \n");
            Character = sc.nextInt();
        }
        return Character;
    }
    public void ActionMenu(int heartless){
        
        int Heartless_hp = 75*heartless, Heartless_atk = 25*heartless;
        System.out.println("Te has encontrado con "+heartless+" heartless");
        while (Heartless_hp!=0){  
            int personaje = chooseCharacter();
            System.out.println("----Menu----");
            System.out.println("1.Attack"
                    + "\n2.Magic"
                    + "\n3.Items"
                    + "\n4.Party");
            int opc = sc.nextInt();
            while(opc<1||opc>4){
                System.out.println("Ingrese un numero valido: \n");
                opc = sc.nextInt();
            }
            switch(opc){
                case 1:
                    System.out.println(Party.get(personaje).getNombre()+" ha atacado ");
                    Heartless_hp-=Party.get(personaje).getAttackPoints();
                    break;
                case 2:
                    Heartless_hp-=magic(personaje);
                    System.out.println("");
                    break;
                case 3:
                    UseItem(personaje);
                    break;
                case 4:
                    swap(personaje);
                    break;
            }
            if (Heartless_hp<=0) {
                Heartless_hp=0;
            }
            
            System.out.println("Vida heartless: " + Heartless_hp );
            System.out.println("El heartless a atacado");
            int awdsda= Party.get(personaje).getHP();
            int damage = awdsda - Heartless_atk;
            if (damage<=0) {
                damage=0;
            }
            Party.get(personaje).setHP(damage);
            System.out.println("-----------------");
        } 
        System.out.println("A derrotado al heartless");
    }
    
    public int magic(int personaje){
        System.out.println("\n1.Blizzard  50MP - 50DMG"
                        + "\n2.Firaga  25MP - 25DMG"
                        + "\n3.Gravity  75MP - 100DMG");
        int opc = sc.nextInt();
        while(opc<1||opc>3){
                System.out.println("Ingrese un numero valido: \n");
                opc = sc.nextInt();
        }
        int atk=0;
        System.out.println(Party.get(personaje).getNombre()+" uso");
        switch(opc){
            case 1:
                System.out.print(" Blizzard");
                Party.get(personaje).setMP(Party.get(personaje).getMP()-50);
                atk = 50;
                break;
            case 2:
                System.out.print(" Firaga");
                Party.get(personaje).setMP(Party.get(personaje).getMP()-25);
                atk = 25;
                break;
            case 3:
                System.out.print(" Gravity");
                Party.get(personaje).setMP(Party.get(personaje).getMP()-70);
                atk = 100;
                break;
        }
        return atk;
    }
    
    public void UseItem(int personaje){
        for (int i = 0; i < Objetos.Backpack.size(); i++) {
            System.out.println("");
            System.out.println(i+". "+Objetos.Backpack.get(i).getName());
            System.out.println("    HP = "+ Objetos.Backpack.get(i).getHPpoints());
            System.out.println("    MP = "+ Objetos.Backpack.get(i).getMPpoints());
        }
        int opc = sc.nextInt();
        while(opc<0||opc>2){
            System.out.println("Ingrese un numero valido: \n");
            opc = sc.nextInt();
        }
        int heal=Party.get(personaje).getHP()-Objetos.Backpack.get(opc).getHPpoints();
        Party.get(personaje).setHP(heal);
        int Mana=Party.get(personaje).getMP()-Objetos.Backpack.get(opc).getMPpoints();
        Party.get(personaje).setMP(Mana);
        Objetos.Backpack.remove(opc);
        
    }
    public void swap(int personaje){
        System.out.println("--Cambiar personaje--");
        System.out.println("--Reserva--");
        
        for (int i = 0; i < 3; i++) {
            System.out.println("");
            System.out.println(i+". "+Reserve.get(i).getNombre());
            System.out.println("    HP = "+ Reserve.get(i).getHP());
            System.out.println("    MP = "+ Reserve.get(i).getMP());
            System.out.println("    Attack Points: = "+ Reserve.get(i).getAttackPoints());
            System.out.println("    Defense Points: = "+ Reserve.get(i).getDefensePoints());
        }
        int opc = sc.nextInt();
        while(opc<0||opc>2){
            System.out.println("Ingrese un numero valido: \n");
            opc = sc.nextInt();
        }
        ArrayList<Personaje> temp = new ArrayList<Personaje>();
        temp.add(Party.get(personaje));
        temp.add(Reserve.get(opc));
        Party.remove(personaje);
        Reserve.remove(opc);
        Reserve.add(temp.get(0));
        Party.add(temp.get(1));
    }
}
