// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {
    id:1,
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
      url: 'http://localhost:8889/query_cByIdTest3',
      data: { id: that.data.id},
      method:'GET',
      success:function(res){
        console.log(res);
        var area=res.data;
          that.setData({
            area:area,
            question:area.question,
            answer:area.answer,
            id:area.id
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
    }
    else{
      wx.showToast({
        title: '回答错误',
        duration: 2000//持续的时间
      })
    }
  },
  sub2:function(){
    var that=this;
    if('0'==that.data.answer){
      wx.showToast({
        title: '回答正确',
        duration: 2000//持续的时间
      })
    }
    else{
      wx.showToast({
        title: '回答错误',
        duration: 2000//持续的时间
      })
    }
  },
  sub:function(e){
    var that=this;
    console.log(that.data.id)
    wx.request({
      url: 'http://localhost:8889/delete_cTest3',
      data:{id:that.data.id},
    })
    that.data.id=that.data.id+1;
    that.onLoad();
  },
  sub5:function(){
    var that=this;
    that.data.id=that.data.id+1;
    that.onLoad();
  }
 
})
