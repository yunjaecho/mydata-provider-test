package mydata.provider.testtool.damin.bank


/*
 * Created By  : mydata-platform
 * Description : 
 * Author                    Date                     Time
 * ------------------       --------------            ------------------
 * YunJae.Cho                2022/01/17                  10:11 오전
 */

case class Accounts(rsp_code:String,
                    rsp_msg:String,
                    search_timestamp:String,
                    reg_date:String,
                    next_page:String,
                    account_cnt:String,
                    account_list: Set[AccountList]) {



}
