package com.example.caknorris.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.caknorris.R
import com.example.caknorris.model.Joke

class JokeAdapter(var jokes: MutableList<Joke>) : RecyclerView.Adapter<JokeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_joke, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val joke = jokes[position]

        val url = joke.url
        val uri = Uri.parse(url)
        val query = uri.pathSegments.last()

        holder.tvUrl.text = query // displays "mFYJgwKQQ_KFYZQr6eJTmg"

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                view.context.startActivity(intent)
            }
        }

        val spannableString = SpannableString(query)
        spannableString.setSpan(clickableSpan, 0, query.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        holder.tvUrl.text = spannableString
        holder.tvUrl.movementMethod = LinkMovementMethod.getInstance()


        holder.tvValue.text = joke.value
        if(joke.updatedAt != null) {
            holder.tvlastUpdate.text = "Last Update:" + " "+ joke.updatedAt
        }else{
            holder.tvlastUpdate.text = "Last Update:" + " " +"2024-June-13"
        }
        Glide.with(holder.itemView.context)
            .load(joke.iconUrl)
            .into(holder.iconImageView)
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iconImageView: ImageView = itemView.findViewById(R.id.iconImageView)
        val tvUrl: TextView = itemView.findViewById(R.id.urlTextView)
        val tvValue: TextView = itemView.findViewById(R.id.valueTextView)
        val tvlastUpdate: TextView = itemView.findViewById(R.id.lastUpdate)
    }
}
