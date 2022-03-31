// pages/center/center.js
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
  data: {},

  /**
   * 组件的方法列表
   */
  methods: {
    login() {
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
              if (res.userInfo.id == undefined) {
                console.log("unlogin")
                wx.getUserProfile({
                  desc: '用于完善会员资料', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
                  success: (res) => {
                    console.log(res)
                    this.setData({
                      userInfo: res.userInfo,
                      hasUserInfo: true
                    })
                  }
                })
              }
            })
          } else {
            console.log('登录失败！' + res.errMsg)
          }
        }
      })
    }
  }
})