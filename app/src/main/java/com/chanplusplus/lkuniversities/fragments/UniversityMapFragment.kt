package com.chanplusplus.lkuniversities.fragments

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.chanplusplus.lkuniversities.R
import com.chanplusplus.lkuniversities.databinding.FragmentUniversityMapBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class UniversityMapFragment : Fragment() {

    private var _binding : FragmentUniversityMapBinding? = null
    private val binding: FragmentUniversityMapBinding
        get() = _binding!!

    val args: UniversityMapFragmentArgs by navArgs()

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
        val university = args.university

        val geoLocationUniversity = LatLng(university.geoLocation.latitude, university.geoLocation.longitude)
        googleMap.addMarker(MarkerOptions().position(geoLocationUniversity).title(university.name))
        googleMap.setMinZoomPreference(10.0f)
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(geoLocationUniversity))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUniversityMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.university_map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}