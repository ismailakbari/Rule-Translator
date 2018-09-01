<?xml version="1.0" encoding="UTF-8"?>


<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  
    xmlns:xd="http://www.oxygenxml.com/ns/doc/xsl"
    version="1.0">
    
    <xsl:output method="text"/>
    
   
    <!-- Note that all the transforms are based on the RID-BLD XML Schema files (BLDRule.xsd and BLDCond.xsd) from w3c Website  -->
    
    
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
    <xsl:template match="/">               
        <xsl:apply-templates  select="IRIMETA"/>
        Document(
        	   <xsl:apply-templates  select="directive"/>
        	   <xsl:apply-templates  select="payload"/>
        )	  
    </xsl:template>        
    
    <!-- ................................................................................... -->
    <!--
	    <xs:element name="directive">
	    directive::= Base? Prefix* Import*
		  Base and Prefix represented directly in XML
		   
		    <xs:complexType>
		      <xs:sequence>
		        <xs:element ref="Import"/>
		      </xs:sequence>
		    </xs:complexType>
	  </xs:element>
    -->
      <xsl:template match="directive"> 
      	<xsl:apply-templates  select="Import"/>
      </xsl:template>   
   
    <!-- ................................................................................... -->
    <!-- 
     payload::= Group?
	    <xs:element name="payload">
		    <xs:complexType>
		      <xs:sequence>
		        <xs:element ref="Group"/>
		      </xs:sequence>
		    </xs:complexType>
	  </xs:element>
    --> 
      <xsl:template match="payload"> 
      	<xsl:apply-templates  select="Group"/>
      </xsl:template> 
      
    <!-- ................................................................................... -->
    <!--    
   
	  Import    ::= IRIMETA? 'Import' '(' LOCATOR PROFILE? ')'
	  LOCATOR   ::= ANGLEBRACKIRI
	  PROFILE   ::= ANGLEBRACKIRI
	  -->
	  <!-- 
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
     <xsl:template match="Import"> 
      	<xsl:apply-templates  select="IRIMETA"/>
      	Import (
      		<xsl:apply-templates  select="location"/>
      		<xsl:apply-templates  select="profile"/>
      	)
      </xsl:template> 
      
    <!-- ................................................................................... -->
    
     <xsl:template match="location"> 
     	 <xsl:value-of select="text()"/> 
     </xsl:template> 
    
    <!-- ................................................................................... -->
    
     <xsl:template match="profile"> 
     	 <xsl:value-of select="text()"/> 
     </xsl:template> 
    
    <!-- ................................................................................... -->
    <!-- 
    	Group     ::= IRIMETA? 'Group' '(' (RULE | Group)* ')'
    -->
    <!-- 
    	<xs:element name="Group">    
	    <xs:complexType>
	      <xs:sequence>
	        <xs:group ref="IRIMETA" minOccurs="0" maxOccurs="1"/>
	        <xs:element ref="sentence" minOccurs="0" maxOccurs="unbounded"/>
	      </xs:sequence>
	    </xs:complexType>
	  </xs:element>
     -->
     <xsl:template match="Group"> 
     	<xsl:apply-templates  select="IRIMETA"/>
     	Group(        	
      		<xsl:apply-templates  select="sentence"/>
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
     <xsl:template match="sentence"> 
      	<xsl:apply-templates  select="RULE"/>
      	<xsl:apply-templates  select="Group"/>
      </xsl:template> 
      
    <!-- ................................................................................... -->
    
    <!--   	
  		RULE      ::= (IRIMETA? 'Forall' Var+ '(' CLAUSE ')') | CLAUSE
    -->
     <!--
	    <xs:group name="RULE">
		    <xs:choice>
		      <xs:element ref="Forall"/>
		      <xs:group ref="CLAUSE"/>
		    </xs:choice>
	 	</xs:group>
     -->
      <xsl:template match="RULE">         
      	<xsl:apply-templates  select="Forall"/>
      	<xsl:apply-templates  select="CLAUSE"/>
      </xsl:template> 
    <!-- ................................................................................... --> 
    <!-- 
    Forall is the first choice of the RULE above.
    Forall::= (IRIMETA? 'Forall' Var+ '(' CLAUSE ')')     
     formula here is different from formula in And, Or and Exists 
     
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
     <xsl:template match="Forall">         
      	<xsl:apply-templates  select="IRIMETA"/>
      	<xsl:apply-templates  select="declare"/>
      	<xsl:apply-templates  select="CLAUSE"/>
      </xsl:template> 
      
    <!-- ................................................................................... -->
      <!--
  		CLAUSE   ::= Implies | ATOMIC
    
    	<xs:group name="CLAUSE">    
		    <xs:choice>
		      <xs:element ref="Implies"/>
		      <xs:group ref="ATOMIC"/>
		    </xs:choice>
  	    </xs:group>
    -->
     <xsl:template match="CLAUSE">         
      	<xsl:apply-templates  select="Implies"/>
      	<xsl:apply-templates  select="ATOMIC"/>
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
     <xsl:template match="Implies">         
      	<xsl:apply-templates  select="if"/>
      	<xsl:apply-templates  select="then"/>
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
      <xsl:template match="if">         
      	<xsl:apply-templates  select="FORMULA"/>
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
     -->
      <xsl:template match="then">         
      	<xsl:apply-templates  select="ATOMIC"/>
      	<xsl:apply-templates  select="And-then.type"/>
      </xsl:template>
      
    <!-- ................................................................................... -->
    <!-- sensitive to then (ATOMIC) context
	    <xs:complexType name="And-then.type">		    
		    <xs:sequence>
		      <xs:element name="formula" type="formula-then.type" minOccurs="0" maxOccurs="unbounded"/>
		    </xs:sequence>
	  </xs:complexType>
   -->
     <xsl:template match="And-then.type">         
      	<xsl:apply-templates  select="formula-then.type"/>
      </xsl:template>
      
    <!-- ................................................................................... -->
    <!-- sensitive to then (ATOMIC) context
	  <xs:complexType name="formula-then.type">	    
	    <xs:sequence>
	      <xs:group ref="ATOMIC"/>
	    </xs:sequence>
	  </xs:complexType>
	-->
	<xsl:template match="formula-then.type">         
      	<xsl:apply-templates  select="ATOMIC"/>
      </xsl:template>
    <!-- ................................................................................... -->
    <!-- ................................................................................... -->    
    <!-- ................................................................................... -->
    <!-- ................................................................................... -->
    <!-- ................................................................................... -->
    <!-- ................................................................................... -->    
    <!-- ................................................................................... -->
    <!-- ................................................................................... -->
    <!-- ................................................................................... -->
    <!-- ................................................................................... -->
    <!-- ................................................................................... -->
    <!-- ................................................................................... -->
    <!-- ................................................................................... -->
    <!-- ................................................................................... -->    
    <!-- ................................................................................... -->
    <!-- ................................................................................... -->
    <!-- ................................................................................... -->
    <!-- this template is just for test: it removes ALL the TEXT in the tags
    it overwrites the default built-in template     -->
    <xsl:template match="text()">    	
    	( <xsl:value-of select ="name(parent::node)"/> )
    </xsl:template> 
    
    <!-- //////////////////////////////////////////////////////////////////////////////// -->
</xsl:stylesheet>






















