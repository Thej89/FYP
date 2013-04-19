/*
 * Final Year Project(EasyContact)
 */

package fyp.thej.web.controller;

import fyp.thej.model.User;
import fyp.thej.sessionbean.EasyContactSessionBeanLocal;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * ApplicationController
 * Mar 11, 2013 12:17:07 PM
 * Thejanee Walgamage <2008061>
 */

@Controller
public class ApplicationController {
    EasyContactSessionBeanLocal easyContactSessionBean = lookupEasyContactSessionBeanLocal();

    /**
     * index page will be loaded through this method when the application
     * initially starts.
     *
     * @param model
     * @return redirect page name
     */
    @RequestMapping("/index.htm")
    public String loadIndex(ModelMap model) {
        
        return "index";
    }
    
     
    @RequestMapping("/login.htm")
    public String authenticateUser(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws JSONException {
       
        String username = null;
        String password = null;
        
        username = request.getParameter("username_login");
        password = request.getParameter("password_login");
//        List<Attendance> attendanceList = new ArrayList<Attendance>();
        boolean result = easyContactSessionBean.authenticateUser(username, password);
        if(result){
            return "home";
        } else {
            model.addAttribute("errorMsg", "Incorrect Login Details");
            return "index";
        }
    }
    
     @RequestMapping("/logout.htm")
    public String logout(ModelMap model) {
        model.addAttribute("errorMsg", "Successfully logged out");
        return "index";
    }
     
      /**
     *
     * @param request
     * @param response
     * @param model
     * @return
     * @throws JSONException
     */
    @RequestMapping(value="/saveAllFriends.htm", method= RequestMethod.POST)
    public String saveAllFriends(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws JSONException {
       
        String friendString = "abc";
        
         System.out.println("/////////////// innnn");
        friendString = (String) request.getParameter("friendsString");
        System.out.println("---------------------- "+friendString);
//        List<Attendance> attendanceList = new ArrayList<Attendance>();
//        if(friendString!=null){
//            easyContactSessionBean.saveAllFriends(friendString);
            return "home";
//        } else {
        
//            model.addAttribute("errorMsg", "Incorrect Login Details");
       
//            return "index";
//        }
    }
    
        @RequestMapping("/signup.htm")
    public String signup(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws JSONException {
       
        String username = null;
        String password = null;
        String firstname = null;
        String email = null;
        User user = new User();
        
        username = request.getParameter("username");
        password = request.getParameter("password");
        firstname = request.getParameter("firstname");
        email = request.getParameter("email");
        
        user.setUsername(username);
        user.setPassword(password);
        user.setUserEmail(email);
        user.setUserFirstName(firstname);
//        List<Attendance> attendanceList = new ArrayList<Attendance>();
        String result = easyContactSessionBean.signup(user);
//        if(result){
//            return "home";
//        } else {
//            model.addAttribute("errorMsg", "Incorrect Login Details");
//            return "index";
//        }
        return null;
    }
        
    @RequestMapping("/backupContacts.htm")
    public String backupContacts(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws JSONException {
        
        String backupStr = null;
        String username = null;
        easyContactSessionBean.backupContacts(backupStr, username);
        
       
//         boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//
//        if (isMultipart) {
//            FileItemFactory factory = new DiskFileItemFactory();
//            ServletFileUpload upload = new ServletFileUpload(factory);
//
//            try {
//                List items = upload.parseRequest(request);
//                Iterator iterator = items.iterator();
//                while (iterator.hasNext()) {
//                    FileItem item = (FileItem) iterator.next();
//
//                    if (!item.isFormField()) {
//                        String fileName = item.getName();
//
////                        String root = getServletContext().getRealPath("/");
//                        File path = new File("F:/upload");
//                        if (!path.exists()) {
//                            boolean status = path.mkdirs();
//                        }
//
//                        File uploadedFile = new File(path + "/" + fileName);
//                        System.out.println(uploadedFile.getAbsolutePath());
//                        item.write(uploadedFile);
//                    }
//                }
//            } catch (FileUploadException e) {
//                e.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        return null;
    }
    
    @RequestMapping("/saveUserDetails.htm")
    public String saveUserDetails(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws JSONException {
        String backupStr = null;
        String userDetails = null;
        String userFbDetails = null;
        easyContactSessionBean.getImagesFromAndroid(backupStr, userDetails, userFbDetails);
        return null;
    }
    
    @RequestMapping("/recognizeFaces.htm")
     public String recognizeFaces(String faces) {
        return null;
    }
    private EasyContactSessionBeanLocal lookupEasyContactSessionBeanLocal() {
        try {
            Context c = new InitialContext();
            return (EasyContactSessionBeanLocal) c.lookup("java:global/FYP/FYP-ejb/EasyContactSessionBean!fyp.thej.sessionbean.EasyContactSessionBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
