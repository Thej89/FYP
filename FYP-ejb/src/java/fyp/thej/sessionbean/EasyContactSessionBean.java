/*
 * Advance Web Technology ECWI604 - Course Work 2
 */
package fyp.thej.sessionbean;

import fyp.thej.jdbc.EasyContactJdbc;
import fyp.thej.model.ImageInfo;
import fyp.thej.model.ImageInfoPK;
import fyp.thej.model.User;
import fyp.thej.util.MySqlConnector;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Arrays;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 *
 * @author Thejanee Walgamage <2008061>
 */
@Stateless
public class EasyContactSessionBean implements EasyContactSessionBeanLocal {

    @PersistenceContext(unitName = "FYP-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void persist(Object object) {
        em.persist(object);
    }

    // does not use for now
    @Override
    public String saveAllFriends(String friendsString) {
//        ClientConfig config = new DefaultClientConfig();
//        com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(config);


        ArrayList<String> idArray = new ArrayList<String>();
//        System.out.println(System.currentTimeMillis());
        for (StringTokenizer stringTokenizer = new StringTokenizer(friendsString, ","); stringTokenizer.hasMoreTokens();) {
            String friendId = stringTokenizer.nextToken();
//            System.out.print(friendId);
            if (friendId != null && !("").equals(friendId)) {
                downloadImage(friendId);
                idArray.add(friendId);
            }

        }
//         System.out.println(idArray.size());
//        System.out.println(System.currentTimeMillis());
        System.out.print("===================== " + idArray.get(0));
        return idArray.get(0);
    }

