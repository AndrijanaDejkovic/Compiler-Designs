package AST;

public class LessEqualRelExp2 extends RelExpression{
	 public LessEqualRelExp2(Term left, Term right){
	        super(right);
	        this.right = right;
	    }

		protected String relOp(){
	        return "Compare_less_equal";
	    }	
}
