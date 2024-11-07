<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>

    <xsl:key name="pagesByType" match="Page" use="@type"/>

    <xsl:template match="/Site">
        <Site>
            <xsl:for-each select="Page[generate-id() = generate-id(key('pagesByType', @type)[1])]">
                <xsl:element name="{@type}">
                    <xsl:for-each select="key('pagesByType', @type)">
                        <Page id="{@id}" type="{@type}">
                            <Title>
                                <xsl:value-of select="Title"/>
                            </Title>
                            <Chars>
                                <xsl:for-each select="Chars/Char">
                                    <Char>
                                        <xsl:value-of select="."/>
                                    </Char>
                                </xsl:for-each>
                            </Chars>
                            <xsl:if test="Votings">
                                <Votings>
                                    <Voting>
                                        <Anonimus>
                                            <xsl:value-of select="Votings/Voting/Anonimus"/>
                                        </Anonimus>
                                    </Voting>
                                </Votings>
                            </xsl:if>
                            <Authorize>
                                <xsl:value-of select="Authorize"/>
                            </Authorize>
                        </Page>
                    </xsl:for-each>
                </xsl:element>
            </xsl:for-each>
        </Site>
    </xsl:template>
</xsl:stylesheet>
