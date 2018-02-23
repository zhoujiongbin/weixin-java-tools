package com.github.binarywang.wxpay.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * Created by cb on 2018/1/29.
 * 上报海关 返回结构
 * state 状态码          UNDECLARED -- 未申报 SUBMITTED -- 申报已提交（订单已经送海关，商户重新申报，并且海关还有修改接口，那么记录的状态会是这个）
 *                       PROCESSING -- 申报中 SUCCESS -- 申报成功 FAIL-- 申报失败 EXCEPT --海关接口异常
 * transaction_id       微信支付订单号
 * out_trade_no         商户订单号
 * sub_order_no         商户子订单号
 * sub_order_id         微信子订单号
 * modify_time          最后更新时间
 */
@XStreamAlias("xml")
@Data
public class WxCustomDeclareOrderResult extends BaseWxPayResult {
  @XStreamAlias("state")
  private String state;
  @XStreamAlias("transaction_id")
  private String transactionId;
  @XStreamAlias("out_trade_no")
  private String outTradeNo;
  @XStreamAlias("sub_order_no")
  private String subOrderNo;
  @XStreamAlias("sub_order_id")
  private String subOrderId;
  @XStreamAlias("modify_time")
  private String modifyTime;
}
