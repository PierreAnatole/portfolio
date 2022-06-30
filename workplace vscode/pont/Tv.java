package pont;

public class Tv implements Device{

    private boolean enabled;
    private int volume;
    private int channel;

    public Tv(int volume, int channel) {
        this.volume = volume;
        this.channel = channel;
        this.enabled=false;
    }
    
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public void enable() {
        this.enabled=true;
    }

    @Override
    public void disable() {
        this.enabled=false;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }
}
