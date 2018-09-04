package cn.wmyskxz.springboot.common;


import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController<T> {
    private static final String DATA = "data";
    private static final String TOTAL = "total";

    protected BaseController() {
    }

    public PageInfo<T> getPageInfo(Pager pager, List<T> rows) {
        PageInfo<T> pageInfo = new PageInfo();
        pageInfo.setList(rows);
        pageInfo.setCount((long)pager.getRowCount());
        pageInfo.setPageSize(pager.getPageSize());
        pageInfo.setPageCount((long)pager.getPageCount());
        pageInfo.setPageNo(pager.getPageId());
        return pageInfo;
    }

    public static Map<String, Object> getGridData(int total, List<?> rows) {
        Map<String, Object> response = new HashMap();
        response.put("total", total);
        response.put("data", rows);
        return response;
    }

    public static Map<String, Object> getData(Object data) {
        Map<String, Object> response = new HashMap();
        response.put("data", data);
        return response;
    }

    public static void download(HttpServletResponse response, File file) throws IOException {
        download(response, file, file.getName());
    }

    public static void download(HttpServletResponse response, File file, String fileName) throws IOException {
        FileInputStream in = new FileInputStream(file);
        Throwable var4 = null;

        try {
            download(response, (InputStream)in, fileName);
        } catch (Throwable var13) {
            var4 = var13;
            throw var13;
        } finally {
            if (in != null) {
                if (var4 != null) {
                    try {
                        in.close();
                    } catch (Throwable var12) {
                        var4.addSuppressed(var12);
                    }
                } else {
                    in.close();
                }
            }

        }

    }

    public static void download(HttpServletResponse response, InputStream in, String fileName) throws IOException {
        response.setContentType("application/x-msdownload;");
        response.addHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        response.setCharacterEncoding("UTF-8");
    }
}
