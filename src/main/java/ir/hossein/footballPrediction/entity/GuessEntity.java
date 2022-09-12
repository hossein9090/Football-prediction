package ir.hossein.footballPrediction.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "guess", schema = "footballpredictions")
public class GuessEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "userId", nullable = true)
    private Integer userId;
    @Basic
    @Column(name = "matchId", nullable = true)
    private Integer matchId;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id",insertable = false,updatable = false)
    private Users usersByUserId;
    @ManyToOne
    @JoinColumn(name = "matchId", referencedColumnName = "id",insertable = false,updatable = false)
    private MatchesEntity matchesByMatchId;

    @Basic
    @Column(name = "guess_home_goal", nullable = false)
    private int guessHomeGoal;
    @Basic
    @Column(name = "guess_away_goal", nullable = false)
    private int guessAwayGoal;
    @Basic
    @Column(name = "score", nullable = true)
    private Integer score;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public int getGuessHomeGoal() {
        return guessHomeGoal;
    }

    public void setGuessHomeGoal(int guessHomeGoal) {
        this.guessHomeGoal = guessHomeGoal;
    }

    public int getGuessAwayGoal() {
        return guessAwayGoal;
    }

    public void setGuessAwayGoal(int guessAwayGoal) {
        this.guessAwayGoal = guessAwayGoal;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    public MatchesEntity getMatchesByMatchId() {
        return matchesByMatchId;
    }

    public void setMatchesByMatchId(MatchesEntity matchesByMatchId) {
        this.matchesByMatchId = matchesByMatchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuessEntity that = (GuessEntity) o;
        return id == that.id && guessHomeGoal == that.guessHomeGoal && guessAwayGoal == that.guessAwayGoal && Objects.equals(userId, that.userId) && Objects.equals(matchId, that.matchId) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, matchId, guessHomeGoal, guessAwayGoal, score);
    }

    public GuessEntity(int id, Integer userId, Integer matchId, Users usersByUserId, MatchesEntity matchesByMatchId, int guessHomeGoal, int guessAwayGoal, Integer score) {
        this.id = id;
        this.userId = userId;
        this.matchId = matchId;
        this.usersByUserId = usersByUserId;
        this.matchesByMatchId = matchesByMatchId;
        this.guessHomeGoal = guessHomeGoal;
        this.guessAwayGoal = guessAwayGoal;
        this.score = score;
    }
    public GuessEntity() {
    }
}
