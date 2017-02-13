package com.yling.common.page;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/13.
 * 修改人：
 */
public class SimplePage
{
    protected int totalSize;
    protected int totalNum;
    protected int pageSize;
    protected int pageNo;
    public static final int DEFAULT_PAGE_SIZE = 10;

    public SimplePage(int pageNo, int pageSize, int totalSize)
    {
        setTotalSize(totalSize);
        setPageNo(pageNo);
        setPageSize(pageSize);
        int totalNum = this.totalSize / this.pageSize;
        if (totalNum == 0 || this.totalSize % this.pageSize != 0) {
            totalNum++;
        }
        this.totalNum = totalNum;
        if(this.pageNo>totalNum)
            this.pageNo = totalNum;
    }

    public boolean isFirstPage()
    {
        return pageNo <= 1;
    }

    public boolean isLastPage()
    {
        return pageNo >= getTotalNum();
    }

    public int getNextPage()
    {
        if(isLastPage())
            return pageNo;
        return pageNo+1;
    }

    public int getPrevPage()
    {
        if(isFirstPage())
            return pageNo;
        return pageNo-1;
    }

    public int getTotalSize()
    {
        return totalSize;
    }

    private void setTotalSize(int totalSize)
    {
        this.totalSize = totalSize>0?totalSize:0;
    }

    public int getTotalNum()
    {
        return totalNum;
    }

    public void setTotalNum(int totalNum)
    {
        this.totalNum = totalNum;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize>0?pageSize:DEFAULT_PAGE_SIZE;
    }

    public int getPageNo()
    {
        return pageNo;
    }

    public void setPageNo(int pageNo)
    {
        this.pageNo = pageNo>0?pageNo:1;
    }

    @Override
    public String toString()
    {
        return Json.toJson(this, JsonFormat.compact());
    }
}
