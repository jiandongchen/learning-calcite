package com.learningcalcite

import org.apache.calcite.avatica.util.{Casing, Quoting}
import org.apache.calcite.sql.parser.SqlParser
import org.apache.calcite.sql.parser.impl.SqlParserImpl

object FirstImpression {
  def main(args: Array[String]): Unit = {
    val config = SqlParser
      .config()
      .withParserFactory(SqlParserImpl.FACTORY)
      .withQuoting(Quoting.DOUBLE_QUOTE)
      .withUnquotedCasing(Casing.TO_LOWER)
      .withQuotedCasing(Casing.TO_LOWER)

    val parser = SqlParser.create("select * from EMP", config)
    val sqlNode = parser.parseQuery()
    println(sqlNode.toString)
  }
}
