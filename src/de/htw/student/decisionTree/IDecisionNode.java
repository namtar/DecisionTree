package de.htw.student.decisionTree;

import java.util.Set;

/**
 * An interfacde for a decision node.
 * <p/>
 * Created by s0542834 on 09.07.14.
 */
public interface IDecisionNode extends INode {

    /**
     * Returns the description of the node.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Returns a set of descisions the node is capable of.
     *
     * @return a set of {@link de.htw.student.decisionTree.Decision}
     */
    Set<Decision> getDecisions();
}
