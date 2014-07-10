package de.htw.student.decisionTree;

/**
 * A class that represents a decision that knows its question and the corresponding following node,.
 * <p/>
 * Created by s0542834 on 09.07.14.
 */
public class Decision {

    private INode follower;
    private String question;
    private String actionOrder;

    /**
     * Constructor.
     *
     * @param follower    the follower if the question has been chosen.
     * @param question    the question to ask the user for
     * @param actionOrder an optional action order
     */
    public Decision(INode follower, String question, String actionOrder) {
        this.follower = follower;
        this.question = question;
        this.actionOrder = actionOrder;
    }

    public INode getFollower() {
        return follower;
    }

    public void setFollower(INode follower) {
        this.follower = follower;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getActionOrder() {
        return actionOrder;
    }

    public void setActionOrder(String actionOrder) {
        this.actionOrder = actionOrder;
    }

    @Override
    public String toString() {
        return "Decision{" +
                "follower=" + follower +
                ", question='" + question + '\'' +
                ", actionOrder='" + actionOrder + '\'' +
                '}';
    }

}
