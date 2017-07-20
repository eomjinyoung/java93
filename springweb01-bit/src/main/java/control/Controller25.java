/* Spring WebMVC: JSON 콘텐츠로 응답하기 + 파일 업로드 + thumbnail 파일 생성
 * => AJAX 파일 업로드
 * 
 */
package control;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequestMapping("/control/controller25/") 
public class Controller25 {
  
  @Autowired ServletContext ctx;
  
  @RequestMapping(path="upload")
  public Object upload(MultipartFile[] files) throws Exception {
    
    ArrayList<Object> fileList = new ArrayList<>();
    
    for (int i = 0; i < files.length; i++) {
      if (files[i].isEmpty()) 
        continue;
      
      String newFilename = this.getNewFilename();
      File file = new File(ctx.getRealPath("/upload/" + newFilename));
      files[i].transferTo(file);
      
      File thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_80"));
      Thumbnails.of(file).size(80, 80).outputFormat("png").toFile(thumbnail); 

      thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_140"));
      Thumbnails.of(file).size(140, 140).outputFormat("png").toFile(thumbnail);
      
      thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_200"));
      Thumbnails.of(file).size(200, 200).outputFormat("png").toFile(thumbnail);
        
      HashMap<String,Object> fileMap = new HashMap<>();
      fileMap.put("filename", newFilename);
      fileMap.put("filesize", files[i].getSize());
      fileList.add(fileMap);
    }
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("fileList", fileList);
    return resultMap;
  }
  
  int count = 0;
  synchronized private String getNewFilename() {
    if (count > 100) {
      count = 0;
    }
    return String.format("%d_%d", System.currentTimeMillis(), ++count); 
  }
}









































