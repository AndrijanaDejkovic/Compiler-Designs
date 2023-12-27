package Paket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class SyntaxTable {

  public final static int SELECTSTATEMENT_PRIME = 100;
  public final static int SELECTSTATEMENT = 101;
  public final static int STATEMENT = 102;
  public final static int CASE = 103;
  public final static int CASELIST = 104;

  private static ArrayList<HashMap<Integer, String>> _syntaxTable;
  private static ArrayList<Rule> _rules;

  public SyntaxTable() {
  }

  public static List<HashMap<Integer, String>> getSyntaxTable() {
    if (_syntaxTable == null)
      _syntaxTable = new ArrayList<HashMap<Integer, String>>() {
        {
          // #0
          add(new HashMap<Integer, String>() {
            {
              put(sym.SELECT, "sk 2");
              put(SELECTSTATEMENT, "1");
            }
          });
          // #1
          add(new HashMap<Integer, String>() {
            {
              put(sym.EOF, "acc");
            }
          });
          // #2
          add(new HashMap<Integer, String>() {
            {
              put(sym.BEGIN, "sk 3");
            }
          });
          // #3
          add(new HashMap<Integer, String>() {
            {
              put(sym.CASE, "sk 7");
              put(CASELIST, "4");
              put(CASE, "6");
            }
          });
          // #4
          add(new HashMap<Integer, String>() {
            {
              put(sym.END, "sk 5");
              put(sym.CASE, "sk 7");
              put(CASE, "11");
            }
          });
          // #5
          add(new HashMap<Integer, String>() {
            {
              put(sym.END, "rk 1");
              put(sym.CASE, "rk 1");
              put(sym.EOF, "rk 1");
            }
          });
          // #6
          add(new HashMap<Integer, String>() {
            {
              put(sym.END, "rk 3");
              put(sym.CASE, "rk 3");
            }
          });
          // #7
          add(new HashMap<Integer, String>() {
            {
              put(sym.ID, "sk 8");
            }
          });
          // #8
          add(new HashMap<Integer, String>() {
            {
              put(sym.LAMBDA, "sk 9");
            }
          });
          // #9
          add(new HashMap<Integer, String>() {
            {
              put(sym.SELECT, "sk 2");
              put(sym.ID, "sk 13");
              put(SELECTSTATEMENT, "12");
              put(STATEMENT, "10");
            }
          });
          // #10
          add(new HashMap<Integer, String>() {
            {
              put(sym.END, "rk 4");
              put(sym.CASE, "rk 4");
            }
          });
          // #11
          add(new HashMap<Integer, String>() {
            {
                put(sym.END, "rk 2");
                put(sym.CASE, "rk 2");
            }
          });
          // #12
          add(new HashMap<Integer, String>() {
            {
                put(sym.END, "rk 5");
                put(sym.CASE, "rk 5");
            }
          });
          // #13
          add(new HashMap<Integer, String>() {
            {
              put(sym.ASSIGN, "sk 14");
            }
          });
          // #14
          add(new HashMap<Integer, String>() {
            {
                put(sym.ID, "sk 15");
                put(sym.CONST, "sk 17");
            }
          });
          // #15
          add(new HashMap<Integer, String>() {
            {
              put(sym.SEMICOLON, "sk 16");
            }
          });
          // #16
          add(new HashMap<Integer, String>() {
            {
                put(sym.END, "rk 6");
                put(sym.CASE, "rk 6");
            }
          });
          // #17
          add(new HashMap<Integer, String>() {
            {
              put(sym.SEMICOLON, "sk 18");
            }
          });
          // #18
          add(new HashMap<Integer, String>() {
            {
                put(sym.END, "rk 7");
                put(sym.CASE, "rk 7");
            }
          });
        }
      };

    return _syntaxTable;
  }

  public static List<Rule> getRules() {
    if (_rules == null)
      _rules = new ArrayList<Rule>() {
        {
          // #0
          add(new Rule(SyntaxTable.SELECTSTATEMENT_PRIME, new LinkedList<Integer>() {
            {
              add(SyntaxTable.SELECTSTATEMENT);
            }
          }));
          // #1
          add(new Rule(SyntaxTable.SELECTSTATEMENT, new LinkedList<Integer>() {
            {
              add(sym.SELECT);
              add(sym.BEGIN);
              add(SyntaxTable.CASELIST);
              add(sym.END);
            }
          }));
          // #2
          add(new Rule(SyntaxTable.CASELIST, new LinkedList<Integer>() {
            {
              add(SyntaxTable.CASELIST);
              add(SyntaxTable.CASE);
            }
          }));
          // #3
          add(new Rule(SyntaxTable.CASELIST, new LinkedList<Integer>() {
            {
              add(SyntaxTable.CASE);
            }
          }));
          // #4
          add(new Rule(SyntaxTable.CASE, new LinkedList<Integer>() {
            {
              add(sym.CASE);
              add(sym.ID);
              add(sym.LAMBDA);
              add(SyntaxTable.STATEMENT);
            }
          }));
          // #5
          add(new Rule(SyntaxTable.STATEMENT, new LinkedList<Integer>() {
            {
              add(SyntaxTable.SELECTSTATEMENT);
            }
          }));
          // #6
          add(new Rule(SyntaxTable.STATEMENT, new LinkedList<Integer>() {
            {
              add(sym.ID);
              add(sym.ASSIGN);
              add(sym.ID);
              add(sym.SEMICOLON);
            }
          }));
          // #7
          add(new Rule(SyntaxTable.STATEMENT, new LinkedList<Integer>() {
            {
                add(sym.ID);
                add(sym.ASSIGN);
                add(sym.CONST);
                add(sym.SEMICOLON);
            }
          }));
        }
      };

    return _rules;
  }
}