package com.yling.common.beetl.tag;

import com.yling.common.page.Page;
import org.beetl.core.Tag;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/20.
 * 修改人：
 */
public class PageTag extends Tag
{
    private static final int PAGE_SPACE = 5;//收尾间隔
    private Page page;
    private String url;
    private List<ParamTag> paramTags;
    @Override
    public void render()
    {
        initPageTag();
        HttpServletRequest request = (HttpServletRequest) ctx.getGlobal("request");
        TagContent tc = new TagContent();
        tc.setTag(this);
        request.setAttribute("tagContent",tc);
        doBodyRender();
        tc = (TagContent) request.getAttribute("tagContent");
        List<TagContent> childs = tc.getChilds();
        if(childs!=null)
        {
            paramTags = new ArrayList<>();
            for (TagContent child : childs)
            {
                paramTags.add((ParamTag) child.getTag());
            }
        }
        request.removeAttribute("tagContent");
        String html = createPageHtml();
        try
        {
            ctx.byteWriter.writeString(html);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private String createPageHtml()
    {
        if(page.getTotalSize()>0)
        {
            String addUrl = createAddUrl();
            url = url+"?"+addUrl;
            StringBuffer sb = new StringBuffer();
            sb.append("<div class=\"row\">")
                    .append("<div class=\"col-md-4 sm-center\">")
                    .append("   <div class=\"dataTables_info\" id=\"inlineEditDataTable_info\">")
                    .append("共有&nbsp;"+page.getTotalSize()+"&nbsp;条数据")
                    .append("   </div>" +
                            "</div>");
            if(page.getTotalNum()>1)
            {
                sb.append("<div class=\"col-md-4\"></div>");
                sb.append("<div class=\"col-md-4 text-right sm-center\">")
                  .append("     <div class=\"dataTables_paginate paging_bootstrap paging_custombootstrap\">")
                  .append("         <ul class=\"pagination\">");
                if(page.isFirstPage())
                    sb.append("<li class=\"prev disabled\"><a href=\"#\"><<</a></li>");
                else sb.append("<li class=\"prev\"><a href=\""+url+"pageNo=1&pageSize="+page.getPageSize()+"\"><<</a></li>");

                int start = 1,end = start + PAGE_SPACE;
                if(!page.isFirstPage())
                {
                    start = page.getPageNo() - 1;
                    while ((page.getTotalNum() - start)<PAGE_SPACE && start>1)
                    {
                        start --;
                    }
                    end = start + PAGE_SPACE;
                }
                end = end>page.getTotalNum()?page.getTotalNum():end;
                for(int i=start;i<=end;i++)
                {
                    if(i== page.getPageNo())
                        sb.append("<li class=\"active\"><a>"+i+"</a></li>");
                    else sb.append("<li class=\"\"><a href=\""+url+"pageNo="+i+"&pageSize="+page.getPageSize()+"\">"+i+"</a></li>");
                }
                if(page.isLastPage())
                    sb.append("<li class=\"next disabled\"><a href=\"#\">>></a></li>" +
                            "</ul>" +
                            "</div>" +
                            "</div>");
                else sb.append("<li class=\"next\"><a href=\""+url+"pageNo="+page.getTotalNum()+"&pageSize="+page.getPageSize()+"\">>></a></li>" +
                        "</ul>" +
                        "</div>" +
                        "</div>");
            }
            sb.append("</div> ");
            return sb.toString();
        }
        return "";
    }

    private String createAddUrl()
    {
        if(paramTags!=null)
        {
            StringBuffer sb = new StringBuffer();
            for (ParamTag paramTag : paramTags)
            {
                sb.append(paramTag.getKey()).append("=").append(paramTag.getValue()).append("&");
            }
            return sb.toString();
        }
        return "";
    }

    private void initPageTag()
    {
        Map<String, Object> argMap = (Map<String, Object>) args[1];
        this.page = (Page) argMap.get("page");
        this.url = (String) argMap.get("url");
    }
}
