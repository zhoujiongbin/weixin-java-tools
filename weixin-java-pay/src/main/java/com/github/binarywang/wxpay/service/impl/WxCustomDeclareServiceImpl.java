package com.github.binarywang.wxpay.service.impl;

import com.github.binarywang.wxpay.bean.request.WxCustomDeclareDeclareRequest;
import com.github.binarywang.wxpay.bean.request.WxCustomDeclareOrderRequest;
import com.github.binarywang.wxpay.bean.request.WxCustomDeclareQueryRequest;
import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.github.binarywang.wxpay.bean.result.WxCustomDeclareDeclareResult;
import com.github.binarywang.wxpay.bean.result.WxCustomDeclareOrderResult;
import com.github.binarywang.wxpay.bean.result.WxCustomDeclareQueryResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxCustomDeclareService;
import com.github.binarywang.wxpay.service.WxPayService;

/**
 * Created by cb on 2018/2/5.
 */
public class WxCustomDeclareServiceImpl implements WxCustomDeclareService{
  private WxPayService payService;
  public WxCustomDeclareServiceImpl(WxPayService wxPayService) {
    this.payService = wxPayService;
  }

  @Override
  public WxCustomDeclareOrderResult customDeclareOrder(WxCustomDeclareOrderRequest request) throws WxPayException {
    request.checkAndSign(this.payService.getConfig());
    String url = this.payService.getPayBaseUrl() + "/cgi-bin/mch/customs/customdeclareorder";

    String responseContent = this.payService.post(url, request.toXML(), true);
    WxCustomDeclareOrderResult result = BaseWxPayResult.fromXML(responseContent, WxCustomDeclareOrderResult.class);
    result.checkResult(this.payService, request.getSignType(), true);
    return result;
  }

  @Override
  public WxCustomDeclareQueryResult customDeclareQuery(WxCustomDeclareQueryRequest request) throws WxPayException {
    request.checkAndSign(this.payService.getConfig());
    String url = this.payService.getPayBaseUrl() + "/cgi-bin/mch/customs/customdeclarequery";

    String responseContent = this.payService.post(url, request.toXML(), true);
    WxCustomDeclareQueryResult result = WxCustomDeclareQueryResult.fromXML(responseContent);
    result.checkResult(this.payService, request.getSignType(), true);
    return result;
  }

  @Override
  public WxCustomDeclareDeclareResult customDeclareDeclare(WxCustomDeclareDeclareRequest request) throws WxPayException {
    request.checkAndSign(this.payService.getConfig());
    String url = this.payService.getPayBaseUrl() + "/cgi-bin/mch/newcustoms/customdeclareredeclare";

    String responseContent = this.payService.post(url, request.toXML(), true);
    WxCustomDeclareDeclareResult result = BaseWxPayResult.fromXML(responseContent, WxCustomDeclareDeclareResult.class);
    result.checkResult(this.payService, request.getSignType(), true);
    return result;
  }
}
