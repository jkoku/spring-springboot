package com.yedam.app.upload.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@Value("${file.upload.path}")
	private String uploadPath;
	
	@GetMapping("upload") // upload 리턴하는 파일이름 
	//classpath:/templates/upload.html
	public void getUploadPage() {} // void 경로가 파일경로와 같을 경우.
	
	@PostMapping("formUpload") // 5-p28 
	public String formUploadFile(@RequestPart MultipartFile[] images) { // 파일에 대한 정보를  MultipartFile배열이 받는다. images이쪽으로 넘어온다. 
		for (MultipartFile image : images) {
			if(image.getContentType().startsWith("image") == false) { // 내가 받은데 이미지인지 아닌지 확인
				System.err.println("No Image");
				return null;
			}
			String originalName = image.getOriginalFilename();
			System.out.println("original : " + originalName);
			String fileName = originalName.substring(originalName.lastIndexOf("//")+1); // 경로 윈도우 이스케이프 문자로 들어가서 // 두개 
			System.out.println("fileName : " + fileName);
			
			// String uploadPath = "C:\\upload"; // 저장하고자 하는 경로. private String uploadPath; 이거 가져와
			String saveName =uploadPath + File.separator + fileName; // 지금 업로드하고자하는 파일 자바는 "//" 인식못함. 실제로 자바는 File.separator 사용. 자바가 인식하는 경로구분자
			System.out.println("saveName : " + saveName);
			
			Path savePath = Paths.get(saveName); // Path를 기반으로 실제 경로정보로 변환하는 작업 Paths.get(saveName)
			
			try {
				image.transferTo(savePath); // transferTo 실제 파일을 저장하는 메소드. 파일자체이동코드는 이 한줄. 
			} catch ( IOException e) {
				e.printStackTrace();
			}
		}
		return "upload";
		
	}
	
	//

	@PostMapping("/uploadsAjax")
	@ResponseBody
	public List<String> uploadFile(@RequestPart MultipartFile[] uploadFiles) {
	    
		List<String> imageList = new ArrayList<>();
		
	    for(MultipartFile uploadFile : uploadFiles){
	    	if(uploadFile.getContentType().startsWith("image") == false){
	    		System.err.println("this file is not image type");
	    		return null;
	        }
	  
	        String originalName = uploadFile.getOriginalFilename();
	        String fileName = originalName.substring(originalName.lastIndexOf("//")+1);
	        
	        System.out.println("fileName : " + fileName); 
	    
	        //날짜 폴더 생성
	        String folderPath = makeFolder(); 
	        //UUID 
	        String uuid = UUID.randomUUID().toString(); 
	        //저장할 파일 이름 중간에 "_"를 이용하여 구분 // 밀리초단위 시간기준삼아랜덤으로 유니크값
	        
	        String uploadFileName = folderPath +File.separator + uuid + "_" + fileName;
	        
	        String saveName = uploadPath + File.separator + uploadFileName;
	        
	        Path savePath = Paths.get(saveName);
	        //Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
	        System.out.println("path : " + saveName);
	        try{
	        	uploadFile.transferTo(savePath);
	            //uploadFile에 파일을 업로드 하는 메서드 transferTo(file)
	        } catch (IOException e) {
	             e.printStackTrace();	             
	        }
	        // DB에 해당 경로 저장
	        // 1) 사용자가 업로드할 때 사용한 파일명
	        // 2) 실제 서버에 업로드할 때 사용한 경로
	        imageList.add(setImagePath(uploadFileName)); //
	     }
	    
	    return imageList;
	}
	private String makeFolder() {
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		// LocalDate를 문자열로 포멧
		String folderPath = str.replace("/", File.separator); // 경로로 인식할 수 있도록 File.separator  운영체제와 상관없이 자바가. 
		
		File uploadPathFoler = new File(uploadPath, folderPath); // 파일생성. 업로드경로uploadPath밑에 folderPath가지고온 연도워일기반으로한 폴다합쳐서하나.
		// File newFile= new File(dir,"파일명");
		if (uploadPathFoler.exists() == false) {
			uploadPathFoler.mkdirs(); // 디렉토리있는지 확인. 없으면 생성. 
			// 만약 uploadPathFolder가 존재하지않는다면 makeDirectory하라는 의미입니다.
			// mkdir(): 디렉토리에 상위 디렉토리가 존재하지 않을경우에는 생성이 불가능한 함수
			// mkdirs(): 디렉토리의 상위 디렉토리가 존재하지 않을 경우에는 상위 디렉토리까지 모두 생성하는 함수
		}
		
		return folderPath;
	}
	 
	private String setImagePath(String uploadFileName) {
		return uploadFileName.replace(File.separator, "/");
	}

	
	
}


