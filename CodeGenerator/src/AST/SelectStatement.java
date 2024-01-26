package AST;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SelectStatement extends Statement {
	public ArrayList<Case> caseList;

    public SelectStatement(ArrayList<Case> caseList) {
        this.caseList = new ArrayList<>(caseList);
    }

    @Override
    public void translate(BufferedWriter out) throws IOException {

        for (Case caseNode : caseList) {
            caseNode.translate(out);
        }

    }
}
