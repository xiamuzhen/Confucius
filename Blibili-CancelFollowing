var time = 250; // 暂停250毫秒
var index = 0;
var cancel = $(".be-dropdown-item:contains('取消关注')");
console.log("本页关注了", cancel.length, "个up主！");
stop = setInterval(function () {
    if (0 <= index && index < cancel.length) {
        cancel[index].click(); // 自动点击【取消关注】
    } else {
        clearInterval(stop); // 停止批量操作
        console.log("OK！你已取消了对本页所有up主的关注！");
    }
    index += 1;
}, time + index * 10); // 暂停多少毫秒，再执行下一次点击，时间间隔增加一点儿变化
