package com.blackey.artisan.global.constants;

/**
 * TODO
 *
 * @author blackey
 * @date 2019/1/2
 */
public class NotifyContent {

    public static String notifyOrderUrl = "您的好友已完成了一笔价格为%d元的订单，订单号：%s,本次订单您获得了%d个银币！";


    public static void main(String[] args) {

        System.out.println(String.format(NotifyContent.notifyOrderUrl,85,85/2));
    }
}
