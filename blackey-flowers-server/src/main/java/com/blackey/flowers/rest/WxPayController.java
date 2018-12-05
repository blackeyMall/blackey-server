package com.blackey.flowers.rest;

import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxPayRefundNotifyResult;
import com.github.binarywang.wxpay.bean.request.*;
import com.github.binarywang.wxpay.bean.result.*;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author Binary Wang
 */
@RestController
@RequestMapping("flowers/wx/pay")
public class WxPayController {
  private WxPayService wxService;

  @Autowired
  public WxPayController(WxPayService wxService) {
    this.wxService = wxService;
  }

  /**
   * <pre>
   * 查询订单(详见https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_2)
   * 该接口提供所有微信支付订单的查询，商户可以通过查询订单接口主动查询订单状态，完成下一步的业务逻辑。
   * 需要调用查询接口的情况：
   * ◆ 当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知；
   * ◆ 调用支付接口后，返回系统错误或未知交易状态情况；
   * ◆ 调用被扫支付API，返回USERPAYING的状态；
   * ◆ 调用关单或撤销接口API之前，需确认支付状态；
   * 接口地址：https://api.mch.weixin.qq.com/pay/orderquery
   * </pre>
   *
   * @param transactionId 微信订单号
   * @param outTradeNo    商户系统内部的订单号，当没提供transactionId时需要传这个。
   */
  @GetMapping("/queryOrder")
  public WxPayOrderQueryResult queryOrder(@RequestParam(required = false) String transactionId,
                                          @RequestParam(required = false) String outTradeNo)
      throws WxPayException {
    return this.wxService.queryOrder(transactionId, outTradeNo);
  }

  @PostMapping("/queryOrder")
  public WxPayOrderQueryResult queryOrder(WxPayOrderQueryRequest wxPayOrderQueryRequest) throws WxPayException {
    return this.wxService.queryOrder(wxPayOrderQueryRequest);
  }

  /**
   * <pre>
   * 关闭订单
   * 应用场景
   * 以下情况需要调用关单接口：
   * 1. 商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；
   * 2. 系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。
   * 注意：订单生成后不能马上调用关单接口，最短调用时间间隔为5分钟。
   * 接口地址：https://api.mch.weixin.qq.com/pay/closeorder
   * 是否需要证书：   不需要。
   * </pre>
   *
   * @param outTradeNo 商户系统内部的订单号
   */
  @GetMapping("/closeOrder/{outTradeNo}")
  public WxPayOrderCloseResult closeOrder(@PathVariable String outTradeNo) throws WxPayException {
    return this.wxService.closeOrder(outTradeNo);
  }

  @PostMapping("/closeOrder")
  public WxPayOrderCloseResult closeOrder(WxPayOrderCloseRequest wxPayOrderCloseRequest) throws WxPayException {
    return this.wxService.closeOrder(wxPayOrderCloseRequest);
  }

  /**
   * 调用统一下单接口，并组装生成支付所需参数对象.
   *
   * @param request 统一下单请求参数
   * @param <T>     请使用{@link com.github.binarywang.wxpay.bean.order}包下的类
   * @return 返回 {@link com.github.binarywang.wxpay.bean.order}包下的类对象
   */
  @PostMapping("/createOrder")
  public <T> T createOrder(@RequestBody WxPayUnifiedOrderRequest request) throws WxPayException {
    return this.wxService.createOrder(request);
  }




  /**
   * 统一下单(详见https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1)
   * 在发起微信支付前，需要调用统一下单接口，获取"预支付交易会话标识"
   * 接口地址：https://api.mch.weixin.qq.com/pay/unifiedorder
   *
   * @param request 请求对象，注意一些参数如appid、mchid等不用设置，方法内会自动从配置对象中获取到（前提是对应配置中已经设置）
   */
  @PostMapping("/unifiedOrder")
  public WxPayUnifiedOrderResult unifiedOrder(@RequestBody WxPayUnifiedOrderRequest request) throws WxPayException {
    return this.wxService.unifiedOrder(request);
  }

  /**
   * <pre>
   * 微信支付-申请退款
   * 详见 https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_4
   * 接口链接：https://api.mch.weixin.qq.com/secapi/pay/refund
   * </pre>
   *
   * @param request 请求对象
   * @return 退款操作结果
   */
  @PostMapping("/refund")
  public WxPayRefundResult refund(@RequestBody WxPayRefundRequest request) throws WxPayException {
    return this.wxService.refund(request);
  }

  /**
   * <pre>
   * 微信支付-查询退款
   * 应用场景：
   *  提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账，
   *  银行卡支付的退款3个工作日后重新查询退款状态。
   * 详见 https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_5
   * 接口链接：https://api.mch.weixin.qq.com/pay/refundquery
   * </pre>
   * 以下四个参数四选一
   *
   * @param transactionId 微信订单号
   * @param outTradeNo    商户订单号
   * @param outRefundNo   商户退款单号
   * @param refundId      微信退款单号
   * @return 退款信息
   */
  @GetMapping("/refundQuery")
  public WxPayRefundQueryResult refundQuery(@RequestParam(required = false) String transactionId,
                                            @RequestParam(required = false) String outTradeNo,
                                            @RequestParam(required = false) String outRefundNo,
                                            @RequestParam(required = false) String refundId)
      throws WxPayException {
    return this.wxService.refundQuery(transactionId, outTradeNo, outRefundNo, refundId);
  }

