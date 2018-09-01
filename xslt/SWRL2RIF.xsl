<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE xsl:stylesheet [ 
    <!ENTITY rif  "http://www.w3.org/2007/rif#">
    <!ENTITY swrlb "http://www.w3.org/2003/11/swrlb">
]>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xd="http://www.oxygenxml.com/ns/doc/xsl"
    xmlns:swrlx="http://www.w3.org/2003/11/swrlx"
    xmlns:swrlb="http://www.w3.org/2003/11/swrlb"
    xmlns:ruleml="http://www.w3.org/2003/11/ruleml"
    xmlns:owlx="http://www.w3.org/2003/05/owl-xml"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:xs="http://www.w3.org/2001/XMLSchema#"
    xmlns="http://www.w3.org/2007/rif#"
    
    exclude-result-prefixes="xd swrlx swrlb ruleml owlx" 
    version="1.0">
    <xd:doc scope="stylesheet">
        <xd:desc>
            <xd:p><xd:b>Created on:</xd:b> Sep 19, 2016</xd:p>
            <xd:p><xd:b>Author:</xd:b> iakbari</xd:p>
            <xd:p></xd:p>
        </xd:desc>
    </xd:doc>
    
    
    <xsl:output method="xml" omit-xml-declaration="no"   indent="yes"/>
    
    <!-- .................................................................... -->
    <!-- <swrlx:Ontology> is the root element in swrl documents  -->
     
    <xsl:template match="swrlx:Ontology">
    	<xsl:text>&#xa;</xsl:text> <!-- newline -->    	
        <!-- <Document xmlns="http://www.w3.org/2007/rif#">-->        
        <Document>
            <!-- copy non swrl-related namespaces 
            <xsl:copy-of select="namespace::*[not(name()='swrlx' or name()='swrlb' or name()='owlx' or name()='ruleml')]"/>
            -->
            
            <!-- swrl rules start with <ruleml:imp> tag. other children of  <swrlx:Ontology> are the ontology part and will be ignored-->
            <payload>
                <Group>
                    <xsl:apply-templates select="ruleml:imp"/>                  
                </Group>
            </payload>
            <xsl:apply-templates select="ruleml:var"/>
            <xsl:apply-templates select="*[not(self::ruleml:imp or self::ruleml:var)]"/>
            <!-- this should work too: <xsl:apply-templates select="*[name()!=ruleml:imp]"/> -->
        </Document>
    </xsl:template>
    
    <!-- .................................................................... -->
    <!-- ruleml:imp = { 
        ruleml:_rlab? ,
        owlx:Annotation* ,
        ruleml:_body ,
        ruleml:_head } 
        ruleml:imp is maped to implies in RIF:
        <ruleml:imp> = {<implies>}.  in more details: 
        <ruleml:imp>   =  { <sentence> <Forall> <declare/>* <formula><implies><if/><then/> </implies></formula></Forall></sentence>
        <ruleml:_body> = {<if>}
        <ruleml:_head> = {<then>}
    -->
    <xsl:template match="ruleml:imp">
        <!-- ruleml:_rlab is the rule name -->
        <xsl:apply-templates select="ruleml:_rlab"/>
        <xsl:apply-templates select="owlx:Annotation"/>
        
        <sentence>
            <Forall>
                <xsl:call-template name="declare"/>
                <formula>
                    <Implies>
                        <if>
                            <xsl:apply-templates select="ruleml:_body"/>                            
                        </if>
                        <then>
                            <xsl:apply-templates select="ruleml:_head"/>                            
                        </then>
                    </Implies>
                </formula>
            </Forall>
        </sentence>
    </xsl:template>   
   
  
    <!-- .................................................................... -->
    <!-- ruleml:_body = {swrlx:atom*} 
        if ruleml:_body has more than one child they will be AND together.
    -->
    <xsl:template match="ruleml:_body">        
        <xsl:choose>
            <xsl:when test="count(*) > 1">
                <And>
                	<xsl:for-each select="*">
                		<formula>
                			<xsl:apply-templates select="."/>
                		</formula>
					</xsl:for-each> 
                </And>
            </xsl:when>
            <xsl:otherwise>
                <xsl:call-template name="atom"/> 
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    
    <!-- ruleml:_head = {swrlx:atom*} 
        if ruleml:_head has more than one child (cluase) the whole rule should be written multiple times 
    -->
    <xsl:template match="ruleml:_head">
        <xsl:call-template name="atom"/>
    </xsl:template>
   
   
    <!-- .................................................................... -->
    <!-- <rulem:var> children variables of <swrlx:Ontology> will
       be ignored because they are defined in the rules too-->
    <xsl:template match="ruleml:var">
        <xsl:choose>
            <!-- if the variable is a general var (out of rules) it is ignored-->
            <xsl:when test="parent::swrlx:Ontology"/>
            <xsl:otherwise>
                <Var><xsl:value-of select="text()"/></Var>
            </xsl:otherwise>
        </xsl:choose>
        
        
    </xsl:template>
    
    <!-- rule name and annoations are not supported for now -->
    <xsl:template match="ruleml:_rlab">            
        <xsl:call-template name="ignore_element"/>  
    </xsl:template>
    <xsl:template match="owlx:Annotation">
        <xsl:call-template name="ignore_element"/>  
    </xsl:template>
         
    <!-- .................................................................... -->
    <xsl:template name="declare">
        <!--
        <xsl:variable   name="vars" select=".//ruleml:var"/>
        
        <xsl:for-each select=".//ruleml:var">
            <xsl:copy-of select="."/>
            <xsl:copy-of select="./preceding::ruleml:var[ancestor::ruleml:imp[last()]]"/> 
            <xsl:copy-of select="./preceding::ruleml:var[ancestor::ruleml:imp]"/> 
        </xsl:for-each>
          --> 
        <!-- check duplicate varaible definition: if a varibale definition 
        is not repeated later in the same ruleml:imp rule it will be declared. -->
        <xsl:for-each select=".//ruleml:var">
            <xsl:variable name="cur" select="text()"/>
            <!--<xsl:copy-of select="(./following::ruleml:var[ancestor::ruleml:imp[last()]])"/> -->
            <xsl:if test="count((./following::ruleml:var[ancestor::ruleml:imp[last()]])[(text() = $cur)])=0">
                <declare><Var><xsl:value-of select="$cur"/></Var></declare>
            </xsl:if>         
        </xsl:for-each>
        
    </xsl:template>
    
    <!-- .................................................................... -->
    <!-- atom = { (
        swrlx:classAtom |
        swrlx:datarangeAtom |
        swrlx:individualPropertyAtom |
        swrlx:datavaluedPropertyAtom |
        swrlx:sameIndividualAtom |
        swrlx:differentIndividualAtom |
        swrlx:builtinAtom         
        ) }     
    -->
    
    <xsl:template name="atom">        
        <xsl:apply-templates select="swrlx:classAtom"/> 
        <xsl:apply-templates select="swrlx:datarangeAtom"/>        
        <xsl:apply-templates select="swrlx:individualPropertyAtom"/>
        <xsl:apply-templates select="swrlx:datavaluedPropertyAtom"/>
        <xsl:apply-templates select="swrlx:sameIndividualAtom"/>
        <xsl:apply-templates select="swrlx:differentIndividualsAtom"/>
        <xsl:apply-templates select="swrlx:builtinAtom"/>
    </xsl:template>
    
    <!-- .................................................................... -->
    <!-- 
    <xsd:element name="classAtom">
    <xsd:complexType>
      <xsd:sequence>
        <xsd:group ref="owlx:description" />
        <xsd:group ref="swrlx:iObject" />
      </xsd:sequence>
    </xsd:complexType>
    </xsd:element>
    
    classAtom is mapped to 'Member' in RIF.
    -->
    <xsl:template match="swrlx:classAtom">
        <formula>
            <Member>  
                <xsl:for-each select="*">
                    <xsl:if test="position()=1">
                        <class><Const type="&rif;iri"><xsl:call-template name="owlx:description"/></Const></class>
                    </xsl:if>
                    <xsl:if test="position()=2">
                        <instance> <xsl:call-template name="iObject"/></instance>
                    </xsl:if>    
                </xsl:for-each>    
            </Member>    
        </formula>    
    </xsl:template>
    
    <!-- .................................................................... -->
    <!--
        owlx:description = {(
            class                   |
            owlx:DataRestriction    |
            owlx:ObjectRestriction  |
            OneOf                   |
            UnionOf                 |
            IntersectionOf          |
            ComplementOf
        )}
        for now, just the named class is supported.        
     -->   
    <xsl:template name="owlx:description">
        <xsl:apply-templates select="current()"/>
        <!-- 
        <xsl:apply-templates select="owlx:Class"/>
        <xsl:apply-templates select="owlx:DataRestriction"/>
        <xsl:apply-templates select="owlx:ObjectRestriction"/>
        <xsl:apply-templates select="owlx:OneOf"/>
        <xsl:apply-templates select="owlx:UnionOf"/>
        <xsl:apply-templates select="owlx:IntersectionOf"/>
        <xsl:apply-templates select="owlx:ComplementOf"/>
        -->
    </xsl:template>
   
    <!-- .................................................................... -->
    <!-- only named classes are supported. 6 other types of classes shown in description
        template (as its child) are not supported.
        class is 
    -->
    <xsl:template match="owlx:Class">
        <xsl:choose>
            <xsl:when test="count(*)=0 or *[name()=not('owlx:Annotation')=0]">
                <xsl:value-of select="@owlx:name"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:apply-templates/>
            </xsl:otherwise>            
        </xsl:choose>        
    </xsl:template>
    
    <!-- .................................................................... -->
    <!--  element swrlx:datarangeAtom        
            <swrlx:datarangeAtom>
              Content: ( owlx:datarange, swrlx:dObject )
            </swrlx:datarangeAtom>
             
             Example 5-3:
            <swrlx:datarangeAtom> 
              <owlx:Datatype owlx:name="&xsd;int" />
              <ruleml:var>x1</ruleml:var>
            </swrlx:datarangeAtom> 
            
            <swrlx:datarangeAtom> 
              <owlx:OneOf>
                <owlx:DataValue owlx:datatype="&xsd;int">5</owlx:DataValue>
                <owlx:DataValue owlx:datatype="&xsd;int">10</owlx:DataValue>
              </owlx:OneOf>
              <ruleml:var>x2</ruleml:var>
            </swrlx:datarangeAtom> 

            swrlx:datarangeAtom  is not supported for now.            
    -->
    <xsl:template match="swrlx:datarangeAtom">
        <xsl:call-template name="ignore_element"/>  
    </xsl:template>
    
    <!-- .................................................................... -->
    <!--  element swrlx:individualPropertyAtom 
        
        <swrlx:individualPropertyAtom   swrlx:property = xsd:anyURI {required} >
            Content: ( swrlx:iObject, swrlx:iObject )
        </swrlx:individualPropertyAtom>
         
        Example 5-4:
          <swrlx:individualPropertyAtom  swrlx:property="hasParent"> 
            <ruleml:var>x1</ruleml:var>
            <owlx:Individual owlx:name="John" />
          </swrlx:individualPropertyAtom> 
                        
        swrlx:individualPropertyAtom is mapped to Atom in RIF.
         in RIF:
         pred (argument1 . . . argumentm) => its xml syntax:
         <Atom>
            <op>χbld(pred)</op>
            <args ordered="yes">
              χbld(argument1)
              . . .
              χbld(argumentm)
            </args>
         </Atom>
         
    -->
    <xsl:template match="swrlx:individualPropertyAtom">
        <Atom>
            <op>
            	<Const type="&rif;iri"><xsl:value-of select="@swrlx:property"/></Const>
            </op>
            <args ordered="yes">
                <xsl:for-each select="*">
                    <xsl:call-template name="iObject"/>
                </xsl:for-each>    
            </args>
        </Atom>
    </xsl:template>
    
    <!-- .................................................................... -->
    <!--  element swrlx:datavaluedPropertyAtom 
        
        <swrlx:datavaluedPropertyAtom   swrlx:property = xsd:anyURI {required} >
            Content: ( swrlx:iObject, swrlx:dObject )
        </swrlx:datavaluedPropertyAtom>
         
         Example 5-4:         
            <swrlx:datavaluedPropertyAtom  swrlx:property="grade"> 
              <ruleml:var>x1</ruleml:var>
              <owlx:DataValue owlx:datatype="&xsd;int">4</owlx:DataValue>
            </swrlx:datavaluedPropertyAtom> 

                        
         swrlx:datavaluedPropertyAtom same as swrlx:individualPropertyAtom is mapped to Atom in RIF.
         in RIF:
         pred (argument1 . . . argumentm) => its xml syntax:
         <Atom>
            <op>χbld(pred)</op>
            <args ordered="yes">
              χbld(argument1)
              . . .
              χbld(argumentm)
            </args>
         </Atom>
         
    -->
    <xsl:template match="swrlx:datavaluedPropertyAtom">
        <Atom>
            <op>
            	<Const type="&rif;iri"><xsl:value-of select="@swrlx:property"/></Const>
            </op>
            <args ordered="yes">
                <xsl:for-each select="*">
                    <xsl:if test="position()=1">
                        <xsl:call-template name="iObject"/>
                    </xsl:if>
                    <xsl:if test="position()=2">
                        <xsl:call-template name="dObject"/>                        
                    </xsl:if>    
                </xsl:for-each>                    
            </args>
        </Atom>
    </xsl:template>
    
    <!-- .................................................................... -->
    <!-- Same (different) individual atoms assert equality (inequality) between sets of individual and variable names.

         swrxl:sameIndividualAtom = {
          swrlx:iObject, swrlx:iObject         
         }

        swrlx:sameIndividualAtom is mapped to Equal in RIF. 
    -->
    <xsl:template match="swrlx:sameIndividualAtom">
        <formula>
            <Equal>
                <xsl:for-each select="*">
                    <xsl:if test="position()=1">
                        <left><xsl:call-template name="iObject"/></left>
                    </xsl:if>
                    <xsl:if test="position()=2">
                        <right><xsl:call-template name="dObject"/></right>                        
                    </xsl:if>    
                </xsl:for-each>    
            </Equal>    
        </formula>
    </xsl:template>
    
    <!-- .................................................................... -->
    <!-- Same (different) individual atoms assert equality (inequality) between sets of individual and variable names.
        
        element swrlx:differentIndividualsAtom:
        <swrlx:differentIndividualsAtom>
          Content: ( swrlx:iObject* )
        </swrlx:differentIndividualsAtom>
        
        Note that (in)equalities can be asserted between arbitrary combinations of variable names and individual names. For example:
     
     swrlx:differentIndividualsAtom is not supported.
     
    -->
    <xsl:template match="swrlx:differentIndividualsAtom">
        <xsl:call-template name="ignore_element"/>  
    </xsl:template>
    
    <!-- .................................................................... -->
    <!-- Builtin atoms provide an interface to the built-ins.
        
        element swrlx:builtinAtom:        
        <swrlx:builtinAtom swrlx:builtin = xsd:anyURI {required} >
          Content: ( swrlx:dObject* )
        </swrlx:builtinAtom>        
        Attribute: 	swrlx:builtin - a reference to a built-in defined in Section 8 (w3c swrl submission)
        
        example:
            <swrlx:builtinAtom swrlx:builtin="&swrlb;#multiply">
                <ruleml:var>inches</ruleml:var>
                <ruleml:var>feet</ruleml:var>
                <owlx:DataValue owlx:datatype="&xsd;#int">12</owlx:DataValue>
            </swrlx:builtinAtom>
            
        example:
             <swrlx:builtinAtom  swrlx:builtin="&swrlb;#greaterThanOrEqual">
                 <ruleml:var>total</ruleml:var>
                 <owlx:DataValue owlx:datatype="&xsd;#int">500</owlx:DataValue>
             </swrlx:builtinAtom>
                      
        swrlx:builtinAtom will be maped to RIF Atom/Expr. swrlx:builtinAtom will be maped to a 
        rif-builtin-predicate or rif-builtin-function 
        rif predicate is Atom. RIF function is Expr.
        
        Prefix( func <http://www.w3.org/2007/rif-builtin-function#> ). This prefix expands into a URI used for RIF builtin functions.
        Prefix( pred <http://www.w3.org/2007/rif-builtin-predicate#> ). This is the prefix used for RIF builtin predicates. 
        swrlb namespace is http://www.w3.org/2003/11/swrlb
        
        list of swlr builtins can be be find in w3c swrl page.
        for now, just some of Math biultins will be mapped to RIF builtins. the rest of builtins
        can be added later.        
        Math Built-Ins:
        1. swrlb:add
        2. swrlb:subtract
        3. swrlb:multiply
        4. swrlb:divide
        will be maped to func:numeric-add, func:numeric-subtract, func:numeric-multiply, func:numeric-divide.
        builtin template can be written in a separate xsl and be imported here.
    -->
    <xsl:template match="swrlx:builtinAtom">
        <xsl:if test="@swrlx:builtin='&swrlb;#add' or @swrlx:builtin='&swrlb;#subtract' or @swrlx:builtin='&swrlb;#multiply' or @swrlx:builtin='&swrlb;#divide'">           
            <!-- check if builtin is a direct child of head/body or is an argument to Atom/Expr. 
            to add <formula> tag or not -->
            <xsl:choose>
                <xsl:when test="parent::ruleml:_head or parent::ruleml:_body">
                   <formula>
                       <External>
                           <content>
                               <Expr>
                                   <op>
                                       <!-- determine name of the builtin -->
                                       <xsl:choose>
                                           <xsl:when test="@swrlx:builtin='&swrlb;#add'"><Const type="&rif;iri">http://www.w3.org/2007/rif-builtin-function#numeric-add</Const></xsl:when>
                                           <xsl:when test="@swrlx:builtin='&swrlb;#subtract'"><Const type="&rif;iri">http://www.w3.org/2007/rif-builtin-function#numeric-subtract</Const></xsl:when>
                                           <xsl:when test="@swrlx:builtin='&swrlb;#multiply'"><Const type="&rif;iri">http://www.w3.org/2007/rif-builtin-function#numeric-multiply</Const></xsl:when>
                                           <xsl:when test="@swrlx:builtin='&swrlb;#divide'"><Const type="&rif;iri">http://www.w3.org/2007/rif-builtin-function#numeric-divide</Const></xsl:when>            
                                       </xsl:choose> 
                                   </op>
                                   <args ordered="yes">
                                       <xsl:apply-templates/>
                                   </args>
                               </Expr>
                           </content>
                       </External>      
                   </formula>
                </xsl:when>
                <xsl:otherwise>
                    <External>
                        <content>
                            <Expr>
                                <op>
                                    <!-- determine name of the builtin -->
                                    <xsl:choose>
                                        <xsl:when test="@swrlx:builtin='&swrlb;#add'"><Const type="&rif;iri">http://www.w3.org/2007/rif-builtin-function#numeric-add</Const></xsl:when>
                                        <xsl:when test="@swrlx:builtin='&swrlb;#subtract'"><Const type="&rif;iri">http://www.w3.org/2007/rif-builtin-function#numeric-subtract</Const></xsl:when>
                                        <xsl:when test="@swrlx:builtin='&swrlb;#multiply'"><Const type="&rif;iri">http://www.w3.org/2007/rif-builtin-function#numeric-multiply</Const></xsl:when>
                                        <xsl:when test="@swrlx:builtin='&swrlb;#divide'"><Const type="&rif;iri">http://www.w3.org/2007/rif-builtin-function#numeric-divide</Const></xsl:when>            
                                    </xsl:choose> 
                                </op>
                                <args ordered="yes">
                                    <xsl:apply-templates/>
                                </args>
                            </Expr>
                        </content>
                    </External> 
                </xsl:otherwise>
            </xsl:choose>
        </xsl:if>
    </xsl:template>
    <!-- .................................................................... -->
    <xsl:template name="owlx:DataRestriction">
        <xsl:call-template name="ignore_element"/>  
    </xsl:template>
    
    <xsl:template name="owlx:ObjectRestriction">
        <xsl:call-template name="ignore_element"/>  
    </xsl:template>
   
    <xsl:template name="owlx:OneOf">
        <xsl:call-template name="ignore_element"/>  
    </xsl:template>
    
    <xsl:template name="owlx:UnionOf">
        <xsl:call-template name="ignore_element"/>  
    </xsl:template>
    
    <xsl:template name="owlx:IntersectionOf">
        <xsl:call-template name="ignore_element"/>  
    </xsl:template>
     
    <xsl:template name="owlx:ComplementOf">
        <xsl:call-template name="ignore_element"/>  
    </xsl:template>
    
    <!-- .................................................................... -->
    <!-- swrlx:iObject
        
          Content: ( owlx:Individual[ID] | ruleml:var[ID] )  
    -->
    <xsl:template name="iObject"> 
        <xsl:apply-templates select="current()"/>
        <!--  
        <xsl:if test="name()='ruleml:var'">
            <xsl:apply-templates select="ruleml:var"/>
        </xsl:if>
        <xsl:if test="name()='owlx:Individual'">
            <xsl:apply-templates select="owlx:Individual"/>
        </xsl:if>
        -->
    </xsl:template>
    
    <!-- .................................................................... -->
    <!-- swrlx:dObject
        
        Content: ( owlx:DataValue | ruleml:var[ID] ) 
        
        ruleml:var[ID] can be processed in iObject template.
    -->
    <xsl:template name="dObject">
        <xsl:apply-templates select="current()"/>
        <!--
        <xsl:if test="name()='owlx:DataValue'">
            <xsl:apply-templates select="owlx:DataValue"/>
        </xsl:if>
        if node is not swrlx:datavaluedPropertyAtom 
        <xsl:if test="name()='ruleml:var'">
            <xsl:apply-templates select="ruleml:var"/>
        </xsl:if>
        -->
    </xsl:template>
    
    <!-- .................................................................... -->
    <!-- <DataValue  datatype = xsd:anyURI>
             Content: (#CDATA)
         </DataValue>    
         
        Example 2_6-2 (L,D,F):
            <owlx:Individual>
              <owlx:type owlx:name="Measurement" /> 
              <owlx:DataPropertyValue owlx:property="timeStamp">
                <owlx:DataValue 
                  owlx:datatype="&xsd;dateTime">2003-01-24T09:00:08+01:00</owlx:DataValue>
              </owlx:DataPropertyValue>
            </owlx:Individual>
            
        owlx:DataValue is mapped to Const in RIF  
    -->
    <xsl:template match="owlx:DataValue">         
        <Const type="@owlx:datatype">
            <xsl:attribute name="type"><xsl:value-of select="@owlx:datatype"/></xsl:attribute>
            <xsl:value-of select="text()"/>
        </Const>
    </xsl:template>
    
    <!-- .................................................................... -->
    <!-- element Individual[ID]:                    
            <Individual
              name = xsd:anyURI {required} 
              type = xsd:anyURI 
            >
              Content: (##empty)
            </Individual>
        Individual is mapped to Const in RIF    
    -->
    <xsl:template match="owlx:Individual">
        <Const type="&rif;iri"><xsl:value-of select="@owlx:name"/></Const>
    </xsl:template>
    
    
    
    
    
    <!-- .................................................................... -->
    <xsl:template name="ignore_element">
        <xsl:element name="{local-name()}">ignored.</xsl:element>
    </xsl:template>
    <!-- .................................................................... -->
   
    <!--  Except <ruleml:imp> and <ruleml:var> other children of  <swrlx:Ontology> are the ontology part (not rule) and will be ignored -->
    <xsl:template match="*">
      <!--   this is correct too: <xsl:template match="swrlx:Ontology/*[not(self::ruleml:imp or self::ruleml:var)]"> --> 
        <xsl:element name="{local-name()}" >ignored.</xsl:element>
    </xsl:template>
    
    <!-- .................................................................... -->
    
    
</xsl:stylesheet>
