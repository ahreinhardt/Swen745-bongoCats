import freemarker.template.TemplateException;
import spark.*;
import spark.template.freemarker.FreeMarkerEngine;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;

import static spark.Spark.*;


public class ChoosePaper{
    static final String VIEW_NAME = "papers.ftl";
    static  final int USER_ID = 1;
    public static void main(String[] args) {
        renderTemplate();
    }

    private static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/ivtjt/Documents/School/data/SAM2019test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private static List<String> selectPapers(){
        String sql = "SELECT name FROM Papers";
        List<String> papers = new ArrayList<>();
        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                       papers.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return papers;
    }
    public static void submit(int val){
        String sql  = "INSERT INTO Interested(userid, submissionid) VALUES(?,?)";
        try(Connection conn = connect();
            PreparedStatement preState = conn.prepareStatement(sql)) {
            preState.setInt(1,USER_ID);
            preState.setInt(2,val);
            preState.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private static void renderTemplate(){ //throws IOException, TemplateException {
        List<String> papers = selectPapers();

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("papers", papers);

        get("/", (request, response) -> new ModelAndView(attributes, VIEW_NAME), new FreeMarkerEngine());
        post("/", (req, resp) -> {
            String[] result = req.queryParamsValues("paper");
            if (!result.equals(null)) {
                for (String i : result)
                    submit(Integer.parseInt(i));
            }
            return null;

        });
    }
}
