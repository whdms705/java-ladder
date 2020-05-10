package ladder.domain;


import java.util.List;

public class Climber {

    private final Users users;
    private final LadderGame ladderGame;

    private Climber(String userNames, int height, CrossRoadStrategy crossRule) {
        this.users = Users.of(userNames);
        LadderMap ladderMap =  LadderMap.of(users, height, crossRule);
        this.ladderGame = LadderGame.of(users, ladderMap);
    }

    public static Climber of(String userNames, int height, CrossRoadStrategy crossRule) {
        return new Climber(userNames, height, crossRule);
    }

    public LadderMap targetLadder() {
        return ladderGame.inquiryLadderMap();
    }

    public Reward offerPrize(String rewards) {
        return Reward.of(rewards, users.size());
    }

    public int climbByUser(String name) {
        return ladderGame.claimByUser(name);
    }

    public List<String> participantNames() {
        return users.participantNames();
    }

    public List<List<Boolean>> getLadderMapList(LadderMap ladderMap) {
        return ladderMap.getLadderMap();
    }

    public List<String> getRewards(Reward reward) {
        return reward.toList();
    }
}