<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="text" encoding="ISO-8859-1" />

<xsl:param name="environment" />

<xsl:template match="/">
  <xsl:apply-templates select="config/group[@name = $environment]" />
</xsl:template>

<xsl:template match="config/group[@name = $environment]"># Copyright (c) 2012 Consupago S.A. de C.V. SFOL.
# ALL RIGHTS RESERVED
# ESB JCo Configuration.

# <xsl:value-of select="@name" />
jco.client.ashost = <xsl:apply-templates select="param[@name = 'jco.client.ashost']" />
jco.client.sysnr = <xsl:apply-templates select="param[@name = 'jco.client.sysnr']" />
jco.client.client = <xsl:apply-templates select="param[@name = 'jco.client.client']" />
jco.client.user = <xsl:apply-templates select="param[@name = 'jco.client.user']" />
jco.client.passwd = <xsl:apply-templates select="param[@name = 'jco.client.passwd']" />
jco.destination.pool_capacity = <xsl:apply-templates select="param[@name = 'jco.destination.pool_capacity']" />
jco.destination.peak_limit = <xsl:apply-templates select="param[@name = 'jco.destination.peak_limit']" />
jco.client.lang = <xsl:apply-templates select="param[@name = 'jco.client.lang']" />
<xsl:text>&#10;</xsl:text>

</xsl:template>

</xsl:stylesheet>
