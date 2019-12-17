package com.zhanghao.handler;

import java.sql.ResultSet;

public interface ResultSetHandler {
    Object handle(ResultSet rs);
}
