// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {
    a:'',
    question:'',
    answer:'',
  },
  // 事件处理函数
  bindViewTap() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    var that=this;
    wx.request({
      url: 'http://localhost:8889/queryByIdTest3',
      data: { id: parseInt(Math.floor(Math.random() * 100+1))},
      method:'GET',
      success:function(res){
        console.log(res);
        var area=res.data;
          that.setData({
            area:area,
            question:area.question,
            answer:area.answer
          })
      }
    })
  },
  sub1:function(){
    var that=this;
    if('1'==that.data.answer){
      wx.showToast({
        title: '回答正确',
        duration: 2000//持续的时间
      })
      that.onLoad();
    }
    else{
      wx.request({
        url: 'http://localhost:8889/addTest3',
        data: { question: that.data.question,answer:that.data.answer},
        method:'GET',
        success:function(res){
          console.log(res.data)
        }
      })
      wx.showToast({
        title: '回答错误',
        duration: 2000//持续的时间
      })
      that.onLoad();
    }
  },
  sub2:function(){
    var that=this;
    if('0'==that.data.answer){
      wx.showToast({
        title: '回答正确',
        duration: 2000//持续的时间
      })
      that.onLoad();
    }
    else{
      wx.request({
        url: 'http://localhost:8889/addTest3',
        data: { question: that.data.question,answer:that.data.answer},
        method:'GET',
        success:function(res){
          console.log(res.data)
        }
      })
      wx.showToast({
        title: '回答错误',
        duration: 2000//持续的时间
      })
      that.onLoad();
    }
  },
  outTest:function(){
    var that = this;
    wx.request({
      url: 'http://localhost:8889/add_cTest3',
      data: { question: that.data.question,answer:that.data.answer},
      success:function(){
        wx.showToast({
          title: '已收藏',
          duration: 2000//持续的时间
        })
      }
    })
   }
})
