package fr.ms.findmyhoops;



public class SiteBasket {
    private String mNomUniqueSite;
    private String mDescription;
    private double mLatitude;
    private double mLongitude;

    public SiteBasket(){
    }
    public SiteBasket(String nomUniqueSite, String description, double latitude, double longitude) {
        mNomUniqueSite = nomUniqueSite;
        mDescription = description;
        mLatitude = latitude;
        mLongitude = longitude;
    }
    public String getNomUniqueSite() {
        return mNomUniqueSite;
    }
    public void setNomUniqueSite(String nomUniqueSite) {
        mNomUniqueSite = nomUniqueSite;
    }
    public String getDescription() {
        return mDescription;
    }
    public void setDescription(String description) {
        mDescription = description;
    }
    public double getLatitude() {
        return mLatitude;
    }
    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }
    public double getLongitude() {
        return mLongitude;
    }
    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }
}