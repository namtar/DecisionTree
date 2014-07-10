package de.htw.student.decisionTree;

import java.util.Set;

/**
 * A simple configurable decision tree node.
 * <p/>
 * Created by s0542834 on 09.07.14.
 */
public class DecisionNode implements IDecisionNode {

    private String description;

    private Set<Decision> decisions;

    /**
     * Constructor.
     *
     * @param description the description of the node
     * @param descisions  a set of possible {@link de.htw.student.decisionTree.Decision}
     */
    public DecisionNode(String description, Set<Decision> descisions) {
        this.description = description;
        this.decisions = descisions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Decision> getDecisions() {
        return decisions;
    }

    public void setDecisions(Set<Decision> decisions) {
        this.decisions = decisions;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.DESCISION;
    }

    @Override
    public String toString() {
        return "DecisionNode{" +
                "description='" + description + '\'' +
                ", decisions=" + decisions +
                '}';
    }
}
