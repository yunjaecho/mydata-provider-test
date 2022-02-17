package mydata.provider.testtool.damin

/*
 * Created By  : mydata-platform
 * Description : 
 * Author                    Date                     Time
 * ------------------       --------------            ------------------
 * YunJae.Cho                2022/01/18                  4:09 오후
 */


import io.circe.literal._
import io.circe.{Json, jawn}
import io.circe.schema.Schema
import mydata.provider.testtool.damin.bank.Accounts

import scala.io.Source



object Main {
  def main(args: Array[String]): Unit = {
//    val objectMapper = new ObjectMapper()
//    objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, "true")
//    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, "false")


    val schema = Source.fromResource("schema/bank_accounts.json").mkString

    val bankAccountsSchema: Schema = Schema.loadFromString(schema).get

    val jsonBA001 = jawn.parse(Source.fromResource("json/bank_accounts.data").mkString)

    jsonBA001 match {
      case Right(v) => {
        val result = bankAccountsSchema.validate(v)
        result.swap.map(_.toList).toList.flatten.map(_.getMessage).foreach(println)

        println(result.isInvalid)
      }
      case Left(err) => {
        println(err.getMessage())
      }
    }

  }


}
