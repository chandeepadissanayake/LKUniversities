package com.chanplusplus.lkuniversities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.chanplusplus.lkuniversities.R
import com.chanplusplus.lkuniversities.fragments.UniversitiesListFragmentDirections
import com.chanplusplus.lkuniversities.models.University

class UniversitiesAdapter(private val universities : List<University>) : RecyclerView.Adapter<UniversitiesAdapter.UniversityViewHolder>() {

    class UniversityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewCover: ImageView = view.findViewById(R.id.imageview_element_universities_cover)
        val textViewName: TextView = view.findViewById(R.id.textview_element_universities_name)
        val textViewLocation: TextView = view.findViewById(R.id.textview_element_universities_location)
        val textViewDescription: TextView = view.findViewById(R.id.textview_element_universities_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        val universityView = LayoutInflater.from(parent.context).inflate(R.layout.view_universities_list_element, parent, false)
        val universityViewHolder = UniversityViewHolder(universityView)

        universityViewHolder.itemView.setOnClickListener { view ->
            val universityIdx = universityViewHolder.adapterPosition
            val university = universities[universityIdx]

            val actionNavigateToUniversityMapFragment = UniversitiesListFragmentDirections.actionNavFromUniversitiesListToUniversityMap(university)
            val navController = view.findNavController()
            navController.navigate(actionNavigateToUniversityMapFragment)
        }

        return universityViewHolder
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        val university = universities[position]

        holder.imageViewCover.load(university.imageURL)
        holder.textViewName.text = university.name
        holder.textViewLocation.text = university.locationTitle
        holder.textViewDescription.text = university.description
    }

    override fun getItemCount(): Int {
        return universities.size
    }

}