    //does not use for now
    public String downloadImage(String friendId) {

        String imgUrlStr = "https://graph.facebook.com/" + friendId + "/picture?type=large";
        URL url = null;
        try {
            url = new URL(imgUrlStr);
        } catch (MalformedURLException ex) {
            Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image image = null;
        try {
            image = ImageIO.read(url);
        } catch (IOException ex) {
            Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedImage cpimg = bufferImage(image);
        File f1 = new File("F:/FYP/FYP-ejb/images/" + friendId + ".png");
        try {
            ImageIO.write(cpimg, "png", f1);
        } catch (IOException ex) {
            Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static BufferedImage bufferImage(Image image) {
        return bufferImage(image, BufferedImage.TYPE_INT_RGB);
    }

    public static BufferedImage bufferImage(Image image, int type) {
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(image, null, null);
        return bufferedImage;
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        EasyContactJdbc jdbcCall = new EasyContactJdbc();
        boolean result = jdbcCall.authenticateUser(username, password);
        return result;
    }

    @Override
    public String signup(User user) {
        em.persist(user);
        return "success";
    }

    @Override
    public String backupContacts(String contactStr, String username) {

        System.out.print(contactStr);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        User user = new User();

        String backupPath = "F:/FYP/FYP-ejb/contact_backup_files/backup_" + username + ".xml";
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Document doc = builder.parse(new InputSource(new StringReader(contactStr)));
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            try {
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(backupPath));
                System.out.println("OK");
                // Output to console for testing
                // StreamResult result = new StreamResult(System.out);
                try {
                    transformer.transform(source, result);
                } catch (TransformerException ex) {
                    Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println("File saved!");
            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SAXException ex) {
            Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        //save backup file path
        user = getUserbyUsername(username);
        user.setContactBackupPath(backupPath);
        saveEditedUsed(user);
        return "success";
    }

    @Override
    public boolean getImagesFromAndroid(String friendDetails, String userDetails, String userFbDetails) {
        System.out.print("Extracting friend details------------------");
        User loggedinuser = new User();
        int userIdFlag = 0;
        Element rootElement = null;
        Document doc = null;
        //save the fb id of the session user 
        loggedinuser = getUserbyUsername(userDetails);
        loggedinuser.setFbId(Integer.parseInt(userFbDetails));
        saveEditedUsed(loggedinuser);

        File fileXmlFaces = new File("F:/FYP/FYP-ejb/images/FC/faces.xml");
        if (!fileXmlFaces.exists()) {
            // Creates an exl to save the details of the images for face recognition purposes
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = null;
            try {
                docBuilder = docFactory.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }

            // root elements
            doc = docBuilder.newDocument();
            rootElement = doc.createElement("faces");
            doc.appendChild(rootElement);
        } else {
            String xmlfilepath = "F:/FYP/FYP-ejb/images/FC/faces.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = null;
            try {
                docBuilder = docFactory.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                doc = docBuilder.parse(xmlfilepath);
                // Get the root element
                rootElement = (Element) doc.getFirstChild();
            } catch (SAXException ex) {
                Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        try {
            JSONArray jsonArray = new JSONArray(friendDetails);
            JSONObject jsonObject = new JSONObject();
            ArrayList<User> userArrayList = new ArrayList<User>();

            for (int i = 0; i < 4; i++) { // change i<3 to i<jsonArray.length() after testing
                if (i == 2) {
                    continue;
                }
                User newFriend = new User();
                User existingFriend = new User();
                ImageInfo imageInfo = new ImageInfo();
                ImageInfoPK imagePk = new ImageInfoPK();
                int imageId = 0;
                boolean fileSave = false;
                boolean fileSave2 = false;

                jsonObject = jsonArray.getJSONObject(i);
                int userFbId = Integer.parseInt(jsonObject.getString("uid"));
                String imageSavePath = "F:/FYP/FYP-ejb/images/" + jsonObject.getString("uid") + "/1.jpg";
                String folderPath = "F:/FYP/FYP-ejb/images/" + jsonObject.getString("uid");
                String imageSavePathFR = "F:/FYP/FYP-ejb/images/FC/" + jsonObject.getString("first_name") + "_" + jsonObject.getString("last_name") + ".jpg";
                String folderPathFR = "F:/FYP/FYP-ejb/images/FC";
                Collection<ImageInfo> imageInfoCollection = new ArrayList<ImageInfo>();

                //Converts the byte array into an image and saves it in a folder
                fileSave = convertStringtoImage(jsonObject.getString("imageString"), imageSavePath, folderPath);

                //Saves the image again in a separate folder for communication between the C#
                fileSave2 = convertStringtoImage(jsonObject.getString("imageString"), imageSavePathFR, folderPathFR);

                newFriend.setUserFirstName(jsonObject.getString("first_name"));
                newFriend.setUserLastName(jsonObject.getString("last_name"));
                newFriend.setUserEmail(jsonObject.getString("email"));
                newFriend.setBirthday(jsonObject.getString("birthday"));
                newFriend.setRole("friend");
                newFriend.setFbId(userFbId);
                newFriend.setFriends(userFbDetails);
                newFriend.setUserId((getLastRecordId("user", "user_id") + 1 + userIdFlag));

                if (fileSave || fileSave2) {
                    imageId = getLastRecordId("image_info", "image_id"); //gets the last record ID of the 'image_info' table
                    imagePk.setImageId((imageId + 1 + i)); // beacuse all the image records are saved after the for loop the id is iterrates manualy
                    imagePk.setUserId(newFriend.getUserId());
                    imageInfo.setImagePath(imageSavePath);
                    imageInfo.setUser(newFriend);
                    imageInfo.setImageInfoPK(imagePk);
                    imageInfoCollection.add(imageInfo);
                    newFriend.setImageInfoCollection(imageInfoCollection);
                }

                existingFriend = isFbUserExists(userFbId); //checks whether the user aleady exists

                if (existingFriend == null) { // if new user save a new record
                    saveUser(newFriend);

                    //Add a record in the xml file
                    // face elements
                    Element face = doc.createElement("face");
                    rootElement.appendChild(face);
                    face.setAttribute("id", "" + userIdFlag);

                    // firstname elements
                    Element firstname = doc.createElement("firstname");
                    firstname.appendChild(doc.createTextNode(newFriend.getUserFirstName()));
                    face.appendChild(firstname);

                    // lastname elements
                    Element lastname = doc.createElement("lastname");
                    lastname.appendChild(doc.createTextNode(newFriend.getUserLastName()));
                    face.appendChild(lastname);

                    // lastname elements
                    Element path = doc.createElement("path");
                    path.appendChild(doc.createTextNode(imageSavePathFR));
                    face.appendChild(path);

                    userIdFlag++;
                } else { //if user already exists update the existing record
                    imagePk.setUserId(existingFriend.getUserId());
                    saveEditedUsed(editUser(existingFriend, newFriend));
                }
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = null;
            try {
                transformer = transformerFactory.newTransformer();
            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("F:/FYP/FYP-ejb/images/FC/faces.xml"));
            try {
                // Output to console for testing
                // StreamResult result = new StreamResult(System.out);

                transformer.transform(source, result);
            } catch (TransformerException ex) {
                Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.print("Extracting friend details------------------END");
            return true;
        } catch (JSONException ex) {
            Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public User saveUser(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public User isUserExist(int userId) {
        User existingUser = new User();
        Query q = em.createQuery("select u from User u where u.userId= '" + userId + "'");
        List<User> resultList = (List<User>) q.getResultList();
        if (!resultList.isEmpty()) {
            existingUser = resultList.get(0);
            return existingUser;
        }
        return null;
    }

    @Override
    public int getLastRecordId(String tableName, String columnName) {
        ArrayList resultList = new ArrayList<HashMap>();
        HashMap<String, String> resultMap = new HashMap<String, String>();

        String queryString = "SELECT max(" + columnName + ") as last_id FROM " + tableName;
        resultList = (ArrayList) MySqlConnector.executeQuery(queryString);
        int lastId = 0;
        Iterator iterator = resultList.iterator();

        while (iterator.hasNext()) {
            resultMap = (HashMap) iterator.next();
            if (resultMap.get("last_id") != null) {
                lastId = Integer.parseInt(resultMap.get("last_id").toString());
            }
        }
        return lastId;
    }

    @Override
    public boolean convertStringtoImage(String imageString, String imageSavePath, String folderPath) {
        boolean flag = false;
        byte[] imageByteArray = Base64.decodeBase64(imageString.getBytes());
        File fileFolder = new File(folderPath);
        if (!fileFolder.exists()) {
            fileFolder.mkdir();
        }
        // Write a image byte array into file system
        FileOutputStream imageOutFile = null;
        try {
            imageOutFile = new FileOutputStream(imageSavePath);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            imageOutFile.write(imageByteArray);
            flag = true;
        } catch (IOException ex) {
            Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            imageOutFile.close();
        } catch (IOException ex) {
            Logger.getLogger(EasyContactSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    @Override
    public User editUser(User editUser, User newUser) {

        Iterator iterator = newUser.getImageInfoCollection().iterator();
        ArrayList imagesList = new ArrayList<ImageInfo>();
        String friendString;

        editUser.setUserFirstName(newUser.getUserFirstName());
        editUser.setUserLastName(newUser.getUserLastName());
        editUser.setBirthday(newUser.getBirthday());
        editUser.setUserEmail(newUser.getUserEmail());
        editUser.setContactBackupPath(newUser.getContactBackupPath());

        friendString = editUser.getFriends();

        if (friendString != null && !("").equals(friendString)) {
            String[] friendArray = friendString.split(",");
            Arrays.sort(friendArray); //sorts the array
            if (Arrays.binarySearch(friendArray, friendString) < 0) {
                friendString = friendString.concat(",").concat(newUser.getFriends());
            }
            editUser.setFriends(friendString);
        } else {
            editUser.setFriends(newUser.getFriends());
        }


        while (iterator.hasNext()) { // for now it only has one element
            ImageInfo newImageInfo = (ImageInfo) iterator.next();
            imagesList.add(newImageInfo);
            if (!doesImgeExists(newImageInfo.getImagePath())) {
                ImageInfo editImageInfo = new ImageInfo();
                ImageInfoPK editImagePk = new ImageInfoPK();
                editImageInfo.setImagePath(newImageInfo.getImagePath());
                editImageInfo.setUser(editUser);
                editImagePk.setImageId(newImageInfo.getImageInfoPK().getImageId());
                editImagePk.setUserId(newImageInfo.getImageInfoPK().getUserId());
                editImageInfo.setImageInfoPK(editImagePk);
                editUser.getImageInfoCollection().add(editImageInfo);
            }
        }

        return editUser;
    }

    @Override
    public boolean doesImgeExists(String imagePath) {
        Query q = em.createQuery("select i from ImageInfo i where i.imagePath= '" + imagePath + "'");
        List<User> resultList = (List<User>) q.getResultList();
        if (!resultList.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public String saveEditedUsed(User editedUser) {
        try {
            em.merge(editedUser);
            return "success";
        } catch (Exception e) {
            System.out.print(e);
            return "cannot be updated because it has changed or been deleted since it was last read";
        }
    }

    @Override
    public User getUserbyUsername(String username) {
        User resultUser = new User();
        Query q = em.createQuery("select u from User u where u.username= '" + username + "'");
        List<User> resultList = (List<User>) q.getResultList();
        if (!resultList.isEmpty()) {
            resultUser = resultList.get(0);
            return resultUser;
        }
        return null;
    }

    @Override
    public User isFbUserExists(int fbId) {
        User existingUser = new User();
        Query q = em.createQuery("select u from User u where u.fbId= '" + fbId + "'");
        List<User> resultList = (List<User>) q.getResultList();
        if (!resultList.isEmpty()) {
            existingUser = resultList.get(0);
            return existingUser;
        }
        return null;
    }

    @Override
    public String recognizeFaces(String faces) {
        boolean result = convertStringtoImage(faces, "F:/FYP/FYP-ejb/images/recognize/t.jpg", "F:/FYP/FYP-ejb/images/recognize");
        if(result == true){
        return "success";
        } else return "error";
    }
}
