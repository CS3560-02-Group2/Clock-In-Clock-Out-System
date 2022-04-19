using GroupProjCS3560num2.Classes;
using GroupProjCS3560num2.Forms;
using System;
using System.Collections.Generic;
using System.Text;

namespace GroupProjCS3560num2.Database
{
    static class DatabaseHelper
    {
        /*
         * String interpreter methods:
         * ---------------------------
           We need to implement toJSON -> Employee class
           We need to implement toJSON -> Jobs class
           We need to implement toJSON -> Issues class
           We need to implement toJSON -> TimeLog class

           We need to implement fromJSON -> Employee class
           We need to implement fromJSON -> Jobs class
           We need to implement fromJSON -> Issues class
           We need to implement fromJSON -> TimeLog class

            general inquary methods:
            ------------------------
            Delete
            Insert
            Update
            QueryAll
            QueryOne
            
         */
        static string server = "localhost";
        static string userId = "root";
        static string pw1 = "password1";
        static string schema = "employee_schema";

        static int ConnectMySql(string insert_Sql_cmd)
        {
            string con = "server=" + server + "; userid=" + userId + "; password=  " + pw1 + "; database = " + schema;
            int status = 0;
            using (var sqlCon = new MySqlConnector.MySqlConnection(con))
            {
                using (var cmd = new MySqlConnector.MySqlCommand(insert_Sql_cmd, sqlCon))
                {
                    sqlCon.Open();
                    status = cmd.ExecuteNonQuery();
                    sqlCon.Close();
                }
            }
            return status;
        }

        static T ConnectMySql<T>(string insert_Sql_cmd, Func<MySqlConnector.MySqlDataReader, T> setter)
        {
            T toReturn = default(T);
            string con = "server=" + server + "; userid=" + userId + "; password=  " + pw1 + "; database = " + schema;
            using (var sqlCon = new MySqlConnector.MySqlConnection(con))
            {
                using (var cmd = new MySqlConnector.MySqlCommand(insert_Sql_cmd, sqlCon))
                {
                    sqlCon.Open();
                   
                    MySqlConnector.MySqlDataReader myReader = cmd.ExecuteReader();
                    try
                    {
                           toReturn = setter(myReader);
                    }
                    finally
                    {
                        myReader.Close();
                        sqlCon.Close();
                    }
                }
            }
            return toReturn;
        }

        public static Employee VerifyPassword(int employeeID, string password)
        {
            
            Employee tempEmployee = new Employee();

            tempEmployee = SelectEmployee(employeeID);

            if (tempEmployee == null || password != tempEmployee.getPw())
            {
                return null;
                
            }
            return tempEmployee;
        }

        public static TimeLog VerifyTimeLog(int employeeID)
        {
            string cmd = string.Format("select * from TimeLog where logID in (select MAX(logID) from TimeLog group by employeeID) and employeeID = {0};", employeeID);
            return ConnectMySql<TimeLog>(cmd, (myReader) =>
            {
                myReader.Read();
                return myReader.IsDBNull(3) ? new TimeLog(
                                myReader.GetInt32(0),
                                myReader.GetInt32(1),
                                myReader.GetDateTime(2),
                                default(DateTime)) : null;
            });
        }

        public static List<Employee> SelectAllEmployees(string where = "")
        {
            string cmd = string.Format("select * from Employee" + where + ";");
            return ConnectMySql<List<Employee>>(cmd, (myReader) =>
            {
                List<Employee> employees = new List<Employee>();
                while (myReader.Read())
                {
                    employees.Add(new Employee(
                        myReader.GetInt32(0),
                        myReader.GetInt32(1),
                        myReader.GetString(2),
                        myReader.GetString(3),
                        myReader.GetString(4),
                        myReader.GetString(5),
                        myReader.GetString(6),
                        myReader.GetDateTime(7),
                        myReader.GetString(8),
                        myReader.GetString(9),
                        myReader.GetDouble(10)));
                }
                return employees;
            });
        }

