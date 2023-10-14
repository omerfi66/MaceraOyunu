import java.util.logging.SimpleFormatter;

public abstract class BattelLoc extends Location {
    protected Obstacle obstacle;
    protected String award;

    BattelLoc(Player player, String name, Obstacle obsbtacle,String award) {
        super(player);
        this.obstacle = obsbtacle;
        this.name = name;
        this.award=award;
    }

    public boolean getLocation() {
        int obsCount = obstacle.count();
        System.out.println("şuan buradasınız " + this.getName());
        System.out.println("Dikkatli ol burada " + obsCount + " tane " + obstacle.getName() + " yaşıyor !");
        System.out.println("<S> savaş veya <K> kaç");
        String selCase=scan.nextLine();
        selCase=selCase.toUpperCase();
        if(selCase.equals("S")){
            if (combat(obsCount)){
                System.out.println(this.getName()+" bölgesinde ki Tüm düşmanları temizlediniz..!");
                if(this.award.equals("Food") && player.getInv().isFood() == false){
                    System.out.println(this.award + "Kazandınız !");
                    player.getInv().setFood(true);
                }else if (this.award.equals("Water") && player.getInv().isWater() == false){
                    System.out.println(this.award + "Kazandınız !");
                    player.getInv().setWater(true);
                }else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false){
                    System.out.println(this.award + "Kazandınız !");
                    player.getInv().setFirewood(true);
                }
                return true;
            }
            if (player.getrHealty()<=0){
                System.out.println("öldünüz..!");
                return false;
            }
        }

        return true;
    }
    public  boolean combat(int obsCount){
        for(int i=0; i<obsCount;i++){
            int defObsHealth=obstacle.getHealth();
            playerStats();
            enemyStats();
            while (player.getrHealty() > 0 && obstacle.getHealth()>0){
                System.out.println("<V> vur veya <K> kaç : ");
                String selCase=scan.nextLine();
                selCase=selCase.toUpperCase();
                if (selCase.equals("V")){
                    System.out.println("Siz vurdunuz !");
                    obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHealth() > 0){
                        System.out.println("Canavar sizi vurdu");
                        player.setHealty(player.getHealty() - (obstacle.getDamage() - player.getInv().getArmor()));
                        afterHit();
                    }

                }else {
                    return false;
                }

            }
            if (obstacle.getHealth() <= 0 && player.getHealty()>0){
                //if (obstacle.getHealth() < player.getHealty()){
                System.out.println("düşmanı yendiniz");
                player.setMoney(player.getMoney() + obstacle.getAwart());
                System.out.println("Güncel paranız : " +player.getMoney());
                obstacle.setHealth(defObsHealth);


            }else {
                return false;
            }
            System.out.println("-------------------");
        }
        return  true;
    }
    public void playerStats(){
        System.out.println("Oyuncu değerleri \n ------");
        System.out.println("Can: "+player.getHealty());
        System.out.println("Hasar: "+ player.getTotalDamage());
        System.out.println("para " +player.getMoney());
        if (player.getInv().getDamage()>0){
            System.out.println("Silah: "+player.getInv().getwName());
        }
        if (player.getInv().getArmor()>0){
            System.out.println("Zırh: "+player.getInv().getaName());
        }
    }
    public  void  enemyStats(){
        System.out.println(obstacle.getName()+ " değerleri \n ---------");
        System.out.println("Can: " + obstacle.getHealth());
        System.out.println("Hasar: " + obstacle.getDamage());
        System.out.println("ödül: "+obstacle.getAwart());
    }
    public void  afterHit(){
        System.out.println("oyuncu canı: "+player.getrHealty());
        System.out.println(obstacle.getName() + " Canı: " + obstacle.getHealth());
        System.out.println();

    }
}
