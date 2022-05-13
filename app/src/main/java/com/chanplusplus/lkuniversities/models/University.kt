package com.chanplusplus.lkuniversities.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class University(val name: String, val locationTitle: String, val description: String, val geoLocation: GeoLocation, val imageURL: String) : Parcelable
