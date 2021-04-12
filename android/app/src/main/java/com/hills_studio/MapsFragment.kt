package com.hills_studio

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {
    private var locationManager: LocationManager? = null
    private var receivedLocation: LatLng? = null

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        googleMap.clear()
        googleMap.addMarker(receivedLocation?.let {
            MarkerOptions().position(it).title("My location")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .alpha(0.5F)
        })

        val member1 = LatLng(51.442, 5.469)
        val member2 = LatLng(52.332, 5.234)
        val member3 = LatLng(49.415, 6.936)
        val member4 = LatLng(51.655, 5.123)
        googleMap.addMarker(
            MarkerOptions()
                .position(member1)
                .title("Nance Reddington")
        )
        googleMap.addMarker(
            MarkerOptions()
                .position(member2)
                .title("Josh Hasnip")
        )
        googleMap.addMarker(
            MarkerOptions()
                .position(member3)
                .title("Filberto Britto")
        )
        googleMap.addMarker(
            MarkerOptions()
                .position(member4)
                .title("Stearne McHugh")
        )
        //googleMap.animateCamera(CameraUpdateFactory.newLatLng(member1))
    }

    private val goToMyLocation = OnMapReadyCallback { googleMap ->
        if (receivedLocation != null) {
            googleMap.animateCamera(CameraUpdateFactory.newLatLng(receivedLocation))
        } else {
            Toast.makeText(context, "Trying to get your location...", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_maps, container, false)

        val btnMyLocation = root.findViewById<Button>(R.id.btnMyLocation)
        btnMyLocation.setOnClickListener {
            val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
            mapFragment?.getMapAsync(goToMyLocation)
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkLocationPermissions()
    }

    private fun updateMapLocation() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    private fun startLocationUpdates() {
        // Create persistent LocationManager reference
        locationManager =
            context?.getSystemService(AppCompatActivity.LOCATION_SERVICE) as LocationManager?
        try {
            // Request location updates
            locationManager?.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                0L,
                0f,
                locationListener
            )
        } catch (ex: SecurityException) {
            Log.d("myTag", "Security Exception, no location available")
        }
    }

    //define the listener
    private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            receivedLocation = LatLng(location.latitude, location.longitude)
            updateMapLocation()
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }

    private fun checkLocationPermissions() {
        when {
            context?.let {
                ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            } == PackageManager.PERMISSION_GRANTED -> {
                startLocationUpdates()
            }
            shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)
            -> {

            }
            else -> {
                requestPermissions(
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1
                )
                checkLocationPermissions()
            }
        }
    }
}