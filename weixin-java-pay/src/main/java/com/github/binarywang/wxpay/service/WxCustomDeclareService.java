package com.github.binarywang.wxpay.service;

import com.github.binarywang.wxpay.bean.request.WxCustomDeclareDeclareRequest;
import com.github.binarywang.wxpay.bean.request.WxCustomDeclareOrderRequest;
import com.github.binarywang.wxpay.bean.request.WxCustomDeclareQueryRequest;
import com.github.binarywang.wxpay.bean.result.WxCustomDeclareDeclareResult;
import com.github.binarywang.wxpay.bean.result.WxCustomDeclareOrderResult;
import com.github.binarywang.wxpay.bean.result.WxCustomDeclareQueryResult;
import com.github.binarywang.wxpay.exception.WxPayException;

/**
 * Created by cb on 2018/2/5.
 */
public interface WxCustomDeclareService {
  /**
   * <pre>
   *     订单附加信息提交接口
   *     用于商户提交海关需要的订单附件信息。报关接口只支持一个月内的支付订单进行报关申请。
   *     接口地址:https://api.mch.weixin.qq.com/cgi-bin/mch/customs/customdeclareorder
   * <pre/>
   */
  WxCustomDeclareOrderResult customDeclareOrder(WxCustomDeclareOrderRequest request) throws WxPayException;

  /**
   * <pre>
   *     订单附加信息查询接口
   *     商户通过订单号查询提交的订单附加信息。如果是微信收集的实名信息，查询接口不返回实名信息内容
   *     接口地址:https://api.mch.weixin.qq.com/cgi-bin/mch/customs/customdeclarequery
   * <pre/>
   */
  WxCustomDeclareQueryResult customDeclareQuery(WxCustomDeclareQueryRequest request) throws WxPayException;

  /**
   * <pre>
   *     订单附加信息重推接口
   *     接口地址:https://api.mch.weixin.qq.com/cgi-bin/mch/newcustoms/customdeclareredeclare
   * <pre/>
   */
  WxCustomDeclareDeclareResult customDeclareDeclare(WxCustomDeclareDeclareRequest request) throws WxPayException;
}
