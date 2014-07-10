package de.htw.student.decisionTree;

import javax.xml.soap.Node;

/**
 * A node that represents a final answer.
 * <p/>
 * Created by s0542834 on 09.07.14.
 */
public class AnswerNode implements IAnswerNode {

    private String answer;

    /**
     * Constructor.
     *
     * @param answer the answer the node contains
     */
    public AnswerNode(String answer) {
        this.answer = answer;
    }

    @Override
    public String getAnswer() {
        return this.answer;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.ANSWER;
    }
}
