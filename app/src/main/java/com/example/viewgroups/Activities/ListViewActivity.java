package com.example.viewgroups.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.viewgroups.Interfaces.MyClickListener;
import com.example.viewgroups.R;
import com.example.viewgroups.Models.Team;
import com.example.viewgroups.Adapters.TeamAdapter;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private ArrayList<Team> teamList = new ArrayList<>();
    private TeamAdapter teamAdapter;
    private ListView listView;
    private int counter = 1;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        displayNotice();
        setAdapter();
    }

    private void displayNotice() {
        new AlertDialog.Builder(this)
                .setTitle("Refresh")
                .setMessage("Please refresh your screen !!")
                .setPositiveButton("Ok", null)
                .show();
    }

    private void setAdapter() {
        teamAdapter = new TeamAdapter(this, teamList, new MyClickListener() {
            @Override
            public void onTextClick(int position) {
                String name = teamList.get(position).getTeamName();
                Toast.makeText(getApplicationContext(), "Selected Team is " + name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRankClick(int position) {
                String rank = teamList.get(position).getTeamRank();
                Toast.makeText(getApplicationContext(), "Selected Team Rank is " + rank, Toast.LENGTH_SHORT).show();
            }
        });
        listView.setAdapter(teamAdapter);
    }

    private void init() {
        listView = (ListView) findViewById(R.id.team_list);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);

        swipeRefreshLayout.setOnRefreshListener(this);
    }

    public void gotoWebView(View view) {
        Intent i = new Intent(this, WebViewActivity.class);
        startActivity(i);
    }

    @Override
    public void onRefresh() {
        /*switch (counter) {
            case 1:
                teamList.add(new Team("Australia", "1", R.drawable.aus));
                break;
            case 2:
                teamList.add(new Team("India", "2", R.drawable.ind));
                break;
            case 3:
                teamList.add(new Team("New Zealand", "3", R.drawable.nz));
                break;
            case 4:
                teamList.add(new Team("England", "4", R.drawable.eng));
                break;
            case 5:
                teamList.add(new Team("Pakistan", "5", R.drawable.pak));
                break;
            default:
                Toast.makeText(this, "No more data present !!", Toast.LENGTH_SHORT).show();
                break;
        }
        counter++;*/

        teamList.add(new Team("Australia", "1", R.drawable.aus));
        teamList.add(new Team("India", "2", R.drawable.ind));
        teamList.add(new Team("New Zealand", "3", R.drawable.nz));
        teamList.add(new Team("England", "4", R.drawable.eng));
        teamList.add(new Team("Pakistan", "5", R.drawable.pak));
        teamAdapter.notifyDataSetChanged();

        swipeRefreshLayout.setRefreshing(false);
    }
}
