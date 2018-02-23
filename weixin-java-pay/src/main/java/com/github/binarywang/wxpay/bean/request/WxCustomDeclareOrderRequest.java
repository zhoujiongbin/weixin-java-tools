package com.github.binarywang.wxpay.bean.request;

/**
 * Created by cb on 2018/2/5.
 */

import com.github.binarywang.wxpay.exception.WxPayException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * https://api.mch.weixin.qq.com/cgi-bin/mch/customs/customdeclareorder
 * 订单附加信息提交接口 相关信息上报海关
 * out_trade_no            商户订单号
 * transaction_id          微信支付订单号
 * customs        NO-无需上报海关    GUANGZHOU_ZS 广州（总署版）  GUANGZHOU_HP_GJ 广州黄埔国检
 * （需推送订单至黄埔国检的订单需分别推送广州（总署版）和广州黄埔国检，即需要请求两次报关接口） GUANGZHOU_NS_GJ 广州南沙国检
 * （需推送订单至南沙国检的订单需分别推送广州（总署版）和广州南沙国检，即需要请求两次报关接口）
 * mchCustomsNo            商户海关备案号
 * duty                 关税  关税，以分为单位，少数海关特殊要求上传该字段时需要
 * sub_order_no             商户子订单号，如有拆单则必传
 * fee_type             微信支付订单支付时使用的币种，暂只支持人民币CNY,如有拆单则必传。
 * order_fee            子订单金额，以分为单位，不能超过原订单金额，order_fee=transport_fee+product_fee（应付金额=物流费+商品价格），如有拆单则必传。
 * transport_fee        物流费用，以分为单位，如有拆单则必传。
 * product_fee          商品费用，以分为单位，如有拆单则必传。
 * cert_type            证件类型 请传固定值IDCARD,暂只支持大陆身份证。(非必填)
 * cert_id              用户大陆身份证号，尾号为字母X的身份证号，请大写字母X。(非必填)
 * name                 用户姓名。
 */
@XStreamAlias("xml")
@Data
public class WxCustomDeclareOrderRequest extends BaseWxPayRequest {

  @XStreamAlias("out_trade_no")
  private String outTradeNo;
  @XStreamAlias("transaction_id")
  private String transactionId;
  @XStreamAlias("customs")
  private String customs;
  @XStreamAlias("mch_customs_no")
  private String mchCustomsNo;
  @XStreamAlias("duty")
  private String duty;
  @XStreamAlias("sub_order_no")
  private String subOrderNo;
  @XStreamAlias("fee_type")
  private String freeType;
  @XStreamAlias("order_fee")
  private String orderFee;
  @XStreamAlias("transport_fee")
  private String transportFee;
  @XStreamAlias("product_fee")
  private String productFee;
  @XStreamAlias("cert_type")
  private String certType;
  @XStreamAlias("cert_id")
  private String certId;
  @XStreamAlias("name")
  private String name;
  @XStreamAlias("sign_type")
  private String signType;

  @Override
  protected void checkConstraints() throws WxPayException {

  }
}