        public static Employee SelectEmployee(int employeeID)
        {
            string cmd = string.Format("select * from Employee where employeeID = {0};", employeeID);
            return ConnectMySql<Employee>(cmd, (myReader) =>
            {
                myReader.Read();
                return myReader.HasRows ? new Employee(
                    myReader.GetInt32(0),
                    myReader.GetInt32(1),
                    myReader.GetString(2),
                    myReader.GetString(3),
                    myReader.GetString(4),
                    myReader.GetString(5),
                    myReader.GetString(6),
                    myReader.GetDateTime(7),
                    myReader.GetString(8),
                    myReader.GetString(9),
                    myReader.GetDouble(10)) : null;
            });
        }

        public static int DeleteEmployee(int employeeID)
        {
            string cmd = string.Format("delete from Employee where employeeID = {0};", employeeID);
            return ConnectMySql(cmd);
        }

        public static int UpdateEmployee(Employee employee)
        {
            string dob = employee.getDateOfBirth().ToString("yyyy-MM-dd HH:mm:ss.fff");
            string cmd = string.Format("update Employee set JobId = {1}, password = '{2}, empName = '{3}', physicalAddress = '{4}', " +
                "emailAddress = '{5}', phoneNumber = '{6}', dateOfBirth = '{7}', bankAccNumber = '{8}', sSN = '{9}', adjustment = {10} where employeeID = {0};", employee.getEmployeeID(),
                employee.getJobID(), employee.getPw(), employee.getEmpName(), employee.getPhysicalAddress(), employee.getEmail(), employee.getPhoneNumber(),
                dob, employee.getBankAccNum(), employee.getSSN(), employee.getAdjustment());
            return ConnectMySql(cmd);
        }

        public static int InsertEmployee(Employee employee)
        {
            string dob = employee.getDateOfBirth().ToString("yyyy-MM-dd HH:mm:ss.fff");
            string cmd1 = string.Format("insert Employee(jobID, pw, empName, physicalAddress, emailAddress, phoneNumber, dateOfBirth, bankAccNumber, sSN, adjustment) " +
                "value({0}, '{1}','{2}', '{3}', '{4}', '{5}', '{6}', '{7}', '{8}', {9}) ", employee.getJobID(), employee.getPw(), employee.getEmpName(), employee.getPhysicalAddress(), employee.getEmail(), employee.getPhoneNumber(), dob, employee.getBankAccNum(), employee.getSSN(), employee.getAdjustment());
            return ConnectMySql(cmd1);
        }

        public static List<Job> SelectAllJobs(string where = "")
        {
            string cmd = string.Format("select * from Job" + where + ";");
            return ConnectMySql<List<Job>>(cmd, (myReader) =>
            {
                List<Job> jobs = new List<Job>();
                while (myReader.Read())
                {
                    jobs.Add(new Job(
                        myReader.GetInt32(0),
                        myReader.GetString(1),
                        myReader.GetDouble(2)));
                }
                return jobs;
            });
        }

        public static Job SelectJob(int jobID)
        {
            string cmd = string.Format("select * from Job where jobID = {0};", jobID);
            return ConnectMySql<Job>(cmd, (myReader) =>
            {
                myReader.Read();
                return myReader.HasRows ? new Job(
                    myReader.GetInt32(0),
                    myReader.GetString(1),
                    myReader.GetDouble(2)) : null;
            });
        }

        public static int DeleteJob(int jobID)
        {
            string cmd = string.Format("delete from Job where jobID = {0};", jobID);
            return ConnectMySql(cmd);
        }

        public static int UpdateJob(Job job)
        {
            string cmd = string.Format("update Job set jobTitle = '{1}', basePayrate = {2} where jobID = {0};", job.getJobID(), job.getJobTitle(), job.getBasePayrate());
            return ConnectMySql(cmd);
        }

        public static int InsertJob(Job job)
        {
            string cmd = string.Format("insert into Job(jobTitle, basePayrate) value ('{0}', {1});", job.getJobTitle(), job.getBasePayrate());
            return ConnectMySql (cmd);
        }

