<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE xsl:stylesheet [ <!ENTITY rif  "http://www.w3.org/2007/rif#"> ]>


<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    exclude-result-prefixes="xd"
    xmlns:ruleml="http://ruleml.org/spec"
    xmlns:xd="http://www.oxygenxml.com/ns/doc/xsl"
    xmlns="http://www.w3.org/2007/rif#"
    
    version="1.0">
    
    <xsl:output method="xml" indent="yes"/>
    
    <xd:doc scope="stylesheet">
        <xd:desc>
            <xd:p><xd:b>Created on:</xd:b> Sep 2, 2016</xd:p>
            <xd:p><xd:b>Author:</xd:b> iakbari</xd:p>
            <xd:p></xd:p>
        </xd:desc>
    </xd:doc>
    
    <!-- .................general elements and attributes.......................... -->
    
    <!-- .......................................................................... -->
   <!-- because ruleml files have a default namespace, therefore xmlns:ruleml namespace
   is added to the list of namespaces in this xslt file. Also all ruleml tages 
   should be searched with the namespace ruleml (added here)
   default namespace is also added to prevent inner tags from
   generating empty namespace xmlns=''. As an alternative You can
   remove the namespace from the <Documnet> tag too.-->
  



    <xsl:template match="ruleml:RuleML">        
        <!-- 
            &lt;!DOCTYPE Document [  
                &lt;!ENTITY rif  "http://www.w3.org/2007/rif#">
            ]>
        -->
        <Document 
            xmlns="http://www.w3.org/2007/rif#"              
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xmlns:xs="http://www.w3.org/2001/XMLSchema#">            
            <payload>      
            	<Group>
            		<sentence>        
		                <xsl:apply-templates  select="ruleml:Assert"/>
		                <xsl:apply-templates  select="ruleml:Retract"/>
		                <xsl:apply-templates  select="ruleml:Query"/>
	                </sentence>
                </Group>
            </payload>            
        </Document>        
    </xsl:template>
    
    <!-- ................................................................................... -->
    <xsl:template match="ruleml:Assert">  
        <xsl:apply-templates select="ruleml:Atom"/>
        <xsl:apply-templates select="ruleml:Implies"/>
        <xsl:apply-templates select="ruleml:Equivalent"/>
        <xsl:apply-templates select="ruleml:Forall"/>
        <xsl:apply-templates select="ruleml:Entails"/>
        <xsl:apply-templates select="ruleml:Rulebase"/>        
    </xsl:template>
    
    <!-- ................................................................................... -->
    <xsl:template match="ruleml:Retract">  
        <Retract>
            in Retract: NOT SUPPORTED.               
        </Retract>                    
    </xsl:template>
    
    <!-- ................................................................................... -->
    <xsl:template match="ruleml:Query">
        <Query>
            in Query: NOT SUPPORTED.              
        </Query>    
    </xsl:template>
    
    <!-- ................................................................................... -->
    <!--
        Aotm { 
          meta*,
          oid?,
          degree?,
          op,
          (arg, arg)?,
          slot*,
          resl?
          }
          maps to uniterm (i.e. maps to Atom and Atom maps to uniterm)
    -->
    <xsl:template match="ruleml:Atom">        
            <Atom>                
                <xsl:call-template name="uniterm"/>               
            </Atom>        
    </xsl:template>
   
    <!-- ................................................................................... -->
    <!--
        rif:uniterm={ 
          IRIMETA?,          
          op,
          (args|
          slot*)
          }
          if all atom children are slot, I consider them uniterm{op, slot*} otherwise uniterm{op, args?}
    -->
    <xsl:template name="uniterm">  
        <!-- <op> might be missing (I guess <op> is optional)-->       
        <xsl:choose>
            <xsl:when test="ruleml:op">
                <xsl:apply-templates select="ruleml:op"/>                
            </xsl:when>
            <xsl:otherwise>
                <!-- if tag <op> is missing-->
                <op>
                    <xsl:apply-templates select="ruleml:Rel"/>
                </op>    
            </xsl:otherwise>
        </xsl:choose>
        <!-- 
        # of non-slot children=<xsl:value-of select="count(*[name()!='slot'])"/> <br/>
        -->
        <xsl:choose>
            <xsl:when test="count(*[name()!='slot'])=1">                    
                <xsl:apply-templates select="ruleml:slot"/>
            </xsl:when>
            <xsl:otherwise>
                <args ordered="yes">
                    <xsl:apply-templates select="*[position()>1]"/>
                </args>    
            </xsl:otherwise>
        </xsl:choose>        
    </xsl:template>
    
    <!-- ................................................................................... -->
    <xsl:template match="ruleml:Implies">
        <Implies>
            <xsl:apply-templates select="ruleml:if"/>
            <xsl:apply-templates select="ruleml:then"/>
        </Implies>
    </xsl:template>
    
    <!-- ................................................................................... -->
    <xsl:template match="ruleml:if">
        <if>
            <xsl:apply-templates/>
        </if>
    </xsl:template>
    
    <!-- ................................................................................... -->
    <xsl:template match="ruleml:then">
        <then>
             <xsl:apply-templates/>
        </then>
    </xsl:template>
    
    <!-- ................................................................................... -->
    <xsl:template match="ruleml:And">
        <And>
            <xsl:apply-templates/>
        </And>
    </xsl:template>
    
    <!-- ................................................................................... -->
    <xsl:template match="ruleml:Or">
        <Or>
            <xsl:apply-templates/>
        </Or>
    </xsl:template>
    
    <!-- ................................................................................... -->
    <!-- 
        Equivalent = {torso, torso } 
        maps to formula > Equal {left, right}
        
    -->
    <xsl:template match="ruleml:Equivalent">   
        <Equal>
        <xsl:apply-templates select="ruleml:torso"/>            
        </Equal>        
    </xsl:template>
    
    <!-- ................................................................................... -->
    <!-- 
        torso = { Atom }
        maps to left or right
    -->
    <xsl:template match="ruleml:torso">       
        <xsl:choose>
            <!-- first torso -->            
            <xsl:when test="following-sibling::ruleml:torso">
                <left>
                    <xsl:apply-templates/>
                </left>
            </xsl:when>
            <!-- second torso -->
            <xsl:otherwise>                
                <right>
                    <xsl:apply-templates/>
                </right>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    
    
    <!-- ................................................................................... -->
    <!-- 
        Forall = {
            declare+,
            formula_5 ={Atom, Implies, Equivalent, Forall}
        } 
        maps to formula > Equal {left, right}
        
    -->
    <xsl:template match="ruleml:Forall">   
        <Forall>
            <xsl:call-template name="declare"/> 
            <xsl:apply-templates select="*[name()!='Var']"/>
        </Forall>        
    </xsl:template>
    
    <!-- ................................................................................... -->
    <!-- 
        Entails ={ 
            meta*,
            if_2,
            then_2  }
        
    -->
    <xsl:template match="ruleml:Entails">   
        <Entails>
           in Entails: NOT SUPPORTED.
        </Entails>        
    </xsl:template>
    
    <!-- ................................................................................... -->
    <!-- 
        Rulebase ={ 
            meta*,
            formula_7* }. formula_7 = {(Atom | Implies | Equivalent | Forall)}
        maps to Group.    
        
    -->
    <xsl:template match="ruleml:Rulebase">   
        <Group>
           <xsl:apply-templates/>
        </Group>        
    </xsl:template>
    
    <!-- ................................................................................... -->
    <!-- 
        op = { Rel }
    -->
    <xsl:template match="ruleml:op">
        <op>
            <xsl:apply-templates select="ruleml:Rel"/>
        </op>
    </xsl:template>
    
    <!-- ................................................................................... -->
    <!-- 
        Rel= {
    (attribute iri, type, node, ns1:schemaLocation, xml:id, key, keyref)
    xsd:token
  }
       
        it converts to const
    -->
    <xsl:template match="ruleml:Rel">
        <xsl:choose>
            <xsl:when test="@iri">
                <Const>            
                    <xsl:attribute name="type">
                        <xsl:value-of select='@iri'/>
                    </xsl:attribute>
                    <xsl:value-of select="text()"/>
                </Const>
            </xsl:when>
            <xsl:otherwise>
                <Const type="&rif;iri">            
                    <xsl:value-of select="text()"/>
                </Const>                
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    
    <!-- ...................................................................................  
    <xsl:template name="Atom_args">       
        <xsl:if test="*[position()=2] and *[position()=3]">
            <args ordered="yes">
                <xsl:apply-templates select="*[position()=2]"/>
                <xsl:apply-templates select="*[position()=3]"/>
            </args>
        </xsl:if>              
    </xsl:template>
    
     ................................................................................... -->
    <!-- 
        Ind= {
    (attribute iri, type, node, ns1:schemaLocation, xml:id, key, keyref)
    xsd:token
  }
       
        it converts to const
    -->
    <xsl:template match="ruleml:Ind">
        <xsl:choose>
            <xsl:when test="@iri">
                <Const>            
                    <xsl:attribute name="type">
                        <xsl:value-of select='@iri'/>
                    </xsl:attribute>
                    <xsl:value-of select="text()"/>
                </Const>
            </xsl:when>
            <xsl:otherwise>
                <Const type="&rif;iri">            
                    <xsl:value-of select="text()"/>
                </Const>                
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    
    <!-- ................................................................................... -->
    <!-- 
        slot {     
           (Ind | Data),
           (Skolem | Reify | Ind | Data | Var)
         }
         maps to slot{name|term, term}
    -->
    <xsl:template match="ruleml:slot">
        <slot ordered="yes">
            <xsl:apply-templates/>
        </slot>
    </xsl:template>
    
    <!-- ................................................................................... -->
    <!-- 
        Data = { & text
          & _1*
          } 
        it converts to const
    -->
    <xsl:template match="ruleml:Data">
        <Const type="&rif;iri">            
            <xsl:value-of select="text()"/>
        </Const>
    </xsl:template>
    
    <!-- ...................................................................................   
    
        resl = { Var }
     
    <xsl:template match="ruleml:resl">
        <xsl:apply-templates/>
    </xsl:template>
    
     ................................................................................... -->
    <!-- 
        rif:declare = { Var }
         
    -->
    <xsl:template name="declare">
        <xsl:apply-templates select="ruleml:Var"/>
    </xsl:template>
    
    <!-- ................................................................................... -->
    <!-- 
        Var = { xs:token }
        it maps to const
    -->
    <xsl:template match="ruleml:Var">
        <Var>            
            <xsl:value-of select="text()"/>
        </Var>
    </xsl:template>
    
    <!-- ................................................................................... -->
    <!-- 
        Skolem = { xs:token }
        it converts to const
    -->
    <xsl:template match="ruleml:Skolem">
        <Const type="&rif;iri">            
            <xsl:value-of select="text()"/>
        </Const>
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
    
    
    <!-- this template is just for test: it removes ALL the TEXT in the tags
    it overwrites the default built-in template      -->
    <xsl:template match="text()"/>
    
    <!-- //////////////////////////////////////////////////////////////////////////////// -->
</xsl:stylesheet>






















