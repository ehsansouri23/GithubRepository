package ir.souri.githubrepository.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.souri.domain.search.Repository
import ir.souri.githubrepository.R

class RepositoryItemView(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    private val repositoryName: TextView = itemView.findViewById(R.id.repoName)
    private val repositoryOwner: TextView = itemView.findViewById(R.id.owner)
    private val ownerAvatar: ImageView = itemView.findViewById(R.id.ownerAvatar)

    fun bind(repository: Repository) {
        with(repository) {
            repositoryName.text = name
            repositoryOwner.text = owner.avatarUrl
        }
    }
}