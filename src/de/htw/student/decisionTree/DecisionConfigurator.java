package de.htw.student.decisionTree;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A static class that configures the whole tree.
 * <p/>
 * Created by s0542834 on 09.07.14.
 */
public final class DecisionConfigurator {

    private static final String DESCRIPTION_1 = "Veränderung der Symptome oder Befunde Viren-verdächtiges Herzgeräusch....";
    private static final String DESCRIPTION_2 = "Hochrisikopatient.";
    private static final String DESCRIPTION_3 = "Vor Beginn eines Fitnessprogramms.";
    private static final String DESCRIPTION_4 = "Kontraindikation für eine Streßuntersuchung";
    private static final String DESCRIPTION_5 = "WPW-Syndrom, VVI, DDD-Stimulation...";
    private static final String DESCRIPTION_6 = "Ist der Patient körperlich belastbar?";
    private static final String DESCRIPTION_7 = "Ergometrie durchführen. Ausbelastet (85% der alterskorrigierten Herzfrequenz?";
    private static final String DESCRIPTION_8 = "Auswertung der Ergometrie";
    private static final String DESCRIPTION_9 = "Bildgebendes Verfahren";
    private static final String DESCRIPTION_10 = "Bildgebendes Verfahren mit pharmakologischer Belastung";

    private static final String ANSWER_1 = "Echokardiographie + ggf Holter-EKG.";
    private static final String ANSWER_2 = "EF < 40% + nsVT....";
    private static final String ANSWER_3 = "Risikostratifizierung und ein regelmäßiges Monitoring ...";
    private static final String ANSWER_4 = "Keine Indikation für Belastungsuntersuchung";
    private static final String ANSWER_5 = "Ggf Kononarangiographie...";
    private static final String ANSWER_9 = "Indikation zur LHK Diagnostik und ggf PCI, Bypass-Op";


    //    private static final String ANSWER_6 = "Ergometrie durchführen.";

    /**
     * We do not need any instance for this.
     */
    private DecisionConfigurator() {
    }

    /**
     * Returns the start node that contains the references to the next nodes depending on the decisions.
     *
     * @return the base {@link DecisionNode}
     */
    public static INode configure() {

        Set<Decision> baseDecisions = new LinkedHashSet<Decision>();
        Set<Decision> highRiskPatientDecisions = new LinkedHashSet<Decision>();
        Set<Decision> praeFitnesDecisions = new LinkedHashSet<Decision>();
        Set<Decision> kontradikationStresstestDecisions = new LinkedHashSet<Decision>();
        Set<Decision> wpwSyndromDecisions = new LinkedHashSet<Decision>();
        Set<Decision> koeBelastbarDecisions = new LinkedHashSet<Decision>();
        Set<Decision> ausbelastetDecisions = new LinkedHashSet<Decision>();
        Set<Decision> auswertErgometrieDecisions = new LinkedHashSet<Decision>();
        Set<Decision> bildgVerfahrenDecisions = new LinkedHashSet<Decision>();
        Set<Decision> bildgVerfahrenMPharmDecisions = new LinkedHashSet<Decision>();

        // create decision nodes
        INode baseNode = new DecisionNode(DESCRIPTION_1, baseDecisions);
        INode highRiskPatientNode = new DecisionNode(DESCRIPTION_2, highRiskPatientDecisions);
        INode praeFitnessNode = new DecisionNode(DESCRIPTION_3, praeFitnesDecisions);
        INode kontradikationStresstestNode = new DecisionNode(DESCRIPTION_4, kontradikationStresstestDecisions);
        INode wpwSyndromNode = new DecisionNode(DESCRIPTION_5, wpwSyndromDecisions);
        INode koeBelastbarNode = new DecisionNode(DESCRIPTION_6, koeBelastbarDecisions);
        INode ausbelastedNode = new DecisionNode(DESCRIPTION_7, ausbelastetDecisions);
        INode auswertErgometrieNode = new DecisionNode(DESCRIPTION_8, auswertErgometrieDecisions);
        INode bildgVerfahrenNode = new DecisionNode(DESCRIPTION_9, bildgVerfahrenDecisions);
        INode bildgVerfahrenMPharmNode = new DecisionNode(DESCRIPTION_10, bildgVerfahrenMPharmDecisions);

        // create answer nodes
        INode firstAnswerNode = new AnswerNode(ANSWER_1);
        INode secondAnswerNode = new AnswerNode(ANSWER_2);
        INode thirdAnswerNode = new AnswerNode(ANSWER_3);
        INode fourthAnswerNode = new AnswerNode(ANSWER_4);
        INode fifthAnswerNode = new AnswerNode(ANSWER_5);
//        INode sixthAnswerNode = new AnswerNode(ANSWER_6);
//        INode seventhAnswerNode = new AnswerNode(ANSWER_7);
        INode ninthAnswerNode = new AnswerNode(ANSWER_9);

        // finally add the decisions
        baseDecisions.add(new Decision(highRiskPatientNode, "Nein", null));
        baseDecisions.add(new Decision(kontradikationStresstestNode, "Ja", "Echokardiographie + ggf Holter-EKG, EF < 40%..."));
//        baseDecisions.add(new Decision(firstAnswerNode, "Ja Echo Kardio", null));

        highRiskPatientDecisions.add(new Decision(praeFitnessNode, "Nein", null));
        highRiskPatientDecisions.add(new Decision(thirdAnswerNode, "Ja", null));

        praeFitnesDecisions.add(new Decision(fourthAnswerNode, "Nein", null));
        praeFitnesDecisions.add(new Decision(thirdAnswerNode, "Ja", null));

        kontradikationStresstestDecisions.add(new Decision(wpwSyndromNode, "Nein", null));
        kontradikationStresstestDecisions.add(new Decision(fifthAnswerNode, "Ja", null));

        wpwSyndromDecisions.add(new Decision(koeBelastbarNode, "Nein", null));
        wpwSyndromDecisions.add(new Decision(bildgVerfahrenNode, "Ja", null));

        bildgVerfahrenDecisions.add(new Decision(ninthAnswerNode, "falls pathologisch", null));
        bildgVerfahrenDecisions.add(new Decision(null, "Ende", null));

        koeBelastbarDecisions.add(new Decision(bildgVerfahrenMPharmNode, "Nein", null));
        koeBelastbarDecisions.add(new Decision(ausbelastedNode, "Ja", null));

        bildgVerfahrenMPharmDecisions.add(new Decision(ninthAnswerNode, "falls pathologisch", null));
        bildgVerfahrenMPharmDecisions.add(new Decision(null, "Ende", null));

        ausbelastetDecisions.add(new Decision(bildgVerfahrenMPharmNode, "Nein", null));
        ausbelastetDecisions.add(new Decision(auswertErgometrieNode, "Ja", null));

        auswertErgometrieDecisions.add(new Decision(bildgVerfahrenNode, "fraglicher Befund", null));
        auswertErgometrieDecisions.add(new Decision(ninthAnswerNode, "falls pathologisch", null));

        return baseNode;
    }
}
