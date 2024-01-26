package AST;

public class NotEqualRelExp extends RelExpression{
	 public NotEqualRelExp(Term left, Term right){
	        super(right);
	        this.right = right;
	    }

		protected String relOp(){
	        return "Compare_not_equal";
	    }	
}
