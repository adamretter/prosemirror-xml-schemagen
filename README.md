# ProseMirror XML Schema Generator

This project implements a converted for converting XML Schema to ProseMirror Schema.

## Usage

Requirements:
* [Java 8](http://java.oracle.com)
* [SBT](https://github.com/sbt/sbt)

```bash
$ git clone https://github.com/adamretter/prosemirror-xml-schemagen.git
$ cd prosemirror-xml-schemagen
$ sbt assembly
$ java -jar java -jar target/scala-2.12/prosemirror-xml-schemagen-assembly-0.1.jar
```

### Arguments

* `schema`: Path to an XML Schema file
* `root element`: The name of an element defined in the XML Schema, to use as the root for the ProseMirror schema.

### Example usage

Converting the [DocBook v4.5](http://docbook.org/xsd/4.5/) XML Schema:

```bash
$ java -jar java -jar target/scala-2.12/prosemirror-xml-schemagen-assembly-0.1.jar docbook.xsd book

```

Generates the ProseMirror schema output:

```json
book: {
    content: "((title subtitle? titleabbrev?)? bookinfo? (dedication | toc | lot | glossary | bibliography | preface | (chapter) | reference | part | (article) | (appendix) | (index | setindex) | colophon)*)"
}
title: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | (indexterm))?)*"
}
footnoteref: {
    content: ""
}
xref: {
    content: ""
}
biblioref: {
    content: ""
}
footnote: {
    content: "((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address))+"
}
bibliolist: {
    content: "(blockinfo? (title titleabbrev?)? (biblioentry | bibliomixed)+)"
}
blockinfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
graphic: {
    content: ""
}
mediaobject: {
    content: "(objectinfo? (videoobject | audioobject | imageobject | textobject | imageobjectco) caption?)"
}
objectinfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
legalnotice: {
    content: "(blockinfo? title? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | (formalpara | para | simpara) | blockquote | (indexterm) | beginpage)+)"
}
glosslist: {
    content: "(blockinfo? (title titleabbrev?)? glossentry+)"
}
titleabbrev: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | (indexterm))?)*"
}
personname: {
    content: "(honorific | firstname | surname | lineage | othername)+"
}
honorific: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
link: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
citebiblioid: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
olink: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
orgname: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
ulink: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
termdef: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
abbrev: {
    content: "((acronym | emphasis | trademark | (link | olink | ulink) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
acronym: {
    content: "((acronym | emphasis | trademark | (link | olink | ulink) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
emphasis: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
citation: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
citerefentry: {
    content: "(refentrytitle manvolnum?)"
}
refentrytitle: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
citetitle: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
foreignphrase: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
glossterm: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
firstterm: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
phrase: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
quote: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
trademark: {
    content: "((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | emphasis)*"
}
ooclass: {
    content: "((modifier | package)* classname)"
}
modifier: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
replaceable: {
    content: "((link | olink | ulink) | optional | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | co)*"
}
optional: {
    content: "(((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
oointerface: {
    content: "((modifier | package)* interfacename)"
}
package: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
inlinegraphic: {
    content: ""
}
inlinemediaobject: {
    content: "(objectinfo? (videoobject | audioobject | imageobject | textobject | imageobjectco))"
}
videoobject: {
    content: "(objectinfo? videodata)"
}
videodata: {
    content: ""
}
audioobject: {
    content: "(objectinfo? audiodata)"
}
audiodata: {
    content: ""
}
imageobject: {
    content: "(objectinfo? imagedata)"
}
imagedata: {
    content: ""
}
textobject: {
    content: "(objectinfo? (phrase | textdata | ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | (formalpara | para | simpara) | blockquote)+))"
}
textdata: {
    content: ""
}
itemizedlist: {
    content: "(blockinfo? (title titleabbrev?)? ((caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)* listitem+)"
}
caution: {
    content: "(title? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | procedure | sidebar | anchor | bridgehead | remark | (indexterm) | beginpage)+)"
}
orderedlist: {
    content: "(blockinfo? (title titleabbrev?)? ((caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)* listitem+)"
}
important: {
    content: "(title? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | procedure | sidebar | anchor | bridgehead | remark | (indexterm) | beginpage)+)"
}
segmentedlist: {
    content: "((title titleabbrev?)? segtitle+ seglistitem+)"
}
segtitle: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | (indexterm))?)*"
}
wordasword: {
    content: "((acronym | emphasis | trademark | (link | olink | ulink) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
anchor: {
    content: ""
}
remark: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
ooexception: {
    content: "((modifier | package)* exceptionname)"
}
exceptionname: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
indexterm: {
    content: "(primary? ((secondary ((tertiary (see | seealso+)?) | see | seealso+)?) | see | seealso+)?)"
}
primary: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject)?)*"
}
interfacename: {
    content: "(((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
methodname: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
beginpage: {
    content: ""
}
action: {
    content: "(((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
application: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
classname: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
command: {
    content: "(((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
computeroutput: {
    content: "((((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?) | co)*"
}
database: {
    content: "(((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
email: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
subscript: {
    content: "((link | olink | ulink) | emphasis | replaceable | symbol | inlinegraphic | inlinemediaobject | (anchor) | (remark | subscript | superscript))*"
}
symbol: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
superscript: {
    content: "((link | olink | ulink) | emphasis | replaceable | symbol | inlinegraphic | inlinemediaobject | (anchor) | (remark | subscript | superscript))*"
}
envar: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
errorcode: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
errorname: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
errortext: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
errortype: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
filename: {
    content: "(((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
function: {
    content: "(((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
guibutton: {
    content: "(((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?) | accel | superscript | subscript)*"
}
accel: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
guiicon: {
    content: "(((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?) | accel | superscript | subscript)*"
}
guilabel: {
    content: "(((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?) | accel | superscript | subscript)*"
}
guimenu: {
    content: "(((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?) | accel | superscript | subscript)*"
}
guimenuitem: {
    content: "(((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?) | accel | superscript | subscript)*"
}
guisubmenu: {
    content: "(((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?) | accel | superscript | subscript)*"
}
hardware: {
    content: "(((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
interface: {
    content: "(((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?) | accel)*"
}
keycap: {
    content: "(((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
keycode: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
keycombo: {
    content: "(keycap | keycombo | keysym | mousebutton)+"
}
keysym: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
mousebutton: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
literal: {
    content: "(((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
code: {
    content: "(((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
constant: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
varname: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
markup: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
medialabel: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
menuchoice: {
    content: "(shortcut? (guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | interface)+)"
}
shortcut: {
    content: "(keycap | keycombo | keysym | mousebutton)+"
}
option: {
    content: "(((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
parameter: {
    content: "(((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
prompt: {
    content: "(((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?) | co)*"
}
co: {
    content: ""
}
property: {
    content: "(((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
returnvalue: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
sgmltag: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
structfield: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
structname: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
systemitem: {
    content: "((((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?) | acronym | co)*"
}
uri: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
token: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
type: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
userinput: {
    content: "((((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?) | co)*"
}
author: {
    content: "((personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib)+) (personblurb | email | address)*)"
}
firstname: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
surname: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
lineage: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
othername: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
affiliation: {
    content: "(shortaffil? jobtitle* orgname? orgdiv* address*)"
}
shortaffil: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
jobtitle: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
orgdiv: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
address: {
    content: "(personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | street | pob | postcode | city | state | country | phone | fax | email | otheraddr)*"
}
authorblurb: {
    content: "(title? (formalpara | para | simpara))"
}
formalpara: {
    content: "(title (indexterm) para)"
}
para: {
    content: "((((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?) | ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table)))*"
}
authorinitials: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
corpauthor: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
corpcredit: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
modespec: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
othercredit: {
    content: "((personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib)+) (personblurb | email | address)*)"
}
contrib: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
personblurb: {
    content: "(title? (formalpara | para | simpara))"
}
simpara: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
productname: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
productnumber: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
revhistory: {
    content: "(revision+)"
}
revision: {
    content: "(revnumber? date (author | authorinitials)* (revremark | revdescription)?)"
}
revnumber: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
date: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
revremark: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
revdescription: {
    content: "((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | procedure | (anchor | bridgehead | remark | highlights) | (indexterm))+"
}
simplelist: {
    content: "(member+)"
}
member: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
inlineequation: {
    content: "(alt? (graphic+ | inlinemediaobject+ | mathphrase+))"
}
alt: {
    content: "()"
}
mathphrase: {
    content: "(subscript | superscript | emphasis)*"
}
constructorsynopsis: {
    content: "(modifier* methodname? (methodparam+ | void?) exceptionname*)"
}
methodparam: {
    content: "(modifier* type? ((parameter initializer?) | funcparams) modifier*)"
}
initializer: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
funcparams: {
    content: "(((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
void: {
    content: ""
}
destructorsynopsis: {
    content: "(modifier* methodname? (methodparam+ | void?) exceptionname*)"
}
methodsynopsis: {
    content: "(modifier* (type | void)? methodname (methodparam+ | void?) exceptionname* modifier*)"
}
synopsis: {
    content: "((((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?) | graphic | mediaobject | co | coref | textobject | lineannotation)*"
}
cmdsynopsis: {
    content: "((command | arg | group | sbr)+ synopfragment*)"
}
arg: {
    content: "(arg | group | option | synopfragmentref | replaceable | sbr)*"
}
group: {
    content: "(arg | group | option | synopfragmentref | replaceable | sbr)+"
}
synopfragmentref: {
    content: "()"
}
sbr: {
    content: ""
}
synopfragment: {
    content: "(arg | group)+"
}
funcsynopsis: {
    content: "(funcsynopsisinfo | funcprototype)+"
}
funcsynopsisinfo: {
    content: "((((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?) | textobject | lineannotation)*"
}
lineannotation: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
classsynopsis: {
    content: "((ooclass | oointerface | ooexception)+ (classsynopsisinfo | fieldsynopsis | (constructorsynopsis | destructorsynopsis | methodsynopsis))*)"
}
classsynopsisinfo: {
    content: "((((link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?) | textobject | lineannotation)*"
}
fieldsynopsis: {
    content: "(modifier* type? varname initializer?)"
}
funcprototype: {
    content: "(modifier* funcdef (void | varargs | (paramdef+ varargs?)) modifier*)"
}
funcdef: {
    content: "(type | replaceable | function)*"
}
varargs: {
    content: ""
}
paramdef: {
    content: "(initializer | type | replaceable | parameter | funcparams)*"
}
coref: {
    content: ""
}
variablelist: {
    content: "(blockinfo? (title titleabbrev?)? ((caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)* varlistentry+)"
}
note: {
    content: "(title? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | procedure | sidebar | anchor | bridgehead | remark | (indexterm) | beginpage)+)"
}
calloutlist: {
    content: "((title titleabbrev?)? callout+)"
}
callout: {
    content: "((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+"
}
tip: {
    content: "(title? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | procedure | sidebar | anchor | bridgehead | remark | (indexterm) | beginpage)+)"
}
programlistingco: {
    content: "(areaspec programlisting calloutlist*)"
}
areaspec: {
    content: "(area | areaset)+"
}
area: {
    content: ""
}
areaset: {
    content: "(area+)"
}
programlisting: {
    content: "((((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?) | co | coref | lineannotation | textobject)*"
}
literallayout: {
    content: "((((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?) | co | coref | textobject | lineannotation)*"
}
screenco: {
    content: "(areaspec screen calloutlist*)"
}
screen: {
    content: "((((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?) | co | coref | textobject | lineannotation)*"
}
screenshot: {
    content: "(screeninfo? (graphic | graphicco | mediaobject | mediaobjectco))"
}
screeninfo: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
graphicco: {
    content: "(areaspec graphic calloutlist*)"
}
mediaobjectco: {
    content: "(objectinfo? imageobjectco (imageobjectco | textobject)*)"
}
imageobjectco: {
    content: "(areaspec imageobject calloutlist*)"
}
blockquote: {
    content: "(blockinfo? title? attribution? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+)"
}
attribution: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
warning: {
    content: "(title? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | procedure | sidebar | anchor | bridgehead | remark | (indexterm) | beginpage)+)"
}
informalexample: {
    content: "(blockinfo? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (indexterm) | beginpage | procedure)+)"
}
informalfigure: {
    content: "(blockinfo? (((programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (indexterm) | beginpage) | (link | olink | ulink))+)"
}
informalequation: {
    content: "(blockinfo? (alt? (graphic+ | mediaobject+ | mathphrase+)))"
}
informaltable: {
    content: "(blockinfo? ((textobject* (graphic+ | mediaobject+ | tgroup+)) | ((col* | colgroup*) thead? tfoot? (tbody+ | tr+))))"
}
tgroup: {
    content: "(colspec* spanspec* thead? tfoot? tbody)"
}
colspec: {
    content: ""
}
spanspec: {
    content: ""
}
thead: {
    content: "(tr+ | (colspec* row+))"
}
tr: {
    content: "(th | td)+"
}
th: {
    content: "((((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?) | ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | (formalpara | para | simpara) | graphic | mediaobject) | table | informaltable)*"
}
table: {
    content: "((blockinfo? (title titleabbrev?) (indexterm) textobject* (graphic+ | mediaobject+ | tgroup+)) | (caption (col* | colgroup*) thead? tfoot? (tbody+ | tr+)))"
}
caption: {
    content: "((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | (formalpara | para | simpara) | blockquote)*"
}
col: {
    content: ""
}
colgroup: {
    content: "(col*)"
}
tfoot: {
    content: "(tr+ | (colspec* row+))"
}
row: {
    content: "(entry | entrytbl)+"
}
entry: {
    content: "((((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?) | ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | (formalpara | para | simpara) | graphic | mediaobject))*"
}
entrytbl: {
    content: "(colspec* spanspec* thead? tbody)"
}
tbody: {
    content: "(tr+ | row+)"
}
td: {
    content: "((((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?) | ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | (formalpara | para | simpara) | graphic | mediaobject) | table | informaltable)*"
}
procedure: {
    content: "(blockinfo? (title titleabbrev?)? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)* step+)"
}
example: {
    content: "(blockinfo? (title titleabbrev?) ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (indexterm) | beginpage | procedure)+)"
}
figure: {
    content: "(blockinfo? (title titleabbrev?) (((programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (indexterm) | beginpage) | (link | olink | ulink))+)"
}
equation: {
    content: "(blockinfo? (title titleabbrev?)? (informalequation | (alt? (graphic+ | mediaobject+ | mathphrase+))))"
}
msgset: {
    content: "(blockinfo? (title titleabbrev?)? (msgentry+ | simplemsgentry+))"
}
msgentry: {
    content: "(msg+ msginfo? msgexplan*)"
}
msg: {
    content: "(title? msgmain (msgsub | msgrel)*)"
}
msgmain: {
    content: "(title? msgtext)"
}
msgtext: {
    content: "((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+"
}
task: {
    content: "(blockinfo? (indexterm) (title titleabbrev?) tasksummary? taskprerequisites? procedure example* taskrelated?)"
}
tasksummary: {
    content: "(blockinfo? (title titleabbrev?)? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+)"
}
qandaset: {
    content: "(blockinfo? (title titleabbrev?)? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | procedure | (anchor | bridgehead | remark | highlights) | (indexterm))* (qandadiv+ | qandaentry+))"
}
bridgehead: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | (indexterm))?)*"
}
highlights: {
    content: "((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (formalpara | para | simpara) | (indexterm))+"
}
qandadiv: {
    content: "(blockinfo? (title titleabbrev?)? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | procedure | (anchor | bridgehead | remark | highlights) | (indexterm))* (qandadiv+ | qandaentry+))"
}
qandaentry: {
    content: "(blockinfo? revhistory? question answer*)"
}
question: {
    content: "(label? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | procedure | (anchor | bridgehead | remark | highlights) | (indexterm))+)"
}
label: {
    content: "((acronym | emphasis | trademark | (link | olink | ulink) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
answer: {
    content: "(label? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | procedure | (anchor | bridgehead | remark | highlights) | (indexterm))* qandaentry*)"
}
sidebar: {
    content: "(sidebarinfo? (title titleabbrev?)? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | procedure | (anchor | bridgehead | remark | highlights) | (indexterm) | beginpage)+)"
}
sidebarinfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
subjectset: {
    content: "(subject+)"
}
subject: {
    content: "(subjectterm+)"
}
subjectterm: {
    content: "()"
}
keywordset: {
    content: "(keyword+)"
}
keyword: {
    content: "()"
}
itermset: {
    content: "(indexterm+)"
}
abstract: {
    content: "(title? (formalpara | para | simpara))"
}
artpagenums: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
authorgroup: {
    content: "(author | editor | collab | corpauthor | corpcredit | othercredit)+"
}
editor: {
    content: "((personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib)+) (personblurb | email | address)*)"
}
collab: {
    content: "(collabname affiliation*)"
}
collabname: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
bibliomisc: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
biblioset: {
    content: "(abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm))+"
}
confgroup: {
    content: "(confdates | conftitle | confnum | address | confsponsor)*"
}
confdates: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
conftitle: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
confnum: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
confsponsor: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
contractnum: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
contractsponsor: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
copyright: {
    content: "(year+ holder*)"
}
year: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
holder: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
corpname: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
edition: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
invpartnumber: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
isbn: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
issn: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
issuenum: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
biblioid: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
bibliosource: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
bibliorelation: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
bibliocoverage: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
pagenums: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
printhistory: {
    content: "((formalpara | para | simpara))"
}
pubdate: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
publisher: {
    content: "(publishername address*)"
}
publishername: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
pubsnumber: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
releaseinfo: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
seriesvolnums: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
subtitle: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | (indexterm))?)*"
}
volumenum: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
epigraph: {
    content: "(attribution? ((formalpara | para | simpara) | literallayout)+)"
}
taskprerequisites: {
    content: "(blockinfo? (title titleabbrev?)? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+)"
}
taskrelated: {
    content: "(blockinfo? (title titleabbrev?)? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+)"
}
msgsub: {
    content: "(title? msgtext)"
}
msgrel: {
    content: "(title? msgtext)"
}
msginfo: {
    content: "(msglevel | msgorig | msgaud)*"
}
msglevel: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
msgorig: {
    content: "((replaceable | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
msgaud: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
msgexplan: {
    content: "(title? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+)"
}
simplemsgentry: {
    content: "(msgtext msgexplan+)"
}
step: {
    content: "(title? ((((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+ ((substeps | stepalternatives) ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)*)?) | ((substeps | stepalternatives) ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)*)))"
}
substeps: {
    content: "(step+)"
}
stepalternatives: {
    content: "(step+)"
}
varlistentry: {
    content: "(term+ listitem)"
}
term: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
listitem: {
    content: "((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+"
}
street: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
pob: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
postcode: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
city: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
state: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
country: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
phone: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
fax: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
otheraddr: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
secondary: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject)?)*"
}
tertiary: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject)?)*"
}
see: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject)?)*"
}
seealso: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject)?)*"
}
seglistitem: {
    content: "(seg+)"
}
seg: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
manvolnum: {
    content: "((acronym | emphasis | trademark | (link | olink | ulink) | (anchor) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm) | beginpage)?)*"
}
glossentry: {
    content: "(glossterm acronym? abbrev? (indexterm) revhistory? (glosssee | glossdef+))"
}
glosssee: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
glossdef: {
    content: "(((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | remark | (indexterm) | beginpage)+ glossseealso*)"
}
glossseealso: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
biblioentry: {
    content: "(articleinfo | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
articleinfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
bibliomixed: {
    content: "((abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)) | bibliomset)*"
}
bibliomset: {
    content: "((abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)) | bibliomset)*"
}
bookinfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
dedication: {
    content: "((title subtitle? titleabbrev?)? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | (formalpara | para | simpara) | blockquote | (indexterm) | beginpage)+)"
}
toc: {
    content: "(beginpage? (title subtitle? titleabbrev?)? tocfront* (tocpart | tocchap)* tocback*)"
}
tocfront: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
tocpart: {
    content: "(tocentry+ tocchap*)"
}
tocentry: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
tocchap: {
    content: "(tocentry+ toclevel1*)"
}
toclevel1: {
    content: "(tocentry+ toclevel2*)"
}
toclevel2: {
    content: "(tocentry+ toclevel3*)"
}
toclevel3: {
    content: "(tocentry+ toclevel4*)"
}
toclevel4: {
    content: "(tocentry+ toclevel5*)"
}
toclevel5: {
    content: "(tocentry+)"
}
tocback: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
lot: {
    content: "(beginpage? (title subtitle? titleabbrev?)? lotentry*)"
}
lotentry: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (inlinegraphic | inlinemediaobject | inlineequation) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (indexterm) | beginpage)?)*"
}
glossary: {
    content: "(glossaryinfo? (title subtitle? titleabbrev?)? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)* (glossdiv+ | glossentry+) bibliography?)"
}
glossaryinfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
glossdiv: {
    content: "((title subtitle? titleabbrev?) ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)* glossentry+)"
}
bibliography: {
    content: "(bibliographyinfo? (title subtitle? titleabbrev?)? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)* (bibliodiv+ | (biblioentry | bibliomixed)+))"
}
bibliographyinfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
bibliodiv: {
    content: "((title subtitle? titleabbrev?)? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)* (biblioentry | bibliomixed)+)"
}
preface: {
    content: "(beginpage? prefaceinfo? (title subtitle? titleabbrev?) (toc | lot | index | glossary | bibliography)* tocchap? ((((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+ (sect1* | (refentry) | simplesect* | (section))) | (sect1+ | (refentry) | simplesect+ | (section))) (toc | lot | index | glossary | bibliography)*)"
}
prefaceinfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
index: {
    content: "(indexinfo? (title subtitle? titleabbrev?)? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)* (indexdiv* | indexentry*))"
}
indexinfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
indexdiv: {
    content: "((title subtitle? titleabbrev?)? ((itemizedlist | orderedlist | variablelist | simplelist | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | anchor | remark | (link | olink | ulink) | beginpage)* (indexentry+ | segmentedlist)))"
}
indexentry: {
    content: "(primaryie (seeie | seealsoie)* (secondaryie (seeie | seealsoie | tertiaryie)*)*)"
}
primaryie: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject)?)*"
}
seeie: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject)?)*"
}
seealsoie: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject)?)*"
}
secondaryie: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject)?)*"
}
tertiaryie: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject)?)*"
}
sect1: {
    content: "(sect1info? (title subtitle? titleabbrev?) (toc | lot | index | glossary | bibliography)* ((((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+ ((refentry) | sect2* | simplesect*)) | (refentry) | sect2+ | simplesect+) (toc | lot | index | glossary | bibliography)*)"
}
sect1info: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
refentry: {
    content: "(beginpage? (indexterm) refentryinfo? refmeta? (remark | (link | olink | ulink))* refnamediv+ refsynopsisdiv? (refsect1+ | refsection+))"
}
refentryinfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
refmeta: {
    content: "((indexterm) refentrytitle manvolnum? refmiscinfo* (indexterm))"
}
refmiscinfo: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
refnamediv: {
    content: "(refdescriptor? refname+ refpurpose refclass* (remark | (link | olink | ulink))*)"
}
refdescriptor: {
    content: "((ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput))*"
}
refname: {
    content: "((ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput))*"
}
refpurpose: {
    content: "(((footnoteref | xref | biblioref) | (footnote | personname | citebiblioid | orgname | termdef | abbrev | acronym | citation | citerefentry | citetitle | emphasis | foreignphrase | glossterm | firstterm | phrase | quote | trademark | wordasword) | (link | olink | ulink) | (ooclass | oointerface | ooexception | interfacename | exceptionname | methodname | action | application | classname | package | command | computeroutput | database | email | envar | errorcode | errorname | errortext | errortype | filename | function | guibutton | guiicon | guilabel | guimenu | guimenuitem | guisubmenu | hardware | interface | keycap | keycode | keycombo | keysym | literal | code | constant | varname | markup | medialabel | menuchoice | mousebutton | option | optional | parameter | prompt | property | replaceable | returnvalue | sgmltag | structfield | structname | symbol | systemitem | uri | token | type | userinput) | (anchor) | (author | authorinitials | corpauthor | corpcredit | modespec | othercredit | productname | productnumber | revhistory) | (remark | subscript | superscript) | (indexterm) | beginpage)?)*"
}
refclass: {
    content: "(application?)*"
}
refsynopsisdiv: {
    content: "(refsynopsisdivinfo? (title subtitle? titleabbrev?)? ((((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+ refsect2*) | refsect2+))"
}
refsynopsisdivinfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
refsect2: {
    content: "(refsect2info? (title subtitle? titleabbrev?) ((((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+ refsect3*) | refsect3+))"
}
refsect2info: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
refsect3: {
    content: "(refsect3info? (title subtitle? titleabbrev?) ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+)"
}
refsect3info: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
refsect1: {
    content: "(refsect1info? (title subtitle? titleabbrev?) ((((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+ refsect2*) | refsect2+))"
}
refsect1info: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
refsection: {
    content: "(refsectioninfo? (title subtitle? titleabbrev?) ((((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+ refsection*) | refsection+))"
}
refsectioninfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
sect2: {
    content: "(sect2info? (title subtitle? titleabbrev?) (toc | lot | index | glossary | bibliography)* ((((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+ ((refentry) | sect3* | simplesect*)) | (refentry) | sect3+ | simplesect+) (toc | lot | index | glossary | bibliography)*)"
}
sect2info: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
sect3: {
    content: "(sect3info? (title subtitle? titleabbrev?) (toc | lot | index | glossary | bibliography)* ((((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+ ((refentry) | sect4* | simplesect*)) | (refentry) | sect4+ | simplesect+) (toc | lot | index | glossary | bibliography)*)"
}
sect3info: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
sect4: {
    content: "(sect4info? (title subtitle? titleabbrev?) (toc | lot | index | glossary | bibliography)* ((((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+ ((refentry) | sect5* | simplesect*)) | (refentry) | sect5+ | simplesect+) (toc | lot | index | glossary | bibliography)*)"
}
sect4info: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
sect5: {
    content: "(sect5info? (title subtitle? titleabbrev?) (toc | lot | index | glossary | bibliography)* ((((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+ ((refentry) | simplesect*)) | (refentry) | simplesect+) (toc | lot | index | glossary | bibliography)*)"
}
sect5info: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
simplesect: {
    content: "((title subtitle? titleabbrev?) ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+)"
}
section: {
    content: "(sectioninfo? (title subtitle? titleabbrev?) (toc | lot | index | glossary | bibliography)* ((((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+ ((refentry) | (section) | simplesect*)) | (refentry) | (section) | simplesect+) (toc | lot | index | glossary | bibliography)*)"
}
sectioninfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
chapter: {
    content: "(beginpage? chapterinfo? (title subtitle? titleabbrev?) (toc | lot | index | glossary | bibliography)* tocchap? ((((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+ (sect1* | (refentry) | simplesect* | (section))) | (sect1+ | (refentry) | simplesect+ | (section))) (toc | lot | index | glossary | bibliography)*)"
}
chapterinfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
reference: {
    content: "(beginpage? referenceinfo? (title subtitle? titleabbrev?) partintro? (refentry))"
}
referenceinfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
partintro: {
    content: "((title subtitle? titleabbrev?)? ((((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+ (sect1* | (refentry) | simplesect* | (section))) | (sect1+ | (refentry) | simplesect+ | (section))))"
}
part: {
    content: "(beginpage? partinfo? (title subtitle? titleabbrev?) partintro? ((appendix) | (chapter) | (toc | lot | index | glossary | bibliography) | (article) | preface | (refentry) | reference)+)"
}
partinfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
appendix: {
    content: "(beginpage? appendixinfo? (title subtitle? titleabbrev?) (toc | lot | index | glossary | bibliography)* tocchap? ((((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+ (sect1* | (refentry) | simplesect* | (section))) | (sect1+ | (refentry) | simplesect+ | (section))) (toc | lot | index | glossary | bibliography)*)"
}
appendixinfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
article: {
    content: "((title subtitle? titleabbrev?)? articleinfo? tocchap? lot* ((((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)+ (sect1* | (refentry) | simplesect* | (section))) | (sect1+ | (refentry) | simplesect+ | (section))) ((toc | lot | index | glossary | bibliography) | (appendix) | colophon | ackno)*)"
}
colophon: {
    content: "((title subtitle? titleabbrev?)? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | (formalpara | para | simpara) | blockquote)+)"
}
ackno: {
    content: "(((link | olink | ulink) | emphasis | trademark | replaceable | (remark | subscript | superscript) | inlinegraphic | inlinemediaobject | (indexterm))?)*"
}
setindex: {
    content: "(setindexinfo? (title subtitle? titleabbrev?)? ((bibliolist | glosslist | itemizedlist | orderedlist | segmentedlist | simplelist | variablelist | calloutlist) | (caution | important | note | tip | warning) | (programlistingco | programlisting | literallayout | screenco | screen | screenshot) | ((constructorsynopsis | destructorsynopsis | methodsynopsis) | methodsynopsis | destructorsynopsis | constructorsynopsis | synopsis | cmdsynopsis | funcsynopsis | classsynopsis | fieldsynopsis) | (formalpara | para | simpara) | (blockquote | informalexample | informalfigure | graphicco | graphic | mediaobject | mediaobjectco | informalequation | informaltable | address) | (example | figure | equation | table) | (msgset | task | qandaset | procedure | sidebar) | (anchor | bridgehead | remark | highlights) | (abstract | authorblurb | epigraph) | (indexterm) | beginpage)* (indexdiv* | indexentry*))"
}
setindexinfo: {
    content: "(graphic | mediaobject | legalnotice | modespec | subjectset | keywordset | itermset | (abbrev | abstract | address | artpagenums | author | authorgroup | authorinitials | bibliomisc | biblioset | collab | confgroup | contractnum | contractsponsor | copyright | corpauthor | corpname | corpcredit | date | edition | editor | invpartnumber | isbn | issn | issuenum | orgname | biblioid | citebiblioid | bibliosource | bibliorelation | bibliocoverage | othercredit | pagenums | printhistory | productname | productnumber | pubdate | publisher | publishername | pubsnumber | releaseinfo | revhistory | seriesvolnums | subtitle | title | titleabbrev | volumenum | citetitle | personname | (honorific | firstname | surname | lineage | othername | affiliation | authorblurb | contrib) | (indexterm)))+"
}
```