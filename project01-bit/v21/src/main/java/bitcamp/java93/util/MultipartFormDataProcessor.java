package bitcamp.java93.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class MultipartFormDataProcessor {
  public static Map<String,FileItem> parse(HttpServletRequest request) throws Exception {
    DiskFileItemFactory partFactory = new DiskFileItemFactory();
    ServletFileUpload partParser = new ServletFileUpload(partFactory);
    List<FileItem> partList = partParser.parseRequest(request);
    
    HashMap<String,FileItem> partMap = new HashMap<>();
    for (FileItem part : partList) {
      partMap.put(part.getFieldName(), part);
    }
    return partMap;
  }
}
