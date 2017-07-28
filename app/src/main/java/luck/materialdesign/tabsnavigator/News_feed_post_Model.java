package luck.materialdesign.tabsnavigator;

/**
 * Created by Jamshed on 7/28/2017.
 */

public class News_feed_post_Model {
    private String Status;
    private String Hospital_name;
    private String SeekerNumber;

    public News_feed_post_Model(String status, String hospital_name, String seekerNumber) {
        Status = status;
        Hospital_name = hospital_name;
        SeekerNumber = seekerNumber;
    }



    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getHospital_name() {
        return Hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        Hospital_name = hospital_name;
    }

    public String getSeekerNumber() {
        return SeekerNumber;
    }

    public void setSeekerNumber(String seekerNumber) {
        SeekerNumber = seekerNumber;
    }



}
