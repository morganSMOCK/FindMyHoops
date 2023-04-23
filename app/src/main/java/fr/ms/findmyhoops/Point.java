package fr.ms.findmyhoops;

import com.google.android.gms.maps.GoogleMap;

import fr.ms.findmyhoops.databinding.ActivityMapsBinding;

public class Point {
    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    public Point(GoogleMap mMap, ActivityMapsBinding binding) {
        this.mMap = mMap;
        this.binding = binding;
    }

    public GoogleMap getmMap() {
        return mMap;
    }

    public void setmMap(GoogleMap mMap) {
        this.mMap = mMap;
    }

    public ActivityMapsBinding getBinding() {
        return binding;
    }

    public void setBinding(ActivityMapsBinding binding) {
        this.binding = binding;
    }
}
