package hm.tamby.kotrana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Adpter pour le BD
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViMyViewHolder> {

    Context context;
    ArrayList<Details> details;

    /**
     * @param context
     * @param details
     */
    public MyAdapter(Context context, ArrayList<Details> details) {
        this.context = context;
        this.details = details;
    }

    /**
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyViMyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViMyViewHolder(v);
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyViMyViewHolder holder, int position) {
        Details detail = details.get(position);
        holder.lastMessage.setText(detail.getLastMessage());
        holder.title.setText(detail.getTitle());
        holder.duree.setText(detail.getDuree());
    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {
        return details.size();
    }

    public static class MyViMyViewHolder extends RecyclerView.ViewHolder{

        TextView lastMessage, title, duree;

        public MyViMyViewHolder(@NonNull View itemView) {
            super(itemView);

            lastMessage = itemView.findViewById(R.id.titleA);
            title = itemView.findViewById(R.id.type);
            duree = itemView.findViewById(R.id.time);
        }
    }
}
