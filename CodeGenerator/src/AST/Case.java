package AST;

import java.io.BufferedWriter;
import java.io.IOException;

public class Case extends ASTNode {
    public Expression expression;
    public Statement statement;

    public Case(Expression expression, Statement statement) {
        this.expression = expression;
        this.statement = statement;
    }

    @Override
    public void translate(BufferedWriter out) throws IOException {
    	 String krajTekuceg = ASTNode.genLab();
    	 expression.translate(out);
    	 expression.genLoad("R1", out);
    	 
    	 out.newLine();
    	 out.write("Compare_Equal R1, 1");
    	 out.newLine();
    	 out.write("JumpIfZero R1, " + krajTekuceg);
    	 out.newLine();
    	 out.write("\tIMC<Statement>");
    	 statement.translate(out);
    	 out.write(krajTekuceg + ":");
    	 out.newLine();
    }


}
