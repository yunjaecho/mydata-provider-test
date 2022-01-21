package mydata.provider.testtool.damin

/*
 * Created By  : mydata-platform
 * Description : 
 * Author                    Date                     Time
 * ------------------       --------------            ------------------
 * YunJae.Cho                2022/01/18                  4:09 오후
 */


import io.circe.literal._
import io.circe.Json
import io.circe.schema.Schema
import mydata.provider.testtool.damin.bank.Accounts

import scala.io.Source



object Main {
  def main(args: Array[String]): Unit = {
//    val objectMapper = new ObjectMapper()
//    objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, "true")
//    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, "false")

    val jsonData =
      json"""
        {
            "rsp_code": "00000",
            "rsp_msg": "성공",
            "reg_date": "20000101",
            "account_cnt": "9",
            "account_list": [
                {
                    "account_num": "20210729132701",
                    "seqno": "0",
                    "is_consent": "true",
                    "is_foreign_deposit": "true",
                    "prod_name": "자유입출식 (수신상품)",
                    "is_minus": "false",
                    "account_type": "1001",
                    "account_status": "01"
                },
                {
                    "account_num": "20210729132702",
                    "seqno": "0",
                    "is_consent": "true",
                    "is_foreign_deposit": "true",
                    "prod_name": "적금 (수신상품)",
                    "is_minus": "false",
                    "account_type": "1003",
                    "account_status": "01"
                },
                {
                    "account_num": "20210729132703",
                    "seqno": "0",
                    "is_consent": "true",
                    "is_foreign_deposit": "false",
                    "prod_name": "기타 (수신상품)",
                    "is_minus": "true",
                    "account_type": "1999",
                    "account_status": "01"
                },
                {
                    "account_num": "20210729132704",
                    "seqno": "0",
                    "is_consent": "true",
        
                    "prod_name": "수익증권 (투자상품)",
        
                    "account_type": "2001",
                    "account_status": "01"
                },
                {
                    "account_num": "20210729132705",
                    "seqno": "0",
                    "is_consent": "true",
        
                    "prod_name": "신탁 (투자상품)",
        
                    "account_type": "2002",
                    "account_status": "01"
                },
                {
                    "account_num": "20210729132706",
                    "seqno": "0",
                    "is_consent": "true",
        
                    "prod_name": "신탁형 ISA (투자상품)",
        
                    "account_type": "2003",
                    "account_status": "01"
                },
                {
                    "account_num": "20210729132707",
                    "seqno": "0",
                    "is_consent": "true",
        
                    "prod_name": "신용대출 (대출상품)",
        
                    "account_type": "3100",
                    "account_status": "01"
                },
                {
                    "account_num": "20210729132708",
                    "seqno": "0",
                    "is_consent": "true",
        
                    "prod_name": "주택담보대출 (대출상품)",
        
                    "account_type": "AAAA3220",
                    "account_status": "01"
                },
                {
                    "account_num": "20210729132709",
                    "seqno": "0",
                    "is_consent": "true",
        
                    "prod_name": "채권인수전문기관 보유 (대출상품)",
        
                    "account_type": "3999",
                    "account_status": "01"
                }
            ]
        }
        """

//    val jsonData = """{"rsp_code": "00000","rsp_msg": "성공","reg_date": "20000101","account_cnt": "9","account_list": [{"account_num": "20210729132701","seqno": "0","is_consent": "true","is_foreign_deposit": "true","prod_name": "자유입출식 (수신상품)","is_minus": "false","account_type": "1001","account_status": "01"},{"account_num": "20210729132702","seqno": "0","is_consent": "true","is_foreign_deposit": "true","prod_name": "적금 (수신상품)","is_minus": "false","account_type": "1003","account_status": "01"},{"account_num": "20210729132703","seqno": "0","is_consent": "true","is_foreign_deposit": "false","prod_name": "기타 (수신상품)","is_minus": "true","account_type": "1999","account_status": "01"},{"account_num": "20210729132704","seqno": "0","is_consent": "true","prod_name": "수익증권 (투자상품)","account_type": "2001","account_status": "01"},{"account_num": "20210729132705","seqno": "0","is_consent": "true","prod_name": "신탁 (투자상품)","account_type": "2002","account_status": "01"},{"account_num": "20210729132706","seqno": "0","is_consent": "true","prod_name": "신탁형 ISA (투자상품)","account_type": "2003","account_status": "01"},{"account_num": "20210729132707","seqno": "0","is_consent": "true","prod_name": "신용대출 (대출상품)","account_type": "3100","account_status": "01"},{"account_num": "20210729132708","seqno": "0","is_consent": "true","prod_name": "주택담보대출 (대출상품)","account_type": "3220","account_status": "01"},{"account_num": "20210729132709","seqno": "0","is_consent": "true","prod_name": "채권인수전문기관 보유 (대출상품)","account_type": "3999","account_status": "01"}]}"""


    val schema = Source.fromResource("schema/bank_accounts.json").mkString

    val bankAccountsSchema: Schema = Schema.loadFromString(schema).get

//    val jsonData = json"""{"rsp_code": "00000","rsp_msg":"성공","reg_date":"20000101"}"""


    val result = bankAccountsSchema.validate(jsonData)

    result.swap.map(_.toList).toList.flatten.map(_.getMessage).foreach(println)

    println(result.isInvalid)

  }


}
