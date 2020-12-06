package utilities;

import java.sql.Connection;
import java.util.Hashtable;

/**
 * Created by Pandrill on 06/07/2020
 */
public class ReportingUtil {
    public static void CreateTestCycle(Connection connection)
    {

        //Params
        Hashtable table = new Hashtable();
        table.put("AUT", "WebApp");
        table.put("ExecutedBy", "QA");
        table.put("RequestedBy", "Lead QA");
        table.put("BuildNo", "1.0");
        table.put("ApplicationVersion", "1.0");
        table.put("MachineName", "Windows 10");
        table.put("TestType",1);

        DatabaseUtil.ExecuteStoredProc("sp_CreateTestCycleID",table, connection );

    }
}
