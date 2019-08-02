package com.example.viewgroups.Models;

public class Team {
    private String teamName,teamRank;
    private int logo;

    public Team(String teamName, String teamRank, int logo) {
        this.teamName = teamName;
        this.teamRank = teamRank;
        this.logo = logo;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamRank() {
        return teamRank;
    }

    public void setTeamRank(String teamRank) {
        this.teamRank = teamRank;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
