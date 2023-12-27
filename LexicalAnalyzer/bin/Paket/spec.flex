// import sekcija

%%

// sekcija opcija i deklaracija
%class MPLexer
%function next_token
%type Yytoken
%line
%column
%debug



%eofval{
 return new Symbol( sym.EOF );
%eofval}

%{
    public int getLine()
    {
        return yyline;
    }
%}

//stanja
%xstate KOMENTAR
//makroi
slovo = [a-zA-Z]
cifra = [0-9]
hexCifra = [0-9a-fA-F]
octCifra = [0-7]

%%

// pravila
\|\* { yybegin( KOMENTAR ); }
<KOMENTAR>~"*|" { yybegin( YYINITIAL ); }

[\t\n\r ] { ; }
\( { return new Symbol( sym.LEFTPAR ); }
\) { return new Symbol( sym.RIGHTPAR ); }

//operatori
\< { return new Symbol( sym.LESS ); }
\<= { return new Symbol( sym.LESSOREQ); }
== { return new Symbol( sym.EQUAL); }
\<> { return new Symbol( sym.NOTEQ); }
\> { return new Symbol( sym.GREATER); }
\>= { return new Symbol( sym.GREATEROREQ); }
\=> { return new Symbol( sym.LAMBDA); }
:= { return new Symbol( sym.ASSIGN ); }
//separatori
\. { return new Symbol( sym.DOT); }
: { return new Symbol( sym.COLON ); }
; { return new Symbol( sym.SEMICOLON ); }
, { return new Symbol( sym.COMMA ); }

//kljucne reci
"program"                       {   return new Symbol( sym.PROGRAM );    }
"begin"                         {   return new Symbol( sym.BEGIN );      }
"end"                           {   return new Symbol( sym.END ); }
"ε"                             {   return new Symbol( sym.ε );   }
"integer"                       {   return new Symbol( sym.INTEGER );               }
"real"                          {   return new Symbol( sym.REAL );            }
"char"                          {   return new Symbol( sym.CHAR );            }
"boolean"                       {   return new Symbol( sym.BOOLEAN );              }
"select"                        {   return new Symbol( sym.SELECT );              }
"case"                          {   return new Symbol( sym.CASE );            }
"const"                         {   return new Symbol( sym.CONST);              }
"and"                          {   return new Symbol( sym.AND);            }
"or"                         {   return new Symbol( sym.OR);              }

{slovo}+ { return getKW(); }
//identifikatori
({slovo}|\$)({slovo}|{cifra}|\$)* { return new Symbol(sym.ID, yytext(),yyline, yycolumn ); }
//konstante
(0x){hexCifra}+|0{octCifra}+|0|[1-9]{cifra}* { return new Symbol( sym.CONST, yytext(), yyline, yycolumn ); }
({cifra}*).{cifra}+(E[+-]?{cifra}+)? { return new Symbol( sym.CONST, yytext(), yyline, yycolumn ); }
'[^]' { return new Symbol( sym.CONST, yytext(), yyline, yycolumn); }
\(true\)|\(false\) { return new Symbol( sym.CONST,yytext(), yyline, yycolumn ); }
//obrada gresaka
. { if (yytext() != null && yytext().length() > 0) System.out.println( "ERROR: " + yytext(), yyline, yycolumn); }
