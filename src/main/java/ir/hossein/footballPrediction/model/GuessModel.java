package ir.hossein.footballPrediction.model;


public class GuessModel {

    private int id;
    private Integer userId;
    private Integer matchId;
    private Integer guessHomeGoal;
    private Integer guessAwayGoal;
    private Integer score;

    public GuessModel(int id, Integer userId, Integer matchId, Integer guessHomeGoal, Integer guessAwayGoal, Integer score) {
        this.id = id;
        this.userId = userId;
        this.matchId = matchId;
        this.guessHomeGoal = guessHomeGoal;
        this.guessAwayGoal = guessAwayGoal;
        this.score = score;
    }

    public GuessModel( Integer userId, Integer matchId) {
        this.userId = userId;
        this.matchId = matchId;
    }

    public GuessModel() {
    }

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

    public Integer getGuessHomeGoal() {
        return guessHomeGoal;
    }

    public void setGuessHomeGoal(Integer guessHomeGoal) {
        this.guessHomeGoal = guessHomeGoal;
    }

    public Integer getGuessAwayGoal() {
        return guessAwayGoal;
    }

    public void setGuessAwayGoal(Integer guessAwayGoal) {
        this.guessAwayGoal = guessAwayGoal;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
