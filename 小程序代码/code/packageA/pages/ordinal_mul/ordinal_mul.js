// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {
    id:1,
    a:'',
    question:'',
    answer:'',
    a:'',
    question:'',
    answer:'',
    riderCommentList: [{
      value: '',

      selected: false ,
    },{
      value: '',
      selected: false ,

    },{
      value: '',
      selected: false ,
    },{
      value: '',
      selected: false , 
    }]
  },
  checkboxChange(e){
    console.log('checkboxChange e:',e);
    let string = "riderCommentList["+e.target.dataset.index+"].selected"
        this.setData({
            [string]: !this.data.riderCommentList[e.target.dataset.index].selected
        })
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
      url: 'http://localhost:8889/queryByIdTest2',
      data: { id: that.data.id},
      method:'GET',
      success:function(res){
        console.log(res);
        var area=res.data;
          that.setData({
            area:area,
            question:area.question,
            "riderCommentList[0].value":area.choice1,
            "riderCommentList[1].value":area.choice2,
            "riderCommentList[2].value":area.choice3,
            "riderCommentList[3].value":area.choice4,
            answer:area.answer,
            id:area.id
          })
      }
    })
  },

  sub:function(){
    var that=this;
    if (that.data.riderCommentList[0].selected) {
      if (that.data.riderCommentList[1].selected) {
        if (that.data.riderCommentList[2].selected) {
          if (that.data.riderCommentList[3].selected) {
            that.setData({
              a:"ABCD"
            })
          }else{
            that.setData({
              a:"ABC"
            })
          }
        }else{
          if (that.data.riderCommentList[3].selected) {
            that.setData({
              a:"ABD"
            })
          }else{
            that.setData({
              a:"AB"
            })
          }
        }
      }else{
        if (that.data.riderCommentList[2].selected) {
          if (that.data.riderCommentList[3].selected) {
            that.setData({
              a:"ACD"
            })
          }else{
            that.setData({
              a:"AC"
            })
          }
        }else{
          if (that.data.riderCommentList[3].selected) {
            that.setData({
              a:"AD"
            })
          }else{
            that.setData({
              a:"A"
            })
          }
        }
      }
    }else{
      if (that.data.riderCommentList[1].selected) {
        if (that.data.riderCommentList[2].selected) {
          if (that.data.riderCommentList[3].selected) {
            that.setData({
              a:"BCD"
            })
          }else{
            that.setData({
              a:"BC"
            })
          }
        }else{
          if (that.data.riderCommentList[3].selected) {
            that.setData({
              a:"BD"
            })
          }else{
            that.setData({
              a:"B"
            })
          }
        }
      }else{
        if (that.data.riderCommentList[2].selected) {
          if (that.data.riderCommentList[3].selected) {
            that.setData({
              a:"CD"
            })
          }else{
            that.setData({
              a:"C"
            })
          }
        }else{
          if (that.data.riderCommentList[3].selected) {
            that.setData({
              a:"D"
            })
          }else{
            that.setData({
              a:""
            })
          }
        }
      }
    }
    if(that.data.a===that.data.answer){
      wx.showToast({
        title: '回答正确',
        duration: 2000//持续的时间
      })
      
    }
    else{
      wx.request({
        url: 'http://localhost:8889/addTest2',
        data: { question: that.data.question,choice1:that.data.riderCommentList[0].value,choice2:that.data.riderCommentList[1].value,choice3:that.data.riderCommentList[2].value,choice4:that.data.riderCommentList[3].value,answer:that.data.answer},
        method:'GET',
        success:function(res){
          console.log(res.data)
        }
      })
      wx.showToast({
        title: '回答错误',
        duration: 2000//持续的时间
      })
    }
  },
  sub5:function(){
    var that=this;
    that.data.id=that.data.id+1;
    that.setData({
      'riderCommentList[0].selected':false,
      'riderCommentList[1].selected':false,
      'riderCommentList[2].selected':false,
      'riderCommentList[3].selected':false,
    })
    that.onLoad();
  },
  outTest:function(){
    var that = this;
    wx.request({
      url: 'http://localhost:8889/add_cTest2',
      data: { question: that.data.question,choice1:that.data.riderCommentList[0].value,choice2:that.data.riderCommentList[1].value,choice3:that.data.riderCommentList[2].value,choice4:that.data.riderCommentList[3].value,answer:that.data.answer},
      success:function(){
        wx.showToast({
          title: '已收藏',
          duration: 2000//持续的时间
        })
      }
    })
   }
 
})
