package io.iqube.kctgrad;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class ParticipantsRecyclerViewAdapter extends RecyclerView.Adapter<ParticipantsRecyclerViewAdapter.MyViewHolder> {
    private List<ParticipantsContent> content_list;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView participant_name,project_name;
        public ImageButton rating1,rating2,rating3,rating4,rating5;


        public MyViewHolder(View view) {
            super(view);
            participant_name= (TextView) view.findViewById(R.id.participant_name);
            project_name = (TextView) view.findViewById(R.id.project_name);
            rating1 = (ImageButton) view.findViewById(R.id.rating1);
            rating2 = (ImageButton) view.findViewById(R.id.rating2);
            rating3 = (ImageButton) view.findViewById(R.id.rating3);
            rating4 = (ImageButton) view.findViewById(R.id.rating4);
            rating5 = (ImageButton) view.findViewById(R.id.rating5);
        }
    }
    public ParticipantsRecyclerViewAdapter(List<ParticipantsContent> moviesList){
        this.content_list=moviesList;
    }
    @Override
    public ParticipantsRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_layout,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final ParticipantsContent content = content_list.get(position);
        holder.project_name.setText(content.getProjectName());
        holder.participant_name.setText(content.getParticipantName());

    }

    @Override
    public int getItemCount() {
        return content_list.size();
    }
}
