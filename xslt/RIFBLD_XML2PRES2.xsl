<?xml version="1.0" encoding="UTF-8"?>


<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  
    xmlns:xd="http://www.oxygenxml.com/ns/doc/xsl"
    xmlns:rif="http://www.w3.org/2007/rif#"
    xmlns="http://www.w3.org/2007/rif#"
    
	exclude-result-prefixes="rif"
    version="1.0">
    
    <xsl:output method="text" indent="yes"/>
    
  
    <!-- .......................................................................... -->
    
    <!-- Note that all the transforms are based on the RID-BLD XML Schema files (BLDRule.xsd and BLDCond.xsd) from w3c Website.
    	I mainly used this link https://www.w3.org/TR/rif-bld/#Mapping_from_the_Presentation_Syntax_to_the_XML_Syntax as a reference to develop this xslt.
     	
     	IRIMETA is not implemented yet.
     	check for IRIMETA tag :
		   	<xsl:choose>	        
		         <xsl:when test="check for IRIMETA tag">
		        	<xsl:apply-templates  select="rif:IRIMETA"/>
		         </xsl:when>
		     </xsl:choose>	  	
		  
    -->
    
    
    <!-- .................general elements and attributes.......................... -->
    
    					
    					<!--  THIS PART COVERS BLDRule.xsd -->
    <!-- .......................................................................... -->
    
    <!--   </xsl:template match="Document">  works when the document tag has no property.  
	 Document  ::= IRIMETA? 'Document' '(' Base? Prefix* Import* Group? ')'
	 
     <xs:element name="Document">  
	    <xs:complexType>
	      <xs:sequence>
	        <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
	        <xs:element ref="directive" minOccurs="0" maxOccurs="unbounded"/>
	        <xs:element ref="payload" minOccurs="0" maxOccurs="1"/>
	      </xs:sequence>
	    </xs:complexType>
  	</xs:element>
   -->
  
    <xsl:template match="rif:Document"> 
	   	<!-- check for IRIMETA tag
	   	<xsl:choose>	        
	         <xsl:when test="check for IRIMETA tag">
	        	<xsl:apply-templates  select="rif:IRIMETA"/>
	         </xsl:when>
	     </xsl:choose>
	  	
		  -->
		  Document(
			  <xsl:apply-templates  select="rif:directive"/>
			  <xsl:apply-templates  select="rif:payload"/>
		  )
    </xsl:template>        
    
    
    <!-- ................................................................................... -->
    <!-- 
    	Base and Prefix represented directly in XML
	  <xs:element name="directive">
	    <xs:complexType>
	      <xs:sequence>
	        <xs:element ref="Import"/>
	      </xs:sequence>
	    </xs:complexType>
	  </xs:element>
    -->
    
     <xsl:template match="rif:directive">
     	<!-- in directive-->   
     	<xsl:apply-templates  select="rif:Import"/>
    </xsl:template>   
    
    <!-- ................................................................................... -->    
      <!--
	  Import    ::= IRIMETA? 'Import' '(' LOCATOR PROFILE? ')'
	  LOCATOR   ::= ANGLEBRACKIRI
	  PROFILE   ::= ANGLEBRACKIRI
	    
	    <xs:element name="Import">	  
	    <xs:complexType>
	      <xs:sequence>
	        <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/> 
	        <xs:element ref="location"/>
	        <xs:element ref="profile" minOccurs="0" maxOccurs="1"/>
	      </xs:sequence>
	    </xs:complexType>
	  </xs:element>
    -->
     <xsl:template match="rif:Import">
     	<!-- check for IRIMETA tag -->
     	Import ( 
     		<xsl:apply-templates  select="rif:location"/>
     		 <xsl:text> </xsl:text> <!-- to add space --> 
     		<xsl:apply-templates  select="rif:profile"/>
     	)
    </xsl:template>   
    
    <!-- ................................................................................... -->
    <!-- 
    	<xs:element name="location" type="xs:anyURI"/>
     -->
    <xsl:template match="rif:location">
     	<xsl:value-of select="text()"/>
    </xsl:template>   
    
    <!-- ................................................................................... -->
    
     <!-- 
    	<xs:element name="profile" type="xs:anyURI"/>
     -->
    <xsl:template match="rif:profile">
     	<xsl:value-of select="text()"/>
    </xsl:template>   
    
    <!-- ................................................................................... -->
    <!-- 
    	payload::= Group ?
	  <xs:element name="payload">
	    <xs:complexType>
	      <xs:sequence>
	        <xs:element ref="Group"/>
	      </xs:sequence>
	    </xs:complexType>
	  </xs:element>
  	-->
  	 <xsl:template match="rif:payload">
     	<xsl:apply-templates  select="rif:Group"/>
    </xsl:template>  
    
    <!-- ................................................................................... -->    
    <!--
  		Group     ::= IRIMETA? 'Group' '(' (RULE | Group)* ')'   
    
    <xs:element name="Group">   
		 <xs:complexType>
		    <xs:sequence>
		      <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
		      <xs:element ref="sentence" minOccurs="0" maxOccurs="unbounded"/>
		    </xs:sequence>
		  </xs:complexType>
	</xs:element>
 	 -->
	 <xsl:template match="rif:Group">
	 	<!-- check for IRIMETA tag -->
	 	Group(
	     	<xsl:apply-templates  select="rif:sentence"/>
     	)
    </xsl:template> 
    <!-- ................................................................................... -->
    <!-- 
		<xs:element name="sentence">
			<xs:complexType>
			  <xs:choice>
			    <xs:group ref="RULE"/>
			   <xs:element ref="Group"/>
			    </xs:choice>
			  </xs:complexType>
		</xs:element>
 	 -->
 	 <xsl:template match="rif:sentence">
	 	<xsl:choose>	        
		   <xsl:when test="rif:Group">
				<xsl:apply-templates  select="rif:Group"/>
		    </xsl:when>
		    <xsl:otherwise>
		    	<xsl:call-template  name="rif:RULE"/>
		    </xsl:otherwise>
		</xsl:choose>
    </xsl:template> 
    
    <!-- ................................................................................... -->
    <!--
  		RULE      ::= (IRIMETA? 'Forall' Var+ '(' CLAUSE ')') | CLAUSE
	    
	    <xs:group name="RULE">	   
	    <xs:choice>
	      <xs:element ref="Forall"/>
	      <xs:group ref="CLAUSE"/>
	    </xs:choice>
	  </xs:group>
	-->
	 <xsl:template name="rif:RULE">	 	
		<xsl:choose>	        
		   <xsl:when test="rif:Forall">
				<xsl:apply-templates  select="rif:Forall"/>
		    </xsl:when>
		    <xsl:otherwise>
		    	<xsl:call-template  name="rif:CLAUSE"/>		    	
		    </xsl:otherwise>
		</xsl:choose>	
    </xsl:template> 
	   	
    <!-- ................................................................................... -->
    <!-- 
    different from formula in And, Or and Exists 
    there are two fomrula template defined. one for Forall and another one for fomrula in BLDCond (And, Or, ...)
    
    forall is the first alternative in the RULE template:
     Forall ::= (IRIMETA? 'Forall' Var+ '(' CLAUSE ')')
     
    <xs:element name="Forall">
		 <xs:complexType>
		   <xs:sequence>
		     <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
		     <xs:element ref="declare" minOccurs="1" maxOccurs="unbounded"/>
		    
		     <xs:element name="formula">
		       <xs:complexType>
		         <xs:group ref="CLAUSE"/>
		        </xs:complexType>
		      </xs:element>
		    </xs:sequence>
		  </xs:complexType>
	</xs:element>
  	-->
  	<xsl:template match="rif:Forall">	 
  		<!-- check for IRIMETA tag -->	
  		Forall 
     	<xsl:apply-templates  select="rif:declare"/>
     	(
     	<xsl:apply-templates  select="rif:formula" mode="Forall"/>
     	)     	
    </xsl:template> 
    <!-- 
    <xsl:template  name="rif:formula-CLAUSE">
    	<xsl:choose>	        
		   <xsl:when test="rif:formula">
		   		in rif:formula-CLAUSE
				<xsl:call-template  name="rif:CLAUSE"/>
		    </xsl:when>		   
		</xsl:choose>	    
    </xsl:template>
    -->
    <!-- ................................................................................... -->
    
     <xsl:template match="rif:declare">	
      	<xsl:apply-templates select="rif:Var"/>
      </xsl:template>
      
    <!-- ................................................................................... -->
    
    <xsl:template match="rif:Var">
    	 <!-- check for IRIMETA tag -->
    	 ?<xsl:value-of select="text()" />
	</xsl:template> 
	
	<!-- ................................................................................... -->
    
    <xsl:template match="rif:formula" mode="Forall">
    	<xsl:call-template  name="rif:CLAUSE"/>
	</xsl:template> 
	
	<!-- ................................................................................... -->
    <!--
    	Implies is rule and ATOMIC is fact.
 		CLAUSE   ::= Implies | ATOMIC
    
    <xs:group name="CLAUSE">  	 
	    <xs:choice>
	      <xs:element ref="Implies"/>
	      <xs:group ref="ATOMIC"/>
	    </xs:choice>
	</xs:group>
	
	<xsl:template name="rif:CLAUSE"> 		
	   	<xsl:choose>	        
		   <xsl:when test="rif:Implies">
				<xsl:apply-templates  select="rif:Implies"/>
		    </xsl:when>
		    <xsl:otherwise>
		    	<xsl:call-template  name="rif:ATOMIC"/>
		    </xsl:otherwise>
		</xsl:choose>	    	
    </xsl:template> 
    -->
    <xsl:template name="rif:CLAUSE"> 
		<xsl:apply-templates  select="rif:Implies"/>		
		<xsl:call-template  name="rif:ATOMIC"/>
    </xsl:template> 
    <!-- ................................................................................... -->
    <!-- 
    	Implies   ::= IRIMETA? (ATOMIC | 'And' '(' ATOMIC* ')') ':-' FORMULA
    	<xs:element name="Implies">
		    <xs:complexType>
		      <xs:sequence>
		        <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
		        <xs:element ref="if"/>
		        <xs:element ref="then"/>
		      </xs:sequence>
		    </xs:complexType>
	  </xs:element>
     -->
    <xsl:template match="rif:Implies">	 
  		<!-- check for IRIMETA tag -->	
     	<xsl:apply-templates  select="rif:then"/>
     	:-
     	<xsl:apply-templates  select="rif:if"/>
    </xsl:template>  
    
    <!-- ................................................................................... -->
    <!-- 
    	<xs:element name="if">
		    <xs:complexType>
		      <xs:sequence>
		        <xs:group ref="FORMULA"/>
		      </xs:sequence>
		    </xs:complexType>
		</xs:element>
     -->
     <xsl:template match="rif:if">
     	<xsl:call-template  name="rif:FORMULA"/>
    </xsl:template>  
    <!-- ................................................................................... -->
    
    <!-- 
    	<xs:element name="then">
		    <xs:complexType>
		     <xs:choice>
		       <xs:group ref="ATOMIC"/>
		       <xs:element name="And" type="And-then.type"/>
		     </xs:choice>
		    </xs:complexType>
	 	</xs:element>
	 
	  	<xs:complexType name="And-then.type">
		    comment: sensitive to then (ATOMIC) context
		    <xs:sequence>
		      <xs:element name="formula" type="formula-then.type" minOccurs="0" maxOccurs="unbounded"/>
		    </xs:sequence>
	  	</xs:complexType>
	 
	  	<xs:complexType name="formula-then.type">
		    comment: sensitive to then (ATOMIC) context
		    <xs:sequence>
		      <xs:group ref="ATOMIC"/>
		    </xs:sequence>
	  	</xs:complexType>
     -->
    <xsl:template match="rif:then">	
	   	<xsl:choose>	        
	   		<!--  if it had <And> tag -->
		   <xsl:when test="rif:And">		   		
				And (	   		
					<xsl:apply-templates  select="rif:And" mode="And-then"/>
				)
		    </xsl:when>
		    <xsl:otherwise>
		    	<xsl:call-template  name="rif:ATOMIC"/>
		    </xsl:otherwise>
		</xsl:choose>	    	
    </xsl:template>
     
    <!-- .......................................................................... -->  
    <!-- 
   		<xs:complexType name="And-then.type">
		    comment: sensitive to then (ATOMIC) context
		    <xs:sequence>
		      <xs:element name="formula" type="formula-then.type" minOccurs="0" maxOccurs="unbounded"/>
		    </xs:sequence>
	  	</xs:complexType>
	 
	  	<xs:complexType name="formula-then.type">
		    comment: sensitive to then (ATOMIC) context
		    <xs:sequence>
		      <xs:group ref="ATOMIC"/>
		    </xs:sequence>
	  	</xs:complexType>
     -->
     <xsl:template match="rif:And" mode="And-then">
     	<xsl:apply-templates  select="rif:formula" mode="formula-then"/>
    </xsl:template>  
    
     <!-- .......................................................................... -->  
    <!--    		
	 
	  	<xs:complexType name="formula-then.type">
		    comment: sensitive to then (ATOMIC) context
		    <xs:sequence>
		      <xs:group ref="ATOMIC"/>
		    </xs:sequence>
	  	</xs:complexType>
     -->
     <xsl:template match="rif:formula" mode="formula-then">
     	<xsl:call-template  name="rif:ATOMIC"/>
    </xsl:template>  
    
    <!-- .......................................................................... -->
    
     					<!--  THIS PART COVERS BLDCond.xsd -->
     					
    <!-- ................................................................................... -->
    
    <!-- 
   		 FORMULA ::= IRIMETA? 'And' '(' FORMULA* ')' |
                     IRIMETA? 'Or' '(' FORMULA* ')' |
                     IRIMETA? 'Exists' Var+ '(' FORMULA ')' |
                     ATOMIC |
                     IRIMETA? 'External' '(' Atom ')'
                     
    	<xs:group name="FORMULA">  
		    <xs:choice>
		      <xs:element ref="And"/>
		      <xs:element ref="Or"/>
		      <xs:element ref="Exists"/>
		      <xs:group ref="ATOMIC"/>
		      <xs:element name="External" type="External-FORMULA.type"/>
		    </xs:choice>
	  </xs:group>
     -->
      <xsl:template name="rif:FORMULA">	 
      	<!-- check for IRIMETA tag -->			
	   	<xsl:choose>	        	   		
		   <xsl:when test="rif:And">		   		
				<xsl:apply-templates select="rif:And"/>
		    </xsl:when>
		     <xsl:when test="rif:Or">		   		
				<xsl:apply-templates select="rif:Or"/>
		    </xsl:when>
		     <xsl:when test="rif:Exists">		   		
				<xsl:apply-templates select="rif:Exists"/>
		    </xsl:when>
		     <xsl:when test="rif:External">		   		
				<xsl:apply-templates select="rif:External" mode="External-FORMULA"/>
		    </xsl:when>
		    <xsl:otherwise>
		    	<xsl:call-template  name="rif:ATOMIC"/>
		    </xsl:otherwise>
		</xsl:choose>	    	
    </xsl:template>  
    
   <!-- ................................................................................... -->
    
    <!-- 
    	from FORMULA
    	FORMULA ::=  IRIMETA? 'External' '(' Atom ')'
    	
    	<xs:complexType name="External-FORMULA.type">    
		    <xs:sequence>
		      <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
		      <xs:element name="content" type="content-FORMULA.type"/>
		    </xs:sequence>
	  	</xs:complexType>
     -->
      <xsl:template match="rif:External" mode="External-FORMULA">	 
      	<!-- check for IRIMETA tag -->
      	External (
      	<xsl:apply-templates select="rif:content" mode="content-FORMULA"/>
      	)		
      </xsl:template>
      
    <!-- ................................................................................... -->    
    
     <xsl:template match="rif:content" mode="content-FORMULA">	
      	<xsl:apply-templates select="rif:Atom"/>
      </xsl:template>
      
    <!-- ................................................................................... -->
    <!-- 
    	from FORMULA
    	 FORMULA ::= IRIMETA? 'And' '(' FORMULA* ')' 
    	 
    	 <xs:element name="And">
		    <xs:complexType>
		      <xs:sequence>
		        <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
		        <xs:element ref="formula" minOccurs="0" maxOccurs="unbounded"/>
		      </xs:sequence>
		    </xs:complexType>
		 </xs:element>
    	
     -->
      <xsl:template match="rif:And">      
      	<!-- check for IRIMETA tag -->
      	And (	
      	<xsl:apply-templates select="rif:formula"/>
      	)
      </xsl:template>
      
      <!-- ................................................................................... -->
    
    <!-- 
    	from FORMULA
    	 FORMULA ::= IRIMETA? 'Or' '(' FORMULA* ')' 
    	 
    	 <xs:element name="Or">
		    <xs:complexType>
		      <xs:sequence>
		        <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
		        <xs:element ref="formula" minOccurs="0" maxOccurs="unbounded"/>
		      </xs:sequence>
		    </xs:complexType>
		  </xs:element>
    	
     -->
     <xsl:template match="rif:Or">
      
      	<!-- check for IRIMETA tag -->
      	Or (	
      	<xsl:apply-templates select="rif:formula"/>
      	)
      </xsl:template>
      
    <!-- ................................................................................... -->
    
    <!-- 
    	from FORMULA
    	  IRIMETA? 'Exists' Var+ '(' FORMULA ')' 
    	  
    	  <xs:element name="Exists">
		    <xs:complexType>
		      <xs:sequence>
		        <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
		        <xs:element ref="declare" minOccurs="1" maxOccurs="unbounded"/>
		        <xs:element ref="formula"/>
		      </xs:sequence>
		    </xs:complexType>
		  </xs:element>
    	
     -->
      <xsl:template match="rif:Exists">	
      	<!-- check for IRIMETA tag -->
      	Exists 
      	<xsl:apply-templates select="rif:declare"/>
      	(
      	<xsl:apply-templates select="rif:formula"/>
      	)
      </xsl:template>
    
    <!-- ................................................................................... -->   
    <!-- 
    	<xs:element name="formula">
		    <xs:complexType>
		      <xs:sequence>
		        <xs:group ref="FORMULA"/>
		      </xs:sequence>
		    </xs:complexType>
		  </xs:element>
    	
     -->  
    <xsl:template match="rif:formula">
      	<xsl:call-template name="rif:FORMULA"/>
      </xsl:template>
          
    <!-- ................................................................................... -->
  	  <!-- 
    	 ATOMIC         ::= IRIMETA? (Atom | Equal | Member | Subclass | Frame)
    	
    	<xs:group name="ATOMIC">
		    <xs:choice>
		      <xs:element ref="Atom"/>
		      <xs:element ref="Equal"/>
		      <xs:element ref="Member"/>
		      <xs:element ref="Subclass"/>
		      <xs:element ref="Frame"/>
		    </xs:choice>
		 </xs:group>
     -->
      <xsl:template name="rif:ATOMIC">	 
      	<!-- check for IRIMETA tag -->			
	   	<xsl:choose>	        	   		
		    <xsl:when test="rif:Atom">		   		
				<xsl:apply-templates select="rif:Atom"/>
		    </xsl:when>
		   <xsl:when test="rif:Equal">		   		
				<xsl:apply-templates select="rif:Equal"/>
		    </xsl:when>
		     <xsl:when test="rif:Member">		   		
				<xsl:apply-templates select="rif:Member"/>
		    </xsl:when>
		     <xsl:when test="rif:Subclass">		   		
				<xsl:apply-templates select="rif:Subclass"/>
		    </xsl:when>
		     <xsl:when test="rif:Frame">		   		
				<xsl:apply-templates select="rif:Frame"/>
		    </xsl:when>
		    <!-- <xsl:otherwise>
		    	<xsl:apply-templates  select="rif:Atom"/>
		    </xsl:otherwise>-->
		</xsl:choose>	    	
    </xsl:template>  
    
     <!-- ................................................................................... -->
    
    <!--
  		Atom           ::= UNITERM
  		
  		<xs:element name="Atom">
		    <xs:complexType>
		      <xs:sequence>
		        <xs:group ref="UNITERM"/>
		      </xs:sequence>
		    </xs:complexType>
		  </xs:element>  
    -->
     <xsl:template match="rif:Atom">	
      	<xsl:call-template name="rif:UNITERM"/>
      </xsl:template>
    
    <!-- ................................................................................... -->
    <!--
  		UNITERM        ::= Const '(' (TERM* | (Name '->' TERM)*) ')'
   
	    <xs:group name="UNITERM">    
		    <xs:sequence>
		      <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
		      <xs:element ref="op"/>
		      <xs:choice>
		        <xs:element ref="args" minOccurs="0" maxOccurs="1"/>
		        <xs:element name="slot" type="slot-UNITERM.type" minOccurs="0" maxOccurs="unbounded"/>
		      </xs:choice>
		    </xs:sequence>
	  	</xs:group>
  	 -->
  	  <xsl:template name="rif:UNITERM">	
  	  	<!-- check for IRIMETA tag -->
      	<xsl:apply-templates select="rif:op"/>
      	(
      	  <xsl:apply-templates select="rif:args"/>		   	   		
		  <xsl:apply-templates select="rif:slot" mode="slot-UNITERM"/>		  
      	)
      </xsl:template>
    
     <!-- ................................................................................... --> 
    <!-- 
    	<xs:element name="op">
		    <xs:complexType>
		      <xs:sequence>
		        <xs:element ref="Const"/>
		      </xs:sequence>
		    </xs:complexType>
	  	</xs:element>
     -->   
     <xsl:template match="rif:op">
     	<xsl:apply-templates select="rif:Const"/>
     </xsl:template>	
    
    
     <!-- ................................................................................... -->
    <!-- 
    	Const          ::= '"' UNICODESTRING '"^^' SYMSPACE | CONSTSHORT    	
		
		<Const type="symspace">unicodestring</Const>
		
		is converted to 
		
		"unicodestring"^^symspace
		
    	<xs:element name="Const">
		    <xs:complexType mixed="true">
		      <xs:sequence>
		        <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
		      </xs:sequence>
		      <xs:attribute name="type" type="xs:anyURI" use="required"/> 
		      <xs:attribute ref="xml:lang"/>
		    </xs:complexType>
	   </xs:element>
     -->
    
       <xsl:template match="rif:Const">
       	 <!-- check for IRIMETA tag -->
     	 "<xsl:value-of select="text()" />"^^<xsl:value-of select='@type'/>     	 
     </xsl:template> 
     
     
      <!-- ................................................................................... -->
    <!-- 
    	since attribute 'ordered' is always 'yes' it is ignored. it means that the order of the arguments
    	should be kept. 
    	<xs:element name="args">
		    <xs:complexType>
		      <xs:sequence>
		        <xs:group ref="TERM" minOccurs="1" maxOccurs="unbounded"/>
		      </xs:sequence>
		      <xs:attribute name="ordered" type="xs:string" fixed="yes"/>
		    </xs:complexType>
	  	</xs:element>
     -->
      <xsl:template match="rif:args">     
      	<xsl:for-each select="*">
      		<xsl:call-template name="rif:TERM"/>
      	</xsl:for-each> 	
     	
     </xsl:template>    
    
    <!-- ................................................................................... -->
    <!-- 
    	slot uniterm:
    	Name -> Term
    
    	<xs:complexType name="slot-UNITERM.type">
		    <xs:sequence>
		      <xs:element ref="Name"/>
		      <xs:group ref="TERM"/>
		    </xs:sequence>
		    <xs:attribute name="ordered" type="xs:string" fixed="yes"/>
		 </xs:complexType>
     -->
     <xsl:template match="rif:slot" mode="slot-UNITERM">
     	<xsl:apply-templates select="rif:Name"/> <xsl:text> </xsl:text> -> <xsl:text> </xsl:text> <xsl:call-template name="rif:TERM"/> <xsl:text> </xsl:text>
     </xsl:template>
     
      <!-- ................................................................................... -->
     <!--
  		Equal          ::= TERM '=' TERM
    
	    <xs:element name="Equal">	   
		    <xs:complexType>
		      <xs:sequence>
		        <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
		        <xs:element ref="left"/>
		        <xs:element ref="right"/>
		      </xs:sequence>
		    </xs:complexType>
	  </xs:element>
  	-->
  	 <xsl:template match="rif:Equal">
  	 	<!-- check for IRIMETA tag -->
     	<xsl:apply-templates select="rif:left"/>
     	=
     	<xsl:apply-templates select="rif:right"/>
     </xsl:template> 
     
      <!-- ................................................................................... -->
    <!-- 
    	Member         ::= TERM '#' TERM
    	
    	<xs:element name="Member">
	    	<xs:complexType>
		      <xs:sequence>
		        <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
		        <xs:element ref="instance"/>
		        <xs:element ref="class"/>
		      </xs:sequence>
		    </xs:complexType>
	  </xs:element>
     -->
      <xsl:template match="rif:Member">
      	<!-- check for IRIMETA tag -->
     	<xsl:apply-templates select="rif:instance"/>
     	#
     	<xsl:apply-templates select="rif:class"/>
     </xsl:template>
     
     <!-- ................................................................................... -->
    <!-- 
    	Subclass       ::= TERM '##' TERM
    	
    	<xs:element name="Subclass">
		    <xs:complexType>
		      <xs:sequence>
		        <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
		        <xs:element ref="sub"/>
		        <xs:element ref="super"/>
		      </xs:sequence>
		    </xs:complexType>
	   </xs:element>
     -->
       <xsl:template match="rif:Subclass">
      	<!-- check for IRIMETA tag -->
     	<xsl:apply-templates select="rif:sub"/>
     	##
     	<xsl:apply-templates select="rif:super"/>
     </xsl:template>
     
     
     <!-- ................................................................................... -->
    <!--
  		Frame          ::= TERM '[' (TERM '->' TERM)* ']'
  		
	    <xs:element name="Frame">
	    <xs:complexType>
	      <xs:sequence>
	        <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
	        <xs:element ref="object"/>
	        <xs:element name="slot" type="slot-Frame.type" minOccurs="0" maxOccurs="unbounded"/>
	      </xs:sequence>
	    </xs:complexType>
	  </xs:element>
	-->
	<xsl:template match="rif:Frame">
		<!-- check for IRIMETA tag -->
     	<xsl:apply-templates select="rif:object"/>
     	[
     	<xsl:apply-templates select="rif:slot" mode="slot-Frame"/>
     	]
     </xsl:template> 
     
    <!-- ................................................................................... -->
    <!-- 
    	<xs:complexType name="slot-Frame.type">
		    <xs:sequence>
		      <xs:group ref="TERM"/>
		      <xs:group ref="TERM"/>
		    </xs:sequence>
		    <xs:attribute name="ordered" type="xs:string" fixed="yes"/>
	    </xs:complexType>
     -->
       <xsl:template match="rif:slot" mode="slot-Frame">
       	<xsl:for-each select="*">
	        <xsl:if test="position()=1">
				<!-- <xsl:call-template name="rif:TERM-slot-Frame"/> -> -->
				<xsl:call-template name="rif:TERM"/> ->
			</xsl:if>
			<xsl:if test="position()=2">
				<!-- <xsl:call-template name="rif:TERM-slot-Frame"/> -->
				<xsl:call-template name="rif:TERM"/>
			</xsl:if>		
		</xsl:for-each>      
     </xsl:template>  
    <!-- ................................................................................... -->
    <!-- 
    	TERM           ::= IRIMETA? (Const | Var | Expr | List | 'External' '(' Expr ')')
    	
    	NOTE: the order of a predicate arguments should be kept  
    	
    	<xs:group name="TERM"> 
	      <xs:choice>
	         <xs:element ref="Const"/>
	         <xs:element ref="Var"/>
	         <xs:element ref="Expr"/>
	         <xs:element ref="List"/>
	         <xs:element name="External" type="External-TERM.type"/>
	      </xs:choice>
	    </xs:group>
     
     <xsl:template name="rif:TERM" > 
		<xsl:apply-templates select="rif:Var"/>
		<xsl:apply-templates select="rif:Const"/> 	
		<xsl:apply-templates select="rif:Expr"/>
		<xsl:apply-templates select="rif:List"/>  
		<xsl:apply-templates select="rif:External" mode="External-TERM"/> 
     </xsl:template>
 	-->
 	
 	<!-- <xsl:template name="rif:TERM-slot-Frame" > -->
 	<xsl:template name="rif:TERM">
 		<xsl:choose>
 			<xsl:when test="name()='Const'">
 				<xsl:apply-templates select="."/> 
 			</xsl:when>
 			<xsl:when test="name()='Var'">
 				<xsl:apply-templates select="."/>
 			</xsl:when>
 			<xsl:when test="name()='Expr'">
 				<xsl:apply-templates select="."/>
 			</xsl:when>
 			<xsl:when test="name()='List'">
 				<xsl:apply-templates select="."/>
 			</xsl:when>
 			<xsl:when test="name()='External'">
 					<xsl:apply-templates select="." mode="External-TERM"/>
 			</xsl:when>
 		</xsl:choose>				    
     </xsl:template>
     
     <!-- ................................................................................... -->   
    <!-- 
    	 List           ::= 'List' '(' TERM* ')' | 'List' '(' TERM+ '|' TERM ')'
         
         rewritten as
  		 
  		 List           ::= 'List' '(' LISTELEMENTS? ')'
  		 
    	<xs:element name="List">  
		    <xs:complexType>
		      <xs:sequence>
		        <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
		        <xs:group ref="LISTELEMENTS" minOccurs="0" maxOccurs="1"/>
		      </xs:sequence>
		    </xs:complexType>
	    </xs:element>
     --> 
   
    <xsl:template match="rif:List">
    	<!-- check for IRIMETA tag -->
    	List (    	
    	<xsl:call-template name="rif:LISTELEMENTS"/>
    	)    
    </xsl:template>
    
     <!-- ................................................................................... -->
    <!-- 
    	LISTELEMENTS   ::= TERM+ ('|' TERM)?
    	
    	<xs:group name="LISTELEMENTS">
		    <xs:sequence>
		      <xs:element ref="items"/>
		      <xs:element ref="rest" minOccurs="0" maxOccurs="1"/>
		    </xs:sequence>
	  	</xs:group>
     -->
    <xsl:template name="rif:LISTELEMENTS">
    	<xsl:apply-templates select="rif:items"/>
    	<xsl:apply-templates select="rif:rest"/>
    </xsl:template> 
    
    <!-- ................................................................................... -->
    <!-- 
    	LISTELEMENTS   ::= TERM+ ('|' TERM)?
    	items::= TERM+
    	rest::= ('|' TERM)?
    	
    	<xs:element name="items">
		    <xs:complexType>
		      <xs:sequence>
		        <xs:group ref="TERM" minOccurs="1" maxOccurs="unbounded"/>
		      </xs:sequence>
		      <xs:attribute name="ordered" type="xs:string" fixed="yes"/>
		    </xs:complexType>
	 	</xs:element>
     -->
     <xsl:template match="rif:items">
     	<xsl:call-template name="rif:TERM"/>
     </xsl:template>
     
    <!-- ................................................................................... -->
    <!-- 
    		LISTELEMENTS   ::= TERM+ ('|' TERM)?
    	items::= TERM+
    	rest::= ('|' TERM)?
    	
    	<xs:element name="rest">
		    <xs:complexType>
		      <xs:sequence>
		        <xs:group ref="TERM"/>
		      </xs:sequence>
		    </xs:complexType>
		</xs:element>
     -->
     <xsl:template match="rif:rest">
     	| <xsl:call-template name="rif:TERM"/>
     </xsl:template>  
     
   
	<!-- ................................................................................... -->
    <!-- 
    	 <xs:complexType name="External-TERM.type">
		    <xs:sequence>
		      <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
		      <xs:element name="content" type="content-TERM.type"/>
		    </xs:sequence>
		 </xs:complexType>
     -->
     <xsl:template match="rif:External" mode="External-TERM">
     	<!-- check for IRIMETA tag -->
     	External (
     	<xsl:apply-templates select="rif:content" mode="content-TERM"/>
     	)
     </xsl:template>
     
    <!-- ................................................................................... -->
    <!-- 
    	<xs:complexType name="content-TERM.type">
		    <xs:sequence>
		      <xs:element ref="Expr"/>
		    </xs:sequence>
	  	</xs:complexType>
     -->
	<xsl:template match="rif:content" mode="content-TERM">
		<xsl:apply-templates select="rif:Expr"/>
	</xsl:template>
	
     <!-- ................................................................................... -->
     <!--
  		Expr           ::= UNITERM
   
	     <xs:element name="Expr">    
		    <xs:complexType>
		      <xs:sequence>
		        <xs:group ref="UNITERM"/>
		      </xs:sequence>
		    </xs:complexType>
		  </xs:element>    
  	-->
  	 <xsl:template match="rif:Expr">
     	<xsl:call-template name="rif:UNITERM"/>
     </xsl:template>
    
    
     <!-- ................................................................................... --> 
    
    <xsl:template match="rif:left">
     	<xsl:call-template name="rif:TERM"/>
     </xsl:template>     
    
    <xsl:template match="rif:right">
     	<xsl:call-template name="rif:TERM"/>
     </xsl:template> 
     
    <xsl:template match="rif:instance">
     	<xsl:call-template name="rif:TERM"/>
     </xsl:template>     
    
    <xsl:template match="rif:class">
     	<xsl:call-template name="rif:TERM"/>
     </xsl:template> 
     
     <xsl:template match="rif:sub">
     	<xsl:call-template name="rif:TERM"/>
     </xsl:template>     
    
    <xsl:template match="rif:super">
     	<xsl:call-template name="rif:TERM"/>
     </xsl:template>  
      
     <xsl:template match="rif:object">
     	<xsl:call-template name="rif:TERM"/>
     </xsl:template> 
    <!-- ................................................................................... -->
    <!-- 
    	 Name           ::= NCName | '"' UNICODESTRING '"'   
  			... i.e., 'Name' stands for either the NCName string or the UNICODESTRING with the outer quotes stripped off.
    	
    	outer quotes of name should be removed (it is assumed that name has double quotes around it).
 
    	<xs:element name="Name" type="xs:string">
  		</xs:element>
     -->
    <xsl:template match="rif:Name">
     	 <xsl:value-of select="text()" />
     	<!-- remove double quotation around the node value.
		<xsl:value-of select="substring(text(), 2, string-length(text())-2)"/>-->
	</xsl:template>
	 
	  
    <!-- ................................................................................... -->
    <!-- ................................................................................... -->
    <!-- ................................................................................... -->
   
    
    <!-- this template is just for test: it removes ALL the TEXT in the tags
    it overwrites the default built-in template     -->
    <xsl:template match="text()">    	
    	
    </xsl:template> 
    
    <!-- /////////////////////end of stylesheet/////////////////////////////////////////////////////////// -->
</xsl:stylesheet>






















