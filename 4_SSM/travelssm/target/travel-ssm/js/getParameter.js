//根据传递过来的参数name获取对应的值
//这样获取的值可能为 null字符串
function getParameter(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    var r = location.search.substr(1).match(reg);
    if (r!=null) return (r[2]);
    return null;
}