package de.htw.student.decisionTree;

/**
 * An interface for an answer node.
 * <p/>
 * Created by s0542834 on 09.07.14.
 */
public interface IAnswerNode extends INode {

    /**
     * The answer that follows a final question.
     *
     * @return the answer String.
     */
    String getAnswer();
}
