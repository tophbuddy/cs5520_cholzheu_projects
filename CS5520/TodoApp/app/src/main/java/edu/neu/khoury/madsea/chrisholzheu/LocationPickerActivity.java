package edu.neu.khoury.madsea.chrisholzheu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import edu.neu.khoury.madsea.chrisholzheu.data.ToDo;
import edu.neu.khoury.madsea.chrisholzheu.databinding.ActivityChooseLocationBinding;

public class LocationPickerActivity extends Fragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap taskMap;
    private ToDoViewModel viewModel;
    private List<ToDo> toDoList;
    private ActivityChooseLocationBinding chooseLocationBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        chooseLocationBinding = ActivityChooseLocationBinding.inflate(inflater, container, false);
        chooseLocationBinding.setLifecycleOwner(this);
        return chooseLocationBinding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        taskMap = googleMap;

        LatLng sydney = new LatLng(-34, 151);
        taskMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        taskMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        taskMap.getUiSettings().setZoomControlsEnabled(true);
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {

    }

}
