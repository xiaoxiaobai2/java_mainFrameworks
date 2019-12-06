package com.zhanghao.domain;

import java.util.ArrayList;
import java.util.List;

public class QueryVo {
    private List<Integer> uids = new ArrayList<Integer>();

    public QueryVo(List<Integer> uids) {
        this.uids = uids;
    }

    public List<Integer> getUids() {
        return uids;
    }

    public void setUids(List<Integer> uids) {
        this.uids = uids;
    }
}
