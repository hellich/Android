package fr.sio.ecp.federatedbirds.app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.sio.ecp.federatedbirds.R;
import fr.sio.ecp.federatedbirds.model.Message;

/**
 * Created by Michaël on 24/11/2015.
 */
public class MessagesForUserDetailAdapter extends RecyclerView.Adapter<MessagesForUserDetailAdapter.MessageViewHolder> {

    private List<Message> mMessages;

    public void setMessages(List<Message> messages) {
        mMessages = messages;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mMessages != null ? mMessages.size() : 0;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item_noavatar, parent, false);
        return new MessageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        final Message message = mMessages.get(position);
        /*Picasso.with(holder.mUserAvatarView.getContext())
                .load(message.user.avatar)
                .into(holder.mUserAvatarView);
        */
        holder.mTextView.setText(message.text);

        /*holder.mUserAvatarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), UserDetailsActivity.class);
                i.putExtra("userId", message.user.id);
                i.putExtra("userAvatar", message.user.avatar);
                i.putExtra("username", message.user.login);
                i.putExtra("userEmail", message.user.email);
                v.getContext().startActivity(i);
            }
        });*/
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {

        //private ImageView mUserAvatarView;
        private TextView mTextView;

        public MessageViewHolder(View itemView) {
            super(itemView);
            //mUserAvatarView = (ImageView) itemView.findViewById(R.id.avatar);
            mTextView = (TextView) itemView.findViewById(R.id.text_message);
        }

    }

}