package ir.hossein.footballPrediction.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "matches", schema = "footballpredictions")
public class MatchesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "Home_Team", nullable = true, length = 30)
    private String homeTeam;
    @Basic
    @Column(name = "Away_Team", nullable = true, length = 30)
    private String awayTeam;
    @Basic
    @Column(name = "home_goal", nullable = true)
    private Integer homeGoal;
    @Basic
    @Column(name = "away_goal", nullable = true)
    private Integer awayGoal;
    @Basic
    @Column(name = "status", nullable = true)
    private Byte status;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchesEntity that = (MatchesEntity) o;
        return id == that.id  && Objects.equals(homeTeam, that.homeTeam) && Objects.equals(awayTeam, that.awayTeam) && Objects.equals(homeGoal, that.homeGoal) && Objects.equals(awayGoal, that.awayGoal) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, homeTeam, awayTeam, homeGoal, awayGoal, status);
    }


}
