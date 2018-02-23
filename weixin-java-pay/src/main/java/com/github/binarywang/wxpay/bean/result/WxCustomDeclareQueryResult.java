package com.github.binarywang.wxpay.bean.result;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;
import me.chanjar.weixin.common.util.xml.XStreamInitializer;

import java.util.List;

/**
 * Created by cb on 2018/2/1.
 * 订单附加信息查询接口
 */
@XStreamAlias("xml")
@Data
public class WxCustomDeclareQueryResult extends BaseWxPayResult {
  @XStreamAlias("transaction_id")
  private String transactionId;               //微信支付单
  @XStreamAlias("count")
  private Integer count;                      //笔数
  @XStreamImplicit(itemFieldName="sub_order_no")
  private List<String> subOrderNo;                            //商户子订单号
  @XStreamImplicit(itemFieldName="sub_order_id")
  private List<String> subOrderId;                            //微信子订单号
  @XStreamImplicit(itemFieldName="mch_customs_no")
  private List<String> mchCustomsNo;                          //商户在海关登记的备案号
  @XStreamImplicit(itemFieldName="customs")
  private List<String> customs;                               //海关
  @XStreamImplicit(itemFieldName="cert_type")
  private List<String> certType;                              //证件类型  暂只支持身份证，取值：IDCARD
  @XStreamImplicit(itemFieldName="cert_id")
  private List<String> certId;                                //证件号码
  @XStreamImplicit(itemFieldName="name")
  private List<String> name;                                  //用户姓名
  @XStreamImplicit(itemFieldName="fee_type")
  private List<String> feeType;                               //币种
  @XStreamImplicit(itemFieldName="order_fee")
  private List<Integer> orderFee;                             //子单金额，以分为单位
  @XStreamImplicit(itemFieldName="duty")
  private List<Integer> duty;                                 //关税，以分为单位
  @XStreamImplicit(itemFieldName="transport_fee")
  private List<Integer> transportFee;                         //物流费用，以分为单位
  @XStreamImplicit(itemFieldName="product_fee")
  private List<Integer> productFee;                           //商品费用，以分为单位
  @XStreamImplicit(itemFieldName="state")
  private List<String> state;                                 //状态码
  @XStreamImplicit(itemFieldName="explanation")
  private List<String> explanation;                           //申报结果说明，如果状态是失败或异常，显示失败原因
  @XStreamImplicit(itemFieldName="modify_time")
  private List<String> modifyTime;                            //最后更新时间，格式为yyyyMMddhhmmss

  /**
   * 从xml字符串创建bean对象.
   */
  public static WxCustomDeclareQueryResult fromXML(String xmlString) {
    XStream xstream = XStreamInitializer.getInstance();
    xstream.processAnnotations(WxCustomDeclareQueryResult.class);
    WxCustomDeclareQueryResult result = (WxCustomDeclareQueryResult) xstream.fromXML(xmlString.replaceAll("_\\d>", ">"));
    result.setXmlString(xmlString);
    return result;
  }
}
