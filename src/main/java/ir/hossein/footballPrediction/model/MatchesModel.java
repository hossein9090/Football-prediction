package ir.hossein.footballPrediction.model;



public class MatchesModel {

    private int id;
    private String homeTeam;
    private String awayTeam;
    private Integer homeGoal;
    private Integer awayGoal;
    private Byte status;

    public MatchesModel(int id, String homeTeam, String awayTeam, Integer homeGoal, Integer awayGoal, Byte status) {
        this.id = id;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoal = homeGoal;
        this.awayGoal = awayGoal;
        this.status = status;
    }

    public MatchesModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Integer getHomeGoal() {
        return homeGoal;
    }

    public void setHomeGoal(Integer homeGoal) {
        this.homeGoal = homeGoal;
    }

    public Integer getAwayGoal() {
        return awayGoal;
    }

    public void setAwayGoal(Integer awayGoal) {
        this.awayGoal = awayGoal;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
