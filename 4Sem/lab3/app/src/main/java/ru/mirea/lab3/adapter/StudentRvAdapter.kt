package ru.mirea.lab3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.item_student.view.*
import ru.mirea.lab3.R
import ru.mirea.lab3.model.Student
import ru.mirea.lab3.repos.StudentRepo

class StudentRvAdapter(private val repository: StudentRepo) : RecyclerView.Adapter<StudentRvAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentViewHolder {
        return StudentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false))
    }

    override fun onBindViewHolder(
        holder: StudentViewHolder,
        position: Int
    ) {
        val student: Student = repository.students[position]
        holder.addingDate.text = student.addingDate
        holder.fullName.text = student.fullName
    }

    override fun getItemCount(): Int = repository.students.size


    inner class StudentViewHolder(view: View) : ViewHolder(view) {
        val fullName: AppCompatTextView = view.fullName
        val addingDate: AppCompatTextView = view.addingDate
    }

}
