import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class IDevice {
    public interface LibIMobileDevice extends Library {
        LibIMobileDevice INSTANCE = (LibIMobileDevice) Native.loadLibrary((Platform.isWindows() ? "libimobiledevice.dll" : "imobiledevice"), LibIMobileDevice.class);

        int idevice_get_device_list(String[] device_list, int size);
        int idevice_get_device_info(String udid, String key, String[] value);
    }

    public static void main(String[] args) {
        String[] device_list = new String[10];
        int count = LibIMobileDevice.INSTANCE.idevice_get_device_list(device_list, 10);
        if (count > 0) {
            String udid = device_list[0];
            String key = "ProductType";
            String[] value = new String[1];
            int result = LibIMobileDevice.INSTANCE.idevice_get_device_info(udid, key, value);
            if (result == 0) {
                System.out.println("Device name: " + value[0]);
            }
        }
    }
}
