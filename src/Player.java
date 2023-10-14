import java.util.Scanner;

public class Player {
    private int damage, healty, money,rHealty;
    private String name, cName;
    private Inventory inv;
    Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inv=new Inventory();
    }

    public void selectCha() {
        switch (chaMenu()) {
            case 1:
                initPlayer("Samuray", 5, 21, 15);
                break;
            case 2:
                initPlayer("Şovalye", 7, 18, 20);
                break;
            case 3:
                initPlayer("Okçu", 8, 24, 5);
                break;
            default:
                setcName("Samuray");
                setDamage(5);
                setHealty(21);
                setMoney(15);
                break;
        }
        System.out.println("Karakter : " + getcName() + "\t Hasar: " + getDamage() + "\t Sağlık: " + getHealty() + "\t Para: " + getMoney());
    }

    public int chaMenu() {
        System.out.println("Lütfen bir karakter seçiniz : ");
        System.out.println("1 - Samuray ,\t Hasar :5,\t Sağlık : 21,\t Para:15");
        System.out.println("2 - Okçu ,\t     Hasar :7,\t Sağlık : 18,\t Para:20");
        System.out.println("3 - Şovalye ,\t Hasar :8,\t Sağlık : 24,\t Para:5");
        System.out.println("Karakter Seçiminiz : ");
        int chaID = scan.nextInt();

        while (chaID < 1 || chaID > 3) {
            System.out.println("Lütfen geçerli bir karakter seçiniz !");
            chaID = scan.nextInt();
        }


        return chaID;
    }
    public  int getTotalDamage(){
        return this.getDamage()+this.getInv().getDamage();
    }

    public void initPlayer(String cName, int dmg, int hlty, int mny) {
        setcName(cName);
        setDamage(dmg);
        setHealty(hlty);
        setMoney(mny);
        setHealty(hlty);


    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealty() {
        return healty;
    }

    public void setHealty(int healty) {
        this.healty = healty;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getrHealty() {
        return rHealty;
    }

    public void setrHealty(int rHealty) {
        this.rHealty = rHealty;
    }
}
