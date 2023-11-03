
public class OOP {

    public static void main(String[] args) {
        var shouldShowObjects = false;

        if (shouldShowObjects) {
            Objects.run();
        }

        var shouldShowComputer = true;

        if (shouldShowComputer) {
            var tostadora = new Computer(OSs.Linux, 20, 128);
            System.out.println(tostadora);
        }
    }
}

/**
 * Objects model aspects of the real world by representing the state and
 * behavior of real world objects.
 */
class Objects {

    public static void run() {
        System.out.println("Objects.");
    }

}

enum OSs {
    Linux,
    Windows,
    MacOS,
}

/**
 * A class is a blueprint for an object.
 */
class Computer {

    private OSs os;
    private int ram;
    private int storage;

    public Computer(OSs os, int ram, int storage) {
        this.os = os;
        this.ram = ram;
        this.storage = storage;
    }

    public OSs getOs() {
        return os;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setOs(OSs os) {
        this.os = os;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return STR."Computer(os=\{this.os}, ram=\{this.ram}, storage=\{this.storage})";
    }
}


    
