package winds.com.ibike.ViewController.Accessory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BikeInfo {
    @SerializedName("materialID")
    @Expose
    private String materialID;
    @SerializedName("materialName")
    @Expose
    private String materialName;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("maxKm")
    @Expose
    private Integer maxKm;

    public String getMaterialID() {
        return materialID;
    }

    public void setMaterialID(String materialID) {
        this.materialID = materialID;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(Integer maxKm) {
        this.maxKm = maxKm;
    }
}
