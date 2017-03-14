package iphan.pibex.igarassu.ifpe.edu.br;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.example.gabrielneves.mapa_igarassu.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.gabrielneves.mapa_igarassu.R.id.map;

public class MapaActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Location[] locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);

        populateLocations();


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

    private static final LatLng CENTER_LOCATION = new LatLng(-7.834195, -34.906142);

    @Override
    public void onMapReady(GoogleMap googleMap) {


        this.mMap = googleMap;

        populateMap();

        this.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CENTER_LOCATION, 16));

    }

    private void infoWindow() {

        if (this.mMap != null) {
            this.mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                    View v = getLayoutInflater().inflate(R.layout.info_window, null);

                    TextView tvLocality = (TextView) v.findViewById(R.id.tv_locality);
                    TextView tvLat = (TextView) v.findViewById(R.id.tv_lat);
                    TextView tvLng = (TextView) v.findViewById(R.id.tv_lng);
                    TextView tvSnippet = (TextView) v.findViewById(R.id.tv_snippet);

                    LatLng location = marker.getPosition();
                    tvLocality.setText(marker.getTitle());
                    tvLat.setText("Latitude: " + location.latitude);
                    tvLng.setText("Longitude: " + location.longitude);
                    tvSnippet.setText(marker.getTitle());

                    return v;
                }
            });
        }
    }


    private void populateMap() {

        for (Location l : locations) {
            LatLng location = new LatLng(l.getLongitude(), l.getLatitude());
            //this.mMap.addMarker(new MarkerOptions().position(location).title(l.getName()));

            MarkerOptions options = new MarkerOptions()
                    //.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher))
                    .title(l.getName())
                    .position(location);
            this.mMap.addMarker(options);

            infoWindow();

        }
    }

    private void populateLocations() {
        // TODO: load the date from a file or and database

        Object[][] rawData = new Object[][]{
                {"Igreja e Convento Franciscanos de Santo Antônio", -7.832511, -34.905131}, //1
                {"Secretária de Turismo", -7.8337595, -34.9054833},    //2
                {"Empresa de Urbanização de Igarassu(URBI)", -7.834452, -34.905451},    //3
                {"Câmara Municipal", -7.835233, -34.906164},    //4
                {"Ruínas da Igreja da Misericórdia", -7.8358037, -34.9073714},//5
                {"Casa do Artesão", -7.834902, -34.906872},    //6
                {"Casa do Patrimônio em Igarassu/Iphan(Sobrado do Imperador)", -7.834733, -34.906740},    //7
                {"Recolhimento e Igreja do Sagrado Coração de Jesus", -7.834387, -34.906491},    //8
                {"Museu Histórico", -7.834078, -34.906410},    //9
                {"Igreja de São Cosme e São Damião", -7.834018, -34.906148},    //10
                {"Casa Paroquial", -7.833618, -34.906010},    //11
                {"CVT - Centro Vocacional Tecnológico", -7.833499, -34.905951},    //12
                {"Biblioteca Municipal", -7.833318, -34.905844},    //13
                {"Loja Maçônica", -7.832854, -34.906450},    //14
                {"Secretária de Planejamento, Meio Ambiente e Patrimônio Histórico(SEPLAMAPH)", -7.832889, -34.906573},    //15
                {"Prefeitura Municipal", -7.833217, -34.906572},    //16
                {"Igreja de Nossa Senhora do Livramento", -7.833169, -34.906673},    //17
                {"Centro de Artes e Cultura", -7.832004, -34.908098},    //18
                {"Igreja de São Sebastião", -7.831667, -34.908622},    //19
                {"Secretária de Obras", -7.8316536, -34.9091987}//20

        };

        this.locations = new Location[rawData.length];

        for (int i = 0; i < rawData.length; i++) {
            locations[i] = new Location((String) rawData[i][0], (Double) rawData[i][1], (Double) rawData[i][2]);
        }
    }

}
