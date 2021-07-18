//app.js
var m =0
App({
  onLaunch: function () {
    // 展示本地存储能力
    let logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })
  },
  
  onHide: function () {
    m +=1,
    this.globalData.i = m,
    
    wx.redirectTo({
      url: '../index/index',
    })
  },
  
  globalData: {
    userInfo: null,
    i :m,
    empower:0,
    questionList : {
      "001": [
          {
            "question": "爸爸的爸爸叫什么?",
            "option": {
              "A": "爷爷",
              "B": "姥爷",
              "C": "叔叔",
              "D": "伯伯",
              "E": "阿姨",
              "F": "老舅"
            },
            "true": "A",   // 正确答案
            "type": 1,     // 类型 1 单选  2 多选
            "scores": 10,  // 分值
            "checked": false  // 默认没有选中
          },
          {
            "question": "妈妈的姐妹叫什么?",
            "option": {
              "A": "姥姥",
              "B": "奶奶",
              "C": "叔叔",
              "D": "大姨",
              "E": "小姨",
              "F": "老舅"
            },
            "true": ["D", "E"],   // 正确答案
            "type": 2,     // 类型 1 单选  2 多选
            "scores": 10,  // 分值
            "checked": false  // 默认没有选中
          },
      ],
      "002": [
          // ...数据格式同上
      ]
    
  }

  

  }

  
})