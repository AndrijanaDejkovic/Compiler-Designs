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
return new Yytoken( sym.EOF, null, yyline, yycolumn);
%eofval}

%{
//dodatni clanovi generisane klase
KWTable kwTable = new KWTable();
Yytoken getKW()
{
	return new Yytoken( kwTable.find( yytext() ),
	yytext(), yyline, yycolumn );
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
\( { return new Yytoken( sym.LEFTPAR, yytext(), yyline, yycolumn ); }
\) { return new Yytoken( sym.RIGHTPAR, yytext(), yyline, yycolumn ); }

//operatori
\< { return new Yytoken( sym.LESS,yytext(), yyline, yycolumn); }
\<= { return new Yytoken( sym.LESSOREQ,yytext(), yyline, yycolumn); }
== { return new Yytoken( sym.EQUAL,yytext(), yyline, yycolumn); }
\<> { return new Yytoken( sym.NOTEQ,yytext(), yyline, yycolumn); }
\> { return new Yytoken( sym.GREATER,yytext(), yyline, yycolumn); }
\>= { return new Yytoken( sym.GREATEROREQ,yytext(), yyline, yycolumn); }
\=> { return new Yytoken( sym.LAMBDA,yytext(), yyline, yycolumn); }
:= { return new Yytoken( sym.ASSIGN, yytext(), yyline, yycolumn ); }
//separatori
\. { return new Yytoken( sym.DOT, yytext(), yyline, yycolumn ); }
: { return new Yytoken( sym.COLON, yytext(), yyline, yycolumn ); }
; { return new Yytoken( sym.SEMICOLON, yytext(), yyline, yycolumn ); }
, { return new Yytoken( sym.COMMA, yytext(), yyline, yycolumn ); }

//kljucne reci
{slovo}+ { return getKW(); }
//identifikatori
({slovo}|\$)({slovo}|{cifra}|\$)* { return new Yytoken(sym.ID, yytext(),yyline, yycolumn ); }
//konstante
(0x){hexCifra}+|0{octCifra}+|0|[1-9]{cifra}* { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }
({cifra}*).{cifra}+(E[+-]?{cifra}+)? { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }
'[^]' { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }
\(true\)|\(false\) { return new Yytoken( sym.CONST,yytext(), yyline, yycolumn ); }
//obrada gresaka
. { if (yytext() != null && yytext().length() > 0) System.out.println( "ERROR: " + yytext() ); }
