package cn.itsource.springmvc.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.smart.cloudantDB.AnalysisResultInfo;
import com.smart.cloudantDB.DataAnalysisInfo;
import com.smart.cloudantDB.DatabaseLoginOperation;
import com.smart.cloudantDB.DatabaseResultOperation;
import com.smart.cloudantDB.DatabaseSparkOperation;
import cn.itsource.springmvc.web.frontItem.FrontResultItem;
import cn.itsource.springmvc.web.frontItem.LoginItem;
import cn.itsource.springmvc.web.frontItem.ResultOnMapItem;
import cn.itsource.springmvc.web.frontItem.SignUpItem;

@Controller //控制器controller
public class AnnController {
	//the function of login
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) throws JSONException, IOException  {
		HttpSession session=request.getSession(true);   
		ModelAndView mav=new ModelAndView();
			String username=(String) request.getParameter("username");
			String password=(String) request.getParameter("password");
			System.out.println("username:"+username+"password:"+password);
			if(username==null && password==null){
				mav.setViewName("/login");
				//System.out.print("1");
			}else{
				username=username.trim();
				password=password.trim();
				if(validLogin(username,password)){
					session.setAttribute("username", username);
					System.out.print("session:"+session.getAttribute("username"));
					mav = new ModelAndView("redirect:/frontPage");//redirect模式  
				}else{
					mav.addObject("error", "The username or password you specified are not correct");
					mav.setViewName("/login");
				}
			}
		return mav;
	}
	
	
	//compared with the database about the login
	public boolean validLogin(String username, String password){
		DatabaseLoginOperation dbOperation = new DatabaseLoginOperation();
		if(username==null || username.trim().length()==0 || password==null || password.trim().length()==0){
			return false;
		}else{
			if(dbOperation.matchUserPassword(username, password)){
				return true;
			}
			else{
				return false;
			}
		}
	}

	
	@RequestMapping("/signUp")
	public ModelAndView signUp(HttpServletRequest request, HttpServletResponse response)
			throws JSONException, IOException {
		//1. connect to database
		DatabaseLoginOperation dbOperation = new DatabaseLoginOperation();
		
		//2.Get the information from website
		ModelAndView mav = new ModelAndView();
		String name = (String) request.getParameter("name");
		String username = (String) request.getParameter("username");
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		String confirm = (String) request.getParameter("confirm");
		System.out.println("password:" + password + "confirm:" + confirm);
		if (confirm == null && password == null && name == null && username == null && email == null) {
			mav.setViewName("/signUp");
		} else {

		//3.remove the blank
			name=name.trim();
			email=email.trim();
			username=username.trim();
			email=email.trim();
			password=password.trim();
			confirm=confirm.trim();
		//check the information the users input
			if (dbOperation.containUserName(username)||password.equals("") || confirm.equals("") || name.equals("") || username.equals("")|| email.equals("") || !password.equals(confirm)) {
				if (username.equals("")) {
					mav.addObject("usernameerrror", "Username cannot be empty.");
				}
				
				if (username.equals("")) {
					mav.addObject("usernameerrror", "Username cannot be empty.");
				}
				
				if (dbOperation.containUserName(username)) {
					System.out.println("has registered");
					mav.addObject("usernameerrror", "Username has been registered.");
				}
				
				if (email.equals("")) {
					mav.addObject("emailerror", "Email cannot be empty.");
				}
				if (password.equals("")) {
					mav.addObject("passworderror", "Password cannot be empty.");
				}
				if (!password.equals(confirm)) {
					mav.addObject("passworderror", "Confirm your password.");
				}
				System.out.println("ssss");
				mav.setViewName("/signUp");
			}else{
				System.out.print("successe");
				//insert the information to the database
				//remove the blank
				name=name.trim();
				email=email.trim();
				username=username.trim();
				email=email.trim();
				password=password.trim();
				//insert into database
				ArrayList<String> list = new ArrayList<String>();
				list.add(name);
				list.add(email);
				list.add(username);
				list.add(password);
				dbOperation.insert(list);
				
				HttpSession session=request.getSession(true);   
				session.setAttribute("username", username);
				mav.setViewName("redirect:/frontPage");
			}
		}
		return mav;
	}
	
	
	//the function of logout
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) throws JSONException, IOException  {
		request.getSession().removeAttribute("username");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/login");
		return mav;
	}
	
	//The front page
	@RequestMapping("/frontPage")
	public ModelAndView frontPage( ){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/frontPage");
		return mav;	
	}

	
	//when user input personal information to the front page
	@RequestMapping("/frontPage/receive")
	public ModelAndView receive(DataAnalysisInfo dataAnalysisInfo){
		ArrayList<String> array=new ArrayList<>();
		array.add(dataAnalysisInfo.getZipcode());
		array.add(dataAnalysisInfo.getIncome());
		array.add(dataAnalysisInfo.getAge());
		array.add(dataAnalysisInfo.getGender());
		array.add(dataAnalysisInfo.getShopping_way());
		String item=transformItem(dataAnalysisInfo.getShopping_content());
		array.add(item);
		System.out.println("7777777"+array.toString());
		DatabaseSparkOperation dso=new DatabaseSparkOperation();
		dso.insert(array);
		
		ModelAndView mav=new ModelAndView();
		FrontResultItem fr=new FrontResultItem();
		fr.setResult_item(dataAnalysisInfo.getShopping_content());
		fr.setResult_zipcode(dataAnalysisInfo.getZipcode());
		List<FrontResultItem> result=new ArrayList<>();
		result.add(fr);
		mav.addObject("dataAnalysisInfo", result);
		mav.setViewName("redirect:/frontPage");
		
		return mav;
	}
	
	
	@RequestMapping("/result")
	public ModelAndView zipcoderesult( ){
		//String[] addresses={"95112","95113"};
		List<Integer> addresses=new ArrayList<>();
		addresses.add(95112);
		addresses.add(95113);
		/*String[] addresses={"95112","95113"};*/
		//String addresses="95112";
		ModelAndView mav=new ModelAndView();
		mav.addObject("addresses", addresses);
		mav.setViewName("/GMap");
		return mav;	
	}
	
	@RequestMapping("/service")
	public ModelAndView service( ){
		System.out.println("service initial");
		ModelAndView mav=new ModelAndView(); 
		mav.setViewName("/service-save-good2");
		return mav;	
	}
	
	
	/*@RequestMapping("/service/receive")
	public ModelAndView serviceReceive(String shopping_content ){
		ModelAndView mav=new ModelAndView(); 
		String url="redirect:/content/"+shopping_content;
		mav.setViewName(url);
		return mav;	
	}*/
	
	
	/*@RequestMapping("/content/{content}")
	public ModelAndView servicecontent(@PathVariable("content") String content,HttpServletRequest request,HttpServletResponse response) throws JSONException, IOException{
		ModelAndView mav=new ModelAndView(); 
		List<ResultOnMapItem> resultOnMapItem=new ArrayList<>();
		String[] array={"95112","95123","95113"};
		
		if(content.equals("Apple MacPro")){
			for(int i=0;i<array.length;i++){
				ResultOnMapItem resultItem=new ResultOnMapItem();
				resultItem.setMessage(array[i]);
				resultItem.setZipcode(array[i]);
				resultOnMapItem.add(resultItem);
			}
		}else{
			ResultOnMapItem resultItem=new ResultOnMapItem();
			resultItem.setMessage("95112");
			resultItem.setZipcode("95112");
		}
		
		mav.addObject("resultOnMapItem", resultOnMapItem);
		return mav;
		
	}*/
	
	
	@RequestMapping("/result2")
	public void result2(HttpServletRequest request,HttpServletResponse response) throws IOException, JSONException {
		JSONArray jsons=new JSONArray();
		String shopping_content = request.getParameter("shopping_content");
		String item=transformItem(shopping_content);
		System.out.println(item);
		System.out.println("fffffueueuue");
		String[] AppleMacBookResult={"95129","95123","92145","95119"};
		String[] AppleMacBookResultNum={"624","506","532","508"};
		
		String[] TeaResult={"94027","92145"};
		String[] TeaResultNum={"574","554"};
		
		String[] ColaResult={"95129","95123","95119"};
		String[] ColaResultNum={"756","507","508"};
		
		String[] BadminRacketResult={"95129","95123","94027","92145"};
		String[] BadminRacketResultNum={"630","518","549","581"};
		
				
		//For test
		//String[] items={"Apple MacPro","Tea","Badmin Racket","Cola"};
		String[] zipcodes={"95129","95133","95112","95123"};
		if(item.equals("Apple MacPro")){
			for(int i=0;i<AppleMacBookResult.length;i++){
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("zipcode", AppleMacBookResult[i]);
				jsonObject.put("message", AppleMacBookResult[i]);
				jsons.put(jsonObject);	
			}
		}
		
		if(item.equals("Tea")){
			for(int i=0;i<TeaResult.length;i++){
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("zipcode", TeaResult[i]);
				jsonObject.put("message", TeaResult[i]);
				jsons.put(jsonObject);	
			}
			
		}
		
		if(item.equals("Badmin Racket")){
			for(int i=0;i<BadminRacketResult.length;i++){
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("zipcode", BadminRacketResult[i]);
				jsonObject.put("message", BadminRacketResult[i]);
				jsons.put(jsonObject);	
			}
			
		}
		
		if(item.equals("Cola")){
			for(int i=0;i<ColaResult.length;i++){
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("zipcode", ColaResult[i]);
				jsonObject.put("message", ColaResult[i]);
				jsons.put(jsonObject);	
			}
			
		}
		
		response.getWriter().print(jsons.toString());
		//For test end
		
		
		//To search the database
		
		/*List<AnalysisResultInfo> results=SearchResults(item);
		if(results==null){
			System.out.print("no result");
			response.getWriter().print(jsons.toString());
		}else{
			for(int i=0;i<results.size();i++){
				System.out.print("number i:"+i);
				JSONObject jsonObject=new JSONObject();
				Double evaluation=results.get(i).getEvaluation();
				String zipcode=results.get(i).getZipcode();
				String message="ZipCode:"+zipcode+". \n"+"Evaluation:"+evaluation+". \n";
				String description=results.get(i).getDescription();
				if(!description.equals("")){
					message=message+"Description:"+description;
				}
			
				jsonObject.put("message",message);
				jsonObject.put("zipcode",results.get(i).getZipcode());
				jsons.put(jsonObject);
			}
			response.getWriter().print(jsons.toString());
		}*/
		
		//search the database end
		
		
	}
	
	//transform item
	public String  transformItem(String str){
		String ss;
		/*String[] result={"Books & Audible", 
				"Movies, Music & Games",
				"Electronics & Computers",
				"Home, Garden & Tools",
				"Beauty, Health & Grocery",
				"Toys, Kids & Baby",
				"Clothing, Shoes & Jewelry",
				"Handmade",
				"Sports & Outdoors",
				"Automotive & Industrial"};*/


		String[] result={"Apple MacPro","Tea","Cola","Badmin Racket"};
		
		int i=Integer.parseInt(str);
		ss=result[i];
		return ss;
	}
	
	
	
	
	//search the result
	public List<AnalysisResultInfo> SearchResults(String shopping_content){
		DatabaseResultOperation dataBaseResultOperation=new DatabaseResultOperation();
		List<AnalysisResultInfo> dataBaseResult=dataBaseResultOperation.select("shopping_content", "eq", shopping_content);
		//System.out.println("results number:"+dataBaseResult.size());
		return dataBaseResult;
	}
	

	///test/{variable1}
	/*@RequestMapping("/frontPage/{username}")
	public ModelAndView frontPageWithName( @PathVariable String username){
		System.out.println("frontpage with login, username="+username);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/frontPage");
		return mav;	
	}*/
		
	
	
	@RequestMapping("/signUpResult")
	public ModelAndView signUpResult(SignUpItem signUpItem ){
		ModelAndView mav=new ModelAndView();
		String username=signUpItem.getUsername().trim();
		String email=signUpItem.getEmail().trim();
		String password=signUpItem.getPassword().trim();
		String confirm=signUpItem.getConfirm().trim();
		
		if(password!=confirm){
			System.out.println("please confirm your password");	
			mav.addObject("error", "error");
			mav.setViewName("/signUp");
		}else{
			System.out.println("sign up and return to the front page");
			mav.setViewName("redirect:/frontPage");
		}
		
		//mav.setViewName("/frontPage");
		return mav;	
		//return null;
	}
	
	

	


}
