package com.example.viewgroups.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viewgroups.Interfaces.MyClickListener;
import com.example.viewgroups.Models.Team;
import com.example.viewgroups.R;

import java.util.ArrayList;

public class TeamAdapter extends ArrayAdapter<Team> {
    Context context;
    private MyClickListener myClickListener=null;
    public TeamAdapter(Context context, ArrayList<Team> teams, MyClickListener listener) {
        super(context, 0, teams);
        this.context = context;
        myClickListener = listener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return init(position, convertView, parent);
    }

    private View init(int position, View convertView, final ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list, parent, false);
        }

        ImageView teamLogo = (ImageView) convertView.findViewById(R.id.logo);
        TextView teamName = (TextView) convertView.findViewById(R.id.team_name);
        TextView teamRank = (TextView) convertView.findViewById(R.id.team_rank);

        teamName.setTag(position);
        teamRank.setTag(position);

        teamName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myClickListener != null){
                    myClickListener.onTextClick((Integer) view.getTag());
                }
            }
        });

        teamRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myClickListener != null){
                    myClickListener.onRankClick((Integer) view.getTag());
                }
            }
        });

        Team currentTeam = getItem(position);

        if(currentTeam != null){
            teamLogo.setImageResource(currentTeam.getLogo());
            teamName.setText(currentTeam.getTeamName());
            teamRank.setText(currentTeam.getTeamRank());
        }

        return convertView;

    }

}
