package com.shadowos.AgriBuddy.ChatFunction

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shadowos.agrifarm.R
//import com.codepalace.chatbot.R
import com.shadowos.AgriBuddy.ChatFunction.Data.Message
//import com.codepalace.chatbot.data.Message
import com.shadowos.AgriBuddy.ChatFunction.utils.Constants.RECEIVE_ID
//import com.codepalace.chatbot.utils.Constants.RECEIVE_ID
import com.shadowos.AgriBuddy.ChatFunction.utils.Constants.SEND_ID
import kotlinx.android.synthetic.main.message_item.view.*
import java.util.*

class MessagingAdapter: RecyclerView.Adapter<MessagingAdapter.MessageViewHolder>(){

    var messagesList = mutableListOf<Message>()
    private lateinit  var tts: TextToSpeech

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            var a : String = "ad"
//            itemView.setOnClickListener {

//                var msg : Message = messagesList.get(adapterPosition);
//                var textToBeRead: String = msg.message;
//                Log.d("tag912", "extracted text to be spoken")
//                tts = TextToSpeech(itemView.context, this);
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    Log.d("tag912", "going to speak: $textToBeRead")
//                    tts.speak(textToBeRead, TextToSpeech.QUEUE_FLUSH, null, "")
//                };



                //Remove message on the item clicked
//                messagesList.removeAt(adapterPosition)
//                notifyItemRemoved(adapterPosition)
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return messagesList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMessage = messagesList[position]

        when (currentMessage.id) {
            SEND_ID -> {
                holder.itemView.tv_message.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_bot_message.visibility = View.GONE
            }
            RECEIVE_ID -> {
                holder.itemView.tv_bot_message.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_message.visibility = View.GONE
            }
        }
    }

    fun insertMessage(message: Message) {
        this.messagesList.add(message)
        notifyItemInserted(messagesList.size)
    }


}