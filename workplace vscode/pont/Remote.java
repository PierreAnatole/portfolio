package pont;

public class Remote {
    // Un appareil qui implémente l'interface device.
    private Device device;

    
    
    public Remote(Device device) {
        this.device = device;
    }


    public void togglePower(){
       if (device.isEnabled()) {
           device.disable();
       }
       else {
           device.enable();
       }
    }

    public void volumeUp() {
        device.setVolume(device.getVolume()+1);
    }

    public void volumeDown() {
        device.setVolume(device.getVolume()-1);
    }
    
    public void channelUp() {
        device.setChannel(device.getChannel()+1);
    }
    
    public void channelDown() {
        device.setChannel(device.getChannel()-1);
    }

    public Device getDevice() {
        return device;
    }
    
}
