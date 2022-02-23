package entity;

public class Hotkeys {
    public String hotkey;

    public String getHotkey() {
        return hotkey;
    }

    public void setHotkey(String hotkey) {
        this.hotkey = hotkey;
    }

    @Override
    public String toString() {
        return "Hotkeys{" + "hotkey='" + hotkey + '\'' + '}';
    }
}
