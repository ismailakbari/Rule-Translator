<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/catalog">
	<html> 
	<body>
	  <h2>My CD Collection</h2>
	  <table border="1">
		<tr bgcolor="#9acd32">
		  <th style="text-align:left">Title</th>
		  <th style="text-align:left">Artist</th>
		</tr>		
		<xsl:apply-templates select="cd" />		
	  </table>
	</body>
	</html>
	</xsl:template>
	<xsl:template match="cd">
		<tr>
		<td><xsl:apply-templates select="title" />	</td>
		<td><xsl:apply-templates select="artist" />	</td>
		</tr>
	</xsl:template>
	<xsl:template match="title">
		<!-- remove double quotation around the node value.-->
		<xsl:value-of select="substring(text(), 2, string-length(text())-2)"/>
	
	</xsl:template>
	<xsl:template match="artist">
		
		<xsl:value-of select="text()"/>
	
	</xsl:template>
</xsl:stylesheet>