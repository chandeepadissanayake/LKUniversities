package com.chanplusplus.lkuniversities.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GeoLocation(val latitude: Double, val longitude: Double) : Parcelable
