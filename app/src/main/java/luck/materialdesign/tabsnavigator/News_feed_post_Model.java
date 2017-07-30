package luck.materialdesign.tabsnavigator;

/**
 * Created by Jamshed on 7/28/2017.
 */

public class News_feed_post_Model {
    private String Status;
    private String Hospital_name;
    private String SeekerNumber;

    public News_feed_post_Model(String status, String hospital_name, String seekerNumber) {
        this.Status = status;
        this.Hospital_name = hospital_name;
        this.SeekerNumber = seekerNumber;
    }

    public News_feed_post_Model(){}


    public String getStatus() {

        if(Status != null)
            return Status;
        else
            return "Null";
    }

    public void setStatus(String status) {

        if(status != null)
            Status = status;
        else
            Status = "Null";
    }

    public String getHospital_name() {

        if(Hospital_name != null)
            return Hospital_name;
        else
            return "Null";


    }

    public void setHospital_name(String hospital_name) {

        if(hospital_name != null)
            Hospital_name = hospital_name;
        else
            Hospital_name = "Null";
    }

    public String getSeekerNumber() {


        if(SeekerNumber != null)
            return SeekerNumber;
        else
            return "Null";
    }

    public void setSeekerNumber(String seekerNumber) {

        if(seekerNumber != null)
                SeekerNumber = seekerNumber;
        else
            seekerNumber = "Null";
    }



}
