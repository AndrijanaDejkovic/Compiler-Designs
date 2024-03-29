package AST;

import java.io.BufferedWriter;
import java.io.IOException;

public class AndExpression 
	extends Term {
		protected Term left;
		protected Term right;

		public AndExpression(Term right){
			this.right=right;
			this.left=null;
		}
		
		protected String opCode(){
			return "and";
		}
		
		public void translate(BufferedWriter out)
		throws IOException
		{
			right.translate(out);
			right.genLoad( "R2", out );
			this.result = ASTNode.genVar();

			if(left != null){
				left.translate(out);
				left.genLoad( "R1", out );
				out.write( "\t" + opCode() + "\t\tR1, R2" );
				out.newLine();
				out.write( "\tStore\t\tR1, " + this.result );
			}else
			out.write( "\tStore\t\tR2, " + this.result );
			out.newLine();
		}	
}
