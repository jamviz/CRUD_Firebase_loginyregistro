package com.example.parcial_jamir_balcona;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private Context context;
    private List<HelperClass> userList;
    private OnItemClickListener listener;

    public UserListAdapter(Context context, List<HelperClass> userList, OnItemClickListener listener) {
        this.context = context;
        this.userList = userList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_list_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        HelperClass user = userList.get(position);
        holder.bind(user, listener);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView phoneTextView;
        private TextView bioTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.list_item_name);
            phoneTextView = itemView.findViewById(R.id.list_item_phone);
            bioTextView = itemView.findViewById(R.id.list_item_bio);
        }

        public void bind(final HelperClass user, final OnItemClickListener listener) {
            nameTextView.setText(user.getName());
            phoneTextView.setText(user.getDNI());
            bioTextView.setText(user.getNacimiento());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(user);
                }
            });
        }
    }

    // Interfaz para manejar el evento de clic en un usuario de la lista.
    public interface OnItemClickListener {
        void onItemClick(HelperClass user);
    }
}

