package de.htw.student.decisionTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * The controller for the program flow.
 * <p/>
 * Created by s0542834 on 09.07.14.
 */
public class FlowController {

    private final INode basicNode;
    private INode actualState = null;

    /**
     * Constructor.
     */
    public FlowController() {

        basicNode = DecisionConfigurator.configure();

        boolean done = false;
        while (!done) {
            flow();
            System.out.println();
            System.out.print("Nochmal? 1 für Ja, 0 für Nein: ");
            Scanner scanner = new Scanner(System.in);
            Integer input = scanner.nextInt();
            if (input == 0) {
                done = true;
            }
        }

    }

    private void flow() {
        actualState = basicNode;

        boolean done = false;
        while (!done) {

            if (actualState.getNodeType() == NodeType.DESCISION) {
                DecisionNode decisionNode = (DecisionNode) actualState;

                System.out.println("Beschreibung:");
                System.out.println();
                System.out.println(decisionNode.getDescription());
                // print out decisions
                System.out.println();
                System.out.println("Entscheidungen");
                Map<Integer, Decision> decisionForInt = new HashMap<Integer, Decision>();
                int i = 0;
                for (Decision decision : decisionNode.getDecisions()) {
                    decisionForInt.put(i, decision);
                    System.out.println(i + " für " + decision.getQuestion());
                    i++;
                }
                System.out.println(i + " für zurücksetzen zu Start");
                Integer choice = getUserInput(decisionForInt.keySet());
                if (choice == i) {
                    actualState = basicNode;
                    System.out.println("Prozess wurde auf Anfang zurückgesetzt.");
                    System.out.println();
                } else {
                    Decision chosenDecision = decisionForInt.get(choice);
                    if (chosenDecision.getActionOrder() != null) {
                        System.out.println("Handlungsanweisung: ");
                        System.out.println();
                        System.out.println(chosenDecision.getActionOrder());
                    }
                    if (chosenDecision.getFollower() != null) {
                        actualState = chosenDecision.getFollower();
                    } else {
                        done = true;
                    }

                    System.out.println();
                    System.out.println("-----------------------------");
                    System.out.println();
                }

            } else {
                AnswerNode answerNode = (AnswerNode) actualState;
                System.out.println("Ende: ");
                System.out.println();
                System.out.println(answerNode.getAnswer());
                done = true;
            }

        }
    }

    private Integer getUserInput(Set<Integer> possibleOptions) {

        System.out.print("Choose: ");
        // we assume that the input is correct.
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
