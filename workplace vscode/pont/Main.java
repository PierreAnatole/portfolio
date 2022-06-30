package pont;

public class Main {
    public static void main(String[] args) {
        Device tv = new Tv(50, 15);
        Device radio = new Radio(10, 94);

        Remote telecommande = new Remote(tv);
        System.out.println("chaine en cours : "+tv.getChannel());
        telecommande.channelUp();
        System.out.println("chaine en cours : "+tv.getChannel());
        telecommande.channelDown();
        telecommande.channelDown();
        telecommande.channelDown();
        telecommande.channelDown();
        System.out.println("chaine en cours : "+tv.getChannel());

        
        AdvancedRemote telecommande2 = new AdvancedRemote(radio);
        System.out.println("son de la radio : "+radio.getVolume());
        telecommande2.volumeUp();
        System.out.println("son de la radio : "+radio.getVolume());
        telecommande2.mute();
        System.out.println("son de la radio : "+radio.getVolume());

    }
}
