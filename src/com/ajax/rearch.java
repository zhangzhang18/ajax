package com.ajax;

import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop01 on 16-11-8.
 */
public class rearch extends HttpServlet {
    static private   List<String> datas=new ArrayList<String>();
    static {
        datas.add("ajax");
        datas.add("ajax post");
        datas.add("bill");
        datas.add("james");
        datas.add("cook");
        datas.add("ajax get");
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        String keyword=httpServletRequest.getParameter("keyword");
        System.out.print("123");
       System.out.print(keyword);
        List<String> listdata=getDate(keyword);
        //返回json格式
        System.out.println(JSONArray.fromObject(listdata));
        httpServletResponse.getWriter().write(JSONArray.fromObject(listdata).toString());

    }
    //获得关联数据
    private List<String> getDate(String keyword){
        List<String> list=new ArrayList<String>();


        for(String data:datas){
          if (data.contains(keyword)){
              list.add(data);
          }
        }
        return list;
    }
}
