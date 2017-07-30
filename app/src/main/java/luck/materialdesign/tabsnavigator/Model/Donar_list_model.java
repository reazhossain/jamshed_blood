package luck.materialdesign.tabsnavigator.Model;

/**
 * Created by Jamshed on 7/24/2017.
 */

public class Donar_list_model {

    private String DonarName;
    private String DonarNumber;
    private String DonarAddress;
    private String Blood_group;

    public Donar_list_model(String donarName, String donarNumber, String donarAddress, String blood_group) {
        DonarName = donarName;
        DonarNumber = donarNumber;
        DonarAddress = donarAddress;
        Blood_group = blood_group;
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

    public String getBlood_group() {
        return Blood_group;
    }

    public void setBlood_group(String blood_group) {
        Blood_group = blood_group;
    }
}

