// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {
    id:1,
    a:'',
    question:'',
    answer:'',
    choice4:'',
    choice1:'',
    choice2:'',
    choice3:'',
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
      url: 'http://localhost:8889/queryByIdTest',
      data: { id: that.data.id},
      method:'GET',
      success:function(res){
        console.log(res);
        var area=res.data;
          that.setData({
            area:area,
            question:area.question,
            choice1:area.choice1,
            choice2:area.choice2,
            choice3:area.choice3,
            choice4:area.choice4,
            answer:area.answer,
            id:area.id
          })
      }
    })
  },
  sub1:function(){
    var that=this;
    if('A'==that.data.answer){
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
      wx.request({
        url: 'http://localhost:8889/addTest',
        data: { question: that.data.question,choice1:that.data.choice1,choice2:that.data.choice2,choice3:that.data.choice3,choice4:that.data.choice4,answer:that.data.answer},
        method:'GET',
        success:function(res){
          console.log(res.data)
        }
      })
    }
  },
  sub2:function(){
    var that=this;
    if('B'==that.data.answer){
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
      wx.request({
        url: 'http://localhost:8889/addTest',
        data: { question: that.data.question,choice1:that.data.choice1,choice2:that.data.choice2,choice3:that.data.choice3,choice4:that.data.choice4,answer:that.data.answer},
        method:'GET',
        success:function(res){
          console.log(res.data)
        }
      })
    }
  },
  sub3:function(){
    var that=this;
    if('C'==that.data.answer){
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
      wx.request({
        url: 'http://localhost:8889/addTest',
        data: { question: that.data.question,choice1:that.data.choice1,choice2:that.data.choice2,choice3:that.data.choice3,choice4:that.data.choice4,answer:that.data.answer},
        method:'GET',
        success:function(res){
          console.log(res.data)
        }
      })
    }
  },
  sub4:function(){
    var that=this;
    if('D'==that.data.answer){
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
      wx.request({
        url: 'http://localhost:8889/addTest',
        data: { question: that.data.question,choice1:that.data.choice1,choice2:that.data.choice2,choice3:that.data.choice3,choice4:that.data.choice4,answer:that.data.answer},
        method:'GET',
        success:function(res){
          console.log(res.data)
        }
      })
    }
  },
  sub5:function(){
    var that=this;
    that.data.id=that.data.id+1;
    that.onLoad();
  },
  outTest:function(){
    var that = this;
    wx.request({
      url: 'http://localhost:8889/add_cTest',
      data: { question: that.data.question,choice1:that.data.choice1,choice2:that.data.choice2,choice3:that.data.choice3,choice4:that.data.choice4,answer:that.data.answer},
      method:'GET',
      success:function(res){
        wx.showToast({
          title: '已收藏',
          duration: 2000//持续的时间
        })
      }
    })
   }
 
})
