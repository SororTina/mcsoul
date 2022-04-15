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
  data: {
    hasUserInfo: false,
    userInfo: {
      id:"",
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
                  userInfo : res.userInfo,
                  hasUserInfo: true
                })
                wx.setStorageSync('userInfo', res.userInfo);
              }
            })
          } else {
            console.log('登录失败！' + res.errMsg)
          }
        }
      })
    },
    getUserInfo() {
      let that = this;
      wx.getUserProfile({
        desc: '用于完善会员资料', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
        success: (res) => {
          that.userInfo = res.userInfo;
          console.log(res)
          wx.login({
            success(res) {
              if (res.code) {
                $post({
                  url: '/sys/manage/register',
                  data: {
                    js_code: res.code,
                    ...that.userInfo
                  }
                }).then(res => {
                  that.setData({
                    userInfo : res.userInfo,
                    hasUserInfo: true
                  });
                  wx.setStorageSync('userInfo', res.userInfo);
                  wx.setStorageSync('hasUserInfo', true);
                })
              }
            }
          })
        }
      })
    }
  }
})