        public static List<TimeLog> SelectAllTimeLogs(string where = "")
        {
            string cmd = string.Format("select * from TimeLog" + where + ";");
            return ConnectMySql<List<TimeLog>>(cmd, (myReader) =>
            {
                List<TimeLog> timeLogs = new List<TimeLog>();
                while (myReader.Read())
                {
                    timeLogs.Add(new TimeLog(
                        myReader.GetInt32(0),
                        myReader.GetInt32(1),
                        myReader.GetDateTime(2),
                        myReader.IsDBNull(3) ? default(DateTime) : myReader.GetDateTime(3)));
                }
                return timeLogs;
            });
        }

        public static TimeLog SelectTimeLog(int logID)
        {
            string cmd = string.Format("select * from TimeLog where logId = {0};", logID);
            return ConnectMySql<TimeLog>(cmd, (myReader) =>
            {
                myReader.Read();
                return myReader.HasRows ? new TimeLog(
                    myReader.GetInt32(0),
                    myReader.GetInt32(1),
                    myReader.GetDateTime(2),
                    myReader.IsDBNull(3) ? myReader.GetDateTime(3) : default(DateTime)) : null;
            });
        }

        public static int DeleteTimeLog(int logID)
        {
            string cmd = string.Format("delete from TimeLog where logID = {0};", logID);
            return ConnectMySql(cmd);
        }

        public static int UpdateTimeLog(TimeLog log)
        {
            string checkIn = log.getCheckIn().ToString("yyyy-MM-dd HH:mm:ss.fff");
            string checkOut = log.getCheckOut().ToString("yyyy-MM-dd HH:mm:ss.fff");
            string cmd = string.Format("update TimeLog set employeeID = {1}, checkIn = '{2}', checkOut = '{3}' where logID = {0};", log.getLogID(), log.getEmployeeID(), checkIn, checkOut);
            return ConnectMySql(cmd);
        }

        public static int InsertTimeLog(TimeLog log)
        {
            string checkIn = log.getCheckIn().ToString("yyyy-MM-dd HH:mm:ss.fff");
            string checkOut = log.getCheckOut().ToString("yyyy-MM-dd HH:mm:ss.fff");
            string cmd = string.Format("insert into TimeLog(employeeID, checkIn, checkOut) value ({0}, '{1}', '{2}');", log.getEmployeeID(), checkIn, checkOut);
            return ConnectMySql(cmd);
        }

        public static List<Issue> SelectAllIssues(string where = "")
        {
            string cmd = string.Format("select * from Issue" + where + ";");
            return ConnectMySql<List<Issue>>(cmd, (myReader) =>
            {
                List<Issue> issues = new List<Issue>();
                while (myReader.Read())
                {
                    issues.Add(new Issue(
                        myReader.GetInt32(0),
                        myReader.GetInt32(1),
                        myReader.GetInt32(2),
                        myReader.GetString(3),
                        myReader.GetBoolean(4)));
                }
                return issues;
                
            });
        }

        public static Issue SelectIssue(int issueID)
        {
            string cmd = string.Format("select * from Issue where issueId = {0};", issueID);
            return ConnectMySql<Issue>(cmd, (myReader) =>
            {
                myReader.Read();
                return myReader.HasRows ? new Issue(
                    myReader.GetInt32(0),
                    myReader.GetInt32(1),
                    myReader.GetInt32(2),
                    myReader.GetString(3),
                    myReader.GetBoolean(4)) : null;
            });
        }

        public static int DeleteIssue(int issueID)
        {
            string cmd = string.Format("delete from Issue where issueId = {0};", issueID);
            return ConnectMySql(cmd);
        }

        public static int UpdateIssue(Issue issue)
        {
            string cmd = string.Format("update Issue set employeeID = {1}, adminID = {2}, issueStr = '{3}', solved = {4} where issueID = {0};", issue.getIssueID(), issue.getEmployeeID(), issue.getAdminID(), issue.getIssueStr(), issue.isSolved());
            return ConnectMySql(cmd);
        }

        public static int InsertIssue(Issue issue)   // no one is allow to use apostrophe , it will crash I promise you..... Update, also don't use quotation mark.... Update 2 , double quotation are fine
        {
            string cmd = string.Format("insert into Issue(employeeID, adminID, issueStr, solved) value ({0}, {1}, '{2}', {3});", issue.getEmployeeID(), issue.getAdminID(), issue.getIssueStr(), issue.isSolved());
            return ConnectMySql (cmd);
        }
    }
}
