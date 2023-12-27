package Paket;
import java.util.Hashtable;
public class KWTable {

	private Hashtable mTable;
	public KWTable()
	{
		// Inicijalizcaija hash tabele koja pamti kljucne reci
		mTable = new Hashtable();
		mTable.put("program", new Integer(sym.PROGRAM));
		mTable.put("integer", new Integer(sym.INTEGER));
		mTable.put("char", new Integer(sym.CHAR));
		mTable.put("begin", new Integer(sym.BEGIN));
		mTable.put("end", new Integer(sym.END));
		mTable.put("real", new Integer(sym.REAL));
		mTable.put("boolean", new Integer(sym.BOOLEAN));
		//mTable.put("ε", new Integer(sym.LAMBDA));
		mTable.put("select", new Integer(sym.SELECT));
		mTable.put("and", new Integer(sym.AND));
		mTable.put("or", new Integer(sym.OR));
		mTable.put("equal", new Integer(sym.EQUAL));
		mTable.put("noteq", new Integer(sym.NOTEQ));
		mTable.put("greater", new Integer(sym.GREATER));
		mTable.put("greateroreq", new Integer(sym.GREATEROREQ));
		mTable.put("lambda", new Integer(sym.LAMBDA));
		mTable.put("less", new Integer(sym.LESS));
		mTable.put("lessoreq", new Integer(sym.LESSOREQ));


	}
	
	/**
	 * Vraca ID kljucne reci 
	 */
	public int find(String keyword)
	{
		Object symbol = mTable.get(keyword);
		if (symbol != null)
			return ((Integer)symbol).intValue();
		
		// Ako rec nije pronadjena u tabeli kljucnih reci radi se o identifikatoru
		return sym.ID;
	}
	

}
