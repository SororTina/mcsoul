// pages/home/home.js
import {
    $get,
    $post
} from "../../utils/request.js"
Component({
    /**
     * 组件的属性列表
     */
    properties: {

    },

    /**
     * 组件的初始数据
     */
    data: {
        hasUserInfo: false,
        userInfo: {
            id: "",
            avatarUrl: "",
            nickName: ""
        }
    },

    /**
     * 组件的方法列表
     */
    methods: {
        onShow() {
            this.setData({
                hasUserInfo: wx.getStorageSync('hasUserInfo'),
                userInfo: wx.getStorageSync('userInfo')
            })
        },
        onLoad() {
            this.login();
        },
        login() {
            let that = this;
            wx.login({
                success(res) {
                    if (res.code) {
                        // 发送 res.code 到后台换取 openId, sessionKey, unionId
                        $post({
                            url: '/sys/manage/login',
                            data: {
                                js_code: res.code,
                            }
                        }).then(res => {
                            if (res.userInfo != undefined && res.userInfo.id !== undefined) {
                                that.setData({
                                    userInfo: res.userInfo,
                                    hasUserInfo: true
                                })
                                wx.setStorageSync('userInfo', res.userInfo);
                                wx.setStorageSync('hasUserInfo', true);
                            } else {
                                wx.setStorageSync('userInfo', null);
                                wx.setStorageSync('hasUserInfo', false);
                            }
                        })
                    } else {
                        console.log('登录失败！' + res.errMsg)
                    }
                }
            })
        },
    }
})