package com.example.gabrielneves.mapa_igarassu;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import static com.example.gabrielneves.mapa_igarassu.R.id.map;

public class MapaActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
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

    private static final LatLng IGARASSULOCAL = new LatLng(-7.834195, -34.906142);

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        String nomeDosLocais[][] = {

                {"Igreja e Convento Franciscanos de Santo Antônio"}, //1									[OK]
                {"Secretária de Turismo"},	//2															    [OK]
                {"Empresa de Urbanização de Igarassu(URBI)"},	//3										    [OK]
                {"Câmara Municipal"},	//4															    	[OK]
                {"Ruínas da Igreja da Misericórdia"},//5													[OK]
                {"Casa do Artesão"},	//6																	[OK]
                {"Casa do Patrimônio em Igarassu/Iphan(Sobrado do Imperador)"},	//7						    [OK]
                {"Recolhimento e Igreja do Sagrado Coração de Jesus"},	//8							    	[OK]
                {"Museu Histórico"},	//9																	[OK]
                {"Igreja de São Cosme e São Damião"},	//10										    	[OK]
                {"Casa Paroquial"},	//11															    	[OK]
                {"CVT - Centro Vocacional Tecnológico"},	//12											[OK]
                {"Biblioteca Municipal"},	//13														    [OK]
                {"Loja Maçônica"},	//14															    	[OK]
                {"Secretária de Planejamento, Meio Ambiente e Patrimônio Histórico(SEPLAMAPH)"},	//15	[OK]
                {"Prefeitura Municipal"},	//16														    [OK]
                {"Igreja de Nossa Senhora do Livramento"},	//17										    [OK]
                {"Centro de Artes e Cultura"},	//18													    [OK]
                {"Igreja de São Sebastião"},	//19														[OK]
                {"Secretária de Obras"},//20														    	[OK]

        };

        Double localizacao[][] = {

                {-7.832511, -34.905131},    //1								                	[OK]
                {-7.8337595,-34.9054833},	//2													[OK]
                {-7.834452, -34.905451},	//3						               				[OK]
                {-7.835233, -34.906164},	//4													[OK]
                {-7.8358037,-34.9073714},   //5													[OK]
                {-7.834902, -34.906872},	//6													[OK]
                {-7.834733, -34.906740},	//7						                            [OK]
                {-7.834387, -34.906491},	//8								                    [OK]
                {-7.834078, -34.906410},	//9													[OK]
                {-7.834018, -34.906148},	//10				    							[OK]
                {-7.833618, -34.906010},	//11												[OK]
                {-7.833499, -34.905951},	//12				    							[OK]
                {-7.833318, -34.905844},	//13												[OK]
                {-7.832854, -34.906450},	//14												[OK]
                {-7.832889, -34.906573},	//15	                                            [OK]
                {-7.833217, -34.906572},	//16							    				[OK]
                {-7.833169, -34.906673},	//17				        						[OK]
                {-7.832004, -34.908098},	//18												[OK]
                {-7.831667, -34.908622},	//19												[OK]
                {-7.8316536,-34.9091987},   //20												[OK]

        };

        for (int i = 0; i < localizacao.length; i++) {

            LatLng local = new LatLng(localizacao[i][0], localizacao[i][1]);
            mMap.addMarker(new MarkerOptions().position(local).title(nomeDosLocais[i][0]));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(IGARASSULOCAL, 16));
        }
    }
}
