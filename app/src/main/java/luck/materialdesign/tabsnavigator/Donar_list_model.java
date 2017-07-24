package luck.materialdesign.tabsnavigator;

/**
 * Created by Jamshed on 7/24/2017.
 */

public class Donar_list_model {

    private String DonarName;
    private String DonarNumber;
    private String DonarAddress;

    public Donar_list_model(String donarName, String donarNumber, String donarAddress) {
        DonarName = donarName;
        DonarNumber = donarNumber;
        DonarAddress = donarAddress;
    }

    public String getDonarName() {
        return DonarName;
    }

    public void setDonarName(String donarName) {
        DonarName = donarName;
    }

    public String getDonarNumber() {
        return DonarNumber;
    }

    public void setDonarNumber(String donarNumber) {
        DonarNumber = donarNumber;
    }

    public String getDonarAddress() {
        return DonarAddress;
    }

    public void setDonarAddress(String donarAddress) {
        DonarAddress = donarAddress;
    }
}
