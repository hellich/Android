package fr.sio.ecp.federatedbirds.app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fr.sio.ecp.federatedbirds.R;
import fr.sio.ecp.federatedbirds.model.Message;

/**
 * Created by Michaël on 24/11/2015.
 */
public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessageViewHolder> {

    private List<Message> mMessages;

    @Override
    public int getItemCount() {
        return mMessages != null ? mMessages.size() : 0;
    }

    public void setMessages(List<Message> messages) {
        mMessages = messages;
        notifyDataSetChanged();
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new MessageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        Message message = mMessages.get(position);
        //holder.mUserAvatarView.setImageDrawable();
        //message.user.avatar;
        holder.mTextView.setText(message.text);
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {

        private ImageView mUserAvatarView;
        private TextView mTextView;

        public MessageViewHolder(View itemView) {
            super(itemView);
            mUserAvatarView = (ImageView) itemView.findViewById(R.id.avatar);
            mTextView = (TextView) itemView.findViewById(R.id.text);
        }

    }

}