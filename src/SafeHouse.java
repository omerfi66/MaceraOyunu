public class SafeHouse extends  NormalLoc{

     SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean getLocation() {
        player.setHealty(player.getrHealty());
        System.out.println("iyileştiniz");
        System.out.println("Şuan güvenli evdesiniz");
        return true;

    }
}
