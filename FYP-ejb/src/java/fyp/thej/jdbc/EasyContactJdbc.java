/*
 * Final Year Project(EasyContact)
 */

package fyp.thej.jdbc;

import fyp.thej.util.MySqlConnector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * EasyContactJdbc
 * Mar 23, 2013 12:30:31 PM
 * Thejanee Walgamage <2008061>
 */
public class EasyContactJdbc {

    public boolean authenticateUser(String username, String password) {
//        HashMap<String, String> resultMap = new HashMap<String, String>();
        String queString = "SELECT * FROM user u WHERE u.username ='"+ username +"' AND u.password ='"+password+"' ";

        ArrayList resultList = new ArrayList<HashMap>();
        ArrayList searchresults = new ArrayList();
        resultList = (ArrayList) MySqlConnector.executeQuery(queString);
        System.out.print(resultList.size());
//        Iterator iterator = resultList.iterator();
//
//        while (iterator.hasNext()) {
//            Department department = new Department();
//            resultMap = (HashMap) iterator.next();
//            department.setDeptName(resultMap.get("dept_name"));
//            department.setDeptNo(resultMap.get("dept_no"));
//
//            searchresults.add(department);
//        }
        if (resultList.size() > 0) {
            return true;
        } else {
            return false;
        }
        
    }
}
