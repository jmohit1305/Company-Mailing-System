
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jmohi
 */
public class dbQuery extends mainFrame {

    //<editor-fold defaultstate="collapsed" desc="insertQueryInbox">
//    static int i_inbox;
    public static int insertQueryInbox(String toID, String composeMsg, String composeSub) {

        int flag = 0;
        try {

            //Establishing conn
            Connection conn = dbConnection.connect();

            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // sql  statement
            String validateUserQuery = "select * from register";
//            String validateIDQuery = "select * from inbox";
            String insertQuery = "insert into inbox (toID, fromID, compSub, compMsg, startDate, inbox_master_id) values (?, ?, ?, ?, ?, ?)";

            // validate user check sql prepared statement
            PreparedStatement validUserPst = conn.prepareStatement(validateUserQuery);
            ResultSet rsUSER = validUserPst.executeQuery();

            // validate ID check sql prepared statement
//            PreparedStatement validIDPst = conn.prepareStatement(validateIDQuery);
//            ResultSet rsID = validIDPst.executeQuery();
//            while (rsID.next()) {
//                i_inbox = rsID.getInt("INBOX_ID");
//            }
//            System.out.println(i_inbox);
            while (rsUSER.next()) {
                if (toID.equals(rsUSER.getString("username"))) {
                    flag = 1;
                }
            }

            if (flag == 0) {
                conn.close();
                return 2;
            } else if (flag == 1) {
                // create sql prepared statement for inbox table
                PreparedStatement pstInsert = conn.prepareStatement(insertQuery);

                pstInsert.setString(1, toID);
                pstInsert.setString(2, LoginDetails.loggedInUserID);
                pstInsert.setString(3, composeSub);
                pstInsert.setString(4, composeMsg);
                pstInsert.setDate(5, startDate);
                pstInsert.setInt(6, (i_master + 1));
                pstInsert.execute();
                conn.close();
                return 1;
            }
            conn.close();
            return 2;

            // execute the preparedstatement
        } catch (SQLException e) {
            System.out.println("Something went wrong (received from try catch insertquery Inbox) " + e.getMessage());
            return -1;
        }
        //  return 1;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="insertQueryMaster">
    static int i_master;

    public static int insertQueryMaster(String toID, String composeMsg, String composeSub) {

        int flag = 0;
        try {

            //Establishing conn
            Connection conn = dbConnection.connect();

            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // sql  statement
            String validateUserQuery = "select * from register";
            String validateIDQuery = "SELECT * FROM MASTER";
            String insertQuery = "insert into master (toID, fromID, compSub, compMsg, startDate) values (?, ?, ?, ? , ?)";

            // validate user check sql prepared statement
            PreparedStatement validUserPst = conn.prepareStatement(validateUserQuery);
            ResultSet rsUSER = validUserPst.executeQuery();

            // validate ID check sql prepared statement
            PreparedStatement validIDPst = conn.prepareStatement(validateIDQuery);
            ResultSet rsID = validIDPst.executeQuery();

            while (rsUSER.next()) {

                if (toID.equals(rsUSER.getString("username"))) {

                    flag = 1;
                }
            }

            if (flag == 0) {
                conn.close();
                return 2;
            } else if (flag == 1) {
                // create sql prepared statement for inbox table
                PreparedStatement pstInsert = conn.prepareStatement(insertQuery);

                pstInsert.setString(1, toID);
                pstInsert.setString(2, LoginDetails.loggedInUserID);
                pstInsert.setString(3, composeSub);
                pstInsert.setString(4, composeMsg);
                pstInsert.setDate(5, startDate);
                pstInsert.execute();

                while (rsID.next()) {
                    i_master = rsID.getInt("MASTER_ID");
                }
                System.out.println(i_master);

                conn.close();
                return 1;

            }
            conn.close();
            return 2;

            // execute the preparedstatement
        } catch (SQLException e) {
            System.out.println("Something went wrong (received from try catch insertquery Master) " + e.getMessage());
            return -1;
        }
        //  return 1; 
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="inboxDisplay ">
    public static void inboxDisplay(JTable tblInbox) {

        try {
            //Establishing conn
            Connection conn = dbConnection.connect();

            // sql display statement
            String dispQuery = "select * from inbox";

            // prepare statement    
            PreparedStatement pst = conn.prepareStatement(dispQuery);
            ResultSet rs = pst.executeQuery();

            // table view
            DefaultTableModel tm = (DefaultTableModel) tblInbox.getModel();
            tm.setRowCount(0);

            while (rs.next()) {
                if (LoginDetails.loggedInUserID.equals(rs.getString("toID"))) {
                    Object record[] = {
                        rs.getString("INBOX_ID"), rs.getString("fromID"), rs.getString("COMPMSG"), rs.getString("STARTDATE")
                    };
                    tm.addRow(record);
                }
            }
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="sentDisplay">
    public static void sentDisplay(JTable tblSent) {
        try {
            //Establishing conn
            Connection conn = dbConnection.connect();

            // sql display statement
            String dispQuery = "select * from master";

            // prepare statement    
            PreparedStatement pst = conn.prepareStatement(dispQuery);
            ResultSet rs = pst.executeQuery();

            // table view
            DefaultTableModel tm = (DefaultTableModel) tblSent.getModel();
            tm.setRowCount(0);

            while (rs.next()) {
                if (LoginDetails.loggedInUserID.equals(rs.getString("fromID"))) {
                    Object record[] = {
                        rs.getString("TOID"), rs.getString("COMPSUB"), rs.getString("COMPMSG"), rs.getString("STARTDATE")
                    };
                    tm.addRow(record);
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="trashDisplay ">
    public static void trashDisplay(JTable tblTrash) {

        try {
            //Establishing conn
            Connection conn = dbConnection.connect();

            // sql display statement
            String dispQuery = "select * from trash";

            // prepare statement    
            PreparedStatement pst = conn.prepareStatement(dispQuery);
            ResultSet rs = pst.executeQuery();

            // table view
            DefaultTableModel tm = (DefaultTableModel) tblTrash.getModel();
            tm.setRowCount(0);

            while (rs.next()) {
                if (LoginDetails.loggedInUserID.equals(rs.getString("toID"))) {
                    Object record[] = {
                        rs.getString("TRASH_ID"), rs.getString("fromID"), rs.getString("COMPMSG"), rs.getString("STARTDATE")
                    };
                    tm.addRow(record);
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="inboxMailDisplay">
    public static void inboxMailDisplay(String s) {
        try {
            // Establishing conn
            Connection conn = dbConnection.connect();

            // sql display statement
            String dispQuery = "select * from inbox";

            // prepare statement    
            PreparedStatement pst = conn.prepareStatement(dispQuery);
            ResultSet rs = pst.executeQuery();

            // set text to respective fields
            while (rs.next()) {
                if (s.equals(rs.getString("INBOX_ID"))) {
                    mainFrame.toMailRec.setText(rs.getString("fromID"));
                    mainFrame.toMailSub.setText(rs.getString("compSub"));
                    mainFrame.MailMsgDisp.setText(rs.getString("COMPMSG"));
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="downloadAttachments">
    public static void downloadAttachments() {
        try {
            // Establishing conn
            Connection conn = dbConnection.connect();

            // sql display statement
            String dispQuery = "select * from inbox";

            // prepare statement    
            PreparedStatement pst = conn.prepareStatement(dispQuery);
            ResultSet rs = pst.executeQuery();

            // set text to respective fields
            while (rs.next()) {
                if (s_inbox.equals(rs.getString("ID"))) {
                    Blob blob = rs.getBlob("attachments");
                    InputStream IS = blob.getBinaryStream();

                    Files.copy(IS, Paths.get("C:\\Users\\jmohi\\Downloads\\" + "abc"));

                    // System.out.println("Selected file: " + .substring(.lastIndexOf(".")+1));
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="attachDocInsert">
    static int i_attach;

    /**
     * @throws NullPointerException
     */
    public static void attachDocInsert() {

        try {

            //Establishing conn
            Connection conn = dbConnection.connect();

            // sql  statement
//            String validQuery = "select * from attachments";
            String insertAttachmentQuery = "insert into attachments(DOC_NAME, DOC_SIZE, DOC_FILE,attach_master_Id ) values (?, ?, ?, ?)";

            // create prepared statement for validity check
//            PreparedStatement validPst = conn.prepareStatement(validQuery);
//            ResultSet rs = validPst.executeQuery();
//        String fileext = filename.substring(filename.lastIndexOf(".") + 1);     
            String filename = (selectedFile.getName());
            long filesize = (selectedFile.length()) / 1024;

            // create sql prepared statement for Attachment
            PreparedStatement pst = conn.prepareStatement(insertAttachmentQuery);

            pst.setString(1, filename);
            pst.setLong(2, filesize);
            pst.setBinaryStream(3, inputAttach);
            pst.setInt(4, (i_master + 1));
            pst.execute();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong (received from attachDocInsert) " + e.getMessage());

        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="deleteInboxMail">
    public static void deleteInboxMail(String delete) {

        try {
            // Establishing conn
            Connection conn = dbConnection.connect();

            // sql display statement
            String deleteQuery = "delete from inbox where inbox_id = ? ";

            // prepare statement    
            PreparedStatement pst = conn.prepareStatement(deleteQuery);

            // execution of prepared statement for deletion
            pst.setInt(1, Integer.parseInt(delete));
            pst.execute();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="composeClean">
    public static void composeClean() {

        toComposeRec.setText("");
        toComposeSub.setText("");
        toComposeMSG.setText("");
        toComposeRec.grabFocus();

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="insertQueryAdmin">
    static int i_admin;

    public static void insertQueryAdmin(long ID, String Name, long ph_no, Date dob, String address, String emp_type, String password) {

        int flag = 0;
        try {

            //Establishing conn
            Connection conn = dbConnection.connect();

            // sql  statement
            String validateUserQuery = "select * from REGISTERADMIN";
            String validateIDQuery = "select * from REGISTERADMIN";
            String insertQuery = "insert into REGISTERADMIN (id, name, phone_number, dob, address, emp_type, password) values (?, ?, ?, ?, ? , ?, ?)";

            // validate user check sql prepared statement
            PreparedStatement validUserPst = conn.prepareStatement(validateUserQuery);
            ResultSet rsUSER = validUserPst.executeQuery();
            PreparedStatement validIDPst = conn.prepareStatement(validateIDQuery);
            ResultSet rsID = validIDPst.executeQuery();

            while (rsUSER.next()) {
                i_admin = rsUSER.getInt("ID");
            }
            System.out.println(i_admin);
            // execute the preparedstatement
            while (rsID.next()) {
                if (ID == rsID.getLong("ID")) {
                    flag = 1;
                }
            }

            if (flag == 0) {
                PreparedStatement pstInsert = conn.prepareStatement(insertQuery);
                pstInsert.setLong(1, ID);
                pstInsert.setString(2, Name);
                pstInsert.setLong(3, ph_no);
                pstInsert.setDate(4, new java.sql.Date(dob.getTime()));
                pstInsert.setString(5, address);
                pstInsert.setString(6, emp_type);
                pstInsert.setString(7, password);
                pstInsert.execute();

                JOptionPane.showMessageDialog(null, ID + " Registered");
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong (received from try catch insertquery Master) " + e.getMessage());

        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="insertQueryTrash">
    static int i_trash = 0;

    public static void insertQueryTrash(String mail) {

        int flag = 0;
        try {
            // Establishing conn
            Connection conn = dbConnection.connect();

            // sql display statement
            String trashInsertQuery = "insert into Trash(toID, fromID, compSub, compMsg, startDate) values(?, ? ,?, ?, ?, ?)";
            String trashIDQuery = "select * from trash";
            String deleteQuery = "select * from inbox where inbox_id=? ";

            // prepare statement    
            PreparedStatement trashInsertPst = conn.prepareStatement(trashInsertQuery);
            PreparedStatement deletePst = conn.prepareStatement(deleteQuery);
            PreparedStatement trashIDPst = conn.prepareStatement(trashIDQuery);
            deletePst.setInt(1, Integer.parseInt(mail));
            ResultSet deleteRS = deletePst.executeQuery();
            ResultSet trashIDRS = trashIDPst.executeQuery();

            String ID = null;
            String toID = null;
            String fromID = null;
            String compSub = null;
            String compMsg = null;
            String startDate = null;

            while (deleteRS.next()) {
                if (Integer.parseInt(mail) == deleteRS.getInt("inbox_id")) {
                    ID = deleteRS.getString("Inbox_ID");
                    toID = deleteRS.getString("toid");
                    fromID = deleteRS.getString("fromID");
                    compSub = deleteRS.getString("COMPSUB");
                    compMsg = deleteRS.getString("COMPMSG");
                    startDate = deleteRS.getString("STARTDATE");
                    flag = 1;
                }
            }

            while (trashIDRS.next()) {
                i_trash = trashIDRS.getInt("trash_id");
            }

            if (flag == 1) {
                trashInsertPst.setInt(1, i_trash + 1);
                trashInsertPst.setString(2, toID);
                trashInsertPst.setString(3, fromID);
                trashInsertPst.setString(4, compSub);
                trashInsertPst.setString(5, compMsg);
                trashInsertPst.setString(6, startDate);
                trashInsertPst.execute();
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //</editor-fold>

}