  @PostMapping("/refundQuery")
  public WxPayRefundQueryResult refundQuery(WxPayRefundQueryRequest wxPayRefundQueryRequest) throws WxPayException {
    return this.wxService.refundQuery(wxPayRefundQueryRequest);
  }

  @PostMapping("/notify/order")
  public String parseOrderNotifyResult(@RequestBody String xmlData) throws WxPayException {
    final WxPayOrderNotifyResult notifyResult = this.wxService.parseOrderNotifyResult(xmlData);
    // TODO 根据自己业务场景需要构造返回对象
    return WxPayNotifyResponse.success("成功");
  }

  @PostMapping("/notify/refund")
  public String parseRefundNotifyResult(@RequestBody String xmlData) throws WxPayException {
    final WxPayRefundNotifyResult result = this.wxService.parseRefundNotifyResult(xmlData);
    // TODO 根据自己业务场景需要构造返回对象
    return WxPayNotifyResponse.success("成功");
  }

  /**
   * <pre>
   * 交易保障
   * 应用场景：
   *  商户在调用微信支付提供的相关接口时，会得到微信支付返回的相关信息以及获得整个接口的响应时间。
   *  为提高整体的服务水平，协助商户一起提高服务质量，微信支付提供了相关接口调用耗时和返回信息的主动上报接口，
   *  微信支付可以根据商户侧上报的数据进一步优化网络部署，完善服务监控，和商户更好的协作为用户提供更好的业务体验。
   * 接口地址： https://api.mch.weixin.qq.com/payitil/report
   * 是否需要证书：不需要
   * </pre>
   */
  @PostMapping("/report")
  public void report(@RequestBody WxPayReportRequest request) throws WxPayException {
    this.wxService.report(request);
  }

  /**
   * <pre>
   * 下载对账单
   * 商户可以通过该接口下载历史交易清单。比如掉单、系统错误等导致商户侧和微信侧数据不一致，通过对账单核对后可校正支付状态。
   * 注意：
   * 1、微信侧未成功下单的交易不会出现在对账单中。支付成功后撤销的交易会出现在对账单中，跟原支付单订单号一致，bill_type为REVOKED；
   * 2、微信在次日9点启动生成前一天的对账单，建议商户10点后再获取；
   * 3、对账单中涉及金额的字段单位为“元”。
   * 4、对账单接口只能下载三个月以内的账单。
   * 接口链接：https://api.mch.weixin.qq.com/pay/downloadbill
   * 详情请见: <a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_6">下载对账单</a>
   * </pre>
   *
   * @param billDate   对账单日期 bill_date	下载对账单的日期，格式：20140603
   * @param billType   账单类型	bill_type	ALL，返回当日所有订单信息，默认值，SUCCESS，返回当日成功支付的订单，REFUND，返回当日退款订单
   * @param tarType    压缩账单	tar_type	非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
   * @param deviceInfo 设备号	device_info	非必传参数，终端设备号
   * @return 保存到本地的临时文件
   */
  @GetMapping("/downloadBill/{billDate}/{billType}/{tarType}/{deviceInfo}")
  public WxPayBillResult downloadBill(@PathVariable String billDate,
                                      @PathVariable String billType,
                                      @PathVariable String tarType,
                                      @PathVariable String deviceInfo) throws WxPayException {
    return this.wxService.downloadBill(billDate, billType, tarType, deviceInfo);
  }

  @PostMapping("/downloadBill")
  public WxPayBillResult downloadBill(WxPayDownloadBillRequest wxPayDownloadBillRequest) throws WxPayException {
    return this.wxService.downloadBill(wxPayDownloadBillRequest);
  }

  /**
   * <pre>
   * 撤销订单API
   * 文档地址：https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_11&index=3
   * 应用场景：
   *  支付交易返回失败或支付系统超时，调用该接口撤销交易。如果此订单用户支付失败，微信支付系统会将此订单关闭；如果用户支付成功，微信支付系统会将此订单资金退还给用户。
   *  注意：7天以内的交易单可调用撤销，其他正常支付的单如需实现相同功能请调用申请退款API。提交支付交易后调用【查询订单API】，没有明确的支付结果再调用【撤销订单API】。
   *  调用支付接口后请勿立即调用撤销订单API，建议支付后至少15s后再调用撤销订单接口。
   *  接口链接 ：https://api.mch.weixin.qq.com/secapi/pay/reverse
   *  是否需要证书：请求需要双向证书。
   * </pre>
   */
  @PostMapping("/reverseOrder")
  public WxPayOrderReverseResult reverseOrder(@RequestBody WxPayOrderReverseRequest request) throws WxPayException {
    return this.wxService.reverseOrder(request);
  }


}

