function loadPageInf(totalPage, totalSize, currentPage, cid, rname) {
    //设置总页数等信息
    $("#totalPage").html(totalPage);
    $("#totalCount").html(totalSize);



    //共显示10页   前4 后 5 ，前不足4  从1开始  ，后不足五，从最后往前数
    var start=currentPage-4;
    var end=currentPage+5;
    //总页数少于10
    if (totalPage<10){
        start = 1;
        end = totalPage;
    } else {
        //前面不够4页，则总1开始，到10
        if (start<1){
            start=1;
            end=10;
        }else if (end>totalPage) {
            //后面不够5
            end = totalPage;
            start = end-9;
        }
    }

    var ul="";
    var firstPage = '<li><a href="javascript:load_page('+cid+','+1+',\''+rname+'\')">首页</a></li>';
    var before = currentPage-1;
    if (before<1){
        before=1;
    }
    var befPage = '<li class="threeword" onclick="javascript:load_page('+cid+','+before+',\''+rname+'\')"><a href="javascript:void(0)">上一页</a></li>';
    ul +=firstPage;
    ul +=befPage;
    for (var i = start; i <= end ; i++) {
        var li_2;
        if (i === currentPage){
            li_2 = '<li class="curPage" onclick="javascript:load_page('+cid+','+i+',\''+rname+'\')"><a href="javascript:void(0)">'+i+'</a></li>';
        } else {
            li_2 = '<li onclick="javascript:load_page('+cid+','+i+',\''+rname+'\')"><a href="javascript:void(0)">'+i+'</a></li>';
        }
        ul +=li_2;
    }
    var next = currentPage+1;
    if (next>totalPage){
        next =totalPage;
    }
    var nextPage = '<li class="threeword" onclick="javascript:load_page('+cid+','+next+',\''+rname+'\')"><a href="javascript:void(0)">下一页</a></li>';
    var lastPage = '<li class="threeword"><a href="javascript:load_page('+cid+','+totalPage+',\''+rname+'\')">末页</a></li>';
    ul +=nextPage;
    ul +=lastPage;
    $("#pageNum").html(ul);
}