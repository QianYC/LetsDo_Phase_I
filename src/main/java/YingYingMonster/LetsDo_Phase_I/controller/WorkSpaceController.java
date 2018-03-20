package YingYingMonster.LetsDo_Phase_I.controller;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import YingYingMonster.LetsDo_Phase_I.model.User;
import YingYingMonster.LetsDo_Phase_I.service.DataService;
import YingYingMonster.LetsDo_Phase_I.service.RepositoryService;
import YingYingMonster.LetsDo_Phase_I.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/workSpace")
@Api()
public class WorkSpaceController {

	@Autowired
	private RepositoryService repoService;
	@Autowired
	private DataService dataService;
	
	
	/**
	 * 
	 * @return 展示名下正在进行的项目
	 */
	@GetMapping("/{id}")
	@ResponseBody
	public String getProjectOverview() {
		
		return "projectOverview";
	}
	
	/**
	 * 
	 * @return 进入工作间
	 */
	@GetMapping("/{id}/{projectId}")
	@ResponseBody
	public String getWorkSpace() {
		
		return "workSpace";
	}	
	
	/**
	 * 获得一张图片
	 * @param request
	 * @param response
	 * @param id
	 * @param projectId
	 * @throws Exception
	 */
    @RequestMapping("/getPic/{id}/{projectId}/{pictureId}")  
    @ApiOperation(value="",notes="获得一张图片")
    @ResponseBody  
    public void getImage(HttpServletRequest request, HttpServletResponse response,@PathVariable("id")String id,@PathVariable("projectId")String projectId) throws Exception{  
    String JPG="image/jpeg;charset=UTF-8";      
        // 本地文件路径  
        String filePath ="C:\\Users\\lenovo\\Desktop\\a.jpg";
        if(id.equals("a")) {
        	 filePath ="C:\\Users\\lenovo\\Desktop\\b.jpg";
        }
        File file = new File(filePath);  
        // 获取输出流  
        OutputStream outputStream = response.getOutputStream();  
        FileInputStream fileInputStream = new FileInputStream(file);  
        // 读数据  
        byte[] data = new byte[fileInputStream.available()];  
        fileInputStream.read(data);  
        fileInputStream.close();  
        // 回写  
        response.setContentType(JPG);  
        outputStream.write(data);  
        outputStream.flush();  
        outputStream.close();  
    }  
    
    /**
     * 提交Tag
     * @param request
     * @param response
     */
    @PostMapping("/submit/{id}/{projectId}/{pictureId}")
    public void submitTag(HttpServletRequest request, HttpServletResponse response) {
    	
    }
    
    /**
     * 已完成的图片
     * @param request
     * @param response
     */
    @RequestMapping("/pictureAlreadyDone")
    public void pictureAlreadyDone(HttpServletRequest request, HttpServletResponse response) {
    	
    }
    
    /**
     * 未完成的图片
     * @param request
     * @param response
     */
    @RequestMapping("/pictureToBeDone")
    public void pictureToBeDone(HttpServletRequest request, HttpServletResponse response) {
    	
    }
}
