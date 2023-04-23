package fr.ms.findmyhoops;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import fr.ms.findmyhoops.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    FirebaseDatabase point_db; // Fait le lien avec FireBase
    DatabaseReference ref_point_db; // Lie et écris dans la bdd
    private final int FINE_PERMISSION_CODE = 1;
    private GoogleMap mMap;
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviedClient;
    private ActivityMapsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        point_db = FirebaseDatabase.getInstance();
        ref_point_db = point_db.getReference("terrain");

        fusedLocationProviedClient = LocationServices.getFusedLocationProviderClient(this);
        getLastLocation();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.



    }

    private void getLastLocation() {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},FINE_PERMISSION_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviedClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location!= null){
                    currentLocation = location;
                    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                            .findFragmentById(R.id.map);
                    mapFragment.getMapAsync(MapsActivity.this);
                }
            }
        });
}

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        FirebaseDatabase point_db; // Fait la connection avec FireBase
        DatabaseReference ref_point_db; // Lie et écris dans la bdd

        // Add a marker in Sydney and move the camera
        LatLng a1 = new LatLng(48.9423, 2.15286);
        BitmapDescriptor icone2 = BitmapDescriptorFactory.fromResource(R.drawable.terrain);
        MarkerOptions option2 = new MarkerOptions()
                .position(new LatLng(48.9423, 2.15286))
                .title("L'île de Maison L'affite")
                .snippet(" 4 Terrain Ouvert ")
                .icon(icone2);
        mMap.addMarker(option2);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(a1));

        LatLng a2 = new LatLng(48.9100173, 2.1419506);
        BitmapDescriptor icone3 = BitmapDescriptorFactory.fromResource(R.drawable.terrain);
        MarkerOptions option3 = new MarkerOptions()
                .position(new LatLng(48.9100173, 2.1419506))
                .title("Gymnase Pablo Picasso")
                .snippet(" Gymnase ")
                .icon(icone3);
        mMap.addMarker(option3);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(a2));

        LatLng a3 = new LatLng(48.7509205, 2.47366);
        BitmapDescriptor icone1 = BitmapDescriptorFactory.fromResource(R.drawable.terrain);
        MarkerOptions option1 = new MarkerOptions()
                .position(new LatLng(48.7509205, 2.47366))
                .title("Terrain de basket")
                .snippet("Terrain ouvert")
                .icon(icone1);
        mMap.addMarker(option1);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(a3));





        LatLng a4 = new LatLng(48.8532558, 2.3605629);
        BitmapDescriptor icone = BitmapDescriptorFactory.fromResource(R.drawable.terrain);
        MarkerOptions option = new MarkerOptions()
                .position(new LatLng(48.8532558, 2.3605629))
                .title("Playground Saint-Paul")
                .snippet("Terrain ouvert")
                .icon(icone);
        mMap.addMarker(option);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(a4));


        LatLng a6 = new LatLng(48.944294, 2.159593);
        BitmapDescriptor icone4 = BitmapDescriptorFactory.fromResource(R.drawable.terrain);
        MarkerOptions option4 = new MarkerOptions()
                .position(new LatLng(48.944294, 2.159593))
                .title("Terrain du Parc du Dispensaire")
                .snippet("Terrain ouvert")
                .icon(icone4);
        mMap.addMarker(option4);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(a6));



        LatLng a7 = new LatLng(48.962948, 2.179712);
        BitmapDescriptor icone5 = BitmapDescriptorFactory.fromResource(R.drawable.terrain);
        MarkerOptions option5 = new MarkerOptions()
                .position(new LatLng(48.962948, 2.179712))
                .title("Terrain du la Frette-sur-Seine")
                .snippet("Terrain ouvert")
                .icon(icone5);
        mMap.addMarker(option5);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(a7));




        LatLng a8 = new LatLng(48.9026987, 2.2875143);
        BitmapDescriptor icone6 = BitmapDescriptorFactory.fromResource(R.drawable.terrain);
        MarkerOptions option6 = new MarkerOptions()
                .position(new LatLng(48.9026987, 2.2875143))
                .title("Playground Rudy Gobert by Courtside")
                .snippet("Terrain ouvert")
                .icon(icone6);
        mMap.addMarker(option6);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(a8));


        LatLng a9 = new LatLng(48.901701, 2.285619);
        BitmapDescriptor icone7 = BitmapDescriptorFactory.fromResource(R.drawable.terrain);
        MarkerOptions option7 = new MarkerOptions()
                .position(new LatLng(48.901701, 2.285619))
                .title("Terrain de Basketball")
                .snippet("Terrain ouvert")
                .icon(icone7);
        mMap.addMarker(option7);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(a9));



        LatLng a10 = new LatLng(48.8823826, 2.3356007);
        BitmapDescriptor icone8 = BitmapDescriptorFactory.fromResource(R.drawable.terrain);
        MarkerOptions option8 = new MarkerOptions()
                .position(new LatLng(48.8823826, 2.3356007))
                .title("Playground Duperré")
                .snippet("Terrain ouvert")
                .icon(icone8);
        mMap.addMarker(option8);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(a10));


        LatLng a5 = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        // Créer une icône personnalisée
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.icon);

        // Créer un marqueur avec l'icône personnalisée
        MarkerOptions options = new MarkerOptions()
                .position(new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude()))
                .title("Titre du marqueur")
                .snippet("Description du marqueur")
                .icon(icon);
        // Ajouter le marqueur à la carte
        mMap.addMarker(options);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(a5));
        LatLng a200 = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(a200, 15);
        mMap.moveCamera(cameraUpdate);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == FINE_PERMISSION_CODE){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getLastLocation();
            }else{
                Toast.makeText(this,"Demande de localisation refuser Veuillez l'accepter",Toast.LENGTH_SHORT).show();
            }


        }
    }
}

