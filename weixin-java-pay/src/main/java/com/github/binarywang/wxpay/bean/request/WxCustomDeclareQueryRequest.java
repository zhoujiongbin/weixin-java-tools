package com.github.binarywang.wxpay.bean.request;

import com.github.binarywang.wxpay.exception.WxPayException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * Created by cb on 2018/1/31.
 * https://api.mch.weixin.qq.com/cgi-bin/mch/customs/customdeclarequery
 * 订单附加信息查询接口 查询上报海关进度
 * sign_type            签名方式 暂只支持md5
 *
 * out_trade_no         商户订单号
 * transaction_id       微信支付单号
 * sub_order_no         微信子订单号       四选一
 * sub_order_id         微信子订单号
 *
 * customs              海关  GUANGZHOU_ZS 广州（总署版） GUANGZHOU_HP_GJ 广州黄埔国检  GUANGZHOU_NS_GJ 广州南沙国检
 * mch_customs_no       商户海关备案号
 */
@XStreamAlias("xml")
@Data
public class WxCustomDeclareQueryRequest extends BaseWxPayRequest {
  @XStreamAlias("sign_type")
  private String signType;
  @XStreamAlias("out_trade_no")
  private String outTradeNo;
  @XStreamAlias("transaction_id")
  private String transactionId;
  @XStreamAlias("sub_order_no")
  private String subOrderNo;
  @XStreamAlias("sub_order_id")
  private String subOrderId;
  @XStreamAlias("customs")
  private String customs;
  @XStreamAlias("mch_customs_no")
  private String mchCustomsNo;

  @Override
  protected void checkConstraints() throws WxPayException {

  }
}
