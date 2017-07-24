package luck.materialdesign.tabsnavigator.Model;

/**
 * Created by prince on 2/10/2017.
 */

public class PlacesListModel {
    private String name;
    private Double rating;
    private String address;
    private String place_id;

    public PlacesListModel(String name, String address, Double rating, String place_id) {
        this.name = name;
        this.rating = rating;
        this.address = address;
        this.place_id = place_id;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
