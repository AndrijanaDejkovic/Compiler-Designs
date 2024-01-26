package AST;

public class GreaterEqualRelExp extends RelExpression{
	 public GreaterEqualRelExp(Term left, Term right){
	        super(right);
	        this.right = right;
	    }

		protected String relOp(){
	        return "Compare_greater_equal";
	    }	
}
